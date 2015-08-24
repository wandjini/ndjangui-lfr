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

package cmr.ndjangui.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MemberAdminService}.
 *
 * @author guyw
 * @see MemberAdminService
 * @generated
 */
public class MemberAdminServiceWrapper implements MemberAdminService,
	ServiceWrapper<MemberAdminService> {
	public MemberAdminServiceWrapper(MemberAdminService memberAdminService) {
		_memberAdminService = memberAdminService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _memberAdminService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_memberAdminService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _memberAdminService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getGroupMembers(
		long groupId, long userId, int start, int end) {
		return _memberAdminService.getGroupMembers(groupId, userId, start, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MemberAdminService getWrappedMemberAdminService() {
		return _memberAdminService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMemberAdminService(
		MemberAdminService memberAdminService) {
		_memberAdminService = memberAdminService;
	}

	@Override
	public MemberAdminService getWrappedService() {
		return _memberAdminService;
	}

	@Override
	public void setWrappedService(MemberAdminService memberAdminService) {
		_memberAdminService = memberAdminService;
	}

	private MemberAdminService _memberAdminService;
}