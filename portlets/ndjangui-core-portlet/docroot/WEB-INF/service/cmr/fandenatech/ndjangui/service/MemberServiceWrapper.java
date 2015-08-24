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
 * Provides a wrapper for {@link MemberService}.
 *
 * @author guyw
 * @see MemberService
 * @generated
 */
public class MemberServiceWrapper implements MemberService,
	ServiceWrapper<MemberService> {
	public MemberServiceWrapper(MemberService memberService) {
		_memberService = memberService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _memberService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_memberService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _memberService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member addMember(long companyId,
		long groupId, long userId, java.lang.String name,
		java.lang.String surname, java.lang.String email,
		java.lang.String cardNumber, java.lang.String phoneNumber,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberService.addMember(companyId, groupId, userId, name,
			surname, email, cardNumber, phoneNumber, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member updateMember(long memberId,
		long userId, java.lang.String name, java.lang.String surname,
		java.lang.String email, java.lang.String cardNumber,
		java.lang.String phoneNumber,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberService.updateMember(memberId, userId, name, surname,
			email, cardNumber, phoneNumber, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member deleteMember(long memberId,
		long userId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberService.deleteMember(memberId, userId, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member activateMember(long memberId,
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberService.activateMember(memberId, userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MemberService getWrappedMemberService() {
		return _memberService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMemberService(MemberService memberService) {
		_memberService = memberService;
	}

	@Override
	public MemberService getWrappedService() {
		return _memberService;
	}

	@Override
	public void setWrappedService(MemberService memberService) {
		_memberService = memberService;
	}

	private MemberService _memberService;
}