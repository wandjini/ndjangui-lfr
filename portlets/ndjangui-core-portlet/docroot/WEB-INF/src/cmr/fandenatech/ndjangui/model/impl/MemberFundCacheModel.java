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

import cmr.fandenatech.ndjangui.model.MemberFund;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MemberFund in entity cache.
 *
 * @author guyw
 * @see MemberFund
 * @generated
 */
public class MemberFundCacheModel implements CacheModel<MemberFund>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{memberFundId=");
		sb.append(memberFundId);
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
		sb.append(", fundId=");
		sb.append(fundId);
		sb.append(", memberName=");
		sb.append(memberName);
		sb.append(", fundName=");
		sb.append(fundName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MemberFund toEntityModel() {
		MemberFundImpl memberFundImpl = new MemberFundImpl();

		memberFundImpl.setMemberFundId(memberFundId);
		memberFundImpl.setUserId(userId);
		memberFundImpl.setGroupId(groupId);
		memberFundImpl.setCompanyId(companyId);

		if (userName == null) {
			memberFundImpl.setUserName(StringPool.BLANK);
		}
		else {
			memberFundImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			memberFundImpl.setCreateDate(null);
		}
		else {
			memberFundImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			memberFundImpl.setModifiedDate(null);
		}
		else {
			memberFundImpl.setModifiedDate(new Date(modifiedDate));
		}

		memberFundImpl.setMemberId(memberId);
		memberFundImpl.setFundId(fundId);

		if (memberName == null) {
			memberFundImpl.setMemberName(StringPool.BLANK);
		}
		else {
			memberFundImpl.setMemberName(memberName);
		}

		if (fundName == null) {
			memberFundImpl.setFundName(StringPool.BLANK);
		}
		else {
			memberFundImpl.setFundName(fundName);
		}

		memberFundImpl.resetOriginalValues();

		return memberFundImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		memberFundId = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		memberId = objectInput.readLong();
		fundId = objectInput.readLong();
		memberName = objectInput.readUTF();
		fundName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(memberFundId);
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
		objectOutput.writeLong(fundId);

		if (memberName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(memberName);
		}

		if (fundName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fundName);
		}
	}

	public long memberFundId;
	public long userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long memberId;
	public long fundId;
	public String memberName;
	public String fundName;
}