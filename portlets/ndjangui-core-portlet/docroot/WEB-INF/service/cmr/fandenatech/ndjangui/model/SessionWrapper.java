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
 * This class is a wrapper for {@link Session}.
 * </p>
 *
 * @author guyw
 * @see Session
 * @generated
 */
public class SessionWrapper implements Session, ModelWrapper<Session> {
	public SessionWrapper(Session session) {
		_session = session;
	}

	@Override
	public Class<?> getModelClass() {
		return Session.class;
	}

	@Override
	public String getModelClassName() {
		return Session.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sessionId", getSessionId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("budgetPeriodId", getBudgetPeriodId());
		attributes.put("name", getName());
		attributes.put("notes", getNotes());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sessionId = (Long)attributes.get("sessionId");

		if (sessionId != null) {
			setSessionId(sessionId);
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

		Long budgetPeriodId = (Long)attributes.get("budgetPeriodId");

		if (budgetPeriodId != null) {
			setBudgetPeriodId(budgetPeriodId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
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
	* Returns the primary key of this session.
	*
	* @return the primary key of this session
	*/
	@Override
	public long getPrimaryKey() {
		return _session.getPrimaryKey();
	}

	/**
	* Sets the primary key of this session.
	*
	* @param primaryKey the primary key of this session
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_session.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the session ID of this session.
	*
	* @return the session ID of this session
	*/
	@Override
	public long getSessionId() {
		return _session.getSessionId();
	}

	/**
	* Sets the session ID of this session.
	*
	* @param sessionId the session ID of this session
	*/
	@Override
	public void setSessionId(long sessionId) {
		_session.setSessionId(sessionId);
	}

	/**
	* Returns the user ID of this session.
	*
	* @return the user ID of this session
	*/
	@Override
	public long getUserId() {
		return _session.getUserId();
	}

	/**
	* Sets the user ID of this session.
	*
	* @param userId the user ID of this session
	*/
	@Override
	public void setUserId(long userId) {
		_session.setUserId(userId);
	}

	/**
	* Returns the user uuid of this session.
	*
	* @return the user uuid of this session
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _session.getUserUuid();
	}

	/**
	* Sets the user uuid of this session.
	*
	* @param userUuid the user uuid of this session
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_session.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this session.
	*
	* @return the group ID of this session
	*/
	@Override
	public long getGroupId() {
		return _session.getGroupId();
	}

	/**
	* Sets the group ID of this session.
	*
	* @param groupId the group ID of this session
	*/
	@Override
	public void setGroupId(long groupId) {
		_session.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this session.
	*
	* @return the company ID of this session
	*/
	@Override
	public long getCompanyId() {
		return _session.getCompanyId();
	}

	/**
	* Sets the company ID of this session.
	*
	* @param companyId the company ID of this session
	*/
	@Override
	public void setCompanyId(long companyId) {
		_session.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this session.
	*
	* @return the user name of this session
	*/
	@Override
	public java.lang.String getUserName() {
		return _session.getUserName();
	}

	/**
	* Sets the user name of this session.
	*
	* @param userName the user name of this session
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_session.setUserName(userName);
	}

	/**
	* Returns the create date of this session.
	*
	* @return the create date of this session
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _session.getCreateDate();
	}

	/**
	* Sets the create date of this session.
	*
	* @param createDate the create date of this session
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_session.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this session.
	*
	* @return the modified date of this session
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _session.getModifiedDate();
	}

	/**
	* Sets the modified date of this session.
	*
	* @param modifiedDate the modified date of this session
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_session.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the budget period ID of this session.
	*
	* @return the budget period ID of this session
	*/
	@Override
	public long getBudgetPeriodId() {
		return _session.getBudgetPeriodId();
	}

	/**
	* Sets the budget period ID of this session.
	*
	* @param budgetPeriodId the budget period ID of this session
	*/
	@Override
	public void setBudgetPeriodId(long budgetPeriodId) {
		_session.setBudgetPeriodId(budgetPeriodId);
	}

	/**
	* Returns the name of this session.
	*
	* @return the name of this session
	*/
	@Override
	public java.lang.String getName() {
		return _session.getName();
	}

	/**
	* Sets the name of this session.
	*
	* @param name the name of this session
	*/
	@Override
	public void setName(java.lang.String name) {
		_session.setName(name);
	}

	/**
	* Returns the notes of this session.
	*
	* @return the notes of this session
	*/
	@Override
	public java.lang.String getNotes() {
		return _session.getNotes();
	}

	/**
	* Sets the notes of this session.
	*
	* @param notes the notes of this session
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_session.setNotes(notes);
	}

	/**
	* Returns the status of this session.
	*
	* @return the status of this session
	*/
	@Override
	public int getStatus() {
		return _session.getStatus();
	}

	/**
	* Sets the status of this session.
	*
	* @param status the status of this session
	*/
	@Override
	public void setStatus(int status) {
		_session.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _session.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_session.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _session.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_session.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _session.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _session.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_session.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _session.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_session.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_session.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_session.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SessionWrapper((Session)_session.clone());
	}

	@Override
	public int compareTo(cmr.fandenatech.ndjangui.model.Session session) {
		return _session.compareTo(session);
	}

	@Override
	public int hashCode() {
		return _session.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<cmr.fandenatech.ndjangui.model.Session> toCacheModel() {
		return _session.toCacheModel();
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Session toEscapedModel() {
		return new SessionWrapper(_session.toEscapedModel());
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Session toUnescapedModel() {
		return new SessionWrapper(_session.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _session.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _session.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_session.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SessionWrapper)) {
			return false;
		}

		SessionWrapper sessionWrapper = (SessionWrapper)obj;

		if (Validator.equals(_session, sessionWrapper._session)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Session getWrappedSession() {
		return _session;
	}

	@Override
	public Session getWrappedModel() {
		return _session;
	}

	@Override
	public void resetOriginalValues() {
		_session.resetOriginalValues();
	}

	private Session _session;
}