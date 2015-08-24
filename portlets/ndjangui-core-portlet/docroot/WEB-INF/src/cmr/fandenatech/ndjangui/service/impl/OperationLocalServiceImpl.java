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
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import cmr.fandenatech.ndjangui.model.Operation;
import cmr.fandenatech.ndjangui.service.base.OperationLocalServiceBaseImpl;

/**
 * The implementation of the operation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.OperationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.OperationLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.OperationLocalServiceUtil
 */
public class OperationLocalServiceImpl extends OperationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.OperationLocalServiceUtil} to access the operation local service.
	 */
	public Operation addOperation(long groupId, long userId, String name, long budgetPeriodId,
			long operationTypeId, long sittingId,
			String shortDescription, long srcFundClassPK, long destFundClassPK,
			String srcFundClassName, String destFundClassName, ServiceContext serviceContext)
					throws SystemException, PortalException{
		
		long operationId = counterLocalService.increment(Operation.class.getName());
		Operation operation = operationPersistence.create(operationId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		operation.setBudgetPeriodId(budgetPeriodId);
		operation.setName(name);
		operation.setOperationTypeId(operationTypeId);
		operation.setShortDescription(shortDescription);;
		operation.setCreateDate(now);
		operation.setModifiedDate(now);
		operation.setGroupId(groupId);
		operation.setUserId(userId);
		operation.setUserName(user.getFullName());
		operation.setCompanyId(user.getCompanyId());
		operation.setStatus(WorkflowConstants.STATUS_DRAFT);
		operation.setSrcFundClassName(srcFundClassName);
		operation.setSrcFundClassPK(srcFundClassPK);
		operation.setSittingId(sittingId);
		operation.setDestFundClassName(destFundClassName);
		operation.setDestFundClassPK(destFundClassPK);
		operation = operationPersistence.update(operation);
		
		//resource
		resourceLocalService.addModelResources(operation, serviceContext);
		return operation; 
	} 

	public Operation updateOperation(long groupId, long userId, long operationId,String name, long budgetPeriodId,
			long operationTypeId, long sittingId,
			String shortDescription, long srcFundClassPK, long destFundClassPK,
			String srcFundClassName, String destFundClassName, ServiceContext serviceContext)
					throws SystemException, PortalException{
		
		Operation operation = getOperation(operationId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		operation.setBudgetPeriodId(budgetPeriodId);
		operation.setName(name);
		operation.setOperationTypeId(operationTypeId);
		operation.setShortDescription(shortDescription);;
		operation.setModifiedDate(now);
		operation.setGroupId(groupId);
		operation.setUserId(userId);
		operation.setUserName(user.getFullName());
		operation.setSrcFundClassName(srcFundClassName);
		operation.setSrcFundClassPK(srcFundClassPK);
		operation.setSittingId(sittingId);
		operation.setDestFundClassName(destFundClassName);
		operation.setDestFundClassPK(destFundClassPK);
		operation = operationPersistence.update(operation);
		operation = operationPersistence.update(operation);
		
		return operation; 
	} 
	
	public Operation confirmOperation(long userId, long operationId) 
			throws SystemException, PortalException{
		
		Operation operation = getOperation(operationId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		operation.setModifiedDate(now);
		operation.setUserId(userId);
		operation.setUserName(user.getFullName());
		operation.setStatus(WorkflowConstants.STATUS_APPROVED);
		operation = operationPersistence.update(operation);
		
		return operation; 
	} 

	public Operation openOperation(long userId, long operationId) 
			throws SystemException, PortalException{
		
		Operation operation = getOperation(operationId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		operation.setModifiedDate(now);
		operation.setUserId(userId);
		operation.setUserName(user.getFullName());
		operation.setStatus(WorkflowConstants.STATUS_DRAFT);
		operation = operationPersistence.update(operation);
		
		return operation; 
	} 

	public Operation deleteOperation(long userId, long operationId) 
			throws SystemException, PortalException{
		
		Operation operation = operationPersistence.remove(operationId);
		resourceLocalService.deleteResource(operation, ResourceConstants.SCOPE_INDIVIDUAL);
		return operation; 
	} 
	public List<Operation> getOperationByGroupId(long groupId, int start, int end) 
			throws PortalException, SystemException{
		
		List<Operation> operations = operationPersistence.findByGroupId(groupId, start, end);
		return operations;

	} 
	public int countOperationsByGroupId(long groupId) 
			throws PortalException, SystemException{
		
		int total = operationPersistence.countByGroupId(groupId);
		return total;

	} 

	public List<Operation> getOperationsByGroupId_Status(long groupId, int status, int start, int end) 
			throws PortalException, SystemException{
		
		List<Operation> operations = operationPersistence.findByGroupId_Status(groupId, status, start, end);
		return operations;

	} 

	public int countOperationsByGroupId_Status(long groupId, int status) 
			throws PortalException, SystemException{
		
		int total = operationPersistence.countByGroupId_Status(groupId, status);
		return total;

	}

}