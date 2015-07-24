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
 * This class is used by SOAP remote services, specifically {@link com.ndjangui.notificationcenter.service.http.NotificaTypeServiceSoap}.
 *
 * @author marcoleo
 * @see com.ndjangui.notificationcenter.service.http.NotificaTypeServiceSoap
 * @generated
 */
public class NotificaTypeSoap implements Serializable {
	public static NotificaTypeSoap toSoapModel(NotificaType model) {
		NotificaTypeSoap soapModel = new NotificaTypeSoap();

		soapModel.setNotificaTypeId(model.getNotificaTypeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setMessageDestination(model.getMessageDestination());
		soapModel.setDescription(model.getDescription());
		soapModel.setPlaceHolders(model.getPlaceHolders());
		soapModel.setAviable(model.getAviable());

		return soapModel;
	}

	public static NotificaTypeSoap[] toSoapModels(NotificaType[] models) {
		NotificaTypeSoap[] soapModels = new NotificaTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NotificaTypeSoap[][] toSoapModels(NotificaType[][] models) {
		NotificaTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NotificaTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NotificaTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NotificaTypeSoap[] toSoapModels(List<NotificaType> models) {
		List<NotificaTypeSoap> soapModels = new ArrayList<NotificaTypeSoap>(models.size());

		for (NotificaType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NotificaTypeSoap[soapModels.size()]);
	}

	public NotificaTypeSoap() {
	}

	public long getPrimaryKey() {
		return _notificaTypeId;
	}

	public void setPrimaryKey(long pk) {
		setNotificaTypeId(pk);
	}

	public long getNotificaTypeId() {
		return _notificaTypeId;
	}

	public void setNotificaTypeId(long notificaTypeId) {
		_notificaTypeId = notificaTypeId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getMessageDestination() {
		return _messageDestination;
	}

	public void setMessageDestination(String messageDestination) {
		_messageDestination = messageDestination;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getPlaceHolders() {
		return _placeHolders;
	}

	public void setPlaceHolders(String placeHolders) {
		_placeHolders = placeHolders;
	}

	public Boolean getAviable() {
		return _aviable;
	}

	public void setAviable(Boolean aviable) {
		_aviable = aviable;
	}

	private long _notificaTypeId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _messageDestination;
	private String _description;
	private String _placeHolders;
	private Boolean _aviable;
}