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

import cmr.fandenatech.ndjangui.model.SanctionType;
import cmr.fandenatech.ndjangui.model.SanctionTypeModel;
import cmr.fandenatech.ndjangui.model.SanctionTypeSoap;

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
 * The base model implementation for the SanctionType service. Represents a row in the &quot;ndjangui_SanctionType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link cmr.fandenatech.ndjangui.model.SanctionTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SanctionTypeImpl}.
 * </p>
 *
 * @author guyw
 * @see SanctionTypeImpl
 * @see cmr.fandenatech.ndjangui.model.SanctionType
 * @see cmr.fandenatech.ndjangui.model.SanctionTypeModel
 * @generated
 */
@JSON(strict = true)
public class SanctionTypeModelImpl extends BaseModelImpl<SanctionType>
	implements SanctionTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sanction type model instance should use the {@link cmr.fandenatech.ndjangui.model.SanctionType} interface instead.
	 */
	public static final String TABLE_NAME = "ndjangui_SanctionType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "sanctionTypeId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "shortDescription", Types.CLOB },
			{ "amount", Types.DOUBLE },
			{ "status", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table ndjangui_SanctionType (sanctionTypeId LONG not null primary key,userId LONG,groupId LONG,companyId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,shortDescription TEXT null,amount DOUBLE,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table ndjangui_SanctionType";
	public static final String ORDER_BY_JPQL = " ORDER BY sanctionType.sanctionTypeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ndjangui_SanctionType.sanctionTypeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.cmr.fandenatech.ndjangui.model.SanctionType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.cmr.fandenatech.ndjangui.model.SanctionType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.cmr.fandenatech.ndjangui.model.SanctionType"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long NAME_COLUMN_BITMASK = 2L;
	public static long STATUS_COLUMN_BITMASK = 4L;
	public static long SANCTIONTYPEID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static SanctionType toModel(SanctionTypeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SanctionType model = new SanctionTypeImpl();

		model.setSanctionTypeId(soapModel.getSanctionTypeId());
		model.setUserId(soapModel.getUserId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setShortDescription(soapModel.getShortDescription());
		model.setAmount(soapModel.getAmount());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SanctionType> toModels(SanctionTypeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SanctionType> models = new ArrayList<SanctionType>(soapModels.length);

		for (SanctionTypeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.cmr.fandenatech.ndjangui.model.SanctionType"));

	public SanctionTypeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _sanctionTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSanctionTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sanctionTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SanctionType.class;
	}

	@Override
	public String getModelClassName() {
		return SanctionType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sanctionTypeId", getSanctionTypeId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("amount", getAmount());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sanctionTypeId = (Long)attributes.get("sanctionTypeId");

		if (sanctionTypeId != null) {
			setSanctionTypeId(sanctionTypeId);
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

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@JSON
	@Override
	public long getSanctionTypeId() {
		return _sanctionTypeId;
	}

	@Override
	public void setSanctionTypeId(long sanctionTypeId) {
		_sanctionTypeId = sanctionTypeId;
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
	public double getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(double amount) {
		_amount = amount;
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
			SanctionType.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SanctionType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SanctionType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SanctionTypeImpl sanctionTypeImpl = new SanctionTypeImpl();

		sanctionTypeImpl.setSanctionTypeId(getSanctionTypeId());
		sanctionTypeImpl.setUserId(getUserId());
		sanctionTypeImpl.setGroupId(getGroupId());
		sanctionTypeImpl.setCompanyId(getCompanyId());
		sanctionTypeImpl.setUserName(getUserName());
		sanctionTypeImpl.setCreateDate(getCreateDate());
		sanctionTypeImpl.setModifiedDate(getModifiedDate());
		sanctionTypeImpl.setName(getName());
		sanctionTypeImpl.setShortDescription(getShortDescription());
		sanctionTypeImpl.setAmount(getAmount());
		sanctionTypeImpl.setStatus(getStatus());

		sanctionTypeImpl.resetOriginalValues();

		return sanctionTypeImpl;
	}

	@Override
	public int compareTo(SanctionType sanctionType) {
		long primaryKey = sanctionType.getPrimaryKey();

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

		if (!(obj instanceof SanctionType)) {
			return false;
		}

		SanctionType sanctionType = (SanctionType)obj;

		long primaryKey = sanctionType.getPrimaryKey();

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
		SanctionTypeModelImpl sanctionTypeModelImpl = this;

		sanctionTypeModelImpl._originalGroupId = sanctionTypeModelImpl._groupId;

		sanctionTypeModelImpl._setOriginalGroupId = false;

		sanctionTypeModelImpl._originalName = sanctionTypeModelImpl._name;

		sanctionTypeModelImpl._originalStatus = sanctionTypeModelImpl._status;

		sanctionTypeModelImpl._setOriginalStatus = false;

		sanctionTypeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SanctionType> toCacheModel() {
		SanctionTypeCacheModel sanctionTypeCacheModel = new SanctionTypeCacheModel();

		sanctionTypeCacheModel.sanctionTypeId = getSanctionTypeId();

		sanctionTypeCacheModel.userId = getUserId();

		sanctionTypeCacheModel.groupId = getGroupId();

		sanctionTypeCacheModel.companyId = getCompanyId();

		sanctionTypeCacheModel.userName = getUserName();

		String userName = sanctionTypeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			sanctionTypeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			sanctionTypeCacheModel.createDate = createDate.getTime();
		}
		else {
			sanctionTypeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			sanctionTypeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			sanctionTypeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		sanctionTypeCacheModel.name = getName();

		String name = sanctionTypeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			sanctionTypeCacheModel.name = null;
		}

		sanctionTypeCacheModel.shortDescription = getShortDescription();

		String shortDescription = sanctionTypeCacheModel.shortDescription;

		if ((shortDescription != null) && (shortDescription.length() == 0)) {
			sanctionTypeCacheModel.shortDescription = null;
		}

		sanctionTypeCacheModel.amount = getAmount();

		sanctionTypeCacheModel.status = getStatus();

		return sanctionTypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{sanctionTypeId=");
		sb.append(getSanctionTypeId());
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
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("cmr.fandenatech.ndjangui.model.SanctionType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sanctionTypeId</column-name><column-value><![CDATA[");
		sb.append(getSanctionTypeId());
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
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SanctionType.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SanctionType.class
		};
	private long _sanctionTypeId;
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
	private double _amount;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _columnBitmask;
	private SanctionType _escapedModel;
}