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
 * This class is used by SOAP remote services, specifically {@link cmr.fandenatech.ndjangui.service.http.MemberServiceSoap}.
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.http.MemberServiceSoap
 * @generated
 */
public class MemberSoap implements Serializable {
	public static MemberSoap toSoapModel(Member model) {
		MemberSoap soapModel = new MemberSoap();

		soapModel.setMemberId(model.getMemberId());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setSurname(model.getSurname());
		soapModel.setFullname(model.getFullname());
		soapModel.setEmail(model.getEmail());
		soapModel.setCardNumber(model.getCardNumber());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setRate(model.getRate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static MemberSoap[] toSoapModels(Member[] models) {
		MemberSoap[] soapModels = new MemberSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MemberSoap[][] toSoapModels(Member[][] models) {
		MemberSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MemberSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MemberSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MemberSoap[] toSoapModels(List<Member> models) {
		List<MemberSoap> soapModels = new ArrayList<MemberSoap>(models.size());

		for (Member model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MemberSoap[soapModels.size()]);
	}

	public MemberSoap() {
	}

	public long getPrimaryKey() {
		return _memberId;
	}

	public void setPrimaryKey(long pk) {
		setMemberId(pk);
	}

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
		_memberId = memberId;
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

	public String getSurname() {
		return _surname;
	}

	public void setSurname(String surname) {
		_surname = surname;
	}

	public String getFullname() {
		return _fullname;
	}

	public void setFullname(String fullname) {
		_fullname = fullname;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getCardNumber() {
		return _cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		_cardNumber = cardNumber;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public double getRate() {
		return _rate;
	}

	public void setRate(double rate) {
		_rate = rate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _memberId;
	private long _userId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _surname;
	private String _fullname;
	private String _email;
	private String _cardNumber;
	private String _phoneNumber;
	private double _rate;
	private int _status;
}