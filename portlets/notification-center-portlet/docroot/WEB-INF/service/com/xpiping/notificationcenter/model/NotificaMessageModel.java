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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the NotificaMessage service. Represents a row in the &quot;xpiping_notificationcenter_NotificaMessage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageImpl}.
 * </p>
 *
 * @author marcoleo
 * @see NotificaMessage
 * @see com.ndjangui.notificationcenter.model.impl.NotificaMessageImpl
 * @see com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl
 * @generated
 */
public interface NotificaMessageModel extends BaseModel<NotificaMessage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a notifica message model instance should use the {@link NotificaMessage} interface instead.
	 */

	/**
	 * Returns the primary key of this notifica message.
	 *
	 * @return the primary key of this notifica message
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this notifica message.
	 *
	 * @param primaryKey the primary key of this notifica message
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the notifica message ID of this notifica message.
	 *
	 * @return the notifica message ID of this notifica message
	 */
	public long getNotificaMessageId();

	/**
	 * Sets the notifica message ID of this notifica message.
	 *
	 * @param notificaMessageId the notifica message ID of this notifica message
	 */
	public void setNotificaMessageId(long notificaMessageId);

	/**
	 * Returns the company ID of this notifica message.
	 *
	 * @return the company ID of this notifica message
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this notifica message.
	 *
	 * @param companyId the company ID of this notifica message
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this notifica message.
	 *
	 * @return the create date of this notifica message
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this notifica message.
	 *
	 * @param createDate the create date of this notifica message
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this notifica message.
	 *
	 * @return the modified date of this notifica message
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this notifica message.
	 *
	 * @param modifiedDate the modified date of this notifica message
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the notifica ID of this notifica message.
	 *
	 * @return the notifica ID of this notifica message
	 */
	public long getNotificaId();

	/**
	 * Sets the notifica ID of this notifica message.
	 *
	 * @param notificaId the notifica ID of this notifica message
	 */
	public void setNotificaId(long notificaId);

	/**
	 * Returns the user ID of this notifica message.
	 *
	 * @return the user ID of this notifica message
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this notifica message.
	 *
	 * @param userId the user ID of this notifica message
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this notifica message.
	 *
	 * @return the user uuid of this notifica message
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this notifica message.
	 *
	 * @param userUuid the user uuid of this notifica message
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the entity ID of this notifica message.
	 *
	 * @return the entity ID of this notifica message
	 */
	public long getEntityId();

	/**
	 * Sets the entity ID of this notifica message.
	 *
	 * @param entityId the entity ID of this notifica message
	 */
	public void setEntityId(long entityId);

	/**
	 * Returns the entity name of this notifica message.
	 *
	 * @return the entity name of this notifica message
	 */
	@AutoEscape
	public String getEntityName();

	/**
	 * Sets the entity name of this notifica message.
	 *
	 * @param entityName the entity name of this notifica message
	 */
	public void setEntityName(String entityName);

	/**
	 * Returns the queued email ID of this notifica message.
	 *
	 * @return the queued email ID of this notifica message
	 */
	public long getQueuedEmailId();

	/**
	 * Sets the queued email ID of this notifica message.
	 *
	 * @param queuedEmailId the queued email ID of this notifica message
	 */
	public void setQueuedEmailId(long queuedEmailId);

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
	public int compareTo(NotificaMessage notificaMessage);

	@Override
	public int hashCode();

	@Override
	public CacheModel<NotificaMessage> toCacheModel();

	@Override
	public NotificaMessage toEscapedModel();

	@Override
	public NotificaMessage toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}