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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import cmr.fandenatech.ndjangui.model.OperationType;
import cmr.fandenatech.ndjangui.service.base.OperationTypeLocalServiceBaseImpl;

/**
 * The implementation of the operation type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.OperationTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.OperationTypeLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.OperationTypeLocalServiceUtil
 */
public class OperationTypeLocalServiceImpl
	extends OperationTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.OperationTypeLocalServiceUtil} to access the operation type local service.
	 */
	
	public OperationType addOperationType(long groupId,long userId, String name,
			String shortDescription, ServiceContext serviceContext ) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		long operationTypeId = counterLocalService.increment(OperationType.class.getName());
		OperationType operationType = operationTypePersistence.create(operationTypeId);
		operationType.setName(name);
		operationType.setUserId(userId);
		operationType.setGroupId(groupId);
		operationType.setUserName(user.getFullName());
		operationType.setShortDescription(shortDescription);
		operationType.setCompanyId(user.getCompanyId());
		operationType.setCreateDate(now);
		operationType.setModifiedDate(now);
		operationType.setStatus(WorkflowConstants.STATUS_APPROVED);
		operationType = operationTypePersistence.update(operationType);
		//resource
		resourceLocalService.addModelResources(operationType, serviceContext);
		
		return operationType ;
		
		
		
	} 

	public OperationType updateOperationType(long userId, long operationTypeId, String name,
			String shortDescription) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		OperationType operationType = getOperationType(operationTypeId);
		operationType.setName(name);
		operationType.setUserId(userId);
		operationType.setUserName(user.getFullName());
		operationType.setShortDescription(shortDescription);
		operationType.setModifiedDate(now);
		operationType = operationTypePersistence.update(operationType);
		return operationType ;
		
		
		
	} 

	public OperationType updateOperationTypeStatus(long userId, long operationTypeId, int status) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		OperationType operationType = getOperationType(operationTypeId);
		operationType.setUserId(userId);
		operationType.setUserName(user.getFullName());
		operationType.setModifiedDate(now);
		operationType.setStatus(status);
		operationType = operationTypePersistence.update(operationType);
		return operationType ;
		
		
		
	} 
	
	public List<OperationType> getOperationTypesByGroupId(long groupId, int start, int end) 
			throws PortalException, SystemException{
		
		List<OperationType> operationTypes = operationTypePersistence.findByGroupId(groupId, start, end);
		return operationTypes;

	} 
	public int countOperationTypesByGroupId(long groupId) 
			throws PortalException, SystemException{
		
		int total = operationTypePersistence.countByGroupId(groupId);
		return total;

	} 

	public List<OperationType> getOperationTypesByGroupId_Status(long groupId, int status, int start, int end) 
			throws PortalException, SystemException{
		
		List<OperationType> operationTypes = operationTypePersistence.findByGroupId_Status(groupId, status, start, end);
		return operationTypes;

	} 

	public int countOperationTypesByGroupId_Status(long groupId, int status) 
			throws PortalException, SystemException{
		
		int total = operationTypePersistence.countByGroupId_Status(groupId, status);
		return total;

	} 
}