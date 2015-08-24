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

import cmr.fandenatech.ndjangui.model.Member;
import cmr.fandenatech.ndjangui.service.base.MemberLocalServiceBaseImpl;

/**
 * The implementation of the member local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.MemberLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.MemberLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil
 */
public class MemberLocalServiceImpl extends MemberLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil} to access the member local service.
	 */

	public Member addMember(long companyId, long groupId, long userId,
			String name, String surname, String email, 
			String cardNumber, String phoneNumber,ServiceContext serviceContext) throws SystemException, PortalException{

		long memberId = counterLocalService.increment(Member.class.getName());
		User user  = userLocalService.getUser(userId);    
		Member member = memberPersistence.create(memberId);
		Date now = new Date();
		member.setUserId(userId);
		member.setCompanyId(user.getCompanyId());
		member.setGroupId(groupId);
		member.setEmail(email);
		member.setCreateDate(now);
		member.setModifiedDate(now);
		member.setName(name);
		member.setSurname(surname);
		member.setCardNumber(cardNumber);
		member.setPhoneNumber(phoneNumber);
		member.setStatus(WorkflowConstants.STATUS_APPROVED);
		member = memberPersistence.update(member);
		//resource
		resourceLocalService.addModelResources(member, serviceContext);
		return member;
	}
	
	public Member updateMember(long memberId, long userId,
			String name, String surname, String email, 
			String cardNumber, String phoneNumber,ServiceContext serviceContext) throws SystemException, PortalException{

		User user  = userLocalService.getUser(userId);    
		Member member = getMember(memberId);
		Date now = new Date();
		member.setUserId(userId);
		member.setUserName(user.getFullName());
		member.setEmail(email);
		member.setModifiedDate(now);
		member.setName(name);
		member.setSurname(surname);
		member.setCardNumber(cardNumber);
		member.setPhoneNumber(phoneNumber);
		member = memberPersistence.update(member);
		//resourceLocalService.addModelResources(member, serviceContext);
		return member;
	}

	public Member deleteMember(long memberId, long userId,ServiceContext serviceContext) throws SystemException, PortalException{

		User user  = userLocalService.getUser(userId);    
		Member member = getMember(memberId);
		Date now = new Date();
		member.setUserId(userId);
		member.setUserName(user.getFullName());
		member.setModifiedDate(now);
		member.setStatus(WorkflowConstants.STATUS_INACTIVE);
		member = memberPersistence.update(member);
		//resourceLocalService.addModelResources(member, serviceContext);
		return member;
	}

	public Member activateMember(long memberId, long userId) throws SystemException, PortalException{

		User user  = userLocalService.getUser(userId);    
		Member member = getMember(memberId);
		Date now = new Date();
		member.setUserId(userId);
		member.setUserName(user.getFullName());
		member.setModifiedDate(now);
		member.setStatus(WorkflowConstants.STATUS_APPROVED);
		return memberPersistence.update(member);
	}

	public List<Member> getMembersByGroupId(long groupId, int start, int end)
			throws SystemException, PortalException{

		List<Member> members = memberPersistence.findByGroupId(groupId, start, end);
		return members;
	}

	
	public Member removeMember(long memberId,long userId, ServiceContext serviceContext)
			throws PortalException, SystemException{
		
		Member member = getMember(memberId);
		deleteMember(memberId);
		//resource
		resourceLocalService.deleteResource(member, ResourceConstants.SCOPE_INDIVIDUAL);
		return member;
	}
	public int countMembersByGroupId(long groupId)
			throws SystemException, PortalException{

		return memberPersistence.countByGroupId(groupId);
	}
	public List<Member> getMembersByGroupId_Status(long groupId,int status, int start, int end)
			throws SystemException, PortalException{

		List<Member> members = memberPersistence.findByGroupId_Status(groupId,status, start, end);
		return members;
	}

	public int countMembersByGroupId_Status(long groupId,int status)
			throws SystemException, PortalException{

		int total = memberPersistence.countByGroupId_Status(groupId,status);
		return total;
	}

}
