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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;

import cmr.fandenatech.ndjangui.model.MemberSitting;
import cmr.fandenatech.ndjangui.model.Sitting;
import cmr.fandenatech.ndjangui.permission.SittingPermission;
import cmr.fandenatech.ndjangui.service.MemberSittingLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.SittingLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.base.SittingServiceBaseImpl;

/**
 * The implementation of the sitting remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.SittingService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.SittingServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.SittingServiceUtil
 */
public class SittingServiceImpl extends SittingServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.SittingServiceUtil} to access the sitting remote service.
	 */
	public Sitting addSitting(long groupId,long userId, String name,
			String dayPlan, String notes, ServiceContext serviceContext ) 
					throws PortalException, SystemException{
		return SittingLocalServiceUtil.addSitting(groupId, userId, name,
				 dayPlan, notes,serviceContext);
	
	}
	
	public Sitting updateSitting(long userId, long sittingId, String name,
			String dayPlan, String notes) 
					throws PortalException, SystemException{
		SittingPermission.check(getPermissionChecker(), sittingId, ActionKeys.UPDATE);
		return SittingLocalServiceUtil.updateSitting(userId, sittingId, name, dayPlan, notes);
	}
	
	public Sitting updateSittingStatus(long userId, long sittingId, int status) 
			throws PortalException, SystemException{
		SittingPermission.check(getPermissionChecker(), sittingId, ActionKeys.UPDATE);
		return SittingLocalServiceUtil.updateSittingStatus(userId, sittingId, status);
	}
	
	public Sitting openSitting(long userId, long sittingId) 
			throws PortalException, SystemException{
		SittingPermission.check(getPermissionChecker(), sittingId, ActionKeys.UPDATE);
		return SittingLocalServiceUtil.openSitting(userId, sittingId);
	}

	public Sitting closeSitting(long userId, long sittingId) 
			throws PortalException, SystemException{
		SittingPermission.check(getPermissionChecker(), sittingId, ActionKeys.UPDATE);
		return SittingLocalServiceUtil.closeSitting(userId, sittingId);
	}

	public MemberSitting addMemberSitting(long groupId, long userId, 
			long sittingId, long memberId) 
			throws PortalException, SystemException{
		SittingPermission.check(getPermissionChecker(), sittingId, ActionKeys.UPDATE);
		return MemberSittingLocalServiceUtil.addMemberSitting(groupId,userId, sittingId, memberId);
	}
	public Sitting removeSitting(long sittingId) 
			throws PortalException, SystemException{
		SittingPermission.check(getPermissionChecker(), sittingId, ActionKeys.UPDATE);
		return SittingLocalServiceUtil.deleteSitting(sittingId);
	}

	public MemberSitting removeMemberSitting(long sittingId, long memberSittingId) 
			throws PortalException, SystemException{
		SittingPermission.check(getPermissionChecker(), sittingId, ActionKeys.UPDATE);
		return MemberSittingLocalServiceUtil.removeMemberSitting(memberSittingId);
	}

}