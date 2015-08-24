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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Member_Fund}.
 * </p>
 *
 * @author guyw
 * @see Member_Fund
 * @generated
 */
public class Member_FundWrapper implements Member_Fund,
	ModelWrapper<Member_Fund> {
	public Member_FundWrapper(Member_Fund member_Fund) {
		_member_Fund = member_Fund;
	}

	@Override
	public Class<?> getModelClass() {
		return Member_Fund.class;
	}

	@Override
	public String getModelClassName() {
		return Member_Fund.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("memberFundId", getMemberFundId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("memberId", getMemberId());
		attributes.put("fundId", getFundId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long memberFundId = (Long)attributes.get("memberFundId");

		if (memberFundId != null) {
			setMemberFundId(memberFundId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		Long fundId = (Long)attributes.get("fundId");

		if (fundId != null) {
			setFundId(fundId);
		}
	}

	/**
	* Returns the primary key of this member_ fund.
	*
	* @return the primary key of this member_ fund
	*/
	@Override
	public long getPrimaryKey() {
		return _member_Fund.getPrimaryKey();
	}

	/**
	* Sets the primary key of this member_ fund.
	*
	* @param primaryKey the primary key of this member_ fund
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_member_Fund.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the member fund ID of this member_ fund.
	*
	* @return the member fund ID of this member_ fund
	*/
	@Override
	public long getMemberFundId() {
		return _member_Fund.getMemberFundId();
	}

	/**
	* Sets the member fund ID of this member_ fund.
	*
	* @param memberFundId the member fund ID of this member_ fund
	*/
	@Override
	public void setMemberFundId(long memberFundId) {
		_member_Fund.setMemberFundId(memberFundId);
	}

	/**
	* Returns the create date of this member_ fund.
	*
	* @return the create date of this member_ fund
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _member_Fund.getCreateDate();
	}

	/**
	* Sets the create date of this member_ fund.
	*
	* @param createDate the create date of this member_ fund
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_member_Fund.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this member_ fund.
	*
	* @return the modified date of this member_ fund
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _member_Fund.getModifiedDate();
	}

	/**
	* Sets the modified date of this member_ fund.
	*
	* @param modifiedDate the modified date of this member_ fund
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_member_Fund.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the member ID of this member_ fund.
	*
	* @return the member ID of this member_ fund
	*/
	@Override
	public long getMemberId() {
		return _member_Fund.getMemberId();
	}

	/**
	* Sets the member ID of this member_ fund.
	*
	* @param memberId the member ID of this member_ fund
	*/
	@Override
	public void setMemberId(long memberId) {
		_member_Fund.setMemberId(memberId);
	}

	/**
	* Returns the fund ID of this member_ fund.
	*
	* @return the fund ID of this member_ fund
	*/
	@Override
	public long getFundId() {
		return _member_Fund.getFundId();
	}

	/**
	* Sets the fund ID of this member_ fund.
	*
	* @param fundId the fund ID of this member_ fund
	*/
	@Override
	public void setFundId(long fundId) {
		_member_Fund.setFundId(fundId);
	}

	@Override
	public boolean isNew() {
		return _member_Fund.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_member_Fund.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _member_Fund.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_member_Fund.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _member_Fund.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _member_Fund.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_member_Fund.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _member_Fund.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_member_Fund.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_member_Fund.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_member_Fund.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Member_FundWrapper((Member_Fund)_member_Fund.clone());
	}

	@Override
	public int compareTo(cmr.fandenatech.ndjangui.model.Member_Fund member_Fund) {
		return _member_Fund.compareTo(member_Fund);
	}

	@Override
	public int hashCode() {
		return _member_Fund.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<cmr.fandenatech.ndjangui.model.Member_Fund> toCacheModel() {
		return _member_Fund.toCacheModel();
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member_Fund toEscapedModel() {
		return new Member_FundWrapper(_member_Fund.toEscapedModel());
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member_Fund toUnescapedModel() {
		return new Member_FundWrapper(_member_Fund.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _member_Fund.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _member_Fund.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_member_Fund.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Member_FundWrapper)) {
			return false;
		}

		Member_FundWrapper member_FundWrapper = (Member_FundWrapper)obj;

		if (Validator.equals(_member_Fund, member_FundWrapper._member_Fund)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Member_Fund getWrappedMember_Fund() {
		return _member_Fund;
	}

	@Override
	public Member_Fund getWrappedModel() {
		return _member_Fund;
	}

	@Override
	public void resetOriginalValues() {
		_member_Fund.resetOriginalValues();
	}

	private Member_Fund _member_Fund;
}