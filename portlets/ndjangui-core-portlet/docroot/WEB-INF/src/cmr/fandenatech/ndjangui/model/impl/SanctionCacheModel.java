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

import cmr.fandenatech.ndjangui.model.Sanction;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Sanction in entity cache.
 *
 * @author guyw
 * @see Sanction
 * @generated
 */
public class SanctionCacheModel implements CacheModel<Sanction>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{sanctionId=");
		sb.append(sanctionId);
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
		sb.append(", budgetPeriodId=");
		sb.append(budgetPeriodId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", shortDescription=");
		sb.append(shortDescription);
		sb.append(", sanctionTypeId=");
		sb.append(sanctionTypeId);
		sb.append(", sittingId=");
		sb.append(sittingId);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", status=");
		sb.append(status);
		sb.append(", srcFundClassPK=");
		sb.append(srcFundClassPK);
		sb.append(", srcFundClassName=");
		sb.append(srcFundClassName);
		sb.append(", destFundClassPK=");
		sb.append(destFundClassPK);
		sb.append(", destFundClassName=");
		sb.append(destFundClassName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Sanction toEntityModel() {
		SanctionImpl sanctionImpl = new SanctionImpl();

		sanctionImpl.setSanctionId(sanctionId);
		sanctionImpl.setUserId(userId);
		sanctionImpl.setGroupId(groupId);
		sanctionImpl.setCompanyId(companyId);

		if (userName == null) {
			sanctionImpl.setUserName(StringPool.BLANK);
		}
		else {
			sanctionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sanctionImpl.setCreateDate(null);
		}
		else {
			sanctionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sanctionImpl.setModifiedDate(null);
		}
		else {
			sanctionImpl.setModifiedDate(new Date(modifiedDate));
		}

		sanctionImpl.setMemberId(memberId);
		sanctionImpl.setBudgetPeriodId(budgetPeriodId);

		if (name == null) {
			sanctionImpl.setName(StringPool.BLANK);
		}
		else {
			sanctionImpl.setName(name);
		}

		if (shortDescription == null) {
			sanctionImpl.setShortDescription(StringPool.BLANK);
		}
		else {
			sanctionImpl.setShortDescription(shortDescription);
		}

		sanctionImpl.setSanctionTypeId(sanctionTypeId);
		sanctionImpl.setSittingId(sittingId);
		sanctionImpl.setAmount(amount);
		sanctionImpl.setStatus(status);
		sanctionImpl.setSrcFundClassPK(srcFundClassPK);

		if (srcFundClassName == null) {
			sanctionImpl.setSrcFundClassName(StringPool.BLANK);
		}
		else {
			sanctionImpl.setSrcFundClassName(srcFundClassName);
		}

		sanctionImpl.setDestFundClassPK(destFundClassPK);

		if (destFundClassName == null) {
			sanctionImpl.setDestFundClassName(StringPool.BLANK);
		}
		else {
			sanctionImpl.setDestFundClassName(destFundClassName);
		}

		sanctionImpl.resetOriginalValues();

		return sanctionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sanctionId = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		memberId = objectInput.readLong();
		budgetPeriodId = objectInput.readLong();
		name = objectInput.readUTF();
		shortDescription = objectInput.readUTF();
		sanctionTypeId = objectInput.readLong();
		sittingId = objectInput.readLong();
		amount = objectInput.readDouble();
		status = objectInput.readInt();
		srcFundClassPK = objectInput.readLong();
		srcFundClassName = objectInput.readUTF();
		destFundClassPK = objectInput.readLong();
		destFundClassName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(sanctionId);
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

		objectOutput.writeLong(sanctionTypeId);
		objectOutput.writeLong(sittingId);
		objectOutput.writeDouble(amount);
		objectOutput.writeInt(status);
		objectOutput.writeLong(srcFundClassPK);

		if (srcFundClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(srcFundClassName);
		}

		objectOutput.writeLong(destFundClassPK);

		if (destFundClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(destFundClassName);
		}
	}

	public long sanctionId;
	public long userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long memberId;
	public long budgetPeriodId;
	public String name;
	public String shortDescription;
	public long sanctionTypeId;
	public long sittingId;
	public double amount;
	public int status;
	public long srcFundClassPK;
	public String srcFundClassName;
	public long destFundClassPK;
	public String destFundClassName;
}