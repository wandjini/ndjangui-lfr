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
 * The base model interface for the Member service. Represents a row in the &quot;ndjangui_Member&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link cmr.fandenatech.ndjangui.model.impl.MemberModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link cmr.fandenatech.ndjangui.model.impl.MemberImpl}.
 * </p>
 *
 * @author guyw
 * @see Member
 * @see cmr.fandenatech.ndjangui.model.impl.MemberImpl
 * @see cmr.fandenatech.ndjangui.model.impl.MemberModelImpl
 * @generated
 */
public interface MemberModel extends BaseModel<Member>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a member model instance should use the {@link Member} interface instead.
	 */

	/**
	 * Returns the primary key of this member.
	 *
	 * @return the primary key of this member
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this member.
	 *
	 * @param primaryKey the primary key of this member
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the member ID of this member.
	 *
	 * @return the member ID of this member
	 */
	public long getMemberId();

	/**
	 * Sets the member ID of this member.
	 *
	 * @param memberId the member ID of this member
	 */
	public void setMemberId(long memberId);

	/**
	 * Returns the user ID of this member.
	 *
	 * @return the user ID of this member
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this member.
	 *
	 * @param userId the user ID of this member
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this member.
	 *
	 * @return the user uuid of this member
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this member.
	 *
	 * @param userUuid the user uuid of this member
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the group ID of this member.
	 *
	 * @return the group ID of this member
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this member.
	 *
	 * @param groupId the group ID of this member
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this member.
	 *
	 * @return the company ID of this member
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this member.
	 *
	 * @param companyId the company ID of this member
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user name of this member.
	 *
	 * @return the user name of this member
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this member.
	 *
	 * @param userName the user name of this member
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this member.
	 *
	 * @return the create date of this member
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this member.
	 *
	 * @param createDate the create date of this member
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this member.
	 *
	 * @return the modified date of this member
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this member.
	 *
	 * @param modifiedDate the modified date of this member
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this member.
	 *
	 * @return the name of this member
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this member.
	 *
	 * @param name the name of this member
	 */
	public void setName(String name);

	/**
	 * Returns the surname of this member.
	 *
	 * @return the surname of this member
	 */
	@AutoEscape
	public String getSurname();

	/**
	 * Sets the surname of this member.
	 *
	 * @param surname the surname of this member
	 */
	public void setSurname(String surname);

	/**
	 * Returns the fullname of this member.
	 *
	 * @return the fullname of this member
	 */
	@AutoEscape
	public String getFullname();

	/**
	 * Sets the fullname of this member.
	 *
	 * @param fullname the fullname of this member
	 */
	public void setFullname(String fullname);

	/**
	 * Returns the email of this member.
	 *
	 * @return the email of this member
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this member.
	 *
	 * @param email the email of this member
	 */
	public void setEmail(String email);

	/**
	 * Returns the card number of this member.
	 *
	 * @return the card number of this member
	 */
	@AutoEscape
	public String getCardNumber();

	/**
	 * Sets the card number of this member.
	 *
	 * @param cardNumber the card number of this member
	 */
	public void setCardNumber(String cardNumber);

	/**
	 * Returns the phone number of this member.
	 *
	 * @return the phone number of this member
	 */
	@AutoEscape
	public String getPhoneNumber();

	/**
	 * Sets the phone number of this member.
	 *
	 * @param phoneNumber the phone number of this member
	 */
	public void setPhoneNumber(String phoneNumber);

	/**
	 * Returns the rate of this member.
	 *
	 * @return the rate of this member
	 */
	public double getRate();

	/**
	 * Sets the rate of this member.
	 *
	 * @param rate the rate of this member
	 */
	public void setRate(double rate);

	/**
	 * Returns the status of this member.
	 *
	 * @return the status of this member
	 */
	public int getStatus();

	/**
	 * Sets the status of this member.
	 *
	 * @param status the status of this member
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
	public int compareTo(cmr.fandenatech.ndjangui.model.Member member);

	@Override
	public int hashCode();

	@Override
	public CacheModel<cmr.fandenatech.ndjangui.model.Member> toCacheModel();

	@Override
	public cmr.fandenatech.ndjangui.model.Member toEscapedModel();

	@Override
	public cmr.fandenatech.ndjangui.model.Member toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}