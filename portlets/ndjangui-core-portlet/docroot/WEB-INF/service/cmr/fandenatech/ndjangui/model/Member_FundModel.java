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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Member_Fund service. Represents a row in the &quot;ndjangui_Member_Fund&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link cmr.fandenatech.ndjangui.model.impl.Member_FundModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link cmr.fandenatech.ndjangui.model.impl.Member_FundImpl}.
 * </p>
 *
 * @author guyw
 * @see Member_Fund
 * @see cmr.fandenatech.ndjangui.model.impl.Member_FundImpl
 * @see cmr.fandenatech.ndjangui.model.impl.Member_FundModelImpl
 * @generated
 */
public interface Member_FundModel extends BaseModel<Member_Fund> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a member_ fund model instance should use the {@link Member_Fund} interface instead.
	 */

	/**
	 * Returns the primary key of this member_ fund.
	 *
	 * @return the primary key of this member_ fund
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this member_ fund.
	 *
	 * @param primaryKey the primary key of this member_ fund
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the member fund ID of this member_ fund.
	 *
	 * @return the member fund ID of this member_ fund
	 */
	public long getMemberFundId();

	/**
	 * Sets the member fund ID of this member_ fund.
	 *
	 * @param memberFundId the member fund ID of this member_ fund
	 */
	public void setMemberFundId(long memberFundId);

	/**
	 * Returns the create date of this member_ fund.
	 *
	 * @return the create date of this member_ fund
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this member_ fund.
	 *
	 * @param createDate the create date of this member_ fund
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this member_ fund.
	 *
	 * @return the modified date of this member_ fund
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this member_ fund.
	 *
	 * @param modifiedDate the modified date of this member_ fund
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the member ID of this member_ fund.
	 *
	 * @return the member ID of this member_ fund
	 */
	public long getMemberId();

	/**
	 * Sets the member ID of this member_ fund.
	 *
	 * @param memberId the member ID of this member_ fund
	 */
	public void setMemberId(long memberId);

	/**
	 * Returns the fund ID of this member_ fund.
	 *
	 * @return the fund ID of this member_ fund
	 */
	public long getFundId();

	/**
	 * Sets the fund ID of this member_ fund.
	 *
	 * @param fundId the fund ID of this member_ fund
	 */
	public void setFundId(long fundId);

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
	public int compareTo(cmr.fandenatech.ndjangui.model.Member_Fund member_Fund);

	@Override
	public int hashCode();

	@Override
	public CacheModel<cmr.fandenatech.ndjangui.model.Member_Fund> toCacheModel();

	@Override
	public cmr.fandenatech.ndjangui.model.Member_Fund toEscapedModel();

	@Override
	public cmr.fandenatech.ndjangui.model.Member_Fund toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}