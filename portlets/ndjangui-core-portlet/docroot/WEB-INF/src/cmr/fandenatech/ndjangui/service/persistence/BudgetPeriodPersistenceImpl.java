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

import cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException;
import cmr.fandenatech.ndjangui.model.BudgetPeriod;
import cmr.fandenatech.ndjangui.model.impl.BudgetPeriodImpl;
import cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl;

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
 * The persistence implementation for the budget period service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see BudgetPeriodPersistence
 * @see BudgetPeriodUtil
 * @generated
 */
public class BudgetPeriodPersistenceImpl extends BasePersistenceImpl<BudgetPeriod>
	implements BudgetPeriodPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BudgetPeriodUtil} to access the budget period persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BudgetPeriodImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
			BudgetPeriodModelImpl.FINDER_CACHE_ENABLED, BudgetPeriodImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
			BudgetPeriodModelImpl.FINDER_CACHE_ENABLED, BudgetPeriodImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
			BudgetPeriodModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
			BudgetPeriodModelImpl.FINDER_CACHE_ENABLED, BudgetPeriodImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
			BudgetPeriodModelImpl.FINDER_CACHE_ENABLED, BudgetPeriodImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			BudgetPeriodModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
			BudgetPeriodModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the budget periods where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching budget periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BudgetPeriod> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the budget periods where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget periods
	 * @param end the upper bound of the range of budget periods (not inclusive)
	 * @return the range of matching budget periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BudgetPeriod> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the budget periods where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget periods
	 * @param end the upper bound of the range of budget periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BudgetPeriod> findByGroupId(long groupId, int start, int end,
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

		List<BudgetPeriod> list = (List<BudgetPeriod>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BudgetPeriod budgetPeriod : list) {
				if ((groupId != budgetPeriod.getGroupId())) {
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

			query.append(_SQL_SELECT_BUDGETPERIOD_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BudgetPeriodModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<BudgetPeriod>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BudgetPeriod>(list);
				}
				else {
					list = (List<BudgetPeriod>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first budget period in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget period
	 * @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a matching budget period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBudgetPeriodException, SystemException {
		BudgetPeriod budgetPeriod = fetchByGroupId_First(groupId,
				orderByComparator);

		if (budgetPeriod != null) {
			return budgetPeriod;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBudgetPeriodException(msg.toString());
	}

	/**
	 * Returns the first budget period in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget period, or <code>null</code> if a matching budget period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BudgetPeriod> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last budget period in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget period
	 * @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a matching budget period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBudgetPeriodException, SystemException {
		BudgetPeriod budgetPeriod = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (budgetPeriod != null) {
			return budgetPeriod;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBudgetPeriodException(msg.toString());
	}

	/**
	 * Returns the last budget period in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget period, or <code>null</code> if a matching budget period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<BudgetPeriod> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the budget periods before and after the current budget period in the ordered set where groupId = &#63;.
	 *
	 * @param budgetPeriodId the primary key of the current budget period
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget period
	 * @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a budget period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod[] findByGroupId_PrevAndNext(long budgetPeriodId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchBudgetPeriodException, SystemException {
		BudgetPeriod budgetPeriod = findByPrimaryKey(budgetPeriodId);

		Session session = null;

		try {
			session = openSession();

			BudgetPeriod[] array = new BudgetPeriodImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, budgetPeriod, groupId,
					orderByComparator, true);

			array[1] = budgetPeriod;

			array[2] = getByGroupId_PrevAndNext(session, budgetPeriod, groupId,
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

	protected BudgetPeriod getByGroupId_PrevAndNext(Session session,
		BudgetPeriod budgetPeriod, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUDGETPERIOD_WHERE);

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
			query.append(BudgetPeriodModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(budgetPeriod);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BudgetPeriod> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the budget periods where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (BudgetPeriod budgetPeriod : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(budgetPeriod);
		}
	}

	/**
	 * Returns the number of budget periods where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching budget periods
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

			query.append(_SQL_COUNT_BUDGETPERIOD_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "budgetPeriod.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
			BudgetPeriodModelImpl.FINDER_CACHE_ENABLED, BudgetPeriodImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId_Status",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
			BudgetPeriodModelImpl.FINDER_CACHE_ENABLED, BudgetPeriodImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() },
			BudgetPeriodModelImpl.GROUPID_COLUMN_BITMASK |
			BudgetPeriodModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_STATUS = new FinderPath(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
			BudgetPeriodModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the budget periods where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching budget periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BudgetPeriod> findByGroupId_Status(long groupId, int status)
		throws SystemException {
		return findByGroupId_Status(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the budget periods where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of budget periods
	 * @param end the upper bound of the range of budget periods (not inclusive)
	 * @return the range of matching budget periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BudgetPeriod> findByGroupId_Status(long groupId, int status,
		int start, int end) throws SystemException {
		return findByGroupId_Status(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the budget periods where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of budget periods
	 * @param end the upper bound of the range of budget periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BudgetPeriod> findByGroupId_Status(long groupId, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<BudgetPeriod> list = (List<BudgetPeriod>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BudgetPeriod budgetPeriod : list) {
				if ((groupId != budgetPeriod.getGroupId()) ||
						(status != budgetPeriod.getStatus())) {
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

			query.append(_SQL_SELECT_BUDGETPERIOD_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BudgetPeriodModelImpl.ORDER_BY_JPQL);
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
					list = (List<BudgetPeriod>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BudgetPeriod>(list);
				}
				else {
					list = (List<BudgetPeriod>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first budget period in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget period
	 * @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a matching budget period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod findByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchBudgetPeriodException, SystemException {
		BudgetPeriod budgetPeriod = fetchByGroupId_Status_First(groupId,
				status, orderByComparator);

		if (budgetPeriod != null) {
			return budgetPeriod;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBudgetPeriodException(msg.toString());
	}

	/**
	 * Returns the first budget period in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget period, or <code>null</code> if a matching budget period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod fetchByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<BudgetPeriod> list = findByGroupId_Status(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last budget period in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget period
	 * @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a matching budget period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod findByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchBudgetPeriodException, SystemException {
		BudgetPeriod budgetPeriod = fetchByGroupId_Status_Last(groupId, status,
				orderByComparator);

		if (budgetPeriod != null) {
			return budgetPeriod;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBudgetPeriodException(msg.toString());
	}

	/**
	 * Returns the last budget period in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget period, or <code>null</code> if a matching budget period could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod fetchByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId_Status(groupId, status);

		if (count == 0) {
			return null;
		}

		List<BudgetPeriod> list = findByGroupId_Status(groupId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the budget periods before and after the current budget period in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param budgetPeriodId the primary key of the current budget period
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget period
	 * @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a budget period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod[] findByGroupId_Status_PrevAndNext(
		long budgetPeriodId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchBudgetPeriodException, SystemException {
		BudgetPeriod budgetPeriod = findByPrimaryKey(budgetPeriodId);

		Session session = null;

		try {
			session = openSession();

			BudgetPeriod[] array = new BudgetPeriodImpl[3];

			array[0] = getByGroupId_Status_PrevAndNext(session, budgetPeriod,
					groupId, status, orderByComparator, true);

			array[1] = budgetPeriod;

			array[2] = getByGroupId_Status_PrevAndNext(session, budgetPeriod,
					groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BudgetPeriod getByGroupId_Status_PrevAndNext(Session session,
		BudgetPeriod budgetPeriod, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUDGETPERIOD_WHERE);

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
			query.append(BudgetPeriodModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(budgetPeriod);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BudgetPeriod> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the budget periods where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId_Status(long groupId, int status)
		throws SystemException {
		for (BudgetPeriod budgetPeriod : findByGroupId_Status(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(budgetPeriod);
		}
	}

	/**
	 * Returns the number of budget periods where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching budget periods
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

			query.append(_SQL_COUNT_BUDGETPERIOD_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_STATUS_GROUPID_2 = "budgetPeriod.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_STATUS_STATUS_2 = "budgetPeriod.status = ?";

	public BudgetPeriodPersistenceImpl() {
		setModelClass(BudgetPeriod.class);
	}

	/**
	 * Caches the budget period in the entity cache if it is enabled.
	 *
	 * @param budgetPeriod the budget period
	 */
	@Override
	public void cacheResult(BudgetPeriod budgetPeriod) {
		EntityCacheUtil.putResult(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
			BudgetPeriodImpl.class, budgetPeriod.getPrimaryKey(), budgetPeriod);

		budgetPeriod.resetOriginalValues();
	}

	/**
	 * Caches the budget periods in the entity cache if it is enabled.
	 *
	 * @param budgetPeriods the budget periods
	 */
	@Override
	public void cacheResult(List<BudgetPeriod> budgetPeriods) {
		for (BudgetPeriod budgetPeriod : budgetPeriods) {
			if (EntityCacheUtil.getResult(
						BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
						BudgetPeriodImpl.class, budgetPeriod.getPrimaryKey()) == null) {
				cacheResult(budgetPeriod);
			}
			else {
				budgetPeriod.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all budget periods.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BudgetPeriodImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BudgetPeriodImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the budget period.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BudgetPeriod budgetPeriod) {
		EntityCacheUtil.removeResult(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
			BudgetPeriodImpl.class, budgetPeriod.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BudgetPeriod> budgetPeriods) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BudgetPeriod budgetPeriod : budgetPeriods) {
			EntityCacheUtil.removeResult(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
				BudgetPeriodImpl.class, budgetPeriod.getPrimaryKey());
		}
	}

	/**
	 * Creates a new budget period with the primary key. Does not add the budget period to the database.
	 *
	 * @param budgetPeriodId the primary key for the new budget period
	 * @return the new budget period
	 */
	@Override
	public BudgetPeriod create(long budgetPeriodId) {
		BudgetPeriod budgetPeriod = new BudgetPeriodImpl();

		budgetPeriod.setNew(true);
		budgetPeriod.setPrimaryKey(budgetPeriodId);

		return budgetPeriod;
	}

	/**
	 * Removes the budget period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param budgetPeriodId the primary key of the budget period
	 * @return the budget period that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a budget period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod remove(long budgetPeriodId)
		throws NoSuchBudgetPeriodException, SystemException {
		return remove((Serializable)budgetPeriodId);
	}

	/**
	 * Removes the budget period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the budget period
	 * @return the budget period that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a budget period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod remove(Serializable primaryKey)
		throws NoSuchBudgetPeriodException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BudgetPeriod budgetPeriod = (BudgetPeriod)session.get(BudgetPeriodImpl.class,
					primaryKey);

			if (budgetPeriod == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBudgetPeriodException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(budgetPeriod);
		}
		catch (NoSuchBudgetPeriodException nsee) {
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
	protected BudgetPeriod removeImpl(BudgetPeriod budgetPeriod)
		throws SystemException {
		budgetPeriod = toUnwrappedModel(budgetPeriod);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(budgetPeriod)) {
				budgetPeriod = (BudgetPeriod)session.get(BudgetPeriodImpl.class,
						budgetPeriod.getPrimaryKeyObj());
			}

			if (budgetPeriod != null) {
				session.delete(budgetPeriod);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (budgetPeriod != null) {
			clearCache(budgetPeriod);
		}

		return budgetPeriod;
	}

	@Override
	public BudgetPeriod updateImpl(
		cmr.fandenatech.ndjangui.model.BudgetPeriod budgetPeriod)
		throws SystemException {
		budgetPeriod = toUnwrappedModel(budgetPeriod);

		boolean isNew = budgetPeriod.isNew();

		BudgetPeriodModelImpl budgetPeriodModelImpl = (BudgetPeriodModelImpl)budgetPeriod;

		Session session = null;

		try {
			session = openSession();

			if (budgetPeriod.isNew()) {
				session.save(budgetPeriod);

				budgetPeriod.setNew(false);
			}
			else {
				session.merge(budgetPeriod);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BudgetPeriodModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((budgetPeriodModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						budgetPeriodModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { budgetPeriodModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((budgetPeriodModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						budgetPeriodModelImpl.getOriginalGroupId(),
						budgetPeriodModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);

				args = new Object[] {
						budgetPeriodModelImpl.getGroupId(),
						budgetPeriodModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
			BudgetPeriodImpl.class, budgetPeriod.getPrimaryKey(), budgetPeriod);

		return budgetPeriod;
	}

	protected BudgetPeriod toUnwrappedModel(BudgetPeriod budgetPeriod) {
		if (budgetPeriod instanceof BudgetPeriodImpl) {
			return budgetPeriod;
		}

		BudgetPeriodImpl budgetPeriodImpl = new BudgetPeriodImpl();

		budgetPeriodImpl.setNew(budgetPeriod.isNew());
		budgetPeriodImpl.setPrimaryKey(budgetPeriod.getPrimaryKey());

		budgetPeriodImpl.setBudgetPeriodId(budgetPeriod.getBudgetPeriodId());
		budgetPeriodImpl.setUserId(budgetPeriod.getUserId());
		budgetPeriodImpl.setGroupId(budgetPeriod.getGroupId());
		budgetPeriodImpl.setCompanyId(budgetPeriod.getCompanyId());
		budgetPeriodImpl.setUserName(budgetPeriod.getUserName());
		budgetPeriodImpl.setCreateDate(budgetPeriod.getCreateDate());
		budgetPeriodImpl.setModifiedDate(budgetPeriod.getModifiedDate());
		budgetPeriodImpl.setName(budgetPeriod.getName());
		budgetPeriodImpl.setShortDescription(budgetPeriod.getShortDescription());
		budgetPeriodImpl.setStartDate(budgetPeriod.getStartDate());
		budgetPeriodImpl.setEndDate(budgetPeriod.getEndDate());
		budgetPeriodImpl.setStatus(budgetPeriod.getStatus());

		return budgetPeriodImpl;
	}

	/**
	 * Returns the budget period with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the budget period
	 * @return the budget period
	 * @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a budget period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBudgetPeriodException, SystemException {
		BudgetPeriod budgetPeriod = fetchByPrimaryKey(primaryKey);

		if (budgetPeriod == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBudgetPeriodException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return budgetPeriod;
	}

	/**
	 * Returns the budget period with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException} if it could not be found.
	 *
	 * @param budgetPeriodId the primary key of the budget period
	 * @return the budget period
	 * @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a budget period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod findByPrimaryKey(long budgetPeriodId)
		throws NoSuchBudgetPeriodException, SystemException {
		return findByPrimaryKey((Serializable)budgetPeriodId);
	}

	/**
	 * Returns the budget period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the budget period
	 * @return the budget period, or <code>null</code> if a budget period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BudgetPeriod budgetPeriod = (BudgetPeriod)EntityCacheUtil.getResult(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
				BudgetPeriodImpl.class, primaryKey);

		if (budgetPeriod == _nullBudgetPeriod) {
			return null;
		}

		if (budgetPeriod == null) {
			Session session = null;

			try {
				session = openSession();

				budgetPeriod = (BudgetPeriod)session.get(BudgetPeriodImpl.class,
						primaryKey);

				if (budgetPeriod != null) {
					cacheResult(budgetPeriod);
				}
				else {
					EntityCacheUtil.putResult(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
						BudgetPeriodImpl.class, primaryKey, _nullBudgetPeriod);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BudgetPeriodModelImpl.ENTITY_CACHE_ENABLED,
					BudgetPeriodImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return budgetPeriod;
	}

	/**
	 * Returns the budget period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param budgetPeriodId the primary key of the budget period
	 * @return the budget period, or <code>null</code> if a budget period with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BudgetPeriod fetchByPrimaryKey(long budgetPeriodId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)budgetPeriodId);
	}

	/**
	 * Returns all the budget periods.
	 *
	 * @return the budget periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BudgetPeriod> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the budget periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget periods
	 * @param end the upper bound of the range of budget periods (not inclusive)
	 * @return the range of budget periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BudgetPeriod> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the budget periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget periods
	 * @param end the upper bound of the range of budget periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of budget periods
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BudgetPeriod> findAll(int start, int end,
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

		List<BudgetPeriod> list = (List<BudgetPeriod>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BUDGETPERIOD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BUDGETPERIOD;

				if (pagination) {
					sql = sql.concat(BudgetPeriodModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BudgetPeriod>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BudgetPeriod>(list);
				}
				else {
					list = (List<BudgetPeriod>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the budget periods from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BudgetPeriod budgetPeriod : findAll()) {
			remove(budgetPeriod);
		}
	}

	/**
	 * Returns the number of budget periods.
	 *
	 * @return the number of budget periods
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

				Query q = session.createQuery(_SQL_COUNT_BUDGETPERIOD);

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
	 * Initializes the budget period persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.cmr.fandenatech.ndjangui.model.BudgetPeriod")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BudgetPeriod>> listenersList = new ArrayList<ModelListener<BudgetPeriod>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BudgetPeriod>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BudgetPeriodImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BUDGETPERIOD = "SELECT budgetPeriod FROM BudgetPeriod budgetPeriod";
	private static final String _SQL_SELECT_BUDGETPERIOD_WHERE = "SELECT budgetPeriod FROM BudgetPeriod budgetPeriod WHERE ";
	private static final String _SQL_COUNT_BUDGETPERIOD = "SELECT COUNT(budgetPeriod) FROM BudgetPeriod budgetPeriod";
	private static final String _SQL_COUNT_BUDGETPERIOD_WHERE = "SELECT COUNT(budgetPeriod) FROM BudgetPeriod budgetPeriod WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "budgetPeriod.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BudgetPeriod exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BudgetPeriod exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BudgetPeriodPersistenceImpl.class);
	private static BudgetPeriod _nullBudgetPeriod = new BudgetPeriodImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BudgetPeriod> toCacheModel() {
				return _nullBudgetPeriodCacheModel;
			}
		};

	private static CacheModel<BudgetPeriod> _nullBudgetPeriodCacheModel = new CacheModel<BudgetPeriod>() {
			@Override
			public BudgetPeriod toEntityModel() {
				return _nullBudgetPeriod;
			}
		};
}