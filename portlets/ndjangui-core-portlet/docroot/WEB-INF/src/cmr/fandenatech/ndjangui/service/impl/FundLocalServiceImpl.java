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

import cmr.fandenatech.ndjangui.model.Fund;
import cmr.fandenatech.ndjangui.model.Member;
import cmr.fandenatech.ndjangui.model.MemberFund;
import cmr.fandenatech.ndjangui.service.base.FundLocalServiceBaseImpl;
import cmr.fandenatech.ndjangui.service.util.EntityWorkflowConstants;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the fund local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.FundLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.FundLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.FundLocalServiceUtil
 */
public class FundLocalServiceImpl extends FundLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.FundLocalServiceUtil} to access the fund local service.
	 */
	
	public Fund addFund(long groupId, long userId, String name, long budgetPeriodId,
			long fundTypeId, String shortDescription, ServiceContext serviceContext)
					throws SystemException, PortalException{
		
		long fundId = counterLocalService.increment(Fund.class.getName());
		Fund fund = fundPersistence.create(fundId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		fund.setBudgetPeriodId(budgetPeriodId);
		fund.setName(name);
		fund.setFundTypeId(fundTypeId);
		fund.setShortDescription(shortDescription);;
		fund.setCreateDate(now);
		fund.setModifiedDate(now);
		fund.setGroupId(groupId);
		fund.setUserId(userId);
		fund.setUserName(user.getFullName());
		fund.setCompanyId(user.getCompanyId());
		fund.setStatus(WorkflowConstants.STATUS_DRAFT);
		fund = fundPersistence.update(fund);
		
		//resource
		resourceLocalService.addModelResources(fund, serviceContext);
		return fund; 
	} 

	public Fund updateFund(long groupId, long userId, long fundId,String name, long budgetPeriodId,
			long fundTypeId, String shortDescription, ServiceContext serviceContext)
					throws SystemException, PortalException{
		
		Fund fund = getFund(fundId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		fund.setBudgetPeriodId(budgetPeriodId);
		fund.setName(name);
		fund.setFundTypeId(fundTypeId);
		fund.setShortDescription(shortDescription);;
		fund.setModifiedDate(now);
		fund.setGroupId(groupId);
		fund.setUserId(userId);
		fund.setUserName(user.getFullName());
		fund = fundPersistence.update(fund);
		
		resourceLocalService.updateModelResources(fund, serviceContext);
		
		return fund; 
	} 
	
	public Fund closeFund(long userId, long fundId, ServiceContext serviceContext) 
			throws SystemException, PortalException{
		
		Fund fund = getFund(fundId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		fund.setModifiedDate(now);
		fund.setUserId(userId);
		fund.setUserName(user.getFullName());
		fund.setStatus(WorkflowConstants.STATUS_INACTIVE);
		fund = fundPersistence.update(fund);
		resourceLocalService.updateModelResources(fund, serviceContext);
		return fund; 
	} 

	public Fund openFund(long userId, long fundId, ServiceContext serviceContext ) 
			throws SystemException, PortalException{
		
		Fund fund = getFund(fundId);
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		fund.setModifiedDate(now);
		fund.setUserId(userId);
		fund.setUserName(user.getFullName());
		fund.setStatus(WorkflowConstants.STATUS_APPROVED);
		fund = fundPersistence.update(fund);
		resourceLocalService.updateModelResources(fund, serviceContext);
		return fund; 
	} 

	public Fund deleteFund(long userId, long fundId) 
			throws SystemException, PortalException{
		
		Fund fund = fundPersistence.remove(fundId);
		resourceLocalService.deleteResource(fund, ResourceConstants.SCOPE_INDIVIDUAL);
		return fund; 
	} 
	public List<Fund> getFundByGroupId(long groupId, int start, int end) 
			throws PortalException, SystemException{
		
		List<Fund> funds = fundPersistence.findByGroupId(groupId, start, end);
		return funds;

	} 
	@SuppressWarnings("unchecked")
	public List<MemberFund> getMembersFund(long groupId,long fundId, int start, int end) 
			throws PortalException, SystemException{
		
		
		List<MemberFund> members = null;
		
		DynamicQuery memberQuery = getFundMemberQuery(groupId, fundId);
		memberQuery.setLimit(start, end);
		
		members = memberFundLocalService.dynamicQuery(memberQuery);
		
		return members;

	} 
	public int countMembersFund(long groupId,long fundId) 
			throws PortalException, SystemException{
		
		
		int total= 0;
		
		DynamicQuery memberQuery = getFundMemberQuery(groupId, fundId);
		
		total = (int) memberPersistence.countWithDynamicQuery(memberQuery, null);
		
		return total;

	} 

	private DynamicQuery getFundMemberQuery(long groupId, long fundId){
		DynamicQuery memberFundQuery = memberFundLocalService.dynamicQuery();
//		DynamicQuery memberQuery = memberLocalService.dynamicQuery();
		memberFundQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
		memberFundQuery.add(PropertyFactoryUtil.forName("fundId").eq(fundId));
//		memberFundQuery.setProjection(ProjectionFactoryUtil.property("memberId"));
//		memberQuery.add(PropertyFactoryUtil.forName("memberId").in(memberFundQuery));
		return memberFundQuery;
	}
	public int countFundsByGroupId(long groupId) 
			throws PortalException, SystemException{
		
		int total = fundPersistence.countByGroupId(groupId);
		return total;

	} 

	public List<Fund> getFundByGroupId_Status(long groupId, int status) 
			throws PortalException, SystemException{
		
		List<Fund> funds = fundPersistence.findByGroupId_Status(groupId, status);
		return funds;

	} 

	public int countFundByGroupId_Status(long groupId, int status) 
			throws PortalException, SystemException{
		
		int total = fundPersistence.countByGroupId_Status(groupId, status);
		return total;

	} 

}