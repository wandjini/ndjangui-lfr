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
import cmr.fandenatech.ndjangui.service.Member_FundLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guyw
 */
public class Member_FundClp extends BaseModelImpl<Member_Fund>
	implements Member_Fund {
	public Member_FundClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Member_Fund.class;
	}

	@Override
	public String getModelClassName() {
		return Member_Fund.class.getName();
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
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("memberId", getMemberId());
		attributes.put("fundId", getFundId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long memberFundId = (Long)attributes.get("memberFundId");

		if (memberFundId != null) {
			setMemberFundId(memberFundId);
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
	}

	@Override
	public long getMemberFundId() {
		return _memberFundId;
	}

	@Override
	public void setMemberFundId(long memberFundId) {
		_memberFundId = memberFundId;

		if (_member_FundRemoteModel != null) {
			try {
				Class<?> clazz = _member_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberFundId", long.class);

				method.invoke(_member_FundRemoteModel, memberFundId);
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

		if (_member_FundRemoteModel != null) {
			try {
				Class<?> clazz = _member_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_member_FundRemoteModel, createDate);
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

		if (_member_FundRemoteModel != null) {
			try {
				Class<?> clazz = _member_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_member_FundRemoteModel, modifiedDate);
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

		if (_member_FundRemoteModel != null) {
			try {
				Class<?> clazz = _member_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberId", long.class);

				method.invoke(_member_FundRemoteModel, memberId);
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

		if (_member_FundRemoteModel != null) {
			try {
				Class<?> clazz = _member_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setFundId", long.class);

				method.invoke(_member_FundRemoteModel, fundId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMember_FundRemoteModel() {
		return _member_FundRemoteModel;
	}

	public void setMember_FundRemoteModel(BaseModel<?> member_FundRemoteModel) {
		_member_FundRemoteModel = member_FundRemoteModel;
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

		Class<?> remoteModelClass = _member_FundRemoteModel.getClass();

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

		Object returnValue = method.invoke(_member_FundRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Member_FundLocalServiceUtil.addMember_Fund(this);
		}
		else {
			Member_FundLocalServiceUtil.updateMember_Fund(this);
		}
	}

	@Override
	public Member_Fund toEscapedModel() {
		return (Member_Fund)ProxyUtil.newProxyInstance(Member_Fund.class.getClassLoader(),
			new Class[] { Member_Fund.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Member_FundClp clone = new Member_FundClp();

		clone.setMemberFundId(getMemberFundId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setMemberId(getMemberId());
		clone.setFundId(getFundId());

		return clone;
	}

	@Override
	public int compareTo(Member_Fund member_Fund) {
		long primaryKey = member_Fund.getPrimaryKey();

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

		if (!(obj instanceof Member_FundClp)) {
			return false;
		}

		Member_FundClp member_Fund = (Member_FundClp)obj;

		long primaryKey = member_Fund.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{memberFundId=");
		sb.append(getMemberFundId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", memberId=");
		sb.append(getMemberId());
		sb.append(", fundId=");
		sb.append(getFundId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("cmr.fandenatech.ndjangui.model.Member_Fund");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>memberFundId</column-name><column-value><![CDATA[");
		sb.append(getMemberFundId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _memberFundId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _memberId;
	private long _fundId;
	private BaseModel<?> _member_FundRemoteModel;
	private Class<?> _clpSerializerClass = cmr.fandenatech.ndjangui.service.ClpSerializer.class;
}