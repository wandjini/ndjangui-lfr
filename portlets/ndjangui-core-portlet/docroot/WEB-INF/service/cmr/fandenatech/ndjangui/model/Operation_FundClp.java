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
import cmr.fandenatech.ndjangui.service.Operation_FundLocalServiceUtil;

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
public class Operation_FundClp extends BaseModelImpl<Operation_Fund>
	implements Operation_Fund {
	public Operation_FundClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Operation_Fund.class;
	}

	@Override
	public String getModelClassName() {
		return Operation_Fund.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _operationFundId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOperationFundId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _operationFundId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("operationFundId", getOperationFundId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("operationId", getOperationId());
		attributes.put("srcFundClassPK", getSrcFundClassPK());
		attributes.put("srcFundClassName", getSrcFundClassName());
		attributes.put("destFundClassPK", getDestFundClassPK());
		attributes.put("destFundClassName", getDestFundClassName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long operationFundId = (Long)attributes.get("operationFundId");

		if (operationFundId != null) {
			setOperationFundId(operationFundId);
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

		Long operationId = (Long)attributes.get("operationId");

		if (operationId != null) {
			setOperationId(operationId);
		}

		Long srcFundClassPK = (Long)attributes.get("srcFundClassPK");

		if (srcFundClassPK != null) {
			setSrcFundClassPK(srcFundClassPK);
		}

		String srcFundClassName = (String)attributes.get("srcFundClassName");

		if (srcFundClassName != null) {
			setSrcFundClassName(srcFundClassName);
		}

		Long destFundClassPK = (Long)attributes.get("destFundClassPK");

		if (destFundClassPK != null) {
			setDestFundClassPK(destFundClassPK);
		}

		String destFundClassName = (String)attributes.get("destFundClassName");

		if (destFundClassName != null) {
			setDestFundClassName(destFundClassName);
		}
	}

	@Override
	public long getOperationFundId() {
		return _operationFundId;
	}

	@Override
	public void setOperationFundId(long operationFundId) {
		_operationFundId = operationFundId;

		if (_operation_FundRemoteModel != null) {
			try {
				Class<?> clazz = _operation_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setOperationFundId", long.class);

				method.invoke(_operation_FundRemoteModel, operationFundId);
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

		if (_operation_FundRemoteModel != null) {
			try {
				Class<?> clazz = _operation_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_operation_FundRemoteModel, userId);
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

		if (_operation_FundRemoteModel != null) {
			try {
				Class<?> clazz = _operation_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_operation_FundRemoteModel, groupId);
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

		if (_operation_FundRemoteModel != null) {
			try {
				Class<?> clazz = _operation_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_operation_FundRemoteModel, companyId);
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

		if (_operation_FundRemoteModel != null) {
			try {
				Class<?> clazz = _operation_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_operation_FundRemoteModel, userName);
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

		if (_operation_FundRemoteModel != null) {
			try {
				Class<?> clazz = _operation_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_operation_FundRemoteModel, createDate);
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

		if (_operation_FundRemoteModel != null) {
			try {
				Class<?> clazz = _operation_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_operation_FundRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOperationId() {
		return _operationId;
	}

	@Override
	public void setOperationId(long operationId) {
		_operationId = operationId;

		if (_operation_FundRemoteModel != null) {
			try {
				Class<?> clazz = _operation_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setOperationId", long.class);

				method.invoke(_operation_FundRemoteModel, operationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSrcFundClassPK() {
		return _srcFundClassPK;
	}

	@Override
	public void setSrcFundClassPK(long srcFundClassPK) {
		_srcFundClassPK = srcFundClassPK;

		if (_operation_FundRemoteModel != null) {
			try {
				Class<?> clazz = _operation_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setSrcFundClassPK", long.class);

				method.invoke(_operation_FundRemoteModel, srcFundClassPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSrcFundClassName() {
		return _srcFundClassName;
	}

	@Override
	public void setSrcFundClassName(String srcFundClassName) {
		_srcFundClassName = srcFundClassName;

		if (_operation_FundRemoteModel != null) {
			try {
				Class<?> clazz = _operation_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setSrcFundClassName",
						String.class);

				method.invoke(_operation_FundRemoteModel, srcFundClassName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDestFundClassPK() {
		return _destFundClassPK;
	}

	@Override
	public void setDestFundClassPK(long destFundClassPK) {
		_destFundClassPK = destFundClassPK;

		if (_operation_FundRemoteModel != null) {
			try {
				Class<?> clazz = _operation_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setDestFundClassPK", long.class);

				method.invoke(_operation_FundRemoteModel, destFundClassPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDestFundClassName() {
		return _destFundClassName;
	}

	@Override
	public void setDestFundClassName(String destFundClassName) {
		_destFundClassName = destFundClassName;

		if (_operation_FundRemoteModel != null) {
			try {
				Class<?> clazz = _operation_FundRemoteModel.getClass();

				Method method = clazz.getMethod("setDestFundClassName",
						String.class);

				method.invoke(_operation_FundRemoteModel, destFundClassName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOperation_FundRemoteModel() {
		return _operation_FundRemoteModel;
	}

	public void setOperation_FundRemoteModel(
		BaseModel<?> operation_FundRemoteModel) {
		_operation_FundRemoteModel = operation_FundRemoteModel;
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

		Class<?> remoteModelClass = _operation_FundRemoteModel.getClass();

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

		Object returnValue = method.invoke(_operation_FundRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Operation_FundLocalServiceUtil.addOperation_Fund(this);
		}
		else {
			Operation_FundLocalServiceUtil.updateOperation_Fund(this);
		}
	}

	@Override
	public Operation_Fund toEscapedModel() {
		return (Operation_Fund)ProxyUtil.newProxyInstance(Operation_Fund.class.getClassLoader(),
			new Class[] { Operation_Fund.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Operation_FundClp clone = new Operation_FundClp();

		clone.setOperationFundId(getOperationFundId());
		clone.setUserId(getUserId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setOperationId(getOperationId());
		clone.setSrcFundClassPK(getSrcFundClassPK());
		clone.setSrcFundClassName(getSrcFundClassName());
		clone.setDestFundClassPK(getDestFundClassPK());
		clone.setDestFundClassName(getDestFundClassName());

		return clone;
	}

	@Override
	public int compareTo(Operation_Fund operation_Fund) {
		long primaryKey = operation_Fund.getPrimaryKey();

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

		if (!(obj instanceof Operation_FundClp)) {
			return false;
		}

		Operation_FundClp operation_Fund = (Operation_FundClp)obj;

		long primaryKey = operation_Fund.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{operationFundId=");
		sb.append(getOperationFundId());
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
		sb.append(", operationId=");
		sb.append(getOperationId());
		sb.append(", srcFundClassPK=");
		sb.append(getSrcFundClassPK());
		sb.append(", srcFundClassName=");
		sb.append(getSrcFundClassName());
		sb.append(", destFundClassPK=");
		sb.append(getDestFundClassPK());
		sb.append(", destFundClassName=");
		sb.append(getDestFundClassName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("cmr.fandenatech.ndjangui.model.Operation_Fund");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>operationFundId</column-name><column-value><![CDATA[");
		sb.append(getOperationFundId());
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
			"<column><column-name>operationId</column-name><column-value><![CDATA[");
		sb.append(getOperationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>srcFundClassPK</column-name><column-value><![CDATA[");
		sb.append(getSrcFundClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>srcFundClassName</column-name><column-value><![CDATA[");
		sb.append(getSrcFundClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>destFundClassPK</column-name><column-value><![CDATA[");
		sb.append(getDestFundClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>destFundClassName</column-name><column-value><![CDATA[");
		sb.append(getDestFundClassName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _operationFundId;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _operationId;
	private long _srcFundClassPK;
	private String _srcFundClassName;
	private long _destFundClassPK;
	private String _destFundClassName;
	private BaseModel<?> _operation_FundRemoteModel;
	private Class<?> _clpSerializerClass = cmr.fandenatech.ndjangui.service.ClpSerializer.class;
}