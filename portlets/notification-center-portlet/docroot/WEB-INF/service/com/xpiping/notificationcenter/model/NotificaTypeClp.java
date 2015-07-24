/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.xpiping.notificationcenter.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.xpiping.notificationcenter.service.ClpSerializer;
import com.xpiping.notificationcenter.service.NotificaTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author marcoleo
 */
public class NotificaTypeClp extends BaseModelImpl<NotificaType>
	implements NotificaType {
	public NotificaTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return NotificaType.class;
	}

	@Override
	public String getModelClassName() {
		return NotificaType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _notificaTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNotificaTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _notificaTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notificaTypeId", getNotificaTypeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("messageDestination", getMessageDestination());
		attributes.put("description", getDescription());
		attributes.put("placeHolders", getPlaceHolders());
		attributes.put("aviable", getAviable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long notificaTypeId = (Long)attributes.get("notificaTypeId");

		if (notificaTypeId != null) {
			setNotificaTypeId(notificaTypeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String messageDestination = (String)attributes.get("messageDestination");

		if (messageDestination != null) {
			setMessageDestination(messageDestination);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String placeHolders = (String)attributes.get("placeHolders");

		if (placeHolders != null) {
			setPlaceHolders(placeHolders);
		}

		Boolean aviable = (Boolean)attributes.get("aviable");

		if (aviable != null) {
			setAviable(aviable);
		}
	}

	@Override
	public long getNotificaTypeId() {
		return _notificaTypeId;
	}

	@Override
	public void setNotificaTypeId(long notificaTypeId) {
		_notificaTypeId = notificaTypeId;

		if (_notificaTypeRemoteModel != null) {
			try {
				Class<?> clazz = _notificaTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificaTypeId", long.class);

				method.invoke(_notificaTypeRemoteModel, notificaTypeId);
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

		if (_notificaTypeRemoteModel != null) {
			try {
				Class<?> clazz = _notificaTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_notificaTypeRemoteModel, companyId);
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

		if (_notificaTypeRemoteModel != null) {
			try {
				Class<?> clazz = _notificaTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_notificaTypeRemoteModel, createDate);
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

		if (_notificaTypeRemoteModel != null) {
			try {
				Class<?> clazz = _notificaTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_notificaTypeRemoteModel, modifiedDate);
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

		if (_notificaTypeRemoteModel != null) {
			try {
				Class<?> clazz = _notificaTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_notificaTypeRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMessageDestination() {
		return _messageDestination;
	}

	@Override
	public void setMessageDestination(String messageDestination) {
		_messageDestination = messageDestination;

		if (_notificaTypeRemoteModel != null) {
			try {
				Class<?> clazz = _notificaTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setMessageDestination",
						String.class);

				method.invoke(_notificaTypeRemoteModel, messageDestination);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_notificaTypeRemoteModel != null) {
			try {
				Class<?> clazz = _notificaTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_notificaTypeRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPlaceHolders() {
		return _placeHolders;
	}

	@Override
	public void setPlaceHolders(String placeHolders) {
		_placeHolders = placeHolders;

		if (_notificaTypeRemoteModel != null) {
			try {
				Class<?> clazz = _notificaTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setPlaceHolders", String.class);

				method.invoke(_notificaTypeRemoteModel, placeHolders);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getAviable() {
		return _aviable;
	}

	@Override
	public void setAviable(Boolean aviable) {
		_aviable = aviable;

		if (_notificaTypeRemoteModel != null) {
			try {
				Class<?> clazz = _notificaTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setAviable", Boolean.class);

				method.invoke(_notificaTypeRemoteModel, aviable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNotificaTypeRemoteModel() {
		return _notificaTypeRemoteModel;
	}

	public void setNotificaTypeRemoteModel(BaseModel<?> notificaTypeRemoteModel) {
		_notificaTypeRemoteModel = notificaTypeRemoteModel;
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

		Class<?> remoteModelClass = _notificaTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_notificaTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NotificaTypeLocalServiceUtil.addNotificaType(this);
		}
		else {
			NotificaTypeLocalServiceUtil.updateNotificaType(this);
		}
	}

	@Override
	public NotificaType toEscapedModel() {
		return (NotificaType)ProxyUtil.newProxyInstance(NotificaType.class.getClassLoader(),
			new Class[] { NotificaType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NotificaTypeClp clone = new NotificaTypeClp();

		clone.setNotificaTypeId(getNotificaTypeId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setMessageDestination(getMessageDestination());
		clone.setDescription(getDescription());
		clone.setPlaceHolders(getPlaceHolders());
		clone.setAviable(getAviable());

		return clone;
	}

	@Override
	public int compareTo(NotificaType notificaType) {
		int value = 0;

		value = getName().compareTo(notificaType.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificaTypeClp)) {
			return false;
		}

		NotificaTypeClp notificaType = (NotificaTypeClp)obj;

		long primaryKey = notificaType.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{notificaTypeId=");
		sb.append(getNotificaTypeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", messageDestination=");
		sb.append(getMessageDestination());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", placeHolders=");
		sb.append(getPlaceHolders());
		sb.append(", aviable=");
		sb.append(getAviable());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.xpiping.notificationcenter.model.NotificaType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>notificaTypeId</column-name><column-value><![CDATA[");
		sb.append(getNotificaTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageDestination</column-name><column-value><![CDATA[");
		sb.append(getMessageDestination());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>placeHolders</column-name><column-value><![CDATA[");
		sb.append(getPlaceHolders());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aviable</column-name><column-value><![CDATA[");
		sb.append(getAviable());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _notificaTypeId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _messageDestination;
	private String _description;
	private String _placeHolders;
	private Boolean _aviable;
	private BaseModel<?> _notificaTypeRemoteModel;
}