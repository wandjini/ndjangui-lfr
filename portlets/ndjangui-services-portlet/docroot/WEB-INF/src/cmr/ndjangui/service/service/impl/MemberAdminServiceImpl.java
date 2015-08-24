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

package cmr.ndjangui.service.service.impl;

import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import cmr.fandenatech.ndjangui.model.Member;
import cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil;
import cmr.ndjangui.service.service.base.MemberAdminServiceBaseImpl;

/**
 * The implementation of the member admin remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.ndjangui.service.service.MemberAdminService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guyw
 * @see cmr.ndjangui.service.service.base.MemberAdminServiceBaseImpl
 * @see cmr.ndjangui.service.service.MemberAdminServiceUtil
 */
@JSONWebService
public class MemberAdminServiceImpl extends MemberAdminServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.ndjangui.service.service.MemberAdminServiceUtil} to access the member admin remote service.
	 */

	
	public JSONObject getGroupMembers(long groupId, long userId, int start, int end){
		
		JSONObject retObject = JSONFactoryUtil.createJSONObject();
		JSONArray arr = JSONFactoryUtil.createJSONArray();
		int total = 0;
		try {
			List<Member> members = MemberLocalServiceUtil.getMembersByGroupId(groupId, start, end);
			for(Member member:members)
				arr.put(getMemberJSONObject(member));
			total = MemberLocalServiceUtil.countMembersByGroupId(groupId);
 		} catch (Exception e) {
			retObject = null;
		}
		retObject.put("results", arr);
		retObject.put("total",total);
		return retObject;
	}
	
	private JSONObject getMemberJSONObject(Member member){
		JSONObject memberJSON = JSONFactoryUtil.createJSONObject();
		
		memberJSON.put("memberId", member.getMemberId());
		memberJSON.put("name", member.getName());
		memberJSON.put("surname", member.getSurname());
		memberJSON.put("email", member.getEmail());
		memberJSON.put("phoneNumber", member.getPhoneNumber());
		memberJSON.put("status", member.getStatus());
		
		return memberJSON;
	}

}