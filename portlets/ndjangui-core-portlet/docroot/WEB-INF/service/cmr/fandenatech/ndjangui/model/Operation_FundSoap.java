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
 * This class is used by SOAP remote services, specifically {@link cmr.fandenatech.ndjangui.service.http.Operation_FundServiceSoap}.
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.http.Operation_FundServiceSoap
 * @generated
 */
public class Operation_FundSoap implements Serializable {
	public static Operation_FundSoap toSoapModel(Operation_Fund model) {
		Operation_FundSoap soapModel = new Operation_FundSoap();

		soapModel.setOperationFundId(model.getOperationFundId());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setOperationId(model.getOperationId());
		soapModel.setSrcFundClassPK(model.getSrcFundClassPK());
		soapModel.setSrcFundClassName(model.getSrcFundClassName());
		soapModel.setDestFundClassPK(model.getDestFundClassPK());
		soapModel.setDestFundClassName(model.getDestFundClassName());

		return soapModel;
	}

	public static Operation_FundSoap[] toSoapModels(Operation_Fund[] models) {
		Operation_FundSoap[] soapModels = new Operation_FundSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Operation_FundSoap[][] toSoapModels(Operation_Fund[][] models) {
		Operation_FundSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Operation_FundSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Operation_FundSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Operation_FundSoap[] toSoapModels(List<Operation_Fund> models) {
		List<Operation_FundSoap> soapModels = new ArrayList<Operation_FundSoap>(models.size());

		for (Operation_Fund model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Operation_FundSoap[soapModels.size()]);
	}

	public Operation_FundSoap() {
	}

	public long getPrimaryKey() {
		return _operationFundId;
	}

	public void setPrimaryKey(long pk) {
		setOperationFundId(pk);
	}

	public long getOperationFundId() {
		return _operationFundId;
	}

	public void setOperationFundId(long operationFundId) {
		_operationFundId = operationFundId;
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

	public long getOperationId() {
		return _operationId;
	}

	public void setOperationId(long operationId) {
		_operationId = operationId;
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

	private long _operationFundId;
	private long _userId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _operationId;
	private long _srcFundClassPK;
	private String _srcFundClassName;
	private long _destFundClassPK;
	private String _destFundClassName;
}