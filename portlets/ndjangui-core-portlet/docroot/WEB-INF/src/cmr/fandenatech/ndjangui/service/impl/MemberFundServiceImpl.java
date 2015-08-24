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

package cmr.fandenatech.ndjangui.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import cmr.fandenatech.ndjangui.model.MemberFund;
import cmr.fandenatech.ndjangui.permission.FundPermission;
import cmr.fandenatech.ndjangui.service.MemberFundLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.base.MemberFundServiceBaseImpl;
import cmr.fandenatech.ndjangui.service.util.ActionKeys;

/**
 * The implementation of the member fund remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.MemberFundService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.MemberFundServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.MemberFundServiceUtil
 */
public class MemberFundServiceImpl extends MemberFundServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.MemberFundServiceUtil} to access the member fund remote service.
	 */
	
	public MemberFund addMemberFund(long groupId, long userId, 
			long memberId, long fundId) throws SystemException, PortalException{
		
		FundPermission.check(getPermissionChecker(), fundId, ActionKeys.ASSIGN_MEMBER);
		return MemberFundLocalServiceUtil.addMemberFund(groupId, userId, memberId, fundId);
	}
	public MemberFund updateMemberFund(long memberFundId, long userId, 
			long memberId, long fundId) throws SystemException, PortalException{
		FundPermission.check(getPermissionChecker(), fundId, ActionKeys.ASSIGN_MEMBER);
		return MemberFundLocalServiceUtil.updateMemberFund(memberFundId, userId, memberId, fundId);
	}
	public MemberFund removeMemberFund(long memberFundId, long fundId) 
			throws SystemException, PortalException{
		FundPermission.check(getPermissionChecker(), fundId, ActionKeys.ASSIGN_MEMBER);
		return MemberFundLocalServiceUtil.removeMemberFund(memberFundId);
	}
}