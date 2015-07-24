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

import com.xpiping.notificationcenter.model.Notifica;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Notifica in entity cache.
 *
 * @author marcoleo
 * @see Notifica
 * @generated
 */
public class NotificaCacheModel implements CacheModel<Notifica>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{notificaId=");
		sb.append(notificaId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", notificaTypeId=");
		sb.append(notificaTypeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", text=");
		sb.append(text);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", description=");
		sb.append(description);
		sb.append(", aviable=");
		sb.append(aviable);
		sb.append(", ignoreIntersaction=");
		sb.append(ignoreIntersaction);
		sb.append(", orgsIds=");
		sb.append(orgsIds);
		sb.append(", groupsIds=");
		sb.append(groupsIds);
		sb.append(", rolesIds=");
		sb.append(rolesIds);
		sb.append(", lastCheckDate=");
		sb.append(lastCheckDate);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Notifica toEntityModel() {
		NotificaImpl notificaImpl = new NotificaImpl();

		notificaImpl.setNotificaId(notificaId);
		notificaImpl.setCompanyId(companyId);
		notificaImpl.setUserId(userId);

		if (userName == null) {
			notificaImpl.setUserName(StringPool.BLANK);
		}
		else {
			notificaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			notificaImpl.setCreateDate(null);
		}
		else {
			notificaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			notificaImpl.setModifiedDate(null);
		}
		else {
			notificaImpl.setModifiedDate(new Date(modifiedDate));
		}

		notificaImpl.setNotificaTypeId(notificaTypeId);

		if (name == null) {
			notificaImpl.setName(StringPool.BLANK);
		}
		else {
			notificaImpl.setName(name);
		}

		if (text == null) {
			notificaImpl.setText(StringPool.BLANK);
		}
		else {
			notificaImpl.setText(text);
		}

		if (subject == null) {
			notificaImpl.setSubject(StringPool.BLANK);
		}
		else {
			notificaImpl.setSubject(subject);
		}

		if (description == null) {
			notificaImpl.setDescription(StringPool.BLANK);
		}
		else {
			notificaImpl.setDescription(description);
		}

		notificaImpl.setAviable(aviable);
		notificaImpl.setIgnoreIntersaction(ignoreIntersaction);

		if (orgsIds == null) {
			notificaImpl.setOrgsIds(StringPool.BLANK);
		}
		else {
			notificaImpl.setOrgsIds(orgsIds);
		}

		if (groupsIds == null) {
			notificaImpl.setGroupsIds(StringPool.BLANK);
		}
		else {
			notificaImpl.setGroupsIds(groupsIds);
		}

		if (rolesIds == null) {
			notificaImpl.setRolesIds(StringPool.BLANK);
		}
		else {
			notificaImpl.setRolesIds(rolesIds);
		}

		if (lastCheckDate == Long.MIN_VALUE) {
			notificaImpl.setLastCheckDate(null);
		}
		else {
			notificaImpl.setLastCheckDate(new Date(lastCheckDate));
		}

		notificaImpl.setDeleted(deleted);

		notificaImpl.resetOriginalValues();

		return notificaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		notificaId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		notificaTypeId = objectInput.readLong();
		name = objectInput.readUTF();
		text = objectInput.readUTF();
		subject = objectInput.readUTF();
		description = objectInput.readUTF();
		aviable = objectInput.readBoolean();
		ignoreIntersaction = objectInput.readBoolean();
		orgsIds = objectInput.readUTF();
		groupsIds = objectInput.readUTF();
		rolesIds = objectInput.readUTF();
		lastCheckDate = objectInput.readLong();
		deleted = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(notificaId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(notificaTypeId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (text == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(text);
		}

		if (subject == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(aviable);
		objectOutput.writeBoolean(ignoreIntersaction);

		if (orgsIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orgsIds);
		}

		if (groupsIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupsIds);
		}

		if (rolesIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rolesIds);
		}

		objectOutput.writeLong(lastCheckDate);
		objectOutput.writeBoolean(deleted);
	}

	public long notificaId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long notificaTypeId;
	public String name;
	public String text;
	public String subject;
	public String description;
	public Boolean aviable;
	public Boolean ignoreIntersaction;
	public String orgsIds;
	public String groupsIds;
	public String rolesIds;
	public long lastCheckDate;
	public Boolean deleted;
}