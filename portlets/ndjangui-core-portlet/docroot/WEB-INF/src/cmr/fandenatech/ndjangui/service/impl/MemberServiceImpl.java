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
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.service.ServiceContext;

import cmr.fandenatech.ndjangui.model.Member;
import cmr.fandenatech.ndjangui.permission.MemberPermission;
import cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.base.MemberServiceBaseImpl;

/**
 * The implementation of the member remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.MemberService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.MemberServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.MemberServiceUtil
 */
public class MemberServiceImpl extends MemberServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.MemberServiceUtil} to access the member remote service.
	 */

	public Member addMember(long companyId, long groupId, long userId,
							String name, String surname, String email, 
							String cardNumber, String phoneNumber,ServiceContext serviceContext) throws SystemException, PortalException{
		
				return MemberLocalServiceUtil.addMember(companyId, groupId, userId, name,
														surname, email, cardNumber, phoneNumber, serviceContext ) ;
	}
	public Member updateMember(long memberId, long userId,
			String name, String surname, String email,
			String cardNumber, String phoneNumber,ServiceContext serviceContext) throws SystemException, PortalException{

		MemberPermission.check(getPermissionChecker(), memberId, ActionKeys.UPDATE);
		return MemberLocalServiceUtil.updateMember(memberId, userId, name, surname, 
				email, cardNumber, phoneNumber,serviceContext);

	}

	public Member deleteMember(long memberId, long userId,ServiceContext serviceContext) throws SystemException, PortalException{

		MemberPermission.check(getPermissionChecker(), memberId, ActionKeys.DELETE);
		return MemberLocalServiceUtil.deleteMember(memberId, userId,serviceContext);
	}

	public Member activateMember(long memberId, long userId) throws SystemException, PortalException{

		MemberPermission.check(getPermissionChecker(), memberId, ActionKeys.DELETE);
		return MemberLocalServiceUtil.activateMember(memberId, userId);
	}
}