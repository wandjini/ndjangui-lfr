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
 * This class is a wrapper for {@link Notifica}.
 * </p>
 *
 * @author marcoleo
 * @see Notifica
 * @generated
 */
public class NotificaWrapper implements Notifica, ModelWrapper<Notifica> {
	public NotificaWrapper(Notifica notifica) {
		_notifica = notifica;
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

	/**
	* Returns the primary key of this notifica.
	*
	* @return the primary key of this notifica
	*/
	@Override
	public long getPrimaryKey() {
		return _notifica.getPrimaryKey();
	}

	/**
	* Sets the primary key of this notifica.
	*
	* @param primaryKey the primary key of this notifica
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_notifica.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the notifica ID of this notifica.
	*
	* @return the notifica ID of this notifica
	*/
	@Override
	public long getNotificaId() {
		return _notifica.getNotificaId();
	}

	/**
	* Sets the notifica ID of this notifica.
	*
	* @param notificaId the notifica ID of this notifica
	*/
	@Override
	public void setNotificaId(long notificaId) {
		_notifica.setNotificaId(notificaId);
	}

	/**
	* Returns the company ID of this notifica.
	*
	* @return the company ID of this notifica
	*/
	@Override
	public long getCompanyId() {
		return _notifica.getCompanyId();
	}

	/**
	* Sets the company ID of this notifica.
	*
	* @param companyId the company ID of this notifica
	*/
	@Override
	public void setCompanyId(long companyId) {
		_notifica.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this notifica.
	*
	* @return the user ID of this notifica
	*/
	@Override
	public long getUserId() {
		return _notifica.getUserId();
	}

	/**
	* Sets the user ID of this notifica.
	*
	* @param userId the user ID of this notifica
	*/
	@Override
	public void setUserId(long userId) {
		_notifica.setUserId(userId);
	}

	/**
	* Returns the user uuid of this notifica.
	*
	* @return the user uuid of this notifica
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notifica.getUserUuid();
	}

	/**
	* Sets the user uuid of this notifica.
	*
	* @param userUuid the user uuid of this notifica
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_notifica.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this notifica.
	*
	* @return the user name of this notifica
	*/
	@Override
	public java.lang.String getUserName() {
		return _notifica.getUserName();
	}

	/**
	* Sets the user name of this notifica.
	*
	* @param userName the user name of this notifica
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_notifica.setUserName(userName);
	}

	/**
	* Returns the create date of this notifica.
	*
	* @return the create date of this notifica
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _notifica.getCreateDate();
	}

	/**
	* Sets the create date of this notifica.
	*
	* @param createDate the create date of this notifica
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_notifica.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this notifica.
	*
	* @return the modified date of this notifica
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _notifica.getModifiedDate();
	}

	/**
	* Sets the modified date of this notifica.
	*
	* @param modifiedDate the modified date of this notifica
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_notifica.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the notifica type ID of this notifica.
	*
	* @return the notifica type ID of this notifica
	*/
	@Override
	public long getNotificaTypeId() {
		return _notifica.getNotificaTypeId();
	}

	/**
	* Sets the notifica type ID of this notifica.
	*
	* @param notificaTypeId the notifica type ID of this notifica
	*/
	@Override
	public void setNotificaTypeId(long notificaTypeId) {
		_notifica.setNotificaTypeId(notificaTypeId);
	}

	/**
	* Returns the name of this notifica.
	*
	* @return the name of this notifica
	*/
	@Override
	public java.lang.String getName() {
		return _notifica.getName();
	}

	/**
	* Sets the name of this notifica.
	*
	* @param name the name of this notifica
	*/
	@Override
	public void setName(java.lang.String name) {
		_notifica.setName(name);
	}

	/**
	* Returns the text of this notifica.
	*
	* @return the text of this notifica
	*/
	@Override
	public java.lang.String getText() {
		return _notifica.getText();
	}

	/**
	* Sets the text of this notifica.
	*
	* @param text the text of this notifica
	*/
	@Override
	public void setText(java.lang.String text) {
		_notifica.setText(text);
	}

	/**
	* Returns the subject of this notifica.
	*
	* @return the subject of this notifica
	*/
	@Override
	public java.lang.String getSubject() {
		return _notifica.getSubject();
	}

	/**
	* Sets the subject of this notifica.
	*
	* @param subject the subject of this notifica
	*/
	@Override
	public void setSubject(java.lang.String subject) {
		_notifica.setSubject(subject);
	}

	/**
	* Returns the description of this notifica.
	*
	* @return the description of this notifica
	*/
	@Override
	public java.lang.String getDescription() {
		return _notifica.getDescription();
	}

	/**
	* Sets the description of this notifica.
	*
	* @param description the description of this notifica
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_notifica.setDescription(description);
	}

	/**
	* Returns the aviable of this notifica.
	*
	* @return the aviable of this notifica
	*/
	@Override
	public java.lang.Boolean getAviable() {
		return _notifica.getAviable();
	}

	/**
	* Sets the aviable of this notifica.
	*
	* @param aviable the aviable of this notifica
	*/
	@Override
	public void setAviable(java.lang.Boolean aviable) {
		_notifica.setAviable(aviable);
	}

	/**
	* Returns the ignore intersaction of this notifica.
	*
	* @return the ignore intersaction of this notifica
	*/
	@Override
	public java.lang.Boolean getIgnoreIntersaction() {
		return _notifica.getIgnoreIntersaction();
	}

	/**
	* Sets the ignore intersaction of this notifica.
	*
	* @param ignoreIntersaction the ignore intersaction of this notifica
	*/
	@Override
	public void setIgnoreIntersaction(java.lang.Boolean ignoreIntersaction) {
		_notifica.setIgnoreIntersaction(ignoreIntersaction);
	}

	/**
	* Returns the orgs IDs of this notifica.
	*
	* @return the orgs IDs of this notifica
	*/
	@Override
	public java.lang.String getOrgsIds() {
		return _notifica.getOrgsIds();
	}

	/**
	* Sets the orgs IDs of this notifica.
	*
	* @param orgsIds the orgs IDs of this notifica
	*/
	@Override
	public void setOrgsIds(java.lang.String orgsIds) {
		_notifica.setOrgsIds(orgsIds);
	}

	/**
	* Returns the groups IDs of this notifica.
	*
	* @return the groups IDs of this notifica
	*/
	@Override
	public java.lang.String getGroupsIds() {
		return _notifica.getGroupsIds();
	}

	/**
	* Sets the groups IDs of this notifica.
	*
	* @param groupsIds the groups IDs of this notifica
	*/
	@Override
	public void setGroupsIds(java.lang.String groupsIds) {
		_notifica.setGroupsIds(groupsIds);
	}

	/**
	* Returns the roles IDs of this notifica.
	*
	* @return the roles IDs of this notifica
	*/
	@Override
	public java.lang.String getRolesIds() {
		return _notifica.getRolesIds();
	}

	/**
	* Sets the roles IDs of this notifica.
	*
	* @param rolesIds the roles IDs of this notifica
	*/
	@Override
	public void setRolesIds(java.lang.String rolesIds) {
		_notifica.setRolesIds(rolesIds);
	}

	/**
	* Returns the last check date of this notifica.
	*
	* @return the last check date of this notifica
	*/
	@Override
	public java.util.Date getLastCheckDate() {
		return _notifica.getLastCheckDate();
	}

	/**
	* Sets the last check date of this notifica.
	*
	* @param lastCheckDate the last check date of this notifica
	*/
	@Override
	public void setLastCheckDate(java.util.Date lastCheckDate) {
		_notifica.setLastCheckDate(lastCheckDate);
	}

	/**
	* Returns the deleted of this notifica.
	*
	* @return the deleted of this notifica
	*/
	@Override
	public java.lang.Boolean getDeleted() {
		return _notifica.getDeleted();
	}

	/**
	* Sets the deleted of this notifica.
	*
	* @param deleted the deleted of this notifica
	*/
	@Override
	public void setDeleted(java.lang.Boolean deleted) {
		_notifica.setDeleted(deleted);
	}

	@Override
	public boolean isNew() {
		return _notifica.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_notifica.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _notifica.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_notifica.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _notifica.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _notifica.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_notifica.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _notifica.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_notifica.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_notifica.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_notifica.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NotificaWrapper((Notifica)_notifica.clone());
	}

	@Override
	public int compareTo(com.xpiping.notificationcenter.model.Notifica notifica) {
		return _notifica.compareTo(notifica);
	}

	@Override
	public int hashCode() {
		return _notifica.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.xpiping.notificationcenter.model.Notifica> toCacheModel() {
		return _notifica.toCacheModel();
	}

	@Override
	public com.xpiping.notificationcenter.model.Notifica toEscapedModel() {
		return new NotificaWrapper(_notifica.toEscapedModel());
	}

	@Override
	public com.xpiping.notificationcenter.model.Notifica toUnescapedModel() {
		return new NotificaWrapper(_notifica.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _notifica.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _notifica.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_notifica.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificaWrapper)) {
			return false;
		}

		NotificaWrapper notificaWrapper = (NotificaWrapper)obj;

		if (Validator.equals(_notifica, notificaWrapper._notifica)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Notifica getWrappedNotifica() {
		return _notifica;
	}

	@Override
	public Notifica getWrappedModel() {
		return _notifica;
	}

	@Override
	public void resetOriginalValues() {
		_notifica.resetOriginalValues();
	}

	private Notifica _notifica;
}