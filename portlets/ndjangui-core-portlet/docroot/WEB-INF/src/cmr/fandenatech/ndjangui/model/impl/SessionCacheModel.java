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

import cmr.fandenatech.ndjangui.model.Session;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Session in entity cache.
 *
 * @author guyw
 * @see Session
 * @generated
 */
public class SessionCacheModel implements CacheModel<Session>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{sessionId=");
		sb.append(sessionId);
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
		sb.append(", notes=");
		sb.append(notes);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Session toEntityModel() {
		SessionImpl sessionImpl = new SessionImpl();

		sessionImpl.setSessionId(sessionId);
		sessionImpl.setUserId(userId);
		sessionImpl.setGroupId(groupId);
		sessionImpl.setCompanyId(companyId);

		if (userName == null) {
			sessionImpl.setUserName(StringPool.BLANK);
		}
		else {
			sessionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sessionImpl.setCreateDate(null);
		}
		else {
			sessionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sessionImpl.setModifiedDate(null);
		}
		else {
			sessionImpl.setModifiedDate(new Date(modifiedDate));
		}

		sessionImpl.setBudgetPeriodId(budgetPeriodId);

		if (name == null) {
			sessionImpl.setName(StringPool.BLANK);
		}
		else {
			sessionImpl.setName(name);
		}

		if (notes == null) {
			sessionImpl.setNotes(StringPool.BLANK);
		}
		else {
			sessionImpl.setNotes(notes);
		}

		sessionImpl.setStatus(status);

		sessionImpl.resetOriginalValues();

		return sessionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sessionId = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		budgetPeriodId = objectInput.readLong();
		name = objectInput.readUTF();
		notes = objectInput.readUTF();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(sessionId);
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

		if (notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes);
		}

		objectOutput.writeInt(status);
	}

	public long sessionId;
	public long userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long budgetPeriodId;
	public String name;
	public String notes;
	public int status;
}