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
 * This class is a wrapper for {@link Fund}.
 * </p>
 *
 * @author guyw
 * @see Fund
 * @generated
 */
public class FundWrapper implements Fund, ModelWrapper<Fund> {
	public FundWrapper(Fund fund) {
		_fund = fund;
	}

	@Override
	public Class<?> getModelClass() {
		return Fund.class;
	}

	@Override
	public String getModelClassName() {
		return Fund.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fundId", getFundId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("budgetPeriodId", getBudgetPeriodId());
		attributes.put("name", getName());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("fundTypeId", getFundTypeId());
		attributes.put("fundType", getFundType());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fundId = (Long)attributes.get("fundId");

		if (fundId != null) {
			setFundId(fundId);
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

		Long fundTypeId = (Long)attributes.get("fundTypeId");

		if (fundTypeId != null) {
			setFundTypeId(fundTypeId);
		}

		String fundType = (String)attributes.get("fundType");

		if (fundType != null) {
			setFundType(fundType);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this fund.
	*
	* @return the primary key of this fund
	*/
	@Override
	public long getPrimaryKey() {
		return _fund.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fund.
	*
	* @param primaryKey the primary key of this fund
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_fund.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fund ID of this fund.
	*
	* @return the fund ID of this fund
	*/
	@Override
	public long getFundId() {
		return _fund.getFundId();
	}

	/**
	* Sets the fund ID of this fund.
	*
	* @param fundId the fund ID of this fund
	*/
	@Override
	public void setFundId(long fundId) {
		_fund.setFundId(fundId);
	}

	/**
	* Returns the user ID of this fund.
	*
	* @return the user ID of this fund
	*/
	@Override
	public long getUserId() {
		return _fund.getUserId();
	}

	/**
	* Sets the user ID of this fund.
	*
	* @param userId the user ID of this fund
	*/
	@Override
	public void setUserId(long userId) {
		_fund.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fund.
	*
	* @return the user uuid of this fund
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fund.getUserUuid();
	}

	/**
	* Sets the user uuid of this fund.
	*
	* @param userUuid the user uuid of this fund
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_fund.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this fund.
	*
	* @return the group ID of this fund
	*/
	@Override
	public long getGroupId() {
		return _fund.getGroupId();
	}

	/**
	* Sets the group ID of this fund.
	*
	* @param groupId the group ID of this fund
	*/
	@Override
	public void setGroupId(long groupId) {
		_fund.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this fund.
	*
	* @return the company ID of this fund
	*/
	@Override
	public long getCompanyId() {
		return _fund.getCompanyId();
	}

	/**
	* Sets the company ID of this fund.
	*
	* @param companyId the company ID of this fund
	*/
	@Override
	public void setCompanyId(long companyId) {
		_fund.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this fund.
	*
	* @return the user name of this fund
	*/
	@Override
	public java.lang.String getUserName() {
		return _fund.getUserName();
	}

	/**
	* Sets the user name of this fund.
	*
	* @param userName the user name of this fund
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_fund.setUserName(userName);
	}

	/**
	* Returns the create date of this fund.
	*
	* @return the create date of this fund
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _fund.getCreateDate();
	}

	/**
	* Sets the create date of this fund.
	*
	* @param createDate the create date of this fund
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_fund.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this fund.
	*
	* @return the modified date of this fund
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _fund.getModifiedDate();
	}

	/**
	* Sets the modified date of this fund.
	*
	* @param modifiedDate the modified date of this fund
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_fund.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the budget period ID of this fund.
	*
	* @return the budget period ID of this fund
	*/
	@Override
	public long getBudgetPeriodId() {
		return _fund.getBudgetPeriodId();
	}

	/**
	* Sets the budget period ID of this fund.
	*
	* @param budgetPeriodId the budget period ID of this fund
	*/
	@Override
	public void setBudgetPeriodId(long budgetPeriodId) {
		_fund.setBudgetPeriodId(budgetPeriodId);
	}

	/**
	* Returns the name of this fund.
	*
	* @return the name of this fund
	*/
	@Override
	public java.lang.String getName() {
		return _fund.getName();
	}

	/**
	* Sets the name of this fund.
	*
	* @param name the name of this fund
	*/
	@Override
	public void setName(java.lang.String name) {
		_fund.setName(name);
	}

	/**
	* Returns the short description of this fund.
	*
	* @return the short description of this fund
	*/
	@Override
	public java.lang.String getShortDescription() {
		return _fund.getShortDescription();
	}

	/**
	* Sets the short description of this fund.
	*
	* @param shortDescription the short description of this fund
	*/
	@Override
	public void setShortDescription(java.lang.String shortDescription) {
		_fund.setShortDescription(shortDescription);
	}

	/**
	* Returns the fund type ID of this fund.
	*
	* @return the fund type ID of this fund
	*/
	@Override
	public long getFundTypeId() {
		return _fund.getFundTypeId();
	}

	/**
	* Sets the fund type ID of this fund.
	*
	* @param fundTypeId the fund type ID of this fund
	*/
	@Override
	public void setFundTypeId(long fundTypeId) {
		_fund.setFundTypeId(fundTypeId);
	}

	/**
	* Returns the fund type of this fund.
	*
	* @return the fund type of this fund
	*/
	@Override
	public java.lang.String getFundType() {
		return _fund.getFundType();
	}

	/**
	* Sets the fund type of this fund.
	*
	* @param fundType the fund type of this fund
	*/
	@Override
	public void setFundType(java.lang.String fundType) {
		_fund.setFundType(fundType);
	}

	/**
	* Returns the status of this fund.
	*
	* @return the status of this fund
	*/
	@Override
	public int getStatus() {
		return _fund.getStatus();
	}

	/**
	* Sets the status of this fund.
	*
	* @param status the status of this fund
	*/
	@Override
	public void setStatus(int status) {
		_fund.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _fund.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_fund.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _fund.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fund.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _fund.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _fund.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_fund.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _fund.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_fund.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_fund.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_fund.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FundWrapper((Fund)_fund.clone());
	}

	@Override
	public int compareTo(cmr.fandenatech.ndjangui.model.Fund fund) {
		return _fund.compareTo(fund);
	}

	@Override
	public int hashCode() {
		return _fund.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<cmr.fandenatech.ndjangui.model.Fund> toCacheModel() {
		return _fund.toCacheModel();
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Fund toEscapedModel() {
		return new FundWrapper(_fund.toEscapedModel());
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Fund toUnescapedModel() {
		return new FundWrapper(_fund.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _fund.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _fund.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_fund.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FundWrapper)) {
			return false;
		}

		FundWrapper fundWrapper = (FundWrapper)obj;

		if (Validator.equals(_fund, fundWrapper._fund)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Fund getWrappedFund() {
		return _fund;
	}

	@Override
	public Fund getWrappedModel() {
		return _fund;
	}

	@Override
	public void resetOriginalValues() {
		_fund.resetOriginalValues();
	}

	private Fund _fund;
}