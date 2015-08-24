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
 * This class is a wrapper for {@link OperationType}.
 * </p>
 *
 * @author guyw
 * @see OperationType
 * @generated
 */
public class OperationTypeWrapper implements OperationType,
	ModelWrapper<OperationType> {
	public OperationTypeWrapper(OperationType operationType) {
		_operationType = operationType;
	}

	@Override
	public Class<?> getModelClass() {
		return OperationType.class;
	}

	@Override
	public String getModelClassName() {
		return OperationType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("operationTypeId", getOperationTypeId());
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
		Long operationTypeId = (Long)attributes.get("operationTypeId");

		if (operationTypeId != null) {
			setOperationTypeId(operationTypeId);
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
	* Returns the primary key of this operation type.
	*
	* @return the primary key of this operation type
	*/
	@Override
	public long getPrimaryKey() {
		return _operationType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this operation type.
	*
	* @param primaryKey the primary key of this operation type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_operationType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the operation type ID of this operation type.
	*
	* @return the operation type ID of this operation type
	*/
	@Override
	public long getOperationTypeId() {
		return _operationType.getOperationTypeId();
	}

	/**
	* Sets the operation type ID of this operation type.
	*
	* @param operationTypeId the operation type ID of this operation type
	*/
	@Override
	public void setOperationTypeId(long operationTypeId) {
		_operationType.setOperationTypeId(operationTypeId);
	}

	/**
	* Returns the user ID of this operation type.
	*
	* @return the user ID of this operation type
	*/
	@Override
	public long getUserId() {
		return _operationType.getUserId();
	}

	/**
	* Sets the user ID of this operation type.
	*
	* @param userId the user ID of this operation type
	*/
	@Override
	public void setUserId(long userId) {
		_operationType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this operation type.
	*
	* @return the user uuid of this operation type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operationType.getUserUuid();
	}

	/**
	* Sets the user uuid of this operation type.
	*
	* @param userUuid the user uuid of this operation type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_operationType.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this operation type.
	*
	* @return the group ID of this operation type
	*/
	@Override
	public long getGroupId() {
		return _operationType.getGroupId();
	}

	/**
	* Sets the group ID of this operation type.
	*
	* @param groupId the group ID of this operation type
	*/
	@Override
	public void setGroupId(long groupId) {
		_operationType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this operation type.
	*
	* @return the company ID of this operation type
	*/
	@Override
	public long getCompanyId() {
		return _operationType.getCompanyId();
	}

	/**
	* Sets the company ID of this operation type.
	*
	* @param companyId the company ID of this operation type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_operationType.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this operation type.
	*
	* @return the user name of this operation type
	*/
	@Override
	public java.lang.String getUserName() {
		return _operationType.getUserName();
	}

	/**
	* Sets the user name of this operation type.
	*
	* @param userName the user name of this operation type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_operationType.setUserName(userName);
	}

	/**
	* Returns the create date of this operation type.
	*
	* @return the create date of this operation type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _operationType.getCreateDate();
	}

	/**
	* Sets the create date of this operation type.
	*
	* @param createDate the create date of this operation type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_operationType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this operation type.
	*
	* @return the modified date of this operation type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _operationType.getModifiedDate();
	}

	/**
	* Sets the modified date of this operation type.
	*
	* @param modifiedDate the modified date of this operation type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_operationType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this operation type.
	*
	* @return the name of this operation type
	*/
	@Override
	public java.lang.String getName() {
		return _operationType.getName();
	}

	/**
	* Sets the name of this operation type.
	*
	* @param name the name of this operation type
	*/
	@Override
	public void setName(java.lang.String name) {
		_operationType.setName(name);
	}

	/**
	* Returns the short description of this operation type.
	*
	* @return the short description of this operation type
	*/
	@Override
	public java.lang.String getShortDescription() {
		return _operationType.getShortDescription();
	}

	/**
	* Sets the short description of this operation type.
	*
	* @param shortDescription the short description of this operation type
	*/
	@Override
	public void setShortDescription(java.lang.String shortDescription) {
		_operationType.setShortDescription(shortDescription);
	}

	/**
	* Returns the status of this operation type.
	*
	* @return the status of this operation type
	*/
	@Override
	public int getStatus() {
		return _operationType.getStatus();
	}

	/**
	* Sets the status of this operation type.
	*
	* @param status the status of this operation type
	*/
	@Override
	public void setStatus(int status) {
		_operationType.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _operationType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_operationType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _operationType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_operationType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _operationType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _operationType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_operationType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _operationType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_operationType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_operationType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_operationType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OperationTypeWrapper((OperationType)_operationType.clone());
	}

	@Override
	public int compareTo(
		cmr.fandenatech.ndjangui.model.OperationType operationType) {
		return _operationType.compareTo(operationType);
	}

	@Override
	public int hashCode() {
		return _operationType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<cmr.fandenatech.ndjangui.model.OperationType> toCacheModel() {
		return _operationType.toCacheModel();
	}

	@Override
	public cmr.fandenatech.ndjangui.model.OperationType toEscapedModel() {
		return new OperationTypeWrapper(_operationType.toEscapedModel());
	}

	@Override
	public cmr.fandenatech.ndjangui.model.OperationType toUnescapedModel() {
		return new OperationTypeWrapper(_operationType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _operationType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _operationType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_operationType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OperationTypeWrapper)) {
			return false;
		}

		OperationTypeWrapper operationTypeWrapper = (OperationTypeWrapper)obj;

		if (Validator.equals(_operationType, operationTypeWrapper._operationType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OperationType getWrappedOperationType() {
		return _operationType;
	}

	@Override
	public OperationType getWrappedModel() {
		return _operationType;
	}

	@Override
	public void resetOriginalValues() {
		_operationType.resetOriginalValues();
	}

	private OperationType _operationType;
}