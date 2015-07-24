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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link QueuedEmail}.
 * </p>
 *
 * @author marcoleo
 * @see QueuedEmail
 * @generated
 */
public class QueuedEmailWrapper implements QueuedEmail,
	ModelWrapper<QueuedEmail> {
	public QueuedEmailWrapper(QueuedEmail queuedEmail) {
		_queuedEmail = queuedEmail;
	}

	@Override
	public Class<?> getModelClass() {
		return QueuedEmail.class;
	}

	@Override
	public String getModelClassName() {
		return QueuedEmail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("queuedEmailId", getQueuedEmailId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("from", getFrom());
		attributes.put("fromName", getFromName());
		attributes.put("to", getTo());
		attributes.put("toName", getToName());
		attributes.put("cc", getCc());
		attributes.put("bcc", getBcc());
		attributes.put("subject", getSubject());
		attributes.put("body", getBody());
		attributes.put("attachmentFileName", getAttachmentFileName());
		attributes.put("attachmentFileEntryId", getAttachmentFileEntryId());
		attributes.put("sentTries", getSentTries());
		attributes.put("sentOn", getSentOn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long queuedEmailId = (Long)attributes.get("queuedEmailId");

		if (queuedEmailId != null) {
			setQueuedEmailId(queuedEmailId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String from = (String)attributes.get("from");

		if (from != null) {
			setFrom(from);
		}

		String fromName = (String)attributes.get("fromName");

		if (fromName != null) {
			setFromName(fromName);
		}

		String to = (String)attributes.get("to");

		if (to != null) {
			setTo(to);
		}

		String toName = (String)attributes.get("toName");

		if (toName != null) {
			setToName(toName);
		}

		String cc = (String)attributes.get("cc");

		if (cc != null) {
			setCc(cc);
		}

		String bcc = (String)attributes.get("bcc");

		if (bcc != null) {
			setBcc(bcc);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		String attachmentFileName = (String)attributes.get("attachmentFileName");

		if (attachmentFileName != null) {
			setAttachmentFileName(attachmentFileName);
		}

		Long attachmentFileEntryId = (Long)attributes.get(
				"attachmentFileEntryId");

		if (attachmentFileEntryId != null) {
			setAttachmentFileEntryId(attachmentFileEntryId);
		}

		Long sentTries = (Long)attributes.get("sentTries");

		if (sentTries != null) {
			setSentTries(sentTries);
		}

		Date sentOn = (Date)attributes.get("sentOn");

		if (sentOn != null) {
			setSentOn(sentOn);
		}
	}

	/**
	* Returns the primary key of this queued email.
	*
	* @return the primary key of this queued email
	*/
	@Override
	public long getPrimaryKey() {
		return _queuedEmail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this queued email.
	*
	* @param primaryKey the primary key of this queued email
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_queuedEmail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the queued email ID of this queued email.
	*
	* @return the queued email ID of this queued email
	*/
	@Override
	public long getQueuedEmailId() {
		return _queuedEmail.getQueuedEmailId();
	}

	/**
	* Sets the queued email ID of this queued email.
	*
	* @param queuedEmailId the queued email ID of this queued email
	*/
	@Override
	public void setQueuedEmailId(long queuedEmailId) {
		_queuedEmail.setQueuedEmailId(queuedEmailId);
	}

	/**
	* Returns the company ID of this queued email.
	*
	* @return the company ID of this queued email
	*/
	@Override
	public long getCompanyId() {
		return _queuedEmail.getCompanyId();
	}

	/**
	* Sets the company ID of this queued email.
	*
	* @param companyId the company ID of this queued email
	*/
	@Override
	public void setCompanyId(long companyId) {
		_queuedEmail.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this queued email.
	*
	* @return the create date of this queued email
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _queuedEmail.getCreateDate();
	}

	/**
	* Sets the create date of this queued email.
	*
	* @param createDate the create date of this queued email
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_queuedEmail.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this queued email.
	*
	* @return the modified date of this queued email
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _queuedEmail.getModifiedDate();
	}

	/**
	* Sets the modified date of this queued email.
	*
	* @param modifiedDate the modified date of this queued email
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_queuedEmail.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the from of this queued email.
	*
	* @return the from of this queued email
	*/
	@Override
	public java.lang.String getFrom() {
		return _queuedEmail.getFrom();
	}

	/**
	* Sets the from of this queued email.
	*
	* @param from the from of this queued email
	*/
	@Override
	public void setFrom(java.lang.String from) {
		_queuedEmail.setFrom(from);
	}

	/**
	* Returns the from name of this queued email.
	*
	* @return the from name of this queued email
	*/
	@Override
	public java.lang.String getFromName() {
		return _queuedEmail.getFromName();
	}

	/**
	* Sets the from name of this queued email.
	*
	* @param fromName the from name of this queued email
	*/
	@Override
	public void setFromName(java.lang.String fromName) {
		_queuedEmail.setFromName(fromName);
	}

	/**
	* Returns the to of this queued email.
	*
	* @return the to of this queued email
	*/
	@Override
	public java.lang.String getTo() {
		return _queuedEmail.getTo();
	}

	/**
	* Sets the to of this queued email.
	*
	* @param to the to of this queued email
	*/
	@Override
	public void setTo(java.lang.String to) {
		_queuedEmail.setTo(to);
	}

	/**
	* Returns the to name of this queued email.
	*
	* @return the to name of this queued email
	*/
	@Override
	public java.lang.String getToName() {
		return _queuedEmail.getToName();
	}

	/**
	* Sets the to name of this queued email.
	*
	* @param toName the to name of this queued email
	*/
	@Override
	public void setToName(java.lang.String toName) {
		_queuedEmail.setToName(toName);
	}

	/**
	* Returns the cc of this queued email.
	*
	* @return the cc of this queued email
	*/
	@Override
	public java.lang.String getCc() {
		return _queuedEmail.getCc();
	}

	/**
	* Sets the cc of this queued email.
	*
	* @param cc the cc of this queued email
	*/
	@Override
	public void setCc(java.lang.String cc) {
		_queuedEmail.setCc(cc);
	}

	/**
	* Returns the bcc of this queued email.
	*
	* @return the bcc of this queued email
	*/
	@Override
	public java.lang.String getBcc() {
		return _queuedEmail.getBcc();
	}

	/**
	* Sets the bcc of this queued email.
	*
	* @param bcc the bcc of this queued email
	*/
	@Override
	public void setBcc(java.lang.String bcc) {
		_queuedEmail.setBcc(bcc);
	}

	/**
	* Returns the subject of this queued email.
	*
	* @return the subject of this queued email
	*/
	@Override
	public java.lang.String getSubject() {
		return _queuedEmail.getSubject();
	}

	/**
	* Sets the subject of this queued email.
	*
	* @param subject the subject of this queued email
	*/
	@Override
	public void setSubject(java.lang.String subject) {
		_queuedEmail.setSubject(subject);
	}

	/**
	* Returns the body of this queued email.
	*
	* @return the body of this queued email
	*/
	@Override
	public java.lang.String getBody() {
		return _queuedEmail.getBody();
	}

	/**
	* Sets the body of this queued email.
	*
	* @param body the body of this queued email
	*/
	@Override
	public void setBody(java.lang.String body) {
		_queuedEmail.setBody(body);
	}

	/**
	* Returns the attachment file name of this queued email.
	*
	* @return the attachment file name of this queued email
	*/
	@Override
	public java.lang.String getAttachmentFileName() {
		return _queuedEmail.getAttachmentFileName();
	}

	/**
	* Sets the attachment file name of this queued email.
	*
	* @param attachmentFileName the attachment file name of this queued email
	*/
	@Override
	public void setAttachmentFileName(java.lang.String attachmentFileName) {
		_queuedEmail.setAttachmentFileName(attachmentFileName);
	}

	/**
	* Returns the attachment file entry ID of this queued email.
	*
	* @return the attachment file entry ID of this queued email
	*/
	@Override
	public long getAttachmentFileEntryId() {
		return _queuedEmail.getAttachmentFileEntryId();
	}

	/**
	* Sets the attachment file entry ID of this queued email.
	*
	* @param attachmentFileEntryId the attachment file entry ID of this queued email
	*/
	@Override
	public void setAttachmentFileEntryId(long attachmentFileEntryId) {
		_queuedEmail.setAttachmentFileEntryId(attachmentFileEntryId);
	}

	/**
	* Returns the sent tries of this queued email.
	*
	* @return the sent tries of this queued email
	*/
	@Override
	public long getSentTries() {
		return _queuedEmail.getSentTries();
	}

	/**
	* Sets the sent tries of this queued email.
	*
	* @param sentTries the sent tries of this queued email
	*/
	@Override
	public void setSentTries(long sentTries) {
		_queuedEmail.setSentTries(sentTries);
	}

	/**
	* Returns the sent on of this queued email.
	*
	* @return the sent on of this queued email
	*/
	@Override
	public java.util.Date getSentOn() {
		return _queuedEmail.getSentOn();
	}

	/**
	* Sets the sent on of this queued email.
	*
	* @param sentOn the sent on of this queued email
	*/
	@Override
	public void setSentOn(java.util.Date sentOn) {
		_queuedEmail.setSentOn(sentOn);
	}

	@Override
	public boolean isNew() {
		return _queuedEmail.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_queuedEmail.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _queuedEmail.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_queuedEmail.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _queuedEmail.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _queuedEmail.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_queuedEmail.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _queuedEmail.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_queuedEmail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_queuedEmail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_queuedEmail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new QueuedEmailWrapper((QueuedEmail)_queuedEmail.clone());
	}

	@Override
	public int compareTo(
		com.xpiping.notificationcenter.model.QueuedEmail queuedEmail) {
		return _queuedEmail.compareTo(queuedEmail);
	}

	@Override
	public int hashCode() {
		return _queuedEmail.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.xpiping.notificationcenter.model.QueuedEmail> toCacheModel() {
		return _queuedEmail.toCacheModel();
	}

	@Override
	public com.xpiping.notificationcenter.model.QueuedEmail toEscapedModel() {
		return new QueuedEmailWrapper(_queuedEmail.toEscapedModel());
	}

	@Override
	public com.xpiping.notificationcenter.model.QueuedEmail toUnescapedModel() {
		return new QueuedEmailWrapper(_queuedEmail.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _queuedEmail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _queuedEmail.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_queuedEmail.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QueuedEmailWrapper)) {
			return false;
		}

		QueuedEmailWrapper queuedEmailWrapper = (QueuedEmailWrapper)obj;

		if (Validator.equals(_queuedEmail, queuedEmailWrapper._queuedEmail)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public QueuedEmail getWrappedQueuedEmail() {
		return _queuedEmail;
	}

	@Override
	public QueuedEmail getWrappedModel() {
		return _queuedEmail;
	}

	@Override
	public void resetOriginalValues() {
		_queuedEmail.resetOriginalValues();
	}

	private QueuedEmail _queuedEmail;
}