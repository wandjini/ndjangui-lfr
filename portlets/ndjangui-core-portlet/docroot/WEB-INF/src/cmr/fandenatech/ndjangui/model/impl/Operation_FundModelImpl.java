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

package cmr.fandenatech.ndjangui.model.impl;

import cmr.fandenatech.ndjangui.model.Operation_Fund;
import cmr.fandenatech.ndjangui.model.Operation_FundModel;
import cmr.fandenatech.ndjangui.model.Operation_FundSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Operation_Fund service. Represents a row in the &quot;ndjangui_Operation_Fund&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link cmr.fandenatech.ndjangui.model.Operation_FundModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Operation_FundImpl}.
 * </p>
 *
 * @author guyw
 * @see Operation_FundImpl
 * @see cmr.fandenatech.ndjangui.model.Operation_Fund
 * @see cmr.fandenatech.ndjangui.model.Operation_FundModel
 * @generated
 */
@JSON(strict = true)
public class Operation_FundModelImpl extends BaseModelImpl<Operation_Fund>
	implements Operation_FundModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a operation_ fund model instance should use the {@link cmr.fandenatech.ndjangui.model.Operation_Fund} interface instead.
	 */
	public static final String TABLE_NAME = "ndjangui_Operation_Fund";
	public static final Object[][] TABLE_COLUMNS = {
			{ "operationFundId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "operationId", Types.BIGINT },
			{ "srcFundClassPK", Types.BIGINT },
			{ "srcFundClassName", Types.VARCHAR },
			{ "destFundClassPK", Types.BIGINT },
			{ "destFundClassName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ndjangui_Operation_Fund (operationFundId LONG not null primary key,userId LONG,groupId LONG,companyId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,operationId LONG,srcFundClassPK LONG,srcFundClassName VARCHAR(75) null,destFundClassPK LONG,destFundClassName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ndjangui_Operation_Fund";
	public static final String ORDER_BY_JPQL = " ORDER BY operation_Fund.operationFundId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ndjangui_Operation_Fund.operationFundId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.cmr.fandenatech.ndjangui.model.Operation_Fund"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.cmr.fandenatech.ndjangui.model.Operation_Fund"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Operation_Fund toModel(Operation_FundSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Operation_Fund model = new Operation_FundImpl();

		model.setOperationFundId(soapModel.getOperationFundId());
		model.setUserId(soapModel.getUserId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setOperationId(soapModel.getOperationId());
		model.setSrcFundClassPK(soapModel.getSrcFundClassPK());
		model.setSrcFundClassName(soapModel.getSrcFundClassName());
		model.setDestFundClassPK(soapModel.getDestFundClassPK());
		model.setDestFundClassName(soapModel.getDestFundClassName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Operation_Fund> toModels(Operation_FundSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Operation_Fund> models = new ArrayList<Operation_Fund>(soapModels.length);

		for (Operation_FundSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.cmr.fandenatech.ndjangui.model.Operation_Fund"));

	public Operation_FundModelImpl() {
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
	public Class<?> getModelClass() {
		return Operation_Fund.class;
	}

	@Override
	public String getModelClassName() {
		return Operation_Fund.class.getName();
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

	@JSON
	@Override
	public long getOperationFundId() {
		return _operationFundId;
	}

	@Override
	public void setOperationFundId(long operationFundId) {
		_operationFundId = operationFundId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getOperationId() {
		return _operationId;
	}

	@Override
	public void setOperationId(long operationId) {
		_operationId = operationId;
	}

	@JSON
	@Override
	public long getSrcFundClassPK() {
		return _srcFundClassPK;
	}

	@Override
	public void setSrcFundClassPK(long srcFundClassPK) {
		_srcFundClassPK = srcFundClassPK;
	}

	@JSON
	@Override
	public String getSrcFundClassName() {
		if (_srcFundClassName == null) {
			return StringPool.BLANK;
		}
		else {
			return _srcFundClassName;
		}
	}

	@Override
	public void setSrcFundClassName(String srcFundClassName) {
		_srcFundClassName = srcFundClassName;
	}

	@JSON
	@Override
	public long getDestFundClassPK() {
		return _destFundClassPK;
	}

	@Override
	public void setDestFundClassPK(long destFundClassPK) {
		_destFundClassPK = destFundClassPK;
	}

	@JSON
	@Override
	public String getDestFundClassName() {
		if (_destFundClassName == null) {
			return StringPool.BLANK;
		}
		else {
			return _destFundClassName;
		}
	}

	@Override
	public void setDestFundClassName(String destFundClassName) {
		_destFundClassName = destFundClassName;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Operation_Fund.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Operation_Fund toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Operation_Fund)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		Operation_FundImpl operation_FundImpl = new Operation_FundImpl();

		operation_FundImpl.setOperationFundId(getOperationFundId());
		operation_FundImpl.setUserId(getUserId());
		operation_FundImpl.setGroupId(getGroupId());
		operation_FundImpl.setCompanyId(getCompanyId());
		operation_FundImpl.setUserName(getUserName());
		operation_FundImpl.setCreateDate(getCreateDate());
		operation_FundImpl.setModifiedDate(getModifiedDate());
		operation_FundImpl.setOperationId(getOperationId());
		operation_FundImpl.setSrcFundClassPK(getSrcFundClassPK());
		operation_FundImpl.setSrcFundClassName(getSrcFundClassName());
		operation_FundImpl.setDestFundClassPK(getDestFundClassPK());
		operation_FundImpl.setDestFundClassName(getDestFundClassName());

		operation_FundImpl.resetOriginalValues();

		return operation_FundImpl;
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

		if (!(obj instanceof Operation_Fund)) {
			return false;
		}

		Operation_Fund operation_Fund = (Operation_Fund)obj;

		long primaryKey = operation_Fund.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Operation_Fund> toCacheModel() {
		Operation_FundCacheModel operation_FundCacheModel = new Operation_FundCacheModel();

		operation_FundCacheModel.operationFundId = getOperationFundId();

		operation_FundCacheModel.userId = getUserId();

		operation_FundCacheModel.groupId = getGroupId();

		operation_FundCacheModel.companyId = getCompanyId();

		operation_FundCacheModel.userName = getUserName();

		String userName = operation_FundCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			operation_FundCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			operation_FundCacheModel.createDate = createDate.getTime();
		}
		else {
			operation_FundCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			operation_FundCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			operation_FundCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		operation_FundCacheModel.operationId = getOperationId();

		operation_FundCacheModel.srcFundClassPK = getSrcFundClassPK();

		operation_FundCacheModel.srcFundClassName = getSrcFundClassName();

		String srcFundClassName = operation_FundCacheModel.srcFundClassName;

		if ((srcFundClassName != null) && (srcFundClassName.length() == 0)) {
			operation_FundCacheModel.srcFundClassName = null;
		}

		operation_FundCacheModel.destFundClassPK = getDestFundClassPK();

		operation_FundCacheModel.destFundClassName = getDestFundClassName();

		String destFundClassName = operation_FundCacheModel.destFundClassName;

		if ((destFundClassName != null) && (destFundClassName.length() == 0)) {
			operation_FundCacheModel.destFundClassName = null;
		}

		return operation_FundCacheModel;
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

	private static ClassLoader _classLoader = Operation_Fund.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Operation_Fund.class
		};
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
	private Operation_Fund _escapedModel;
}