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
 * Provides a wrapper for {@link SittingService}.
 *
 * @author guyw
 * @see SittingService
 * @generated
 */
public class SittingServiceWrapper implements SittingService,
	ServiceWrapper<SittingService> {
	public SittingServiceWrapper(SittingService sittingService) {
		_sittingService = sittingService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _sittingService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sittingService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sittingService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting addSitting(long groupId,
		long userId, java.lang.String name, java.lang.String dayPlan,
		java.lang.String notes,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingService.addSitting(groupId, userId, name, dayPlan,
			notes, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting updateSitting(long userId,
		long sittingId, java.lang.String name, java.lang.String dayPlan,
		java.lang.String notes)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingService.updateSitting(userId, sittingId, name, dayPlan,
			notes);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting updateSittingStatus(
		long userId, long sittingId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingService.updateSittingStatus(userId, sittingId, status);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting openSitting(long userId,
		long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingService.openSitting(userId, sittingId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting closeSitting(long userId,
		long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingService.closeSitting(userId, sittingId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting addMemberSitting(
		long groupId, long userId, long sittingId, long memberId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingService.addMemberSitting(groupId, userId, sittingId,
			memberId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting removeSitting(long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingService.removeSitting(sittingId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting removeMemberSitting(
		long sittingId, long memberSittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingService.removeMemberSitting(sittingId, memberSittingId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SittingService getWrappedSittingService() {
		return _sittingService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSittingService(SittingService sittingService) {
		_sittingService = sittingService;
	}

	@Override
	public SittingService getWrappedService() {
		return _sittingService;
	}

	@Override
	public void setWrappedService(SittingService sittingService) {
		_sittingService = sittingService;
	}

	private SittingService _sittingService;
}