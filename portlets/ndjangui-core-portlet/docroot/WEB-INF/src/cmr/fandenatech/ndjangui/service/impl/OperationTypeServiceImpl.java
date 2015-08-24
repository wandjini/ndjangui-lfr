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

import cmr.fandenatech.ndjangui.model.OperationType;
import cmr.fandenatech.ndjangui.permission.OperationTypePermission;
import cmr.fandenatech.ndjangui.service.OperationTypeLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.base.OperationTypeServiceBaseImpl;

/**
 * The implementation of the operation type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.OperationTypeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.OperationTypeServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.OperationTypeServiceUtil
 */
public class OperationTypeServiceImpl extends OperationTypeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.OperationTypeServiceUtil} to access the operation type remote service.
	 */
	public OperationType addOperationType(long groupId,long userId, String name,
			String shortDescription, ServiceContext serviceContext ) 
					throws PortalException, SystemException{
		return OperationTypeLocalServiceUtil.addOperationType(groupId, userId, name, shortDescription, serviceContext);
	}
	
	public OperationType updateOperationType(long groupId,long userId,long operationTypeId, String name,
			String shortDescription, ServiceContext serviceContext ) 
					throws PortalException, SystemException{
		OperationTypePermission.check(getPermissionChecker(), operationTypeId, ActionKeys.UPDATE);
		return OperationTypeLocalServiceUtil.updateOperationType(userId, operationTypeId, name, shortDescription);
	}
	public OperationType updateOperationTypeStatus(long userId, long operationTypeId, int status) 
			throws PortalException, SystemException{
		OperationTypePermission.check(getPermissionChecker(), operationTypeId, ActionKeys.UPDATE);
		return OperationTypeLocalServiceUtil.updateOperationTypeStatus(userId, operationTypeId, status);
		
	}
	public OperationType deleOperationType(long operationTypeId) 
			throws PortalException, SystemException{
		OperationTypePermission.check(getPermissionChecker(), operationTypeId, ActionKeys.DELETE);
		return OperationTypeLocalServiceUtil.deleteOperationType(operationTypeId);
		
	}
}