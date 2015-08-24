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
import cmr.fandenatech.ndjangui.service.SanctionLocalServiceUtil;

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
public class SanctionClp extends BaseModelImpl<Sanction> implements Sanction {
	public SanctionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Sanction.class;
	}

	@Override
	public String getModelClassName() {
		return Sanction.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _sanctionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSanctionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sanctionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sanctionId", getSanctionId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("memberId", getMemberId());
		attributes.put("budgetPeriodId", getBudgetPeriodId());
		attributes.put("name", getName());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("sanctionTypeId", getSanctionTypeId());
		attributes.put("sittingId", getSittingId());
		attributes.put("amount", getAmount());
		attributes.put("status", getStatus());
		attributes.put("srcFundClassPK", getSrcFundClassPK());
		attributes.put("srcFundClassName", getSrcFundClassName());
		attributes.put("destFundClassPK", getDestFundClassPK());
		attributes.put("destFundClassName", getDestFundClassName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sanctionId = (Long)attributes.get("sanctionId");

		if (sanctionId != null) {
			setSanctionId(sanctionId);
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

		Long budgetPeriodId = (Long)attributes.get("budgetPeriodId");

		if (budgetPeriodId != null) {
			setBudgetPeriodId(budgetPeriodId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		Long sanctionTypeId = (Long)attributes.get("sanctionTypeId");

		if (sanctionTypeId != null) {
			setSanctionTypeId(sanctionTypeId);
		}

		Long sittingId = (Long)attributes.get("sittingId");

		if (sittingId != null) {
			setSittingId(sittingId);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
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
	public long getSanctionId() {
		return _sanctionId;
	}

	@Override
	public void setSanctionId(long sanctionId) {
		_sanctionId = sanctionId;

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setSanctionId", long.class);

				method.invoke(_sanctionRemoteModel, sanctionId);
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

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_sanctionRemoteModel, userId);
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

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_sanctionRemoteModel, groupId);
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

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_sanctionRemoteModel, companyId);
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

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_sanctionRemoteModel, userName);
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

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_sanctionRemoteModel, createDate);
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

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_sanctionRemoteModel, modifiedDate);
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

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberId", long.class);

				method.invoke(_sanctionRemoteModel, memberId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBudgetPeriodId() {
		return _budgetPeriodId;
	}

	@Override
	public void setBudgetPeriodId(long budgetPeriodId) {
		_budgetPeriodId = budgetPeriodId;

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setBudgetPeriodId", long.class);

				method.invoke(_sanctionRemoteModel, budgetPeriodId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_sanctionRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShortDescription() {
		return _shortDescription;
	}

	@Override
	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setShortDescription",
						String.class);

				method.invoke(_sanctionRemoteModel, shortDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSanctionTypeId() {
		return _sanctionTypeId;
	}

	@Override
	public void setSanctionTypeId(long sanctionTypeId) {
		_sanctionTypeId = sanctionTypeId;

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setSanctionTypeId", long.class);

				method.invoke(_sanctionRemoteModel, sanctionTypeId);
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

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setSittingId", long.class);

				method.invoke(_sanctionRemoteModel, sittingId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(double amount) {
		_amount = amount;

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setAmount", double.class);

				method.invoke(_sanctionRemoteModel, amount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_sanctionRemoteModel, status);
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

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setSrcFundClassPK", long.class);

				method.invoke(_sanctionRemoteModel, srcFundClassPK);
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

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setSrcFundClassName",
						String.class);

				method.invoke(_sanctionRemoteModel, srcFundClassName);
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

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setDestFundClassPK", long.class);

				method.invoke(_sanctionRemoteModel, destFundClassPK);
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

		if (_sanctionRemoteModel != null) {
			try {
				Class<?> clazz = _sanctionRemoteModel.getClass();

				Method method = clazz.getMethod("setDestFundClassName",
						String.class);

				method.invoke(_sanctionRemoteModel, destFundClassName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSanctionRemoteModel() {
		return _sanctionRemoteModel;
	}

	public void setSanctionRemoteModel(BaseModel<?> sanctionRemoteModel) {
		_sanctionRemoteModel = sanctionRemoteModel;
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

		Class<?> remoteModelClass = _sanctionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_sanctionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SanctionLocalServiceUtil.addSanction(this);
		}
		else {
			SanctionLocalServiceUtil.updateSanction(this);
		}
	}

	@Override
	public Sanction toEscapedModel() {
		return (Sanction)ProxyUtil.newProxyInstance(Sanction.class.getClassLoader(),
			new Class[] { Sanction.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SanctionClp clone = new SanctionClp();

		clone.setSanctionId(getSanctionId());
		clone.setUserId(getUserId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setMemberId(getMemberId());
		clone.setBudgetPeriodId(getBudgetPeriodId());
		clone.setName(getName());
		clone.setShortDescription(getShortDescription());
		clone.setSanctionTypeId(getSanctionTypeId());
		clone.setSittingId(getSittingId());
		clone.setAmount(getAmount());
		clone.setStatus(getStatus());
		clone.setSrcFundClassPK(getSrcFundClassPK());
		clone.setSrcFundClassName(getSrcFundClassName());
		clone.setDestFundClassPK(getDestFundClassPK());
		clone.setDestFundClassName(getDestFundClassName());

		return clone;
	}

	@Override
	public int compareTo(Sanction sanction) {
		long primaryKey = sanction.getPrimaryKey();

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

		if (!(obj instanceof SanctionClp)) {
			return false;
		}

		SanctionClp sanction = (SanctionClp)obj;

		long primaryKey = sanction.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{sanctionId=");
		sb.append(getSanctionId());
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
		sb.append(", budgetPeriodId=");
		sb.append(getBudgetPeriodId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", shortDescription=");
		sb.append(getShortDescription());
		sb.append(", sanctionTypeId=");
		sb.append(getSanctionTypeId());
		sb.append(", sittingId=");
		sb.append(getSittingId());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", status=");
		sb.append(getStatus());
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
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("cmr.fandenatech.ndjangui.model.Sanction");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sanctionId</column-name><column-value><![CDATA[");
		sb.append(getSanctionId());
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
			"<column><column-name>budgetPeriodId</column-name><column-value><![CDATA[");
		sb.append(getBudgetPeriodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortDescription</column-name><column-value><![CDATA[");
		sb.append(getShortDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sanctionTypeId</column-name><column-value><![CDATA[");
		sb.append(getSanctionTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sittingId</column-name><column-value><![CDATA[");
		sb.append(getSittingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
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

	private long _sanctionId;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _memberId;
	private long _budgetPeriodId;
	private String _name;
	private String _shortDescription;
	private long _sanctionTypeId;
	private long _sittingId;
	private double _amount;
	private int _status;
	private long _srcFundClassPK;
	private String _srcFundClassName;
	private long _destFundClassPK;
	private String _destFundClassName;
	private BaseModel<?> _sanctionRemoteModel;
	private Class<?> _clpSerializerClass = cmr.fandenatech.ndjangui.service.ClpSerializer.class;
}