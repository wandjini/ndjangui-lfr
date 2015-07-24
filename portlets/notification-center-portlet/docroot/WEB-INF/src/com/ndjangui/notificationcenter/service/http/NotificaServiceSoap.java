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

package com.ndjangui.notificationcenter.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.xpiping.notificationcenter.service.NotificaServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.xpiping.notificationcenter.service.NotificaServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.xpiping.notificationcenter.model.NotificaSoap}.
 * If the method in the service utility returns a
 * {@link com.xpiping.notificationcenter.model.Notifica}, that is translated to a
 * {@link com.xpiping.notificationcenter.model.NotificaSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author marcoleo
 * @see NotificaServiceHttp
 * @see com.xpiping.notificationcenter.model.NotificaSoap
 * @see com.xpiping.notificationcenter.service.NotificaServiceUtil
 * @generated
 */
public class NotificaServiceSoap {
	public static com.xpiping.notificationcenter.model.NotificaSoap getNotifica(
		long notificaId) throws RemoteException {
		try {
			com.xpiping.notificationcenter.model.Notifica returnValue = NotificaServiceUtil.getNotifica(notificaId);

			return com.xpiping.notificationcenter.model.NotificaSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.xpiping.notificationcenter.model.NotificaSoap addNotifica(
		long notificaTypeId, java.lang.String name, java.lang.String text,
		java.lang.String subject, java.lang.String description,
		java.lang.Boolean aviable, java.lang.Boolean ignoreIntersaction,
		java.lang.String orgsIds, java.lang.String groupsIds,
		java.lang.String rolesIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.xpiping.notificationcenter.model.Notifica returnValue = NotificaServiceUtil.addNotifica(notificaTypeId,
					name, text, subject, description, aviable,
					ignoreIntersaction, orgsIds, groupsIds, rolesIds,
					serviceContext);

			return com.xpiping.notificationcenter.model.NotificaSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.xpiping.notificationcenter.model.NotificaSoap updateNotifica(
		long notificaId, java.lang.String text, java.lang.String subject,
		java.lang.String description, java.lang.Boolean aviable,
		java.lang.Boolean ignoreIntersaction, java.lang.String orgsIds,
		java.lang.String groupsIds, java.lang.String rolesIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.xpiping.notificationcenter.model.Notifica returnValue = NotificaServiceUtil.updateNotifica(notificaId,
					text, subject, description, aviable, ignoreIntersaction,
					orgsIds, groupsIds, rolesIds, serviceContext);

			return com.xpiping.notificationcenter.model.NotificaSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.xpiping.notificationcenter.model.NotificaSoap deleteNotifica(
		long notificaId) throws RemoteException {
		try {
			com.xpiping.notificationcenter.model.Notifica returnValue = NotificaServiceUtil.deleteNotifica(notificaId);

			return com.xpiping.notificationcenter.model.NotificaSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.xpiping.notificationcenter.model.NotificaSoap[] getNotifiche(
		long companyId, int start, int end) throws RemoteException {
		try {
			java.util.List<com.xpiping.notificationcenter.model.Notifica> returnValue =
				NotificaServiceUtil.getNotifiche(companyId, start, end);

			return com.xpiping.notificationcenter.model.NotificaSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countNotifiche(long companyId) throws RemoteException {
		try {
			int returnValue = NotificaServiceUtil.countNotifiche(companyId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void sendNotificaInstantanea(long groupId, long notificaId,
		boolean forceReSend) throws RemoteException {
		try {
			NotificaServiceUtil.sendNotificaInstantanea(groupId, notificaId,
				forceReSend);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(NotificaServiceSoap.class);
}