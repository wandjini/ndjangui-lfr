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
 * This class is used by SOAP remote services, specifically {@link cmr.fandenatech.ndjangui.service.http.SanctionTypeServiceSoap}.
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.http.SanctionTypeServiceSoap
 * @generated
 */
public class SanctionTypeSoap implements Serializable {
	public static SanctionTypeSoap toSoapModel(SanctionType model) {
		SanctionTypeSoap soapModel = new SanctionTypeSoap();

		soapModel.setSanctionTypeId(model.getSanctionTypeId());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setShortDescription(model.getShortDescription());
		soapModel.setAmount(model.getAmount());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static SanctionTypeSoap[] toSoapModels(SanctionType[] models) {
		SanctionTypeSoap[] soapModels = new SanctionTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SanctionTypeSoap[][] toSoapModels(SanctionType[][] models) {
		SanctionTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SanctionTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SanctionTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SanctionTypeSoap[] toSoapModels(List<SanctionType> models) {
		List<SanctionTypeSoap> soapModels = new ArrayList<SanctionTypeSoap>(models.size());

		for (SanctionType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SanctionTypeSoap[soapModels.size()]);
	}

	public SanctionTypeSoap() {
	}

	public long getPrimaryKey() {
		return _sanctionTypeId;
	}

	public void setPrimaryKey(long pk) {
		setSanctionTypeId(pk);
	}

	public long getSanctionTypeId() {
		return _sanctionTypeId;
	}

	public void setSanctionTypeId(long sanctionTypeId) {
		_sanctionTypeId = sanctionTypeId;
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

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _sanctionTypeId;
	private long _userId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _shortDescription;
	private double _amount;
	private int _status;
}