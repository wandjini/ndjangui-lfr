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

import cmr.fandenatech.ndjangui.model.Member_Fund;
import cmr.fandenatech.ndjangui.model.Member_FundModel;
import cmr.fandenatech.ndjangui.model.Member_FundSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

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
 * The base model implementation for the Member_Fund service. Represents a row in the &quot;ndjangui_Member_Fund&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link cmr.fandenatech.ndjangui.model.Member_FundModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Member_FundImpl}.
 * </p>
 *
 * @author guyw
 * @see Member_FundImpl
 * @see cmr.fandenatech.ndjangui.model.Member_Fund
 * @see cmr.fandenatech.ndjangui.model.Member_FundModel
 * @generated
 */
@JSON(strict = true)
public class Member_FundModelImpl extends BaseModelImpl<Member_Fund>
	implements Member_FundModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a member_ fund model instance should use the {@link cmr.fandenatech.ndjangui.model.Member_Fund} interface instead.
	 */
	public static final String TABLE_NAME = "ndjangui_Member_Fund";
	public static final Object[][] TABLE_COLUMNS = {
			{ "memberFundId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "memberId", Types.BIGINT },
			{ "fundId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ndjangui_Member_Fund (memberFundId LONG not null primary key,createDate DATE null,modifiedDate DATE null,memberId LONG,fundId LONG)";
	public static final String TABLE_SQL_DROP = "drop table ndjangui_Member_Fund";
	public static final String ORDER_BY_JPQL = " ORDER BY member_Fund.memberFundId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ndjangui_Member_Fund.memberFundId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.cmr.fandenatech.ndjangui.model.Member_Fund"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.cmr.fandenatech.ndjangui.model.Member_Fund"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Member_Fund toModel(Member_FundSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Member_Fund model = new Member_FundImpl();

		model.setMemberFundId(soapModel.getMemberFundId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setMemberId(soapModel.getMemberId());
		model.setFundId(soapModel.getFundId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Member_Fund> toModels(Member_FundSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Member_Fund> models = new ArrayList<Member_Fund>(soapModels.length);

		for (Member_FundSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.cmr.fandenatech.ndjangui.model.Member_Fund"));

	public Member_FundModelImpl() {
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
	public Class<?> getModelClass() {
		return Member_Fund.class;
	}

	@Override
	public String getModelClassName() {
		return Member_Fund.class.getName();
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

	@JSON
	@Override
	public long getMemberFundId() {
		return _memberFundId;
	}

	@Override
	public void setMemberFundId(long memberFundId) {
		_memberFundId = memberFundId;
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
	public long getMemberId() {
		return _memberId;
	}

	@Override
	public void setMemberId(long memberId) {
		_memberId = memberId;
	}

	@JSON
	@Override
	public long getFundId() {
		return _fundId;
	}

	@Override
	public void setFundId(long fundId) {
		_fundId = fundId;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Member_Fund.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Member_Fund toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Member_Fund)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		Member_FundImpl member_FundImpl = new Member_FundImpl();

		member_FundImpl.setMemberFundId(getMemberFundId());
		member_FundImpl.setCreateDate(getCreateDate());
		member_FundImpl.setModifiedDate(getModifiedDate());
		member_FundImpl.setMemberId(getMemberId());
		member_FundImpl.setFundId(getFundId());

		member_FundImpl.resetOriginalValues();

		return member_FundImpl;
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

		if (!(obj instanceof Member_Fund)) {
			return false;
		}

		Member_Fund member_Fund = (Member_Fund)obj;

		long primaryKey = member_Fund.getPrimaryKey();

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
	public CacheModel<Member_Fund> toCacheModel() {
		Member_FundCacheModel member_FundCacheModel = new Member_FundCacheModel();

		member_FundCacheModel.memberFundId = getMemberFundId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			member_FundCacheModel.createDate = createDate.getTime();
		}
		else {
			member_FundCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			member_FundCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			member_FundCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		member_FundCacheModel.memberId = getMemberId();

		member_FundCacheModel.fundId = getFundId();

		return member_FundCacheModel;
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

	private static ClassLoader _classLoader = Member_Fund.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Member_Fund.class
		};
	private long _memberFundId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _memberId;
	private long _fundId;
	private Member_Fund _escapedModel;
}