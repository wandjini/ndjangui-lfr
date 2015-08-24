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
 * Provides a wrapper for {@link BudgetPeriodService}.
 *
 * @author guyw
 * @see BudgetPeriodService
 * @generated
 */
public class BudgetPeriodServiceWrapper implements BudgetPeriodService,
	ServiceWrapper<BudgetPeriodService> {
	public BudgetPeriodServiceWrapper(BudgetPeriodService budgetPeriodService) {
		_budgetPeriodService = budgetPeriodService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _budgetPeriodService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_budgetPeriodService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _budgetPeriodService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.BudgetPeriod addBudgetPeriod(
		long groupId, long userId, java.lang.String name,
		java.lang.String shortDescription, java.util.Date startDate,
		java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _budgetPeriodService.addBudgetPeriod(groupId, userId, name,
			shortDescription, startDate, endDate, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.BudgetPeriod updateBudgetPeriod(
		long userId, long budgetPeriodId, java.lang.String name,
		java.lang.String shortDescription, java.util.Date startDate,
		java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _budgetPeriodService.updateBudgetPeriod(userId, budgetPeriodId,
			name, shortDescription, startDate, endDate);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.BudgetPeriod updateBudgetPeriodStatus(
		long userId, long budgetPeriodId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _budgetPeriodService.updateBudgetPeriodStatus(userId,
			budgetPeriodId, status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BudgetPeriodService getWrappedBudgetPeriodService() {
		return _budgetPeriodService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBudgetPeriodService(
		BudgetPeriodService budgetPeriodService) {
		_budgetPeriodService = budgetPeriodService;
	}

	@Override
	public BudgetPeriodService getWrappedService() {
		return _budgetPeriodService;
	}

	@Override
	public void setWrappedService(BudgetPeriodService budgetPeriodService) {
		_budgetPeriodService = budgetPeriodService;
	}

	private BudgetPeriodService _budgetPeriodService;
}