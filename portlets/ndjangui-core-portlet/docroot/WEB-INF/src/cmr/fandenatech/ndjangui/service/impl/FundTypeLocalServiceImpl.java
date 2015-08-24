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

import cmr.fandenatech.ndjangui.model.FundType;
import cmr.fandenatech.ndjangui.service.base.FundTypeLocalServiceBaseImpl;

/**
 * The implementation of the fund type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.FundTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.FundTypeLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.FundTypeLocalServiceUtil
 */
public class FundTypeLocalServiceImpl extends FundTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.FundTypeLocalServiceUtil} to access the fund type local service.
	 */

	public FundType addFundType(long groupId,long userId, String name,
			String shortDescription, ServiceContext serviceContext ) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		long fundTypeId = counterLocalService.increment(FundType.class.getName());
		FundType fundType = fundTypePersistence.create(fundTypeId);
		fundType.setName(name);
		fundType.setUserId(userId);
		fundType.setGroupId(groupId);
		fundType.setUserName(user.getFullName());
		fundType.setShortDescription(shortDescription);
		fundType.setCompanyId(user.getCompanyId());
		fundType.setCreateDate(now);
		fundType.setModifiedDate(now);
		fundType.setStatus(WorkflowConstants.STATUS_APPROVED);
		fundType = fundTypePersistence.update(fundType);
		//resource
		resourceLocalService.addModelResources(fundType, serviceContext);
		
		return fundType ;
		
		
		
	} 

	public FundType updateFundType(long userId, long fundTypeId, String name,
			String shortDescription) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		FundType fundType = getFundType(fundTypeId);
		fundType.setName(name);
		fundType.setUserId(userId);
		fundType.setUserName(user.getFullName());
		fundType.setShortDescription(shortDescription);
		fundType.setModifiedDate(now);
		fundType = fundTypePersistence.update(fundType);
		return fundType ;
		
		
		
	} 

	public FundType updateFundTypeStatus(long userId, long fundTypeId, int status) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		FundType fundType = getFundType(fundTypeId);
		fundType.setUserId(userId);
		fundType.setUserName(user.getFullName());
		fundType.setModifiedDate(now);
		fundType.setStatus(status);
		fundType = fundTypePersistence.update(fundType);
		return fundType ;
		
		
		
	} 
	
	public List<FundType> getFundTypesByGroupId(long groupId, int start, int end) 
			throws PortalException, SystemException{
		
		List<FundType> fundTypes = fundTypePersistence.findByGroupId(groupId, start, end);
		return fundTypes;

	} 
	public int countFundTypesByGroupId(long groupId) 
			throws PortalException, SystemException{
		
		int total = fundTypePersistence.countByGroupId(groupId);
		return total;

	} 

	public List<FundType> getFundTypesByGroupId_Status(long groupId, int status, int start, int end) 
			throws PortalException, SystemException{
		
		List<FundType> fundTypes = fundTypePersistence.findByGroupId_Status(groupId, status, start, end);
		return fundTypes;

	} 

	public int countFundTypesByGroupId_Status(long groupId, int status) 
			throws PortalException, SystemException{
		
		int total = fundTypePersistence.countByGroupId_Status(groupId, status);
		return total;

	} 
	
	public FundType deleteFundType(long fundTypeId) 
			throws PortalException, SystemException{
		
		FundType fundType = fundTypePersistence.remove(fundTypeId);
		//resource
		resourceLocalService.deleteResource(fundType, ResourceConstants.SCOPE_INDIVIDUAL);
		return fundType;

	} 

}