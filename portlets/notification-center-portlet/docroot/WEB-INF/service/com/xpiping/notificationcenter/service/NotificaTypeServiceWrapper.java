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

package com.xpiping.notificationcenter.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NotificaTypeService}.
 *
 * @author marcoleo
 * @see NotificaTypeService
 * @generated
 */
public class NotificaTypeServiceWrapper implements NotificaTypeService,
	ServiceWrapper<NotificaTypeService> {
	public NotificaTypeServiceWrapper(NotificaTypeService notificaTypeService) {
		_notificaTypeService = notificaTypeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _notificaTypeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_notificaTypeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _notificaTypeService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.xpiping.notificationcenter.model.NotificaType addNotificaType(
		java.lang.String name, java.lang.String description,
		java.lang.String messageDestination, java.lang.Boolean aviable,
		java.lang.String placeHolders,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _notificaTypeService.addNotificaType(name, description,
			messageDestination, aviable, placeHolders, serviceContext);
	}

	@Override
	public com.xpiping.notificationcenter.model.NotificaType updateNotificaType(
		long notificaTypeId, java.lang.String description,
		java.lang.String messageDestination, java.lang.Boolean aviable,
		java.lang.String placeHolders,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _notificaTypeService.updateNotificaType(notificaTypeId,
			description, messageDestination, aviable, placeHolders,
			serviceContext);
	}

	@Override
	public com.xpiping.notificationcenter.model.NotificaType getNotificaType(
		long notificaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _notificaTypeService.getNotificaType(notificaTypeId);
	}

	@Override
	public java.util.List<com.xpiping.notificationcenter.model.NotificaType> getNotificheType(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _notificaTypeService.getNotificheType(companyId, start, end);
	}

	@Override
	public int countNotificheType(long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _notificaTypeService.countNotificheType(companyId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public NotificaTypeService getWrappedNotificaTypeService() {
		return _notificaTypeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedNotificaTypeService(
		NotificaTypeService notificaTypeService) {
		_notificaTypeService = notificaTypeService;
	}

	@Override
	public NotificaTypeService getWrappedService() {
		return _notificaTypeService;
	}

	@Override
	public void setWrappedService(NotificaTypeService notificaTypeService) {
		_notificaTypeService = notificaTypeService;
	}

	private NotificaTypeService _notificaTypeService;
}