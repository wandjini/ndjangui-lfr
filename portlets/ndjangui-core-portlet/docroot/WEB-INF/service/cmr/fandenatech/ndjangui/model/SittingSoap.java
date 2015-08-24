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
 * This class is used by SOAP remote services, specifically {@link cmr.fandenatech.ndjangui.service.http.SittingServiceSoap}.
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.http.SittingServiceSoap
 * @generated
 */
public class SittingSoap implements Serializable {
	public static SittingSoap toSoapModel(Sitting model) {
		SittingSoap soapModel = new SittingSoap();

		soapModel.setSittingId(model.getSittingId());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setStartHour(model.getStartHour());
		soapModel.setStartMin(model.getStartMin());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setEndHour(model.getEndHour());
		soapModel.setEndMin(model.getEndMin());
		soapModel.setBudgetPeriodId(model.getBudgetPeriodId());
		soapModel.setName(model.getName());
		soapModel.setDayPlan(model.getDayPlan());
		soapModel.setNotes(model.getNotes());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static SittingSoap[] toSoapModels(Sitting[] models) {
		SittingSoap[] soapModels = new SittingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SittingSoap[][] toSoapModels(Sitting[][] models) {
		SittingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SittingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SittingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SittingSoap[] toSoapModels(List<Sitting> models) {
		List<SittingSoap> soapModels = new ArrayList<SittingSoap>(models.size());

		for (Sitting model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SittingSoap[soapModels.size()]);
	}

	public SittingSoap() {
	}

	public long getPrimaryKey() {
		return _sittingId;
	}

	public void setPrimaryKey(long pk) {
		setSittingId(pk);
	}

	public long getSittingId() {
		return _sittingId;
	}

	public void setSittingId(long sittingId) {
		_sittingId = sittingId;
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

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public int getStartHour() {
		return _startHour;
	}

	public void setStartHour(int startHour) {
		_startHour = startHour;
	}

	public int getStartMin() {
		return _startMin;
	}

	public void setStartMin(int startMin) {
		_startMin = startMin;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public int getEndHour() {
		return _endHour;
	}

	public void setEndHour(int endHour) {
		_endHour = endHour;
	}

	public int getEndMin() {
		return _endMin;
	}

	public void setEndMin(int endMin) {
		_endMin = endMin;
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

	public String getDayPlan() {
		return _dayPlan;
	}

	public void setDayPlan(String dayPlan) {
		_dayPlan = dayPlan;
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

	private long _sittingId;
	private long _userId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _startDate;
	private int _startHour;
	private int _startMin;
	private Date _endDate;
	private int _endHour;
	private int _endMin;
	private long _budgetPeriodId;
	private String _name;
	private String _dayPlan;
	private String _notes;
	private int _status;
}