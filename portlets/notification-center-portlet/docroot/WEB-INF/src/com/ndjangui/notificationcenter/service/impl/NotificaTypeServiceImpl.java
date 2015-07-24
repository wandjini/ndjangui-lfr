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

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.ndjangui.notificationcenter.service.base.NotificaTypeServiceBaseImpl;
import com.ndjangui.notificationcenter.util.ActionKeys;
import com.xpiping.notificationcenter.model.NotificaType;
import com.xpiping.notificationcenter.permission.NotificaTypePermission;
import com.xpiping.notificationcenter.permission.NotificationCenterPermission;

/**
 * The implementation of the notifica type remote service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.xpiping.notificationcenter.service.NotificaTypeService}
 * interface. <p> This is a remote service. Methods of this service are expected
 * to have security checks based on the propagated JAAS credentials because this
 * service can be accessed remotely. </p>
 * 
 * @author marcol
 * @see com.ndjangui.notificationcenter.service.base.NotificaTypeServiceBaseImpl
 * @see com.xpiping.notificationcenter.service.NotificaTypeServiceUtil
 */
public class NotificaTypeServiceImpl extends NotificaTypeServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.xpiping.notificationcenter.service.NotificaTypeServiceUtil}
	 * to access the notifica type remote service.
	 */

	public NotificaType addNotificaType(
		String name, String description, String messageDestination,
		Boolean aviable, String placeHolders, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		NotificationCenterPermission.check(
			getPermissionChecker(), 0, ActionKeys.ADD_NOTIFICA_TYPE);

		return notificaTypeLocalService.addNotificaType(
			name, description, messageDestination, aviable, placeHolders,
			serviceContext);

	}

	public NotificaType updateNotificaType(
		long notificaTypeId, String description, String messageDestination,
		Boolean aviable, String placeHolders, ServiceContext serviceContext)
		throws PrincipalException, PortalException, SystemException {

		NotificaTypePermission.check(
			getPermissionChecker(), notificaTypeId, ActionKeys.UPDATE);

		return notificaTypeLocalService.updateNotificaType(
			notificaTypeId, description, messageDestination, aviable,
			placeHolders, serviceContext);

	}

	public NotificaType getNotificaType(long notificaTypeId)
		throws PrincipalException, PortalException, SystemException {

		NotificaTypePermission.check(
			getPermissionChecker(), notificaTypeId, ActionKeys.VIEW);

		return notificaTypeLocalService.getNotificaType(notificaTypeId);
	}

	public List<NotificaType> getNotificheType(
		long companyId, int start, int end)
		throws SystemException, PrincipalException, PortalException {

		NotificationCenterPermission.check(
			getPermissionChecker(), 0, ActionKeys.VIEW);

		return notificaTypeLocalService.getNotificheType(companyId, start, end);
	}

	public int countNotificheType(long companyId)
		throws SystemException, PrincipalException, PortalException {

		NotificationCenterPermission.check(
			getPermissionChecker(), 0, ActionKeys.VIEW);

		return notificaTypeLocalService.countNotificheType(companyId);
	}

}