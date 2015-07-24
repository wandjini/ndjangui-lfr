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
 * This class is a wrapper for {@link NotificaType}.
 * </p>
 *
 * @author marcoleo
 * @see NotificaType
 * @generated
 */
public class NotificaTypeWrapper implements NotificaType,
	ModelWrapper<NotificaType> {
	public NotificaTypeWrapper(NotificaType notificaType) {
		_notificaType = notificaType;
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

	/**
	* Returns the primary key of this notifica type.
	*
	* @return the primary key of this notifica type
	*/
	@Override
	public long getPrimaryKey() {
		return _notificaType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this notifica type.
	*
	* @param primaryKey the primary key of this notifica type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_notificaType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the notifica type ID of this notifica type.
	*
	* @return the notifica type ID of this notifica type
	*/
	@Override
	public long getNotificaTypeId() {
		return _notificaType.getNotificaTypeId();
	}

	/**
	* Sets the notifica type ID of this notifica type.
	*
	* @param notificaTypeId the notifica type ID of this notifica type
	*/
	@Override
	public void setNotificaTypeId(long notificaTypeId) {
		_notificaType.setNotificaTypeId(notificaTypeId);
	}

	/**
	* Returns the company ID of this notifica type.
	*
	* @return the company ID of this notifica type
	*/
	@Override
	public long getCompanyId() {
		return _notificaType.getCompanyId();
	}

	/**
	* Sets the company ID of this notifica type.
	*
	* @param companyId the company ID of this notifica type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_notificaType.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this notifica type.
	*
	* @return the create date of this notifica type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _notificaType.getCreateDate();
	}

	/**
	* Sets the create date of this notifica type.
	*
	* @param createDate the create date of this notifica type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_notificaType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this notifica type.
	*
	* @return the modified date of this notifica type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _notificaType.getModifiedDate();
	}

	/**
	* Sets the modified date of this notifica type.
	*
	* @param modifiedDate the modified date of this notifica type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_notificaType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this notifica type.
	*
	* @return the name of this notifica type
	*/
	@Override
	public java.lang.String getName() {
		return _notificaType.getName();
	}

	/**
	* Sets the name of this notifica type.
	*
	* @param name the name of this notifica type
	*/
	@Override
	public void setName(java.lang.String name) {
		_notificaType.setName(name);
	}

	/**
	* Returns the message destination of this notifica type.
	*
	* @return the message destination of this notifica type
	*/
	@Override
	public java.lang.String getMessageDestination() {
		return _notificaType.getMessageDestination();
	}

	/**
	* Sets the message destination of this notifica type.
	*
	* @param messageDestination the message destination of this notifica type
	*/
	@Override
	public void setMessageDestination(java.lang.String messageDestination) {
		_notificaType.setMessageDestination(messageDestination);
	}

	/**
	* Returns the description of this notifica type.
	*
	* @return the description of this notifica type
	*/
	@Override
	public java.lang.String getDescription() {
		return _notificaType.getDescription();
	}

	/**
	* Sets the description of this notifica type.
	*
	* @param description the description of this notifica type
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_notificaType.setDescription(description);
	}

	/**
	* Returns the place holders of this notifica type.
	*
	* @return the place holders of this notifica type
	*/
	@Override
	public java.lang.String getPlaceHolders() {
		return _notificaType.getPlaceHolders();
	}

	/**
	* Sets the place holders of this notifica type.
	*
	* @param placeHolders the place holders of this notifica type
	*/
	@Override
	public void setPlaceHolders(java.lang.String placeHolders) {
		_notificaType.setPlaceHolders(placeHolders);
	}

	/**
	* Returns the aviable of this notifica type.
	*
	* @return the aviable of this notifica type
	*/
	@Override
	public java.lang.Boolean getAviable() {
		return _notificaType.getAviable();
	}

	/**
	* Sets the aviable of this notifica type.
	*
	* @param aviable the aviable of this notifica type
	*/
	@Override
	public void setAviable(java.lang.Boolean aviable) {
		_notificaType.setAviable(aviable);
	}

	@Override
	public boolean isNew() {
		return _notificaType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_notificaType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _notificaType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_notificaType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _notificaType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _notificaType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_notificaType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _notificaType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_notificaType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_notificaType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_notificaType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NotificaTypeWrapper((NotificaType)_notificaType.clone());
	}

	@Override
	public int compareTo(
		com.xpiping.notificationcenter.model.NotificaType notificaType) {
		return _notificaType.compareTo(notificaType);
	}

	@Override
	public int hashCode() {
		return _notificaType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.xpiping.notificationcenter.model.NotificaType> toCacheModel() {
		return _notificaType.toCacheModel();
	}

	@Override
	public com.xpiping.notificationcenter.model.NotificaType toEscapedModel() {
		return new NotificaTypeWrapper(_notificaType.toEscapedModel());
	}

	@Override
	public com.xpiping.notificationcenter.model.NotificaType toUnescapedModel() {
		return new NotificaTypeWrapper(_notificaType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _notificaType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _notificaType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_notificaType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificaTypeWrapper)) {
			return false;
		}

		NotificaTypeWrapper notificaTypeWrapper = (NotificaTypeWrapper)obj;

		if (Validator.equals(_notificaType, notificaTypeWrapper._notificaType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public NotificaType getWrappedNotificaType() {
		return _notificaType;
	}

	@Override
	public NotificaType getWrappedModel() {
		return _notificaType;
	}

	@Override
	public void resetOriginalValues() {
		_notificaType.resetOriginalValues();
	}

	private NotificaType _notificaType;
}