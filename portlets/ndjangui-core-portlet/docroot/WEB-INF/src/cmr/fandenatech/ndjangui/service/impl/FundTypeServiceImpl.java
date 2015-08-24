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
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;

import cmr.fandenatech.ndjangui.model.FundType;
import cmr.fandenatech.ndjangui.permission.FundTypePermission;
import cmr.fandenatech.ndjangui.service.FundTypeLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.base.FundTypeServiceBaseImpl;

/**
 * The implementation of the fund type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.FundTypeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.FundTypeServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.FundTypeServiceUtil
 */
public class FundTypeServiceImpl extends FundTypeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.FundTypeServiceUtil} to access the fund type remote service.
	 */

	public FundType addFundType(long groupId,long userId, String name,
			String shortDescription, ServiceContext serviceContext ) 
					throws PortalException, SystemException{
		return FundTypeLocalServiceUtil.addFundType(groupId, userId, name, shortDescription, serviceContext);
	}
	
	public FundType updateFundType(long groupId,long userId,long fundTypeId, String name,
			String shortDescription, ServiceContext serviceContext ) 
					throws PortalException, SystemException{
		FundTypePermission.check(getPermissionChecker(), fundTypeId, ActionKeys.UPDATE);
		return FundTypeLocalServiceUtil.updateFundType(userId, fundTypeId, name, shortDescription);
	}
	public FundType updateFundTypeStatus(long userId, long fundTypeId, int status) 
			throws PortalException, SystemException{
		FundTypePermission.check(getPermissionChecker(), fundTypeId, ActionKeys.UPDATE);
		return FundTypeLocalServiceUtil.updateFundTypeStatus(userId, fundTypeId, status);
		
	}
	public FundType deleFundType(long fundTypeId) 
			throws PortalException, SystemException{
		FundTypePermission.check(getPermissionChecker(), fundTypeId, ActionKeys.DELETE);
		return FundTypeLocalServiceUtil.deleteFundType(fundTypeId);
		
	}
}