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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for BudgetPeriod. This utility wraps
 * {@link cmr.fandenatech.ndjangui.service.impl.BudgetPeriodServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author guyw
 * @see BudgetPeriodService
 * @see cmr.fandenatech.ndjangui.service.base.BudgetPeriodServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.impl.BudgetPeriodServiceImpl
 * @generated
 */
public class BudgetPeriodServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link cmr.fandenatech.ndjangui.service.impl.BudgetPeriodServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static cmr.fandenatech.ndjangui.model.BudgetPeriod addBudgetPeriod(
		long groupId, long userId, java.lang.String name,
		java.lang.String shortDescription, java.util.Date startDate,
		java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addBudgetPeriod(groupId, userId, name, shortDescription,
			startDate, endDate, serviceContext);
	}

	public static cmr.fandenatech.ndjangui.model.BudgetPeriod updateBudgetPeriod(
		long userId, long budgetPeriodId, java.lang.String name,
		java.lang.String shortDescription, java.util.Date startDate,
		java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBudgetPeriod(userId, budgetPeriodId, name,
			shortDescription, startDate, endDate);
	}

	public static cmr.fandenatech.ndjangui.model.BudgetPeriod updateBudgetPeriodStatus(
		long userId, long budgetPeriodId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBudgetPeriodStatus(userId, budgetPeriodId, status);
	}

	public static void clearService() {
		_service = null;
	}

	public static BudgetPeriodService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BudgetPeriodService.class.getName());

			if (invokableService instanceof BudgetPeriodService) {
				_service = (BudgetPeriodService)invokableService;
			}
			else {
				_service = new BudgetPeriodServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(BudgetPeriodServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BudgetPeriodService service) {
	}

	private static BudgetPeriodService _service;
}