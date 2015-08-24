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
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import cmr.fandenatech.ndjangui.model.MemberSitting;
import cmr.fandenatech.ndjangui.model.Sitting;
import cmr.fandenatech.ndjangui.service.MemberSittingLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.base.SittingLocalServiceBaseImpl;

/**
 * The implementation of the sitting local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.SittingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.SittingLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.SittingLocalServiceUtil
 */
public class SittingLocalServiceImpl extends SittingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.SittingLocalServiceUtil} to access the sitting local service.
	 */
	
	public Sitting addSitting(long groupId,long userId, String name,
			String dayPlan, String notes, ServiceContext serviceContext ) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		long sittingId = counterLocalService.increment(Sitting.class.getName());
		Sitting sitting = sittingPersistence.create(sittingId);
		sitting.setName(name);
		sitting.setUserId(userId);
		sitting.setGroupId(groupId);
		sitting.setUserName(user.getFullName());
		sitting.setCompanyId(user.getCompanyId());
		sitting.setCreateDate(now);
		sitting.setModifiedDate(now);
		sitting.setNotes(notes);
		sitting.setDayPlan(dayPlan);
		sitting.setStatus(WorkflowConstants.STATUS_APPROVED);
		sitting = sittingPersistence.update(sitting);
		//resource
		resourceLocalService.addModelResources(sitting, serviceContext);
		
		return sitting ;
		
		
		
	} 

	public Sitting updateSitting(long userId, long sittingId, String name,
			String dayPlan, String notes) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		Sitting sitting = getSitting(sittingId);
		sitting.setName(name);
		sitting.setUserId(userId);
		sitting.setUserName(user.getFullName());
		sitting.setNotes(notes);
		sitting.setDayPlan(dayPlan);
		sitting.setModifiedDate(now);
		sittingPersistence.update(sitting);
		return sitting ;
		
		
		
	} 
	
	public Sitting openSitting(long userId, long sittingId) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		Sitting sitting = getSitting(sittingId);
		sitting.setStartDate(now);
		sitting.setStatus(WorkflowConstants.STATUS_INCOMPLETE);
		sitting.setUserId(userId);
		sitting.setUserName(user.getFullName());

		sittingPersistence.update(sitting);
		
		return sitting ;
		
		
		
	}
	public Sitting closeSitting(long userId, long sittingId) 
			throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		Sitting sitting = getSitting(sittingId);
		sitting.setUserId(userId);
		sitting.setUserName(user.getFullName());
		sitting.setEndDate(now);
		sitting.setStatus(WorkflowConstants.STATUS_APPROVED);
		sittingPersistence.update(sitting);
		
		return sitting ;
	}

	public Sitting updateSittingStatus(long userId, long sittingId, int status) 
					throws PortalException, SystemException{
		User user = userLocalService.getUser(userId);
		Date now = new Date();
		
		Sitting sitting = getSitting(sittingId);
		sitting.setUserId(userId);
		sitting.setUserName(user.getFullName());
		sitting.setModifiedDate(now);
		sitting.setStatus(status);
		sitting = sittingPersistence.update(sitting);
		return sitting ;
		
		
		
	} 
	
	public List<Sitting> getSittingsByGroupId(long groupId, int start, int end) 
			throws PortalException, SystemException{
		
		List<Sitting> sittings = sittingPersistence.findByGroupId(groupId, start, end);
		return sittings;

	} 
	public int countSittingsByGroupId(long groupId) 
			throws PortalException, SystemException{
		
		int total = sittingPersistence.countByGroupId(groupId);
		return total;

	} 

	public List<Sitting> getSittingsByGroupId_Status(long groupId, int status) 
			throws PortalException, SystemException{
		
		List<Sitting> sittings = sittingPersistence.findByGroupId_Status(groupId, status);
		return sittings;

	} 

	public int countSittingsByGroupId_Status(long groupId, int status) 
			throws PortalException, SystemException{
		
		int total = sittingPersistence.countByGroupId_Status(groupId, status);
		return total;

	} 
	public MemberSitting addMemberSitting(long groupId, long userId, 
				long sittingId, long memberId) throws PortalException, SystemException{
		
		return MemberSittingLocalServiceUtil.addMemberSitting(groupId, userId, memberId, sittingId);
	}
	
	public MemberSitting removeMemberSitting(long memberSittingId) throws PortalException, SystemException{
	
		return MemberSittingLocalServiceUtil.deleteMemberSitting(memberSittingId);
	}

}