/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package cmr.fandenatech.ndjangui.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SanctionTypeService}.
 *
 * @author guyw
 * @see SanctionTypeService
 * @generated
 */
public class SanctionTypeServiceWrapper implements SanctionTypeService,
	ServiceWrapper<SanctionTypeService> {
	public SanctionTypeServiceWrapper(SanctionTypeService sanctionTypeService) {
		_sanctionTypeService = sanctionTypeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _sanctionTypeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sanctionTypeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sanctionTypeService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType addSanctionType(
		long groupId, long userId, java.lang.String name,
		java.lang.String shortDescription, double amount,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeService.addSanctionType(groupId, userId, name,
			shortDescription, amount, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType updateSanctionType(
		long groupId, long userId, long sanctionTypeId, java.lang.String name,
		java.lang.String shortDescription, double amount,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeService.updateSanctionType(groupId, userId,
			sanctionTypeId, name, shortDescription, amount, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType updateSanctionTypeStatus(
		long userId, long sanctionTypeId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeService.updateSanctionTypeStatus(userId,
			sanctionTypeId, status);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType deleSanctionType(
		long sanctionTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeService.deleSanctionType(sanctionTypeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SanctionTypeService getWrappedSanctionTypeService() {
		return _sanctionTypeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSanctionTypeService(
		SanctionTypeService sanctionTypeService) {
		_sanctionTypeService = sanctionTypeService;
	}

	@Override
	public SanctionTypeService getWrappedService() {
		return _sanctionTypeService;
	}

	@Override
	public void setWrappedService(SanctionTypeService sanctionTypeService) {
		_sanctionTypeService = sanctionTypeService;
	}

	private SanctionTypeService _sanctionTypeService;
}