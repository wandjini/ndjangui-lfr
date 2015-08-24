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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import cmr.fandenatech.ndjangui.model.Fund;
import cmr.fandenatech.ndjangui.model.Member;
import cmr.fandenatech.ndjangui.model.MemberFund;
import cmr.fandenatech.ndjangui.service.base.MemberFundLocalServiceBaseImpl;

/**
 * The implementation of the member fund local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.MemberFundLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.MemberFundLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.MemberFundLocalServiceUtil
 */
public class MemberFundLocalServiceImpl extends MemberFundLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.MemberFundLocalServiceUtil} to access the member fund local service.
	 */

	public MemberFund addMemberFund(long groupId, long userId, 
			long memberId, long fundId) throws SystemException, PortalException{
		
		long memberFundId = counterLocalService.increment(MemberFund.class.getName());
		MemberFund memberFund = memberFundPersistence.create(memberFundId);
		User user = userLocalService.getUser(userId);
		Fund fund = fundLocalService.getFund(fundId);
		Member member = memberLocalService.getMember(memberId);
		Date now = new Date(); 
		memberFund.setMemberId(memberId);
		memberFund.setFundId(fundId);
		memberFund.setCreateDate(now);
		memberFund.setModifiedDate(now);
		memberFund.setUserId(userId);
		memberFund.setUserName(user.getFullName());
		memberFund.setMemberName(member.getName()+" "+ member.getSurname());
		memberFund.setFundName(fund.getName());
		memberFund.setGroupId(groupId);
		
		memberFund = memberFundPersistence.update(memberFund);
		
		return memberFund;
	}
	
	public MemberFund updateMemberFund(long memberFundId, long userId, 
			long memberId, long fundId) throws SystemException, PortalException{
		
		MemberFund memberFund = getMemberFund(memberFundId);
		User user = userLocalService.getUser(userId);
		Fund fund = fundLocalService.getFund(fundId);
		Member member = memberLocalService.getMember(memberId);
		Date now = new Date(); 
		memberFund.setMemberId(memberId);
		memberFund.setFundId(memberFundId);
		memberFund.setCreateDate(now);
		memberFund.setModifiedDate(now);
		memberFund.setUserId(userId);
		memberFund.setUserName(user.getFullName());
		memberFund.setMemberName(member.getName()+" "+ member.getSurname());
		memberFund.setFundName(fund.getName());
		
		memberFund = memberFundPersistence.update(memberFund);
		
		return memberFund;
	}
	public MemberFund removeMemberFund(long memberFundId) 
			throws SystemException, PortalException{
		
		MemberFund memberFund = getMemberFund(memberFundId);
		
		memberFund = memberFundPersistence.remove(memberFund);
		
		return memberFund;
	}


}