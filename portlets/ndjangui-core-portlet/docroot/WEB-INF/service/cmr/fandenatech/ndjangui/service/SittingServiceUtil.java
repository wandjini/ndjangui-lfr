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
 * Provides the remote service utility for Sitting. This utility wraps
 * {@link cmr.fandenatech.ndjangui.service.impl.SittingServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author guyw
 * @see SittingService
 * @see cmr.fandenatech.ndjangui.service.base.SittingServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.impl.SittingServiceImpl
 * @generated
 */
public class SittingServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link cmr.fandenatech.ndjangui.service.impl.SittingServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static cmr.fandenatech.ndjangui.model.Sitting addSitting(
		long groupId, long userId, java.lang.String name,
		java.lang.String dayPlan, java.lang.String notes,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSitting(groupId, userId, name, dayPlan, notes,
			serviceContext);
	}

	public static cmr.fandenatech.ndjangui.model.Sitting updateSitting(
		long userId, long sittingId, java.lang.String name,
		java.lang.String dayPlan, java.lang.String notes)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSitting(userId, sittingId, name, dayPlan, notes);
	}

	public static cmr.fandenatech.ndjangui.model.Sitting updateSittingStatus(
		long userId, long sittingId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSittingStatus(userId, sittingId, status);
	}

	public static cmr.fandenatech.ndjangui.model.Sitting openSitting(
		long userId, long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().openSitting(userId, sittingId);
	}

	public static cmr.fandenatech.ndjangui.model.Sitting closeSitting(
		long userId, long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().closeSitting(userId, sittingId);
	}

	public static cmr.fandenatech.ndjangui.model.MemberSitting addMemberSitting(
		long groupId, long userId, long sittingId, long memberId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addMemberSitting(groupId, userId, sittingId, memberId);
	}

	public static cmr.fandenatech.ndjangui.model.Sitting removeSitting(
		long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().removeSitting(sittingId);
	}

	public static cmr.fandenatech.ndjangui.model.MemberSitting removeMemberSitting(
		long sittingId, long memberSittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().removeMemberSitting(sittingId, memberSittingId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SittingService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SittingService.class.getName());

			if (invokableService instanceof SittingService) {
				_service = (SittingService)invokableService;
			}
			else {
				_service = new SittingServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SittingServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SittingService service) {
	}

	private static SittingService _service;
}