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
import com.liferay.portal.model.User;

import cmr.fandenatech.ndjangui.model.Sitting;
import cmr.fandenatech.ndjangui.model.Member;
import cmr.fandenatech.ndjangui.model.MemberSitting;
import cmr.fandenatech.ndjangui.service.base.MemberSittingLocalServiceBaseImpl;

/**
 * The implementation of the member sitting local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.MemberSittingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.MemberSittingLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.MemberSittingLocalServiceUtil
 */
public class MemberSittingLocalServiceImpl
	extends MemberSittingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.MemberSittingLocalServiceUtil} to access the member sitting local service.
	 */
	public MemberSitting addMemberSitting(long groupId, long userId, 
			long memberId, long sittingId) throws SystemException, PortalException{
		
		long memberSittingId = counterLocalService.increment(MemberSitting.class.getName());
		MemberSitting memberSitting = memberSittingPersistence.create(memberSittingId);
		User user = userLocalService.getUser(userId);
		Sitting sitting = sittingLocalService.getSitting(sittingId);
		Member member = memberLocalService.getMember(memberId);
		Date now = new Date(); 
		memberSitting.setMemberId(memberId);
		memberSitting.setSittingId(sittingId);
		memberSitting.setCreateDate(now);
		memberSitting.setModifiedDate(now);
		memberSitting.setUserId(userId);
		memberSitting.setUserName(user.getFullName());
		memberSitting.setMemberName(member.getName()+" "+ member.getSurname());
		memberSitting.setSittingName(sitting.getName());
		memberSitting.setGroupId(groupId);
		
		memberSitting = memberSittingPersistence.update(memberSitting);
		
		return memberSitting;
	}
	
	public MemberSitting updateMemberSitting(long memberSittingId, long userId, 
			long memberId, long sittingId) throws SystemException, PortalException{
		
		MemberSitting memberSitting = getMemberSitting(memberSittingId);
		User user = userLocalService.getUser(userId);
		Sitting sitting = sittingLocalService.getSitting(sittingId);
		Member member = memberLocalService.getMember(memberId);
		Date now = new Date(); 
		memberSitting.setMemberId(memberId);
		memberSitting.setSittingId(memberSittingId);
		memberSitting.setCreateDate(now);
		memberSitting.setModifiedDate(now);
		memberSitting.setUserId(userId);
		memberSitting.setUserName(user.getFullName());
		memberSitting.setMemberName(member.getName()+" "+ member.getSurname());
		memberSitting.setSittingName(sitting.getName());
		
		memberSitting = memberSittingPersistence.update(memberSitting);
		
		return memberSitting;
	}
	public MemberSitting removeMemberSitting(long memberSittingId) 
			throws SystemException, PortalException{
		
		MemberSitting memberSitting = getMemberSitting(memberSittingId);
		
		memberSitting = memberSittingPersistence.remove(memberSitting);
		
		return memberSitting;
	}

	public List<MemberSitting> getMembersSittingByGroupId(long groupId, long sittingId, int start, int end) 
			throws SystemException, PortalException{
		
		List<MemberSitting> membersSitting = null;
		
		membersSitting = memberSittingPersistence.findByGroupId_SittingId(groupId, sittingId, start, end);
		
		return membersSitting;
	}
	
	public int contMembersSittingByGroupId(long groupId, long sittingId) 
			throws SystemException, PortalException{
		
		int total = 0;
		
		total = memberSittingPersistence.countByGroupId_SittingId(groupId, sittingId);
		
		return total;
	}

}