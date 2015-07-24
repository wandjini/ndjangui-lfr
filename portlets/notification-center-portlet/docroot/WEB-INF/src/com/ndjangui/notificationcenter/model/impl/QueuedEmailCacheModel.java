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

import com.xpiping.notificationcenter.model.QueuedEmail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing QueuedEmail in entity cache.
 *
 * @author marcoleo
 * @see QueuedEmail
 * @generated
 */
public class QueuedEmailCacheModel implements CacheModel<QueuedEmail>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{queuedEmailId=");
		sb.append(queuedEmailId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", from=");
		sb.append(from);
		sb.append(", fromName=");
		sb.append(fromName);
		sb.append(", to=");
		sb.append(to);
		sb.append(", toName=");
		sb.append(toName);
		sb.append(", cc=");
		sb.append(cc);
		sb.append(", bcc=");
		sb.append(bcc);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", body=");
		sb.append(body);
		sb.append(", attachmentFileName=");
		sb.append(attachmentFileName);
		sb.append(", attachmentFileEntryId=");
		sb.append(attachmentFileEntryId);
		sb.append(", sentTries=");
		sb.append(sentTries);
		sb.append(", sentOn=");
		sb.append(sentOn);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QueuedEmail toEntityModel() {
		QueuedEmailImpl queuedEmailImpl = new QueuedEmailImpl();

		queuedEmailImpl.setQueuedEmailId(queuedEmailId);
		queuedEmailImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			queuedEmailImpl.setCreateDate(null);
		}
		else {
			queuedEmailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			queuedEmailImpl.setModifiedDate(null);
		}
		else {
			queuedEmailImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (from == null) {
			queuedEmailImpl.setFrom(StringPool.BLANK);
		}
		else {
			queuedEmailImpl.setFrom(from);
		}

		if (fromName == null) {
			queuedEmailImpl.setFromName(StringPool.BLANK);
		}
		else {
			queuedEmailImpl.setFromName(fromName);
		}

		if (to == null) {
			queuedEmailImpl.setTo(StringPool.BLANK);
		}
		else {
			queuedEmailImpl.setTo(to);
		}

		if (toName == null) {
			queuedEmailImpl.setToName(StringPool.BLANK);
		}
		else {
			queuedEmailImpl.setToName(toName);
		}

		if (cc == null) {
			queuedEmailImpl.setCc(StringPool.BLANK);
		}
		else {
			queuedEmailImpl.setCc(cc);
		}

		if (bcc == null) {
			queuedEmailImpl.setBcc(StringPool.BLANK);
		}
		else {
			queuedEmailImpl.setBcc(bcc);
		}

		if (subject == null) {
			queuedEmailImpl.setSubject(StringPool.BLANK);
		}
		else {
			queuedEmailImpl.setSubject(subject);
		}

		if (body == null) {
			queuedEmailImpl.setBody(StringPool.BLANK);
		}
		else {
			queuedEmailImpl.setBody(body);
		}

		if (attachmentFileName == null) {
			queuedEmailImpl.setAttachmentFileName(StringPool.BLANK);
		}
		else {
			queuedEmailImpl.setAttachmentFileName(attachmentFileName);
		}

		queuedEmailImpl.setAttachmentFileEntryId(attachmentFileEntryId);
		queuedEmailImpl.setSentTries(sentTries);

		if (sentOn == Long.MIN_VALUE) {
			queuedEmailImpl.setSentOn(null);
		}
		else {
			queuedEmailImpl.setSentOn(new Date(sentOn));
		}

		queuedEmailImpl.resetOriginalValues();

		return queuedEmailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		queuedEmailId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		from = objectInput.readUTF();
		fromName = objectInput.readUTF();
		to = objectInput.readUTF();
		toName = objectInput.readUTF();
		cc = objectInput.readUTF();
		bcc = objectInput.readUTF();
		subject = objectInput.readUTF();
		body = objectInput.readUTF();
		attachmentFileName = objectInput.readUTF();
		attachmentFileEntryId = objectInput.readLong();
		sentTries = objectInput.readLong();
		sentOn = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(queuedEmailId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (from == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(from);
		}

		if (fromName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fromName);
		}

		if (to == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(to);
		}

		if (toName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(toName);
		}

		if (cc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cc);
		}

		if (bcc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bcc);
		}

		if (subject == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (body == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(body);
		}

		if (attachmentFileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(attachmentFileName);
		}

		objectOutput.writeLong(attachmentFileEntryId);
		objectOutput.writeLong(sentTries);
		objectOutput.writeLong(sentOn);
	}

	public long queuedEmailId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String from;
	public String fromName;
	public String to;
	public String toName;
	public String cc;
	public String bcc;
	public String subject;
	public String body;
	public String attachmentFileName;
	public long attachmentFileEntryId;
	public long sentTries;
	public long sentOn;
}