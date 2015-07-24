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

import java.util.HashMap;
import java.util.List;

import javax.naming.NoInitialContextException;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.ndjangui.notificationcenter.service.base.NotificaServiceBaseImpl;
import com.ndjangui.notificationcenter.util.ActionKeys;
import com.ndjangui.notificationcenter.util.WebKeys;
import com.xpiping.notificationcenter.NoSuchNotificaException;
import com.xpiping.notificationcenter.model.Notifica;
import com.xpiping.notificationcenter.model.NotificaType;
import com.xpiping.notificationcenter.permission.NotificaPermission;
import com.xpiping.notificationcenter.permission.NotificationCenterPermission;
import com.xpiping.notificationcenter.service.NotificaTypeLocalServiceUtil;

/**
 * The implementation of the notifica remote service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.xpiping.notificationcenter.service.NotificaService}
 * interface. <p> This is a remote service. Methods of this service are expected
 * to have security checks based on the propagated JAAS credentials because this
 * service can be accessed remotely. </p>
 * 
 * @author marcol
 * @see com.ndjangui.notificationcenter.service.base.NotificaServiceBaseImpl
 * @see com.xpiping.notificationcenter.service.NotificaServiceUtil
 */
public class NotificaServiceImpl extends NotificaServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.xpiping.notificationcenter.service.NotificaServiceUtil} to
	 * access the notifica remote service.
	 */

	public Notifica getNotifica(long notificaId)
		throws PrincipalException, PortalException, SystemException {

		NotificaPermission.check(
			getPermissionChecker(), notificaId, ActionKeys.VIEW);

		Notifica notifica = notificaLocalService.getNotifica(notificaId);

		return notifica;
	}

	public Notifica addNotifica(
		long notificaTypeId, String name, String text, String subject,
		String description, Boolean aviable,Boolean ignoreIntersaction, String orgsIds, String groupsIds,
		String rolesIds, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		NotificationCenterPermission.check(
			getPermissionChecker(), 0, ActionKeys.ADD_NOTIFICA);

		Notifica notifica =
			notificaLocalService.addNotifica(
				notificaTypeId, name, text, subject, description, aviable,ignoreIntersaction,
				orgsIds, groupsIds, rolesIds, serviceContext);

		return notifica;
	}

	public Notifica updateNotifica(
		long notificaId, String text, String subject, String description,
		Boolean aviable,Boolean ignoreIntersaction, String orgsIds, String groupsIds, String rolesIds,
		ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		NotificaPermission.check(
			getPermissionChecker(), notificaId, ActionKeys.UPDATE);
		
		Notifica notifica =
			notificaLocalService.updateNotifica(
				notificaId, text, subject, description, aviable,ignoreIntersaction, orgsIds,
				groupsIds, rolesIds, serviceContext);
		return notifica;
	}
	
	public Notifica deleteNotifica(
		long notificaId)
		throws SystemException, PrincipalException, PortalException {

		NotificaPermission.check(
			getPermissionChecker(), notificaId, ActionKeys.DELETE);
		
		Notifica notifica =
			notificaLocalService.deleteNotifica(notificaId);
		
		return notifica;
	}

	public List<Notifica> getNotifiche(long companyId, int start, int end)
		throws SystemException, PrincipalException, PortalException {

		NotificationCenterPermission.check(
			getPermissionChecker(), 0, ActionKeys.VIEW);

		return notificaLocalService.getNotifiche(companyId, start, end);
	}

	public int countNotifiche(long companyId)
		throws SystemException, PrincipalException, PortalException {

		NotificationCenterPermission.check(
			getPermissionChecker(), 0, ActionKeys.VIEW);

		return notificaLocalService.countNotifiche(companyId);
	}
	
	
	public void sendNotificaInstantanea(long groupId,long notificaId,boolean forceReSend )
					throws PrincipalException, PortalException, SystemException{
		
		NotificationCenterPermission.check(getPermissionChecker(), groupId, ActionKeys.SEND_INSTANT_NOTIFICA);
		
		Notifica notifica = getNotifica(notificaId);
		
		String notificaTypeName = 
						WebKeys.INSTANT_NOTIFICATION;
		
		NotificaType notificaType =
						NotificaTypeLocalServiceUtil.getNotificaType(notifica.getNotificaTypeId());

		
		if (notificaType == null) {
			_log.error("Nessuna notificaType esiste con il nome: " +
				notificaTypeName);
			return;
		}
		
		
		if (!notificaType.getAviable()) {
			_log.info("NotificaType " + notificaTypeName +
				" non � attiva , notificaId: " + notificaId);
			return;
		}
		
		

		if (!notificaType.getName().equals(notificaTypeName)) {
			_log.error("La notifica notificaId: " + notificaId + " non � una notifica instantanea");
			return;
		}
		
		notificaLocalService.sendNotifica(notifica, notificaTypeName, notificaId, null , new HashMap<String, Object>(), forceReSend);
		
	}

	private static Log _log =
					LogFactoryUtil.getLog(NotificaServiceImpl.class);
}
