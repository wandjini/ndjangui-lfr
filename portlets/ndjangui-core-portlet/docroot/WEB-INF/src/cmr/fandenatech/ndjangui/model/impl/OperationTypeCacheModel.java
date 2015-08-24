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

import cmr.fandenatech.ndjangui.model.OperationType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OperationType in entity cache.
 *
 * @author guyw
 * @see OperationType
 * @generated
 */
public class OperationTypeCacheModel implements CacheModel<OperationType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{operationTypeId=");
		sb.append(operationTypeId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OperationType toEntityModel() {
		OperationTypeImpl operationTypeImpl = new OperationTypeImpl();

		operationTypeImpl.setOperationTypeId(operationTypeId);
		operationTypeImpl.setUserId(userId);
		operationTypeImpl.setGroupId(groupId);
		operationTypeImpl.setCompanyId(companyId);

		if (userName == null) {
			operationTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			operationTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			operationTypeImpl.setCreateDate(null);
		}
		else {
			operationTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			operationTypeImpl.setModifiedDate(null);
		}
		else {
			operationTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			operationTypeImpl.setName(StringPool.BLANK);
		}
		else {
			operationTypeImpl.setName(name);
		}

		if (shortDescription == null) {
			operationTypeImpl.setShortDescription(StringPool.BLANK);
		}
		else {
			operationTypeImpl.setShortDescription(shortDescription);
		}

		operationTypeImpl.setStatus(status);

		operationTypeImpl.resetOriginalValues();

		return operationTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		operationTypeId = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		shortDescription = objectInput.readUTF();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(operationTypeId);
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

		objectOutput.writeInt(status);
	}

	public long operationTypeId;
	public long userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String shortDescription;
	public int status;
}