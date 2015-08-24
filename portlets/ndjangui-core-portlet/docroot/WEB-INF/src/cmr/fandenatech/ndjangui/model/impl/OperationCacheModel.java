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

import cmr.fandenatech.ndjangui.model.Operation;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Operation in entity cache.
 *
 * @author guyw
 * @see Operation
 * @generated
 */
public class OperationCacheModel implements CacheModel<Operation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{operationId=");
		sb.append(operationId);
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
		sb.append(", operationTypeId=");
		sb.append(operationTypeId);
		sb.append(", sittingId=");
		sb.append(sittingId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", amount=");
		sb.append(amount);
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
	public Operation toEntityModel() {
		OperationImpl operationImpl = new OperationImpl();

		operationImpl.setOperationId(operationId);
		operationImpl.setUserId(userId);
		operationImpl.setGroupId(groupId);
		operationImpl.setCompanyId(companyId);

		if (userName == null) {
			operationImpl.setUserName(StringPool.BLANK);
		}
		else {
			operationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			operationImpl.setCreateDate(null);
		}
		else {
			operationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			operationImpl.setModifiedDate(null);
		}
		else {
			operationImpl.setModifiedDate(new Date(modifiedDate));
		}

		operationImpl.setBudgetPeriodId(budgetPeriodId);

		if (name == null) {
			operationImpl.setName(StringPool.BLANK);
		}
		else {
			operationImpl.setName(name);
		}

		if (shortDescription == null) {
			operationImpl.setShortDescription(StringPool.BLANK);
		}
		else {
			operationImpl.setShortDescription(shortDescription);
		}

		operationImpl.setOperationTypeId(operationTypeId);
		operationImpl.setSittingId(sittingId);
		operationImpl.setStatus(status);
		operationImpl.setAmount(amount);
		operationImpl.setSrcFundClassPK(srcFundClassPK);

		if (srcFundClassName == null) {
			operationImpl.setSrcFundClassName(StringPool.BLANK);
		}
		else {
			operationImpl.setSrcFundClassName(srcFundClassName);
		}

		operationImpl.setDestFundClassPK(destFundClassPK);

		if (destFundClassName == null) {
			operationImpl.setDestFundClassName(StringPool.BLANK);
		}
		else {
			operationImpl.setDestFundClassName(destFundClassName);
		}

		operationImpl.resetOriginalValues();

		return operationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		operationId = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		budgetPeriodId = objectInput.readLong();
		name = objectInput.readUTF();
		shortDescription = objectInput.readUTF();
		operationTypeId = objectInput.readLong();
		sittingId = objectInput.readLong();
		status = objectInput.readInt();
		amount = objectInput.readDouble();
		srcFundClassPK = objectInput.readLong();
		srcFundClassName = objectInput.readUTF();
		destFundClassPK = objectInput.readLong();
		destFundClassName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(operationId);
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

		objectOutput.writeLong(operationTypeId);
		objectOutput.writeLong(sittingId);
		objectOutput.writeInt(status);
		objectOutput.writeDouble(amount);
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

	public long operationId;
	public long userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long budgetPeriodId;
	public String name;
	public String shortDescription;
	public long operationTypeId;
	public long sittingId;
	public int status;
	public double amount;
	public long srcFundClassPK;
	public String srcFundClassName;
	public long destFundClassPK;
	public String destFundClassName;
}