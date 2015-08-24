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

import cmr.fandenatech.ndjangui.model.Sitting;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Sitting in entity cache.
 *
 * @author guyw
 * @see Sitting
 * @generated
 */
public class SittingCacheModel implements CacheModel<Sitting>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{sittingId=");
		sb.append(sittingId);
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
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", startHour=");
		sb.append(startHour);
		sb.append(", startMin=");
		sb.append(startMin);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", endHour=");
		sb.append(endHour);
		sb.append(", endMin=");
		sb.append(endMin);
		sb.append(", budgetPeriodId=");
		sb.append(budgetPeriodId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", dayPlan=");
		sb.append(dayPlan);
		sb.append(", notes=");
		sb.append(notes);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Sitting toEntityModel() {
		SittingImpl sittingImpl = new SittingImpl();

		sittingImpl.setSittingId(sittingId);
		sittingImpl.setUserId(userId);
		sittingImpl.setGroupId(groupId);
		sittingImpl.setCompanyId(companyId);

		if (userName == null) {
			sittingImpl.setUserName(StringPool.BLANK);
		}
		else {
			sittingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sittingImpl.setCreateDate(null);
		}
		else {
			sittingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sittingImpl.setModifiedDate(null);
		}
		else {
			sittingImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (startDate == Long.MIN_VALUE) {
			sittingImpl.setStartDate(null);
		}
		else {
			sittingImpl.setStartDate(new Date(startDate));
		}

		sittingImpl.setStartHour(startHour);
		sittingImpl.setStartMin(startMin);

		if (endDate == Long.MIN_VALUE) {
			sittingImpl.setEndDate(null);
		}
		else {
			sittingImpl.setEndDate(new Date(endDate));
		}

		sittingImpl.setEndHour(endHour);
		sittingImpl.setEndMin(endMin);
		sittingImpl.setBudgetPeriodId(budgetPeriodId);

		if (name == null) {
			sittingImpl.setName(StringPool.BLANK);
		}
		else {
			sittingImpl.setName(name);
		}

		if (dayPlan == null) {
			sittingImpl.setDayPlan(StringPool.BLANK);
		}
		else {
			sittingImpl.setDayPlan(dayPlan);
		}

		if (notes == null) {
			sittingImpl.setNotes(StringPool.BLANK);
		}
		else {
			sittingImpl.setNotes(notes);
		}

		sittingImpl.setStatus(status);

		sittingImpl.resetOriginalValues();

		return sittingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sittingId = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		startDate = objectInput.readLong();
		startHour = objectInput.readInt();
		startMin = objectInput.readInt();
		endDate = objectInput.readLong();
		endHour = objectInput.readInt();
		endMin = objectInput.readInt();
		budgetPeriodId = objectInput.readLong();
		name = objectInput.readUTF();
		dayPlan = objectInput.readUTF();
		notes = objectInput.readUTF();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(sittingId);
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
		objectOutput.writeLong(startDate);
		objectOutput.writeInt(startHour);
		objectOutput.writeInt(startMin);
		objectOutput.writeLong(endDate);
		objectOutput.writeInt(endHour);
		objectOutput.writeInt(endMin);
		objectOutput.writeLong(budgetPeriodId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (dayPlan == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dayPlan);
		}

		if (notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes);
		}

		objectOutput.writeInt(status);
	}

	public long sittingId;
	public long userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long startDate;
	public int startHour;
	public int startMin;
	public long endDate;
	public int endHour;
	public int endMin;
	public long budgetPeriodId;
	public String name;
	public String dayPlan;
	public String notes;
	public int status;
}