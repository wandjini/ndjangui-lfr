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
 * This class is used by SOAP remote services, specifically {@link cmr.fandenatech.ndjangui.service.http.OperationServiceSoap}.
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.http.OperationServiceSoap
 * @generated
 */
public class OperationSoap implements Serializable {
	public static OperationSoap toSoapModel(Operation model) {
		OperationSoap soapModel = new OperationSoap();

		soapModel.setOperationId(model.getOperationId());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBudgetPeriodId(model.getBudgetPeriodId());
		soapModel.setName(model.getName());
		soapModel.setShortDescription(model.getShortDescription());
		soapModel.setOperationTypeId(model.getOperationTypeId());
		soapModel.setSittingId(model.getSittingId());
		soapModel.setStatus(model.getStatus());
		soapModel.setAmount(model.getAmount());
		soapModel.setSrcFundClassPK(model.getSrcFundClassPK());
		soapModel.setSrcFundClassName(model.getSrcFundClassName());
		soapModel.setDestFundClassPK(model.getDestFundClassPK());
		soapModel.setDestFundClassName(model.getDestFundClassName());

		return soapModel;
	}

	public static OperationSoap[] toSoapModels(Operation[] models) {
		OperationSoap[] soapModels = new OperationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OperationSoap[][] toSoapModels(Operation[][] models) {
		OperationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OperationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OperationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OperationSoap[] toSoapModels(List<Operation> models) {
		List<OperationSoap> soapModels = new ArrayList<OperationSoap>(models.size());

		for (Operation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OperationSoap[soapModels.size()]);
	}

	public OperationSoap() {
	}

	public long getPrimaryKey() {
		return _operationId;
	}

	public void setPrimaryKey(long pk) {
		setOperationId(pk);
	}

	public long getOperationId() {
		return _operationId;
	}

	public void setOperationId(long operationId) {
		_operationId = operationId;
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

	public long getOperationTypeId() {
		return _operationTypeId;
	}

	public void setOperationTypeId(long operationTypeId) {
		_operationTypeId = operationTypeId;
	}

	public long getSittingId() {
		return _sittingId;
	}

	public void setSittingId(long sittingId) {
		_sittingId = sittingId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public long getSrcFundClassPK() {
		return _srcFundClassPK;
	}

	public void setSrcFundClassPK(long srcFundClassPK) {
		_srcFundClassPK = srcFundClassPK;
	}

	public String getSrcFundClassName() {
		return _srcFundClassName;
	}

	public void setSrcFundClassName(String srcFundClassName) {
		_srcFundClassName = srcFundClassName;
	}

	public long getDestFundClassPK() {
		return _destFundClassPK;
	}

	public void setDestFundClassPK(long destFundClassPK) {
		_destFundClassPK = destFundClassPK;
	}

	public String getDestFundClassName() {
		return _destFundClassName;
	}

	public void setDestFundClassName(String destFundClassName) {
		_destFundClassName = destFundClassName;
	}

	private long _operationId;
	private long _userId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _budgetPeriodId;
	private String _name;
	private String _shortDescription;
	private long _operationTypeId;
	private long _sittingId;
	private int _status;
	private double _amount;
	private long _srcFundClassPK;
	private String _srcFundClassName;
	private long _destFundClassPK;
	private String _destFundClassName;
}