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

package cmr.fandenatech.ndjangui.service.persistence;

import cmr.fandenatech.ndjangui.NoSuchFundException;
import cmr.fandenatech.ndjangui.model.Fund;
import cmr.fandenatech.ndjangui.model.impl.FundImpl;
import cmr.fandenatech.ndjangui.model.impl.FundModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the fund service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see FundPersistence
 * @see FundUtil
 * @generated
 */
public class FundPersistenceImpl extends BasePersistenceImpl<Fund>
	implements FundPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FundUtil} to access the fund persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FundImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundModelImpl.FINDER_CACHE_ENABLED, FundImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundModelImpl.FINDER_CACHE_ENABLED, FundImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundModelImpl.FINDER_CACHE_ENABLED, FundImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundModelImpl.FINDER_CACHE_ENABLED, FundImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			FundModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the funds where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fund> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funds where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of funds
	 * @param end the upper bound of the range of funds (not inclusive)
	 * @return the range of matching funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fund> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funds where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of funds
	 * @param end the upper bound of the range of funds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fund> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Fund> list = (List<Fund>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Fund fund : list) {
				if ((groupId != fund.getGroupId())) {
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

			query.append(_SQL_SELECT_FUND_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FundModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Fund>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Fund>(list);
				}
				else {
					list = (List<Fund>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first fund in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundException if a matching fund could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFundException, SystemException {
		Fund fund = fetchByGroupId_First(groupId, orderByComparator);

		if (fund != null) {
			return fund;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundException(msg.toString());
	}

	/**
	 * Returns the first fund in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund, or <code>null</code> if a matching fund could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Fund> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fund in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundException if a matching fund could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFundException, SystemException {
		Fund fund = fetchByGroupId_Last(groupId, orderByComparator);

		if (fund != null) {
			return fund;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundException(msg.toString());
	}

	/**
	 * Returns the last fund in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund, or <code>null</code> if a matching fund could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Fund> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funds before and after the current fund in the ordered set where groupId = &#63;.
	 *
	 * @param fundId the primary key of the current fund
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundException if a fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund[] findByGroupId_PrevAndNext(long fundId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFundException, SystemException {
		Fund fund = findByPrimaryKey(fundId);

		Session session = null;

		try {
			session = openSession();

			Fund[] array = new FundImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, fund, groupId,
					orderByComparator, true);

			array[1] = fund;

			array[2] = getByGroupId_PrevAndNext(session, fund, groupId,
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

	protected Fund getByGroupId_PrevAndNext(Session session, Fund fund,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUND_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(FundModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fund);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Fund> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funds where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Fund fund : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(fund);
		}
	}

	/**
	 * Returns the number of funds where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUND_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "fund.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundModelImpl.FINDER_CACHE_ENABLED, FundImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId_Status",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundModelImpl.FINDER_CACHE_ENABLED, FundImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() },
			FundModelImpl.GROUPID_COLUMN_BITMASK |
			FundModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_STATUS = new FinderPath(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the funds where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fund> findByGroupId_Status(long groupId, int status)
		throws SystemException {
		return findByGroupId_Status(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funds where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of funds
	 * @param end the upper bound of the range of funds (not inclusive)
	 * @return the range of matching funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fund> findByGroupId_Status(long groupId, int status, int start,
		int end) throws SystemException {
		return findByGroupId_Status(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funds where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of funds
	 * @param end the upper bound of the range of funds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fund> findByGroupId_Status(long groupId, int status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS;
			finderArgs = new Object[] { groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID_STATUS;
			finderArgs = new Object[] {
					groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<Fund> list = (List<Fund>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Fund fund : list) {
				if ((groupId != fund.getGroupId()) ||
						(status != fund.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_FUND_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FundModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<Fund>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Fund>(list);
				}
				else {
					list = (List<Fund>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first fund in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundException if a matching fund could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund findByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchFundException, SystemException {
		Fund fund = fetchByGroupId_Status_First(groupId, status,
				orderByComparator);

		if (fund != null) {
			return fund;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundException(msg.toString());
	}

	/**
	 * Returns the first fund in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund, or <code>null</code> if a matching fund could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund fetchByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Fund> list = findByGroupId_Status(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fund in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundException if a matching fund could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund findByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchFundException, SystemException {
		Fund fund = fetchByGroupId_Status_Last(groupId, status,
				orderByComparator);

		if (fund != null) {
			return fund;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundException(msg.toString());
	}

	/**
	 * Returns the last fund in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund, or <code>null</code> if a matching fund could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund fetchByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId_Status(groupId, status);

		if (count == 0) {
			return null;
		}

		List<Fund> list = findByGroupId_Status(groupId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funds before and after the current fund in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param fundId the primary key of the current fund
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundException if a fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund[] findByGroupId_Status_PrevAndNext(long fundId, long groupId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchFundException, SystemException {
		Fund fund = findByPrimaryKey(fundId);

		Session session = null;

		try {
			session = openSession();

			Fund[] array = new FundImpl[3];

			array[0] = getByGroupId_Status_PrevAndNext(session, fund, groupId,
					status, orderByComparator, true);

			array[1] = fund;

			array[2] = getByGroupId_Status_PrevAndNext(session, fund, groupId,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Fund getByGroupId_Status_PrevAndNext(Session session, Fund fund,
		long groupId, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUND_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_STATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPID_STATUS_STATUS_2);

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
			query.append(FundModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fund);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Fund> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funds where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId_Status(long groupId, int status)
		throws SystemException {
		for (Fund fund : findByGroupId_Status(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fund);
		}
	}

	/**
	 * Returns the number of funds where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId_Status(long groupId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID_STATUS;

		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FUND_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_GROUPID_STATUS_GROUPID_2 = "fund.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_STATUS_STATUS_2 = "fund.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID_BUDGETPERIODID =
		new FinderPath(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundModelImpl.FINDER_CACHE_ENABLED, FundImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId_BudgetPeriodId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_BUDGETPERIODID =
		new FinderPath(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundModelImpl.FINDER_CACHE_ENABLED, FundImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId_BudgetPeriodId",
			new String[] { Long.class.getName(), Long.class.getName() },
			FundModelImpl.GROUPID_COLUMN_BITMASK |
			FundModelImpl.BUDGETPERIODID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_BUDGETPERIODID = new FinderPath(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupId_BudgetPeriodId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the funds where groupId = &#63; and budgetPeriodId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param budgetPeriodId the budget period ID
	 * @return the matching funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fund> findByGroupId_BudgetPeriodId(long groupId,
		long budgetPeriodId) throws SystemException {
		return findByGroupId_BudgetPeriodId(groupId, budgetPeriodId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funds where groupId = &#63; and budgetPeriodId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param budgetPeriodId the budget period ID
	 * @param start the lower bound of the range of funds
	 * @param end the upper bound of the range of funds (not inclusive)
	 * @return the range of matching funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fund> findByGroupId_BudgetPeriodId(long groupId,
		long budgetPeriodId, int start, int end) throws SystemException {
		return findByGroupId_BudgetPeriodId(groupId, budgetPeriodId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the funds where groupId = &#63; and budgetPeriodId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param budgetPeriodId the budget period ID
	 * @param start the lower bound of the range of funds
	 * @param end the upper bound of the range of funds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fund> findByGroupId_BudgetPeriodId(long groupId,
		long budgetPeriodId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_BUDGETPERIODID;
			finderArgs = new Object[] { groupId, budgetPeriodId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID_BUDGETPERIODID;
			finderArgs = new Object[] {
					groupId, budgetPeriodId,
					
					start, end, orderByComparator
				};
		}

		List<Fund> list = (List<Fund>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Fund fund : list) {
				if ((groupId != fund.getGroupId()) ||
						(budgetPeriodId != fund.getBudgetPeriodId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_FUND_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_BUDGETPERIODID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_BUDGETPERIODID_BUDGETPERIODID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FundModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(budgetPeriodId);

				if (!pagination) {
					list = (List<Fund>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Fund>(list);
				}
				else {
					list = (List<Fund>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first fund in the ordered set where groupId = &#63; and budgetPeriodId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param budgetPeriodId the budget period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundException if a matching fund could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund findByGroupId_BudgetPeriodId_First(long groupId,
		long budgetPeriodId, OrderByComparator orderByComparator)
		throws NoSuchFundException, SystemException {
		Fund fund = fetchByGroupId_BudgetPeriodId_First(groupId,
				budgetPeriodId, orderByComparator);

		if (fund != null) {
			return fund;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", budgetPeriodId=");
		msg.append(budgetPeriodId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundException(msg.toString());
	}

	/**
	 * Returns the first fund in the ordered set where groupId = &#63; and budgetPeriodId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param budgetPeriodId the budget period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund, or <code>null</code> if a matching fund could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund fetchByGroupId_BudgetPeriodId_First(long groupId,
		long budgetPeriodId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Fund> list = findByGroupId_BudgetPeriodId(groupId, budgetPeriodId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fund in the ordered set where groupId = &#63; and budgetPeriodId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param budgetPeriodId the budget period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundException if a matching fund could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund findByGroupId_BudgetPeriodId_Last(long groupId,
		long budgetPeriodId, OrderByComparator orderByComparator)
		throws NoSuchFundException, SystemException {
		Fund fund = fetchByGroupId_BudgetPeriodId_Last(groupId, budgetPeriodId,
				orderByComparator);

		if (fund != null) {
			return fund;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", budgetPeriodId=");
		msg.append(budgetPeriodId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundException(msg.toString());
	}

	/**
	 * Returns the last fund in the ordered set where groupId = &#63; and budgetPeriodId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param budgetPeriodId the budget period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund, or <code>null</code> if a matching fund could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund fetchByGroupId_BudgetPeriodId_Last(long groupId,
		long budgetPeriodId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupId_BudgetPeriodId(groupId, budgetPeriodId);

		if (count == 0) {
			return null;
		}

		List<Fund> list = findByGroupId_BudgetPeriodId(groupId, budgetPeriodId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funds before and after the current fund in the ordered set where groupId = &#63; and budgetPeriodId = &#63;.
	 *
	 * @param fundId the primary key of the current fund
	 * @param groupId the group ID
	 * @param budgetPeriodId the budget period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundException if a fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund[] findByGroupId_BudgetPeriodId_PrevAndNext(long fundId,
		long groupId, long budgetPeriodId, OrderByComparator orderByComparator)
		throws NoSuchFundException, SystemException {
		Fund fund = findByPrimaryKey(fundId);

		Session session = null;

		try {
			session = openSession();

			Fund[] array = new FundImpl[3];

			array[0] = getByGroupId_BudgetPeriodId_PrevAndNext(session, fund,
					groupId, budgetPeriodId, orderByComparator, true);

			array[1] = fund;

			array[2] = getByGroupId_BudgetPeriodId_PrevAndNext(session, fund,
					groupId, budgetPeriodId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Fund getByGroupId_BudgetPeriodId_PrevAndNext(Session session,
		Fund fund, long groupId, long budgetPeriodId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUND_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_BUDGETPERIODID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPID_BUDGETPERIODID_BUDGETPERIODID_2);

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
			query.append(FundModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(budgetPeriodId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fund);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Fund> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funds where groupId = &#63; and budgetPeriodId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param budgetPeriodId the budget period ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId_BudgetPeriodId(long groupId, long budgetPeriodId)
		throws SystemException {
		for (Fund fund : findByGroupId_BudgetPeriodId(groupId, budgetPeriodId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fund);
		}
	}

	/**
	 * Returns the number of funds where groupId = &#63; and budgetPeriodId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param budgetPeriodId the budget period ID
	 * @return the number of matching funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId_BudgetPeriodId(long groupId, long budgetPeriodId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID_BUDGETPERIODID;

		Object[] finderArgs = new Object[] { groupId, budgetPeriodId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FUND_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_BUDGETPERIODID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_BUDGETPERIODID_BUDGETPERIODID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(budgetPeriodId);

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

	private static final String _FINDER_COLUMN_GROUPID_BUDGETPERIODID_GROUPID_2 = "fund.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_BUDGETPERIODID_BUDGETPERIODID_2 =
		"fund.budgetPeriodId = ?";

	public FundPersistenceImpl() {
		setModelClass(Fund.class);
	}

	/**
	 * Caches the fund in the entity cache if it is enabled.
	 *
	 * @param fund the fund
	 */
	@Override
	public void cacheResult(Fund fund) {
		EntityCacheUtil.putResult(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundImpl.class, fund.getPrimaryKey(), fund);

		fund.resetOriginalValues();
	}

	/**
	 * Caches the funds in the entity cache if it is enabled.
	 *
	 * @param funds the funds
	 */
	@Override
	public void cacheResult(List<Fund> funds) {
		for (Fund fund : funds) {
			if (EntityCacheUtil.getResult(FundModelImpl.ENTITY_CACHE_ENABLED,
						FundImpl.class, fund.getPrimaryKey()) == null) {
				cacheResult(fund);
			}
			else {
				fund.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all funds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FundImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FundImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fund.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Fund fund) {
		EntityCacheUtil.removeResult(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundImpl.class, fund.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Fund> funds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Fund fund : funds) {
			EntityCacheUtil.removeResult(FundModelImpl.ENTITY_CACHE_ENABLED,
				FundImpl.class, fund.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fund with the primary key. Does not add the fund to the database.
	 *
	 * @param fundId the primary key for the new fund
	 * @return the new fund
	 */
	@Override
	public Fund create(long fundId) {
		Fund fund = new FundImpl();

		fund.setNew(true);
		fund.setPrimaryKey(fundId);

		return fund;
	}

	/**
	 * Removes the fund with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fundId the primary key of the fund
	 * @return the fund that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundException if a fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund remove(long fundId) throws NoSuchFundException, SystemException {
		return remove((Serializable)fundId);
	}

	/**
	 * Removes the fund with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fund
	 * @return the fund that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundException if a fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund remove(Serializable primaryKey)
		throws NoSuchFundException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Fund fund = (Fund)session.get(FundImpl.class, primaryKey);

			if (fund == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFundException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(fund);
		}
		catch (NoSuchFundException nsee) {
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
	protected Fund removeImpl(Fund fund) throws SystemException {
		fund = toUnwrappedModel(fund);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fund)) {
				fund = (Fund)session.get(FundImpl.class, fund.getPrimaryKeyObj());
			}

			if (fund != null) {
				session.delete(fund);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (fund != null) {
			clearCache(fund);
		}

		return fund;
	}

	@Override
	public Fund updateImpl(cmr.fandenatech.ndjangui.model.Fund fund)
		throws SystemException {
		fund = toUnwrappedModel(fund);

		boolean isNew = fund.isNew();

		FundModelImpl fundModelImpl = (FundModelImpl)fund;

		Session session = null;

		try {
			session = openSession();

			if (fund.isNew()) {
				session.save(fund);

				fund.setNew(false);
			}
			else {
				session.merge(fund);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FundModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((fundModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { fundModelImpl.getOriginalGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { fundModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((fundModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundModelImpl.getOriginalGroupId(),
						fundModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);

				args = new Object[] {
						fundModelImpl.getGroupId(), fundModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);
			}

			if ((fundModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_BUDGETPERIODID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundModelImpl.getOriginalGroupId(),
						fundModelImpl.getOriginalBudgetPeriodId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_BUDGETPERIODID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_BUDGETPERIODID,
					args);

				args = new Object[] {
						fundModelImpl.getGroupId(),
						fundModelImpl.getBudgetPeriodId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_BUDGETPERIODID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_BUDGETPERIODID,
					args);
			}
		}

		EntityCacheUtil.putResult(FundModelImpl.ENTITY_CACHE_ENABLED,
			FundImpl.class, fund.getPrimaryKey(), fund);

		return fund;
	}

	protected Fund toUnwrappedModel(Fund fund) {
		if (fund instanceof FundImpl) {
			return fund;
		}

		FundImpl fundImpl = new FundImpl();

		fundImpl.setNew(fund.isNew());
		fundImpl.setPrimaryKey(fund.getPrimaryKey());

		fundImpl.setFundId(fund.getFundId());
		fundImpl.setUserId(fund.getUserId());
		fundImpl.setGroupId(fund.getGroupId());
		fundImpl.setCompanyId(fund.getCompanyId());
		fundImpl.setUserName(fund.getUserName());
		fundImpl.setCreateDate(fund.getCreateDate());
		fundImpl.setModifiedDate(fund.getModifiedDate());
		fundImpl.setBudgetPeriodId(fund.getBudgetPeriodId());
		fundImpl.setName(fund.getName());
		fundImpl.setShortDescription(fund.getShortDescription());
		fundImpl.setFundTypeId(fund.getFundTypeId());
		fundImpl.setFundType(fund.getFundType());
		fundImpl.setStatus(fund.getStatus());

		return fundImpl;
	}

	/**
	 * Returns the fund with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fund
	 * @return the fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundException if a fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFundException, SystemException {
		Fund fund = fetchByPrimaryKey(primaryKey);

		if (fund == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFundException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return fund;
	}

	/**
	 * Returns the fund with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchFundException} if it could not be found.
	 *
	 * @param fundId the primary key of the fund
	 * @return the fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundException if a fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund findByPrimaryKey(long fundId)
		throws NoSuchFundException, SystemException {
		return findByPrimaryKey((Serializable)fundId);
	}

	/**
	 * Returns the fund with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fund
	 * @return the fund, or <code>null</code> if a fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Fund fund = (Fund)EntityCacheUtil.getResult(FundModelImpl.ENTITY_CACHE_ENABLED,
				FundImpl.class, primaryKey);

		if (fund == _nullFund) {
			return null;
		}

		if (fund == null) {
			Session session = null;

			try {
				session = openSession();

				fund = (Fund)session.get(FundImpl.class, primaryKey);

				if (fund != null) {
					cacheResult(fund);
				}
				else {
					EntityCacheUtil.putResult(FundModelImpl.ENTITY_CACHE_ENABLED,
						FundImpl.class, primaryKey, _nullFund);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FundModelImpl.ENTITY_CACHE_ENABLED,
					FundImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return fund;
	}

	/**
	 * Returns the fund with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fundId the primary key of the fund
	 * @return the fund, or <code>null</code> if a fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Fund fetchByPrimaryKey(long fundId) throws SystemException {
		return fetchByPrimaryKey((Serializable)fundId);
	}

	/**
	 * Returns all the funds.
	 *
	 * @return the funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fund> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of funds
	 * @param end the upper bound of the range of funds (not inclusive)
	 * @return the range of funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fund> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the funds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of funds
	 * @param end the upper bound of the range of funds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Fund> findAll(int start, int end,
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

		List<Fund> list = (List<Fund>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FUND);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FUND;

				if (pagination) {
					sql = sql.concat(FundModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Fund>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Fund>(list);
				}
				else {
					list = (List<Fund>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the funds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Fund fund : findAll()) {
			remove(fund);
		}
	}

	/**
	 * Returns the number of funds.
	 *
	 * @return the number of funds
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

				Query q = session.createQuery(_SQL_COUNT_FUND);

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
	 * Initializes the fund persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.cmr.fandenatech.ndjangui.model.Fund")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Fund>> listenersList = new ArrayList<ModelListener<Fund>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Fund>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FundImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FUND = "SELECT fund FROM Fund fund";
	private static final String _SQL_SELECT_FUND_WHERE = "SELECT fund FROM Fund fund WHERE ";
	private static final String _SQL_COUNT_FUND = "SELECT COUNT(fund) FROM Fund fund";
	private static final String _SQL_COUNT_FUND_WHERE = "SELECT COUNT(fund) FROM Fund fund WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "fund.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Fund exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Fund exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FundPersistenceImpl.class);
	private static Fund _nullFund = new FundImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Fund> toCacheModel() {
				return _nullFundCacheModel;
			}
		};

	private static CacheModel<Fund> _nullFundCacheModel = new CacheModel<Fund>() {
			@Override
			public Fund toEntityModel() {
				return _nullFund;
			}
		};
}