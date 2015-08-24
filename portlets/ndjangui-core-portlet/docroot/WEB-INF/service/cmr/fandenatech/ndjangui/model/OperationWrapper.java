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
 * This class is a wrapper for {@link Operation}.
 * </p>
 *
 * @author guyw
 * @see Operation
 * @generated
 */
public class OperationWrapper implements Operation, ModelWrapper<Operation> {
	public OperationWrapper(Operation operation) {
		_operation = operation;
	}

	@Override
	public Class<?> getModelClass() {
		return Operation.class;
	}

	@Override
	public String getModelClassName() {
		return Operation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("operationId", getOperationId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("budgetPeriodId", getBudgetPeriodId());
		attributes.put("name", getName());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("operationTypeId", getOperationTypeId());
		attributes.put("sittingId", getSittingId());
		attributes.put("status", getStatus());
		attributes.put("amount", getAmount());
		attributes.put("srcFundClassPK", getSrcFundClassPK());
		attributes.put("srcFundClassName", getSrcFundClassName());
		attributes.put("destFundClassPK", getDestFundClassPK());
		attributes.put("destFundClassName", getDestFundClassName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long operationId = (Long)attributes.get("operationId");

		if (operationId != null) {
			setOperationId(operationId);
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

		Long budgetPeriodId = (Long)attributes.get("budgetPeriodId");

		if (budgetPeriodId != null) {
			setBudgetPeriodId(budgetPeriodId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		Long operationTypeId = (Long)attributes.get("operationTypeId");

		if (operationTypeId != null) {
			setOperationTypeId(operationTypeId);
		}

		Long sittingId = (Long)attributes.get("sittingId");

		if (sittingId != null) {
			setSittingId(sittingId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
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
	* Returns the primary key of this operation.
	*
	* @return the primary key of this operation
	*/
	@Override
	public long getPrimaryKey() {
		return _operation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this operation.
	*
	* @param primaryKey the primary key of this operation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_operation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the operation ID of this operation.
	*
	* @return the operation ID of this operation
	*/
	@Override
	public long getOperationId() {
		return _operation.getOperationId();
	}

	/**
	* Sets the operation ID of this operation.
	*
	* @param operationId the operation ID of this operation
	*/
	@Override
	public void setOperationId(long operationId) {
		_operation.setOperationId(operationId);
	}

	/**
	* Returns the user ID of this operation.
	*
	* @return the user ID of this operation
	*/
	@Override
	public long getUserId() {
		return _operation.getUserId();
	}

	/**
	* Sets the user ID of this operation.
	*
	* @param userId the user ID of this operation
	*/
	@Override
	public void setUserId(long userId) {
		_operation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this operation.
	*
	* @return the user uuid of this operation
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operation.getUserUuid();
	}

	/**
	* Sets the user uuid of this operation.
	*
	* @param userUuid the user uuid of this operation
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_operation.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this operation.
	*
	* @return the group ID of this operation
	*/
	@Override
	public long getGroupId() {
		return _operation.getGroupId();
	}

	/**
	* Sets the group ID of this operation.
	*
	* @param groupId the group ID of this operation
	*/
	@Override
	public void setGroupId(long groupId) {
		_operation.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this operation.
	*
	* @return the company ID of this operation
	*/
	@Override
	public long getCompanyId() {
		return _operation.getCompanyId();
	}

	/**
	* Sets the company ID of this operation.
	*
	* @param companyId the company ID of this operation
	*/
	@Override
	public void setCompanyId(long companyId) {
		_operation.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this operation.
	*
	* @return the user name of this operation
	*/
	@Override
	public java.lang.String getUserName() {
		return _operation.getUserName();
	}

	/**
	* Sets the user name of this operation.
	*
	* @param userName the user name of this operation
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_operation.setUserName(userName);
	}

	/**
	* Returns the create date of this operation.
	*
	* @return the create date of this operation
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _operation.getCreateDate();
	}

	/**
	* Sets the create date of this operation.
	*
	* @param createDate the create date of this operation
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_operation.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this operation.
	*
	* @return the modified date of this operation
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _operation.getModifiedDate();
	}

	/**
	* Sets the modified date of this operation.
	*
	* @param modifiedDate the modified date of this operation
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_operation.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the budget period ID of this operation.
	*
	* @return the budget period ID of this operation
	*/
	@Override
	public long getBudgetPeriodId() {
		return _operation.getBudgetPeriodId();
	}

	/**
	* Sets the budget period ID of this operation.
	*
	* @param budgetPeriodId the budget period ID of this operation
	*/
	@Override
	public void setBudgetPeriodId(long budgetPeriodId) {
		_operation.setBudgetPeriodId(budgetPeriodId);
	}

	/**
	* Returns the name of this operation.
	*
	* @return the name of this operation
	*/
	@Override
	public java.lang.String getName() {
		return _operation.getName();
	}

	/**
	* Sets the name of this operation.
	*
	* @param name the name of this operation
	*/
	@Override
	public void setName(java.lang.String name) {
		_operation.setName(name);
	}

	/**
	* Returns the short description of this operation.
	*
	* @return the short description of this operation
	*/
	@Override
	public java.lang.String getShortDescription() {
		return _operation.getShortDescription();
	}

	/**
	* Sets the short description of this operation.
	*
	* @param shortDescription the short description of this operation
	*/
	@Override
	public void setShortDescription(java.lang.String shortDescription) {
		_operation.setShortDescription(shortDescription);
	}

	/**
	* Returns the operation type ID of this operation.
	*
	* @return the operation type ID of this operation
	*/
	@Override
	public long getOperationTypeId() {
		return _operation.getOperationTypeId();
	}

	/**
	* Sets the operation type ID of this operation.
	*
	* @param operationTypeId the operation type ID of this operation
	*/
	@Override
	public void setOperationTypeId(long operationTypeId) {
		_operation.setOperationTypeId(operationTypeId);
	}

	/**
	* Returns the sitting ID of this operation.
	*
	* @return the sitting ID of this operation
	*/
	@Override
	public long getSittingId() {
		return _operation.getSittingId();
	}

	/**
	* Sets the sitting ID of this operation.
	*
	* @param sittingId the sitting ID of this operation
	*/
	@Override
	public void setSittingId(long sittingId) {
		_operation.setSittingId(sittingId);
	}

	/**
	* Returns the status of this operation.
	*
	* @return the status of this operation
	*/
	@Override
	public int getStatus() {
		return _operation.getStatus();
	}

	/**
	* Sets the status of this operation.
	*
	* @param status the status of this operation
	*/
	@Override
	public void setStatus(int status) {
		_operation.setStatus(status);
	}

	/**
	* Returns the amount of this operation.
	*
	* @return the amount of this operation
	*/
	@Override
	public double getAmount() {
		return _operation.getAmount();
	}

	/**
	* Sets the amount of this operation.
	*
	* @param amount the amount of this operation
	*/
	@Override
	public void setAmount(double amount) {
		_operation.setAmount(amount);
	}

	/**
	* Returns the src fund class p k of this operation.
	*
	* @return the src fund class p k of this operation
	*/
	@Override
	public long getSrcFundClassPK() {
		return _operation.getSrcFundClassPK();
	}

	/**
	* Sets the src fund class p k of this operation.
	*
	* @param srcFundClassPK the src fund class p k of this operation
	*/
	@Override
	public void setSrcFundClassPK(long srcFundClassPK) {
		_operation.setSrcFundClassPK(srcFundClassPK);
	}

	/**
	* Returns the src fund class name of this operation.
	*
	* @return the src fund class name of this operation
	*/
	@Override
	public java.lang.String getSrcFundClassName() {
		return _operation.getSrcFundClassName();
	}

	/**
	* Sets the src fund class name of this operation.
	*
	* @param srcFundClassName the src fund class name of this operation
	*/
	@Override
	public void setSrcFundClassName(java.lang.String srcFundClassName) {
		_operation.setSrcFundClassName(srcFundClassName);
	}

	/**
	* Returns the dest fund class p k of this operation.
	*
	* @return the dest fund class p k of this operation
	*/
	@Override
	public long getDestFundClassPK() {
		return _operation.getDestFundClassPK();
	}

	/**
	* Sets the dest fund class p k of this operation.
	*
	* @param destFundClassPK the dest fund class p k of this operation
	*/
	@Override
	public void setDestFundClassPK(long destFundClassPK) {
		_operation.setDestFundClassPK(destFundClassPK);
	}

	/**
	* Returns the dest fund class name of this operation.
	*
	* @return the dest fund class name of this operation
	*/
	@Override
	public java.lang.String getDestFundClassName() {
		return _operation.getDestFundClassName();
	}

	/**
	* Sets the dest fund class name of this operation.
	*
	* @param destFundClassName the dest fund class name of this operation
	*/
	@Override
	public void setDestFundClassName(java.lang.String destFundClassName) {
		_operation.setDestFundClassName(destFundClassName);
	}

	@Override
	public boolean isNew() {
		return _operation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_operation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _operation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_operation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _operation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _operation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_operation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _operation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_operation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_operation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_operation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OperationWrapper((Operation)_operation.clone());
	}

	@Override
	public int compareTo(cmr.fandenatech.ndjangui.model.Operation operation) {
		return _operation.compareTo(operation);
	}

	@Override
	public int hashCode() {
		return _operation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<cmr.fandenatech.ndjangui.model.Operation> toCacheModel() {
		return _operation.toCacheModel();
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Operation toEscapedModel() {
		return new OperationWrapper(_operation.toEscapedModel());
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Operation toUnescapedModel() {
		return new OperationWrapper(_operation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _operation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _operation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_operation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OperationWrapper)) {
			return false;
		}

		OperationWrapper operationWrapper = (OperationWrapper)obj;

		if (Validator.equals(_operation, operationWrapper._operation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Operation getWrappedOperation() {
		return _operation;
	}

	@Override
	public Operation getWrappedModel() {
		return _operation;
	}

	@Override
	public void resetOriginalValues() {
		_operation.resetOriginalValues();
	}

	private Operation _operation;
}