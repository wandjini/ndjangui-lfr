/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.ndjangui.notificationcenter.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.xpiping.notificationcenter.model.NotificaMessage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NotificaMessage in entity cache.
 *
 * @author marcoleo
 * @see NotificaMessage
 * @generated
 */
public class NotificaMessageCacheModel implements CacheModel<NotificaMessage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{notificaMessageId=");
		sb.append(notificaMessageId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", notificaId=");
		sb.append(notificaId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", entityName=");
		sb.append(entityName);
		sb.append(", queuedEmailId=");
		sb.append(queuedEmailId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NotificaMessage toEntityModel() {
		NotificaMessageImpl notificaMessageImpl = new NotificaMessageImpl();

		notificaMessageImpl.setNotificaMessageId(notificaMessageId);
		notificaMessageImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			notificaMessageImpl.setCreateDate(null);
		}
		else {
			notificaMessageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			notificaMessageImpl.setModifiedDate(null);
		}
		else {
			notificaMessageImpl.setModifiedDate(new Date(modifiedDate));
		}

		notificaMessageImpl.setNotificaId(notificaId);
		notificaMessageImpl.setUserId(userId);
		notificaMessageImpl.setEntityId(entityId);

		if (entityName == null) {
			notificaMessageImpl.setEntityName(StringPool.BLANK);
		}
		else {
			notificaMessageImpl.setEntityName(entityName);
		}

		notificaMessageImpl.setQueuedEmailId(queuedEmailId);

		notificaMessageImpl.resetOriginalValues();

		return notificaMessageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		notificaMessageId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		notificaId = objectInput.readLong();
		userId = objectInput.readLong();
		entityId = objectInput.readLong();
		entityName = objectInput.readUTF();
		queuedEmailId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(notificaMessageId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(notificaId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(entityId);

		if (entityName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entityName);
		}

		objectOutput.writeLong(queuedEmailId);
	}

	public long notificaMessageId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long notificaId;
	public long userId;
	public long entityId;
	public String entityName;
	public long queuedEmailId;
}