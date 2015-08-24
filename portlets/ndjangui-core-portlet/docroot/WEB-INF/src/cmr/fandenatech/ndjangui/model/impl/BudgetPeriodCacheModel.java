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

import cmr.fandenatech.ndjangui.model.BudgetPeriod;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BudgetPeriod in entity cache.
 *
 * @author guyw
 * @see BudgetPeriod
 * @generated
 */
public class BudgetPeriodCacheModel implements CacheModel<BudgetPeriod>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{budgetPeriodId=");
		sb.append(budgetPeriodId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", shortDescription=");
		sb.append(shortDescription);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BudgetPeriod toEntityModel() {
		BudgetPeriodImpl budgetPeriodImpl = new BudgetPeriodImpl();

		budgetPeriodImpl.setBudgetPeriodId(budgetPeriodId);
		budgetPeriodImpl.setUserId(userId);
		budgetPeriodImpl.setGroupId(groupId);
		budgetPeriodImpl.setCompanyId(companyId);

		if (userName == null) {
			budgetPeriodImpl.setUserName(StringPool.BLANK);
		}
		else {
			budgetPeriodImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			budgetPeriodImpl.setCreateDate(null);
		}
		else {
			budgetPeriodImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			budgetPeriodImpl.setModifiedDate(null);
		}
		else {
			budgetPeriodImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			budgetPeriodImpl.setName(StringPool.BLANK);
		}
		else {
			budgetPeriodImpl.setName(name);
		}

		if (shortDescription == null) {
			budgetPeriodImpl.setShortDescription(StringPool.BLANK);
		}
		else {
			budgetPeriodImpl.setShortDescription(shortDescription);
		}

		if (startDate == Long.MIN_VALUE) {
			budgetPeriodImpl.setStartDate(null);
		}
		else {
			budgetPeriodImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			budgetPeriodImpl.setEndDate(null);
		}
		else {
			budgetPeriodImpl.setEndDate(new Date(endDate));
		}

		budgetPeriodImpl.setStatus(status);

		budgetPeriodImpl.resetOriginalValues();

		return budgetPeriodImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		budgetPeriodId = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		shortDescription = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(budgetPeriodId);
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

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeInt(status);
	}

	public long budgetPeriodId;
	public long userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String shortDescription;
	public long startDate;
	public long endDate;
	public int status;
}