
package com.ndjangui.notificationcenter.messaging.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;







import com.xpiping.notificationcenter.NotificationPayLoad;
import com.xpiping.notificationcenter.model.QueuedEmail;
import com.xpiping.notificationcenter.service.NotificaLocalServiceUtil;
import com.xpiping.notificationcenter.service.QueuedEmailLocalServiceUtil;

import javax.mail.internet.InternetAddress;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.LockLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.OrganizationServiceUtil;
import com.liferay.portal.service.UserServiceUtil;

public class NotificaListner implements MessageListener {

	private static Log _log = LogFactoryUtil.getLog(NotificaListner.class);

	public void receive(Message message)
		throws MessageListenerException {

		try {

			doReceive(message);

		}
		catch (Exception e) {
			_log.error("Unable to process message " + message, e);
		}

	}

	protected synchronized void doReceive(Message message)
		throws Exception {

		try {

			NotificationPayLoad brotherNotificationPayLoad =
				new NotificationPayLoad((String) message.getPayload());

			NotificaLocalServiceUtil.sendNotificaType(
				brotherNotificationPayLoad.getNotificationName(),
				brotherNotificationPayLoad.getEntityType(),
				brotherNotificationPayLoad.getEntityId(),
				brotherNotificationPayLoad.getUsersIds(),
				brotherNotificationPayLoad.getMessageTokens(),
				brotherNotificationPayLoad.isForceReSend());
				

		}
		catch (Exception e) {
			_log.error(e);
		}
	}

}
