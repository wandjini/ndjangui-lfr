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
import com.xpiping.notificationcenter.service.NotificaMessageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author marcoleo
 */
public class NotificaMessageClp extends BaseModelImpl<NotificaMessage>
	implements NotificaMessage {
	public NotificaMessageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return NotificaMessage.class;
	}

	@Override
	public String getModelClassName() {
		return NotificaMessage.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _notificaMessageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNotificaMessageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _notificaMessageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notificaMessageId", getNotificaMessageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("notificaId", getNotificaId());
		attributes.put("userId", getUserId());
		attributes.put("entityId", getEntityId());
		attributes.put("entityName", getEntityName());
		attributes.put("queuedEmailId", getQueuedEmailId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long notificaMessageId = (Long)attributes.get("notificaMessageId");

		if (notificaMessageId != null) {
			setNotificaMessageId(notificaMessageId);
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

		Long notificaId = (Long)attributes.get("notificaId");

		if (notificaId != null) {
			setNotificaId(notificaId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		String entityName = (String)attributes.get("entityName");

		if (entityName != null) {
			setEntityName(entityName);
		}

		Long queuedEmailId = (Long)attributes.get("queuedEmailId");

		if (queuedEmailId != null) {
			setQueuedEmailId(queuedEmailId);
		}
	}

	@Override
	public long getNotificaMessageId() {
		return _notificaMessageId;
	}

	@Override
	public void setNotificaMessageId(long notificaMessageId) {
		_notificaMessageId = notificaMessageId;

		if (_notificaMessageRemoteModel != null) {
			try {
				Class<?> clazz = _notificaMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificaMessageId",
						long.class);

				method.invoke(_notificaMessageRemoteModel, notificaMessageId);
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

		if (_notificaMessageRemoteModel != null) {
			try {
				Class<?> clazz = _notificaMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_notificaMessageRemoteModel, companyId);
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

		if (_notificaMessageRemoteModel != null) {
			try {
				Class<?> clazz = _notificaMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_notificaMessageRemoteModel, createDate);
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

		if (_notificaMessageRemoteModel != null) {
			try {
				Class<?> clazz = _notificaMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_notificaMessageRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNotificaId() {
		return _notificaId;
	}

	@Override
	public void setNotificaId(long notificaId) {
		_notificaId = notificaId;

		if (_notificaMessageRemoteModel != null) {
			try {
				Class<?> clazz = _notificaMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificaId", long.class);

				method.invoke(_notificaMessageRemoteModel, notificaId);
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

		if (_notificaMessageRemoteModel != null) {
			try {
				Class<?> clazz = _notificaMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_notificaMessageRemoteModel, userId);
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
	public long getEntityId() {
		return _entityId;
	}

	@Override
	public void setEntityId(long entityId) {
		_entityId = entityId;

		if (_notificaMessageRemoteModel != null) {
			try {
				Class<?> clazz = _notificaMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityId", long.class);

				method.invoke(_notificaMessageRemoteModel, entityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntityName() {
		return _entityName;
	}

	@Override
	public void setEntityName(String entityName) {
		_entityName = entityName;

		if (_notificaMessageRemoteModel != null) {
			try {
				Class<?> clazz = _notificaMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityName", String.class);

				method.invoke(_notificaMessageRemoteModel, entityName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getQueuedEmailId() {
		return _queuedEmailId;
	}

	@Override
	public void setQueuedEmailId(long queuedEmailId) {
		_queuedEmailId = queuedEmailId;

		if (_notificaMessageRemoteModel != null) {
			try {
				Class<?> clazz = _notificaMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setQueuedEmailId", long.class);

				method.invoke(_notificaMessageRemoteModel, queuedEmailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNotificaMessageRemoteModel() {
		return _notificaMessageRemoteModel;
	}

	public void setNotificaMessageRemoteModel(
		BaseModel<?> notificaMessageRemoteModel) {
		_notificaMessageRemoteModel = notificaMessageRemoteModel;
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

		Class<?> remoteModelClass = _notificaMessageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_notificaMessageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NotificaMessageLocalServiceUtil.addNotificaMessage(this);
		}
		else {
			NotificaMessageLocalServiceUtil.updateNotificaMessage(this);
		}
	}

	@Override
	public NotificaMessage toEscapedModel() {
		return (NotificaMessage)ProxyUtil.newProxyInstance(NotificaMessage.class.getClassLoader(),
			new Class[] { NotificaMessage.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NotificaMessageClp clone = new NotificaMessageClp();

		clone.setNotificaMessageId(getNotificaMessageId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNotificaId(getNotificaId());
		clone.setUserId(getUserId());
		clone.setEntityId(getEntityId());
		clone.setEntityName(getEntityName());
		clone.setQueuedEmailId(getQueuedEmailId());

		return clone;
	}

	@Override
	public int compareTo(NotificaMessage notificaMessage) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				notificaMessage.getCreateDate());

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

		if (!(obj instanceof NotificaMessageClp)) {
			return false;
		}

		NotificaMessageClp notificaMessage = (NotificaMessageClp)obj;

		long primaryKey = notificaMessage.getPrimaryKey();

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

		sb.append("{notificaMessageId=");
		sb.append(getNotificaMessageId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", notificaId=");
		sb.append(getNotificaId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", entityId=");
		sb.append(getEntityId());
		sb.append(", entityName=");
		sb.append(getEntityName());
		sb.append(", queuedEmailId=");
		sb.append(getQueuedEmailId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.xpiping.notificationcenter.model.NotificaMessage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>notificaMessageId</column-name><column-value><![CDATA[");
		sb.append(getNotificaMessageId());
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
			"<column><column-name>notificaId</column-name><column-value><![CDATA[");
		sb.append(getNotificaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityId</column-name><column-value><![CDATA[");
		sb.append(getEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityName</column-name><column-value><![CDATA[");
		sb.append(getEntityName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>queuedEmailId</column-name><column-value><![CDATA[");
		sb.append(getQueuedEmailId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _notificaMessageId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _notificaId;
	private long _userId;
	private String _userUuid;
	private long _entityId;
	private String _entityName;
	private long _queuedEmailId;
	private BaseModel<?> _notificaMessageRemoteModel;
}