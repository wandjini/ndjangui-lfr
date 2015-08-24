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

import cmr.fandenatech.ndjangui.NoSuchFundTypeException;
import cmr.fandenatech.ndjangui.model.FundType;
import cmr.fandenatech.ndjangui.model.impl.FundTypeImpl;
import cmr.fandenatech.ndjangui.model.impl.FundTypeModelImpl;

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
 * The persistence implementation for the fund type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see FundTypePersistence
 * @see FundTypeUtil
 * @generated
 */
public class FundTypePersistenceImpl extends BasePersistenceImpl<FundType>
	implements FundTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FundTypeUtil} to access the fund type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FundTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
			FundTypeModelImpl.FINDER_CACHE_ENABLED, FundTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
			FundTypeModelImpl.FINDER_CACHE_ENABLED, FundTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
			FundTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
			FundTypeModelImpl.FINDER_CACHE_ENABLED, FundTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
			FundTypeModelImpl.FINDER_CACHE_ENABLED, FundTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			FundTypeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
			FundTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fund types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching fund types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FundType> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of fund types
	 * @param end the upper bound of the range of fund types (not inclusive)
	 * @return the range of matching fund types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FundType> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of fund types
	 * @param end the upper bound of the range of fund types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fund types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FundType> findByGroupId(long groupId, int start, int end,
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

		List<FundType> list = (List<FundType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FundType fundType : list) {
				if ((groupId != fundType.getGroupId())) {
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

			query.append(_SQL_SELECT_FUNDTYPE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FundTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<FundType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FundType>(list);
				}
				else {
					list = (List<FundType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fund type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund type
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundTypeException if a matching fund type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFundTypeException, SystemException {
		FundType fundType = fetchByGroupId_First(groupId, orderByComparator);

		if (fundType != null) {
			return fundType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundTypeException(msg.toString());
	}

	/**
	 * Returns the first fund type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund type, or <code>null</code> if a matching fund type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FundType> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fund type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund type
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundTypeException if a matching fund type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFundTypeException, SystemException {
		FundType fundType = fetchByGroupId_Last(groupId, orderByComparator);

		if (fundType != null) {
			return fundType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundTypeException(msg.toString());
	}

	/**
	 * Returns the last fund type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund type, or <code>null</code> if a matching fund type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<FundType> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fund types before and after the current fund type in the ordered set where groupId = &#63;.
	 *
	 * @param fundTypeId the primary key of the current fund type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund type
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundTypeException if a fund type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType[] findByGroupId_PrevAndNext(long fundTypeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFundTypeException, SystemException {
		FundType fundType = findByPrimaryKey(fundTypeId);

		Session session = null;

		try {
			session = openSession();

			FundType[] array = new FundTypeImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, fundType, groupId,
					orderByComparator, true);

			array[1] = fundType;

			array[2] = getByGroupId_PrevAndNext(session, fundType, groupId,
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

	protected FundType getByGroupId_PrevAndNext(Session session,
		FundType fundType, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNDTYPE_WHERE);

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
			query.append(FundTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fundType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FundType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fund types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (FundType fundType : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(fundType);
		}
	}

	/**
	 * Returns the number of fund types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching fund types
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

			query.append(_SQL_COUNT_FUNDTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "fundType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
			FundTypeModelImpl.FINDER_CACHE_ENABLED, FundTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId_Status",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
			FundTypeModelImpl.FINDER_CACHE_ENABLED, FundTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() },
			FundTypeModelImpl.GROUPID_COLUMN_BITMASK |
			FundTypeModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_STATUS = new FinderPath(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
			FundTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the fund types where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching fund types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FundType> findByGroupId_Status(long groupId, int status)
		throws SystemException {
		return findByGroupId_Status(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund types where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of fund types
	 * @param end the upper bound of the range of fund types (not inclusive)
	 * @return the range of matching fund types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FundType> findByGroupId_Status(long groupId, int status,
		int start, int end) throws SystemException {
		return findByGroupId_Status(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund types where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of fund types
	 * @param end the upper bound of the range of fund types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fund types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FundType> findByGroupId_Status(long groupId, int status,
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

		List<FundType> list = (List<FundType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FundType fundType : list) {
				if ((groupId != fundType.getGroupId()) ||
						(status != fundType.getStatus())) {
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

			query.append(_SQL_SELECT_FUNDTYPE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FundTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<FundType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FundType>(list);
				}
				else {
					list = (List<FundType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fund type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund type
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundTypeException if a matching fund type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType findByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchFundTypeException, SystemException {
		FundType fundType = fetchByGroupId_Status_First(groupId, status,
				orderByComparator);

		if (fundType != null) {
			return fundType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundTypeException(msg.toString());
	}

	/**
	 * Returns the first fund type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund type, or <code>null</code> if a matching fund type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType fetchByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<FundType> list = findByGroupId_Status(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fund type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund type
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundTypeException if a matching fund type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType findByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchFundTypeException, SystemException {
		FundType fundType = fetchByGroupId_Status_Last(groupId, status,
				orderByComparator);

		if (fundType != null) {
			return fundType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundTypeException(msg.toString());
	}

	/**
	 * Returns the last fund type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund type, or <code>null</code> if a matching fund type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType fetchByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId_Status(groupId, status);

		if (count == 0) {
			return null;
		}

		List<FundType> list = findByGroupId_Status(groupId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fund types before and after the current fund type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param fundTypeId the primary key of the current fund type
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund type
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundTypeException if a fund type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType[] findByGroupId_Status_PrevAndNext(long fundTypeId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws NoSuchFundTypeException, SystemException {
		FundType fundType = findByPrimaryKey(fundTypeId);

		Session session = null;

		try {
			session = openSession();

			FundType[] array = new FundTypeImpl[3];

			array[0] = getByGroupId_Status_PrevAndNext(session, fundType,
					groupId, status, orderByComparator, true);

			array[1] = fundType;

			array[2] = getByGroupId_Status_PrevAndNext(session, fundType,
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

	protected FundType getByGroupId_Status_PrevAndNext(Session session,
		FundType fundType, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNDTYPE_WHERE);

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
			query.append(FundTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fundType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FundType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fund types where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId_Status(long groupId, int status)
		throws SystemException {
		for (FundType fundType : findByGroupId_Status(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fundType);
		}
	}

	/**
	 * Returns the number of fund types where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching fund types
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

			query.append(_SQL_COUNT_FUNDTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_STATUS_GROUPID_2 = "fundType.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_STATUS_STATUS_2 = "fundType.status = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPID_NAME = new FinderPath(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
			FundTypeModelImpl.FINDER_CACHE_ENABLED, FundTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByGroupId_Name",
			new String[] { Long.class.getName(), String.class.getName() },
			FundTypeModelImpl.GROUPID_COLUMN_BITMASK |
			FundTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_NAME = new FinderPath(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
			FundTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId_Name",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the fund type where groupId = &#63; and name = &#63; or throws a {@link cmr.fandenatech.ndjangui.NoSuchFundTypeException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching fund type
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundTypeException if a matching fund type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType findByGroupId_Name(long groupId, String name)
		throws NoSuchFundTypeException, SystemException {
		FundType fundType = fetchByGroupId_Name(groupId, name);

		if (fundType == null) {
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

			throw new NoSuchFundTypeException(msg.toString());
		}

		return fundType;
	}

	/**
	 * Returns the fund type where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the matching fund type, or <code>null</code> if a matching fund type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType fetchByGroupId_Name(long groupId, String name)
		throws SystemException {
		return fetchByGroupId_Name(groupId, name, true);
	}

	/**
	 * Returns the fund type where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching fund type, or <code>null</code> if a matching fund type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType fetchByGroupId_Name(long groupId, String name,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPID_NAME,
					finderArgs, this);
		}

		if (result instanceof FundType) {
			FundType fundType = (FundType)result;

			if ((groupId != fundType.getGroupId()) ||
					!Validator.equals(name, fundType.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_FUNDTYPE_WHERE);

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

				List<FundType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_NAME,
						finderArgs, list);
				}
				else {
					FundType fundType = list.get(0);

					result = fundType;

					cacheResult(fundType);

					if ((fundType.getGroupId() != groupId) ||
							(fundType.getName() == null) ||
							!fundType.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_NAME,
							finderArgs, fundType);
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
			return (FundType)result;
		}
	}

	/**
	 * Removes the fund type where groupId = &#63; and name = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the fund type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType removeByGroupId_Name(long groupId, String name)
		throws NoSuchFundTypeException, SystemException {
		FundType fundType = findByGroupId_Name(groupId, name);

		return remove(fundType);
	}

	/**
	 * Returns the number of fund types where groupId = &#63; and name = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @return the number of matching fund types
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

			query.append(_SQL_COUNT_FUNDTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_NAME_GROUPID_2 = "fundType.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_NAME_NAME_1 = "fundType.name IS NULL";
	private static final String _FINDER_COLUMN_GROUPID_NAME_NAME_2 = "fundType.name = ?";
	private static final String _FINDER_COLUMN_GROUPID_NAME_NAME_3 = "(fundType.name IS NULL OR fundType.name = '')";

	public FundTypePersistenceImpl() {
		setModelClass(FundType.class);
	}

	/**
	 * Caches the fund type in the entity cache if it is enabled.
	 *
	 * @param fundType the fund type
	 */
	@Override
	public void cacheResult(FundType fundType) {
		EntityCacheUtil.putResult(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
			FundTypeImpl.class, fundType.getPrimaryKey(), fundType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_NAME,
			new Object[] { fundType.getGroupId(), fundType.getName() }, fundType);

		fundType.resetOriginalValues();
	}

	/**
	 * Caches the fund types in the entity cache if it is enabled.
	 *
	 * @param fundTypes the fund types
	 */
	@Override
	public void cacheResult(List<FundType> fundTypes) {
		for (FundType fundType : fundTypes) {
			if (EntityCacheUtil.getResult(
						FundTypeModelImpl.ENTITY_CACHE_ENABLED,
						FundTypeImpl.class, fundType.getPrimaryKey()) == null) {
				cacheResult(fundType);
			}
			else {
				fundType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fund types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FundTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FundTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fund type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FundType fundType) {
		EntityCacheUtil.removeResult(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
			FundTypeImpl.class, fundType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(fundType);
	}

	@Override
	public void clearCache(List<FundType> fundTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FundType fundType : fundTypes) {
			EntityCacheUtil.removeResult(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
				FundTypeImpl.class, fundType.getPrimaryKey());

			clearUniqueFindersCache(fundType);
		}
	}

	protected void cacheUniqueFindersCache(FundType fundType) {
		if (fundType.isNew()) {
			Object[] args = new Object[] {
					fundType.getGroupId(), fundType.getName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_NAME, args,
				fundType);
		}
		else {
			FundTypeModelImpl fundTypeModelImpl = (FundTypeModelImpl)fundType;

			if ((fundTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GROUPID_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundType.getGroupId(), fundType.getName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_NAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_NAME,
					args, fundType);
			}
		}
	}

	protected void clearUniqueFindersCache(FundType fundType) {
		FundTypeModelImpl fundTypeModelImpl = (FundTypeModelImpl)fundType;

		Object[] args = new Object[] { fundType.getGroupId(), fundType.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_NAME, args);

		if ((fundTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GROUPID_NAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					fundTypeModelImpl.getOriginalGroupId(),
					fundTypeModelImpl.getOriginalName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_NAME, args);
		}
	}

	/**
	 * Creates a new fund type with the primary key. Does not add the fund type to the database.
	 *
	 * @param fundTypeId the primary key for the new fund type
	 * @return the new fund type
	 */
	@Override
	public FundType create(long fundTypeId) {
		FundType fundType = new FundTypeImpl();

		fundType.setNew(true);
		fundType.setPrimaryKey(fundTypeId);

		return fundType;
	}

	/**
	 * Removes the fund type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fundTypeId the primary key of the fund type
	 * @return the fund type that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundTypeException if a fund type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType remove(long fundTypeId)
		throws NoSuchFundTypeException, SystemException {
		return remove((Serializable)fundTypeId);
	}

	/**
	 * Removes the fund type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fund type
	 * @return the fund type that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundTypeException if a fund type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType remove(Serializable primaryKey)
		throws NoSuchFundTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FundType fundType = (FundType)session.get(FundTypeImpl.class,
					primaryKey);

			if (fundType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFundTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(fundType);
		}
		catch (NoSuchFundTypeException nsee) {
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
	protected FundType removeImpl(FundType fundType) throws SystemException {
		fundType = toUnwrappedModel(fundType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fundType)) {
				fundType = (FundType)session.get(FundTypeImpl.class,
						fundType.getPrimaryKeyObj());
			}

			if (fundType != null) {
				session.delete(fundType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (fundType != null) {
			clearCache(fundType);
		}

		return fundType;
	}

	@Override
	public FundType updateImpl(cmr.fandenatech.ndjangui.model.FundType fundType)
		throws SystemException {
		fundType = toUnwrappedModel(fundType);

		boolean isNew = fundType.isNew();

		FundTypeModelImpl fundTypeModelImpl = (FundTypeModelImpl)fundType;

		Session session = null;

		try {
			session = openSession();

			if (fundType.isNew()) {
				session.save(fundType);

				fundType.setNew(false);
			}
			else {
				session.merge(fundType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FundTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((fundTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundTypeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { fundTypeModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((fundTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundTypeModelImpl.getOriginalGroupId(),
						fundTypeModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);

				args = new Object[] {
						fundTypeModelImpl.getGroupId(),
						fundTypeModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
			FundTypeImpl.class, fundType.getPrimaryKey(), fundType);

		clearUniqueFindersCache(fundType);
		cacheUniqueFindersCache(fundType);

		return fundType;
	}

	protected FundType toUnwrappedModel(FundType fundType) {
		if (fundType instanceof FundTypeImpl) {
			return fundType;
		}

		FundTypeImpl fundTypeImpl = new FundTypeImpl();

		fundTypeImpl.setNew(fundType.isNew());
		fundTypeImpl.setPrimaryKey(fundType.getPrimaryKey());

		fundTypeImpl.setFundTypeId(fundType.getFundTypeId());
		fundTypeImpl.setUserId(fundType.getUserId());
		fundTypeImpl.setGroupId(fundType.getGroupId());
		fundTypeImpl.setCompanyId(fundType.getCompanyId());
		fundTypeImpl.setUserName(fundType.getUserName());
		fundTypeImpl.setCreateDate(fundType.getCreateDate());
		fundTypeImpl.setModifiedDate(fundType.getModifiedDate());
		fundTypeImpl.setName(fundType.getName());
		fundTypeImpl.setShortDescription(fundType.getShortDescription());
		fundTypeImpl.setStatus(fundType.getStatus());

		return fundTypeImpl;
	}

	/**
	 * Returns the fund type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fund type
	 * @return the fund type
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundTypeException if a fund type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFundTypeException, SystemException {
		FundType fundType = fetchByPrimaryKey(primaryKey);

		if (fundType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFundTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return fundType;
	}

	/**
	 * Returns the fund type with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchFundTypeException} if it could not be found.
	 *
	 * @param fundTypeId the primary key of the fund type
	 * @return the fund type
	 * @throws cmr.fandenatech.ndjangui.NoSuchFundTypeException if a fund type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType findByPrimaryKey(long fundTypeId)
		throws NoSuchFundTypeException, SystemException {
		return findByPrimaryKey((Serializable)fundTypeId);
	}

	/**
	 * Returns the fund type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fund type
	 * @return the fund type, or <code>null</code> if a fund type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FundType fundType = (FundType)EntityCacheUtil.getResult(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
				FundTypeImpl.class, primaryKey);

		if (fundType == _nullFundType) {
			return null;
		}

		if (fundType == null) {
			Session session = null;

			try {
				session = openSession();

				fundType = (FundType)session.get(FundTypeImpl.class, primaryKey);

				if (fundType != null) {
					cacheResult(fundType);
				}
				else {
					EntityCacheUtil.putResult(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
						FundTypeImpl.class, primaryKey, _nullFundType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FundTypeModelImpl.ENTITY_CACHE_ENABLED,
					FundTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return fundType;
	}

	/**
	 * Returns the fund type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fundTypeId the primary key of the fund type
	 * @return the fund type, or <code>null</code> if a fund type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FundType fetchByPrimaryKey(long fundTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)fundTypeId);
	}

	/**
	 * Returns all the fund types.
	 *
	 * @return the fund types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FundType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund types
	 * @param end the upper bound of the range of fund types (not inclusive)
	 * @return the range of fund types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FundType> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund types
	 * @param end the upper bound of the range of fund types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fund types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FundType> findAll(int start, int end,
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

		List<FundType> list = (List<FundType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FUNDTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FUNDTYPE;

				if (pagination) {
					sql = sql.concat(FundTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FundType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FundType>(list);
				}
				else {
					list = (List<FundType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the fund types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FundType fundType : findAll()) {
			remove(fundType);
		}
	}

	/**
	 * Returns the number of fund types.
	 *
	 * @return the number of fund types
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

				Query q = session.createQuery(_SQL_COUNT_FUNDTYPE);

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
	 * Initializes the fund type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.cmr.fandenatech.ndjangui.model.FundType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FundType>> listenersList = new ArrayList<ModelListener<FundType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FundType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FundTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FUNDTYPE = "SELECT fundType FROM FundType fundType";
	private static final String _SQL_SELECT_FUNDTYPE_WHERE = "SELECT fundType FROM FundType fundType WHERE ";
	private static final String _SQL_COUNT_FUNDTYPE = "SELECT COUNT(fundType) FROM FundType fundType";
	private static final String _SQL_COUNT_FUNDTYPE_WHERE = "SELECT COUNT(fundType) FROM FundType fundType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "fundType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FundType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FundType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FundTypePersistenceImpl.class);
	private static FundType _nullFundType = new FundTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FundType> toCacheModel() {
				return _nullFundTypeCacheModel;
			}
		};

	private static CacheModel<FundType> _nullFundTypeCacheModel = new CacheModel<FundType>() {
			@Override
			public FundType toEntityModel() {
				return _nullFundType;
			}
		};
}