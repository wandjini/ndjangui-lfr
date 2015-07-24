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
 * Provides a wrapper for {@link NotificaService}.
 *
 * @author marcoleo
 * @see NotificaService
 * @generated
 */
public class NotificaServiceWrapper implements NotificaService,
	ServiceWrapper<NotificaService> {
	public NotificaServiceWrapper(NotificaService notificaService) {
		_notificaService = notificaService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _notificaService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_notificaService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _notificaService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.xpiping.notificationcenter.model.Notifica getNotifica(
		long notificaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _notificaService.getNotifica(notificaId);
	}

	@Override
	public com.xpiping.notificationcenter.model.Notifica addNotifica(
		long notificaTypeId, java.lang.String name, java.lang.String text,
		java.lang.String subject, java.lang.String description,
		java.lang.Boolean aviable, java.lang.Boolean ignoreIntersaction,
		java.lang.String orgsIds, java.lang.String groupsIds,
		java.lang.String rolesIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _notificaService.addNotifica(notificaTypeId, name, text,
			subject, description, aviable, ignoreIntersaction, orgsIds,
			groupsIds, rolesIds, serviceContext);
	}

	@Override
	public com.xpiping.notificationcenter.model.Notifica updateNotifica(
		long notificaId, java.lang.String text, java.lang.String subject,
		java.lang.String description, java.lang.Boolean aviable,
		java.lang.Boolean ignoreIntersaction, java.lang.String orgsIds,
		java.lang.String groupsIds, java.lang.String rolesIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _notificaService.updateNotifica(notificaId, text, subject,
			description, aviable, ignoreIntersaction, orgsIds, groupsIds,
			rolesIds, serviceContext);
	}

	@Override
	public com.xpiping.notificationcenter.model.Notifica deleteNotifica(
		long notificaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _notificaService.deleteNotifica(notificaId);
	}

	@Override
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> getNotifiche(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _notificaService.getNotifiche(companyId, start, end);
	}

	@Override
	public int countNotifiche(long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _notificaService.countNotifiche(companyId);
	}

	@Override
	public void sendNotificaInstantanea(long groupId, long notificaId,
		boolean forceReSend)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		_notificaService.sendNotificaInstantanea(groupId, notificaId,
			forceReSend);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public NotificaService getWrappedNotificaService() {
		return _notificaService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedNotificaService(NotificaService notificaService) {
		_notificaService = notificaService;
	}

	@Override
	public NotificaService getWrappedService() {
		return _notificaService;
	}

	@Override
	public void setWrappedService(NotificaService notificaService) {
		_notificaService = notificaService;
	}

	private NotificaService _notificaService;
}