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
 * This class is a wrapper for {@link MemberSitting}.
 * </p>
 *
 * @author guyw
 * @see MemberSitting
 * @generated
 */
public class MemberSittingWrapper implements MemberSitting,
	ModelWrapper<MemberSitting> {
	public MemberSittingWrapper(MemberSitting memberSitting) {
		_memberSitting = memberSitting;
	}

	@Override
	public Class<?> getModelClass() {
		return MemberSitting.class;
	}

	@Override
	public String getModelClassName() {
		return MemberSitting.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("memberSittingId", getMemberSittingId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("memberId", getMemberId());
		attributes.put("sittingId", getSittingId());
		attributes.put("memberName", getMemberName());
		attributes.put("sittingName", getSittingName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long memberSittingId = (Long)attributes.get("memberSittingId");

		if (memberSittingId != null) {
			setMemberSittingId(memberSittingId);
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

		Long sittingId = (Long)attributes.get("sittingId");

		if (sittingId != null) {
			setSittingId(sittingId);
		}

		String memberName = (String)attributes.get("memberName");

		if (memberName != null) {
			setMemberName(memberName);
		}

		String sittingName = (String)attributes.get("sittingName");

		if (sittingName != null) {
			setSittingName(sittingName);
		}
	}

	/**
	* Returns the primary key of this member sitting.
	*
	* @return the primary key of this member sitting
	*/
	@Override
	public long getPrimaryKey() {
		return _memberSitting.getPrimaryKey();
	}

	/**
	* Sets the primary key of this member sitting.
	*
	* @param primaryKey the primary key of this member sitting
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_memberSitting.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the member sitting ID of this member sitting.
	*
	* @return the member sitting ID of this member sitting
	*/
	@Override
	public long getMemberSittingId() {
		return _memberSitting.getMemberSittingId();
	}

	/**
	* Sets the member sitting ID of this member sitting.
	*
	* @param memberSittingId the member sitting ID of this member sitting
	*/
	@Override
	public void setMemberSittingId(long memberSittingId) {
		_memberSitting.setMemberSittingId(memberSittingId);
	}

	/**
	* Returns the user ID of this member sitting.
	*
	* @return the user ID of this member sitting
	*/
	@Override
	public long getUserId() {
		return _memberSitting.getUserId();
	}

	/**
	* Sets the user ID of this member sitting.
	*
	* @param userId the user ID of this member sitting
	*/
	@Override
	public void setUserId(long userId) {
		_memberSitting.setUserId(userId);
	}

	/**
	* Returns the user uuid of this member sitting.
	*
	* @return the user uuid of this member sitting
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberSitting.getUserUuid();
	}

	/**
	* Sets the user uuid of this member sitting.
	*
	* @param userUuid the user uuid of this member sitting
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_memberSitting.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this member sitting.
	*
	* @return the group ID of this member sitting
	*/
	@Override
	public long getGroupId() {
		return _memberSitting.getGroupId();
	}

	/**
	* Sets the group ID of this member sitting.
	*
	* @param groupId the group ID of this member sitting
	*/
	@Override
	public void setGroupId(long groupId) {
		_memberSitting.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this member sitting.
	*
	* @return the company ID of this member sitting
	*/
	@Override
	public long getCompanyId() {
		return _memberSitting.getCompanyId();
	}

	/**
	* Sets the company ID of this member sitting.
	*
	* @param companyId the company ID of this member sitting
	*/
	@Override
	public void setCompanyId(long companyId) {
		_memberSitting.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this member sitting.
	*
	* @return the user name of this member sitting
	*/
	@Override
	public java.lang.String getUserName() {
		return _memberSitting.getUserName();
	}

	/**
	* Sets the user name of this member sitting.
	*
	* @param userName the user name of this member sitting
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_memberSitting.setUserName(userName);
	}

	/**
	* Returns the create date of this member sitting.
	*
	* @return the create date of this member sitting
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _memberSitting.getCreateDate();
	}

	/**
	* Sets the create date of this member sitting.
	*
	* @param createDate the create date of this member sitting
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_memberSitting.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this member sitting.
	*
	* @return the modified date of this member sitting
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _memberSitting.getModifiedDate();
	}

	/**
	* Sets the modified date of this member sitting.
	*
	* @param modifiedDate the modified date of this member sitting
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_memberSitting.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the member ID of this member sitting.
	*
	* @return the member ID of this member sitting
	*/
	@Override
	public long getMemberId() {
		return _memberSitting.getMemberId();
	}

	/**
	* Sets the member ID of this member sitting.
	*
	* @param memberId the member ID of this member sitting
	*/
	@Override
	public void setMemberId(long memberId) {
		_memberSitting.setMemberId(memberId);
	}

	/**
	* Returns the sitting ID of this member sitting.
	*
	* @return the sitting ID of this member sitting
	*/
	@Override
	public long getSittingId() {
		return _memberSitting.getSittingId();
	}

	/**
	* Sets the sitting ID of this member sitting.
	*
	* @param sittingId the sitting ID of this member sitting
	*/
	@Override
	public void setSittingId(long sittingId) {
		_memberSitting.setSittingId(sittingId);
	}

	/**
	* Returns the member name of this member sitting.
	*
	* @return the member name of this member sitting
	*/
	@Override
	public java.lang.String getMemberName() {
		return _memberSitting.getMemberName();
	}

	/**
	* Sets the member name of this member sitting.
	*
	* @param memberName the member name of this member sitting
	*/
	@Override
	public void setMemberName(java.lang.String memberName) {
		_memberSitting.setMemberName(memberName);
	}

	/**
	* Returns the sitting name of this member sitting.
	*
	* @return the sitting name of this member sitting
	*/
	@Override
	public java.lang.String getSittingName() {
		return _memberSitting.getSittingName();
	}

	/**
	* Sets the sitting name of this member sitting.
	*
	* @param sittingName the sitting name of this member sitting
	*/
	@Override
	public void setSittingName(java.lang.String sittingName) {
		_memberSitting.setSittingName(sittingName);
	}

	@Override
	public boolean isNew() {
		return _memberSitting.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_memberSitting.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _memberSitting.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_memberSitting.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _memberSitting.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _memberSitting.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_memberSitting.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _memberSitting.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_memberSitting.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_memberSitting.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_memberSitting.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MemberSittingWrapper((MemberSitting)_memberSitting.clone());
	}

	@Override
	public int compareTo(
		cmr.fandenatech.ndjangui.model.MemberSitting memberSitting) {
		return _memberSitting.compareTo(memberSitting);
	}

	@Override
	public int hashCode() {
		return _memberSitting.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<cmr.fandenatech.ndjangui.model.MemberSitting> toCacheModel() {
		return _memberSitting.toCacheModel();
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting toEscapedModel() {
		return new MemberSittingWrapper(_memberSitting.toEscapedModel());
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting toUnescapedModel() {
		return new MemberSittingWrapper(_memberSitting.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _memberSitting.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _memberSitting.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_memberSitting.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MemberSittingWrapper)) {
			return false;
		}

		MemberSittingWrapper memberSittingWrapper = (MemberSittingWrapper)obj;

		if (Validator.equals(_memberSitting, memberSittingWrapper._memberSitting)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MemberSitting getWrappedMemberSitting() {
		return _memberSitting;
	}

	@Override
	public MemberSitting getWrappedModel() {
		return _memberSitting;
	}

	@Override
	public void resetOriginalValues() {
		_memberSitting.resetOriginalValues();
	}

	private MemberSitting _memberSitting;
}