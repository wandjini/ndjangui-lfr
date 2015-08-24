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

import cmr.fandenatech.ndjangui.model.Fund;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Fund in entity cache.
 *
 * @author guyw
 * @see Fund
 * @generated
 */
public class FundCacheModel implements CacheModel<Fund>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{fundId=");
		sb.append(fundId);
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
		sb.append(", budgetPeriodId=");
		sb.append(budgetPeriodId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", shortDescription=");
		sb.append(shortDescription);
		sb.append(", fundTypeId=");
		sb.append(fundTypeId);
		sb.append(", fundType=");
		sb.append(fundType);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Fund toEntityModel() {
		FundImpl fundImpl = new FundImpl();

		fundImpl.setFundId(fundId);
		fundImpl.setUserId(userId);
		fundImpl.setGroupId(groupId);
		fundImpl.setCompanyId(companyId);

		if (userName == null) {
			fundImpl.setUserName(StringPool.BLANK);
		}
		else {
			fundImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			fundImpl.setCreateDate(null);
		}
		else {
			fundImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			fundImpl.setModifiedDate(null);
		}
		else {
			fundImpl.setModifiedDate(new Date(modifiedDate));
		}

		fundImpl.setBudgetPeriodId(budgetPeriodId);

		if (name == null) {
			fundImpl.setName(StringPool.BLANK);
		}
		else {
			fundImpl.setName(name);
		}

		if (shortDescription == null) {
			fundImpl.setShortDescription(StringPool.BLANK);
		}
		else {
			fundImpl.setShortDescription(shortDescription);
		}

		fundImpl.setFundTypeId(fundTypeId);

		if (fundType == null) {
			fundImpl.setFundType(StringPool.BLANK);
		}
		else {
			fundImpl.setFundType(fundType);
		}

		fundImpl.setStatus(status);

		fundImpl.resetOriginalValues();

		return fundImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fundId = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		budgetPeriodId = objectInput.readLong();
		name = objectInput.readUTF();
		shortDescription = objectInput.readUTF();
		fundTypeId = objectInput.readLong();
		fundType = objectInput.readUTF();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(fundId);
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
		objectOutput.writeLong(budgetPeriodId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (shortDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shortDescription);
		}

		objectOutput.writeLong(fundTypeId);

		if (fundType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fundType);
		}

		objectOutput.writeInt(status);
	}

	public long fundId;
	public long userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long budgetPeriodId;
	public String name;
	public String shortDescription;
	public long fundTypeId;
	public String fundType;
	public int status;
}