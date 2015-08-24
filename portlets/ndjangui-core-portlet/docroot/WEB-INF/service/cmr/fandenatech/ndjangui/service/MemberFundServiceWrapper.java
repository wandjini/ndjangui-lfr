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
 * Provides a wrapper for {@link MemberFundService}.
 *
 * @author guyw
 * @see MemberFundService
 * @generated
 */
public class MemberFundServiceWrapper implements MemberFundService,
	ServiceWrapper<MemberFundService> {
	public MemberFundServiceWrapper(MemberFundService memberFundService) {
		_memberFundService = memberFundService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _memberFundService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_memberFundService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _memberFundService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberFund addMemberFund(
		long groupId, long userId, long memberId, long fundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberFundService.addMemberFund(groupId, userId, memberId,
			fundId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberFund updateMemberFund(
		long memberFundId, long userId, long memberId, long fundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberFundService.updateMemberFund(memberFundId, userId,
			memberId, fundId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberFund removeMemberFund(
		long memberFundId, long fundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberFundService.removeMemberFund(memberFundId, fundId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MemberFundService getWrappedMemberFundService() {
		return _memberFundService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMemberFundService(MemberFundService memberFundService) {
		_memberFundService = memberFundService;
	}

	@Override
	public MemberFundService getWrappedService() {
		return _memberFundService;
	}

	@Override
	public void setWrappedService(MemberFundService memberFundService) {
		_memberFundService = memberFundService;
	}

	private MemberFundService _memberFundService;
}