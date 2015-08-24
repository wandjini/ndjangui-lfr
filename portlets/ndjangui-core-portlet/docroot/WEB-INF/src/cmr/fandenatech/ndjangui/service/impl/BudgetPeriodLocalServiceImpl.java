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

import cmr.fandenatech.ndjangui.model.BudgetPeriod;
import cmr.fandenatech.ndjangui.service.base.BudgetPeriodLocalServiceBaseImpl;
import cmr.fandenatech.ndjangui.service.util.EntityWorkflowConstants;

/**
 * The implementation of the budget period local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.BudgetPeriodLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.BudgetPeriodLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.BudgetPeriodLocalServiceUtil
 */
public class BudgetPeriodLocalServiceImpl
	extends BudgetPeriodLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.BudgetPeriodLocalServiceUtil} to access the budget period local service.
	 */
	public BudgetPeriod addBudgetPeriod(long groupId,long userId, String name,
			String shortDescription, Date startDate, Date endDate, ServiceContext serviceContext ) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		long budgetPeriodId = counterLocalService.increment(BudgetPeriod.class.getName());
		BudgetPeriod budgetPeriod = budgetPeriodPersistence.create(budgetPeriodId);
		budgetPeriod.setName(name);
		budgetPeriod.setUserId(userId);
		budgetPeriod.setGroupId(groupId);
		budgetPeriod.setUserName(user.getFullName());
		budgetPeriod.setShortDescription(shortDescription);
		budgetPeriod.setCompanyId(user.getCompanyId());
		budgetPeriod.setCreateDate(now);
		budgetPeriod.setModifiedDate(now);
		budgetPeriod.setStartDate(startDate);
		budgetPeriod.setEndDate(endDate);
		budgetPeriod.setStatus(EntityWorkflowConstants.STATUS_DRAFT);
		budgetPeriod = budgetPeriodPersistence.update(budgetPeriod);
		//resource
		resourceLocalService.addModelResources(budgetPeriod, serviceContext);
		
		return budgetPeriod ;
		
		
		
	} 

	public BudgetPeriod updateBudgetPeriod(long userId, long budgetPeriodId, String name,
			String shortDescription,  Date startDate, Date endDate) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		BudgetPeriod budgetPeriod = getBudgetPeriod(budgetPeriodId);
		budgetPeriod.setName(name);
		budgetPeriod.setUserId(userId);
		budgetPeriod.setUserName(user.getFullName());
		budgetPeriod.setShortDescription(shortDescription);
		budgetPeriod.setModifiedDate(now);
		budgetPeriod.setStartDate(startDate);
		budgetPeriod.setEndDate(endDate);
		
		budgetPeriod = budgetPeriodPersistence.update(budgetPeriod);
		
		return budgetPeriod ;
		
		
		
	} 

	public BudgetPeriod updateBudgetPeriodStatus(long userId, long budgetPeriodId, int status) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		BudgetPeriod budgetPeriod = getBudgetPeriod(budgetPeriodId);
		budgetPeriod.setUserId(userId);
		budgetPeriod.setUserName(user.getFullName());
		budgetPeriod.setModifiedDate(now);
		budgetPeriod.setStatus(status);
		//if(status == WorkflowConstants.)
		budgetPeriod = budgetPeriodPersistence.update(budgetPeriod);
		return budgetPeriod ;
	} 

	public BudgetPeriod closeBudgetPeriod(long userId, long budgetPeriodId) 
			throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		BudgetPeriod budgetPeriod = getBudgetPeriod(budgetPeriodId);
		budgetPeriod.setUserId(userId);
		budgetPeriod.setUserName(user.getFullName());
		budgetPeriod.setModifiedDate(now);
		budgetPeriod.setEndDate(now);
		budgetPeriod.setStatus(WorkflowConstants.STATUS_EXPIRED);
		budgetPeriod = budgetPeriodPersistence.update(budgetPeriod);
		
		return budgetPeriod ;



} 

	public List<BudgetPeriod> getBudgetPeriodsByGroupId(long groupId, int start, int end) 
			throws PortalException, SystemException{
		
		List<BudgetPeriod> budgetPeriods = budgetPeriodPersistence.findByGroupId(groupId, start, end);
		return budgetPeriods;

	} 
	public int countBudgetPeriodsByGroupId(long groupId) 
			throws PortalException, SystemException{
		
		int total = budgetPeriodPersistence.countByGroupId(groupId);
		return total;

	} 

	public List<BudgetPeriod> getBudgetPeriodsByGroupId_Status(long groupId, int status) 
			throws PortalException, SystemException{
		
		List<BudgetPeriod> budgetPeriods = budgetPeriodPersistence.findByGroupId_Status(groupId, status);
		return budgetPeriods;

	} 

	public int countBudgetPeriodsByGroupId_Status(long groupId, int status) 
			throws PortalException, SystemException{
		
		int total = budgetPeriodPersistence.countByGroupId_Status(groupId, status);
		return total;

	} 
}