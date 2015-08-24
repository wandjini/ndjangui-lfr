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
 * Provides the remote service utility for SanctionType. This utility wraps
 * {@link cmr.fandenatech.ndjangui.service.impl.SanctionTypeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author guyw
 * @see SanctionTypeService
 * @see cmr.fandenatech.ndjangui.service.base.SanctionTypeServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.impl.SanctionTypeServiceImpl
 * @generated
 */
public class SanctionTypeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link cmr.fandenatech.ndjangui.service.impl.SanctionTypeServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static cmr.fandenatech.ndjangui.model.SanctionType addSanctionType(
		long groupId, long userId, java.lang.String name,
		java.lang.String shortDescription, double amount,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSanctionType(groupId, userId, name, shortDescription,
			amount, serviceContext);
	}

	public static cmr.fandenatech.ndjangui.model.SanctionType updateSanctionType(
		long groupId, long userId, long sanctionTypeId, java.lang.String name,
		java.lang.String shortDescription, double amount,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSanctionType(groupId, userId, sanctionTypeId, name,
			shortDescription, amount, serviceContext);
	}

	public static cmr.fandenatech.ndjangui.model.SanctionType updateSanctionTypeStatus(
		long userId, long sanctionTypeId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSanctionTypeStatus(userId, sanctionTypeId, status);
	}

	public static cmr.fandenatech.ndjangui.model.SanctionType deleSanctionType(
		long sanctionTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleSanctionType(sanctionTypeId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SanctionTypeService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SanctionTypeService.class.getName());

			if (invokableService instanceof SanctionTypeService) {
				_service = (SanctionTypeService)invokableService;
			}
			else {
				_service = new SanctionTypeServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SanctionTypeServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SanctionTypeService service) {
	}

	private static SanctionTypeService _service;
}