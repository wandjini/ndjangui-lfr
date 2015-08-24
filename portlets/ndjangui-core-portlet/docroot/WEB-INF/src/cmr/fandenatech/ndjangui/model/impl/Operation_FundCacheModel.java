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

import cmr.fandenatech.ndjangui.model.Operation_Fund;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Operation_Fund in entity cache.
 *
 * @author guyw
 * @see Operation_Fund
 * @generated
 */
public class Operation_FundCacheModel implements CacheModel<Operation_Fund>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{operationFundId=");
		sb.append(operationFundId);
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
		sb.append(", operationId=");
		sb.append(operationId);
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
	public Operation_Fund toEntityModel() {
		Operation_FundImpl operation_FundImpl = new Operation_FundImpl();

		operation_FundImpl.setOperationFundId(operationFundId);
		operation_FundImpl.setUserId(userId);
		operation_FundImpl.setGroupId(groupId);
		operation_FundImpl.setCompanyId(companyId);

		if (userName == null) {
			operation_FundImpl.setUserName(StringPool.BLANK);
		}
		else {
			operation_FundImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			operation_FundImpl.setCreateDate(null);
		}
		else {
			operation_FundImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			operation_FundImpl.setModifiedDate(null);
		}
		else {
			operation_FundImpl.setModifiedDate(new Date(modifiedDate));
		}

		operation_FundImpl.setOperationId(operationId);
		operation_FundImpl.setSrcFundClassPK(srcFundClassPK);

		if (srcFundClassName == null) {
			operation_FundImpl.setSrcFundClassName(StringPool.BLANK);
		}
		else {
			operation_FundImpl.setSrcFundClassName(srcFundClassName);
		}

		operation_FundImpl.setDestFundClassPK(destFundClassPK);

		if (destFundClassName == null) {
			operation_FundImpl.setDestFundClassName(StringPool.BLANK);
		}
		else {
			operation_FundImpl.setDestFundClassName(destFundClassName);
		}

		operation_FundImpl.resetOriginalValues();

		return operation_FundImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		operationFundId = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		operationId = objectInput.readLong();
		srcFundClassPK = objectInput.readLong();
		srcFundClassName = objectInput.readUTF();
		destFundClassPK = objectInput.readLong();
		destFundClassName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(operationFundId);
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
		objectOutput.writeLong(operationId);
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

	public long operationFundId;
	public long userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long operationId;
	public long srcFundClassPK;
	public String srcFundClassName;
	public long destFundClassPK;
	public String destFundClassName;
}