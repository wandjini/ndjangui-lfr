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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Sitting service. Represents a row in the &quot;ndjangui_Sitting&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link cmr.fandenatech.ndjangui.model.impl.SittingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link cmr.fandenatech.ndjangui.model.impl.SittingImpl}.
 * </p>
 *
 * @author guyw
 * @see Sitting
 * @see cmr.fandenatech.ndjangui.model.impl.SittingImpl
 * @see cmr.fandenatech.ndjangui.model.impl.SittingModelImpl
 * @generated
 */
public interface SittingModel extends BaseModel<Sitting>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a sitting model instance should use the {@link Sitting} interface instead.
	 */

	/**
	 * Returns the primary key of this sitting.
	 *
	 * @return the primary key of this sitting
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this sitting.
	 *
	 * @param primaryKey the primary key of this sitting
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sitting ID of this sitting.
	 *
	 * @return the sitting ID of this sitting
	 */
	public long getSittingId();

	/**
	 * Sets the sitting ID of this sitting.
	 *
	 * @param sittingId the sitting ID of this sitting
	 */
	public void setSittingId(long sittingId);

	/**
	 * Returns the user ID of this sitting.
	 *
	 * @return the user ID of this sitting
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this sitting.
	 *
	 * @param userId the user ID of this sitting
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this sitting.
	 *
	 * @return the user uuid of this sitting
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this sitting.
	 *
	 * @param userUuid the user uuid of this sitting
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the group ID of this sitting.
	 *
	 * @return the group ID of this sitting
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this sitting.
	 *
	 * @param groupId the group ID of this sitting
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this sitting.
	 *
	 * @return the company ID of this sitting
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this sitting.
	 *
	 * @param companyId the company ID of this sitting
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user name of this sitting.
	 *
	 * @return the user name of this sitting
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this sitting.
	 *
	 * @param userName the user name of this sitting
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this sitting.
	 *
	 * @return the create date of this sitting
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this sitting.
	 *
	 * @param createDate the create date of this sitting
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this sitting.
	 *
	 * @return the modified date of this sitting
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this sitting.
	 *
	 * @param modifiedDate the modified date of this sitting
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the start date of this sitting.
	 *
	 * @return the start date of this sitting
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this sitting.
	 *
	 * @param startDate the start date of this sitting
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the start hour of this sitting.
	 *
	 * @return the start hour of this sitting
	 */
	public int getStartHour();

	/**
	 * Sets the start hour of this sitting.
	 *
	 * @param startHour the start hour of this sitting
	 */
	public void setStartHour(int startHour);

	/**
	 * Returns the start min of this sitting.
	 *
	 * @return the start min of this sitting
	 */
	public int getStartMin();

	/**
	 * Sets the start min of this sitting.
	 *
	 * @param startMin the start min of this sitting
	 */
	public void setStartMin(int startMin);

	/**
	 * Returns the end date of this sitting.
	 *
	 * @return the end date of this sitting
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this sitting.
	 *
	 * @param endDate the end date of this sitting
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the end hour of this sitting.
	 *
	 * @return the end hour of this sitting
	 */
	public int getEndHour();

	/**
	 * Sets the end hour of this sitting.
	 *
	 * @param endHour the end hour of this sitting
	 */
	public void setEndHour(int endHour);

	/**
	 * Returns the end min of this sitting.
	 *
	 * @return the end min of this sitting
	 */
	public int getEndMin();

	/**
	 * Sets the end min of this sitting.
	 *
	 * @param endMin the end min of this sitting
	 */
	public void setEndMin(int endMin);

	/**
	 * Returns the budget period ID of this sitting.
	 *
	 * @return the budget period ID of this sitting
	 */
	public long getBudgetPeriodId();

	/**
	 * Sets the budget period ID of this sitting.
	 *
	 * @param budgetPeriodId the budget period ID of this sitting
	 */
	public void setBudgetPeriodId(long budgetPeriodId);

	/**
	 * Returns the name of this sitting.
	 *
	 * @return the name of this sitting
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this sitting.
	 *
	 * @param name the name of this sitting
	 */
	public void setName(String name);

	/**
	 * Returns the day plan of this sitting.
	 *
	 * @return the day plan of this sitting
	 */
	@AutoEscape
	public String getDayPlan();

	/**
	 * Sets the day plan of this sitting.
	 *
	 * @param dayPlan the day plan of this sitting
	 */
	public void setDayPlan(String dayPlan);

	/**
	 * Returns the notes of this sitting.
	 *
	 * @return the notes of this sitting
	 */
	@AutoEscape
	public String getNotes();

	/**
	 * Sets the notes of this sitting.
	 *
	 * @param notes the notes of this sitting
	 */
	public void setNotes(String notes);

	/**
	 * Returns the status of this sitting.
	 *
	 * @return the status of this sitting
	 */
	public int getStatus();

	/**
	 * Sets the status of this sitting.
	 *
	 * @param status the status of this sitting
	 */
	public void setStatus(int status);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(cmr.fandenatech.ndjangui.model.Sitting sitting);

	@Override
	public int hashCode();

	@Override
	public CacheModel<cmr.fandenatech.ndjangui.model.Sitting> toCacheModel();

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting toEscapedModel();

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}