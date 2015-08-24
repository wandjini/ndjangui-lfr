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
 * This class is a wrapper for {@link MemberFund}.
 * </p>
 *
 * @author guyw
 * @see MemberFund
 * @generated
 */
public class MemberFundWrapper implements MemberFund, ModelWrapper<MemberFund> {
	public MemberFundWrapper(MemberFund memberFund) {
		_memberFund = memberFund;
	}

	@Override
	public Class<?> getModelClass() {
		return MemberFund.class;
	}

	@Override
	public String getModelClassName() {
		return MemberFund.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("memberFundId", getMemberFundId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("memberId", getMemberId());
		attributes.put("fundId", getFundId());
		attributes.put("memberName", getMemberName());
		attributes.put("fundName", getFundName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long memberFundId = (Long)attributes.get("memberFundId");

		if (memberFundId != null) {
			setMemberFundId(memberFundId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
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

		String memberName = (String)attributes.get("memberName");

		if (memberName != null) {
			setMemberName(memberName);
		}

		String fundName = (String)attributes.get("fundName");

		if (fundName != null) {
			setFundName(fundName);
		}
	}

	/**
	* Returns the primary key of this member fund.
	*
	* @return the primary key of this member fund
	*/
	@Override
	public long getPrimaryKey() {
		return _memberFund.getPrimaryKey();
	}

	/**
	* Sets the primary key of this member fund.
	*
	* @param primaryKey the primary key of this member fund
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_memberFund.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the member fund ID of this member fund.
	*
	* @return the member fund ID of this member fund
	*/
	@Override
	public long getMemberFundId() {
		return _memberFund.getMemberFundId();
	}

	/**
	* Sets the member fund ID of this member fund.
	*
	* @param memberFundId the member fund ID of this member fund
	*/
	@Override
	public void setMemberFundId(long memberFundId) {
		_memberFund.setMemberFundId(memberFundId);
	}

	/**
	* Returns the user ID of this member fund.
	*
	* @return the user ID of this member fund
	*/
	@Override
	public long getUserId() {
		return _memberFund.getUserId();
	}

	/**
	* Sets the user ID of this member fund.
	*
	* @param userId the user ID of this member fund
	*/
	@Override
	public void setUserId(long userId) {
		_memberFund.setUserId(userId);
	}

	/**
	* Returns the user uuid of this member fund.
	*
	* @return the user uuid of this member fund
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberFund.getUserUuid();
	}

	/**
	* Sets the user uuid of this member fund.
	*
	* @param userUuid the user uuid of this member fund
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_memberFund.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this member fund.
	*
	* @return the group ID of this member fund
	*/
	@Override
	public long getGroupId() {
		return _memberFund.getGroupId();
	}

	/**
	* Sets the group ID of this member fund.
	*
	* @param groupId the group ID of this member fund
	*/
	@Override
	public void setGroupId(long groupId) {
		_memberFund.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this member fund.
	*
	* @return the company ID of this member fund
	*/
	@Override
	public long getCompanyId() {
		return _memberFund.getCompanyId();
	}

	/**
	* Sets the company ID of this member fund.
	*
	* @param companyId the company ID of this member fund
	*/
	@Override
	public void setCompanyId(long companyId) {
		_memberFund.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this member fund.
	*
	* @return the user name of this member fund
	*/
	@Override
	public java.lang.String getUserName() {
		return _memberFund.getUserName();
	}

	/**
	* Sets the user name of this member fund.
	*
	* @param userName the user name of this member fund
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_memberFund.setUserName(userName);
	}

	/**
	* Returns the create date of this member fund.
	*
	* @return the create date of this member fund
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _memberFund.getCreateDate();
	}

	/**
	* Sets the create date of this member fund.
	*
	* @param createDate the create date of this member fund
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_memberFund.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this member fund.
	*
	* @return the modified date of this member fund
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _memberFund.getModifiedDate();
	}

	/**
	* Sets the modified date of this member fund.
	*
	* @param modifiedDate the modified date of this member fund
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_memberFund.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the member ID of this member fund.
	*
	* @return the member ID of this member fund
	*/
	@Override
	public long getMemberId() {
		return _memberFund.getMemberId();
	}

	/**
	* Sets the member ID of this member fund.
	*
	* @param memberId the member ID of this member fund
	*/
	@Override
	public void setMemberId(long memberId) {
		_memberFund.setMemberId(memberId);
	}

	/**
	* Returns the fund ID of this member fund.
	*
	* @return the fund ID of this member fund
	*/
	@Override
	public long getFundId() {
		return _memberFund.getFundId();
	}

	/**
	* Sets the fund ID of this member fund.
	*
	* @param fundId the fund ID of this member fund
	*/
	@Override
	public void setFundId(long fundId) {
		_memberFund.setFundId(fundId);
	}

	/**
	* Returns the member name of this member fund.
	*
	* @return the member name of this member fund
	*/
	@Override
	public java.lang.String getMemberName() {
		return _memberFund.getMemberName();
	}

	/**
	* Sets the member name of this member fund.
	*
	* @param memberName the member name of this member fund
	*/
	@Override
	public void setMemberName(java.lang.String memberName) {
		_memberFund.setMemberName(memberName);
	}

	/**
	* Returns the fund name of this member fund.
	*
	* @return the fund name of this member fund
	*/
	@Override
	public java.lang.String getFundName() {
		return _memberFund.getFundName();
	}

	/**
	* Sets the fund name of this member fund.
	*
	* @param fundName the fund name of this member fund
	*/
	@Override
	public void setFundName(java.lang.String fundName) {
		_memberFund.setFundName(fundName);
	}

	@Override
	public boolean isNew() {
		return _memberFund.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_memberFund.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _memberFund.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_memberFund.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _memberFund.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _memberFund.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_memberFund.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _memberFund.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_memberFund.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_memberFund.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_memberFund.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MemberFundWrapper((MemberFund)_memberFund.clone());
	}

	@Override
	public int compareTo(cmr.fandenatech.ndjangui.model.MemberFund memberFund) {
		return _memberFund.compareTo(memberFund);
	}

	@Override
	public int hashCode() {
		return _memberFund.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<cmr.fandenatech.ndjangui.model.MemberFund> toCacheModel() {
		return _memberFund.toCacheModel();
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberFund toEscapedModel() {
		return new MemberFundWrapper(_memberFund.toEscapedModel());
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberFund toUnescapedModel() {
		return new MemberFundWrapper(_memberFund.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _memberFund.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _memberFund.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_memberFund.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MemberFundWrapper)) {
			return false;
		}

		MemberFundWrapper memberFundWrapper = (MemberFundWrapper)obj;

		if (Validator.equals(_memberFund, memberFundWrapper._memberFund)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MemberFund getWrappedMemberFund() {
		return _memberFund;
	}

	@Override
	public MemberFund getWrappedModel() {
		return _memberFund;
	}

	@Override
	public void resetOriginalValues() {
		_memberFund.resetOriginalValues();
	}

	private MemberFund _memberFund;
}