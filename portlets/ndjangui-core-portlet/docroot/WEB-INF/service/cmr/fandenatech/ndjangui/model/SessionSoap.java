/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package cmr.fandenatech.ndjangui.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link cmr.fandenatech.ndjangui.service.http.SessionServiceSoap}.
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.http.SessionServiceSoap
 * @generated
 */
public class SessionSoap implements Serializable {
	public static SessionSoap toSoapModel(Session model) {
		SessionSoap soapModel = new SessionSoap();

		soapModel.setSessionId(model.getSessionId());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBudgetPeriodId(model.getBudgetPeriodId());
		soapModel.setName(model.getName());
		soapModel.setNotes(model.getNotes());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static SessionSoap[] toSoapModels(Session[] models) {
		SessionSoap[] soapModels = new SessionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SessionSoap[][] toSoapModels(Session[][] models) {
		SessionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SessionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SessionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SessionSoap[] toSoapModels(List<Session> models) {
		List<SessionSoap> soapModels = new ArrayList<SessionSoap>(models.size());

		for (Session model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SessionSoap[soapModels.size()]);
	}

	public SessionSoap() {
	}

	public long getPrimaryKey() {
		return _sessionId;
	}

	public void setPrimaryKey(long pk) {
		setSessionId(pk);
	}

	public long getSessionId() {
		return _sessionId;
	}

	public void setSessionId(long sessionId) {
		_sessionId = sessionId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getBudgetPeriodId() {
		return _budgetPeriodId;
	}

	public void setBudgetPeriodId(long budgetPeriodId) {
		_budgetPeriodId = budgetPeriodId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _sessionId;
	private long _userId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _budgetPeriodId;
	private String _name;
	private String _notes;
	private int _status;
}