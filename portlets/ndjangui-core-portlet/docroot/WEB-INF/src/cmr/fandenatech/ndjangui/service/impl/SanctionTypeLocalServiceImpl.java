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

import cmr.fandenatech.ndjangui.model.SanctionType;
import cmr.fandenatech.ndjangui.service.base.SanctionTypeLocalServiceBaseImpl;

/**
 * The implementation of the sanction type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.SanctionTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.SanctionTypeLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.SanctionTypeLocalServiceUtil
 */
public class SanctionTypeLocalServiceImpl
	extends SanctionTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.SanctionTypeLocalServiceUtil} to access the sanction type local service.
	 */
	public SanctionType addSanctionType(long groupId,long userId, String name,
			String shortDescription, double amount, ServiceContext serviceContext ) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		long sanctionTypeId = counterLocalService.increment(SanctionType.class.getName());
		SanctionType sanctionType = sanctionTypePersistence.create(sanctionTypeId);
		sanctionType.setName(name);
		sanctionType.setUserId(userId);
		sanctionType.setGroupId(groupId);
		sanctionType.setUserName(user.getFullName());
		sanctionType.setShortDescription(shortDescription);
		sanctionType.setCompanyId(user.getCompanyId());
		sanctionType.setCreateDate(now);
		sanctionType.setModifiedDate(now);
		sanctionType.setStatus(WorkflowConstants.STATUS_APPROVED);
		sanctionType.setAmount(amount);
		sanctionType = sanctionTypePersistence.update(sanctionType);
		
		//resource
		resourceLocalService.addModelResources(sanctionType, serviceContext);
		
		return sanctionType ;
		
		
		
	} 

	public SanctionType updateSanctionType(long userId, long sanctionTypeId, String name,
			String shortDescription, double amount) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		SanctionType sanctionType = getSanctionType(sanctionTypeId);
		sanctionType.setName(name);
		sanctionType.setUserId(userId);
		sanctionType.setUserName(user.getFullName());
		sanctionType.setShortDescription(shortDescription);
		sanctionType.setAmount(amount);
		sanctionType.setModifiedDate(now);
		sanctionType = sanctionTypePersistence.update(sanctionType);

		return sanctionType ;
		
		
		
	} 

	public SanctionType updateSanctionTypeStatus(long userId, long sanctionTypeId, int status) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		SanctionType sanctionType = getSanctionType(sanctionTypeId);
		sanctionType.setUserId(userId);
		sanctionType.setUserName(user.getFullName());
		sanctionType.setModifiedDate(now);
		sanctionType.setStatus(status);
		sanctionType = sanctionTypePersistence.update(sanctionType);
		return sanctionType ;
		
		
		
	} 
	
	public List<SanctionType> getSanctionTypesByGroupId(long groupId, int start, int end) 
			throws PortalException, SystemException{
		
		List<SanctionType> sanctionTypes = sanctionTypePersistence.findByGroupId(groupId, start, end);
		return sanctionTypes;

	} 
	public int countSanctionTypesByGroupId(long groupId) 
			throws PortalException, SystemException{
		
		int total = sanctionTypePersistence.countByGroupId(groupId);
		return total;

	} 

	public List<SanctionType> getSanctionTypesByGroupId_Status(long groupId, int status, int start, int end) 
			throws PortalException, SystemException{
		
		List<SanctionType> sanctionTypes = sanctionTypePersistence.findByGroupId_Status(groupId, status, start, end);
		return sanctionTypes;

	} 

	public int countSanctionTypesByGroupId_Status(long groupId, int status) 
			throws PortalException, SystemException{
		
		int total = sanctionTypePersistence.countByGroupId_Status(groupId, status);
		return total;

	} 
	
}