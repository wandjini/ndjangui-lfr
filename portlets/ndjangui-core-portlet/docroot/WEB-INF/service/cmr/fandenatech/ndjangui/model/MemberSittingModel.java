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
 * The base model interface for the MemberSitting service. Represents a row in the &quot;ndjangui_MemberSitting&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingImpl}.
 * </p>
 *
 * @author guyw
 * @see MemberSitting
 * @see cmr.fandenatech.ndjangui.model.impl.MemberSittingImpl
 * @see cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl
 * @generated
 */
public interface MemberSittingModel extends BaseModel<MemberSitting>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a member sitting model instance should use the {@link MemberSitting} interface instead.
	 */

	/**
	 * Returns the primary key of this member sitting.
	 *
	 * @return the primary key of this member sitting
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this member sitting.
	 *
	 * @param primaryKey the primary key of this member sitting
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the member sitting ID of this member sitting.
	 *
	 * @return the member sitting ID of this member sitting
	 */
	public long getMemberSittingId();

	/**
	 * Sets the member sitting ID of this member sitting.
	 *
	 * @param memberSittingId the member sitting ID of this member sitting
	 */
	public void setMemberSittingId(long memberSittingId);

	/**
	 * Returns the user ID of this member sitting.
	 *
	 * @return the user ID of this member sitting
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this member sitting.
	 *
	 * @param userId the user ID of this member sitting
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this member sitting.
	 *
	 * @return the user uuid of this member sitting
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this member sitting.
	 *
	 * @param userUuid the user uuid of this member sitting
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the group ID of this member sitting.
	 *
	 * @return the group ID of this member sitting
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this member sitting.
	 *
	 * @param groupId the group ID of this member sitting
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this member sitting.
	 *
	 * @return the company ID of this member sitting
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this member sitting.
	 *
	 * @param companyId the company ID of this member sitting
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user name of this member sitting.
	 *
	 * @return the user name of this member sitting
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this member sitting.
	 *
	 * @param userName the user name of this member sitting
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this member sitting.
	 *
	 * @return the create date of this member sitting
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this member sitting.
	 *
	 * @param createDate the create date of this member sitting
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this member sitting.
	 *
	 * @return the modified date of this member sitting
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this member sitting.
	 *
	 * @param modifiedDate the modified date of this member sitting
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the member ID of this member sitting.
	 *
	 * @return the member ID of this member sitting
	 */
	public long getMemberId();

	/**
	 * Sets the member ID of this member sitting.
	 *
	 * @param memberId the member ID of this member sitting
	 */
	public void setMemberId(long memberId);

	/**
	 * Returns the sitting ID of this member sitting.
	 *
	 * @return the sitting ID of this member sitting
	 */
	public long getSittingId();

	/**
	 * Sets the sitting ID of this member sitting.
	 *
	 * @param sittingId the sitting ID of this member sitting
	 */
	public void setSittingId(long sittingId);

	/**
	 * Returns the member name of this member sitting.
	 *
	 * @return the member name of this member sitting
	 */
	@AutoEscape
	public String getMemberName();

	/**
	 * Sets the member name of this member sitting.
	 *
	 * @param memberName the member name of this member sitting
	 */
	public void setMemberName(String memberName);

	/**
	 * Returns the sitting name of this member sitting.
	 *
	 * @return the sitting name of this member sitting
	 */
	@AutoEscape
	public String getSittingName();

	/**
	 * Sets the sitting name of this member sitting.
	 *
	 * @param sittingName the sitting name of this member sitting
	 */
	public void setSittingName(String sittingName);

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
	public int compareTo(
		cmr.fandenatech.ndjangui.model.MemberSitting memberSitting);

	@Override
	public int hashCode();

	@Override
	public CacheModel<cmr.fandenatech.ndjangui.model.MemberSitting> toCacheModel();

	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting toEscapedModel();

	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}