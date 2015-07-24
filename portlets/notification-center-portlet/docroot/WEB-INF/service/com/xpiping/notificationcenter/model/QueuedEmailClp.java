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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.xpiping.notificationcenter.service.ClpSerializer;
import com.xpiping.notificationcenter.service.QueuedEmailLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author marcoleo
 */
public class QueuedEmailClp extends BaseModelImpl<QueuedEmail>
	implements QueuedEmail {
	public QueuedEmailClp() {
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
	public long getPrimaryKey() {
		return _queuedEmailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setQueuedEmailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _queuedEmailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getQueuedEmailId() {
		return _queuedEmailId;
	}

	@Override
	public void setQueuedEmailId(long queuedEmailId) {
		_queuedEmailId = queuedEmailId;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setQueuedEmailId", long.class);

				method.invoke(_queuedEmailRemoteModel, queuedEmailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_queuedEmailRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_queuedEmailRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_queuedEmailRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFrom() {
		return _from;
	}

	@Override
	public void setFrom(String from) {
		_from = from;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setFrom", String.class);

				method.invoke(_queuedEmailRemoteModel, from);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFromName() {
		return _fromName;
	}

	@Override
	public void setFromName(String fromName) {
		_fromName = fromName;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setFromName", String.class);

				method.invoke(_queuedEmailRemoteModel, fromName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTo() {
		return _to;
	}

	@Override
	public void setTo(String to) {
		_to = to;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setTo", String.class);

				method.invoke(_queuedEmailRemoteModel, to);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getToName() {
		return _toName;
	}

	@Override
	public void setToName(String toName) {
		_toName = toName;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setToName", String.class);

				method.invoke(_queuedEmailRemoteModel, toName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCc() {
		return _cc;
	}

	@Override
	public void setCc(String cc) {
		_cc = cc;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setCc", String.class);

				method.invoke(_queuedEmailRemoteModel, cc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBcc() {
		return _bcc;
	}

	@Override
	public void setBcc(String bcc) {
		_bcc = bcc;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setBcc", String.class);

				method.invoke(_queuedEmailRemoteModel, bcc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubject() {
		return _subject;
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setSubject", String.class);

				method.invoke(_queuedEmailRemoteModel, subject);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBody() {
		return _body;
	}

	@Override
	public void setBody(String body) {
		_body = body;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setBody", String.class);

				method.invoke(_queuedEmailRemoteModel, body);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAttachmentFileName() {
		return _attachmentFileName;
	}

	@Override
	public void setAttachmentFileName(String attachmentFileName) {
		_attachmentFileName = attachmentFileName;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentFileName",
						String.class);

				method.invoke(_queuedEmailRemoteModel, attachmentFileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAttachmentFileEntryId() {
		return _attachmentFileEntryId;
	}

	@Override
	public void setAttachmentFileEntryId(long attachmentFileEntryId) {
		_attachmentFileEntryId = attachmentFileEntryId;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentFileEntryId",
						long.class);

				method.invoke(_queuedEmailRemoteModel, attachmentFileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSentTries() {
		return _sentTries;
	}

	@Override
	public void setSentTries(long sentTries) {
		_sentTries = sentTries;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setSentTries", long.class);

				method.invoke(_queuedEmailRemoteModel, sentTries);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSentOn() {
		return _sentOn;
	}

	@Override
	public void setSentOn(Date sentOn) {
		_sentOn = sentOn;

		if (_queuedEmailRemoteModel != null) {
			try {
				Class<?> clazz = _queuedEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setSentOn", Date.class);

				method.invoke(_queuedEmailRemoteModel, sentOn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getQueuedEmailRemoteModel() {
		return _queuedEmailRemoteModel;
	}

	public void setQueuedEmailRemoteModel(BaseModel<?> queuedEmailRemoteModel) {
		_queuedEmailRemoteModel = queuedEmailRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _queuedEmailRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_queuedEmailRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			QueuedEmailLocalServiceUtil.addQueuedEmail(this);
		}
		else {
			QueuedEmailLocalServiceUtil.updateQueuedEmail(this);
		}
	}

	@Override
	public QueuedEmail toEscapedModel() {
		return (QueuedEmail)ProxyUtil.newProxyInstance(QueuedEmail.class.getClassLoader(),
			new Class[] { QueuedEmail.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		QueuedEmailClp clone = new QueuedEmailClp();

		clone.setQueuedEmailId(getQueuedEmailId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFrom(getFrom());
		clone.setFromName(getFromName());
		clone.setTo(getTo());
		clone.setToName(getToName());
		clone.setCc(getCc());
		clone.setBcc(getBcc());
		clone.setSubject(getSubject());
		clone.setBody(getBody());
		clone.setAttachmentFileName(getAttachmentFileName());
		clone.setAttachmentFileEntryId(getAttachmentFileEntryId());
		clone.setSentTries(getSentTries());
		clone.setSentOn(getSentOn());

		return clone;
	}

	@Override
	public int compareTo(QueuedEmail queuedEmail) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), queuedEmail.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QueuedEmailClp)) {
			return false;
		}

		QueuedEmailClp queuedEmail = (QueuedEmailClp)obj;

		long primaryKey = queuedEmail.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{queuedEmailId=");
		sb.append(getQueuedEmailId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", from=");
		sb.append(getFrom());
		sb.append(", fromName=");
		sb.append(getFromName());
		sb.append(", to=");
		sb.append(getTo());
		sb.append(", toName=");
		sb.append(getToName());
		sb.append(", cc=");
		sb.append(getCc());
		sb.append(", bcc=");
		sb.append(getBcc());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", body=");
		sb.append(getBody());
		sb.append(", attachmentFileName=");
		sb.append(getAttachmentFileName());
		sb.append(", attachmentFileEntryId=");
		sb.append(getAttachmentFileEntryId());
		sb.append(", sentTries=");
		sb.append(getSentTries());
		sb.append(", sentOn=");
		sb.append(getSentOn());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.xpiping.notificationcenter.model.QueuedEmail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>queuedEmailId</column-name><column-value><![CDATA[");
		sb.append(getQueuedEmailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>from</column-name><column-value><![CDATA[");
		sb.append(getFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromName</column-name><column-value><![CDATA[");
		sb.append(getFromName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>to</column-name><column-value><![CDATA[");
		sb.append(getTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toName</column-name><column-value><![CDATA[");
		sb.append(getToName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cc</column-name><column-value><![CDATA[");
		sb.append(getCc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bcc</column-name><column-value><![CDATA[");
		sb.append(getBcc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachmentFileName</column-name><column-value><![CDATA[");
		sb.append(getAttachmentFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachmentFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getAttachmentFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentTries</column-name><column-value><![CDATA[");
		sb.append(getSentTries());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentOn</column-name><column-value><![CDATA[");
		sb.append(getSentOn());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _queuedEmailRemoteModel;
}