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
 * Provides the remote service utility for Fund. This utility wraps
 * {@link cmr.fandenatech.ndjangui.service.impl.FundServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author guyw
 * @see FundService
 * @see cmr.fandenatech.ndjangui.service.base.FundServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.impl.FundServiceImpl
 * @generated
 */
public class FundServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link cmr.fandenatech.ndjangui.service.impl.FundServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static cmr.fandenatech.ndjangui.model.Fund addFund(long groupId,
		long userId, java.lang.String name, long budgetPeriodId,
		long fundTypeId, java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addFund(groupId, userId, name, budgetPeriodId, fundTypeId,
			shortDescription, serviceContext);
	}

	public static cmr.fandenatech.ndjangui.model.Fund updateFund(long groupId,
		long userId, long fundId, java.lang.String name, long budgetPeriodId,
		long fundTypeId, java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateFund(groupId, userId, fundId, name, budgetPeriodId,
			fundTypeId, shortDescription, serviceContext);
	}

	public static cmr.fandenatech.ndjangui.model.Fund closeFund(long userId,
		long fundId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().closeFund(userId, fundId, serviceContext);
	}

	public static cmr.fandenatech.ndjangui.model.Fund openFund(long userId,
		long fundId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().openFund(userId, fundId, serviceContext);
	}

	public static cmr.fandenatech.ndjangui.model.Fund deleteFund(long userId,
		long fundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFund(userId, fundId);
	}

	public static java.util.List<cmr.fandenatech.ndjangui.model.MemberFund> getMembersFund(
		long groupId, long fundId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMembersFund(groupId, fundId, start, end);
	}

	public static void clearService() {
		_service = null;
	}

	public static FundService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FundService.class.getName());

			if (invokableService instanceof FundService) {
				_service = (FundService)invokableService;
			}
			else {
				_service = new FundServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(FundServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FundService service) {
	}

	private static FundService _service;
}