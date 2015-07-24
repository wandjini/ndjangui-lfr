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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.xpiping.notificationcenter.model.QueuedEmail;
import com.xpiping.notificationcenter.model.QueuedEmailModel;
import com.xpiping.notificationcenter.model.QueuedEmailSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the QueuedEmail service. Represents a row in the &quot;xpiping_notificationcenter_QueuedEmail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.xpiping.notificationcenter.model.QueuedEmailModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link QueuedEmailImpl}.
 * </p>
 *
 * @author marcoleo
 * @see QueuedEmailImpl
 * @see com.xpiping.notificationcenter.model.QueuedEmail
 * @see com.xpiping.notificationcenter.model.QueuedEmailModel
 * @generated
 */
@JSON(strict = true)
public class QueuedEmailModelImpl extends BaseModelImpl<QueuedEmail>
	implements QueuedEmailModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a queued email model instance should use the {@link com.xpiping.notificationcenter.model.QueuedEmail} interface instead.
	 */
	public static final String TABLE_NAME = "xpiping_notificationcenter_QueuedEmail";
	public static final Object[][] TABLE_COLUMNS = {
			{ "queuedEmailId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "from_", Types.VARCHAR },
			{ "fromName", Types.VARCHAR },
			{ "to_", Types.VARCHAR },
			{ "toName", Types.VARCHAR },
			{ "cc", Types.VARCHAR },
			{ "bcc", Types.VARCHAR },
			{ "subject", Types.VARCHAR },
			{ "body", Types.CLOB },
			{ "attachmentFileName", Types.VARCHAR },
			{ "attachmentFileEntryId", Types.BIGINT },
			{ "sentTries", Types.BIGINT },
			{ "sentOn", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table xpiping_notificationcenter_QueuedEmail (queuedEmailId LONG not null primary key,companyId LONG,createDate DATE null,modifiedDate DATE null,from_ VARCHAR(75) null,fromName VARCHAR(75) null,to_ VARCHAR(75) null,toName VARCHAR(75) null,cc VARCHAR(75) null,bcc VARCHAR(75) null,subject STRING null,body TEXT null,attachmentFileName VARCHAR(75) null,attachmentFileEntryId LONG,sentTries LONG,sentOn DATE null)";
	public static final String TABLE_SQL_DROP = "drop table xpiping_notificationcenter_QueuedEmail";
	public static final String ORDER_BY_JPQL = " ORDER BY queuedEmail.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY xpiping_notificationcenter_QueuedEmail.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.xpiping.notificationcenter.model.QueuedEmail"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.xpiping.notificationcenter.model.QueuedEmail"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.xpiping.notificationcenter.model.QueuedEmail"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long SENTON_COLUMN_BITMASK = 2L;
	public static long CREATEDATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static QueuedEmail toModel(QueuedEmailSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		QueuedEmail model = new QueuedEmailImpl();

		model.setQueuedEmailId(soapModel.getQueuedEmailId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setFrom(soapModel.getFrom());
		model.setFromName(soapModel.getFromName());
		model.setTo(soapModel.getTo());
		model.setToName(soapModel.getToName());
		model.setCc(soapModel.getCc());
		model.setBcc(soapModel.getBcc());
		model.setSubject(soapModel.getSubject());
		model.setBody(soapModel.getBody());
		model.setAttachmentFileName(soapModel.getAttachmentFileName());
		model.setAttachmentFileEntryId(soapModel.getAttachmentFileEntryId());
		model.setSentTries(soapModel.getSentTries());
		model.setSentOn(soapModel.getSentOn());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<QueuedEmail> toModels(QueuedEmailSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<QueuedEmail> models = new ArrayList<QueuedEmail>(soapModels.length);

		for (QueuedEmailSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.xpiping.notificationcenter.model.QueuedEmail"));

	public QueuedEmailModelImpl() {
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

	@JSON
	@Override
	public long getQueuedEmailId() {
		return _queuedEmailId;
	}

	@Override
	public void setQueuedEmailId(long queuedEmailId) {
		_queuedEmailId = queuedEmailId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getFrom() {
		if (_from == null) {
			return StringPool.BLANK;
		}
		else {
			return _from;
		}
	}

	@Override
	public void setFrom(String from) {
		_from = from;
	}

	@JSON
	@Override
	public String getFromName() {
		if (_fromName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fromName;
		}
	}

	@Override
	public void setFromName(String fromName) {
		_fromName = fromName;
	}

	@JSON
	@Override
	public String getTo() {
		if (_to == null) {
			return StringPool.BLANK;
		}
		else {
			return _to;
		}
	}

	@Override
	public void setTo(String to) {
		_to = to;
	}

	@JSON
	@Override
	public String getToName() {
		if (_toName == null) {
			return StringPool.BLANK;
		}
		else {
			return _toName;
		}
	}

	@Override
	public void setToName(String toName) {
		_toName = toName;
	}

	@JSON
	@Override
	public String getCc() {
		if (_cc == null) {
			return StringPool.BLANK;
		}
		else {
			return _cc;
		}
	}

	@Override
	public void setCc(String cc) {
		_cc = cc;
	}

	@JSON
	@Override
	public String getBcc() {
		if (_bcc == null) {
			return StringPool.BLANK;
		}
		else {
			return _bcc;
		}
	}

	@Override
	public void setBcc(String bcc) {
		_bcc = bcc;
	}

	@JSON
	@Override
	public String getSubject() {
		if (_subject == null) {
			return StringPool.BLANK;
		}
		else {
			return _subject;
		}
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;
	}

	@JSON
	@Override
	public String getBody() {
		if (_body == null) {
			return StringPool.BLANK;
		}
		else {
			return _body;
		}
	}

	@Override
	public void setBody(String body) {
		_body = body;
	}

	@JSON
	@Override
	public String getAttachmentFileName() {
		if (_attachmentFileName == null) {
			return StringPool.BLANK;
		}
		else {
			return _attachmentFileName;
		}
	}

	@Override
	public void setAttachmentFileName(String attachmentFileName) {
		_attachmentFileName = attachmentFileName;
	}

	@JSON
	@Override
	public long getAttachmentFileEntryId() {
		return _attachmentFileEntryId;
	}

	@Override
	public void setAttachmentFileEntryId(long attachmentFileEntryId) {
		_attachmentFileEntryId = attachmentFileEntryId;
	}

	@JSON
	@Override
	public long getSentTries() {
		return _sentTries;
	}

	@Override
	public void setSentTries(long sentTries) {
		_sentTries = sentTries;
	}

	@JSON
	@Override
	public Date getSentOn() {
		return _sentOn;
	}

	@Override
	public void setSentOn(Date sentOn) {
		_columnBitmask |= SENTON_COLUMN_BITMASK;

		if (_originalSentOn == null) {
			_originalSentOn = _sentOn;
		}

		_sentOn = sentOn;
	}

	public Date getOriginalSentOn() {
		return _originalSentOn;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			QueuedEmail.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public QueuedEmail toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (QueuedEmail)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		QueuedEmailImpl queuedEmailImpl = new QueuedEmailImpl();

		queuedEmailImpl.setQueuedEmailId(getQueuedEmailId());
		queuedEmailImpl.setCompanyId(getCompanyId());
		queuedEmailImpl.setCreateDate(getCreateDate());
		queuedEmailImpl.setModifiedDate(getModifiedDate());
		queuedEmailImpl.setFrom(getFrom());
		queuedEmailImpl.setFromName(getFromName());
		queuedEmailImpl.setTo(getTo());
		queuedEmailImpl.setToName(getToName());
		queuedEmailImpl.setCc(getCc());
		queuedEmailImpl.setBcc(getBcc());
		queuedEmailImpl.setSubject(getSubject());
		queuedEmailImpl.setBody(getBody());
		queuedEmailImpl.setAttachmentFileName(getAttachmentFileName());
		queuedEmailImpl.setAttachmentFileEntryId(getAttachmentFileEntryId());
		queuedEmailImpl.setSentTries(getSentTries());
		queuedEmailImpl.setSentOn(getSentOn());

		queuedEmailImpl.resetOriginalValues();

		return queuedEmailImpl;
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

		if (!(obj instanceof QueuedEmail)) {
			return false;
		}

		QueuedEmail queuedEmail = (QueuedEmail)obj;

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
	public void resetOriginalValues() {
		QueuedEmailModelImpl queuedEmailModelImpl = this;

		queuedEmailModelImpl._originalCompanyId = queuedEmailModelImpl._companyId;

		queuedEmailModelImpl._setOriginalCompanyId = false;

		queuedEmailModelImpl._originalSentOn = queuedEmailModelImpl._sentOn;

		queuedEmailModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<QueuedEmail> toCacheModel() {
		QueuedEmailCacheModel queuedEmailCacheModel = new QueuedEmailCacheModel();

		queuedEmailCacheModel.queuedEmailId = getQueuedEmailId();

		queuedEmailCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			queuedEmailCacheModel.createDate = createDate.getTime();
		}
		else {
			queuedEmailCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			queuedEmailCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			queuedEmailCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		queuedEmailCacheModel.from = getFrom();

		String from = queuedEmailCacheModel.from;

		if ((from != null) && (from.length() == 0)) {
			queuedEmailCacheModel.from = null;
		}

		queuedEmailCacheModel.fromName = getFromName();

		String fromName = queuedEmailCacheModel.fromName;

		if ((fromName != null) && (fromName.length() == 0)) {
			queuedEmailCacheModel.fromName = null;
		}

		queuedEmailCacheModel.to = getTo();

		String to = queuedEmailCacheModel.to;

		if ((to != null) && (to.length() == 0)) {
			queuedEmailCacheModel.to = null;
		}

		queuedEmailCacheModel.toName = getToName();

		String toName = queuedEmailCacheModel.toName;

		if ((toName != null) && (toName.length() == 0)) {
			queuedEmailCacheModel.toName = null;
		}

		queuedEmailCacheModel.cc = getCc();

		String cc = queuedEmailCacheModel.cc;

		if ((cc != null) && (cc.length() == 0)) {
			queuedEmailCacheModel.cc = null;
		}

		queuedEmailCacheModel.bcc = getBcc();

		String bcc = queuedEmailCacheModel.bcc;

		if ((bcc != null) && (bcc.length() == 0)) {
			queuedEmailCacheModel.bcc = null;
		}

		queuedEmailCacheModel.subject = getSubject();

		String subject = queuedEmailCacheModel.subject;

		if ((subject != null) && (subject.length() == 0)) {
			queuedEmailCacheModel.subject = null;
		}

		queuedEmailCacheModel.body = getBody();

		String body = queuedEmailCacheModel.body;

		if ((body != null) && (body.length() == 0)) {
			queuedEmailCacheModel.body = null;
		}

		queuedEmailCacheModel.attachmentFileName = getAttachmentFileName();

		String attachmentFileName = queuedEmailCacheModel.attachmentFileName;

		if ((attachmentFileName != null) && (attachmentFileName.length() == 0)) {
			queuedEmailCacheModel.attachmentFileName = null;
		}

		queuedEmailCacheModel.attachmentFileEntryId = getAttachmentFileEntryId();

		queuedEmailCacheModel.sentTries = getSentTries();

		Date sentOn = getSentOn();

		if (sentOn != null) {
			queuedEmailCacheModel.sentOn = sentOn.getTime();
		}
		else {
			queuedEmailCacheModel.sentOn = Long.MIN_VALUE;
		}

		return queuedEmailCacheModel;
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

	private static ClassLoader _classLoader = QueuedEmail.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			QueuedEmail.class
		};
	private long _queuedEmailId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
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
	private Date _originalSentOn;
	private long _columnBitmask;
	private QueuedEmail _escapedModel;
}