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
 * This class is used by SOAP remote services, specifically {@link com.ndjangui.notificationcenter.service.http.NotificaMessageServiceSoap}.
 *
 * @author marcoleo
 * @see com.ndjangui.notificationcenter.service.http.NotificaMessageServiceSoap
 * @generated
 */
public class NotificaMessageSoap implements Serializable {
	public static NotificaMessageSoap toSoapModel(NotificaMessage model) {
		NotificaMessageSoap soapModel = new NotificaMessageSoap();

		soapModel.setNotificaMessageId(model.getNotificaMessageId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNotificaId(model.getNotificaId());
		soapModel.setUserId(model.getUserId());
		soapModel.setEntityId(model.getEntityId());
		soapModel.setEntityName(model.getEntityName());
		soapModel.setQueuedEmailId(model.getQueuedEmailId());

		return soapModel;
	}

	public static NotificaMessageSoap[] toSoapModels(NotificaMessage[] models) {
		NotificaMessageSoap[] soapModels = new NotificaMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NotificaMessageSoap[][] toSoapModels(
		NotificaMessage[][] models) {
		NotificaMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NotificaMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NotificaMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NotificaMessageSoap[] toSoapModels(
		List<NotificaMessage> models) {
		List<NotificaMessageSoap> soapModels = new ArrayList<NotificaMessageSoap>(models.size());

		for (NotificaMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NotificaMessageSoap[soapModels.size()]);
	}

	public NotificaMessageSoap() {
	}

	public long getPrimaryKey() {
		return _notificaMessageId;
	}

	public void setPrimaryKey(long pk) {
		setNotificaMessageId(pk);
	}

	public long getNotificaMessageId() {
		return _notificaMessageId;
	}

	public void setNotificaMessageId(long notificaMessageId) {
		_notificaMessageId = notificaMessageId;
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

	public long getNotificaId() {
		return _notificaId;
	}

	public void setNotificaId(long notificaId) {
		_notificaId = notificaId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getEntityId() {
		return _entityId;
	}

	public void setEntityId(long entityId) {
		_entityId = entityId;
	}

	public String getEntityName() {
		return _entityName;
	}

	public void setEntityName(String entityName) {
		_entityName = entityName;
	}

	public long getQueuedEmailId() {
		return _queuedEmailId;
	}

	public void setQueuedEmailId(long queuedEmailId) {
		_queuedEmailId = queuedEmailId;
	}

	private long _notificaMessageId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _notificaId;
	private long _userId;
	private long _entityId;
	private String _entityName;
	private long _queuedEmailId;
}