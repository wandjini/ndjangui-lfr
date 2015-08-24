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
import cmr.fandenatech.ndjangui.service.MemberSittingLocalServiceUtil;

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
public class MemberSittingClp extends BaseModelImpl<MemberSitting>
	implements MemberSitting {
	public MemberSittingClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MemberSitting.class;
	}

	@Override
	public String getModelClassName() {
		return MemberSitting.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _memberSittingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMemberSittingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _memberSittingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("memberSittingId", getMemberSittingId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("memberId", getMemberId());
		attributes.put("sittingId", getSittingId());
		attributes.put("memberName", getMemberName());
		attributes.put("sittingName", getSittingName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long memberSittingId = (Long)attributes.get("memberSittingId");

		if (memberSittingId != null) {
			setMemberSittingId(memberSittingId);
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

		Long sittingId = (Long)attributes.get("sittingId");

		if (sittingId != null) {
			setSittingId(sittingId);
		}

		String memberName = (String)attributes.get("memberName");

		if (memberName != null) {
			setMemberName(memberName);
		}

		String sittingName = (String)attributes.get("sittingName");

		if (sittingName != null) {
			setSittingName(sittingName);
		}
	}

	@Override
	public long getMemberSittingId() {
		return _memberSittingId;
	}

	@Override
	public void setMemberSittingId(long memberSittingId) {
		_memberSittingId = memberSittingId;

		if (_memberSittingRemoteModel != null) {
			try {
				Class<?> clazz = _memberSittingRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberSittingId", long.class);

				method.invoke(_memberSittingRemoteModel, memberSittingId);
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

		if (_memberSittingRemoteModel != null) {
			try {
				Class<?> clazz = _memberSittingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_memberSittingRemoteModel, userId);
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

		if (_memberSittingRemoteModel != null) {
			try {
				Class<?> clazz = _memberSittingRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_memberSittingRemoteModel, groupId);
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

		if (_memberSittingRemoteModel != null) {
			try {
				Class<?> clazz = _memberSittingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_memberSittingRemoteModel, companyId);
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

		if (_memberSittingRemoteModel != null) {
			try {
				Class<?> clazz = _memberSittingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_memberSittingRemoteModel, userName);
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

		if (_memberSittingRemoteModel != null) {
			try {
				Class<?> clazz = _memberSittingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_memberSittingRemoteModel, createDate);
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

		if (_memberSittingRemoteModel != null) {
			try {
				Class<?> clazz = _memberSittingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_memberSittingRemoteModel, modifiedDate);
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

		if (_memberSittingRemoteModel != null) {
			try {
				Class<?> clazz = _memberSittingRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberId", long.class);

				method.invoke(_memberSittingRemoteModel, memberId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSittingId() {
		return _sittingId;
	}

	@Override
	public void setSittingId(long sittingId) {
		_sittingId = sittingId;

		if (_memberSittingRemoteModel != null) {
			try {
				Class<?> clazz = _memberSittingRemoteModel.getClass();

				Method method = clazz.getMethod("setSittingId", long.class);

				method.invoke(_memberSittingRemoteModel, sittingId);
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

		if (_memberSittingRemoteModel != null) {
			try {
				Class<?> clazz = _memberSittingRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberName", String.class);

				method.invoke(_memberSittingRemoteModel, memberName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSittingName() {
		return _sittingName;
	}

	@Override
	public void setSittingName(String sittingName) {
		_sittingName = sittingName;

		if (_memberSittingRemoteModel != null) {
			try {
				Class<?> clazz = _memberSittingRemoteModel.getClass();

				Method method = clazz.getMethod("setSittingName", String.class);

				method.invoke(_memberSittingRemoteModel, sittingName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMemberSittingRemoteModel() {
		return _memberSittingRemoteModel;
	}

	public void setMemberSittingRemoteModel(
		BaseModel<?> memberSittingRemoteModel) {
		_memberSittingRemoteModel = memberSittingRemoteModel;
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

		Class<?> remoteModelClass = _memberSittingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_memberSittingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MemberSittingLocalServiceUtil.addMemberSitting(this);
		}
		else {
			MemberSittingLocalServiceUtil.updateMemberSitting(this);
		}
	}

	@Override
	public MemberSitting toEscapedModel() {
		return (MemberSitting)ProxyUtil.newProxyInstance(MemberSitting.class.getClassLoader(),
			new Class[] { MemberSitting.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MemberSittingClp clone = new MemberSittingClp();

		clone.setMemberSittingId(getMemberSittingId());
		clone.setUserId(getUserId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setMemberId(getMemberId());
		clone.setSittingId(getSittingId());
		clone.setMemberName(getMemberName());
		clone.setSittingName(getSittingName());

		return clone;
	}

	@Override
	public int compareTo(MemberSitting memberSitting) {
		long primaryKey = memberSitting.getPrimaryKey();

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

		if (!(obj instanceof MemberSittingClp)) {
			return false;
		}

		MemberSittingClp memberSitting = (MemberSittingClp)obj;

		long primaryKey = memberSitting.getPrimaryKey();

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

		sb.append("{memberSittingId=");
		sb.append(getMemberSittingId());
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
		sb.append(", sittingId=");
		sb.append(getSittingId());
		sb.append(", memberName=");
		sb.append(getMemberName());
		sb.append(", sittingName=");
		sb.append(getSittingName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("cmr.fandenatech.ndjangui.model.MemberSitting");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>memberSittingId</column-name><column-value><![CDATA[");
		sb.append(getMemberSittingId());
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
			"<column><column-name>sittingId</column-name><column-value><![CDATA[");
		sb.append(getSittingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberName</column-name><column-value><![CDATA[");
		sb.append(getMemberName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sittingName</column-name><column-value><![CDATA[");
		sb.append(getSittingName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _memberSittingId;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _memberId;
	private long _sittingId;
	private String _memberName;
	private String _sittingName;
	private BaseModel<?> _memberSittingRemoteModel;
	private Class<?> _clpSerializerClass = cmr.fandenatech.ndjangui.service.ClpSerializer.class;
}