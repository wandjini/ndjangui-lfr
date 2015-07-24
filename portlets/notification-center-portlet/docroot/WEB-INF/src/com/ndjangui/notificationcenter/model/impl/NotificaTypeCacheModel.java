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

import com.xpiping.notificationcenter.model.NotificaType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NotificaType in entity cache.
 *
 * @author marcoleo
 * @see NotificaType
 * @generated
 */
public class NotificaTypeCacheModel implements CacheModel<NotificaType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{notificaTypeId=");
		sb.append(notificaTypeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", messageDestination=");
		sb.append(messageDestination);
		sb.append(", description=");
		sb.append(description);
		sb.append(", placeHolders=");
		sb.append(placeHolders);
		sb.append(", aviable=");
		sb.append(aviable);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NotificaType toEntityModel() {
		NotificaTypeImpl notificaTypeImpl = new NotificaTypeImpl();

		notificaTypeImpl.setNotificaTypeId(notificaTypeId);
		notificaTypeImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			notificaTypeImpl.setCreateDate(null);
		}
		else {
			notificaTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			notificaTypeImpl.setModifiedDate(null);
		}
		else {
			notificaTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			notificaTypeImpl.setName(StringPool.BLANK);
		}
		else {
			notificaTypeImpl.setName(name);
		}

		if (messageDestination == null) {
			notificaTypeImpl.setMessageDestination(StringPool.BLANK);
		}
		else {
			notificaTypeImpl.setMessageDestination(messageDestination);
		}

		if (description == null) {
			notificaTypeImpl.setDescription(StringPool.BLANK);
		}
		else {
			notificaTypeImpl.setDescription(description);
		}

		if (placeHolders == null) {
			notificaTypeImpl.setPlaceHolders(StringPool.BLANK);
		}
		else {
			notificaTypeImpl.setPlaceHolders(placeHolders);
		}

		notificaTypeImpl.setAviable(aviable);

		notificaTypeImpl.resetOriginalValues();

		return notificaTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		notificaTypeId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		messageDestination = objectInput.readUTF();
		description = objectInput.readUTF();
		placeHolders = objectInput.readUTF();
		aviable = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(notificaTypeId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (messageDestination == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(messageDestination);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (placeHolders == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(placeHolders);
		}

		objectOutput.writeBoolean(aviable);
	}

	public long notificaTypeId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String messageDestination;
	public String description;
	public String placeHolders;
	public Boolean aviable;
}