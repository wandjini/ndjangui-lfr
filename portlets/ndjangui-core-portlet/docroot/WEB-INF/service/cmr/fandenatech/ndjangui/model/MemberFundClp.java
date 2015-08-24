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

import cmr.fandenatech.ndjangui.service.ClpSerializer;
import cmr.fandenatech.ndjangui.service.MemberFundLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guyw
 */
public class MemberFundClp extends BaseModelImpl<MemberFund>
	implements MemberFund {
	public MemberFundClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MemberFund.class;
	}

	@Override
	public String getModelClassName() {
		return MemberFund.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _memberFundId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMemberFundId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _memberFundId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("memberFundId", getMemberFundId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("memberId", getMemberId());
		attributes.put("fundId", getFundId());
		attributes.put("memberName", getMemberName());
		attributes.put("fundName", getFundName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long memberFundId = (Long)attributes.get("memberFundId");

		if (memberFundId != null) {
			setMemberFundId(memberFundId);
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

		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		Long fundId = (Long)attributes.get("fundId");

		if (fundId != null) {
			setFundId(fundId);
		}

		String memberName = (String)attributes.get("memberName");

		if (memberName != null) {
			setMemberName(memberName);
		}

		String fundName = (String)attributes.get("fundName");

		if (fundName != null) {
			setFundName(fundName);
		}
	}

	@Override
	public long getMemberFundId() {
		return _memberFundId;
	}

	@Override
	public void setMemberFundId(long memberFundId) {
		_memberFundId = memberFundId;

		if (_memberFundRemoteModel != null) {
			try {
				Class<?> clazz = _memberFundRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberFundId", long.class);

				method.invoke(_memberFundRemoteModel, memberFundId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_memberFundRemoteModel != null) {
			try {
				Class<?> clazz = _memberFundRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_memberFundRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_memberFundRemoteModel != null) {
			try {
				Class<?> clazz = _memberFundRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_memberFundRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_memberFundRemoteModel != null) {
			try {
				Class<?> clazz = _memberFundRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_memberFundRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_memberFundRemoteModel != null) {
			try {
				Class<?> clazz = _memberFundRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_memberFundRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_memberFundRemoteModel != null) {
			try {
				Class<?> clazz = _memberFundRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_memberFundRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_memberFundRemoteModel != null) {
			try {
				Class<?> clazz = _memberFundRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_memberFundRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMemberId() {
		return _memberId;
	}

	@Override
	public void setMemberId(long memberId) {
		_memberId = memberId;

		if (_memberFundRemoteModel != null) {
			try {
				Class<?> clazz = _memberFundRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberId", long.class);

				method.invoke(_memberFundRemoteModel, memberId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFundId() {
		return _fundId;
	}

	@Override
	public void setFundId(long fundId) {
		_fundId = fundId;

		if (_memberFundRemoteModel != null) {
			try {
				Class<?> clazz = _memberFundRemoteModel.getClass();

				Method method = clazz.getMethod("setFundId", long.class);

				method.invoke(_memberFundRemoteModel, fundId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMemberName() {
		return _memberName;
	}

	@Override
	public void setMemberName(String memberName) {
		_memberName = memberName;

		if (_memberFundRemoteModel != null) {
			try {
				Class<?> clazz = _memberFundRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberName", String.class);

				method.invoke(_memberFundRemoteModel, memberName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFundName() {
		return _fundName;
	}

	@Override
	public void setFundName(String fundName) {
		_fundName = fundName;

		if (_memberFundRemoteModel != null) {
			try {
				Class<?> clazz = _memberFundRemoteModel.getClass();

				Method method = clazz.getMethod("setFundName", String.class);

				method.invoke(_memberFundRemoteModel, fundName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMemberFundRemoteModel() {
		return _memberFundRemoteModel;
	}

	public void setMemberFundRemoteModel(BaseModel<?> memberFundRemoteModel) {
		_memberFundRemoteModel = memberFundRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _memberFundRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_memberFundRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MemberFundLocalServiceUtil.addMemberFund(this);
		}
		else {
			MemberFundLocalServiceUtil.updateMemberFund(this);
		}
	}

	@Override
	public MemberFund toEscapedModel() {
		return (MemberFund)ProxyUtil.newProxyInstance(MemberFund.class.getClassLoader(),
			new Class[] { MemberFund.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MemberFundClp clone = new MemberFundClp();

		clone.setMemberFundId(getMemberFundId());
		clone.setUserId(getUserId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setMemberId(getMemberId());
		clone.setFundId(getFundId());
		clone.setMemberName(getMemberName());
		clone.setFundName(getFundName());

		return clone;
	}

	@Override
	public int compareTo(MemberFund memberFund) {
		long primaryKey = memberFund.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MemberFundClp)) {
			return false;
		}

		MemberFundClp memberFund = (MemberFundClp)obj;

		long primaryKey = memberFund.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{memberFundId=");
		sb.append(getMemberFundId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", memberId=");
		sb.append(getMemberId());
		sb.append(", fundId=");
		sb.append(getFundId());
		sb.append(", memberName=");
		sb.append(getMemberName());
		sb.append(", fundName=");
		sb.append(getFundName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("cmr.fandenatech.ndjangui.model.MemberFund");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>memberFundId</column-name><column-value><![CDATA[");
		sb.append(getMemberFundId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberId</column-name><column-value><![CDATA[");
		sb.append(getMemberId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundId</column-name><column-value><![CDATA[");
		sb.append(getFundId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberName</column-name><column-value><![CDATA[");
		sb.append(getMemberName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundName</column-name><column-value><![CDATA[");
		sb.append(getFundName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _memberFundId;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _memberId;
	private long _fundId;
	private String _memberName;
	private String _fundName;
	private BaseModel<?> _memberFundRemoteModel;
	private Class<?> _clpSerializerClass = cmr.fandenatech.ndjangui.service.ClpSerializer.class;
}