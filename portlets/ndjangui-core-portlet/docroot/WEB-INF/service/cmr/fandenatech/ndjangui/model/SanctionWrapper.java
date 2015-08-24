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
 * This class is a wrapper for {@link Sanction}.
 * </p>
 *
 * @author guyw
 * @see Sanction
 * @generated
 */
public class SanctionWrapper implements Sanction, ModelWrapper<Sanction> {
	public SanctionWrapper(Sanction sanction) {
		_sanction = sanction;
	}

	@Override
	public Class<?> getModelClass() {
		return Sanction.class;
	}

	@Override
	public String getModelClassName() {
		return Sanction.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sanctionId", getSanctionId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("memberId", getMemberId());
		attributes.put("budgetPeriodId", getBudgetPeriodId());
		attributes.put("name", getName());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("sanctionTypeId", getSanctionTypeId());
		attributes.put("sittingId", getSittingId());
		attributes.put("amount", getAmount());
		attributes.put("status", getStatus());
		attributes.put("srcFundClassPK", getSrcFundClassPK());
		attributes.put("srcFundClassName", getSrcFundClassName());
		attributes.put("destFundClassPK", getDestFundClassPK());
		attributes.put("destFundClassName", getDestFundClassName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sanctionId = (Long)attributes.get("sanctionId");

		if (sanctionId != null) {
			setSanctionId(sanctionId);
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

		Long sanctionTypeId = (Long)attributes.get("sanctionTypeId");

		if (sanctionTypeId != null) {
			setSanctionTypeId(sanctionTypeId);
		}

		Long sittingId = (Long)attributes.get("sittingId");

		if (sittingId != null) {
			setSittingId(sittingId);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
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
	* Returns the primary key of this sanction.
	*
	* @return the primary key of this sanction
	*/
	@Override
	public long getPrimaryKey() {
		return _sanction.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sanction.
	*
	* @param primaryKey the primary key of this sanction
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sanction.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sanction ID of this sanction.
	*
	* @return the sanction ID of this sanction
	*/
	@Override
	public long getSanctionId() {
		return _sanction.getSanctionId();
	}

	/**
	* Sets the sanction ID of this sanction.
	*
	* @param sanctionId the sanction ID of this sanction
	*/
	@Override
	public void setSanctionId(long sanctionId) {
		_sanction.setSanctionId(sanctionId);
	}

	/**
	* Returns the user ID of this sanction.
	*
	* @return the user ID of this sanction
	*/
	@Override
	public long getUserId() {
		return _sanction.getUserId();
	}

	/**
	* Sets the user ID of this sanction.
	*
	* @param userId the user ID of this sanction
	*/
	@Override
	public void setUserId(long userId) {
		_sanction.setUserId(userId);
	}

	/**
	* Returns the user uuid of this sanction.
	*
	* @return the user uuid of this sanction
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sanction.getUserUuid();
	}

	/**
	* Sets the user uuid of this sanction.
	*
	* @param userUuid the user uuid of this sanction
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_sanction.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this sanction.
	*
	* @return the group ID of this sanction
	*/
	@Override
	public long getGroupId() {
		return _sanction.getGroupId();
	}

	/**
	* Sets the group ID of this sanction.
	*
	* @param groupId the group ID of this sanction
	*/
	@Override
	public void setGroupId(long groupId) {
		_sanction.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this sanction.
	*
	* @return the company ID of this sanction
	*/
	@Override
	public long getCompanyId() {
		return _sanction.getCompanyId();
	}

	/**
	* Sets the company ID of this sanction.
	*
	* @param companyId the company ID of this sanction
	*/
	@Override
	public void setCompanyId(long companyId) {
		_sanction.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this sanction.
	*
	* @return the user name of this sanction
	*/
	@Override
	public java.lang.String getUserName() {
		return _sanction.getUserName();
	}

	/**
	* Sets the user name of this sanction.
	*
	* @param userName the user name of this sanction
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_sanction.setUserName(userName);
	}

	/**
	* Returns the create date of this sanction.
	*
	* @return the create date of this sanction
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _sanction.getCreateDate();
	}

	/**
	* Sets the create date of this sanction.
	*
	* @param createDate the create date of this sanction
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_sanction.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this sanction.
	*
	* @return the modified date of this sanction
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _sanction.getModifiedDate();
	}

	/**
	* Sets the modified date of this sanction.
	*
	* @param modifiedDate the modified date of this sanction
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_sanction.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the member ID of this sanction.
	*
	* @return the member ID of this sanction
	*/
	@Override
	public long getMemberId() {
		return _sanction.getMemberId();
	}

	/**
	* Sets the member ID of this sanction.
	*
	* @param memberId the member ID of this sanction
	*/
	@Override
	public void setMemberId(long memberId) {
		_sanction.setMemberId(memberId);
	}

	/**
	* Returns the budget period ID of this sanction.
	*
	* @return the budget period ID of this sanction
	*/
	@Override
	public long getBudgetPeriodId() {
		return _sanction.getBudgetPeriodId();
	}

	/**
	* Sets the budget period ID of this sanction.
	*
	* @param budgetPeriodId the budget period ID of this sanction
	*/
	@Override
	public void setBudgetPeriodId(long budgetPeriodId) {
		_sanction.setBudgetPeriodId(budgetPeriodId);
	}

	/**
	* Returns the name of this sanction.
	*
	* @return the name of this sanction
	*/
	@Override
	public java.lang.String getName() {
		return _sanction.getName();
	}

	/**
	* Sets the name of this sanction.
	*
	* @param name the name of this sanction
	*/
	@Override
	public void setName(java.lang.String name) {
		_sanction.setName(name);
	}

	/**
	* Returns the short description of this sanction.
	*
	* @return the short description of this sanction
	*/
	@Override
	public java.lang.String getShortDescription() {
		return _sanction.getShortDescription();
	}

	/**
	* Sets the short description of this sanction.
	*
	* @param shortDescription the short description of this sanction
	*/
	@Override
	public void setShortDescription(java.lang.String shortDescription) {
		_sanction.setShortDescription(shortDescription);
	}

	/**
	* Returns the sanction type ID of this sanction.
	*
	* @return the sanction type ID of this sanction
	*/
	@Override
	public long getSanctionTypeId() {
		return _sanction.getSanctionTypeId();
	}

	/**
	* Sets the sanction type ID of this sanction.
	*
	* @param sanctionTypeId the sanction type ID of this sanction
	*/
	@Override
	public void setSanctionTypeId(long sanctionTypeId) {
		_sanction.setSanctionTypeId(sanctionTypeId);
	}

	/**
	* Returns the sitting ID of this sanction.
	*
	* @return the sitting ID of this sanction
	*/
	@Override
	public long getSittingId() {
		return _sanction.getSittingId();
	}

	/**
	* Sets the sitting ID of this sanction.
	*
	* @param sittingId the sitting ID of this sanction
	*/
	@Override
	public void setSittingId(long sittingId) {
		_sanction.setSittingId(sittingId);
	}

	/**
	* Returns the amount of this sanction.
	*
	* @return the amount of this sanction
	*/
	@Override
	public double getAmount() {
		return _sanction.getAmount();
	}

	/**
	* Sets the amount of this sanction.
	*
	* @param amount the amount of this sanction
	*/
	@Override
	public void setAmount(double amount) {
		_sanction.setAmount(amount);
	}

	/**
	* Returns the status of this sanction.
	*
	* @return the status of this sanction
	*/
	@Override
	public int getStatus() {
		return _sanction.getStatus();
	}

	/**
	* Sets the status of this sanction.
	*
	* @param status the status of this sanction
	*/
	@Override
	public void setStatus(int status) {
		_sanction.setStatus(status);
	}

	/**
	* Returns the src fund class p k of this sanction.
	*
	* @return the src fund class p k of this sanction
	*/
	@Override
	public long getSrcFundClassPK() {
		return _sanction.getSrcFundClassPK();
	}

	/**
	* Sets the src fund class p k of this sanction.
	*
	* @param srcFundClassPK the src fund class p k of this sanction
	*/
	@Override
	public void setSrcFundClassPK(long srcFundClassPK) {
		_sanction.setSrcFundClassPK(srcFundClassPK);
	}

	/**
	* Returns the src fund class name of this sanction.
	*
	* @return the src fund class name of this sanction
	*/
	@Override
	public java.lang.String getSrcFundClassName() {
		return _sanction.getSrcFundClassName();
	}

	/**
	* Sets the src fund class name of this sanction.
	*
	* @param srcFundClassName the src fund class name of this sanction
	*/
	@Override
	public void setSrcFundClassName(java.lang.String srcFundClassName) {
		_sanction.setSrcFundClassName(srcFundClassName);
	}

	/**
	* Returns the dest fund class p k of this sanction.
	*
	* @return the dest fund class p k of this sanction
	*/
	@Override
	public long getDestFundClassPK() {
		return _sanction.getDestFundClassPK();
	}

	/**
	* Sets the dest fund class p k of this sanction.
	*
	* @param destFundClassPK the dest fund class p k of this sanction
	*/
	@Override
	public void setDestFundClassPK(long destFundClassPK) {
		_sanction.setDestFundClassPK(destFundClassPK);
	}

	/**
	* Returns the dest fund class name of this sanction.
	*
	* @return the dest fund class name of this sanction
	*/
	@Override
	public java.lang.String getDestFundClassName() {
		return _sanction.getDestFundClassName();
	}

	/**
	* Sets the dest fund class name of this sanction.
	*
	* @param destFundClassName the dest fund class name of this sanction
	*/
	@Override
	public void setDestFundClassName(java.lang.String destFundClassName) {
		_sanction.setDestFundClassName(destFundClassName);
	}

	@Override
	public boolean isNew() {
		return _sanction.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sanction.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sanction.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sanction.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sanction.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sanction.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sanction.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sanction.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sanction.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sanction.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sanction.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SanctionWrapper((Sanction)_sanction.clone());
	}

	@Override
	public int compareTo(cmr.fandenatech.ndjangui.model.Sanction sanction) {
		return _sanction.compareTo(sanction);
	}

	@Override
	public int hashCode() {
		return _sanction.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<cmr.fandenatech.ndjangui.model.Sanction> toCacheModel() {
		return _sanction.toCacheModel();
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sanction toEscapedModel() {
		return new SanctionWrapper(_sanction.toEscapedModel());
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sanction toUnescapedModel() {
		return new SanctionWrapper(_sanction.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sanction.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sanction.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sanction.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SanctionWrapper)) {
			return false;
		}

		SanctionWrapper sanctionWrapper = (SanctionWrapper)obj;

		if (Validator.equals(_sanction, sanctionWrapper._sanction)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Sanction getWrappedSanction() {
		return _sanction;
	}

	@Override
	public Sanction getWrappedModel() {
		return _sanction;
	}

	@Override
	public void resetOriginalValues() {
		_sanction.resetOriginalValues();
	}

	private Sanction _sanction;
}