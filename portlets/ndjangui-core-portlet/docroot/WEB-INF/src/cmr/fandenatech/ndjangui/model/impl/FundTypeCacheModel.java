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

import cmr.fandenatech.ndjangui.model.FundType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FundType in entity cache.
 *
 * @author guyw
 * @see FundType
 * @generated
 */
public class FundTypeCacheModel implements CacheModel<FundType>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{fundTypeId=");
		sb.append(fundTypeId);
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
	public FundType toEntityModel() {
		FundTypeImpl fundTypeImpl = new FundTypeImpl();

		fundTypeImpl.setFundTypeId(fundTypeId);
		fundTypeImpl.setUserId(userId);
		fundTypeImpl.setGroupId(groupId);
		fundTypeImpl.setCompanyId(companyId);

		if (userName == null) {
			fundTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			fundTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			fundTypeImpl.setCreateDate(null);
		}
		else {
			fundTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			fundTypeImpl.setModifiedDate(null);
		}
		else {
			fundTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			fundTypeImpl.setName(StringPool.BLANK);
		}
		else {
			fundTypeImpl.setName(name);
		}

		if (shortDescription == null) {
			fundTypeImpl.setShortDescription(StringPool.BLANK);
		}
		else {
			fundTypeImpl.setShortDescription(shortDescription);
		}

		fundTypeImpl.setStatus(status);

		fundTypeImpl.resetOriginalValues();

		return fundTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fundTypeId = objectInput.readLong();
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
		objectOutput.writeLong(fundTypeId);
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

	public long fundTypeId;
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