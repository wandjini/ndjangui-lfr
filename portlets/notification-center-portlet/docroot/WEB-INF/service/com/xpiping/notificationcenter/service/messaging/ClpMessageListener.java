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

package com.xpiping.notificationcenter.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.xpiping.notificationcenter.service.ClpSerializer;
import com.xpiping.notificationcenter.service.NotificaLocalServiceUtil;
import com.xpiping.notificationcenter.service.NotificaMessageLocalServiceUtil;
import com.xpiping.notificationcenter.service.NotificaMessageServiceUtil;
import com.xpiping.notificationcenter.service.NotificaServiceUtil;
import com.xpiping.notificationcenter.service.NotificaTypeLocalServiceUtil;
import com.xpiping.notificationcenter.service.NotificaTypeServiceUtil;
import com.xpiping.notificationcenter.service.QueuedEmailLocalServiceUtil;
import com.xpiping.notificationcenter.service.QueuedEmailServiceUtil;

/**
 * @author marcoleo
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			NotificaLocalServiceUtil.clearService();

			NotificaServiceUtil.clearService();
			NotificaMessageLocalServiceUtil.clearService();

			NotificaMessageServiceUtil.clearService();
			NotificaTypeLocalServiceUtil.clearService();

			NotificaTypeServiceUtil.clearService();
			QueuedEmailLocalServiceUtil.clearService();

			QueuedEmailServiceUtil.clearService();
		}
	}
}