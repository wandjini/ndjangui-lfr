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
 * This class is used by SOAP remote services, specifically {@link com.ndjangui.notificationcenter.service.http.NotificaServiceSoap}.
 *
 * @author marcoleo
 * @see com.ndjangui.notificationcenter.service.http.NotificaServiceSoap
 * @generated
 */
public class NotificaSoap implements Serializable {
	public static NotificaSoap toSoapModel(Notifica model) {
		NotificaSoap soapModel = new NotificaSoap();

		soapModel.setNotificaId(model.getNotificaId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNotificaTypeId(model.getNotificaTypeId());
		soapModel.setName(model.getName());
		soapModel.setText(model.getText());
		soapModel.setSubject(model.getSubject());
		soapModel.setDescription(model.getDescription());
		soapModel.setAviable(model.getAviable());
		soapModel.setIgnoreIntersaction(model.getIgnoreIntersaction());
		soapModel.setOrgsIds(model.getOrgsIds());
		soapModel.setGroupsIds(model.getGroupsIds());
		soapModel.setRolesIds(model.getRolesIds());
		soapModel.setLastCheckDate(model.getLastCheckDate());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static NotificaSoap[] toSoapModels(Notifica[] models) {
		NotificaSoap[] soapModels = new NotificaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NotificaSoap[][] toSoapModels(Notifica[][] models) {
		NotificaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NotificaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NotificaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NotificaSoap[] toSoapModels(List<Notifica> models) {
		List<NotificaSoap> soapModels = new ArrayList<NotificaSoap>(models.size());

		for (Notifica model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NotificaSoap[soapModels.size()]);
	}

	public NotificaSoap() {
	}

	public long getPrimaryKey() {
		return _notificaId;
	}

	public void setPrimaryKey(long pk) {
		setNotificaId(pk);
	}

	public long getNotificaId() {
		return _notificaId;
	}

	public void setNotificaId(long notificaId) {
		_notificaId = notificaId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public long getNotificaTypeId() {
		return _notificaTypeId;
	}

	public void setNotificaTypeId(long notificaTypeId) {
		_notificaTypeId = notificaTypeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Boolean getAviable() {
		return _aviable;
	}

	public void setAviable(Boolean aviable) {
		_aviable = aviable;
	}

	public Boolean getIgnoreIntersaction() {
		return _ignoreIntersaction;
	}

	public void setIgnoreIntersaction(Boolean ignoreIntersaction) {
		_ignoreIntersaction = ignoreIntersaction;
	}

	public String getOrgsIds() {
		return _orgsIds;
	}

	public void setOrgsIds(String orgsIds) {
		_orgsIds = orgsIds;
	}

	public String getGroupsIds() {
		return _groupsIds;
	}

	public void setGroupsIds(String groupsIds) {
		_groupsIds = groupsIds;
	}

	public String getRolesIds() {
		return _rolesIds;
	}

	public void setRolesIds(String rolesIds) {
		_rolesIds = rolesIds;
	}

	public Date getLastCheckDate() {
		return _lastCheckDate;
	}

	public void setLastCheckDate(Date lastCheckDate) {
		_lastCheckDate = lastCheckDate;
	}

	public Boolean getDeleted() {
		return _deleted;
	}

	public void setDeleted(Boolean deleted) {
		_deleted = deleted;
	}

	private long _notificaId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _notificaTypeId;
	private String _name;
	private String _text;
	private String _subject;
	private String _description;
	private Boolean _aviable;
	private Boolean _ignoreIntersaction;
	private String _orgsIds;
	private String _groupsIds;
	private String _rolesIds;
	private Date _lastCheckDate;
	private Boolean _deleted;
}