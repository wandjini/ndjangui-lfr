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

import java.util.Date;
import java.util.List;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.ndjangui.notificationcenter.service.base.NotificaMessageLocalServiceBaseImpl;
import com.xpiping.notificationcenter.model.Notifica;
import com.xpiping.notificationcenter.model.NotificaMessage;
import com.xpiping.notificationcenter.model.QueuedEmail;
import com.xpiping.notificationcenter.service.QueuedEmailLocalServiceUtil;

/**
 * The implementation of the notifica message local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.xpiping.notificationcenter.service.NotificaMessageLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author marcol
 * @see com.ndjangui.notificationcenter.service.base.NotificaMessageLocalServiceBaseImpl
 * @see com.xpiping.notificationcenter.service.NotificaMessageLocalServiceUtil
 */
public class NotificaMessageLocalServiceImpl
	extends NotificaMessageLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.xpiping.notificationcenter.service.
	 * NotificaMessageLocalServiceUtil} to access the notifica message local
	 * service.
	 */
	/*
	 * <column name="notificaId" type="long" /> <column name="userId"
	 * type="long" /> <column name="entityId" type="long" /> <column
	 * name="entityName" type="String" />
	 */

	public NotificaMessage addNotificaMessage(
		long companyId, long notificaId, User user, long entityId,
		String entityName, String bcc, String body, String subject) 
						throws SystemException, NoSuchUserException {
		
		Date now = new Date();
		
		long notificaMessageId =
			counterLocalService.increment(NotificaMessage.class.getName());

		NotificaMessage notificaMessage = notificaMessagePersistence.create(notificaMessageId);
		
		notificaMessage.setCompanyId(companyId);
		notificaMessage.setCreateDate(now);
		notificaMessage.setModifiedDate(now);
		
		notificaMessage.setUserId(user.getUserId());
		notificaMessage.setNotificaId(notificaId);
		notificaMessage.setEntityId(entityId);
		notificaMessage.setEntityName(entityName);
		
		notificaMessage = notificaMessagePersistence.update(notificaMessage,false);
		 
		QueuedEmail queuedEmail = QueuedEmailLocalServiceUtil.addQueuedEmail(user, bcc, body, subject);
		
		notificaMessage.setQueuedEmailId(queuedEmail.getQueuedEmailId());
		
		notificaMessage = notificaMessagePersistence.update(notificaMessage,false);
		
		
		return  notificaMessage;
	}

	public List<NotificaMessage> getNotificaMessages(long notificaId)
		throws SystemException {

		return notificaMessagePersistence.findByNotificaId(notificaId);
	}

	public List<NotificaMessage> getNotificaMessages_N_E_E(
		long notificaId, String entityName, long entityId)
		throws SystemException {

		return notificaMessagePersistence.findByN_E_E(
			notificaId, entityName, entityId);
	}

}