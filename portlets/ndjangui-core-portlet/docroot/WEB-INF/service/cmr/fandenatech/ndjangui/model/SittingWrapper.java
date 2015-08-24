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
 * This class is a wrapper for {@link Sitting}.
 * </p>
 *
 * @author guyw
 * @see Sitting
 * @generated
 */
public class SittingWrapper implements Sitting, ModelWrapper<Sitting> {
	public SittingWrapper(Sitting sitting) {
		_sitting = sitting;
	}

	@Override
	public Class<?> getModelClass() {
		return Sitting.class;
	}

	@Override
	public String getModelClassName() {
		return Sitting.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sittingId", getSittingId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("startDate", getStartDate());
		attributes.put("startHour", getStartHour());
		attributes.put("startMin", getStartMin());
		attributes.put("endDate", getEndDate());
		attributes.put("endHour", getEndHour());
		attributes.put("endMin", getEndMin());
		attributes.put("budgetPeriodId", getBudgetPeriodId());
		attributes.put("name", getName());
		attributes.put("dayPlan", getDayPlan());
		attributes.put("notes", getNotes());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sittingId = (Long)attributes.get("sittingId");

		if (sittingId != null) {
			setSittingId(sittingId);
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

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Integer startHour = (Integer)attributes.get("startHour");

		if (startHour != null) {
			setStartHour(startHour);
		}

		Integer startMin = (Integer)attributes.get("startMin");

		if (startMin != null) {
			setStartMin(startMin);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer endHour = (Integer)attributes.get("endHour");

		if (endHour != null) {
			setEndHour(endHour);
		}

		Integer endMin = (Integer)attributes.get("endMin");

		if (endMin != null) {
			setEndMin(endMin);
		}

		Long budgetPeriodId = (Long)attributes.get("budgetPeriodId");

		if (budgetPeriodId != null) {
			setBudgetPeriodId(budgetPeriodId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String dayPlan = (String)attributes.get("dayPlan");

		if (dayPlan != null) {
			setDayPlan(dayPlan);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this sitting.
	*
	* @return the primary key of this sitting
	*/
	@Override
	public long getPrimaryKey() {
		return _sitting.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sitting.
	*
	* @param primaryKey the primary key of this sitting
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sitting.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sitting ID of this sitting.
	*
	* @return the sitting ID of this sitting
	*/
	@Override
	public long getSittingId() {
		return _sitting.getSittingId();
	}

	/**
	* Sets the sitting ID of this sitting.
	*
	* @param sittingId the sitting ID of this sitting
	*/
	@Override
	public void setSittingId(long sittingId) {
		_sitting.setSittingId(sittingId);
	}

	/**
	* Returns the user ID of this sitting.
	*
	* @return the user ID of this sitting
	*/
	@Override
	public long getUserId() {
		return _sitting.getUserId();
	}

	/**
	* Sets the user ID of this sitting.
	*
	* @param userId the user ID of this sitting
	*/
	@Override
	public void setUserId(long userId) {
		_sitting.setUserId(userId);
	}

	/**
	* Returns the user uuid of this sitting.
	*
	* @return the user uuid of this sitting
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sitting.getUserUuid();
	}

	/**
	* Sets the user uuid of this sitting.
	*
	* @param userUuid the user uuid of this sitting
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_sitting.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this sitting.
	*
	* @return the group ID of this sitting
	*/
	@Override
	public long getGroupId() {
		return _sitting.getGroupId();
	}

	/**
	* Sets the group ID of this sitting.
	*
	* @param groupId the group ID of this sitting
	*/
	@Override
	public void setGroupId(long groupId) {
		_sitting.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this sitting.
	*
	* @return the company ID of this sitting
	*/
	@Override
	public long getCompanyId() {
		return _sitting.getCompanyId();
	}

	/**
	* Sets the company ID of this sitting.
	*
	* @param companyId the company ID of this sitting
	*/
	@Override
	public void setCompanyId(long companyId) {
		_sitting.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this sitting.
	*
	* @return the user name of this sitting
	*/
	@Override
	public java.lang.String getUserName() {
		return _sitting.getUserName();
	}

	/**
	* Sets the user name of this sitting.
	*
	* @param userName the user name of this sitting
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_sitting.setUserName(userName);
	}

	/**
	* Returns the create date of this sitting.
	*
	* @return the create date of this sitting
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _sitting.getCreateDate();
	}

	/**
	* Sets the create date of this sitting.
	*
	* @param createDate the create date of this sitting
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_sitting.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this sitting.
	*
	* @return the modified date of this sitting
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _sitting.getModifiedDate();
	}

	/**
	* Sets the modified date of this sitting.
	*
	* @param modifiedDate the modified date of this sitting
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_sitting.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the start date of this sitting.
	*
	* @return the start date of this sitting
	*/
	@Override
	public java.util.Date getStartDate() {
		return _sitting.getStartDate();
	}

	/**
	* Sets the start date of this sitting.
	*
	* @param startDate the start date of this sitting
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_sitting.setStartDate(startDate);
	}

	/**
	* Returns the start hour of this sitting.
	*
	* @return the start hour of this sitting
	*/
	@Override
	public int getStartHour() {
		return _sitting.getStartHour();
	}

	/**
	* Sets the start hour of this sitting.
	*
	* @param startHour the start hour of this sitting
	*/
	@Override
	public void setStartHour(int startHour) {
		_sitting.setStartHour(startHour);
	}

	/**
	* Returns the start min of this sitting.
	*
	* @return the start min of this sitting
	*/
	@Override
	public int getStartMin() {
		return _sitting.getStartMin();
	}

	/**
	* Sets the start min of this sitting.
	*
	* @param startMin the start min of this sitting
	*/
	@Override
	public void setStartMin(int startMin) {
		_sitting.setStartMin(startMin);
	}

	/**
	* Returns the end date of this sitting.
	*
	* @return the end date of this sitting
	*/
	@Override
	public java.util.Date getEndDate() {
		return _sitting.getEndDate();
	}

	/**
	* Sets the end date of this sitting.
	*
	* @param endDate the end date of this sitting
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_sitting.setEndDate(endDate);
	}

	/**
	* Returns the end hour of this sitting.
	*
	* @return the end hour of this sitting
	*/
	@Override
	public int getEndHour() {
		return _sitting.getEndHour();
	}

	/**
	* Sets the end hour of this sitting.
	*
	* @param endHour the end hour of this sitting
	*/
	@Override
	public void setEndHour(int endHour) {
		_sitting.setEndHour(endHour);
	}

	/**
	* Returns the end min of this sitting.
	*
	* @return the end min of this sitting
	*/
	@Override
	public int getEndMin() {
		return _sitting.getEndMin();
	}

	/**
	* Sets the end min of this sitting.
	*
	* @param endMin the end min of this sitting
	*/
	@Override
	public void setEndMin(int endMin) {
		_sitting.setEndMin(endMin);
	}

	/**
	* Returns the budget period ID of this sitting.
	*
	* @return the budget period ID of this sitting
	*/
	@Override
	public long getBudgetPeriodId() {
		return _sitting.getBudgetPeriodId();
	}

	/**
	* Sets the budget period ID of this sitting.
	*
	* @param budgetPeriodId the budget period ID of this sitting
	*/
	@Override
	public void setBudgetPeriodId(long budgetPeriodId) {
		_sitting.setBudgetPeriodId(budgetPeriodId);
	}

	/**
	* Returns the name of this sitting.
	*
	* @return the name of this sitting
	*/
	@Override
	public java.lang.String getName() {
		return _sitting.getName();
	}

	/**
	* Sets the name of this sitting.
	*
	* @param name the name of this sitting
	*/
	@Override
	public void setName(java.lang.String name) {
		_sitting.setName(name);
	}

	/**
	* Returns the day plan of this sitting.
	*
	* @return the day plan of this sitting
	*/
	@Override
	public java.lang.String getDayPlan() {
		return _sitting.getDayPlan();
	}

	/**
	* Sets the day plan of this sitting.
	*
	* @param dayPlan the day plan of this sitting
	*/
	@Override
	public void setDayPlan(java.lang.String dayPlan) {
		_sitting.setDayPlan(dayPlan);
	}

	/**
	* Returns the notes of this sitting.
	*
	* @return the notes of this sitting
	*/
	@Override
	public java.lang.String getNotes() {
		return _sitting.getNotes();
	}

	/**
	* Sets the notes of this sitting.
	*
	* @param notes the notes of this sitting
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_sitting.setNotes(notes);
	}

	/**
	* Returns the status of this sitting.
	*
	* @return the status of this sitting
	*/
	@Override
	public int getStatus() {
		return _sitting.getStatus();
	}

	/**
	* Sets the status of this sitting.
	*
	* @param status the status of this sitting
	*/
	@Override
	public void setStatus(int status) {
		_sitting.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _sitting.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sitting.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sitting.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sitting.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sitting.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sitting.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sitting.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sitting.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sitting.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sitting.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sitting.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SittingWrapper((Sitting)_sitting.clone());
	}

	@Override
	public int compareTo(cmr.fandenatech.ndjangui.model.Sitting sitting) {
		return _sitting.compareTo(sitting);
	}

	@Override
	public int hashCode() {
		return _sitting.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<cmr.fandenatech.ndjangui.model.Sitting> toCacheModel() {
		return _sitting.toCacheModel();
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting toEscapedModel() {
		return new SittingWrapper(_sitting.toEscapedModel());
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting toUnescapedModel() {
		return new SittingWrapper(_sitting.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sitting.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sitting.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sitting.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SittingWrapper)) {
			return false;
		}

		SittingWrapper sittingWrapper = (SittingWrapper)obj;

		if (Validator.equals(_sitting, sittingWrapper._sitting)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Sitting getWrappedSitting() {
		return _sitting;
	}

	@Override
	public Sitting getWrappedModel() {
		return _sitting;
	}

	@Override
	public void resetOriginalValues() {
		_sitting.resetOriginalValues();
	}

	private Sitting _sitting;
}