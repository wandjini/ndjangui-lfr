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
 * This class is a wrapper for {@link Member}.
 * </p>
 *
 * @author guyw
 * @see Member
 * @generated
 */
public class MemberWrapper implements Member, ModelWrapper<Member> {
	public MemberWrapper(Member member) {
		_member = member;
	}

	@Override
	public Class<?> getModelClass() {
		return Member.class;
	}

	@Override
	public String getModelClassName() {
		return Member.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("memberId", getMemberId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("surname", getSurname());
		attributes.put("fullname", getFullname());
		attributes.put("email", getEmail());
		attributes.put("cardNumber", getCardNumber());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("rate", getRate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String surname = (String)attributes.get("surname");

		if (surname != null) {
			setSurname(surname);
		}

		String fullname = (String)attributes.get("fullname");

		if (fullname != null) {
			setFullname(fullname);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String cardNumber = (String)attributes.get("cardNumber");

		if (cardNumber != null) {
			setCardNumber(cardNumber);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		Double rate = (Double)attributes.get("rate");

		if (rate != null) {
			setRate(rate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this member.
	*
	* @return the primary key of this member
	*/
	@Override
	public long getPrimaryKey() {
		return _member.getPrimaryKey();
	}

	/**
	* Sets the primary key of this member.
	*
	* @param primaryKey the primary key of this member
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_member.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the member ID of this member.
	*
	* @return the member ID of this member
	*/
	@Override
	public long getMemberId() {
		return _member.getMemberId();
	}

	/**
	* Sets the member ID of this member.
	*
	* @param memberId the member ID of this member
	*/
	@Override
	public void setMemberId(long memberId) {
		_member.setMemberId(memberId);
	}

	/**
	* Returns the user ID of this member.
	*
	* @return the user ID of this member
	*/
	@Override
	public long getUserId() {
		return _member.getUserId();
	}

	/**
	* Sets the user ID of this member.
	*
	* @param userId the user ID of this member
	*/
	@Override
	public void setUserId(long userId) {
		_member.setUserId(userId);
	}

	/**
	* Returns the user uuid of this member.
	*
	* @return the user uuid of this member
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _member.getUserUuid();
	}

	/**
	* Sets the user uuid of this member.
	*
	* @param userUuid the user uuid of this member
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_member.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this member.
	*
	* @return the group ID of this member
	*/
	@Override
	public long getGroupId() {
		return _member.getGroupId();
	}

	/**
	* Sets the group ID of this member.
	*
	* @param groupId the group ID of this member
	*/
	@Override
	public void setGroupId(long groupId) {
		_member.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this member.
	*
	* @return the company ID of this member
	*/
	@Override
	public long getCompanyId() {
		return _member.getCompanyId();
	}

	/**
	* Sets the company ID of this member.
	*
	* @param companyId the company ID of this member
	*/
	@Override
	public void setCompanyId(long companyId) {
		_member.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this member.
	*
	* @return the user name of this member
	*/
	@Override
	public java.lang.String getUserName() {
		return _member.getUserName();
	}

	/**
	* Sets the user name of this member.
	*
	* @param userName the user name of this member
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_member.setUserName(userName);
	}

	/**
	* Returns the create date of this member.
	*
	* @return the create date of this member
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _member.getCreateDate();
	}

	/**
	* Sets the create date of this member.
	*
	* @param createDate the create date of this member
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_member.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this member.
	*
	* @return the modified date of this member
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _member.getModifiedDate();
	}

	/**
	* Sets the modified date of this member.
	*
	* @param modifiedDate the modified date of this member
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_member.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this member.
	*
	* @return the name of this member
	*/
	@Override
	public java.lang.String getName() {
		return _member.getName();
	}

	/**
	* Sets the name of this member.
	*
	* @param name the name of this member
	*/
	@Override
	public void setName(java.lang.String name) {
		_member.setName(name);
	}

	/**
	* Returns the surname of this member.
	*
	* @return the surname of this member
	*/
	@Override
	public java.lang.String getSurname() {
		return _member.getSurname();
	}

	/**
	* Sets the surname of this member.
	*
	* @param surname the surname of this member
	*/
	@Override
	public void setSurname(java.lang.String surname) {
		_member.setSurname(surname);
	}

	/**
	* Returns the fullname of this member.
	*
	* @return the fullname of this member
	*/
	@Override
	public java.lang.String getFullname() {
		return _member.getFullname();
	}

	/**
	* Sets the fullname of this member.
	*
	* @param fullname the fullname of this member
	*/
	@Override
	public void setFullname(java.lang.String fullname) {
		_member.setFullname(fullname);
	}

	/**
	* Returns the email of this member.
	*
	* @return the email of this member
	*/
	@Override
	public java.lang.String getEmail() {
		return _member.getEmail();
	}

	/**
	* Sets the email of this member.
	*
	* @param email the email of this member
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_member.setEmail(email);
	}

	/**
	* Returns the card number of this member.
	*
	* @return the card number of this member
	*/
	@Override
	public java.lang.String getCardNumber() {
		return _member.getCardNumber();
	}

	/**
	* Sets the card number of this member.
	*
	* @param cardNumber the card number of this member
	*/
	@Override
	public void setCardNumber(java.lang.String cardNumber) {
		_member.setCardNumber(cardNumber);
	}

	/**
	* Returns the phone number of this member.
	*
	* @return the phone number of this member
	*/
	@Override
	public java.lang.String getPhoneNumber() {
		return _member.getPhoneNumber();
	}

	/**
	* Sets the phone number of this member.
	*
	* @param phoneNumber the phone number of this member
	*/
	@Override
	public void setPhoneNumber(java.lang.String phoneNumber) {
		_member.setPhoneNumber(phoneNumber);
	}

	/**
	* Returns the rate of this member.
	*
	* @return the rate of this member
	*/
	@Override
	public double getRate() {
		return _member.getRate();
	}

	/**
	* Sets the rate of this member.
	*
	* @param rate the rate of this member
	*/
	@Override
	public void setRate(double rate) {
		_member.setRate(rate);
	}

	/**
	* Returns the status of this member.
	*
	* @return the status of this member
	*/
	@Override
	public int getStatus() {
		return _member.getStatus();
	}

	/**
	* Sets the status of this member.
	*
	* @param status the status of this member
	*/
	@Override
	public void setStatus(int status) {
		_member.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _member.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_member.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _member.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_member.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _member.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _member.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_member.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _member.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_member.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_member.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_member.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MemberWrapper((Member)_member.clone());
	}

	@Override
	public int compareTo(cmr.fandenatech.ndjangui.model.Member member) {
		return _member.compareTo(member);
	}

	@Override
	public int hashCode() {
		return _member.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<cmr.fandenatech.ndjangui.model.Member> toCacheModel() {
		return _member.toCacheModel();
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member toEscapedModel() {
		return new MemberWrapper(_member.toEscapedModel());
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member toUnescapedModel() {
		return new MemberWrapper(_member.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _member.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _member.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_member.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MemberWrapper)) {
			return false;
		}

		MemberWrapper memberWrapper = (MemberWrapper)obj;

		if (Validator.equals(_member, memberWrapper._member)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Member getWrappedMember() {
		return _member;
	}

	@Override
	public Member getWrappedModel() {
		return _member;
	}

	@Override
	public void resetOriginalValues() {
		_member.resetOriginalValues();
	}

	private Member _member;
}