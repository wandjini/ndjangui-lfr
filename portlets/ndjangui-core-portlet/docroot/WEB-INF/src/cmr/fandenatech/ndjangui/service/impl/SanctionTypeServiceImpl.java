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

import cmr.fandenatech.ndjangui.model.SanctionType;
import cmr.fandenatech.ndjangui.permission.SanctionTypePermission;
import cmr.fandenatech.ndjangui.service.SanctionTypeLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.base.SanctionTypeServiceBaseImpl;

/**
 * The implementation of the sanction type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.SanctionTypeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.SanctionTypeServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.SanctionTypeServiceUtil
 */
public class SanctionTypeServiceImpl extends SanctionTypeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.SanctionTypeServiceUtil} to access the sanction type remote service.
	 */
	public SanctionType addSanctionType(long groupId,long userId, String name,
			String shortDescription, double amount,ServiceContext serviceContext ) 
					throws PortalException, SystemException{
		return SanctionTypeLocalServiceUtil.addSanctionType(groupId, userId, name, shortDescription, 
					amount, serviceContext);
	}
	
	public SanctionType updateSanctionType(long groupId,long userId,long sanctionTypeId, String name,
			String shortDescription, double amount, ServiceContext serviceContext ) 
					throws PortalException, SystemException{
		SanctionTypePermission.check(getPermissionChecker(), sanctionTypeId, ActionKeys.UPDATE);
		return SanctionTypeLocalServiceUtil.updateSanctionType(userId, sanctionTypeId, name, shortDescription, amount);
	}
	public SanctionType updateSanctionTypeStatus(long userId, long sanctionTypeId, int status) 
			throws PortalException, SystemException{
		SanctionTypePermission.check(getPermissionChecker(), sanctionTypeId, ActionKeys.UPDATE);
		return SanctionTypeLocalServiceUtil.updateSanctionTypeStatus(userId, sanctionTypeId, status);
		
	}
	public SanctionType deleSanctionType(long sanctionTypeId) 
			throws PortalException, SystemException{
		SanctionTypePermission.check(getPermissionChecker(), sanctionTypeId, ActionKeys.DELETE);
		return SanctionTypeLocalServiceUtil.deleteSanctionType(sanctionTypeId);
		
	}
}