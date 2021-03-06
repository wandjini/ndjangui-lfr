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

import cmr.fandenatech.ndjangui.model.OperationType;
import cmr.fandenatech.ndjangui.model.OperationTypeModel;
import cmr.fandenatech.ndjangui.model.OperationTypeSoap;

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
 * The base model implementation for the OperationType service. Represents a row in the &quot;ndjangui_OperationType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link cmr.fandenatech.ndjangui.model.OperationTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OperationTypeImpl}.
 * </p>
 *
 * @author guyw
 * @see OperationTypeImpl
 * @see cmr.fandenatech.ndjangui.model.OperationType
 * @see cmr.fandenatech.ndjangui.model.OperationTypeModel
 * @generated
 */
@JSON(strict = true)
public class OperationTypeModelImpl extends BaseModelImpl<OperationType>
	implements OperationTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a operation type model instance should use the {@link cmr.fandenatech.ndjangui.model.OperationType} interface instead.
	 */
	public static final String TABLE_NAME = "ndjangui_OperationType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "operationTypeId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "shortDescription", Types.CLOB },
			{ "status", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table ndjangui_OperationType (operationTypeId LONG not null primary key,userId LONG,groupId LONG,companyId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,shortDescription TEXT null,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table ndjangui_OperationType";
	public static final String ORDER_BY_JPQL = " ORDER BY operationType.operationTypeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ndjangui_OperationType.operationTypeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.cmr.fandenatech.ndjangui.model.OperationType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.cmr.fandenatech.ndjangui.model.OperationType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.cmr.fandenatech.ndjangui.model.OperationType"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long NAME_COLUMN_BITMASK = 2L;
	public static long STATUS_COLUMN_BITMASK = 4L;
	public static long OPERATIONTYPEID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static OperationType toModel(OperationTypeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		OperationType model = new OperationTypeImpl();

		model.setOperationTypeId(soapModel.getOperationTypeId());
		model.setUserId(soapModel.getUserId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setShortDescription(soapModel.getShortDescription());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<OperationType> toModels(OperationTypeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<OperationType> models = new ArrayList<OperationType>(soapModels.length);

		for (OperationTypeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.cmr.fandenatech.ndjangui.model.OperationType"));

	public OperationTypeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _operationTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOperationTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _operationTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return OperationType.class;
	}

	@Override
	public String getModelClassName() {
		return OperationType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("operationTypeId", getOperationTypeId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long operationTypeId = (Long)attributes.get("operationTypeId");

		if (operationTypeId != null) {
			setOperationTypeId(operationTypeId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@JSON
	@Override
	public long getOperationTypeId() {
		return _operationTypeId;
	}

	@Override
	public void setOperationTypeId(long operationTypeId) {
		_operationTypeId = operationTypeId;
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
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public String getShortDescription() {
		if (_shortDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _shortDescription;
		}
	}

	@Override
	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			OperationType.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OperationType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (OperationType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OperationTypeImpl operationTypeImpl = new OperationTypeImpl();

		operationTypeImpl.setOperationTypeId(getOperationTypeId());
		operationTypeImpl.setUserId(getUserId());
		operationTypeImpl.setGroupId(getGroupId());
		operationTypeImpl.setCompanyId(getCompanyId());
		operationTypeImpl.setUserName(getUserName());
		operationTypeImpl.setCreateDate(getCreateDate());
		operationTypeImpl.setModifiedDate(getModifiedDate());
		operationTypeImpl.setName(getName());
		operationTypeImpl.setShortDescription(getShortDescription());
		operationTypeImpl.setStatus(getStatus());

		operationTypeImpl.resetOriginalValues();

		return operationTypeImpl;
	}

	@Override
	public int compareTo(OperationType operationType) {
		long primaryKey = operationType.getPrimaryKey();

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

		if (!(obj instanceof OperationType)) {
			return false;
		}

		OperationType operationType = (OperationType)obj;

		long primaryKey = operationType.getPrimaryKey();

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
		OperationTypeModelImpl operationTypeModelImpl = this;

		operationTypeModelImpl._originalGroupId = operationTypeModelImpl._groupId;

		operationTypeModelImpl._setOriginalGroupId = false;

		operationTypeModelImpl._originalName = operationTypeModelImpl._name;

		operationTypeModelImpl._originalStatus = operationTypeModelImpl._status;

		operationTypeModelImpl._setOriginalStatus = false;

		operationTypeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<OperationType> toCacheModel() {
		OperationTypeCacheModel operationTypeCacheModel = new OperationTypeCacheModel();

		operationTypeCacheModel.operationTypeId = getOperationTypeId();

		operationTypeCacheModel.userId = getUserId();

		operationTypeCacheModel.groupId = getGroupId();

		operationTypeCacheModel.companyId = getCompanyId();

		operationTypeCacheModel.userName = getUserName();

		String userName = operationTypeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			operationTypeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			operationTypeCacheModel.createDate = createDate.getTime();
		}
		else {
			operationTypeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			operationTypeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			operationTypeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		operationTypeCacheModel.name = getName();

		String name = operationTypeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			operationTypeCacheModel.name = null;
		}

		operationTypeCacheModel.shortDescription = getShortDescription();

		String shortDescription = operationTypeCacheModel.shortDescription;

		if ((shortDescription != null) && (shortDescription.length() == 0)) {
			operationTypeCacheModel.shortDescription = null;
		}

		operationTypeCacheModel.status = getStatus();

		return operationTypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{operationTypeId=");
		sb.append(getOperationTypeId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", shortDescription=");
		sb.append(getShortDescription());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("cmr.fandenatech.ndjangui.model.OperationType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>operationTypeId</column-name><column-value><![CDATA[");
		sb.append(getOperationTypeId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortDescription</column-name><column-value><![CDATA[");
		sb.append(getShortDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = OperationType.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			OperationType.class
		};
	private long _operationTypeId;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _originalName;
	private String _shortDescription;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _columnBitmask;
	private OperationType _escapedModel;
}