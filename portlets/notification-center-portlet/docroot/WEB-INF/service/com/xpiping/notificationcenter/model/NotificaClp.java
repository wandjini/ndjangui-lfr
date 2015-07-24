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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.xpiping.notificationcenter.service.ClpSerializer;
import com.xpiping.notificationcenter.service.NotificaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author marcoleo
 */
public class NotificaClp extends BaseModelImpl<Notifica> implements Notifica {
	public NotificaClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Notifica.class;
	}

	@Override
	public String getModelClassName() {
		return Notifica.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _notificaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNotificaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _notificaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notificaId", getNotificaId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("notificaTypeId", getNotificaTypeId());
		attributes.put("name", getName());
		attributes.put("text", getText());
		attributes.put("subject", getSubject());
		attributes.put("description", getDescription());
		attributes.put("aviable", getAviable());
		attributes.put("ignoreIntersaction", getIgnoreIntersaction());
		attributes.put("orgsIds", getOrgsIds());
		attributes.put("groupsIds", getGroupsIds());
		attributes.put("rolesIds", getRolesIds());
		attributes.put("lastCheckDate", getLastCheckDate());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long notificaId = (Long)attributes.get("notificaId");

		if (notificaId != null) {
			setNotificaId(notificaId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
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

		Long notificaTypeId = (Long)attributes.get("notificaTypeId");

		if (notificaTypeId != null) {
			setNotificaTypeId(notificaTypeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String text = (String)attributes.get("text");

		if (text != null) {
			setText(text);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean aviable = (Boolean)attributes.get("aviable");

		if (aviable != null) {
			setAviable(aviable);
		}

		Boolean ignoreIntersaction = (Boolean)attributes.get(
				"ignoreIntersaction");

		if (ignoreIntersaction != null) {
			setIgnoreIntersaction(ignoreIntersaction);
		}

		String orgsIds = (String)attributes.get("orgsIds");

		if (orgsIds != null) {
			setOrgsIds(orgsIds);
		}

		String groupsIds = (String)attributes.get("groupsIds");

		if (groupsIds != null) {
			setGroupsIds(groupsIds);
		}

		String rolesIds = (String)attributes.get("rolesIds");

		if (rolesIds != null) {
			setRolesIds(rolesIds);
		}

		Date lastCheckDate = (Date)attributes.get("lastCheckDate");

		if (lastCheckDate != null) {
			setLastCheckDate(lastCheckDate);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	@Override
	public long getNotificaId() {
		return _notificaId;
	}

	@Override
	public void setNotificaId(long notificaId) {
		_notificaId = notificaId;

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificaId", long.class);

				method.invoke(_notificaRemoteModel, notificaId);
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

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_notificaRemoteModel, companyId);
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

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_notificaRemoteModel, userId);
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
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_notificaRemoteModel, userName);
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

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_notificaRemoteModel, createDate);
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

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_notificaRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNotificaTypeId() {
		return _notificaTypeId;
	}

	@Override
	public void setNotificaTypeId(long notificaTypeId) {
		_notificaTypeId = notificaTypeId;

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificaTypeId", long.class);

				method.invoke(_notificaRemoteModel, notificaTypeId);
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

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_notificaRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getText() {
		return _text;
	}

	@Override
	public void setText(String text) {
		_text = text;

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setText", String.class);

				method.invoke(_notificaRemoteModel, text);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubject() {
		return _subject;
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setSubject", String.class);

				method.invoke(_notificaRemoteModel, subject);
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

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_notificaRemoteModel, description);
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

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setAviable", Boolean.class);

				method.invoke(_notificaRemoteModel, aviable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getIgnoreIntersaction() {
		return _ignoreIntersaction;
	}

	@Override
	public void setIgnoreIntersaction(Boolean ignoreIntersaction) {
		_ignoreIntersaction = ignoreIntersaction;

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setIgnoreIntersaction",
						Boolean.class);

				method.invoke(_notificaRemoteModel, ignoreIntersaction);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrgsIds() {
		return _orgsIds;
	}

	@Override
	public void setOrgsIds(String orgsIds) {
		_orgsIds = orgsIds;

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setOrgsIds", String.class);

				method.invoke(_notificaRemoteModel, orgsIds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGroupsIds() {
		return _groupsIds;
	}

	@Override
	public void setGroupsIds(String groupsIds) {
		_groupsIds = groupsIds;

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupsIds", String.class);

				method.invoke(_notificaRemoteModel, groupsIds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRolesIds() {
		return _rolesIds;
	}

	@Override
	public void setRolesIds(String rolesIds) {
		_rolesIds = rolesIds;

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setRolesIds", String.class);

				method.invoke(_notificaRemoteModel, rolesIds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastCheckDate() {
		return _lastCheckDate;
	}

	@Override
	public void setLastCheckDate(Date lastCheckDate) {
		_lastCheckDate = lastCheckDate;

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setLastCheckDate", Date.class);

				method.invoke(_notificaRemoteModel, lastCheckDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getDeleted() {
		return _deleted;
	}

	@Override
	public void setDeleted(Boolean deleted) {
		_deleted = deleted;

		if (_notificaRemoteModel != null) {
			try {
				Class<?> clazz = _notificaRemoteModel.getClass();

				Method method = clazz.getMethod("setDeleted", Boolean.class);

				method.invoke(_notificaRemoteModel, deleted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNotificaRemoteModel() {
		return _notificaRemoteModel;
	}

	public void setNotificaRemoteModel(BaseModel<?> notificaRemoteModel) {
		_notificaRemoteModel = notificaRemoteModel;
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

		Class<?> remoteModelClass = _notificaRemoteModel.getClass();

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

		Object returnValue = method.invoke(_notificaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NotificaLocalServiceUtil.addNotifica(this);
		}
		else {
			NotificaLocalServiceUtil.updateNotifica(this);
		}
	}

	@Override
	public Notifica toEscapedModel() {
		return (Notifica)ProxyUtil.newProxyInstance(Notifica.class.getClassLoader(),
			new Class[] { Notifica.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NotificaClp clone = new NotificaClp();

		clone.setNotificaId(getNotificaId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNotificaTypeId(getNotificaTypeId());
		clone.setName(getName());
		clone.setText(getText());
		clone.setSubject(getSubject());
		clone.setDescription(getDescription());
		clone.setAviable(getAviable());
		clone.setIgnoreIntersaction(getIgnoreIntersaction());
		clone.setOrgsIds(getOrgsIds());
		clone.setGroupsIds(getGroupsIds());
		clone.setRolesIds(getRolesIds());
		clone.setLastCheckDate(getLastCheckDate());
		clone.setDeleted(getDeleted());

		return clone;
	}

	@Override
	public int compareTo(Notifica notifica) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), notifica.getCreateDate());

		value = value * -1;

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

		if (!(obj instanceof NotificaClp)) {
			return false;
		}

		NotificaClp notifica = (NotificaClp)obj;

		long primaryKey = notifica.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{notificaId=");
		sb.append(getNotificaId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", notificaTypeId=");
		sb.append(getNotificaTypeId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", text=");
		sb.append(getText());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", aviable=");
		sb.append(getAviable());
		sb.append(", ignoreIntersaction=");
		sb.append(getIgnoreIntersaction());
		sb.append(", orgsIds=");
		sb.append(getOrgsIds());
		sb.append(", groupsIds=");
		sb.append(getGroupsIds());
		sb.append(", rolesIds=");
		sb.append(getRolesIds());
		sb.append(", lastCheckDate=");
		sb.append(getLastCheckDate());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.xpiping.notificationcenter.model.Notifica");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>notificaId</column-name><column-value><![CDATA[");
		sb.append(getNotificaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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
			"<column><column-name>notificaTypeId</column-name><column-value><![CDATA[");
		sb.append(getNotificaTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>text</column-name><column-value><![CDATA[");
		sb.append(getText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aviable</column-name><column-value><![CDATA[");
		sb.append(getAviable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ignoreIntersaction</column-name><column-value><![CDATA[");
		sb.append(getIgnoreIntersaction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgsIds</column-name><column-value><![CDATA[");
		sb.append(getOrgsIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupsIds</column-name><column-value><![CDATA[");
		sb.append(getGroupsIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rolesIds</column-name><column-value><![CDATA[");
		sb.append(getRolesIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastCheckDate</column-name><column-value><![CDATA[");
		sb.append(getLastCheckDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _notificaId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _notificaTypeId;
	private String _name;
	private String _text;
	private String _subject;
	private String _description;
	private Boolean _aviable;
	private Boolean _ignoreIntersaction;
	private String _orgsIds;
	private String _groupsIds;
	private String _rolesIds;
	private Date _lastCheckDate;
	private Boolean _deleted;
	private BaseModel<?> _notificaRemoteModel;
}