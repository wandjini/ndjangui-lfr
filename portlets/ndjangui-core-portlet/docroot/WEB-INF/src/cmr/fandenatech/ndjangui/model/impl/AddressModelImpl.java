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

import cmr.fandenatech.ndjangui.model.Address;
import cmr.fandenatech.ndjangui.model.AddressModel;
import cmr.fandenatech.ndjangui.model.AddressSoap;

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
 * The base model implementation for the Address service. Represents a row in the &quot;ndjangui_Address&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link cmr.fandenatech.ndjangui.model.AddressModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AddressImpl}.
 * </p>
 *
 * @author guyw
 * @see AddressImpl
 * @see cmr.fandenatech.ndjangui.model.Address
 * @see cmr.fandenatech.ndjangui.model.AddressModel
 * @generated
 */
@JSON(strict = true)
public class AddressModelImpl extends BaseModelImpl<Address>
	implements AddressModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a address model instance should use the {@link cmr.fandenatech.ndjangui.model.Address} interface instead.
	 */
	public static final String TABLE_NAME = "ndjangui_Address";
	public static final Object[][] TABLE_COLUMNS = {
			{ "addressId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "street", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "country", Types.VARCHAR },
			{ "town", Types.VARCHAR },
			{ "note", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ndjangui_Address (addressId LONG not null primary key,userId LONG,groupId LONG,companyId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,street VARCHAR(75) null,city VARCHAR(75) null,country VARCHAR(75) null,town VARCHAR(75) null,note VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ndjangui_Address";
	public static final String ORDER_BY_JPQL = " ORDER BY address.addressId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ndjangui_Address.addressId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.cmr.fandenatech.ndjangui.model.Address"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.cmr.fandenatech.ndjangui.model.Address"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.cmr.fandenatech.ndjangui.model.Address"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long ADDRESSID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Address toModel(AddressSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Address model = new AddressImpl();

		model.setAddressId(soapModel.getAddressId());
		model.setUserId(soapModel.getUserId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStreet(soapModel.getStreet());
		model.setCity(soapModel.getCity());
		model.setCountry(soapModel.getCountry());
		model.setTown(soapModel.getTown());
		model.setNote(soapModel.getNote());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Address> toModels(AddressSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Address> models = new ArrayList<Address>(soapModels.length);

		for (AddressSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.cmr.fandenatech.ndjangui.model.Address"));

	public AddressModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _addressId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAddressId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _addressId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Address.class;
	}

	@Override
	public String getModelClassName() {
		return Address.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressId", getAddressId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("street", getStreet());
		attributes.put("city", getCity());
		attributes.put("country", getCountry());
		attributes.put("town", getTown());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
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

		String street = (String)attributes.get("street");

		if (street != null) {
			setStreet(street);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String town = (String)attributes.get("town");

		if (town != null) {
			setTown(town);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	@JSON
	@Override
	public long getAddressId() {
		return _addressId;
	}

	@Override
	public void setAddressId(long addressId) {
		_addressId = addressId;
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
	public String getStreet() {
		if (_street == null) {
			return StringPool.BLANK;
		}
		else {
			return _street;
		}
	}

	@Override
	public void setStreet(String street) {
		_street = street;
	}

	@JSON
	@Override
	public String getCity() {
		if (_city == null) {
			return StringPool.BLANK;
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		_city = city;
	}

	@JSON
	@Override
	public String getCountry() {
		if (_country == null) {
			return StringPool.BLANK;
		}
		else {
			return _country;
		}
	}

	@Override
	public void setCountry(String country) {
		_country = country;
	}

	@JSON
	@Override
	public String getTown() {
		if (_town == null) {
			return StringPool.BLANK;
		}
		else {
			return _town;
		}
	}

	@Override
	public void setTown(String town) {
		_town = town;
	}

	@JSON
	@Override
	public String getNote() {
		if (_note == null) {
			return StringPool.BLANK;
		}
		else {
			return _note;
		}
	}

	@Override
	public void setNote(String note) {
		_note = note;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Address.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Address toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Address)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AddressImpl addressImpl = new AddressImpl();

		addressImpl.setAddressId(getAddressId());
		addressImpl.setUserId(getUserId());
		addressImpl.setGroupId(getGroupId());
		addressImpl.setCompanyId(getCompanyId());
		addressImpl.setUserName(getUserName());
		addressImpl.setCreateDate(getCreateDate());
		addressImpl.setModifiedDate(getModifiedDate());
		addressImpl.setStreet(getStreet());
		addressImpl.setCity(getCity());
		addressImpl.setCountry(getCountry());
		addressImpl.setTown(getTown());
		addressImpl.setNote(getNote());

		addressImpl.resetOriginalValues();

		return addressImpl;
	}

	@Override
	public int compareTo(Address address) {
		long primaryKey = address.getPrimaryKey();

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

		if (!(obj instanceof Address)) {
			return false;
		}

		Address address = (Address)obj;

		long primaryKey = address.getPrimaryKey();

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
		AddressModelImpl addressModelImpl = this;

		addressModelImpl._originalGroupId = addressModelImpl._groupId;

		addressModelImpl._setOriginalGroupId = false;

		addressModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Address> toCacheModel() {
		AddressCacheModel addressCacheModel = new AddressCacheModel();

		addressCacheModel.addressId = getAddressId();

		addressCacheModel.userId = getUserId();

		addressCacheModel.groupId = getGroupId();

		addressCacheModel.companyId = getCompanyId();

		addressCacheModel.userName = getUserName();

		String userName = addressCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			addressCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			addressCacheModel.createDate = createDate.getTime();
		}
		else {
			addressCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			addressCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			addressCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		addressCacheModel.street = getStreet();

		String street = addressCacheModel.street;

		if ((street != null) && (street.length() == 0)) {
			addressCacheModel.street = null;
		}

		addressCacheModel.city = getCity();

		String city = addressCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			addressCacheModel.city = null;
		}

		addressCacheModel.country = getCountry();

		String country = addressCacheModel.country;

		if ((country != null) && (country.length() == 0)) {
			addressCacheModel.country = null;
		}

		addressCacheModel.town = getTown();

		String town = addressCacheModel.town;

		if ((town != null) && (town.length() == 0)) {
			addressCacheModel.town = null;
		}

		addressCacheModel.note = getNote();

		String note = addressCacheModel.note;

		if ((note != null) && (note.length() == 0)) {
			addressCacheModel.note = null;
		}

		return addressCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{addressId=");
		sb.append(getAddressId());
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
		sb.append(", street=");
		sb.append(getStreet());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", town=");
		sb.append(getTown());
		sb.append(", note=");
		sb.append(getNote());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("cmr.fandenatech.ndjangui.model.Address");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>addressId</column-name><column-value><![CDATA[");
		sb.append(getAddressId());
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
			"<column><column-name>street</column-name><column-value><![CDATA[");
		sb.append(getStreet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>town</column-name><column-value><![CDATA[");
		sb.append(getTown());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Address.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Address.class
		};
	private long _addressId;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _street;
	private String _city;
	private String _country;
	private String _town;
	private String _note;
	private long _columnBitmask;
	private Address _escapedModel;
}