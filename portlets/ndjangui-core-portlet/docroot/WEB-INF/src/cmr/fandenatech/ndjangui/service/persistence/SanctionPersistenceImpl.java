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

import cmr.fandenatech.ndjangui.NoSuchSanctionException;
import cmr.fandenatech.ndjangui.model.Sanction;
import cmr.fandenatech.ndjangui.model.impl.SanctionImpl;
import cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl;

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
 * The persistence implementation for the sanction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see SanctionPersistence
 * @see SanctionUtil
 * @generated
 */
public class SanctionPersistenceImpl extends BasePersistenceImpl<Sanction>
	implements SanctionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SanctionUtil} to access the sanction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SanctionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SanctionModelImpl.ENTITY_CACHE_ENABLED,
			SanctionModelImpl.FINDER_CACHE_ENABLED, SanctionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SanctionModelImpl.ENTITY_CACHE_ENABLED,
			SanctionModelImpl.FINDER_CACHE_ENABLED, SanctionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SanctionModelImpl.ENTITY_CACHE_ENABLED,
			SanctionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(SanctionModelImpl.ENTITY_CACHE_ENABLED,
			SanctionModelImpl.FINDER_CACHE_ENABLED, SanctionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(SanctionModelImpl.ENTITY_CACHE_ENABLED,
			SanctionModelImpl.FINDER_CACHE_ENABLED, SanctionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			SanctionModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SanctionModelImpl.ENTITY_CACHE_ENABLED,
			SanctionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the sanctions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching sanctions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sanction> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sanctions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sanctions
	 * @param end the upper bound of the range of sanctions (not inclusive)
	 * @return the range of matching sanctions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sanction> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sanctions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sanctions
	 * @param end the upper bound of the range of sanctions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sanctions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sanction> findByGroupId(long groupId, int start, int end,
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

		List<Sanction> list = (List<Sanction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Sanction sanction : list) {
				if ((groupId != sanction.getGroupId())) {
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

			query.append(_SQL_SELECT_SANCTION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SanctionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Sanction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Sanction>(list);
				}
				else {
					list = (List<Sanction>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first sanction in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sanction
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a matching sanction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSanctionException, SystemException {
		Sanction sanction = fetchByGroupId_First(groupId, orderByComparator);

		if (sanction != null) {
			return sanction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSanctionException(msg.toString());
	}

	/**
	 * Returns the first sanction in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sanction, or <code>null</code> if a matching sanction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Sanction> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sanction in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sanction
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a matching sanction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSanctionException, SystemException {
		Sanction sanction = fetchByGroupId_Last(groupId, orderByComparator);

		if (sanction != null) {
			return sanction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSanctionException(msg.toString());
	}

	/**
	 * Returns the last sanction in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sanction, or <code>null</code> if a matching sanction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Sanction> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sanctions before and after the current sanction in the ordered set where groupId = &#63;.
	 *
	 * @param sanctionId the primary key of the current sanction
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sanction
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a sanction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction[] findByGroupId_PrevAndNext(long sanctionId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSanctionException, SystemException {
		Sanction sanction = findByPrimaryKey(sanctionId);

		Session session = null;

		try {
			session = openSession();

			Sanction[] array = new SanctionImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, sanction, groupId,
					orderByComparator, true);

			array[1] = sanction;

			array[2] = getByGroupId_PrevAndNext(session, sanction, groupId,
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

	protected Sanction getByGroupId_PrevAndNext(Session session,
		Sanction sanction, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SANCTION_WHERE);

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
			query.append(SanctionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sanction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Sanction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sanctions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Sanction sanction : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(sanction);
		}
	}

	/**
	 * Returns the number of sanctions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching sanctions
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

			query.append(_SQL_COUNT_SANCTION_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "sanction.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(SanctionModelImpl.ENTITY_CACHE_ENABLED,
			SanctionModelImpl.FINDER_CACHE_ENABLED, SanctionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId_Status",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(SanctionModelImpl.ENTITY_CACHE_ENABLED,
			SanctionModelImpl.FINDER_CACHE_ENABLED, SanctionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() },
			SanctionModelImpl.GROUPID_COLUMN_BITMASK |
			SanctionModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_STATUS = new FinderPath(SanctionModelImpl.ENTITY_CACHE_ENABLED,
			SanctionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the sanctions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching sanctions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sanction> findByGroupId_Status(long groupId, int status)
		throws SystemException {
		return findByGroupId_Status(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sanctions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of sanctions
	 * @param end the upper bound of the range of sanctions (not inclusive)
	 * @return the range of matching sanctions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sanction> findByGroupId_Status(long groupId, int status,
		int start, int end) throws SystemException {
		return findByGroupId_Status(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sanctions where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of sanctions
	 * @param end the upper bound of the range of sanctions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sanctions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sanction> findByGroupId_Status(long groupId, int status,
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

		List<Sanction> list = (List<Sanction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Sanction sanction : list) {
				if ((groupId != sanction.getGroupId()) ||
						(status != sanction.getStatus())) {
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

			query.append(_SQL_SELECT_SANCTION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SanctionModelImpl.ORDER_BY_JPQL);
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
					list = (List<Sanction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Sanction>(list);
				}
				else {
					list = (List<Sanction>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first sanction in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sanction
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a matching sanction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction findByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchSanctionException, SystemException {
		Sanction sanction = fetchByGroupId_Status_First(groupId, status,
				orderByComparator);

		if (sanction != null) {
			return sanction;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSanctionException(msg.toString());
	}

	/**
	 * Returns the first sanction in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sanction, or <code>null</code> if a matching sanction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction fetchByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Sanction> list = findByGroupId_Status(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sanction in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sanction
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a matching sanction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction findByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchSanctionException, SystemException {
		Sanction sanction = fetchByGroupId_Status_Last(groupId, status,
				orderByComparator);

		if (sanction != null) {
			return sanction;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSanctionException(msg.toString());
	}

	/**
	 * Returns the last sanction in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sanction, or <code>null</code> if a matching sanction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction fetchByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId_Status(groupId, status);

		if (count == 0) {
			return null;
		}

		List<Sanction> list = findByGroupId_Status(groupId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sanctions before and after the current sanction in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param sanctionId the primary key of the current sanction
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sanction
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a sanction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction[] findByGroupId_Status_PrevAndNext(long sanctionId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws NoSuchSanctionException, SystemException {
		Sanction sanction = findByPrimaryKey(sanctionId);

		Session session = null;

		try {
			session = openSession();

			Sanction[] array = new SanctionImpl[3];

			array[0] = getByGroupId_Status_PrevAndNext(session, sanction,
					groupId, status, orderByComparator, true);

			array[1] = sanction;

			array[2] = getByGroupId_Status_PrevAndNext(session, sanction,
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

	protected Sanction getByGroupId_Status_PrevAndNext(Session session,
		Sanction sanction, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SANCTION_WHERE);

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
			query.append(SanctionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sanction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Sanction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sanctions where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId_Status(long groupId, int status)
		throws SystemException {
		for (Sanction sanction : findByGroupId_Status(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sanction);
		}
	}

	/**
	 * Returns the number of sanctions where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching sanctions
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

			query.append(_SQL_COUNT_SANCTION_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_STATUS_GROUPID_2 = "sanction.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_STATUS_STATUS_2 = "sanction.status = ?";

	public SanctionPersistenceImpl() {
		setModelClass(Sanction.class);
	}

	/**
	 * Caches the sanction in the entity cache if it is enabled.
	 *
	 * @param sanction the sanction
	 */
	@Override
	public void cacheResult(Sanction sanction) {
		EntityCacheUtil.putResult(SanctionModelImpl.ENTITY_CACHE_ENABLED,
			SanctionImpl.class, sanction.getPrimaryKey(), sanction);

		sanction.resetOriginalValues();
	}

	/**
	 * Caches the sanctions in the entity cache if it is enabled.
	 *
	 * @param sanctions the sanctions
	 */
	@Override
	public void cacheResult(List<Sanction> sanctions) {
		for (Sanction sanction : sanctions) {
			if (EntityCacheUtil.getResult(
						SanctionModelImpl.ENTITY_CACHE_ENABLED,
						SanctionImpl.class, sanction.getPrimaryKey()) == null) {
				cacheResult(sanction);
			}
			else {
				sanction.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sanctions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SanctionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SanctionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sanction.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Sanction sanction) {
		EntityCacheUtil.removeResult(SanctionModelImpl.ENTITY_CACHE_ENABLED,
			SanctionImpl.class, sanction.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Sanction> sanctions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Sanction sanction : sanctions) {
			EntityCacheUtil.removeResult(SanctionModelImpl.ENTITY_CACHE_ENABLED,
				SanctionImpl.class, sanction.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sanction with the primary key. Does not add the sanction to the database.
	 *
	 * @param sanctionId the primary key for the new sanction
	 * @return the new sanction
	 */
	@Override
	public Sanction create(long sanctionId) {
		Sanction sanction = new SanctionImpl();

		sanction.setNew(true);
		sanction.setPrimaryKey(sanctionId);

		return sanction;
	}

	/**
	 * Removes the sanction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sanctionId the primary key of the sanction
	 * @return the sanction that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a sanction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction remove(long sanctionId)
		throws NoSuchSanctionException, SystemException {
		return remove((Serializable)sanctionId);
	}

	/**
	 * Removes the sanction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sanction
	 * @return the sanction that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a sanction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction remove(Serializable primaryKey)
		throws NoSuchSanctionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Sanction sanction = (Sanction)session.get(SanctionImpl.class,
					primaryKey);

			if (sanction == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSanctionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sanction);
		}
		catch (NoSuchSanctionException nsee) {
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
	protected Sanction removeImpl(Sanction sanction) throws SystemException {
		sanction = toUnwrappedModel(sanction);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sanction)) {
				sanction = (Sanction)session.get(SanctionImpl.class,
						sanction.getPrimaryKeyObj());
			}

			if (sanction != null) {
				session.delete(sanction);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sanction != null) {
			clearCache(sanction);
		}

		return sanction;
	}

	@Override
	public Sanction updateImpl(cmr.fandenatech.ndjangui.model.Sanction sanction)
		throws SystemException {
		sanction = toUnwrappedModel(sanction);

		boolean isNew = sanction.isNew();

		SanctionModelImpl sanctionModelImpl = (SanctionModelImpl)sanction;

		Session session = null;

		try {
			session = openSession();

			if (sanction.isNew()) {
				session.save(sanction);

				sanction.setNew(false);
			}
			else {
				session.merge(sanction);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SanctionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((sanctionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sanctionModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { sanctionModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((sanctionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sanctionModelImpl.getOriginalGroupId(),
						sanctionModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);

				args = new Object[] {
						sanctionModelImpl.getGroupId(),
						sanctionModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(SanctionModelImpl.ENTITY_CACHE_ENABLED,
			SanctionImpl.class, sanction.getPrimaryKey(), sanction);

		return sanction;
	}

	protected Sanction toUnwrappedModel(Sanction sanction) {
		if (sanction instanceof SanctionImpl) {
			return sanction;
		}

		SanctionImpl sanctionImpl = new SanctionImpl();

		sanctionImpl.setNew(sanction.isNew());
		sanctionImpl.setPrimaryKey(sanction.getPrimaryKey());

		sanctionImpl.setSanctionId(sanction.getSanctionId());
		sanctionImpl.setUserId(sanction.getUserId());
		sanctionImpl.setGroupId(sanction.getGroupId());
		sanctionImpl.setCompanyId(sanction.getCompanyId());
		sanctionImpl.setUserName(sanction.getUserName());
		sanctionImpl.setCreateDate(sanction.getCreateDate());
		sanctionImpl.setModifiedDate(sanction.getModifiedDate());
		sanctionImpl.setMemberId(sanction.getMemberId());
		sanctionImpl.setBudgetPeriodId(sanction.getBudgetPeriodId());
		sanctionImpl.setName(sanction.getName());
		sanctionImpl.setShortDescription(sanction.getShortDescription());
		sanctionImpl.setSanctionTypeId(sanction.getSanctionTypeId());
		sanctionImpl.setSittingId(sanction.getSittingId());
		sanctionImpl.setAmount(sanction.getAmount());
		sanctionImpl.setStatus(sanction.getStatus());
		sanctionImpl.setSrcFundClassPK(sanction.getSrcFundClassPK());
		sanctionImpl.setSrcFundClassName(sanction.getSrcFundClassName());
		sanctionImpl.setDestFundClassPK(sanction.getDestFundClassPK());
		sanctionImpl.setDestFundClassName(sanction.getDestFundClassName());

		return sanctionImpl;
	}

	/**
	 * Returns the sanction with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sanction
	 * @return the sanction
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a sanction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSanctionException, SystemException {
		Sanction sanction = fetchByPrimaryKey(primaryKey);

		if (sanction == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSanctionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sanction;
	}

	/**
	 * Returns the sanction with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchSanctionException} if it could not be found.
	 *
	 * @param sanctionId the primary key of the sanction
	 * @return the sanction
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a sanction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction findByPrimaryKey(long sanctionId)
		throws NoSuchSanctionException, SystemException {
		return findByPrimaryKey((Serializable)sanctionId);
	}

	/**
	 * Returns the sanction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sanction
	 * @return the sanction, or <code>null</code> if a sanction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Sanction sanction = (Sanction)EntityCacheUtil.getResult(SanctionModelImpl.ENTITY_CACHE_ENABLED,
				SanctionImpl.class, primaryKey);

		if (sanction == _nullSanction) {
			return null;
		}

		if (sanction == null) {
			Session session = null;

			try {
				session = openSession();

				sanction = (Sanction)session.get(SanctionImpl.class, primaryKey);

				if (sanction != null) {
					cacheResult(sanction);
				}
				else {
					EntityCacheUtil.putResult(SanctionModelImpl.ENTITY_CACHE_ENABLED,
						SanctionImpl.class, primaryKey, _nullSanction);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SanctionModelImpl.ENTITY_CACHE_ENABLED,
					SanctionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sanction;
	}

	/**
	 * Returns the sanction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sanctionId the primary key of the sanction
	 * @return the sanction, or <code>null</code> if a sanction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sanction fetchByPrimaryKey(long sanctionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)sanctionId);
	}

	/**
	 * Returns all the sanctions.
	 *
	 * @return the sanctions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sanction> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sanctions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sanctions
	 * @param end the upper bound of the range of sanctions (not inclusive)
	 * @return the range of sanctions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sanction> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sanctions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sanctions
	 * @param end the upper bound of the range of sanctions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sanctions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sanction> findAll(int start, int end,
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

		List<Sanction> list = (List<Sanction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SANCTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SANCTION;

				if (pagination) {
					sql = sql.concat(SanctionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Sanction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Sanction>(list);
				}
				else {
					list = (List<Sanction>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the sanctions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Sanction sanction : findAll()) {
			remove(sanction);
		}
	}

	/**
	 * Returns the number of sanctions.
	 *
	 * @return the number of sanctions
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

				Query q = session.createQuery(_SQL_COUNT_SANCTION);

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
	 * Initializes the sanction persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.cmr.fandenatech.ndjangui.model.Sanction")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Sanction>> listenersList = new ArrayList<ModelListener<Sanction>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Sanction>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SanctionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SANCTION = "SELECT sanction FROM Sanction sanction";
	private static final String _SQL_SELECT_SANCTION_WHERE = "SELECT sanction FROM Sanction sanction WHERE ";
	private static final String _SQL_COUNT_SANCTION = "SELECT COUNT(sanction) FROM Sanction sanction";
	private static final String _SQL_COUNT_SANCTION_WHERE = "SELECT COUNT(sanction) FROM Sanction sanction WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sanction.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Sanction exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Sanction exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SanctionPersistenceImpl.class);
	private static Sanction _nullSanction = new SanctionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Sanction> toCacheModel() {
				return _nullSanctionCacheModel;
			}
		};

	private static CacheModel<Sanction> _nullSanctionCacheModel = new CacheModel<Sanction>() {
			@Override
			public Sanction toEntityModel() {
				return _nullSanction;
			}
		};
}