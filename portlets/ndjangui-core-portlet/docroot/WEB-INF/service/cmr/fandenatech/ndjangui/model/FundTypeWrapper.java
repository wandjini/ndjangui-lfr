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
 * This class is a wrapper for {@link FundType}.
 * </p>
 *
 * @author guyw
 * @see FundType
 * @generated
 */
public class FundTypeWrapper implements FundType, ModelWrapper<FundType> {
	public FundTypeWrapper(FundType fundType) {
		_fundType = fundType;
	}

	@Override
	public Class<?> getModelClass() {
		return FundType.class;
	}

	@Override
	public String getModelClassName() {
		return FundType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fundTypeId", getFundTypeId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fundTypeId = (Long)attributes.get("fundTypeId");

		if (fundTypeId != null) {
			setFundTypeId(fundTypeId);
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

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this fund type.
	*
	* @return the primary key of this fund type
	*/
	@Override
	public long getPrimaryKey() {
		return _fundType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fund type.
	*
	* @param primaryKey the primary key of this fund type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_fundType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fund type ID of this fund type.
	*
	* @return the fund type ID of this fund type
	*/
	@Override
	public long getFundTypeId() {
		return _fundType.getFundTypeId();
	}

	/**
	* Sets the fund type ID of this fund type.
	*
	* @param fundTypeId the fund type ID of this fund type
	*/
	@Override
	public void setFundTypeId(long fundTypeId) {
		_fundType.setFundTypeId(fundTypeId);
	}

	/**
	* Returns the user ID of this fund type.
	*
	* @return the user ID of this fund type
	*/
	@Override
	public long getUserId() {
		return _fundType.getUserId();
	}

	/**
	* Sets the user ID of this fund type.
	*
	* @param userId the user ID of this fund type
	*/
	@Override
	public void setUserId(long userId) {
		_fundType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fund type.
	*
	* @return the user uuid of this fund type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundType.getUserUuid();
	}

	/**
	* Sets the user uuid of this fund type.
	*
	* @param userUuid the user uuid of this fund type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_fundType.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this fund type.
	*
	* @return the group ID of this fund type
	*/
	@Override
	public long getGroupId() {
		return _fundType.getGroupId();
	}

	/**
	* Sets the group ID of this fund type.
	*
	* @param groupId the group ID of this fund type
	*/
	@Override
	public void setGroupId(long groupId) {
		_fundType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this fund type.
	*
	* @return the company ID of this fund type
	*/
	@Override
	public long getCompanyId() {
		return _fundType.getCompanyId();
	}

	/**
	* Sets the company ID of this fund type.
	*
	* @param companyId the company ID of this fund type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_fundType.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this fund type.
	*
	* @return the user name of this fund type
	*/
	@Override
	public java.lang.String getUserName() {
		return _fundType.getUserName();
	}

	/**
	* Sets the user name of this fund type.
	*
	* @param userName the user name of this fund type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_fundType.setUserName(userName);
	}

	/**
	* Returns the create date of this fund type.
	*
	* @return the create date of this fund type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _fundType.getCreateDate();
	}

	/**
	* Sets the create date of this fund type.
	*
	* @param createDate the create date of this fund type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_fundType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this fund type.
	*
	* @return the modified date of this fund type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _fundType.getModifiedDate();
	}

	/**
	* Sets the modified date of this fund type.
	*
	* @param modifiedDate the modified date of this fund type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_fundType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this fund type.
	*
	* @return the name of this fund type
	*/
	@Override
	public java.lang.String getName() {
		return _fundType.getName();
	}

	/**
	* Sets the name of this fund type.
	*
	* @param name the name of this fund type
	*/
	@Override
	public void setName(java.lang.String name) {
		_fundType.setName(name);
	}

	/**
	* Returns the short description of this fund type.
	*
	* @return the short description of this fund type
	*/
	@Override
	public java.lang.String getShortDescription() {
		return _fundType.getShortDescription();
	}

	/**
	* Sets the short description of this fund type.
	*
	* @param shortDescription the short description of this fund type
	*/
	@Override
	public void setShortDescription(java.lang.String shortDescription) {
		_fundType.setShortDescription(shortDescription);
	}

	/**
	* Returns the status of this fund type.
	*
	* @return the status of this fund type
	*/
	@Override
	public int getStatus() {
		return _fundType.getStatus();
	}

	/**
	* Sets the status of this fund type.
	*
	* @param status the status of this fund type
	*/
	@Override
	public void setStatus(int status) {
		_fundType.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _fundType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_fundType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _fundType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fundType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _fundType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _fundType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_fundType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _fundType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_fundType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_fundType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_fundType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FundTypeWrapper((FundType)_fundType.clone());
	}

	@Override
	public int compareTo(cmr.fandenatech.ndjangui.model.FundType fundType) {
		return _fundType.compareTo(fundType);
	}

	@Override
	public int hashCode() {
		return _fundType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<cmr.fandenatech.ndjangui.model.FundType> toCacheModel() {
		return _fundType.toCacheModel();
	}

	@Override
	public cmr.fandenatech.ndjangui.model.FundType toEscapedModel() {
		return new FundTypeWrapper(_fundType.toEscapedModel());
	}

	@Override
	public cmr.fandenatech.ndjangui.model.FundType toUnescapedModel() {
		return new FundTypeWrapper(_fundType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _fundType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _fundType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_fundType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FundTypeWrapper)) {
			return false;
		}

		FundTypeWrapper fundTypeWrapper = (FundTypeWrapper)obj;

		if (Validator.equals(_fundType, fundTypeWrapper._fundType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FundType getWrappedFundType() {
		return _fundType;
	}

	@Override
	public FundType getWrappedModel() {
		return _fundType;
	}

	@Override
	public void resetOriginalValues() {
		_fundType.resetOriginalValues();
	}

	private FundType _fundType;
}