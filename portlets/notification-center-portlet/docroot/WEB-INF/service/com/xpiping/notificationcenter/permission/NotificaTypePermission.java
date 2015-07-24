package com.xpiping.notificationcenter.permission;


import com.xpiping.notificationcenter.model.Notifica;
import com.xpiping.notificationcenter.model.NotificaType;
import com.xpiping.notificationcenter.service.NotificaLocalServiceUtil;
import com.xpiping.notificationcenter.service.NotificaTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class NotificaTypePermission {

	public static void check(
			PermissionChecker permissionChecker, NotificaType notificaType, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, notificaType, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long notificaTypeId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, notificaTypeId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, NotificaType notificaType, String actionId) {

		if (permissionChecker.hasOwnerPermission(
			notificaType.getCompanyId(), Notifica.class.getName(), notificaType.getNotificaTypeId(),
			permissionChecker.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			0 , NotificaType.class.getName(), notificaType.getNotificaTypeId(),
			actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long notificaTypeId, String actionId)
		throws PortalException, SystemException {

		NotificaType notificaType = NotificaTypeLocalServiceUtil.getNotificaType(notificaTypeId);

		return contains(permissionChecker, notificaType, actionId);
	}
}
