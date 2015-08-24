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
 * The base model interface for the Sanction service. Represents a row in the &quot;ndjangui_Sanction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link cmr.fandenatech.ndjangui.model.impl.SanctionImpl}.
 * </p>
 *
 * @author guyw
 * @see Sanction
 * @see cmr.fandenatech.ndjangui.model.impl.SanctionImpl
 * @see cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl
 * @generated
 */
public interface SanctionModel extends BaseModel<Sanction>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a sanction model instance should use the {@link Sanction} interface instead.
	 */

	/**
	 * Returns the primary key of this sanction.
	 *
	 * @return the primary key of this sanction
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this sanction.
	 *
	 * @param primaryKey the primary key of this sanction
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sanction ID of this sanction.
	 *
	 * @return the sanction ID of this sanction
	 */
	public long getSanctionId();

	/**
	 * Sets the sanction ID of this sanction.
	 *
	 * @param sanctionId the sanction ID of this sanction
	 */
	public void setSanctionId(long sanctionId);

	/**
	 * Returns the user ID of this sanction.
	 *
	 * @return the user ID of this sanction
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this sanction.
	 *
	 * @param userId the user ID of this sanction
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this sanction.
	 *
	 * @return the user uuid of this sanction
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this sanction.
	 *
	 * @param userUuid the user uuid of this sanction
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the group ID of this sanction.
	 *
	 * @return the group ID of this sanction
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this sanction.
	 *
	 * @param groupId the group ID of this sanction
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this sanction.
	 *
	 * @return the company ID of this sanction
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this sanction.
	 *
	 * @param companyId the company ID of this sanction
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user name of this sanction.
	 *
	 * @return the user name of this sanction
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this sanction.
	 *
	 * @param userName the user name of this sanction
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this sanction.
	 *
	 * @return the create date of this sanction
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this sanction.
	 *
	 * @param createDate the create date of this sanction
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this sanction.
	 *
	 * @return the modified date of this sanction
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this sanction.
	 *
	 * @param modifiedDate the modified date of this sanction
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the member ID of this sanction.
	 *
	 * @return the member ID of this sanction
	 */
	public long getMemberId();

	/**
	 * Sets the member ID of this sanction.
	 *
	 * @param memberId the member ID of this sanction
	 */
	public void setMemberId(long memberId);

	/**
	 * Returns the budget period ID of this sanction.
	 *
	 * @return the budget period ID of this sanction
	 */
	public long getBudgetPeriodId();

	/**
	 * Sets the budget period ID of this sanction.
	 *
	 * @param budgetPeriodId the budget period ID of this sanction
	 */
	public void setBudgetPeriodId(long budgetPeriodId);

	/**
	 * Returns the name of this sanction.
	 *
	 * @return the name of this sanction
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this sanction.
	 *
	 * @param name the name of this sanction
	 */
	public void setName(String name);

	/**
	 * Returns the short description of this sanction.
	 *
	 * @return the short description of this sanction
	 */
	@AutoEscape
	public String getShortDescription();

	/**
	 * Sets the short description of this sanction.
	 *
	 * @param shortDescription the short description of this sanction
	 */
	public void setShortDescription(String shortDescription);

	/**
	 * Returns the sanction type ID of this sanction.
	 *
	 * @return the sanction type ID of this sanction
	 */
	public long getSanctionTypeId();

	/**
	 * Sets the sanction type ID of this sanction.
	 *
	 * @param sanctionTypeId the sanction type ID of this sanction
	 */
	public void setSanctionTypeId(long sanctionTypeId);

	/**
	 * Returns the sitting ID of this sanction.
	 *
	 * @return the sitting ID of this sanction
	 */
	public long getSittingId();

	/**
	 * Sets the sitting ID of this sanction.
	 *
	 * @param sittingId the sitting ID of this sanction
	 */
	public void setSittingId(long sittingId);

	/**
	 * Returns the amount of this sanction.
	 *
	 * @return the amount of this sanction
	 */
	public double getAmount();

	/**
	 * Sets the amount of this sanction.
	 *
	 * @param amount the amount of this sanction
	 */
	public void setAmount(double amount);

	/**
	 * Returns the status of this sanction.
	 *
	 * @return the status of this sanction
	 */
	public int getStatus();

	/**
	 * Sets the status of this sanction.
	 *
	 * @param status the status of this sanction
	 */
	public void setStatus(int status);

	/**
	 * Returns the src fund class p k of this sanction.
	 *
	 * @return the src fund class p k of this sanction
	 */
	public long getSrcFundClassPK();

	/**
	 * Sets the src fund class p k of this sanction.
	 *
	 * @param srcFundClassPK the src fund class p k of this sanction
	 */
	public void setSrcFundClassPK(long srcFundClassPK);

	/**
	 * Returns the src fund class name of this sanction.
	 *
	 * @return the src fund class name of this sanction
	 */
	@AutoEscape
	public String getSrcFundClassName();

	/**
	 * Sets the src fund class name of this sanction.
	 *
	 * @param srcFundClassName the src fund class name of this sanction
	 */
	public void setSrcFundClassName(String srcFundClassName);

	/**
	 * Returns the dest fund class p k of this sanction.
	 *
	 * @return the dest fund class p k of this sanction
	 */
	public long getDestFundClassPK();

	/**
	 * Sets the dest fund class p k of this sanction.
	 *
	 * @param destFundClassPK the dest fund class p k of this sanction
	 */
	public void setDestFundClassPK(long destFundClassPK);

	/**
	 * Returns the dest fund class name of this sanction.
	 *
	 * @return the dest fund class name of this sanction
	 */
	@AutoEscape
	public String getDestFundClassName();

	/**
	 * Sets the dest fund class name of this sanction.
	 *
	 * @param destFundClassName the dest fund class name of this sanction
	 */
	public void setDestFundClassName(String destFundClassName);

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
	public int compareTo(cmr.fandenatech.ndjangui.model.Sanction sanction);

	@Override
	public int hashCode();

	@Override
	public CacheModel<cmr.fandenatech.ndjangui.model.Sanction> toCacheModel();

	@Override
	public cmr.fandenatech.ndjangui.model.Sanction toEscapedModel();

	@Override
	public cmr.fandenatech.ndjangui.model.Sanction toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}