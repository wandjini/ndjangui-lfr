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
 * This class is a wrapper for {@link BudgetPeriod}.
 * </p>
 *
 * @author guyw
 * @see BudgetPeriod
 * @generated
 */
public class BudgetPeriodWrapper implements BudgetPeriod,
	ModelWrapper<BudgetPeriod> {
	public BudgetPeriodWrapper(BudgetPeriod budgetPeriod) {
		_budgetPeriod = budgetPeriod;
	}

	@Override
	public Class<?> getModelClass() {
		return BudgetPeriod.class;
	}

	@Override
	public String getModelClassName() {
		return BudgetPeriod.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("budgetPeriodId", getBudgetPeriodId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long budgetPeriodId = (Long)attributes.get("budgetPeriodId");

		if (budgetPeriodId != null) {
			setBudgetPeriodId(budgetPeriodId);
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

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this budget period.
	*
	* @return the primary key of this budget period
	*/
	@Override
	public long getPrimaryKey() {
		return _budgetPeriod.getPrimaryKey();
	}

	/**
	* Sets the primary key of this budget period.
	*
	* @param primaryKey the primary key of this budget period
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_budgetPeriod.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the budget period ID of this budget period.
	*
	* @return the budget period ID of this budget period
	*/
	@Override
	public long getBudgetPeriodId() {
		return _budgetPeriod.getBudgetPeriodId();
	}

	/**
	* Sets the budget period ID of this budget period.
	*
	* @param budgetPeriodId the budget period ID of this budget period
	*/
	@Override
	public void setBudgetPeriodId(long budgetPeriodId) {
		_budgetPeriod.setBudgetPeriodId(budgetPeriodId);
	}

	/**
	* Returns the user ID of this budget period.
	*
	* @return the user ID of this budget period
	*/
	@Override
	public long getUserId() {
		return _budgetPeriod.getUserId();
	}

	/**
	* Sets the user ID of this budget period.
	*
	* @param userId the user ID of this budget period
	*/
	@Override
	public void setUserId(long userId) {
		_budgetPeriod.setUserId(userId);
	}

	/**
	* Returns the user uuid of this budget period.
	*
	* @return the user uuid of this budget period
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _budgetPeriod.getUserUuid();
	}

	/**
	* Sets the user uuid of this budget period.
	*
	* @param userUuid the user uuid of this budget period
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_budgetPeriod.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this budget period.
	*
	* @return the group ID of this budget period
	*/
	@Override
	public long getGroupId() {
		return _budgetPeriod.getGroupId();
	}

	/**
	* Sets the group ID of this budget period.
	*
	* @param groupId the group ID of this budget period
	*/
	@Override
	public void setGroupId(long groupId) {
		_budgetPeriod.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this budget period.
	*
	* @return the company ID of this budget period
	*/
	@Override
	public long getCompanyId() {
		return _budgetPeriod.getCompanyId();
	}

	/**
	* Sets the company ID of this budget period.
	*
	* @param companyId the company ID of this budget period
	*/
	@Override
	public void setCompanyId(long companyId) {
		_budgetPeriod.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this budget period.
	*
	* @return the user name of this budget period
	*/
	@Override
	public java.lang.String getUserName() {
		return _budgetPeriod.getUserName();
	}

	/**
	* Sets the user name of this budget period.
	*
	* @param userName the user name of this budget period
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_budgetPeriod.setUserName(userName);
	}

	/**
	* Returns the create date of this budget period.
	*
	* @return the create date of this budget period
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _budgetPeriod.getCreateDate();
	}

	/**
	* Sets the create date of this budget period.
	*
	* @param createDate the create date of this budget period
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_budgetPeriod.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this budget period.
	*
	* @return the modified date of this budget period
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _budgetPeriod.getModifiedDate();
	}

	/**
	* Sets the modified date of this budget period.
	*
	* @param modifiedDate the modified date of this budget period
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_budgetPeriod.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this budget period.
	*
	* @return the name of this budget period
	*/
	@Override
	public java.lang.String getName() {
		return _budgetPeriod.getName();
	}

	/**
	* Sets the name of this budget period.
	*
	* @param name the name of this budget period
	*/
	@Override
	public void setName(java.lang.String name) {
		_budgetPeriod.setName(name);
	}

	/**
	* Returns the short description of this budget period.
	*
	* @return the short description of this budget period
	*/
	@Override
	public java.lang.String getShortDescription() {
		return _budgetPeriod.getShortDescription();
	}

	/**
	* Sets the short description of this budget period.
	*
	* @param shortDescription the short description of this budget period
	*/
	@Override
	public void setShortDescription(java.lang.String shortDescription) {
		_budgetPeriod.setShortDescription(shortDescription);
	}

	/**
	* Returns the start date of this budget period.
	*
	* @return the start date of this budget period
	*/
	@Override
	public java.util.Date getStartDate() {
		return _budgetPeriod.getStartDate();
	}

	/**
	* Sets the start date of this budget period.
	*
	* @param startDate the start date of this budget period
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_budgetPeriod.setStartDate(startDate);
	}

	/**
	* Returns the end date of this budget period.
	*
	* @return the end date of this budget period
	*/
	@Override
	public java.util.Date getEndDate() {
		return _budgetPeriod.getEndDate();
	}

	/**
	* Sets the end date of this budget period.
	*
	* @param endDate the end date of this budget period
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_budgetPeriod.setEndDate(endDate);
	}

	/**
	* Returns the status of this budget period.
	*
	* @return the status of this budget period
	*/
	@Override
	public int getStatus() {
		return _budgetPeriod.getStatus();
	}

	/**
	* Sets the status of this budget period.
	*
	* @param status the status of this budget period
	*/
	@Override
	public void setStatus(int status) {
		_budgetPeriod.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _budgetPeriod.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_budgetPeriod.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _budgetPeriod.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_budgetPeriod.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _budgetPeriod.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _budgetPeriod.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_budgetPeriod.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _budgetPeriod.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_budgetPeriod.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_budgetPeriod.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_budgetPeriod.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BudgetPeriodWrapper((BudgetPeriod)_budgetPeriod.clone());
	}

	@Override
	public int compareTo(
		cmr.fandenatech.ndjangui.model.BudgetPeriod budgetPeriod) {
		return _budgetPeriod.compareTo(budgetPeriod);
	}

	@Override
	public int hashCode() {
		return _budgetPeriod.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<cmr.fandenatech.ndjangui.model.BudgetPeriod> toCacheModel() {
		return _budgetPeriod.toCacheModel();
	}

	@Override
	public cmr.fandenatech.ndjangui.model.BudgetPeriod toEscapedModel() {
		return new BudgetPeriodWrapper(_budgetPeriod.toEscapedModel());
	}

	@Override
	public cmr.fandenatech.ndjangui.model.BudgetPeriod toUnescapedModel() {
		return new BudgetPeriodWrapper(_budgetPeriod.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _budgetPeriod.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _budgetPeriod.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_budgetPeriod.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BudgetPeriodWrapper)) {
			return false;
		}

		BudgetPeriodWrapper budgetPeriodWrapper = (BudgetPeriodWrapper)obj;

		if (Validator.equals(_budgetPeriod, budgetPeriodWrapper._budgetPeriod)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BudgetPeriod getWrappedBudgetPeriod() {
		return _budgetPeriod;
	}

	@Override
	public BudgetPeriod getWrappedModel() {
		return _budgetPeriod;
	}

	@Override
	public void resetOriginalValues() {
		_budgetPeriod.resetOriginalValues();
	}

	private BudgetPeriod _budgetPeriod;
}