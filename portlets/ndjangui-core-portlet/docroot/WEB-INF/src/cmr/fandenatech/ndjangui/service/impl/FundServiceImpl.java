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

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;

import cmr.fandenatech.ndjangui.model.Fund;
import cmr.fandenatech.ndjangui.model.Member;
import cmr.fandenatech.ndjangui.model.MemberFund;
import cmr.fandenatech.ndjangui.permission.FundPermission;
import cmr.fandenatech.ndjangui.service.FundLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.base.FundServiceBaseImpl;

/**
 * The implementation of the fund remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.FundService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.FundServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.FundServiceUtil
 */
public class FundServiceImpl extends FundServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.FundServiceUtil} to access the fund remote service.
	 */
	public Fund addFund(long groupId, long userId, String name, long budgetPeriodId,
			long fundTypeId, String shortDescription, ServiceContext serviceContext)
					throws SystemException, PortalException{
		
		return FundLocalServiceUtil.addFund(groupId, userId, name, budgetPeriodId, fundTypeId, shortDescription, serviceContext); 
	}
	public Fund updateFund(long groupId, long userId, long fundId,String name, long budgetPeriodId,
			long fundTypeId, String shortDescription, ServiceContext serviceContext)
					throws SystemException, PortalException{
		FundPermission.check(getPermissionChecker(), fundId, ActionKeys.UPDATE);
		return FundLocalServiceUtil.updateFund(groupId, userId, fundId, name, budgetPeriodId,
				fundTypeId, shortDescription, serviceContext);
	
	}
	public Fund closeFund(long userId, long fundId, ServiceContext serviceContext) 
			throws SystemException, PortalException{
		FundPermission.check(getPermissionChecker(), fundId, ActionKeys.DELETE);
		return FundLocalServiceUtil.closeFund(userId, fundId, serviceContext);
	}
	public Fund openFund(long userId, long fundId, ServiceContext serviceContext ) 
			throws SystemException, PortalException{
		FundPermission.check(getPermissionChecker(), fundId, ActionKeys.DELETE);
		return FundLocalServiceUtil.openFund(userId, fundId, serviceContext);
	}
	
	public Fund deleteFund(long userId, long fundId)
			throws SystemException, PortalException{
		FundPermission.check(getPermissionChecker(), fundId, ActionKeys.DELETE);
		return FundLocalServiceUtil.deleteFund(userId, fundId);
	}
	public List<MemberFund> getMembersFund(long groupId,long fundId, int start, int end) 
			throws PortalException, SystemException{
		FundPermission.check(getPermissionChecker(), fundId, ActionKeys.VIEW);
		return FundLocalServiceUtil.getMembersFund(groupId, fundId, start, end);
		
	}
}