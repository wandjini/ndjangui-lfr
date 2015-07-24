package com.ndjangui.notificationcenter.messaging.impl;


import java.io.UnsupportedEncodingException;
import java.util.List;

import com.xpiping.notificationcenter.model.QueuedEmail;
import com.xpiping.notificationcenter.service.QueuedEmailLocalServiceUtil;

import javax.mail.internet.InternetAddress;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.service.LockLocalServiceUtil;



public class QueuedEmailSenderListner implements MessageListener {
	private static Log _log = LogFactoryUtil
					.getLog(QueuedEmailSenderListner.class);

	public static String  LOCK_KEY = "QueuedEmailSender";
	public static String  DEFAULT_OWNER = "QueuedEmailSenderOwner";
	
	
	public void receive(Message message) throws MessageListenerException {
		try {
			
			doReceive(message);

		} catch (Exception e) {
			_log.error("Unable to process message " + message, e);
		}
		
	}

	protected synchronized void doReceive(Message message) throws Exception {
			
		try {
			if (LockLocalServiceUtil.isLocked("QueuedEmailSenderListner", LOCK_KEY)) {
		        return;
		    }
		    
			LockLocalServiceUtil.lock("QueuedEmailSenderListner", LOCK_KEY, DEFAULT_OWNER, false);

			List<QueuedEmail> emails =  QueuedEmailLocalServiceUtil.getQueuedEmailToSend();
			
			for(QueuedEmail email:emails){
				QueuedEmailLocalServiceUtil.sendEmail(email,true);
			}
		    
		} finally {
		    LockLocalServiceUtil.unlock("QueuedEmailSenderListner", LOCK_KEY);
		}
	}
	
	

}
