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

import cmr.fandenatech.ndjangui.NoSuchOperationException;
import cmr.fandenatech.ndjangui.model.Operation;
import cmr.fandenatech.ndjangui.model.impl.OperationImpl;
import cmr.fandenatech.ndjangui.model.impl.OperationModelImpl;

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
 * The persistence implementation for the operation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see OperationPersistence
 * @see OperationUtil
 * @generated
 */
public class OperationPersistenceImpl extends BasePersistenceImpl<Operation>
	implements OperationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OperationUtil} to access the operation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OperationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OperationModelImpl.ENTITY_CACHE_ENABLED,
			OperationModelImpl.FINDER_CACHE_ENABLED, OperationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OperationModelImpl.ENTITY_CACHE_ENABLED,
			OperationModelImpl.FINDER_CACHE_ENABLED, OperationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OperationModelImpl.ENTITY_CACHE_ENABLED,
			OperationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(OperationModelImpl.ENTITY_CACHE_ENABLED,
			OperationModelImpl.FINDER_CACHE_ENABLED, OperationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(OperationModelImpl.ENTITY_CACHE_ENABLED,
			OperationModelImpl.FINDER_CACHE_ENABLED, OperationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			OperationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(OperationModelImpl.ENTITY_CACHE_ENABLED,
			OperationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the operations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching operations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Operation> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the operations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @return the range of matching operations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Operation> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the operations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching operations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Operation> findByGroupId(long groupId, int start, int end,
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

		List<Operation> list = (List<Operation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Operation operation : list) {
				if ((groupId != operation.getGroupId())) {
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

			query.append(_SQL_SELECT_OPERATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OperationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Operation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Operation>(list);
				}
				else {
					list = (List<Operation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first operation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation
	 * @throws cmr.fandenatech.ndjangui.NoSuchOperationException if a matching operation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOperationException, SystemException {
		Operation operation = fetchByGroupId_First(groupId, orderByComparator);

		if (operation != null) {
			return operation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOperationException(msg.toString());
	}

	/**
	 * Returns the first operation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation, or <code>null</code> if a matching operation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Operation> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last operation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation
	 * @throws cmr.fandenatech.ndjangui.NoSuchOperationException if a matching operation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOperationException, SystemException {
		Operation operation = fetchByGroupId_Last(groupId, orderByComparator);

		if (operation != null) {
			return operation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOperationException(msg.toString());
	}

	/**
	 * Returns the last operation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation, or <code>null</code> if a matching operation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Operation> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the operations before and after the current operation in the ordered set where groupId = &#63;.
	 *
	 * @param operationId the primary key of the current operation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next operation
	 * @throws cmr.fandenatech.ndjangui.NoSuchOperationException if a operation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation[] findByGroupId_PrevAndNext(long operationId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchOperationException, SystemException {
		Operation operation = findByPrimaryKey(operationId);

		Session session = null;

		try {
			session = openSession();

			Operation[] array = new OperationImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, operation, groupId,
					orderByComparator, true);

			array[1] = operation;

			array[2] = getByGroupId_PrevAndNext(session, operation, groupId,
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

	protected Operation getByGroupId_PrevAndNext(Session session,
		Operation operation, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OPERATION_WHERE);

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
			query.append(OperationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(operation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Operation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the operations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Operation operation : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(operation);
		}
	}

	/**
	 * Returns the number of operations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching operations
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

			query.append(_SQL_COUNT_OPERATION_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "operation.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(OperationModelImpl.ENTITY_CACHE_ENABLED,
			OperationModelImpl.FINDER_CACHE_ENABLED, OperationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId_Status",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(OperationModelImpl.ENTITY_CACHE_ENABLED,
			OperationModelImpl.FINDER_CACHE_ENABLED, OperationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() },
			OperationModelImpl.GROUPID_COLUMN_BITMASK |
			OperationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_STATUS = new FinderPath(OperationModelImpl.ENTITY_CACHE_ENABLED,
			OperationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the operations where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching operations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Operation> findByGroupId_Status(long groupId, int status)
		throws SystemException {
		return findByGroupId_Status(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the operations where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @return the range of matching operations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Operation> findByGroupId_Status(long groupId, int status,
		int start, int end) throws SystemException {
		return findByGroupId_Status(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the operations where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching operations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Operation> findByGroupId_Status(long groupId, int status,
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

		List<Operation> list = (List<Operation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Operation operation : list) {
				if ((groupId != operation.getGroupId()) ||
						(status != operation.getStatus())) {
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

			query.append(_SQL_SELECT_OPERATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OperationModelImpl.ORDER_BY_JPQL);
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
					list = (List<Operation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Operation>(list);
				}
				else {
					list = (List<Operation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first operation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation
	 * @throws cmr.fandenatech.ndjangui.NoSuchOperationException if a matching operation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation findByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchOperationException, SystemException {
		Operation operation = fetchByGroupId_Status_First(groupId, status,
				orderByComparator);

		if (operation != null) {
			return operation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOperationException(msg.toString());
	}

	/**
	 * Returns the first operation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation, or <code>null</code> if a matching operation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation fetchByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Operation> list = findByGroupId_Status(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last operation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation
	 * @throws cmr.fandenatech.ndjangui.NoSuchOperationException if a matching operation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation findByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchOperationException, SystemException {
		Operation operation = fetchByGroupId_Status_Last(groupId, status,
				orderByComparator);

		if (operation != null) {
			return operation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOperationException(msg.toString());
	}

	/**
	 * Returns the last operation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation, or <code>null</code> if a matching operation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation fetchByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId_Status(groupId, status);

		if (count == 0) {
			return null;
		}

		List<Operation> list = findByGroupId_Status(groupId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the operations before and after the current operation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param operationId the primary key of the current operation
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next operation
	 * @throws cmr.fandenatech.ndjangui.NoSuchOperationException if a operation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation[] findByGroupId_Status_PrevAndNext(long operationId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws NoSuchOperationException, SystemException {
		Operation operation = findByPrimaryKey(operationId);

		Session session = null;

		try {
			session = openSession();

			Operation[] array = new OperationImpl[3];

			array[0] = getByGroupId_Status_PrevAndNext(session, operation,
					groupId, status, orderByComparator, true);

			array[1] = operation;

			array[2] = getByGroupId_Status_PrevAndNext(session, operation,
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

	protected Operation getByGroupId_Status_PrevAndNext(Session session,
		Operation operation, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OPERATION_WHERE);

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
			query.append(OperationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(operation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Operation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the operations where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId_Status(long groupId, int status)
		throws SystemException {
		for (Operation operation : findByGroupId_Status(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(operation);
		}
	}

	/**
	 * Returns the number of operations where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching operations
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

			query.append(_SQL_COUNT_OPERATION_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_STATUS_GROUPID_2 = "operation.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_STATUS_STATUS_2 = "operation.status = ?";

	public OperationPersistenceImpl() {
		setModelClass(Operation.class);
	}

	/**
	 * Caches the operation in the entity cache if it is enabled.
	 *
	 * @param operation the operation
	 */
	@Override
	public void cacheResult(Operation operation) {
		EntityCacheUtil.putResult(OperationModelImpl.ENTITY_CACHE_ENABLED,
			OperationImpl.class, operation.getPrimaryKey(), operation);

		operation.resetOriginalValues();
	}

	/**
	 * Caches the operations in the entity cache if it is enabled.
	 *
	 * @param operations the operations
	 */
	@Override
	public void cacheResult(List<Operation> operations) {
		for (Operation operation : operations) {
			if (EntityCacheUtil.getResult(
						OperationModelImpl.ENTITY_CACHE_ENABLED,
						OperationImpl.class, operation.getPrimaryKey()) == null) {
				cacheResult(operation);
			}
			else {
				operation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all operations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OperationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OperationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the operation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Operation operation) {
		EntityCacheUtil.removeResult(OperationModelImpl.ENTITY_CACHE_ENABLED,
			OperationImpl.class, operation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Operation> operations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Operation operation : operations) {
			EntityCacheUtil.removeResult(OperationModelImpl.ENTITY_CACHE_ENABLED,
				OperationImpl.class, operation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new operation with the primary key. Does not add the operation to the database.
	 *
	 * @param operationId the primary key for the new operation
	 * @return the new operation
	 */
	@Override
	public Operation create(long operationId) {
		Operation operation = new OperationImpl();

		operation.setNew(true);
		operation.setPrimaryKey(operationId);

		return operation;
	}

	/**
	 * Removes the operation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param operationId the primary key of the operation
	 * @return the operation that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchOperationException if a operation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation remove(long operationId)
		throws NoSuchOperationException, SystemException {
		return remove((Serializable)operationId);
	}

	/**
	 * Removes the operation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the operation
	 * @return the operation that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchOperationException if a operation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation remove(Serializable primaryKey)
		throws NoSuchOperationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Operation operation = (Operation)session.get(OperationImpl.class,
					primaryKey);

			if (operation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOperationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(operation);
		}
		catch (NoSuchOperationException nsee) {
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
	protected Operation removeImpl(Operation operation)
		throws SystemException {
		operation = toUnwrappedModel(operation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(operation)) {
				operation = (Operation)session.get(OperationImpl.class,
						operation.getPrimaryKeyObj());
			}

			if (operation != null) {
				session.delete(operation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (operation != null) {
			clearCache(operation);
		}

		return operation;
	}

	@Override
	public Operation updateImpl(
		cmr.fandenatech.ndjangui.model.Operation operation)
		throws SystemException {
		operation = toUnwrappedModel(operation);

		boolean isNew = operation.isNew();

		OperationModelImpl operationModelImpl = (OperationModelImpl)operation;

		Session session = null;

		try {
			session = openSession();

			if (operation.isNew()) {
				session.save(operation);

				operation.setNew(false);
			}
			else {
				session.merge(operation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OperationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((operationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						operationModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { operationModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((operationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						operationModelImpl.getOriginalGroupId(),
						operationModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);

				args = new Object[] {
						operationModelImpl.getGroupId(),
						operationModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(OperationModelImpl.ENTITY_CACHE_ENABLED,
			OperationImpl.class, operation.getPrimaryKey(), operation);

		return operation;
	}

	protected Operation toUnwrappedModel(Operation operation) {
		if (operation instanceof OperationImpl) {
			return operation;
		}

		OperationImpl operationImpl = new OperationImpl();

		operationImpl.setNew(operation.isNew());
		operationImpl.setPrimaryKey(operation.getPrimaryKey());

		operationImpl.setOperationId(operation.getOperationId());
		operationImpl.setUserId(operation.getUserId());
		operationImpl.setGroupId(operation.getGroupId());
		operationImpl.setCompanyId(operation.getCompanyId());
		operationImpl.setUserName(operation.getUserName());
		operationImpl.setCreateDate(operation.getCreateDate());
		operationImpl.setModifiedDate(operation.getModifiedDate());
		operationImpl.setBudgetPeriodId(operation.getBudgetPeriodId());
		operationImpl.setName(operation.getName());
		operationImpl.setShortDescription(operation.getShortDescription());
		operationImpl.setOperationTypeId(operation.getOperationTypeId());
		operationImpl.setSittingId(operation.getSittingId());
		operationImpl.setStatus(operation.getStatus());
		operationImpl.setAmount(operation.getAmount());
		operationImpl.setSrcFundClassPK(operation.getSrcFundClassPK());
		operationImpl.setSrcFundClassName(operation.getSrcFundClassName());
		operationImpl.setDestFundClassPK(operation.getDestFundClassPK());
		operationImpl.setDestFundClassName(operation.getDestFundClassName());

		return operationImpl;
	}

	/**
	 * Returns the operation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the operation
	 * @return the operation
	 * @throws cmr.fandenatech.ndjangui.NoSuchOperationException if a operation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOperationException, SystemException {
		Operation operation = fetchByPrimaryKey(primaryKey);

		if (operation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOperationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return operation;
	}

	/**
	 * Returns the operation with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchOperationException} if it could not be found.
	 *
	 * @param operationId the primary key of the operation
	 * @return the operation
	 * @throws cmr.fandenatech.ndjangui.NoSuchOperationException if a operation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation findByPrimaryKey(long operationId)
		throws NoSuchOperationException, SystemException {
		return findByPrimaryKey((Serializable)operationId);
	}

	/**
	 * Returns the operation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the operation
	 * @return the operation, or <code>null</code> if a operation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Operation operation = (Operation)EntityCacheUtil.getResult(OperationModelImpl.ENTITY_CACHE_ENABLED,
				OperationImpl.class, primaryKey);

		if (operation == _nullOperation) {
			return null;
		}

		if (operation == null) {
			Session session = null;

			try {
				session = openSession();

				operation = (Operation)session.get(OperationImpl.class,
						primaryKey);

				if (operation != null) {
					cacheResult(operation);
				}
				else {
					EntityCacheUtil.putResult(OperationModelImpl.ENTITY_CACHE_ENABLED,
						OperationImpl.class, primaryKey, _nullOperation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OperationModelImpl.ENTITY_CACHE_ENABLED,
					OperationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return operation;
	}

	/**
	 * Returns the operation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param operationId the primary key of the operation
	 * @return the operation, or <code>null</code> if a operation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation fetchByPrimaryKey(long operationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)operationId);
	}

	/**
	 * Returns all the operations.
	 *
	 * @return the operations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Operation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the operations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @return the range of operations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Operation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the operations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of operations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Operation> findAll(int start, int end,
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

		List<Operation> list = (List<Operation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OPERATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OPERATION;

				if (pagination) {
					sql = sql.concat(OperationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Operation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Operation>(list);
				}
				else {
					list = (List<Operation>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the operations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Operation operation : findAll()) {
			remove(operation);
		}
	}

	/**
	 * Returns the number of operations.
	 *
	 * @return the number of operations
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

				Query q = session.createQuery(_SQL_COUNT_OPERATION);

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
	 * Initializes the operation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.cmr.fandenatech.ndjangui.model.Operation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Operation>> listenersList = new ArrayList<ModelListener<Operation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Operation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OperationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OPERATION = "SELECT operation FROM Operation operation";
	private static final String _SQL_SELECT_OPERATION_WHERE = "SELECT operation FROM Operation operation WHERE ";
	private static final String _SQL_COUNT_OPERATION = "SELECT COUNT(operation) FROM Operation operation";
	private static final String _SQL_COUNT_OPERATION_WHERE = "SELECT COUNT(operation) FROM Operation operation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "operation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Operation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Operation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OperationPersistenceImpl.class);
	private static Operation _nullOperation = new OperationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Operation> toCacheModel() {
				return _nullOperationCacheModel;
			}
		};

	private static CacheModel<Operation> _nullOperationCacheModel = new CacheModel<Operation>() {
			@Override
			public Operation toEntityModel() {
				return _nullOperation;
			}
		};
}