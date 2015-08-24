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
 * The base model interface for the FundType service. Represents a row in the &quot;ndjangui_FundType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link cmr.fandenatech.ndjangui.model.impl.FundTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link cmr.fandenatech.ndjangui.model.impl.FundTypeImpl}.
 * </p>
 *
 * @author guyw
 * @see FundType
 * @see cmr.fandenatech.ndjangui.model.impl.FundTypeImpl
 * @see cmr.fandenatech.ndjangui.model.impl.FundTypeModelImpl
 * @generated
 */
public interface FundTypeModel extends BaseModel<FundType>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fund type model instance should use the {@link FundType} interface instead.
	 */

	/**
	 * Returns the primary key of this fund type.
	 *
	 * @return the primary key of this fund type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fund type.
	 *
	 * @param primaryKey the primary key of this fund type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the fund type ID of this fund type.
	 *
	 * @return the fund type ID of this fund type
	 */
	public long getFundTypeId();

	/**
	 * Sets the fund type ID of this fund type.
	 *
	 * @param fundTypeId the fund type ID of this fund type
	 */
	public void setFundTypeId(long fundTypeId);

	/**
	 * Returns the user ID of this fund type.
	 *
	 * @return the user ID of this fund type
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this fund type.
	 *
	 * @param userId the user ID of this fund type
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this fund type.
	 *
	 * @return the user uuid of this fund type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this fund type.
	 *
	 * @param userUuid the user uuid of this fund type
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the group ID of this fund type.
	 *
	 * @return the group ID of this fund type
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this fund type.
	 *
	 * @param groupId the group ID of this fund type
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this fund type.
	 *
	 * @return the company ID of this fund type
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this fund type.
	 *
	 * @param companyId the company ID of this fund type
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user name of this fund type.
	 *
	 * @return the user name of this fund type
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this fund type.
	 *
	 * @param userName the user name of this fund type
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this fund type.
	 *
	 * @return the create date of this fund type
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this fund type.
	 *
	 * @param createDate the create date of this fund type
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this fund type.
	 *
	 * @return the modified date of this fund type
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this fund type.
	 *
	 * @param modifiedDate the modified date of this fund type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this fund type.
	 *
	 * @return the name of this fund type
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this fund type.
	 *
	 * @param name the name of this fund type
	 */
	public void setName(String name);

	/**
	 * Returns the short description of this fund type.
	 *
	 * @return the short description of this fund type
	 */
	@AutoEscape
	public String getShortDescription();

	/**
	 * Sets the short description of this fund type.
	 *
	 * @param shortDescription the short description of this fund type
	 */
	public void setShortDescription(String shortDescription);

	/**
	 * Returns the status of this fund type.
	 *
	 * @return the status of this fund type
	 */
	public int getStatus();

	/**
	 * Sets the status of this fund type.
	 *
	 * @param status the status of this fund type
	 */
	public void setStatus(int status);

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
	public int compareTo(cmr.fandenatech.ndjangui.model.FundType fundType);

	@Override
	public int hashCode();

	@Override
	public CacheModel<cmr.fandenatech.ndjangui.model.FundType> toCacheModel();

	@Override
	public cmr.fandenatech.ndjangui.model.FundType toEscapedModel();

	@Override
	public cmr.fandenatech.ndjangui.model.FundType toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}