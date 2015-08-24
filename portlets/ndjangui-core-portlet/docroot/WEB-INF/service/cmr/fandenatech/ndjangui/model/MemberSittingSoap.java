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
 * This class is used by SOAP remote services, specifically {@link cmr.fandenatech.ndjangui.service.http.MemberSittingServiceSoap}.
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.http.MemberSittingServiceSoap
 * @generated
 */
public class MemberSittingSoap implements Serializable {
	public static MemberSittingSoap toSoapModel(MemberSitting model) {
		MemberSittingSoap soapModel = new MemberSittingSoap();

		soapModel.setMemberSittingId(model.getMemberSittingId());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMemberId(model.getMemberId());
		soapModel.setSittingId(model.getSittingId());
		soapModel.setMemberName(model.getMemberName());
		soapModel.setSittingName(model.getSittingName());

		return soapModel;
	}

	public static MemberSittingSoap[] toSoapModels(MemberSitting[] models) {
		MemberSittingSoap[] soapModels = new MemberSittingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MemberSittingSoap[][] toSoapModels(MemberSitting[][] models) {
		MemberSittingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MemberSittingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MemberSittingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MemberSittingSoap[] toSoapModels(List<MemberSitting> models) {
		List<MemberSittingSoap> soapModels = new ArrayList<MemberSittingSoap>(models.size());

		for (MemberSitting model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MemberSittingSoap[soapModels.size()]);
	}

	public MemberSittingSoap() {
	}

	public long getPrimaryKey() {
		return _memberSittingId;
	}

	public void setPrimaryKey(long pk) {
		setMemberSittingId(pk);
	}

	public long getMemberSittingId() {
		return _memberSittingId;
	}

	public void setMemberSittingId(long memberSittingId) {
		_memberSittingId = memberSittingId;
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

	public long getSittingId() {
		return _sittingId;
	}

	public void setSittingId(long sittingId) {
		_sittingId = sittingId;
	}

	public String getMemberName() {
		return _memberName;
	}

	public void setMemberName(String memberName) {
		_memberName = memberName;
	}

	public String getSittingName() {
		return _sittingName;
	}

	public void setSittingName(String sittingName) {
		_sittingName = sittingName;
	}

	private long _memberSittingId;
	private long _userId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _memberId;
	private long _sittingId;
	private String _memberName;
	private String _sittingName;
}