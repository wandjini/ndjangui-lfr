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
 * Provides a wrapper for {@link FundService}.
 *
 * @author guyw
 * @see FundService
 * @generated
 */
public class FundServiceWrapper implements FundService,
	ServiceWrapper<FundService> {
	public FundServiceWrapper(FundService fundService) {
		_fundService = fundService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _fundService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_fundService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _fundService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Fund addFund(long groupId,
		long userId, java.lang.String name, long budgetPeriodId,
		long fundTypeId, java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundService.addFund(groupId, userId, name, budgetPeriodId,
			fundTypeId, shortDescription, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Fund updateFund(long groupId,
		long userId, long fundId, java.lang.String name, long budgetPeriodId,
		long fundTypeId, java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundService.updateFund(groupId, userId, fundId, name,
			budgetPeriodId, fundTypeId, shortDescription, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Fund closeFund(long userId,
		long fundId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundService.closeFund(userId, fundId, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Fund openFund(long userId,
		long fundId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundService.openFund(userId, fundId, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Fund deleteFund(long userId,
		long fundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundService.deleteFund(userId, fundId);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.MemberFund> getMembersFund(
		long groupId, long fundId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundService.getMembersFund(groupId, fundId, start, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FundService getWrappedFundService() {
		return _fundService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFundService(FundService fundService) {
		_fundService = fundService;
	}

	@Override
	public FundService getWrappedService() {
		return _fundService;
	}

	@Override
	public void setWrappedService(FundService fundService) {
		_fundService = fundService;
	}

	private FundService _fundService;
}