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

package com.xpiping.notificationcenter.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ndjangui.notificationcenter.service.http.QueuedEmailServiceSoap}.
 *
 * @author marcoleo
 * @see com.ndjangui.notificationcenter.service.http.QueuedEmailServiceSoap
 * @generated
 */
public class QueuedEmailSoap implements Serializable {
	public static QueuedEmailSoap toSoapModel(QueuedEmail model) {
		QueuedEmailSoap soapModel = new QueuedEmailSoap();

		soapModel.setQueuedEmailId(model.getQueuedEmailId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFrom(model.getFrom());
		soapModel.setFromName(model.getFromName());
		soapModel.setTo(model.getTo());
		soapModel.setToName(model.getToName());
		soapModel.setCc(model.getCc());
		soapModel.setBcc(model.getBcc());
		soapModel.setSubject(model.getSubject());
		soapModel.setBody(model.getBody());
		soapModel.setAttachmentFileName(model.getAttachmentFileName());
		soapModel.setAttachmentFileEntryId(model.getAttachmentFileEntryId());
		soapModel.setSentTries(model.getSentTries());
		soapModel.setSentOn(model.getSentOn());

		return soapModel;
	}

	public static QueuedEmailSoap[] toSoapModels(QueuedEmail[] models) {
		QueuedEmailSoap[] soapModels = new QueuedEmailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QueuedEmailSoap[][] toSoapModels(QueuedEmail[][] models) {
		QueuedEmailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QueuedEmailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QueuedEmailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QueuedEmailSoap[] toSoapModels(List<QueuedEmail> models) {
		List<QueuedEmailSoap> soapModels = new ArrayList<QueuedEmailSoap>(models.size());

		for (QueuedEmail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QueuedEmailSoap[soapModels.size()]);
	}

	public QueuedEmailSoap() {
	}

	public long getPrimaryKey() {
		return _queuedEmailId;
	}

	public void setPrimaryKey(long pk) {
		setQueuedEmailId(pk);
	}

	public long getQueuedEmailId() {
		return _queuedEmailId;
	}

	public void setQueuedEmailId(long queuedEmailId) {
		_queuedEmailId = queuedEmailId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getFrom() {
		return _from;
	}

	public void setFrom(String from) {
		_from = from;
	}

	public String getFromName() {
		return _fromName;
	}

	public void setFromName(String fromName) {
		_fromName = fromName;
	}

	public String getTo() {
		return _to;
	}

	public void setTo(String to) {
		_to = to;
	}

	public String getToName() {
		return _toName;
	}

	public void setToName(String toName) {
		_toName = toName;
	}

	public String getCc() {
		return _cc;
	}

	public void setCc(String cc) {
		_cc = cc;
	}

	public String getBcc() {
		return _bcc;
	}

	public void setBcc(String bcc) {
		_bcc = bcc;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getBody() {
		return _body;
	}

	public void setBody(String body) {
		_body = body;
	}

	public String getAttachmentFileName() {
		return _attachmentFileName;
	}

	public void setAttachmentFileName(String attachmentFileName) {
		_attachmentFileName = attachmentFileName;
	}

	public long getAttachmentFileEntryId() {
		return _attachmentFileEntryId;
	}

	public void setAttachmentFileEntryId(long attachmentFileEntryId) {
		_attachmentFileEntryId = attachmentFileEntryId;
	}

	public long getSentTries() {
		return _sentTries;
	}

	public void setSentTries(long sentTries) {
		_sentTries = sentTries;
	}

	public Date getSentOn() {
		return _sentOn;
	}

	public void setSentOn(Date sentOn) {
		_sentOn = sentOn;
	}

	private long _queuedEmailId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _from;
	private String _fromName;
	private String _to;
	private String _toName;
	private String _cc;
	private String _bcc;
	private String _subject;
	private String _body;
	private String _attachmentFileName;
	private long _attachmentFileEntryId;
	private long _sentTries;
	private Date _sentOn;
}