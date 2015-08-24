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
 * This class is used by SOAP remote services, specifically {@link cmr.fandenatech.ndjangui.service.http.BudgetPeriodServiceSoap}.
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.http.BudgetPeriodServiceSoap
 * @generated
 */
public class BudgetPeriodSoap implements Serializable {
	public static BudgetPeriodSoap toSoapModel(BudgetPeriod model) {
		BudgetPeriodSoap soapModel = new BudgetPeriodSoap();

		soapModel.setBudgetPeriodId(model.getBudgetPeriodId());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setShortDescription(model.getShortDescription());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static BudgetPeriodSoap[] toSoapModels(BudgetPeriod[] models) {
		BudgetPeriodSoap[] soapModels = new BudgetPeriodSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BudgetPeriodSoap[][] toSoapModels(BudgetPeriod[][] models) {
		BudgetPeriodSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BudgetPeriodSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BudgetPeriodSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BudgetPeriodSoap[] toSoapModels(List<BudgetPeriod> models) {
		List<BudgetPeriodSoap> soapModels = new ArrayList<BudgetPeriodSoap>(models.size());

		for (BudgetPeriod model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BudgetPeriodSoap[soapModels.size()]);
	}

	public BudgetPeriodSoap() {
	}

	public long getPrimaryKey() {
		return _budgetPeriodId;
	}

	public void setPrimaryKey(long pk) {
		setBudgetPeriodId(pk);
	}

	public long getBudgetPeriodId() {
		return _budgetPeriodId;
	}

	public void setBudgetPeriodId(long budgetPeriodId) {
		_budgetPeriodId = budgetPeriodId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getShortDescription() {
		return _shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _budgetPeriodId;
	private long _userId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _shortDescription;
	private Date _startDate;
	private Date _endDate;
	private int _status;
}