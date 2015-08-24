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
 * This class is used by SOAP remote services, specifically {@link cmr.fandenatech.ndjangui.service.http.Member_FundServiceSoap}.
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.http.Member_FundServiceSoap
 * @generated
 */
public class Member_FundSoap implements Serializable {
	public static Member_FundSoap toSoapModel(Member_Fund model) {
		Member_FundSoap soapModel = new Member_FundSoap();

		soapModel.setMemberFundId(model.getMemberFundId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMemberId(model.getMemberId());
		soapModel.setFundId(model.getFundId());

		return soapModel;
	}

	public static Member_FundSoap[] toSoapModels(Member_Fund[] models) {
		Member_FundSoap[] soapModels = new Member_FundSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Member_FundSoap[][] toSoapModels(Member_Fund[][] models) {
		Member_FundSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Member_FundSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Member_FundSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Member_FundSoap[] toSoapModels(List<Member_Fund> models) {
		List<Member_FundSoap> soapModels = new ArrayList<Member_FundSoap>(models.size());

		for (Member_Fund model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Member_FundSoap[soapModels.size()]);
	}

	public Member_FundSoap() {
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

	private long _memberFundId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _memberId;
	private long _fundId;
}