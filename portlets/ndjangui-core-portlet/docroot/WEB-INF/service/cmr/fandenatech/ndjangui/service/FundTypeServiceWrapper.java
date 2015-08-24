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
 * Provides a wrapper for {@link FundTypeService}.
 *
 * @author guyw
 * @see FundTypeService
 * @generated
 */
public class FundTypeServiceWrapper implements FundTypeService,
	ServiceWrapper<FundTypeService> {
	public FundTypeServiceWrapper(FundTypeService fundTypeService) {
		_fundTypeService = fundTypeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _fundTypeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_fundTypeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _fundTypeService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.FundType addFundType(long groupId,
		long userId, java.lang.String name, java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeService.addFundType(groupId, userId, name,
			shortDescription, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.FundType updateFundType(
		long groupId, long userId, long fundTypeId, java.lang.String name,
		java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeService.updateFundType(groupId, userId, fundTypeId,
			name, shortDescription, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.FundType updateFundTypeStatus(
		long userId, long fundTypeId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeService.updateFundTypeStatus(userId, fundTypeId, status);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.FundType deleFundType(long fundTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeService.deleFundType(fundTypeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FundTypeService getWrappedFundTypeService() {
		return _fundTypeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFundTypeService(FundTypeService fundTypeService) {
		_fundTypeService = fundTypeService;
	}

	@Override
	public FundTypeService getWrappedService() {
		return _fundTypeService;
	}

	@Override
	public void setWrappedService(FundTypeService fundTypeService) {
		_fundTypeService = fundTypeService;
	}

	private FundTypeService _fundTypeService;
}