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

import cmr.fandenatech.ndjangui.model.Sanction;
import cmr.fandenatech.ndjangui.service.base.SanctionLocalServiceBaseImpl;

/**
 * The implementation of the sanction local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.SanctionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.SanctionLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.SanctionLocalServiceUtil
 */
public class SanctionLocalServiceImpl extends SanctionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.SanctionLocalServiceUtil} to access the sanction local service.
	 */
	public Sanction addSanction(long groupId, long userId, String name, long budgetPeriodId,
			long sanctionTypeId, long sittingId,
			String shortDescription, long srcFundClassPK, long destFundClassPK,
			String srcFundClassName, String destFundClassName, ServiceContext serviceContext)
					throws SystemException, PortalException{
		
		long sanctionId = counterLocalService.increment(Sanction.class.getName());
		Sanction sanction = sanctionPersistence.create(sanctionId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		sanction.setBudgetPeriodId(budgetPeriodId);
		sanction.setName(name);
		sanction.setSanctionTypeId(sanctionTypeId);
		sanction.setShortDescription(shortDescription);;
		sanction.setCreateDate(now);
		sanction.setModifiedDate(now);
		sanction.setGroupId(groupId);
		sanction.setUserId(userId);
		sanction.setUserName(user.getFullName());
		sanction.setCompanyId(user.getCompanyId());
		sanction.setStatus(WorkflowConstants.STATUS_DRAFT);
		sanction.setSrcFundClassName(srcFundClassName);
		sanction.setSrcFundClassPK(srcFundClassPK);
		sanction.setSittingId(sittingId);
		sanction.setDestFundClassName(destFundClassName);
		sanction.setDestFundClassPK(destFundClassPK);
		sanction = sanctionPersistence.update(sanction);
		
		//resource
		resourceLocalService.addModelResources(sanction, serviceContext);
		return sanction; 
	} 

	public Sanction updateSanction(long groupId, long userId, long sanctionId,String name, long budgetPeriodId,
			long sanctionTypeId, long sittingId,
			String shortDescription, long srcFundClassPK, long destFundClassPK,
			String srcFundClassName, String destFundClassName, ServiceContext serviceContext)
					throws SystemException, PortalException{
		
		Sanction sanction = getSanction(sanctionId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		sanction.setBudgetPeriodId(budgetPeriodId);
		sanction.setName(name);
		sanction.setSanctionTypeId(sanctionTypeId);
		sanction.setShortDescription(shortDescription);;
		sanction.setModifiedDate(now);
		sanction.setGroupId(groupId);
		sanction.setUserId(userId);
		sanction.setUserName(user.getFullName());
		sanction.setSrcFundClassName(srcFundClassName);
		sanction.setSrcFundClassPK(srcFundClassPK);
		sanction.setSittingId(sittingId);
		sanction.setDestFundClassName(destFundClassName);
		sanction.setDestFundClassPK(destFundClassPK);
		sanction = sanctionPersistence.update(sanction);
		sanction = sanctionPersistence.update(sanction);
		
		return sanction; 
	} 
	
	public Sanction confirmSanction(long userId, long sanctionId) 
			throws SystemException, PortalException{
		
		Sanction sanction = getSanction(sanctionId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		sanction.setModifiedDate(now);
		sanction.setUserId(userId);
		sanction.setUserName(user.getFullName());
		sanction.setStatus(WorkflowConstants.STATUS_APPROVED);
		sanction = sanctionPersistence.update(sanction);
		
		return sanction; 
	} 

	public Sanction openSanction(long userId, long sanctionId) 
			throws SystemException, PortalException{
		
		Sanction sanction = getSanction(sanctionId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		sanction.setModifiedDate(now);
		sanction.setUserId(userId);
		sanction.setUserName(user.getFullName());
		sanction.setStatus(WorkflowConstants.STATUS_DRAFT);
		sanction = sanctionPersistence.update(sanction);
		
		return sanction; 
	} 

	public Sanction deleteSanction(long userId, long sanctionId) 
			throws SystemException, PortalException{
		
		Sanction sanction = sanctionPersistence.remove(sanctionId);
		resourceLocalService.deleteResource(sanction, ResourceConstants.SCOPE_INDIVIDUAL);
		return sanction; 
	} 
	public List<Sanction> getSanctionByGroupId(long groupId, int start, int end) 
			throws PortalException, SystemException{
		
		List<Sanction> sanctions = sanctionPersistence.findByGroupId(groupId, start, end);
		return sanctions;

	} 
	public int countSanctionsByGroupId(long groupId) 
			throws PortalException, SystemException{
		
		int total = sanctionPersistence.countByGroupId(groupId);
		return total;

	} 

	public List<Sanction> getSanctionsByGroupId_Status(long groupId, int status, int start, int end) 
			throws PortalException, SystemException{
		
		List<Sanction> sanctions = sanctionPersistence.findByGroupId_Status(groupId, status, start, end);
		return sanctions;

	} 

	public int countSanctionsByGroupId_Status(long groupId, int status) 
			throws PortalException, SystemException{
		
		int total = sanctionPersistence.countByGroupId_Status(groupId, status);
		return total;

	}

}