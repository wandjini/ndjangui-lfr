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

package cmr.fandenatech.ndjangui.model.impl;

import cmr.fandenatech.ndjangui.model.MemberSitting;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MemberSitting in entity cache.
 *
 * @author guyw
 * @see MemberSitting
 * @generated
 */
public class MemberSittingCacheModel implements CacheModel<MemberSitting>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{memberSittingId=");
		sb.append(memberSittingId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", memberId=");
		sb.append(memberId);
		sb.append(", sittingId=");
		sb.append(sittingId);
		sb.append(", memberName=");
		sb.append(memberName);
		sb.append(", sittingName=");
		sb.append(sittingName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MemberSitting toEntityModel() {
		MemberSittingImpl memberSittingImpl = new MemberSittingImpl();

		memberSittingImpl.setMemberSittingId(memberSittingId);
		memberSittingImpl.setUserId(userId);
		memberSittingImpl.setGroupId(groupId);
		memberSittingImpl.setCompanyId(companyId);

		if (userName == null) {
			memberSittingImpl.setUserName(StringPool.BLANK);
		}
		else {
			memberSittingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			memberSittingImpl.setCreateDate(null);
		}
		else {
			memberSittingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			memberSittingImpl.setModifiedDate(null);
		}
		else {
			memberSittingImpl.setModifiedDate(new Date(modifiedDate));
		}

		memberSittingImpl.setMemberId(memberId);
		memberSittingImpl.setSittingId(sittingId);

		if (memberName == null) {
			memberSittingImpl.setMemberName(StringPool.BLANK);
		}
		else {
			memberSittingImpl.setMemberName(memberName);
		}

		if (sittingName == null) {
			memberSittingImpl.setSittingName(StringPool.BLANK);
		}
		else {
			memberSittingImpl.setSittingName(sittingName);
		}

		memberSittingImpl.resetOriginalValues();

		return memberSittingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		memberSittingId = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		memberId = objectInput.readLong();
		sittingId = objectInput.readLong();
		memberName = objectInput.readUTF();
		sittingName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(memberSittingId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(memberId);
		objectOutput.writeLong(sittingId);

		if (memberName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(memberName);
		}

		if (sittingName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sittingName);
		}
	}

	public long memberSittingId;
	public long userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long memberId;
	public long sittingId;
	public String memberName;
	public String sittingName;
}