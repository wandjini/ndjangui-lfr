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
 * This class is used by SOAP remote services, specifically {@link cmr.fandenatech.ndjangui.service.http.MemberFundServiceSoap}.
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.http.MemberFundServiceSoap
 * @generated
 */
public class MemberFundSoap implements Serializable {
	public static MemberFundSoap toSoapModel(MemberFund model) {
		MemberFundSoap soapModel = new MemberFundSoap();

		soapModel.setMemberFundId(model.getMemberFundId());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMemberId(model.getMemberId());
		soapModel.setFundId(model.getFundId());
		soapModel.setMemberName(model.getMemberName());
		soapModel.setFundName(model.getFundName());

		return soapModel;
	}

	public static MemberFundSoap[] toSoapModels(MemberFund[] models) {
		MemberFundSoap[] soapModels = new MemberFundSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MemberFundSoap[][] toSoapModels(MemberFund[][] models) {
		MemberFundSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MemberFundSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MemberFundSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MemberFundSoap[] toSoapModels(List<MemberFund> models) {
		List<MemberFundSoap> soapModels = new ArrayList<MemberFundSoap>(models.size());

		for (MemberFund model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MemberFundSoap[soapModels.size()]);
	}

	public MemberFundSoap() {
	}

	public long getPrimaryKey() {
		return _memberFundId;
	}

	public void setPrimaryKey(long pk) {
		setMemberFundId(pk);
	}

	public long getMemberFundId() {
		return _memberFundId;
	}

	public void setMemberFundId(long memberFundId) {
		_memberFundId = memberFundId;
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

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
		_memberId = memberId;
	}

	public long getFundId() {
		return _fundId;
	}

	public void setFundId(long fundId) {
		_fundId = fundId;
	}

	public String getMemberName() {
		return _memberName;
	}

	public void setMemberName(String memberName) {
		_memberName = memberName;
	}

	public String getFundName() {
		return _fundName;
	}

	public void setFundName(String fundName) {
		_fundName = fundName;
	}

	private long _memberFundId;
	private long _userId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _memberId;
	private long _fundId;
	private String _memberName;
	private String _fundName;
}