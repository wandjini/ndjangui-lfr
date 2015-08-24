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

import cmr.fandenatech.ndjangui.model.SanctionType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SanctionType in entity cache.
 *
 * @author guyw
 * @see SanctionType
 * @generated
 */
public class SanctionTypeCacheModel implements CacheModel<SanctionType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{sanctionTypeId=");
		sb.append(sanctionTypeId);
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
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SanctionType toEntityModel() {
		SanctionTypeImpl sanctionTypeImpl = new SanctionTypeImpl();

		sanctionTypeImpl.setSanctionTypeId(sanctionTypeId);
		sanctionTypeImpl.setUserId(userId);
		sanctionTypeImpl.setGroupId(groupId);
		sanctionTypeImpl.setCompanyId(companyId);

		if (userName == null) {
			sanctionTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			sanctionTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sanctionTypeImpl.setCreateDate(null);
		}
		else {
			sanctionTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sanctionTypeImpl.setModifiedDate(null);
		}
		else {
			sanctionTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			sanctionTypeImpl.setName(StringPool.BLANK);
		}
		else {
			sanctionTypeImpl.setName(name);
		}

		if (shortDescription == null) {
			sanctionTypeImpl.setShortDescription(StringPool.BLANK);
		}
		else {
			sanctionTypeImpl.setShortDescription(shortDescription);
		}

		sanctionTypeImpl.setAmount(amount);
		sanctionTypeImpl.setStatus(status);

		sanctionTypeImpl.resetOriginalValues();

		return sanctionTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sanctionTypeId = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		shortDescription = objectInput.readUTF();
		amount = objectInput.readDouble();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(sanctionTypeId);
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

		objectOutput.writeDouble(amount);
		objectOutput.writeInt(status);
	}

	public long sanctionTypeId;
	public long userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String shortDescription;
	public double amount;
	public int status;
}