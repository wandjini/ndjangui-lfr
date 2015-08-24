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
 * This class is a wrapper for {@link SanctionType}.
 * </p>
 *
 * @author guyw
 * @see SanctionType
 * @generated
 */
public class SanctionTypeWrapper implements SanctionType,
	ModelWrapper<SanctionType> {
	public SanctionTypeWrapper(SanctionType sanctionType) {
		_sanctionType = sanctionType;
	}

	@Override
	public Class<?> getModelClass() {
		return SanctionType.class;
	}

	@Override
	public String getModelClassName() {
		return SanctionType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sanctionTypeId", getSanctionTypeId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("amount", getAmount());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sanctionTypeId = (Long)attributes.get("sanctionTypeId");

		if (sanctionTypeId != null) {
			setSanctionTypeId(sanctionTypeId);
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

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this sanction type.
	*
	* @return the primary key of this sanction type
	*/
	@Override
	public long getPrimaryKey() {
		return _sanctionType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sanction type.
	*
	* @param primaryKey the primary key of this sanction type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sanctionType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sanction type ID of this sanction type.
	*
	* @return the sanction type ID of this sanction type
	*/
	@Override
	public long getSanctionTypeId() {
		return _sanctionType.getSanctionTypeId();
	}

	/**
	* Sets the sanction type ID of this sanction type.
	*
	* @param sanctionTypeId the sanction type ID of this sanction type
	*/
	@Override
	public void setSanctionTypeId(long sanctionTypeId) {
		_sanctionType.setSanctionTypeId(sanctionTypeId);
	}

	/**
	* Returns the user ID of this sanction type.
	*
	* @return the user ID of this sanction type
	*/
	@Override
	public long getUserId() {
		return _sanctionType.getUserId();
	}

	/**
	* Sets the user ID of this sanction type.
	*
	* @param userId the user ID of this sanction type
	*/
	@Override
	public void setUserId(long userId) {
		_sanctionType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this sanction type.
	*
	* @return the user uuid of this sanction type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sanctionType.getUserUuid();
	}

	/**
	* Sets the user uuid of this sanction type.
	*
	* @param userUuid the user uuid of this sanction type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_sanctionType.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this sanction type.
	*
	* @return the group ID of this sanction type
	*/
	@Override
	public long getGroupId() {
		return _sanctionType.getGroupId();
	}

	/**
	* Sets the group ID of this sanction type.
	*
	* @param groupId the group ID of this sanction type
	*/
	@Override
	public void setGroupId(long groupId) {
		_sanctionType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this sanction type.
	*
	* @return the company ID of this sanction type
	*/
	@Override
	public long getCompanyId() {
		return _sanctionType.getCompanyId();
	}

	/**
	* Sets the company ID of this sanction type.
	*
	* @param companyId the company ID of this sanction type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_sanctionType.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this sanction type.
	*
	* @return the user name of this sanction type
	*/
	@Override
	public java.lang.String getUserName() {
		return _sanctionType.getUserName();
	}

	/**
	* Sets the user name of this sanction type.
	*
	* @param userName the user name of this sanction type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_sanctionType.setUserName(userName);
	}

	/**
	* Returns the create date of this sanction type.
	*
	* @return the create date of this sanction type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _sanctionType.getCreateDate();
	}

	/**
	* Sets the create date of this sanction type.
	*
	* @param createDate the create date of this sanction type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_sanctionType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this sanction type.
	*
	* @return the modified date of this sanction type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _sanctionType.getModifiedDate();
	}

	/**
	* Sets the modified date of this sanction type.
	*
	* @param modifiedDate the modified date of this sanction type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_sanctionType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this sanction type.
	*
	* @return the name of this sanction type
	*/
	@Override
	public java.lang.String getName() {
		return _sanctionType.getName();
	}

	/**
	* Sets the name of this sanction type.
	*
	* @param name the name of this sanction type
	*/
	@Override
	public void setName(java.lang.String name) {
		_sanctionType.setName(name);
	}

	/**
	* Returns the short description of this sanction type.
	*
	* @return the short description of this sanction type
	*/
	@Override
	public java.lang.String getShortDescription() {
		return _sanctionType.getShortDescription();
	}

	/**
	* Sets the short description of this sanction type.
	*
	* @param shortDescription the short description of this sanction type
	*/
	@Override
	public void setShortDescription(java.lang.String shortDescription) {
		_sanctionType.setShortDescription(shortDescription);
	}

	/**
	* Returns the amount of this sanction type.
	*
	* @return the amount of this sanction type
	*/
	@Override
	public double getAmount() {
		return _sanctionType.getAmount();
	}

	/**
	* Sets the amount of this sanction type.
	*
	* @param amount the amount of this sanction type
	*/
	@Override
	public void setAmount(double amount) {
		_sanctionType.setAmount(amount);
	}

	/**
	* Returns the status of this sanction type.
	*
	* @return the status of this sanction type
	*/
	@Override
	public int getStatus() {
		return _sanctionType.getStatus();
	}

	/**
	* Sets the status of this sanction type.
	*
	* @param status the status of this sanction type
	*/
	@Override
	public void setStatus(int status) {
		_sanctionType.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _sanctionType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sanctionType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sanctionType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sanctionType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sanctionType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sanctionType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sanctionType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sanctionType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sanctionType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sanctionType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sanctionType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SanctionTypeWrapper((SanctionType)_sanctionType.clone());
	}

	@Override
	public int compareTo(
		cmr.fandenatech.ndjangui.model.SanctionType sanctionType) {
		return _sanctionType.compareTo(sanctionType);
	}

	@Override
	public int hashCode() {
		return _sanctionType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<cmr.fandenatech.ndjangui.model.SanctionType> toCacheModel() {
		return _sanctionType.toCacheModel();
	}

	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType toEscapedModel() {
		return new SanctionTypeWrapper(_sanctionType.toEscapedModel());
	}

	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType toUnescapedModel() {
		return new SanctionTypeWrapper(_sanctionType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sanctionType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sanctionType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sanctionType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SanctionTypeWrapper)) {
			return false;
		}

		SanctionTypeWrapper sanctionTypeWrapper = (SanctionTypeWrapper)obj;

		if (Validator.equals(_sanctionType, sanctionTypeWrapper._sanctionType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SanctionType getWrappedSanctionType() {
		return _sanctionType;
	}

	@Override
	public SanctionType getWrappedModel() {
		return _sanctionType;
	}

	@Override
	public void resetOriginalValues() {
		_sanctionType.resetOriginalValues();
	}

	private SanctionType _sanctionType;
}