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
 * This class is used by SOAP remote services, specifically {@link cmr.fandenatech.ndjangui.service.http.FundServiceSoap}.
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.http.FundServiceSoap
 * @generated
 */
public class FundSoap implements Serializable {
	public static FundSoap toSoapModel(Fund model) {
		FundSoap soapModel = new FundSoap();

		soapModel.setFundId(model.getFundId());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBudgetPeriodId(model.getBudgetPeriodId());
		soapModel.setName(model.getName());
		soapModel.setShortDescription(model.getShortDescription());
		soapModel.setFundTypeId(model.getFundTypeId());
		soapModel.setFundType(model.getFundType());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static FundSoap[] toSoapModels(Fund[] models) {
		FundSoap[] soapModels = new FundSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FundSoap[][] toSoapModels(Fund[][] models) {
		FundSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FundSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FundSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FundSoap[] toSoapModels(List<Fund> models) {
		List<FundSoap> soapModels = new ArrayList<FundSoap>(models.size());

		for (Fund model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FundSoap[soapModels.size()]);
	}

	public FundSoap() {
	}

	public long getPrimaryKey() {
		return _fundId;
	}

	public void setPrimaryKey(long pk) {
		setFundId(pk);
	}

	public long getFundId() {
		return _fundId;
	}

	public void setFundId(long fundId) {
		_fundId = fundId;
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

	public String getShortDescription() {
		return _shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;
	}

	public long getFundTypeId() {
		return _fundTypeId;
	}

	public void setFundTypeId(long fundTypeId) {
		_fundTypeId = fundTypeId;
	}

	public String getFundType() {
		return _fundType;
	}

	public void setFundType(String fundType) {
		_fundType = fundType;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _fundId;
	private long _userId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _budgetPeriodId;
	private String _name;
	private String _shortDescription;
	private long _fundTypeId;
	private String _fundType;
	private int _status;
}