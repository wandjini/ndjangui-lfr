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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.ndjangui.notificationcenter.model.impl.NotificaImpl;
import com.ndjangui.notificationcenter.model.impl.NotificaModelImpl;
import com.xpiping.notificationcenter.NoSuchNotificaException;
import com.xpiping.notificationcenter.model.Notifica;
import com.xpiping.notificationcenter.service.persistence.NotificaPersistence;
import com.xpiping.notificationcenter.service.persistence.NotificaUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the notifica service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcoleo
 * @see NotificaPersistence
 * @see NotificaUtil
 * @generated
 */
public class NotificaPersistenceImpl extends BasePersistenceImpl<Notifica>
	implements NotificaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NotificaUtil} to access the notifica persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NotificaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NotificaModelImpl.ENTITY_CACHE_ENABLED,
			NotificaModelImpl.FINDER_CACHE_ENABLED, NotificaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NotificaModelImpl.ENTITY_CACHE_ENABLED,
			NotificaModelImpl.FINDER_CACHE_ENABLED, NotificaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NotificaModelImpl.ENTITY_CACHE_ENABLED,
			NotificaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(NotificaModelImpl.ENTITY_CACHE_ENABLED,
			NotificaModelImpl.FINDER_CACHE_ENABLED, NotificaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(NotificaModelImpl.ENTITY_CACHE_ENABLED,
			NotificaModelImpl.FINDER_CACHE_ENABLED, NotificaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			NotificaModelImpl.COMPANYID_COLUMN_BITMASK |
			NotificaModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(NotificaModelImpl.ENTITY_CACHE_ENABLED,
			NotificaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the notificas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching notificas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the notificas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notificas
	 * @param end the upper bound of the range of notificas (not inclusive)
	 * @return the range of matching notificas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notificas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notificas
	 * @param end the upper bound of the range of notificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notificas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Notifica> list = (List<Notifica>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Notifica notifica : list) {
				if ((companyId != notifica.getCompanyId())) {
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

			query.append(_SQL_SELECT_NOTIFICA_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NotificaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Notifica>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Notifica>(list);
				}
				else {
					list = (List<Notifica>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first notifica in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notifica
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaException if a matching notifica could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchNotificaException, SystemException {
		Notifica notifica = fetchByCompanyId_First(companyId, orderByComparator);

		if (notifica != null) {
			return notifica;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificaException(msg.toString());
	}

	/**
	 * Returns the first notifica in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notifica, or <code>null</code> if a matching notifica could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Notifica> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notifica in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notifica
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaException if a matching notifica could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchNotificaException, SystemException {
		Notifica notifica = fetchByCompanyId_Last(companyId, orderByComparator);

		if (notifica != null) {
			return notifica;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificaException(msg.toString());
	}

	/**
	 * Returns the last notifica in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notifica, or <code>null</code> if a matching notifica could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<Notifica> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notificas before and after the current notifica in the ordered set where companyId = &#63;.
	 *
	 * @param notificaId the primary key of the current notifica
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notifica
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica[] findByCompanyId_PrevAndNext(long notificaId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchNotificaException, SystemException {
		Notifica notifica = findByPrimaryKey(notificaId);

		Session session = null;

		try {
			session = openSession();

			Notifica[] array = new NotificaImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, notifica, companyId,
					orderByComparator, true);

			array[1] = notifica;

			array[2] = getByCompanyId_PrevAndNext(session, notifica, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Notifica getByCompanyId_PrevAndNext(Session session,
		Notifica notifica, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NOTIFICA_WHERE);

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
			query.append(NotificaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notifica);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Notifica> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the notificas that the user has permission to view where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching notificas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> filterFindByCompanyId(long companyId)
		throws SystemException {
		return filterFindByCompanyId(companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notificas that the user has permission to view where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notificas
	 * @param end the upper bound of the range of notificas (not inclusive)
	 * @return the range of matching notificas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> filterFindByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return filterFindByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notificas that the user has permissions to view where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notificas
	 * @param end the upper bound of the range of notificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notificas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> filterFindByCompanyId(long companyId, int start,
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
			query.append(_FILTER_SQL_SELECT_NOTIFICA_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_NOTIFICA_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_NOTIFICA_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(NotificaModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(NotificaModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Notifica.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, NotificaImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, NotificaImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			return (List<Notifica>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the notificas before and after the current notifica in the ordered set of notificas that the user has permission to view where companyId = &#63;.
	 *
	 * @param notificaId the primary key of the current notifica
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notifica
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica[] filterFindByCompanyId_PrevAndNext(long notificaId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchNotificaException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCompanyId_PrevAndNext(notificaId, companyId,
				orderByComparator);
		}

		Notifica notifica = findByPrimaryKey(notificaId);

		Session session = null;

		try {
			session = openSession();

			Notifica[] array = new NotificaImpl[3];

			array[0] = filterGetByCompanyId_PrevAndNext(session, notifica,
					companyId, orderByComparator, true);

			array[1] = notifica;

			array[2] = filterGetByCompanyId_PrevAndNext(session, notifica,
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

	protected Notifica filterGetByCompanyId_PrevAndNext(Session session,
		Notifica notifica, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_NOTIFICA_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_NOTIFICA_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_NOTIFICA_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(NotificaModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(NotificaModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Notifica.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, NotificaImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, NotificaImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notifica);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Notifica> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notificas where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Notifica notifica : findByCompanyId(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(notifica);
		}
	}

	/**
	 * Returns the number of notificas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching notificas
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

			query.append(_SQL_COUNT_NOTIFICA_WHERE);

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
	 * Returns the number of notificas that the user has permission to view where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching notificas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByCompanyId(long companyId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByCompanyId(companyId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_NOTIFICA_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Notifica.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "notifica.companyId = ? AND notifica.deleted=FALSE";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTIFICATYPEID =
		new FinderPath(NotificaModelImpl.ENTITY_CACHE_ENABLED,
			NotificaModelImpl.FINDER_CACHE_ENABLED, NotificaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNotificaTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATYPEID =
		new FinderPath(NotificaModelImpl.ENTITY_CACHE_ENABLED,
			NotificaModelImpl.FINDER_CACHE_ENABLED, NotificaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNotificaTypeId",
			new String[] { Long.class.getName() },
			NotificaModelImpl.NOTIFICATYPEID_COLUMN_BITMASK |
			NotificaModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NOTIFICATYPEID = new FinderPath(NotificaModelImpl.ENTITY_CACHE_ENABLED,
			NotificaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNotificaTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the notificas where notificaTypeId = &#63;.
	 *
	 * @param notificaTypeId the notifica type ID
	 * @return the matching notificas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> findByNotificaTypeId(long notificaTypeId)
		throws SystemException {
		return findByNotificaTypeId(notificaTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notificas where notificaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param notificaTypeId the notifica type ID
	 * @param start the lower bound of the range of notificas
	 * @param end the upper bound of the range of notificas (not inclusive)
	 * @return the range of matching notificas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> findByNotificaTypeId(long notificaTypeId, int start,
		int end) throws SystemException {
		return findByNotificaTypeId(notificaTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notificas where notificaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param notificaTypeId the notifica type ID
	 * @param start the lower bound of the range of notificas
	 * @param end the upper bound of the range of notificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notificas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> findByNotificaTypeId(long notificaTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATYPEID;
			finderArgs = new Object[] { notificaTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTIFICATYPEID;
			finderArgs = new Object[] {
					notificaTypeId,
					
					start, end, orderByComparator
				};
		}

		List<Notifica> list = (List<Notifica>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Notifica notifica : list) {
				if ((notificaTypeId != notifica.getNotificaTypeId())) {
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

			query.append(_SQL_SELECT_NOTIFICA_WHERE);

			query.append(_FINDER_COLUMN_NOTIFICATYPEID_NOTIFICATYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NotificaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(notificaTypeId);

				if (!pagination) {
					list = (List<Notifica>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Notifica>(list);
				}
				else {
					list = (List<Notifica>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first notifica in the ordered set where notificaTypeId = &#63;.
	 *
	 * @param notificaTypeId the notifica type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notifica
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaException if a matching notifica could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica findByNotificaTypeId_First(long notificaTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNotificaException, SystemException {
		Notifica notifica = fetchByNotificaTypeId_First(notificaTypeId,
				orderByComparator);

		if (notifica != null) {
			return notifica;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("notificaTypeId=");
		msg.append(notificaTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificaException(msg.toString());
	}

	/**
	 * Returns the first notifica in the ordered set where notificaTypeId = &#63;.
	 *
	 * @param notificaTypeId the notifica type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notifica, or <code>null</code> if a matching notifica could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica fetchByNotificaTypeId_First(long notificaTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Notifica> list = findByNotificaTypeId(notificaTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notifica in the ordered set where notificaTypeId = &#63;.
	 *
	 * @param notificaTypeId the notifica type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notifica
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaException if a matching notifica could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica findByNotificaTypeId_Last(long notificaTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNotificaException, SystemException {
		Notifica notifica = fetchByNotificaTypeId_Last(notificaTypeId,
				orderByComparator);

		if (notifica != null) {
			return notifica;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("notificaTypeId=");
		msg.append(notificaTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificaException(msg.toString());
	}

	/**
	 * Returns the last notifica in the ordered set where notificaTypeId = &#63;.
	 *
	 * @param notificaTypeId the notifica type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notifica, or <code>null</code> if a matching notifica could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica fetchByNotificaTypeId_Last(long notificaTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNotificaTypeId(notificaTypeId);

		if (count == 0) {
			return null;
		}

		List<Notifica> list = findByNotificaTypeId(notificaTypeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notificas before and after the current notifica in the ordered set where notificaTypeId = &#63;.
	 *
	 * @param notificaId the primary key of the current notifica
	 * @param notificaTypeId the notifica type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notifica
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica[] findByNotificaTypeId_PrevAndNext(long notificaId,
		long notificaTypeId, OrderByComparator orderByComparator)
		throws NoSuchNotificaException, SystemException {
		Notifica notifica = findByPrimaryKey(notificaId);

		Session session = null;

		try {
			session = openSession();

			Notifica[] array = new NotificaImpl[3];

			array[0] = getByNotificaTypeId_PrevAndNext(session, notifica,
					notificaTypeId, orderByComparator, true);

			array[1] = notifica;

			array[2] = getByNotificaTypeId_PrevAndNext(session, notifica,
					notificaTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Notifica getByNotificaTypeId_PrevAndNext(Session session,
		Notifica notifica, long notificaTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NOTIFICA_WHERE);

		query.append(_FINDER_COLUMN_NOTIFICATYPEID_NOTIFICATYPEID_2);

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
			query.append(NotificaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(notificaTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notifica);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Notifica> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the notificas that the user has permission to view where notificaTypeId = &#63;.
	 *
	 * @param notificaTypeId the notifica type ID
	 * @return the matching notificas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> filterFindByNotificaTypeId(long notificaTypeId)
		throws SystemException {
		return filterFindByNotificaTypeId(notificaTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notificas that the user has permission to view where notificaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param notificaTypeId the notifica type ID
	 * @param start the lower bound of the range of notificas
	 * @param end the upper bound of the range of notificas (not inclusive)
	 * @return the range of matching notificas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> filterFindByNotificaTypeId(long notificaTypeId,
		int start, int end) throws SystemException {
		return filterFindByNotificaTypeId(notificaTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notificas that the user has permissions to view where notificaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param notificaTypeId the notifica type ID
	 * @param start the lower bound of the range of notificas
	 * @param end the upper bound of the range of notificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notificas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> filterFindByNotificaTypeId(long notificaTypeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByNotificaTypeId(notificaTypeId, start, end,
				orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_NOTIFICA_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_NOTIFICA_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_NOTIFICATYPEID_NOTIFICATYPEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_NOTIFICA_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(NotificaModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(NotificaModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Notifica.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, NotificaImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, NotificaImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(notificaTypeId);

			return (List<Notifica>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the notificas before and after the current notifica in the ordered set of notificas that the user has permission to view where notificaTypeId = &#63;.
	 *
	 * @param notificaId the primary key of the current notifica
	 * @param notificaTypeId the notifica type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notifica
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica[] filterFindByNotificaTypeId_PrevAndNext(long notificaId,
		long notificaTypeId, OrderByComparator orderByComparator)
		throws NoSuchNotificaException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByNotificaTypeId_PrevAndNext(notificaId, notificaTypeId,
				orderByComparator);
		}

		Notifica notifica = findByPrimaryKey(notificaId);

		Session session = null;

		try {
			session = openSession();

			Notifica[] array = new NotificaImpl[3];

			array[0] = filterGetByNotificaTypeId_PrevAndNext(session, notifica,
					notificaTypeId, orderByComparator, true);

			array[1] = notifica;

			array[2] = filterGetByNotificaTypeId_PrevAndNext(session, notifica,
					notificaTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Notifica filterGetByNotificaTypeId_PrevAndNext(Session session,
		Notifica notifica, long notificaTypeId,
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
			query.append(_FILTER_SQL_SELECT_NOTIFICA_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_NOTIFICA_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_NOTIFICATYPEID_NOTIFICATYPEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_NOTIFICA_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(NotificaModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(NotificaModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Notifica.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, NotificaImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, NotificaImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(notificaTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notifica);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Notifica> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notificas where notificaTypeId = &#63; from the database.
	 *
	 * @param notificaTypeId the notifica type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNotificaTypeId(long notificaTypeId)
		throws SystemException {
		for (Notifica notifica : findByNotificaTypeId(notificaTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(notifica);
		}
	}

	/**
	 * Returns the number of notificas where notificaTypeId = &#63;.
	 *
	 * @param notificaTypeId the notifica type ID
	 * @return the number of matching notificas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNotificaTypeId(long notificaTypeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NOTIFICATYPEID;

		Object[] finderArgs = new Object[] { notificaTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NOTIFICA_WHERE);

			query.append(_FINDER_COLUMN_NOTIFICATYPEID_NOTIFICATYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(notificaTypeId);

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
	 * Returns the number of notificas that the user has permission to view where notificaTypeId = &#63;.
	 *
	 * @param notificaTypeId the notifica type ID
	 * @return the number of matching notificas that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByNotificaTypeId(long notificaTypeId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByNotificaTypeId(notificaTypeId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_NOTIFICA_WHERE);

		query.append(_FINDER_COLUMN_NOTIFICATYPEID_NOTIFICATYPEID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Notifica.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(notificaTypeId);

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

	private static final String _FINDER_COLUMN_NOTIFICATYPEID_NOTIFICATYPEID_2 = "notifica.notificaTypeId = ? AND notifica.deleted=FALSE";

	public NotificaPersistenceImpl() {
		setModelClass(Notifica.class);
	}

	/**
	 * Caches the notifica in the entity cache if it is enabled.
	 *
	 * @param notifica the notifica
	 */
	@Override
	public void cacheResult(Notifica notifica) {
		EntityCacheUtil.putResult(NotificaModelImpl.ENTITY_CACHE_ENABLED,
			NotificaImpl.class, notifica.getPrimaryKey(), notifica);

		notifica.resetOriginalValues();
	}

	/**
	 * Caches the notificas in the entity cache if it is enabled.
	 *
	 * @param notificas the notificas
	 */
	@Override
	public void cacheResult(List<Notifica> notificas) {
		for (Notifica notifica : notificas) {
			if (EntityCacheUtil.getResult(
						NotificaModelImpl.ENTITY_CACHE_ENABLED,
						NotificaImpl.class, notifica.getPrimaryKey()) == null) {
				cacheResult(notifica);
			}
			else {
				notifica.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all notificas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NotificaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NotificaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the notifica.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Notifica notifica) {
		EntityCacheUtil.removeResult(NotificaModelImpl.ENTITY_CACHE_ENABLED,
			NotificaImpl.class, notifica.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Notifica> notificas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Notifica notifica : notificas) {
			EntityCacheUtil.removeResult(NotificaModelImpl.ENTITY_CACHE_ENABLED,
				NotificaImpl.class, notifica.getPrimaryKey());
		}
	}

	/**
	 * Creates a new notifica with the primary key. Does not add the notifica to the database.
	 *
	 * @param notificaId the primary key for the new notifica
	 * @return the new notifica
	 */
	@Override
	public Notifica create(long notificaId) {
		Notifica notifica = new NotificaImpl();

		notifica.setNew(true);
		notifica.setPrimaryKey(notificaId);

		return notifica;
	}

	/**
	 * Removes the notifica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificaId the primary key of the notifica
	 * @return the notifica that was removed
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica remove(long notificaId)
		throws NoSuchNotificaException, SystemException {
		return remove((Serializable)notificaId);
	}

	/**
	 * Removes the notifica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the notifica
	 * @return the notifica that was removed
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica remove(Serializable primaryKey)
		throws NoSuchNotificaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Notifica notifica = (Notifica)session.get(NotificaImpl.class,
					primaryKey);

			if (notifica == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotificaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(notifica);
		}
		catch (NoSuchNotificaException nsee) {
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
	protected Notifica removeImpl(Notifica notifica) throws SystemException {
		notifica = toUnwrappedModel(notifica);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(notifica)) {
				notifica = (Notifica)session.get(NotificaImpl.class,
						notifica.getPrimaryKeyObj());
			}

			if (notifica != null) {
				session.delete(notifica);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (notifica != null) {
			clearCache(notifica);
		}

		return notifica;
	}

	@Override
	public Notifica updateImpl(
		com.xpiping.notificationcenter.model.Notifica notifica)
		throws SystemException {
		notifica = toUnwrappedModel(notifica);

		boolean isNew = notifica.isNew();

		NotificaModelImpl notificaModelImpl = (NotificaModelImpl)notifica;

		Session session = null;

		try {
			session = openSession();

			if (notifica.isNew()) {
				session.save(notifica);

				notifica.setNew(false);
			}
			else {
				session.merge(notifica);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NotificaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((notificaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						notificaModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { notificaModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((notificaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						notificaModelImpl.getOriginalNotificaTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTIFICATYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATYPEID,
					args);

				args = new Object[] { notificaModelImpl.getNotificaTypeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTIFICATYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(NotificaModelImpl.ENTITY_CACHE_ENABLED,
			NotificaImpl.class, notifica.getPrimaryKey(), notifica);

		return notifica;
	}

	protected Notifica toUnwrappedModel(Notifica notifica) {
		if (notifica instanceof NotificaImpl) {
			return notifica;
		}

		NotificaImpl notificaImpl = new NotificaImpl();

		notificaImpl.setNew(notifica.isNew());
		notificaImpl.setPrimaryKey(notifica.getPrimaryKey());

		notificaImpl.setNotificaId(notifica.getNotificaId());
		notificaImpl.setCompanyId(notifica.getCompanyId());
		notificaImpl.setUserId(notifica.getUserId());
		notificaImpl.setUserName(notifica.getUserName());
		notificaImpl.setCreateDate(notifica.getCreateDate());
		notificaImpl.setModifiedDate(notifica.getModifiedDate());
		notificaImpl.setNotificaTypeId(notifica.getNotificaTypeId());
		notificaImpl.setName(notifica.getName());
		notificaImpl.setText(notifica.getText());
		notificaImpl.setSubject(notifica.getSubject());
		notificaImpl.setDescription(notifica.getDescription());
		notificaImpl.setAviable(notifica.getAviable());
		notificaImpl.setIgnoreIntersaction(notifica.getIgnoreIntersaction());
		notificaImpl.setOrgsIds(notifica.getOrgsIds());
		notificaImpl.setGroupsIds(notifica.getGroupsIds());
		notificaImpl.setRolesIds(notifica.getRolesIds());
		notificaImpl.setLastCheckDate(notifica.getLastCheckDate());
		notificaImpl.setDeleted(notifica.getDeleted());

		return notificaImpl;
	}

	/**
	 * Returns the notifica with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the notifica
	 * @return the notifica
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNotificaException, SystemException {
		Notifica notifica = fetchByPrimaryKey(primaryKey);

		if (notifica == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNotificaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return notifica;
	}

	/**
	 * Returns the notifica with the primary key or throws a {@link com.xpiping.notificationcenter.NoSuchNotificaException} if it could not be found.
	 *
	 * @param notificaId the primary key of the notifica
	 * @return the notifica
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica findByPrimaryKey(long notificaId)
		throws NoSuchNotificaException, SystemException {
		return findByPrimaryKey((Serializable)notificaId);
	}

	/**
	 * Returns the notifica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the notifica
	 * @return the notifica, or <code>null</code> if a notifica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Notifica notifica = (Notifica)EntityCacheUtil.getResult(NotificaModelImpl.ENTITY_CACHE_ENABLED,
				NotificaImpl.class, primaryKey);

		if (notifica == _nullNotifica) {
			return null;
		}

		if (notifica == null) {
			Session session = null;

			try {
				session = openSession();

				notifica = (Notifica)session.get(NotificaImpl.class, primaryKey);

				if (notifica != null) {
					cacheResult(notifica);
				}
				else {
					EntityCacheUtil.putResult(NotificaModelImpl.ENTITY_CACHE_ENABLED,
						NotificaImpl.class, primaryKey, _nullNotifica);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NotificaModelImpl.ENTITY_CACHE_ENABLED,
					NotificaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return notifica;
	}

	/**
	 * Returns the notifica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notificaId the primary key of the notifica
	 * @return the notifica, or <code>null</code> if a notifica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Notifica fetchByPrimaryKey(long notificaId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)notificaId);
	}

	/**
	 * Returns all the notificas.
	 *
	 * @return the notificas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notificas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notificas
	 * @param end the upper bound of the range of notificas (not inclusive)
	 * @return the range of notificas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the notificas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notificas
	 * @param end the upper bound of the range of notificas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notificas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Notifica> findAll(int start, int end,
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

		List<Notifica> list = (List<Notifica>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NOTIFICA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NOTIFICA;

				if (pagination) {
					sql = sql.concat(NotificaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Notifica>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Notifica>(list);
				}
				else {
					list = (List<Notifica>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the notificas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Notifica notifica : findAll()) {
			remove(notifica);
		}
	}

	/**
	 * Returns the number of notificas.
	 *
	 * @return the number of notificas
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

				Query q = session.createQuery(_SQL_COUNT_NOTIFICA);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the notifica persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.xpiping.notificationcenter.model.Notifica")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Notifica>> listenersList = new ArrayList<ModelListener<Notifica>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Notifica>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NotificaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NOTIFICA = "SELECT notifica FROM Notifica notifica";
	private static final String _SQL_SELECT_NOTIFICA_WHERE = "SELECT notifica FROM Notifica notifica WHERE ";
	private static final String _SQL_COUNT_NOTIFICA = "SELECT COUNT(notifica) FROM Notifica notifica";
	private static final String _SQL_COUNT_NOTIFICA_WHERE = "SELECT COUNT(notifica) FROM Notifica notifica WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "notifica.notificaId";
	private static final String _FILTER_SQL_SELECT_NOTIFICA_WHERE = "SELECT DISTINCT {notifica.*} FROM xpiping_notificationcenter_Notifica notifica WHERE ";
	private static final String _FILTER_SQL_SELECT_NOTIFICA_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {xpiping_notificationcenter_Notifica.*} FROM (SELECT DISTINCT notifica.notificaId FROM xpiping_notificationcenter_Notifica notifica WHERE ";
	private static final String _FILTER_SQL_SELECT_NOTIFICA_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN xpiping_notificationcenter_Notifica ON TEMP_TABLE.notificaId = xpiping_notificationcenter_Notifica.notificaId";
	private static final String _FILTER_SQL_COUNT_NOTIFICA_WHERE = "SELECT COUNT(DISTINCT notifica.notificaId) AS COUNT_VALUE FROM xpiping_notificationcenter_Notifica notifica WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "notifica";
	private static final String _FILTER_ENTITY_TABLE = "xpiping_notificationcenter_Notifica";
	private static final String _ORDER_BY_ENTITY_ALIAS = "notifica.";
	private static final String _ORDER_BY_ENTITY_TABLE = "xpiping_notificationcenter_Notifica.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Notifica exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Notifica exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NotificaPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"text"
			});
	private static Notifica _nullNotifica = new NotificaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Notifica> toCacheModel() {
				return _nullNotificaCacheModel;
			}
		};

	private static CacheModel<Notifica> _nullNotificaCacheModel = new CacheModel<Notifica>() {
			@Override
			public Notifica toEntityModel() {
				return _nullNotifica;
			}
		};
}