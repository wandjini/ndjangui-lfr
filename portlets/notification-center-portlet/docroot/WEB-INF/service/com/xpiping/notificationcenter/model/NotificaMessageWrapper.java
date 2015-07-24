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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NotificaMessage}.
 * </p>
 *
 * @author marcoleo
 * @see NotificaMessage
 * @generated
 */
public class NotificaMessageWrapper implements NotificaMessage,
	ModelWrapper<NotificaMessage> {
	public NotificaMessageWrapper(NotificaMessage notificaMessage) {
		_notificaMessage = notificaMessage;
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

	/**
	* Returns the primary key of this notifica message.
	*
	* @return the primary key of this notifica message
	*/
	@Override
	public long getPrimaryKey() {
		return _notificaMessage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this notifica message.
	*
	* @param primaryKey the primary key of this notifica message
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_notificaMessage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the notifica message ID of this notifica message.
	*
	* @return the notifica message ID of this notifica message
	*/
	@Override
	public long getNotificaMessageId() {
		return _notificaMessage.getNotificaMessageId();
	}

	/**
	* Sets the notifica message ID of this notifica message.
	*
	* @param notificaMessageId the notifica message ID of this notifica message
	*/
	@Override
	public void setNotificaMessageId(long notificaMessageId) {
		_notificaMessage.setNotificaMessageId(notificaMessageId);
	}

	/**
	* Returns the company ID of this notifica message.
	*
	* @return the company ID of this notifica message
	*/
	@Override
	public long getCompanyId() {
		return _notificaMessage.getCompanyId();
	}

	/**
	* Sets the company ID of this notifica message.
	*
	* @param companyId the company ID of this notifica message
	*/
	@Override
	public void setCompanyId(long companyId) {
		_notificaMessage.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this notifica message.
	*
	* @return the create date of this notifica message
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _notificaMessage.getCreateDate();
	}

	/**
	* Sets the create date of this notifica message.
	*
	* @param createDate the create date of this notifica message
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_notificaMessage.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this notifica message.
	*
	* @return the modified date of this notifica message
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _notificaMessage.getModifiedDate();
	}

	/**
	* Sets the modified date of this notifica message.
	*
	* @param modifiedDate the modified date of this notifica message
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_notificaMessage.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the notifica ID of this notifica message.
	*
	* @return the notifica ID of this notifica message
	*/
	@Override
	public long getNotificaId() {
		return _notificaMessage.getNotificaId();
	}

	/**
	* Sets the notifica ID of this notifica message.
	*
	* @param notificaId the notifica ID of this notifica message
	*/
	@Override
	public void setNotificaId(long notificaId) {
		_notificaMessage.setNotificaId(notificaId);
	}

	/**
	* Returns the user ID of this notifica message.
	*
	* @return the user ID of this notifica message
	*/
	@Override
	public long getUserId() {
		return _notificaMessage.getUserId();
	}

	/**
	* Sets the user ID of this notifica message.
	*
	* @param userId the user ID of this notifica message
	*/
	@Override
	public void setUserId(long userId) {
		_notificaMessage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this notifica message.
	*
	* @return the user uuid of this notifica message
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessage.getUserUuid();
	}

	/**
	* Sets the user uuid of this notifica message.
	*
	* @param userUuid the user uuid of this notifica message
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_notificaMessage.setUserUuid(userUuid);
	}

	/**
	* Returns the entity ID of this notifica message.
	*
	* @return the entity ID of this notifica message
	*/
	@Override
	public long getEntityId() {
		return _notificaMessage.getEntityId();
	}

	/**
	* Sets the entity ID of this notifica message.
	*
	* @param entityId the entity ID of this notifica message
	*/
	@Override
	public void setEntityId(long entityId) {
		_notificaMessage.setEntityId(entityId);
	}

	/**
	* Returns the entity name of this notifica message.
	*
	* @return the entity name of this notifica message
	*/
	@Override
	public java.lang.String getEntityName() {
		return _notificaMessage.getEntityName();
	}

	/**
	* Sets the entity name of this notifica message.
	*
	* @param entityName the entity name of this notifica message
	*/
	@Override
	public void setEntityName(java.lang.String entityName) {
		_notificaMessage.setEntityName(entityName);
	}

	/**
	* Returns the queued email ID of this notifica message.
	*
	* @return the queued email ID of this notifica message
	*/
	@Override
	public long getQueuedEmailId() {
		return _notificaMessage.getQueuedEmailId();
	}

	/**
	* Sets the queued email ID of this notifica message.
	*
	* @param queuedEmailId the queued email ID of this notifica message
	*/
	@Override
	public void setQueuedEmailId(long queuedEmailId) {
		_notificaMessage.setQueuedEmailId(queuedEmailId);
	}

	@Override
	public boolean isNew() {
		return _notificaMessage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_notificaMessage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _notificaMessage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_notificaMessage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _notificaMessage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _notificaMessage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_notificaMessage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _notificaMessage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_notificaMessage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_notificaMessage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_notificaMessage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NotificaMessageWrapper((NotificaMessage)_notificaMessage.clone());
	}

	@Override
	public int compareTo(
		com.xpiping.notificationcenter.model.NotificaMessage notificaMessage) {
		return _notificaMessage.compareTo(notificaMessage);
	}

	@Override
	public int hashCode() {
		return _notificaMessage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.xpiping.notificationcenter.model.NotificaMessage> toCacheModel() {
		return _notificaMessage.toCacheModel();
	}

	@Override
	public com.xpiping.notificationcenter.model.NotificaMessage toEscapedModel() {
		return new NotificaMessageWrapper(_notificaMessage.toEscapedModel());
	}

	@Override
	public com.xpiping.notificationcenter.model.NotificaMessage toUnescapedModel() {
		return new NotificaMessageWrapper(_notificaMessage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _notificaMessage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _notificaMessage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_notificaMessage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificaMessageWrapper)) {
			return false;
		}

		NotificaMessageWrapper notificaMessageWrapper = (NotificaMessageWrapper)obj;

		if (Validator.equals(_notificaMessage,
					notificaMessageWrapper._notificaMessage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public NotificaMessage getWrappedNotificaMessage() {
		return _notificaMessage;
	}

	@Override
	public NotificaMessage getWrappedModel() {
		return _notificaMessage;
	}

	@Override
	public void resetOriginalValues() {
		_notificaMessage.resetOriginalValues();
	}

	private NotificaMessage _notificaMessage;
}