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

import cmr.fandenatech.ndjangui.NoSuchSittingException;
import cmr.fandenatech.ndjangui.model.Sitting;
import cmr.fandenatech.ndjangui.model.impl.SittingImpl;
import cmr.fandenatech.ndjangui.model.impl.SittingModelImpl;

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
 * The persistence implementation for the sitting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see SittingPersistence
 * @see SittingUtil
 * @generated
 */
public class SittingPersistenceImpl extends BasePersistenceImpl<Sitting>
	implements SittingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SittingUtil} to access the sitting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SittingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SittingModelImpl.ENTITY_CACHE_ENABLED,
			SittingModelImpl.FINDER_CACHE_ENABLED, SittingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SittingModelImpl.ENTITY_CACHE_ENABLED,
			SittingModelImpl.FINDER_CACHE_ENABLED, SittingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SittingModelImpl.ENTITY_CACHE_ENABLED,
			SittingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(SittingModelImpl.ENTITY_CACHE_ENABLED,
			SittingModelImpl.FINDER_CACHE_ENABLED, SittingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(SittingModelImpl.ENTITY_CACHE_ENABLED,
			SittingModelImpl.FINDER_CACHE_ENABLED, SittingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			SittingModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SittingModelImpl.ENTITY_CACHE_ENABLED,
			SittingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the sittings where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sitting> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sittings where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sittings
	 * @param end the upper bound of the range of sittings (not inclusive)
	 * @return the range of matching sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sitting> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sittings where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sittings
	 * @param end the upper bound of the range of sittings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sitting> findByGroupId(long groupId, int start, int end,
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

		List<Sitting> list = (List<Sitting>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Sitting sitting : list) {
				if ((groupId != sitting.getGroupId())) {
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

			query.append(_SQL_SELECT_SITTING_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SittingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Sitting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Sitting>(list);
				}
				else {
					list = (List<Sitting>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first sitting in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchSittingException if a matching sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSittingException, SystemException {
		Sitting sitting = fetchByGroupId_First(groupId, orderByComparator);

		if (sitting != null) {
			return sitting;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSittingException(msg.toString());
	}

	/**
	 * Returns the first sitting in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sitting, or <code>null</code> if a matching sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Sitting> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sitting in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchSittingException if a matching sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSittingException, SystemException {
		Sitting sitting = fetchByGroupId_Last(groupId, orderByComparator);

		if (sitting != null) {
			return sitting;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSittingException(msg.toString());
	}

	/**
	 * Returns the last sitting in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sitting, or <code>null</code> if a matching sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Sitting> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sittings before and after the current sitting in the ordered set where groupId = &#63;.
	 *
	 * @param sittingId the primary key of the current sitting
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchSittingException if a sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting[] findByGroupId_PrevAndNext(long sittingId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSittingException, SystemException {
		Sitting sitting = findByPrimaryKey(sittingId);

		Session session = null;

		try {
			session = openSession();

			Sitting[] array = new SittingImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, sitting, groupId,
					orderByComparator, true);

			array[1] = sitting;

			array[2] = getByGroupId_PrevAndNext(session, sitting, groupId,
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

	protected Sitting getByGroupId_PrevAndNext(Session session,
		Sitting sitting, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SITTING_WHERE);

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
			query.append(SittingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sitting);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Sitting> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sittings where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Sitting sitting : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(sitting);
		}
	}

	/**
	 * Returns the number of sittings where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching sittings
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

			query.append(_SQL_COUNT_SITTING_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "sitting.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(SittingModelImpl.ENTITY_CACHE_ENABLED,
			SittingModelImpl.FINDER_CACHE_ENABLED, SittingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId_Status",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(SittingModelImpl.ENTITY_CACHE_ENABLED,
			SittingModelImpl.FINDER_CACHE_ENABLED, SittingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() },
			SittingModelImpl.GROUPID_COLUMN_BITMASK |
			SittingModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_STATUS = new FinderPath(SittingModelImpl.ENTITY_CACHE_ENABLED,
			SittingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the sittings where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sitting> findByGroupId_Status(long groupId, int status)
		throws SystemException {
		return findByGroupId_Status(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sittings where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of sittings
	 * @param end the upper bound of the range of sittings (not inclusive)
	 * @return the range of matching sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sitting> findByGroupId_Status(long groupId, int status,
		int start, int end) throws SystemException {
		return findByGroupId_Status(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sittings where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of sittings
	 * @param end the upper bound of the range of sittings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sitting> findByGroupId_Status(long groupId, int status,
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

		List<Sitting> list = (List<Sitting>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Sitting sitting : list) {
				if ((groupId != sitting.getGroupId()) ||
						(status != sitting.getStatus())) {
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

			query.append(_SQL_SELECT_SITTING_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SittingModelImpl.ORDER_BY_JPQL);
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
					list = (List<Sitting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Sitting>(list);
				}
				else {
					list = (List<Sitting>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first sitting in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchSittingException if a matching sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting findByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchSittingException, SystemException {
		Sitting sitting = fetchByGroupId_Status_First(groupId, status,
				orderByComparator);

		if (sitting != null) {
			return sitting;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSittingException(msg.toString());
	}

	/**
	 * Returns the first sitting in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sitting, or <code>null</code> if a matching sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting fetchByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Sitting> list = findByGroupId_Status(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sitting in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchSittingException if a matching sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting findByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchSittingException, SystemException {
		Sitting sitting = fetchByGroupId_Status_Last(groupId, status,
				orderByComparator);

		if (sitting != null) {
			return sitting;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSittingException(msg.toString());
	}

	/**
	 * Returns the last sitting in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sitting, or <code>null</code> if a matching sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting fetchByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId_Status(groupId, status);

		if (count == 0) {
			return null;
		}

		List<Sitting> list = findByGroupId_Status(groupId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sittings before and after the current sitting in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param sittingId the primary key of the current sitting
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchSittingException if a sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting[] findByGroupId_Status_PrevAndNext(long sittingId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws NoSuchSittingException, SystemException {
		Sitting sitting = findByPrimaryKey(sittingId);

		Session session = null;

		try {
			session = openSession();

			Sitting[] array = new SittingImpl[3];

			array[0] = getByGroupId_Status_PrevAndNext(session, sitting,
					groupId, status, orderByComparator, true);

			array[1] = sitting;

			array[2] = getByGroupId_Status_PrevAndNext(session, sitting,
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

	protected Sitting getByGroupId_Status_PrevAndNext(Session session,
		Sitting sitting, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SITTING_WHERE);

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
			query.append(SittingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sitting);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Sitting> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sittings where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId_Status(long groupId, int status)
		throws SystemException {
		for (Sitting sitting : findByGroupId_Status(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sitting);
		}
	}

	/**
	 * Returns the number of sittings where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching sittings
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

			query.append(_SQL_COUNT_SITTING_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_STATUS_GROUPID_2 = "sitting.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_STATUS_STATUS_2 = "sitting.status = ?";

	public SittingPersistenceImpl() {
		setModelClass(Sitting.class);
	}

	/**
	 * Caches the sitting in the entity cache if it is enabled.
	 *
	 * @param sitting the sitting
	 */
	@Override
	public void cacheResult(Sitting sitting) {
		EntityCacheUtil.putResult(SittingModelImpl.ENTITY_CACHE_ENABLED,
			SittingImpl.class, sitting.getPrimaryKey(), sitting);

		sitting.resetOriginalValues();
	}

	/**
	 * Caches the sittings in the entity cache if it is enabled.
	 *
	 * @param sittings the sittings
	 */
	@Override
	public void cacheResult(List<Sitting> sittings) {
		for (Sitting sitting : sittings) {
			if (EntityCacheUtil.getResult(
						SittingModelImpl.ENTITY_CACHE_ENABLED,
						SittingImpl.class, sitting.getPrimaryKey()) == null) {
				cacheResult(sitting);
			}
			else {
				sitting.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sittings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SittingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SittingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sitting.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Sitting sitting) {
		EntityCacheUtil.removeResult(SittingModelImpl.ENTITY_CACHE_ENABLED,
			SittingImpl.class, sitting.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Sitting> sittings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Sitting sitting : sittings) {
			EntityCacheUtil.removeResult(SittingModelImpl.ENTITY_CACHE_ENABLED,
				SittingImpl.class, sitting.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sitting with the primary key. Does not add the sitting to the database.
	 *
	 * @param sittingId the primary key for the new sitting
	 * @return the new sitting
	 */
	@Override
	public Sitting create(long sittingId) {
		Sitting sitting = new SittingImpl();

		sitting.setNew(true);
		sitting.setPrimaryKey(sittingId);

		return sitting;
	}

	/**
	 * Removes the sitting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sittingId the primary key of the sitting
	 * @return the sitting that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchSittingException if a sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting remove(long sittingId)
		throws NoSuchSittingException, SystemException {
		return remove((Serializable)sittingId);
	}

	/**
	 * Removes the sitting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sitting
	 * @return the sitting that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchSittingException if a sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting remove(Serializable primaryKey)
		throws NoSuchSittingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Sitting sitting = (Sitting)session.get(SittingImpl.class, primaryKey);

			if (sitting == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSittingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sitting);
		}
		catch (NoSuchSittingException nsee) {
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
	protected Sitting removeImpl(Sitting sitting) throws SystemException {
		sitting = toUnwrappedModel(sitting);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sitting)) {
				sitting = (Sitting)session.get(SittingImpl.class,
						sitting.getPrimaryKeyObj());
			}

			if (sitting != null) {
				session.delete(sitting);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sitting != null) {
			clearCache(sitting);
		}

		return sitting;
	}

	@Override
	public Sitting updateImpl(cmr.fandenatech.ndjangui.model.Sitting sitting)
		throws SystemException {
		sitting = toUnwrappedModel(sitting);

		boolean isNew = sitting.isNew();

		SittingModelImpl sittingModelImpl = (SittingModelImpl)sitting;

		Session session = null;

		try {
			session = openSession();

			if (sitting.isNew()) {
				session.save(sitting);

				sitting.setNew(false);
			}
			else {
				session.merge(sitting);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SittingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((sittingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sittingModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { sittingModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((sittingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sittingModelImpl.getOriginalGroupId(),
						sittingModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);

				args = new Object[] {
						sittingModelImpl.getGroupId(),
						sittingModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(SittingModelImpl.ENTITY_CACHE_ENABLED,
			SittingImpl.class, sitting.getPrimaryKey(), sitting);

		return sitting;
	}

	protected Sitting toUnwrappedModel(Sitting sitting) {
		if (sitting instanceof SittingImpl) {
			return sitting;
		}

		SittingImpl sittingImpl = new SittingImpl();

		sittingImpl.setNew(sitting.isNew());
		sittingImpl.setPrimaryKey(sitting.getPrimaryKey());

		sittingImpl.setSittingId(sitting.getSittingId());
		sittingImpl.setUserId(sitting.getUserId());
		sittingImpl.setGroupId(sitting.getGroupId());
		sittingImpl.setCompanyId(sitting.getCompanyId());
		sittingImpl.setUserName(sitting.getUserName());
		sittingImpl.setCreateDate(sitting.getCreateDate());
		sittingImpl.setModifiedDate(sitting.getModifiedDate());
		sittingImpl.setStartDate(sitting.getStartDate());
		sittingImpl.setStartHour(sitting.getStartHour());
		sittingImpl.setStartMin(sitting.getStartMin());
		sittingImpl.setEndDate(sitting.getEndDate());
		sittingImpl.setEndHour(sitting.getEndHour());
		sittingImpl.setEndMin(sitting.getEndMin());
		sittingImpl.setBudgetPeriodId(sitting.getBudgetPeriodId());
		sittingImpl.setName(sitting.getName());
		sittingImpl.setDayPlan(sitting.getDayPlan());
		sittingImpl.setNotes(sitting.getNotes());
		sittingImpl.setStatus(sitting.getStatus());

		return sittingImpl;
	}

	/**
	 * Returns the sitting with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sitting
	 * @return the sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchSittingException if a sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSittingException, SystemException {
		Sitting sitting = fetchByPrimaryKey(primaryKey);

		if (sitting == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSittingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sitting;
	}

	/**
	 * Returns the sitting with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchSittingException} if it could not be found.
	 *
	 * @param sittingId the primary key of the sitting
	 * @return the sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchSittingException if a sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting findByPrimaryKey(long sittingId)
		throws NoSuchSittingException, SystemException {
		return findByPrimaryKey((Serializable)sittingId);
	}

	/**
	 * Returns the sitting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sitting
	 * @return the sitting, or <code>null</code> if a sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Sitting sitting = (Sitting)EntityCacheUtil.getResult(SittingModelImpl.ENTITY_CACHE_ENABLED,
				SittingImpl.class, primaryKey);

		if (sitting == _nullSitting) {
			return null;
		}

		if (sitting == null) {
			Session session = null;

			try {
				session = openSession();

				sitting = (Sitting)session.get(SittingImpl.class, primaryKey);

				if (sitting != null) {
					cacheResult(sitting);
				}
				else {
					EntityCacheUtil.putResult(SittingModelImpl.ENTITY_CACHE_ENABLED,
						SittingImpl.class, primaryKey, _nullSitting);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SittingModelImpl.ENTITY_CACHE_ENABLED,
					SittingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sitting;
	}

	/**
	 * Returns the sitting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sittingId the primary key of the sitting
	 * @return the sitting, or <code>null</code> if a sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sitting fetchByPrimaryKey(long sittingId) throws SystemException {
		return fetchByPrimaryKey((Serializable)sittingId);
	}

	/**
	 * Returns all the sittings.
	 *
	 * @return the sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sitting> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sittings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sittings
	 * @param end the upper bound of the range of sittings (not inclusive)
	 * @return the range of sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sitting> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sittings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sittings
	 * @param end the upper bound of the range of sittings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sitting> findAll(int start, int end,
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

		List<Sitting> list = (List<Sitting>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SITTING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SITTING;

				if (pagination) {
					sql = sql.concat(SittingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Sitting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Sitting>(list);
				}
				else {
					list = (List<Sitting>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the sittings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Sitting sitting : findAll()) {
			remove(sitting);
		}
	}

	/**
	 * Returns the number of sittings.
	 *
	 * @return the number of sittings
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

				Query q = session.createQuery(_SQL_COUNT_SITTING);

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
	 * Initializes the sitting persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.cmr.fandenatech.ndjangui.model.Sitting")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Sitting>> listenersList = new ArrayList<ModelListener<Sitting>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Sitting>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SittingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SITTING = "SELECT sitting FROM Sitting sitting";
	private static final String _SQL_SELECT_SITTING_WHERE = "SELECT sitting FROM Sitting sitting WHERE ";
	private static final String _SQL_COUNT_SITTING = "SELECT COUNT(sitting) FROM Sitting sitting";
	private static final String _SQL_COUNT_SITTING_WHERE = "SELECT COUNT(sitting) FROM Sitting sitting WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sitting.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Sitting exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Sitting exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SittingPersistenceImpl.class);
	private static Sitting _nullSitting = new SittingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Sitting> toCacheModel() {
				return _nullSittingCacheModel;
			}
		};

	private static CacheModel<Sitting> _nullSittingCacheModel = new CacheModel<Sitting>() {
			@Override
			public Sitting toEntityModel() {
				return _nullSitting;
			}
		};
}