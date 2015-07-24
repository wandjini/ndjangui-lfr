package com.xpiping.notificationcenter.permission;


import com.xpiping.notificationcenter.model.Notifica;
import com.xpiping.notificationcenter.service.NotificaLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class NotificaPermission {

	public static void check(
			PermissionChecker permissionChecker, Notifica notifica, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, notifica, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long notificaId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, notificaId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, Notifica notifica, String actionId) {

		if (permissionChecker.hasOwnerPermission(
			notifica.getCompanyId(), Notifica.class.getName(), notifica.getNotificaId(),
			notifica.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			0 , Notifica.class.getName(), notifica.getNotificaId(),
			actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long notificaId, String actionId)
		throws PortalException, SystemException {

		Notifica notifica = NotificaLocalServiceUtil.getNotifica(notificaId);

		return contains(permissionChecker, notifica, actionId);
	}
}
