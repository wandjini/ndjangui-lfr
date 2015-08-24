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

import cmr.fandenatech.ndjangui.service.ClpSerializer;
import cmr.fandenatech.ndjangui.service.SittingLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guyw
 */
public class SittingClp extends BaseModelImpl<Sitting> implements Sitting {
	public SittingClp() {
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
	public long getPrimaryKey() {
		return _sittingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSittingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sittingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSittingId() {
		return _sittingId;
	}

	@Override
	public void setSittingId(long sittingId) {
		_sittingId = sittingId;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setSittingId", long.class);

				method.invoke(_sittingRemoteModel, sittingId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_sittingRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_sittingRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_sittingRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_sittingRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_sittingRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_sittingRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_sittingRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStartHour() {
		return _startHour;
	}

	@Override
	public void setStartHour(int startHour) {
		_startHour = startHour;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setStartHour", int.class);

				method.invoke(_sittingRemoteModel, startHour);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStartMin() {
		return _startMin;
	}

	@Override
	public void setStartMin(int startMin) {
		_startMin = startMin;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setStartMin", int.class);

				method.invoke(_sittingRemoteModel, startMin);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_sittingRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEndHour() {
		return _endHour;
	}

	@Override
	public void setEndHour(int endHour) {
		_endHour = endHour;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setEndHour", int.class);

				method.invoke(_sittingRemoteModel, endHour);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEndMin() {
		return _endMin;
	}

	@Override
	public void setEndMin(int endMin) {
		_endMin = endMin;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setEndMin", int.class);

				method.invoke(_sittingRemoteModel, endMin);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBudgetPeriodId() {
		return _budgetPeriodId;
	}

	@Override
	public void setBudgetPeriodId(long budgetPeriodId) {
		_budgetPeriodId = budgetPeriodId;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setBudgetPeriodId", long.class);

				method.invoke(_sittingRemoteModel, budgetPeriodId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_sittingRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDayPlan() {
		return _dayPlan;
	}

	@Override
	public void setDayPlan(String dayPlan) {
		_dayPlan = dayPlan;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setDayPlan", String.class);

				method.invoke(_sittingRemoteModel, dayPlan);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotes() {
		return _notes;
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setNotes", String.class);

				method.invoke(_sittingRemoteModel, notes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_sittingRemoteModel != null) {
			try {
				Class<?> clazz = _sittingRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_sittingRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSittingRemoteModel() {
		return _sittingRemoteModel;
	}

	public void setSittingRemoteModel(BaseModel<?> sittingRemoteModel) {
		_sittingRemoteModel = sittingRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _sittingRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_sittingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SittingLocalServiceUtil.addSitting(this);
		}
		else {
			SittingLocalServiceUtil.updateSitting(this);
		}
	}

	@Override
	public Sitting toEscapedModel() {
		return (Sitting)ProxyUtil.newProxyInstance(Sitting.class.getClassLoader(),
			new Class[] { Sitting.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SittingClp clone = new SittingClp();

		clone.setSittingId(getSittingId());
		clone.setUserId(getUserId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setStartDate(getStartDate());
		clone.setStartHour(getStartHour());
		clone.setStartMin(getStartMin());
		clone.setEndDate(getEndDate());
		clone.setEndHour(getEndHour());
		clone.setEndMin(getEndMin());
		clone.setBudgetPeriodId(getBudgetPeriodId());
		clone.setName(getName());
		clone.setDayPlan(getDayPlan());
		clone.setNotes(getNotes());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(Sitting sitting) {
		long primaryKey = sitting.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SittingClp)) {
			return false;
		}

		SittingClp sitting = (SittingClp)obj;

		long primaryKey = sitting.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{sittingId=");
		sb.append(getSittingId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", startHour=");
		sb.append(getStartHour());
		sb.append(", startMin=");
		sb.append(getStartMin());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", endHour=");
		sb.append(getEndHour());
		sb.append(", endMin=");
		sb.append(getEndMin());
		sb.append(", budgetPeriodId=");
		sb.append(getBudgetPeriodId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", dayPlan=");
		sb.append(getDayPlan());
		sb.append(", notes=");
		sb.append(getNotes());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("cmr.fandenatech.ndjangui.model.Sitting");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sittingId</column-name><column-value><![CDATA[");
		sb.append(getSittingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startHour</column-name><column-value><![CDATA[");
		sb.append(getStartHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startMin</column-name><column-value><![CDATA[");
		sb.append(getStartMin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endHour</column-name><column-value><![CDATA[");
		sb.append(getEndHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endMin</column-name><column-value><![CDATA[");
		sb.append(getEndMin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>budgetPeriodId</column-name><column-value><![CDATA[");
		sb.append(getBudgetPeriodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dayPlan</column-name><column-value><![CDATA[");
		sb.append(getDayPlan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notes</column-name><column-value><![CDATA[");
		sb.append(getNotes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _sittingId;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _startDate;
	private int _startHour;
	private int _startMin;
	private Date _endDate;
	private int _endHour;
	private int _endMin;
	private long _budgetPeriodId;
	private String _name;
	private String _dayPlan;
	private String _notes;
	private int _status;
	private BaseModel<?> _sittingRemoteModel;
	private Class<?> _clpSerializerClass = cmr.fandenatech.ndjangui.service.ClpSerializer.class;
}