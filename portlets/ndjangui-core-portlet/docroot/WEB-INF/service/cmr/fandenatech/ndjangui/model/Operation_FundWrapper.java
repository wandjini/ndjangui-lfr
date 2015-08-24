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
 * This class is a wrapper for {@link Operation_Fund}.
 * </p>
 *
 * @author guyw
 * @see Operation_Fund
 * @generated
 */
public class Operation_FundWrapper implements Operation_Fund,
	ModelWrapper<Operation_Fund> {
	public Operation_FundWrapper(Operation_Fund operation_Fund) {
		_operation_Fund = operation_Fund;
	}

	@Override
	public Class<?> getModelClass() {
		return Operation_Fund.class;
	}

	@Override
	public String getModelClassName() {
		return Operation_Fund.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("operationFundId", getOperationFundId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("operationId", getOperationId());
		attributes.put("srcFundClassPK", getSrcFundClassPK());
		attributes.put("srcFundClassName", getSrcFundClassName());
		attributes.put("destFundClassPK", getDestFundClassPK());
		attributes.put("destFundClassName", getDestFundClassName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long operationFundId = (Long)attributes.get("operationFundId");

		if (operationFundId != null) {
			setOperationFundId(operationFundId);
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

		Long operationId = (Long)attributes.get("operationId");

		if (operationId != null) {
			setOperationId(operationId);
		}

		Long srcFundClassPK = (Long)attributes.get("srcFundClassPK");

		if (srcFundClassPK != null) {
			setSrcFundClassPK(srcFundClassPK);
		}

		String srcFundClassName = (String)attributes.get("srcFundClassName");

		if (srcFundClassName != null) {
			setSrcFundClassName(srcFundClassName);
		}

		Long destFundClassPK = (Long)attributes.get("destFundClassPK");

		if (destFundClassPK != null) {
			setDestFundClassPK(destFundClassPK);
		}

		String destFundClassName = (String)attributes.get("destFundClassName");

		if (destFundClassName != null) {
			setDestFundClassName(destFundClassName);
		}
	}

	/**
	* Returns the primary key of this operation_ fund.
	*
	* @return the primary key of this operation_ fund
	*/
	@Override
	public long getPrimaryKey() {
		return _operation_Fund.getPrimaryKey();
	}

	/**
	* Sets the primary key of this operation_ fund.
	*
	* @param primaryKey the primary key of this operation_ fund
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_operation_Fund.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the operation fund ID of this operation_ fund.
	*
	* @return the operation fund ID of this operation_ fund
	*/
	@Override
	public long getOperationFundId() {
		return _operation_Fund.getOperationFundId();
	}

	/**
	* Sets the operation fund ID of this operation_ fund.
	*
	* @param operationFundId the operation fund ID of this operation_ fund
	*/
	@Override
	public void setOperationFundId(long operationFundId) {
		_operation_Fund.setOperationFundId(operationFundId);
	}

	/**
	* Returns the user ID of this operation_ fund.
	*
	* @return the user ID of this operation_ fund
	*/
	@Override
	public long getUserId() {
		return _operation_Fund.getUserId();
	}

	/**
	* Sets the user ID of this operation_ fund.
	*
	* @param userId the user ID of this operation_ fund
	*/
	@Override
	public void setUserId(long userId) {
		_operation_Fund.setUserId(userId);
	}

	/**
	* Returns the user uuid of this operation_ fund.
	*
	* @return the user uuid of this operation_ fund
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operation_Fund.getUserUuid();
	}

	/**
	* Sets the user uuid of this operation_ fund.
	*
	* @param userUuid the user uuid of this operation_ fund
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_operation_Fund.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this operation_ fund.
	*
	* @return the group ID of this operation_ fund
	*/
	@Override
	public long getGroupId() {
		return _operation_Fund.getGroupId();
	}

	/**
	* Sets the group ID of this operation_ fund.
	*
	* @param groupId the group ID of this operation_ fund
	*/
	@Override
	public void setGroupId(long groupId) {
		_operation_Fund.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this operation_ fund.
	*
	* @return the company ID of this operation_ fund
	*/
	@Override
	public long getCompanyId() {
		return _operation_Fund.getCompanyId();
	}

	/**
	* Sets the company ID of this operation_ fund.
	*
	* @param companyId the company ID of this operation_ fund
	*/
	@Override
	public void setCompanyId(long companyId) {
		_operation_Fund.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this operation_ fund.
	*
	* @return the user name of this operation_ fund
	*/
	@Override
	public java.lang.String getUserName() {
		return _operation_Fund.getUserName();
	}

	/**
	* Sets the user name of this operation_ fund.
	*
	* @param userName the user name of this operation_ fund
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_operation_Fund.setUserName(userName);
	}

	/**
	* Returns the create date of this operation_ fund.
	*
	* @return the create date of this operation_ fund
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _operation_Fund.getCreateDate();
	}

	/**
	* Sets the create date of this operation_ fund.
	*
	* @param createDate the create date of this operation_ fund
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_operation_Fund.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this operation_ fund.
	*
	* @return the modified date of this operation_ fund
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _operation_Fund.getModifiedDate();
	}

	/**
	* Sets the modified date of this operation_ fund.
	*
	* @param modifiedDate the modified date of this operation_ fund
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_operation_Fund.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the operation ID of this operation_ fund.
	*
	* @return the operation ID of this operation_ fund
	*/
	@Override
	public long getOperationId() {
		return _operation_Fund.getOperationId();
	}

	/**
	* Sets the operation ID of this operation_ fund.
	*
	* @param operationId the operation ID of this operation_ fund
	*/
	@Override
	public void setOperationId(long operationId) {
		_operation_Fund.setOperationId(operationId);
	}

	/**
	* Returns the src fund class p k of this operation_ fund.
	*
	* @return the src fund class p k of this operation_ fund
	*/
	@Override
	public long getSrcFundClassPK() {
		return _operation_Fund.getSrcFundClassPK();
	}

	/**
	* Sets the src fund class p k of this operation_ fund.
	*
	* @param srcFundClassPK the src fund class p k of this operation_ fund
	*/
	@Override
	public void setSrcFundClassPK(long srcFundClassPK) {
		_operation_Fund.setSrcFundClassPK(srcFundClassPK);
	}

	/**
	* Returns the src fund class name of this operation_ fund.
	*
	* @return the src fund class name of this operation_ fund
	*/
	@Override
	public java.lang.String getSrcFundClassName() {
		return _operation_Fund.getSrcFundClassName();
	}

	/**
	* Sets the src fund class name of this operation_ fund.
	*
	* @param srcFundClassName the src fund class name of this operation_ fund
	*/
	@Override
	public void setSrcFundClassName(java.lang.String srcFundClassName) {
		_operation_Fund.setSrcFundClassName(srcFundClassName);
	}

	/**
	* Returns the dest fund class p k of this operation_ fund.
	*
	* @return the dest fund class p k of this operation_ fund
	*/
	@Override
	public long getDestFundClassPK() {
		return _operation_Fund.getDestFundClassPK();
	}

	/**
	* Sets the dest fund class p k of this operation_ fund.
	*
	* @param destFundClassPK the dest fund class p k of this operation_ fund
	*/
	@Override
	public void setDestFundClassPK(long destFundClassPK) {
		_operation_Fund.setDestFundClassPK(destFundClassPK);
	}

	/**
	* Returns the dest fund class name of this operation_ fund.
	*
	* @return the dest fund class name of this operation_ fund
	*/
	@Override
	public java.lang.String getDestFundClassName() {
		return _operation_Fund.getDestFundClassName();
	}

	/**
	* Sets the dest fund class name of this operation_ fund.
	*
	* @param destFundClassName the dest fund class name of this operation_ fund
	*/
	@Override
	public void setDestFundClassName(java.lang.String destFundClassName) {
		_operation_Fund.setDestFundClassName(destFundClassName);
	}

	@Override
	public boolean isNew() {
		return _operation_Fund.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_operation_Fund.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _operation_Fund.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_operation_Fund.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _operation_Fund.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _operation_Fund.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_operation_Fund.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _operation_Fund.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_operation_Fund.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_operation_Fund.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_operation_Fund.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Operation_FundWrapper((Operation_Fund)_operation_Fund.clone());
	}

	@Override
	public int compareTo(
		cmr.fandenatech.ndjangui.model.Operation_Fund operation_Fund) {
		return _operation_Fund.compareTo(operation_Fund);
	}

	@Override
	public int hashCode() {
		return _operation_Fund.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<cmr.fandenatech.ndjangui.model.Operation_Fund> toCacheModel() {
		return _operation_Fund.toCacheModel();
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Operation_Fund toEscapedModel() {
		return new Operation_FundWrapper(_operation_Fund.toEscapedModel());
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Operation_Fund toUnescapedModel() {
		return new Operation_FundWrapper(_operation_Fund.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _operation_Fund.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _operation_Fund.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_operation_Fund.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Operation_FundWrapper)) {
			return false;
		}

		Operation_FundWrapper operation_FundWrapper = (Operation_FundWrapper)obj;

		if (Validator.equals(_operation_Fund,
					operation_FundWrapper._operation_Fund)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Operation_Fund getWrappedOperation_Fund() {
		return _operation_Fund;
	}

	@Override
	public Operation_Fund getWrappedModel() {
		return _operation_Fund;
	}

	@Override
	public void resetOriginalValues() {
		_operation_Fund.resetOriginalValues();
	}

	private Operation_Fund _operation_Fund;
}