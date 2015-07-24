/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.ndjangui.notificationcenter.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.ndjangui.notificationcenter.model.impl.NotificaTypeImpl;
import com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl;
import com.xpiping.notificationcenter.NoSuchNotificaTypeException;
import com.xpiping.notificationcenter.model.NotificaType;
import com.xpiping.notificationcenter.service.persistence.NotificaTypePersistence;
import com.xpiping.notificationcenter.service.persistence.NotificaTypeUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the notifica type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcoleo
 * @see NotificaTypePersistence
 * @see NotificaTypeUtil
 * @generated
 */
public class NotificaTypePersistenceImpl extends BasePersistenceImpl<NotificaType>
	implements NotificaTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NotificaTypeUtil} to access the notifica type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NotificaTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
			NotificaTypeModelImpl.FINDER_CACHE_ENABLED, NotificaTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
			NotificaTypeModelImpl.FINDER_CACHE_ENABLED, NotificaTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
			NotificaTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
			NotificaTypeModelImpl.FINDER_CACHE_ENABLED, NotificaTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
			NotificaTypeModelImpl.FINDER_CACHE_ENABLED, NotificaTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			NotificaTypeModelImpl.COMPANYID_COLUMN_BITMASK |
			NotificaTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
			NotificaTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the notifica types where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching notifica types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaType> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the notifica types where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notifica types
	 * @param end the upper bound of the range of notifica types (not inclusive)
	 * @return the range of matching notifica types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaType> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notifica types where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notifica types
	 * @param end the upper bound of the range of notifica types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notifica types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaType> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<NotificaType> list = (List<NotificaType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (NotificaType notificaType : list) {
				if ((companyId != notificaType.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_NOTIFICATYPE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NotificaTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<NotificaType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NotificaType>(list);
				}
				else {
					list = (List<NotificaType>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first notifica type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notifica type
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a matching notifica type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchNotificaTypeException, SystemException {
		NotificaType notificaType = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (notificaType != null) {
			return notificaType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificaTypeException(msg.toString());
	}

	/**
	 * Returns the first notifica type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notifica type, or <code>null</code> if a matching notifica type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<NotificaType> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notifica type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notifica type
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a matching notifica type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchNotificaTypeException, SystemException {
		NotificaType notificaType = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (notificaType != null) {
			return notificaType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificaTypeException(msg.toString());
	}

	/**
	 * Returns the last notifica type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notifica type, or <code>null</code> if a matching notifica type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<NotificaType> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notifica types before and after the current notifica type in the ordered set where companyId = &#63;.
	 *
	 * @param notificaTypeId the primary key of the current notifica type
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notifica type
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a notifica type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType[] findByCompanyId_PrevAndNext(long notificaTypeId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchNotificaTypeException, SystemException {
		NotificaType notificaType = findByPrimaryKey(notificaTypeId);

		Session session = null;

		try {
			session = openSession();

			NotificaType[] array = new NotificaTypeImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, notificaType,
					companyId, orderByComparator, true);

			array[1] = notificaType;

			array[2] = getByCompanyId_PrevAndNext(session, notificaType,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected NotificaType getByCompanyId_PrevAndNext(Session session,
		NotificaType notificaType, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NOTIFICATYPE_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(NotificaTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notificaType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NotificaType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the notifica types that the user has permission to view where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching notifica types that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaType> filterFindByCompanyId(long companyId)
		throws SystemException {
		return filterFindByCompanyId(companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notifica types that the user has permission to view where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notifica types
	 * @param end the upper bound of the range of notifica types (not inclusive)
	 * @return the range of matching notifica types that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaType> filterFindByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return filterFindByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notifica types that the user has permissions to view where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notifica types
	 * @param end the upper bound of the range of notifica types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notifica types that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaType> filterFindByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCompanyId(companyId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_NOTIFICATYPE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_NOTIFICATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_NOTIFICATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(NotificaTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(NotificaTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				NotificaType.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, NotificaTypeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, NotificaTypeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			return (List<NotificaType>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the notifica types before and after the current notifica type in the ordered set of notifica types that the user has permission to view where companyId = &#63;.
	 *
	 * @param notificaTypeId the primary key of the current notifica type
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notifica type
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a notifica type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType[] filterFindByCompanyId_PrevAndNext(
		long notificaTypeId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchNotificaTypeException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCompanyId_PrevAndNext(notificaTypeId, companyId,
				orderByComparator);
		}

		NotificaType notificaType = findByPrimaryKey(notificaTypeId);

		Session session = null;

		try {
			session = openSession();

			NotificaType[] array = new NotificaTypeImpl[3];

			array[0] = filterGetByCompanyId_PrevAndNext(session, notificaType,
					companyId, orderByComparator, true);

			array[1] = notificaType;

			array[2] = filterGetByCompanyId_PrevAndNext(session, notificaType,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected NotificaType filterGetByCompanyId_PrevAndNext(Session session,
		NotificaType notificaType, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_NOTIFICATYPE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_NOTIFICATYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_NOTIFICATYPE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(NotificaTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(NotificaTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				NotificaType.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, NotificaTypeImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, NotificaTypeImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notificaType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NotificaType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notifica types where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (NotificaType notificaType : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(notificaType);
		}
	}

	/**
	 * Returns the number of notifica types where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching notifica types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NOTIFICATYPE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of notifica types that the user has permission to view where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching notifica types that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByCompanyId(long companyId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByCompanyId(companyId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_NOTIFICATYPE_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				NotificaType.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "notificaType.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
			NotificaTypeModelImpl.FINDER_CACHE_ENABLED, NotificaTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			NotificaTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
			NotificaTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the notifica type where name = &#63; or throws a {@link com.xpiping.notificationcenter.NoSuchNotificaTypeException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching notifica type
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a matching notifica type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType findByName(String name)
		throws NoSuchNotificaTypeException, SystemException {
		NotificaType notificaType = fetchByName(name);

		if (notificaType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchNotificaTypeException(msg.toString());
		}

		return notificaType;
	}

	/**
	 * Returns the notifica type where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching notifica type, or <code>null</code> if a matching notifica type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the notifica type where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching notifica type, or <code>null</code> if a matching notifica type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof NotificaType) {
			NotificaType notificaType = (NotificaType)result;

			if (!Validator.equals(name, notificaType.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_NOTIFICATYPE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<NotificaType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					NotificaType notificaType = list.get(0);

					result = notificaType;

					cacheResult(notificaType);

					if ((notificaType.getName() == null) ||
							!notificaType.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, notificaType);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (NotificaType)result;
		}
	}

	/**
	 * Removes the notifica type where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the notifica type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType removeByName(String name)
		throws NoSuchNotificaTypeException, SystemException {
		NotificaType notificaType = findByName(name);

		return remove(notificaType);
	}

	/**
	 * Returns the number of notifica types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching notifica types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NOTIFICATYPE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "notificaType.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "notificaType.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(notificaType.name IS NULL OR notificaType.name = '')";

	public NotificaTypePersistenceImpl() {
		setModelClass(NotificaType.class);
	}

	/**
	 * Caches the notifica type in the entity cache if it is enabled.
	 *
	 * @param notificaType the notifica type
	 */
	@Override
	public void cacheResult(NotificaType notificaType) {
		EntityCacheUtil.putResult(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
			NotificaTypeImpl.class, notificaType.getPrimaryKey(), notificaType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { notificaType.getName() }, notificaType);

		notificaType.resetOriginalValues();
	}

	/**
	 * Caches the notifica types in the entity cache if it is enabled.
	 *
	 * @param notificaTypes the notifica types
	 */
	@Override
	public void cacheResult(List<NotificaType> notificaTypes) {
		for (NotificaType notificaType : notificaTypes) {
			if (EntityCacheUtil.getResult(
						NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
						NotificaTypeImpl.class, notificaType.getPrimaryKey()) == null) {
				cacheResult(notificaType);
			}
			else {
				notificaType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all notifica types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NotificaTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NotificaTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the notifica type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NotificaType notificaType) {
		EntityCacheUtil.removeResult(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
			NotificaTypeImpl.class, notificaType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(notificaType);
	}

	@Override
	public void clearCache(List<NotificaType> notificaTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NotificaType notificaType : notificaTypes) {
			EntityCacheUtil.removeResult(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
				NotificaTypeImpl.class, notificaType.getPrimaryKey());

			clearUniqueFindersCache(notificaType);
		}
	}

	protected void cacheUniqueFindersCache(NotificaType notificaType) {
		if (notificaType.isNew()) {
			Object[] args = new Object[] { notificaType.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
				notificaType);
		}
		else {
			NotificaTypeModelImpl notificaTypeModelImpl = (NotificaTypeModelImpl)notificaType;

			if ((notificaTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { notificaType.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					notificaType);
			}
		}
	}

	protected void clearUniqueFindersCache(NotificaType notificaType) {
		NotificaTypeModelImpl notificaTypeModelImpl = (NotificaTypeModelImpl)notificaType;

		Object[] args = new Object[] { notificaType.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((notificaTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { notificaTypeModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new notifica type with the primary key. Does not add the notifica type to the database.
	 *
	 * @param notificaTypeId the primary key for the new notifica type
	 * @return the new notifica type
	 */
	@Override
	public NotificaType create(long notificaTypeId) {
		NotificaType notificaType = new NotificaTypeImpl();

		notificaType.setNew(true);
		notificaType.setPrimaryKey(notificaTypeId);

		return notificaType;
	}

	/**
	 * Removes the notifica type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificaTypeId the primary key of the notifica type
	 * @return the notifica type that was removed
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a notifica type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType remove(long notificaTypeId)
		throws NoSuchNotificaTypeException, SystemException {
		return remove((Serializable)notificaTypeId);
	}

	/**
	 * Removes the notifica type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the notifica type
	 * @return the notifica type that was removed
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a notifica type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType remove(Serializable primaryKey)
		throws NoSuchNotificaTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NotificaType notificaType = (NotificaType)session.get(NotificaTypeImpl.class,
					primaryKey);

			if (notificaType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotificaTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(notificaType);
		}
		catch (NoSuchNotificaTypeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected NotificaType removeImpl(NotificaType notificaType)
		throws SystemException {
		notificaType = toUnwrappedModel(notificaType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(notificaType)) {
				notificaType = (NotificaType)session.get(NotificaTypeImpl.class,
						notificaType.getPrimaryKeyObj());
			}

			if (notificaType != null) {
				session.delete(notificaType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (notificaType != null) {
			clearCache(notificaType);
		}

		return notificaType;
	}

	@Override
	public NotificaType updateImpl(
		com.xpiping.notificationcenter.model.NotificaType notificaType)
		throws SystemException {
		notificaType = toUnwrappedModel(notificaType);

		boolean isNew = notificaType.isNew();

		NotificaTypeModelImpl notificaTypeModelImpl = (NotificaTypeModelImpl)notificaType;

		Session session = null;

		try {
			session = openSession();

			if (notificaType.isNew()) {
				session.save(notificaType);

				notificaType.setNew(false);
			}
			else {
				session.merge(notificaType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NotificaTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((notificaTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						notificaTypeModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { notificaTypeModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
			NotificaTypeImpl.class, notificaType.getPrimaryKey(), notificaType);

		clearUniqueFindersCache(notificaType);
		cacheUniqueFindersCache(notificaType);

		return notificaType;
	}

	protected NotificaType toUnwrappedModel(NotificaType notificaType) {
		if (notificaType instanceof NotificaTypeImpl) {
			return notificaType;
		}

		NotificaTypeImpl notificaTypeImpl = new NotificaTypeImpl();

		notificaTypeImpl.setNew(notificaType.isNew());
		notificaTypeImpl.setPrimaryKey(notificaType.getPrimaryKey());

		notificaTypeImpl.setNotificaTypeId(notificaType.getNotificaTypeId());
		notificaTypeImpl.setCompanyId(notificaType.getCompanyId());
		notificaTypeImpl.setCreateDate(notificaType.getCreateDate());
		notificaTypeImpl.setModifiedDate(notificaType.getModifiedDate());
		notificaTypeImpl.setName(notificaType.getName());
		notificaTypeImpl.setMessageDestination(notificaType.getMessageDestination());
		notificaTypeImpl.setDescription(notificaType.getDescription());
		notificaTypeImpl.setPlaceHolders(notificaType.getPlaceHolders());
		notificaTypeImpl.setAviable(notificaType.getAviable());

		return notificaTypeImpl;
	}

	/**
	 * Returns the notifica type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the notifica type
	 * @return the notifica type
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a notifica type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNotificaTypeException, SystemException {
		NotificaType notificaType = fetchByPrimaryKey(primaryKey);

		if (notificaType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNotificaTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return notificaType;
	}

	/**
	 * Returns the notifica type with the primary key or throws a {@link com.xpiping.notificationcenter.NoSuchNotificaTypeException} if it could not be found.
	 *
	 * @param notificaTypeId the primary key of the notifica type
	 * @return the notifica type
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a notifica type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType findByPrimaryKey(long notificaTypeId)
		throws NoSuchNotificaTypeException, SystemException {
		return findByPrimaryKey((Serializable)notificaTypeId);
	}

	/**
	 * Returns the notifica type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the notifica type
	 * @return the notifica type, or <code>null</code> if a notifica type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		NotificaType notificaType = (NotificaType)EntityCacheUtil.getResult(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
				NotificaTypeImpl.class, primaryKey);

		if (notificaType == _nullNotificaType) {
			return null;
		}

		if (notificaType == null) {
			Session session = null;

			try {
				session = openSession();

				notificaType = (NotificaType)session.get(NotificaTypeImpl.class,
						primaryKey);

				if (notificaType != null) {
					cacheResult(notificaType);
				}
				else {
					EntityCacheUtil.putResult(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
						NotificaTypeImpl.class, primaryKey, _nullNotificaType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NotificaTypeModelImpl.ENTITY_CACHE_ENABLED,
					NotificaTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return notificaType;
	}

	/**
	 * Returns the notifica type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notificaTypeId the primary key of the notifica type
	 * @return the notifica type, or <code>null</code> if a notifica type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaType fetchByPrimaryKey(long notificaTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)notificaTypeId);
	}

	/**
	 * Returns all the notifica types.
	 *
	 * @return the notifica types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notifica types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notifica types
	 * @param end the upper bound of the range of notifica types (not inclusive)
	 * @return the range of notifica types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the notifica types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notifica types
	 * @param end the upper bound of the range of notifica types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notifica types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaType> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<NotificaType> list = (List<NotificaType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NOTIFICATYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NOTIFICATYPE;

				if (pagination) {
					sql = sql.concat(NotificaTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NotificaType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NotificaType>(list);
				}
				else {
					list = (List<NotificaType>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the notifica types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (NotificaType notificaType : findAll()) {
			remove(notificaType);
		}
	}

	/**
	 * Returns the number of notifica types.
	 *
	 * @return the number of notifica types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NOTIFICATYPE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the notifica type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.xpiping.notificationcenter.model.NotificaType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NotificaType>> listenersList = new ArrayList<ModelListener<NotificaType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NotificaType>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(NotificaTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NOTIFICATYPE = "SELECT notificaType FROM NotificaType notificaType";
	private static final String _SQL_SELECT_NOTIFICATYPE_WHERE = "SELECT notificaType FROM NotificaType notificaType WHERE ";
	private static final String _SQL_COUNT_NOTIFICATYPE = "SELECT COUNT(notificaType) FROM NotificaType notificaType";
	private static final String _SQL_COUNT_NOTIFICATYPE_WHERE = "SELECT COUNT(notificaType) FROM NotificaType notificaType WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "notificaType.notificaTypeId";
	private static final String _FILTER_SQL_SELECT_NOTIFICATYPE_WHERE = "SELECT DISTINCT {notificaType.*} FROM xpiping_notificationcenter_NotificaType notificaType WHERE ";
	private static final String _FILTER_SQL_SELECT_NOTIFICATYPE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {xpiping_notificationcenter_NotificaType.*} FROM (SELECT DISTINCT notificaType.notificaTypeId FROM xpiping_notificationcenter_NotificaType notificaType WHERE ";
	private static final String _FILTER_SQL_SELECT_NOTIFICATYPE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN xpiping_notificationcenter_NotificaType ON TEMP_TABLE.notificaTypeId = xpiping_notificationcenter_NotificaType.notificaTypeId";
	private static final String _FILTER_SQL_COUNT_NOTIFICATYPE_WHERE = "SELECT COUNT(DISTINCT notificaType.notificaTypeId) AS COUNT_VALUE FROM xpiping_notificationcenter_NotificaType notificaType WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "notificaType";
	private static final String _FILTER_ENTITY_TABLE = "xpiping_notificationcenter_NotificaType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "notificaType.";
	private static final String _ORDER_BY_ENTITY_TABLE = "xpiping_notificationcenter_NotificaType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NotificaType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NotificaType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NotificaTypePersistenceImpl.class);
	private static NotificaType _nullNotificaType = new NotificaTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NotificaType> toCacheModel() {
				return _nullNotificaTypeCacheModel;
			}
		};

	private static CacheModel<NotificaType> _nullNotificaTypeCacheModel = new CacheModel<NotificaType>() {
			@Override
			public NotificaType toEntityModel() {
				return _nullNotificaType;
			}
		};
}