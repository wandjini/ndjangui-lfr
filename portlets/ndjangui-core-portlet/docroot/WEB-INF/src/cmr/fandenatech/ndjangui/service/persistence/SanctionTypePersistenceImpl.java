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

import cmr.fandenatech.ndjangui.NoSuchSanctionTypeException;
import cmr.fandenatech.ndjangui.model.SanctionType;
import cmr.fandenatech.ndjangui.model.impl.SanctionTypeImpl;
import cmr.fandenatech.ndjangui.model.impl.SanctionTypeModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the sanction type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see SanctionTypePersistence
 * @see SanctionTypeUtil
 * @generated
 */
public class SanctionTypePersistenceImpl extends BasePersistenceImpl<SanctionType>
	implements SanctionTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SanctionTypeUtil} to access the sanction type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SanctionTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
			SanctionTypeModelImpl.FINDER_CACHE_ENABLED, SanctionTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
			SanctionTypeModelImpl.FINDER_CACHE_ENABLED, SanctionTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
			SanctionTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
			SanctionTypeModelImpl.FINDER_CACHE_ENABLED, SanctionTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
			SanctionTypeModelImpl.FINDER_CACHE_ENABLED, SanctionTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			SanctionTypeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
			SanctionTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the sanction types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching sanction types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SanctionType> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sanction types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sanction types
	 * @param end the upper bound of the range of sanction types (not inclusive)
	 * @return the range of matching sanction types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SanctionType> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sanction types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sanction types
	 * @param end the upper bound of the range of sanction types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sanction types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SanctionType> findByGroupId(long groupId, int start, int end,
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

		List<SanctionType> list = (List<SanctionType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SanctionType sanctionType : list) {
				if ((groupId != sanctionType.getGroupId())) {
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

			query.append(_SQL_SELECT_SANCTIONTYPE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SanctionTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<SanctionType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SanctionType>(list);
				}
				else {
					list = (List<SanctionType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first sanction type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sanction type
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionTypeException if a matching sanction type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSanctionTypeException, SystemException {
		SanctionType sanctionType = fetchByGroupId_First(groupId,
				orderByComparator);

		if (sanctionType != null) {
			return sanctionType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSanctionTypeException(msg.toString());
	}

	/**
	 * Returns the first sanction type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sanction type, or <code>null</code> if a matching sanction type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SanctionType> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sanction type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sanction type
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionTypeException if a matching sanction type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSanctionTypeException, SystemException {
		SanctionType sanctionType = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (sanctionType != null) {
			return sanctionType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSanctionTypeException(msg.toString());
	}

	/**
	 * Returns the last sanction type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sanction type, or <code>null</code> if a matching sanction type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<SanctionType> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sanction types before and after the current sanction type in the ordered set where groupId = &#63;.
	 *
	 * @param sanctionTypeId the primary key of the current sanction type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sanction type
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionTypeException if a sanction type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType[] findByGroupId_PrevAndNext(long sanctionTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchSanctionTypeException, SystemException {
		SanctionType sanctionType = findByPrimaryKey(sanctionTypeId);

		Session session = null;

		try {
			session = openSession();

			SanctionType[] array = new SanctionTypeImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, sanctionType, groupId,
					orderByComparator, true);

			array[1] = sanctionType;

			array[2] = getByGroupId_PrevAndNext(session, sanctionType, groupId,
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

	protected SanctionType getByGroupId_PrevAndNext(Session session,
		SanctionType sanctionType, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SANCTIONTYPE_WHERE);

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
			query.append(SanctionTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sanctionType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SanctionType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sanction types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (SanctionType sanctionType : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sanctionType);
		}
	}

	/**
	 * Returns the number of sanction types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching sanction types
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

			query.append(_SQL_COUNT_SANCTIONTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "sanctionType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
			SanctionTypeModelImpl.FINDER_CACHE_ENABLED, SanctionTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId_Status",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
			SanctionTypeModelImpl.FINDER_CACHE_ENABLED, SanctionTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() },
			SanctionTypeModelImpl.GROUPID_COLUMN_BITMASK |
			SanctionTypeModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_STATUS = new FinderPath(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
			SanctionTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the sanction types where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching sanction types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SanctionType> findByGroupId_Status(long groupId, int status)
		throws SystemException {
		return findByGroupId_Status(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sanction types where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of sanction types
	 * @param end the upper bound of the range of sanction types (not inclusive)
	 * @return the range of matching sanction types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SanctionType> findByGroupId_Status(long groupId, int status,
		int start, int end) throws SystemException {
		return findByGroupId_Status(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sanction types where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of sanction types
	 * @param end the upper bound of the range of sanction types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sanction types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SanctionType> findByGroupId_Status(long groupId, int status,
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

		List<SanctionType> list = (List<SanctionType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SanctionType sanctionType : list) {
				if ((groupId != sanctionType.getGroupId()) ||
						(status != sanctionType.getStatus())) {
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

			query.append(_SQL_SELECT_SANCTIONTYPE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SanctionTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<SanctionType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SanctionType>(list);
				}
				else {
					list = (List<SanctionType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first sanction type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sanction type
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionTypeException if a matching sanction type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType findByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchSanctionTypeException, SystemException {
		SanctionType sanctionType = fetchByGroupId_Status_First(groupId,
				status, orderByComparator);

		if (sanctionType != null) {
			return sanctionType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSanctionTypeException(msg.toString());
	}

	/**
	 * Returns the first sanction type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sanction type, or <code>null</code> if a matching sanction type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType fetchByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<SanctionType> list = findByGroupId_Status(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sanction type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sanction type
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionTypeException if a matching sanction type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType findByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchSanctionTypeException, SystemException {
		SanctionType sanctionType = fetchByGroupId_Status_Last(groupId, status,
				orderByComparator);

		if (sanctionType != null) {
			return sanctionType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSanctionTypeException(msg.toString());
	}

	/**
	 * Returns the last sanction type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sanction type, or <code>null</code> if a matching sanction type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType fetchByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId_Status(groupId, status);

		if (count == 0) {
			return null;
		}

		List<SanctionType> list = findByGroupId_Status(groupId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sanction types before and after the current sanction type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param sanctionTypeId the primary key of the current sanction type
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sanction type
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionTypeException if a sanction type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType[] findByGroupId_Status_PrevAndNext(
		long sanctionTypeId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchSanctionTypeException, SystemException {
		SanctionType sanctionType = findByPrimaryKey(sanctionTypeId);

		Session session = null;

		try {
			session = openSession();

			SanctionType[] array = new SanctionTypeImpl[3];

			array[0] = getByGroupId_Status_PrevAndNext(session, sanctionType,
					groupId, status, orderByComparator, true);

			array[1] = sanctionType;

			array[2] = getByGroupId_Status_PrevAndNext(session, sanctionType,
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

	protected SanctionType getByGroupId_Status_PrevAndNext(Session session,
		SanctionType sanctionType, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SANCTIONTYPE_WHERE);

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
			query.append(SanctionTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sanctionType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SanctionType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sanction types where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId_Status(long groupId, int status)
		throws SystemException {
		for (SanctionType sanctionType : findByGroupId_Status(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sanctionType);
		}
	}

	/**
	 * Returns the number of sanction types where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching sanction types
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

			query.append(_SQL_COUNT_SANCTIONTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_STATUS_GROUPID_2 = "sanctionType.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_STATUS_STATUS_2 = "sanctionType.status = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPID_NAME = new FinderPath(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
			SanctionTypeModelImpl.FINDER_CACHE_ENABLED, SanctionTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByGroupId_Name",
			new String[] { Long.class.getName(), String.class.getName() },
			SanctionTypeModelImpl.GROUPID_COLUMN_BITMASK |
			SanctionTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_NAME = new FinderPath(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
			SanctionTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId_Name",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the sanction type where groupId = &#63; and name = &#63; or throws a {@link cmr.fandenatech.ndjangui.NoSuchSanctionTypeException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching sanction type
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionTypeException if a matching sanction type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType findByGroupId_Name(long groupId, String name)
		throws NoSuchSanctionTypeException, SystemException {
		SanctionType sanctionType = fetchByGroupId_Name(groupId, name);

		if (sanctionType == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSanctionTypeException(msg.toString());
		}

		return sanctionType;
	}

	/**
	 * Returns the sanction type where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching sanction type, or <code>null</code> if a matching sanction type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType fetchByGroupId_Name(long groupId, String name)
		throws SystemException {
		return fetchByGroupId_Name(groupId, name, true);
	}

	/**
	 * Returns the sanction type where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching sanction type, or <code>null</code> if a matching sanction type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType fetchByGroupId_Name(long groupId, String name,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPID_NAME,
					finderArgs, this);
		}

		if (result instanceof SanctionType) {
			SanctionType sanctionType = (SanctionType)result;

			if ((groupId != sanctionType.getGroupId()) ||
					!Validator.equals(name, sanctionType.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SANCTIONTYPE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_NAME_GROUPID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_GROUPID_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPID_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_GROUPID_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindName) {
					qPos.add(name);
				}

				List<SanctionType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_NAME,
						finderArgs, list);
				}
				else {
					SanctionType sanctionType = list.get(0);

					result = sanctionType;

					cacheResult(sanctionType);

					if ((sanctionType.getGroupId() != groupId) ||
							(sanctionType.getName() == null) ||
							!sanctionType.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_NAME,
							finderArgs, sanctionType);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_NAME,
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
			return (SanctionType)result;
		}
	}

	/**
	 * Removes the sanction type where groupId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the sanction type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType removeByGroupId_Name(long groupId, String name)
		throws NoSuchSanctionTypeException, SystemException {
		SanctionType sanctionType = findByGroupId_Name(groupId, name);

		return remove(sanctionType);
	}

	/**
	 * Returns the number of sanction types where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching sanction types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId_Name(long groupId, String name)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID_NAME;

		Object[] finderArgs = new Object[] { groupId, name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SANCTIONTYPE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_NAME_GROUPID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_GROUPID_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPID_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_GROUPID_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_NAME_GROUPID_2 = "sanctionType.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_NAME_NAME_1 = "sanctionType.name IS NULL";
	private static final String _FINDER_COLUMN_GROUPID_NAME_NAME_2 = "sanctionType.name = ?";
	private static final String _FINDER_COLUMN_GROUPID_NAME_NAME_3 = "(sanctionType.name IS NULL OR sanctionType.name = '')";

	public SanctionTypePersistenceImpl() {
		setModelClass(SanctionType.class);
	}

	/**
	 * Caches the sanction type in the entity cache if it is enabled.
	 *
	 * @param sanctionType the sanction type
	 */
	@Override
	public void cacheResult(SanctionType sanctionType) {
		EntityCacheUtil.putResult(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
			SanctionTypeImpl.class, sanctionType.getPrimaryKey(), sanctionType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_NAME,
			new Object[] { sanctionType.getGroupId(), sanctionType.getName() },
			sanctionType);

		sanctionType.resetOriginalValues();
	}

	/**
	 * Caches the sanction types in the entity cache if it is enabled.
	 *
	 * @param sanctionTypes the sanction types
	 */
	@Override
	public void cacheResult(List<SanctionType> sanctionTypes) {
		for (SanctionType sanctionType : sanctionTypes) {
			if (EntityCacheUtil.getResult(
						SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
						SanctionTypeImpl.class, sanctionType.getPrimaryKey()) == null) {
				cacheResult(sanctionType);
			}
			else {
				sanctionType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sanction types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SanctionTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SanctionTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sanction type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SanctionType sanctionType) {
		EntityCacheUtil.removeResult(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
			SanctionTypeImpl.class, sanctionType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(sanctionType);
	}

	@Override
	public void clearCache(List<SanctionType> sanctionTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SanctionType sanctionType : sanctionTypes) {
			EntityCacheUtil.removeResult(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
				SanctionTypeImpl.class, sanctionType.getPrimaryKey());

			clearUniqueFindersCache(sanctionType);
		}
	}

	protected void cacheUniqueFindersCache(SanctionType sanctionType) {
		if (sanctionType.isNew()) {
			Object[] args = new Object[] {
					sanctionType.getGroupId(), sanctionType.getName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_NAME, args,
				sanctionType);
		}
		else {
			SanctionTypeModelImpl sanctionTypeModelImpl = (SanctionTypeModelImpl)sanctionType;

			if ((sanctionTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GROUPID_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sanctionType.getGroupId(), sanctionType.getName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_NAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_NAME,
					args, sanctionType);
			}
		}
	}

	protected void clearUniqueFindersCache(SanctionType sanctionType) {
		SanctionTypeModelImpl sanctionTypeModelImpl = (SanctionTypeModelImpl)sanctionType;

		Object[] args = new Object[] {
				sanctionType.getGroupId(), sanctionType.getName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_NAME, args);

		if ((sanctionTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GROUPID_NAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					sanctionTypeModelImpl.getOriginalGroupId(),
					sanctionTypeModelImpl.getOriginalName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_NAME, args);
		}
	}

	/**
	 * Creates a new sanction type with the primary key. Does not add the sanction type to the database.
	 *
	 * @param sanctionTypeId the primary key for the new sanction type
	 * @return the new sanction type
	 */
	@Override
	public SanctionType create(long sanctionTypeId) {
		SanctionType sanctionType = new SanctionTypeImpl();

		sanctionType.setNew(true);
		sanctionType.setPrimaryKey(sanctionTypeId);

		return sanctionType;
	}

	/**
	 * Removes the sanction type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sanctionTypeId the primary key of the sanction type
	 * @return the sanction type that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionTypeException if a sanction type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType remove(long sanctionTypeId)
		throws NoSuchSanctionTypeException, SystemException {
		return remove((Serializable)sanctionTypeId);
	}

	/**
	 * Removes the sanction type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sanction type
	 * @return the sanction type that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionTypeException if a sanction type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType remove(Serializable primaryKey)
		throws NoSuchSanctionTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SanctionType sanctionType = (SanctionType)session.get(SanctionTypeImpl.class,
					primaryKey);

			if (sanctionType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSanctionTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sanctionType);
		}
		catch (NoSuchSanctionTypeException nsee) {
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
	protected SanctionType removeImpl(SanctionType sanctionType)
		throws SystemException {
		sanctionType = toUnwrappedModel(sanctionType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sanctionType)) {
				sanctionType = (SanctionType)session.get(SanctionTypeImpl.class,
						sanctionType.getPrimaryKeyObj());
			}

			if (sanctionType != null) {
				session.delete(sanctionType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sanctionType != null) {
			clearCache(sanctionType);
		}

		return sanctionType;
	}

	@Override
	public SanctionType updateImpl(
		cmr.fandenatech.ndjangui.model.SanctionType sanctionType)
		throws SystemException {
		sanctionType = toUnwrappedModel(sanctionType);

		boolean isNew = sanctionType.isNew();

		SanctionTypeModelImpl sanctionTypeModelImpl = (SanctionTypeModelImpl)sanctionType;

		Session session = null;

		try {
			session = openSession();

			if (sanctionType.isNew()) {
				session.save(sanctionType);

				sanctionType.setNew(false);
			}
			else {
				session.merge(sanctionType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SanctionTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((sanctionTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sanctionTypeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { sanctionTypeModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((sanctionTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sanctionTypeModelImpl.getOriginalGroupId(),
						sanctionTypeModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);

				args = new Object[] {
						sanctionTypeModelImpl.getGroupId(),
						sanctionTypeModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
			SanctionTypeImpl.class, sanctionType.getPrimaryKey(), sanctionType);

		clearUniqueFindersCache(sanctionType);
		cacheUniqueFindersCache(sanctionType);

		return sanctionType;
	}

	protected SanctionType toUnwrappedModel(SanctionType sanctionType) {
		if (sanctionType instanceof SanctionTypeImpl) {
			return sanctionType;
		}

		SanctionTypeImpl sanctionTypeImpl = new SanctionTypeImpl();

		sanctionTypeImpl.setNew(sanctionType.isNew());
		sanctionTypeImpl.setPrimaryKey(sanctionType.getPrimaryKey());

		sanctionTypeImpl.setSanctionTypeId(sanctionType.getSanctionTypeId());
		sanctionTypeImpl.setUserId(sanctionType.getUserId());
		sanctionTypeImpl.setGroupId(sanctionType.getGroupId());
		sanctionTypeImpl.setCompanyId(sanctionType.getCompanyId());
		sanctionTypeImpl.setUserName(sanctionType.getUserName());
		sanctionTypeImpl.setCreateDate(sanctionType.getCreateDate());
		sanctionTypeImpl.setModifiedDate(sanctionType.getModifiedDate());
		sanctionTypeImpl.setName(sanctionType.getName());
		sanctionTypeImpl.setShortDescription(sanctionType.getShortDescription());
		sanctionTypeImpl.setAmount(sanctionType.getAmount());
		sanctionTypeImpl.setStatus(sanctionType.getStatus());

		return sanctionTypeImpl;
	}

	/**
	 * Returns the sanction type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sanction type
	 * @return the sanction type
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionTypeException if a sanction type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSanctionTypeException, SystemException {
		SanctionType sanctionType = fetchByPrimaryKey(primaryKey);

		if (sanctionType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSanctionTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sanctionType;
	}

	/**
	 * Returns the sanction type with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchSanctionTypeException} if it could not be found.
	 *
	 * @param sanctionTypeId the primary key of the sanction type
	 * @return the sanction type
	 * @throws cmr.fandenatech.ndjangui.NoSuchSanctionTypeException if a sanction type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType findByPrimaryKey(long sanctionTypeId)
		throws NoSuchSanctionTypeException, SystemException {
		return findByPrimaryKey((Serializable)sanctionTypeId);
	}

	/**
	 * Returns the sanction type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sanction type
	 * @return the sanction type, or <code>null</code> if a sanction type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SanctionType sanctionType = (SanctionType)EntityCacheUtil.getResult(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
				SanctionTypeImpl.class, primaryKey);

		if (sanctionType == _nullSanctionType) {
			return null;
		}

		if (sanctionType == null) {
			Session session = null;

			try {
				session = openSession();

				sanctionType = (SanctionType)session.get(SanctionTypeImpl.class,
						primaryKey);

				if (sanctionType != null) {
					cacheResult(sanctionType);
				}
				else {
					EntityCacheUtil.putResult(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
						SanctionTypeImpl.class, primaryKey, _nullSanctionType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SanctionTypeModelImpl.ENTITY_CACHE_ENABLED,
					SanctionTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sanctionType;
	}

	/**
	 * Returns the sanction type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sanctionTypeId the primary key of the sanction type
	 * @return the sanction type, or <code>null</code> if a sanction type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SanctionType fetchByPrimaryKey(long sanctionTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)sanctionTypeId);
	}

	/**
	 * Returns all the sanction types.
	 *
	 * @return the sanction types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SanctionType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sanction types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sanction types
	 * @param end the upper bound of the range of sanction types (not inclusive)
	 * @return the range of sanction types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SanctionType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sanction types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sanction types
	 * @param end the upper bound of the range of sanction types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sanction types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SanctionType> findAll(int start, int end,
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

		List<SanctionType> list = (List<SanctionType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SANCTIONTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SANCTIONTYPE;

				if (pagination) {
					sql = sql.concat(SanctionTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SanctionType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SanctionType>(list);
				}
				else {
					list = (List<SanctionType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the sanction types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SanctionType sanctionType : findAll()) {
			remove(sanctionType);
		}
	}

	/**
	 * Returns the number of sanction types.
	 *
	 * @return the number of sanction types
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

				Query q = session.createQuery(_SQL_COUNT_SANCTIONTYPE);

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
	 * Initializes the sanction type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.cmr.fandenatech.ndjangui.model.SanctionType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SanctionType>> listenersList = new ArrayList<ModelListener<SanctionType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SanctionType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SanctionTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SANCTIONTYPE = "SELECT sanctionType FROM SanctionType sanctionType";
	private static final String _SQL_SELECT_SANCTIONTYPE_WHERE = "SELECT sanctionType FROM SanctionType sanctionType WHERE ";
	private static final String _SQL_COUNT_SANCTIONTYPE = "SELECT COUNT(sanctionType) FROM SanctionType sanctionType";
	private static final String _SQL_COUNT_SANCTIONTYPE_WHERE = "SELECT COUNT(sanctionType) FROM SanctionType sanctionType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sanctionType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SanctionType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SanctionType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SanctionTypePersistenceImpl.class);
	private static SanctionType _nullSanctionType = new SanctionTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SanctionType> toCacheModel() {
				return _nullSanctionTypeCacheModel;
			}
		};

	private static CacheModel<SanctionType> _nullSanctionTypeCacheModel = new CacheModel<SanctionType>() {
			@Override
			public SanctionType toEntityModel() {
				return _nullSanctionType;
			}
		};
}