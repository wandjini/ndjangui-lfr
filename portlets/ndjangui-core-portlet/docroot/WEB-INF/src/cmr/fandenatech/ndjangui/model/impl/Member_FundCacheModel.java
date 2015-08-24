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

import cmr.fandenatech.ndjangui.model.Member_Fund;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Member_Fund in entity cache.
 *
 * @author guyw
 * @see Member_Fund
 * @generated
 */
public class Member_FundCacheModel implements CacheModel<Member_Fund>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{memberFundId=");
		sb.append(memberFundId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", memberId=");
		sb.append(memberId);
		sb.append(", fundId=");
		sb.append(fundId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Member_Fund toEntityModel() {
		Member_FundImpl member_FundImpl = new Member_FundImpl();

		member_FundImpl.setMemberFundId(memberFundId);

		if (createDate == Long.MIN_VALUE) {
			member_FundImpl.setCreateDate(null);
		}
		else {
			member_FundImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			member_FundImpl.setModifiedDate(null);
		}
		else {
			member_FundImpl.setModifiedDate(new Date(modifiedDate));
		}

		member_FundImpl.setMemberId(memberId);
		member_FundImpl.setFundId(fundId);

		member_FundImpl.resetOriginalValues();

		return member_FundImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		memberFundId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		memberId = objectInput.readLong();
		fundId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(memberFundId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(memberId);
		objectOutput.writeLong(fundId);
	}

	public long memberFundId;
	public long createDate;
	public long modifiedDate;
	public long memberId;
	public long fundId;
}