/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ndjangui.notificationcenter.service.impl;


import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringUtils;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.mail.MailEngine;
import com.ndjangui.notificationcenter.messaging.impl.QueuedEmailSenderListner;
import com.ndjangui.notificationcenter.service.base.QueuedEmailLocalServiceBaseImpl;
import com.xpiping.notificationcenter.NoSuchQueuedEmailException;
import com.xpiping.notificationcenter.model.QueuedEmail;
import com.xpiping.notificationcenter.service.QueuedEmailLocalService;

/**
 * The implementation of the queued email local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@linkcom.xpiping.notificationcenter.service.QueuedEmailLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author marcol
 * @seecom.xpiping.notificationcenter.service.base.QueuedEmailLocalServiceBaseImpl
 * @seecom.xpiping.notificationcenter.service.QueuedEmailLocalServiceUtil
 */
public class QueuedEmailLocalServiceImpl
	extends QueuedEmailLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 *com.xpiping.notificationcenter.service.QueuedEmailLocalServiceUtil
	 * } to access the queued email local service.
	 */
	private static Log _log =
		LogFactoryUtil.getLog(QueuedEmailLocalServiceImpl.class);

	public List<QueuedEmail> getQueuedEmailToSend()
		throws SystemException {

		return queuedEmailPersistence.findBySentDate(null);
	}

	public QueuedEmail addQueuedEmail(
		User user, String bcc, String body, String subject)
		throws SystemException, NoSuchUserException {

		String fromName = PrefsPropsUtil.getString(user.getCompanyId(),
			PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String from = PrefsPropsUtil.getString(user.getCompanyId(),
			PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
		
		String to = user.getEmailAddress();
		
		
		
		return addQueuedEmail(
			user.getCompanyId(), to, null, from, fromName, bcc, null, body,
			subject);

	}

	public QueuedEmail addQueuedEmail(
		long companyId, String to, String toName, String from, String fromName,
		String bcc, String cc, String body, String subject)
		throws SystemException, NoSuchUserException {

		Date now = new Date();

		long queuedEmailId =
			counterLocalService.increment(QueuedEmail.class.getName());

		QueuedEmail queuedEmail = queuedEmailPersistence.create(queuedEmailId);

		queuedEmail.setCompanyId(companyId);

		queuedEmail.setCreateDate(now);
		queuedEmail.setModifiedDate(now);

		queuedEmail.setTo(to);
		queuedEmail.setToName(toName);
		queuedEmail.setFrom(from);
		queuedEmail.setFromName(fromName);
		queuedEmail.setBcc(bcc);
		queuedEmail.setCc(cc);
		queuedEmail.setBody(body);
		queuedEmail.setSubject(subject);
		queuedEmail.setSentTries(0);

		queuedEmail = queuedEmailPersistence.update(queuedEmail, false);

		return queuedEmail;

	}

	public QueuedEmail setQueuedEmailAsSent(long queuedEmailId)
		throws NoSuchQueuedEmailException, SystemException {

		QueuedEmail queuedEmail =
			queuedEmailPersistence.findByPrimaryKey(queuedEmailId);

		Date now = new Date();

		queuedEmail.setModifiedDate(now);
		queuedEmail.setSentOn(now);
		queuedEmail.setSentTries(queuedEmail.getSentTries() + 1);

		queuedEmail = queuedEmailPersistence.update(queuedEmail, false);

		return queuedEmail;
	}

	public QueuedEmail incrementSentTries(long queuedEmailId)
		throws NoSuchQueuedEmailException, SystemException {

		QueuedEmail queuedEmail =
			queuedEmailPersistence.findByPrimaryKey(queuedEmailId);

		Date now = new Date();

		queuedEmail.setModifiedDate(now);
		queuedEmail.setSentTries(queuedEmail.getSentTries() + 1);

		queuedEmail = queuedEmailPersistence.update(queuedEmail, false);

		return queuedEmail;
	}

	public boolean sendEmail(long queuedEmailId, boolean checkSentTries)
		throws NoSuchQueuedEmailException, SystemException {

		QueuedEmail queuedEmail =
			queuedEmailPersistence.findByPrimaryKey(queuedEmailId);

		return sendEmail(queuedEmail, checkSentTries);
	}

	public boolean sendEmail(QueuedEmail queuedEmail, boolean checkSentTries)
		throws SystemException, NoSuchQueuedEmailException {

		MailMessage mailMessage = null;
		InternetAddress to, from, bcc, cc;

		if (queuedEmail == null)
			return false;

		// TODO spostare 10 in costante letta da file di properties
		if (queuedEmail.getSentTries() >= 10 && checkSentTries)
			return false;

		try {
			to =
				new InternetAddress(
					queuedEmail.getTo(), queuedEmail.getToName());
			from =
				new InternetAddress(
					queuedEmail.getFrom(), queuedEmail.getFromName());

			mailMessage =
				new MailMessage(
					from, to, queuedEmail.getSubject(), queuedEmail.getBody(),
					true);

			if (!StringUtils.isEmpty(queuedEmail.getBcc())) {
				bcc = new InternetAddress(queuedEmail.getBcc());
				mailMessage.setBCC(bcc);
			}
			if (!StringUtils.isEmpty(queuedEmail.getCc())) {
				cc = new InternetAddress(queuedEmail.getCc());
				mailMessage.setCC(cc);
			}

			// MailEngine.send(from, to, subject, body);
			// MailEngine.
			MailServiceUtil.sendEmail(mailMessage);

			setQueuedEmailAsSent(queuedEmail.getQueuedEmailId());
			return true;
		}
		catch (Exception e) {
			_log.error(
				"Errore durante invio QueuedEmail : " +
					queuedEmail.getQueuedEmailId(), e);

			incrementSentTries(queuedEmail.getQueuedEmailId());
			return false;

		}
		finally {
			mailMessage = null;
			queuedEmail = null;
			to = null;
			from = null;
		}

	}

	public List<QueuedEmail> getQueuedEmail(long companyId, int start, int end)
		throws SystemException {

		return queuedEmailPersistence.findByCompanyId(companyId, start, end);
	}

	public int countQueuedEmail(long companyId)
		throws SystemException {

		return queuedEmailPersistence.countByCompanyId(companyId);
	}

}
