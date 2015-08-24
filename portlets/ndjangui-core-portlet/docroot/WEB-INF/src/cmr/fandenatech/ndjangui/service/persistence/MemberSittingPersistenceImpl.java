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

import cmr.fandenatech.ndjangui.NoSuchMemberSittingException;
import cmr.fandenatech.ndjangui.model.MemberSitting;
import cmr.fandenatech.ndjangui.model.impl.MemberSittingImpl;
import cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl;

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
 * The persistence implementation for the member sitting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see MemberSittingPersistence
 * @see MemberSittingUtil
 * @generated
 */
public class MemberSittingPersistenceImpl extends BasePersistenceImpl<MemberSitting>
	implements MemberSittingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MemberSittingUtil} to access the member sitting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MemberSittingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
			MemberSittingModelImpl.FINDER_CACHE_ENABLED,
			MemberSittingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
			MemberSittingModelImpl.FINDER_CACHE_ENABLED,
			MemberSittingImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
			MemberSittingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
			MemberSittingModelImpl.FINDER_CACHE_ENABLED,
			MemberSittingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
			MemberSittingModelImpl.FINDER_CACHE_ENABLED,
			MemberSittingImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] { Long.class.getName() },
			MemberSittingModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
			MemberSittingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the member sittings where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching member sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MemberSitting> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the member sittings where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of member sittings
	 * @param end the upper bound of the range of member sittings (not inclusive)
	 * @return the range of matching member sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MemberSitting> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the member sittings where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of member sittings
	 * @param end the upper bound of the range of member sittings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching member sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MemberSitting> findByGroupId(long groupId, int start, int end,
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

		List<MemberSitting> list = (List<MemberSitting>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MemberSitting memberSitting : list) {
				if ((groupId != memberSitting.getGroupId())) {
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

			query.append(_SQL_SELECT_MEMBERSITTING_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MemberSittingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<MemberSitting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MemberSitting>(list);
				}
				else {
					list = (List<MemberSitting>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first member sitting in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a matching member sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMemberSittingException, SystemException {
		MemberSitting memberSitting = fetchByGroupId_First(groupId,
				orderByComparator);

		if (memberSitting != null) {
			return memberSitting;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMemberSittingException(msg.toString());
	}

	/**
	 * Returns the first member sitting in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member sitting, or <code>null</code> if a matching member sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<MemberSitting> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last member sitting in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a matching member sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMemberSittingException, SystemException {
		MemberSitting memberSitting = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (memberSitting != null) {
			return memberSitting;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMemberSittingException(msg.toString());
	}

	/**
	 * Returns the last member sitting in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member sitting, or <code>null</code> if a matching member sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<MemberSitting> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the member sittings before and after the current member sitting in the ordered set where groupId = &#63;.
	 *
	 * @param memberSittingId the primary key of the current member sitting
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a member sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting[] findByGroupId_PrevAndNext(long memberSittingId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchMemberSittingException, SystemException {
		MemberSitting memberSitting = findByPrimaryKey(memberSittingId);

		Session session = null;

		try {
			session = openSession();

			MemberSitting[] array = new MemberSittingImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, memberSitting,
					groupId, orderByComparator, true);

			array[1] = memberSitting;

			array[2] = getByGroupId_PrevAndNext(session, memberSitting,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MemberSitting getByGroupId_PrevAndNext(Session session,
		MemberSitting memberSitting, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSITTING_WHERE);

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
			query.append(MemberSittingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(memberSitting);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MemberSitting> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the member sittings where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (MemberSitting memberSitting : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(memberSitting);
		}
	}

	/**
	 * Returns the number of member sittings where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching member sittings
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

			query.append(_SQL_COUNT_MEMBERSITTING_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "memberSitting.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID_SITTINGID =
		new FinderPath(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
			MemberSittingModelImpl.FINDER_CACHE_ENABLED,
			MemberSittingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId_SittingId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_SITTINGID =
		new FinderPath(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
			MemberSittingModelImpl.FINDER_CACHE_ENABLED,
			MemberSittingImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId_SittingId",
			new String[] { Long.class.getName(), Long.class.getName() },
			MemberSittingModelImpl.GROUPID_COLUMN_BITMASK |
			MemberSittingModelImpl.SITTINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_SITTINGID = new FinderPath(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
			MemberSittingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupId_SittingId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the member sittings where groupId = &#63; and sittingId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param sittingId the sitting ID
	 * @return the matching member sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MemberSitting> findByGroupId_SittingId(long groupId,
		long sittingId) throws SystemException {
		return findByGroupId_SittingId(groupId, sittingId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the member sittings where groupId = &#63; and sittingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param sittingId the sitting ID
	 * @param start the lower bound of the range of member sittings
	 * @param end the upper bound of the range of member sittings (not inclusive)
	 * @return the range of matching member sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MemberSitting> findByGroupId_SittingId(long groupId,
		long sittingId, int start, int end) throws SystemException {
		return findByGroupId_SittingId(groupId, sittingId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the member sittings where groupId = &#63; and sittingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param sittingId the sitting ID
	 * @param start the lower bound of the range of member sittings
	 * @param end the upper bound of the range of member sittings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching member sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MemberSitting> findByGroupId_SittingId(long groupId,
		long sittingId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_SITTINGID;
			finderArgs = new Object[] { groupId, sittingId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID_SITTINGID;
			finderArgs = new Object[] {
					groupId, sittingId,
					
					start, end, orderByComparator
				};
		}

		List<MemberSitting> list = (List<MemberSitting>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MemberSitting memberSitting : list) {
				if ((groupId != memberSitting.getGroupId()) ||
						(sittingId != memberSitting.getSittingId())) {
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

			query.append(_SQL_SELECT_MEMBERSITTING_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_SITTINGID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_SITTINGID_SITTINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MemberSittingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(sittingId);

				if (!pagination) {
					list = (List<MemberSitting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MemberSitting>(list);
				}
				else {
					list = (List<MemberSitting>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first member sitting in the ordered set where groupId = &#63; and sittingId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param sittingId the sitting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a matching member sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting findByGroupId_SittingId_First(long groupId,
		long sittingId, OrderByComparator orderByComparator)
		throws NoSuchMemberSittingException, SystemException {
		MemberSitting memberSitting = fetchByGroupId_SittingId_First(groupId,
				sittingId, orderByComparator);

		if (memberSitting != null) {
			return memberSitting;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", sittingId=");
		msg.append(sittingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMemberSittingException(msg.toString());
	}

	/**
	 * Returns the first member sitting in the ordered set where groupId = &#63; and sittingId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param sittingId the sitting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member sitting, or <code>null</code> if a matching member sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting fetchByGroupId_SittingId_First(long groupId,
		long sittingId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MemberSitting> list = findByGroupId_SittingId(groupId, sittingId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last member sitting in the ordered set where groupId = &#63; and sittingId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param sittingId the sitting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a matching member sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting findByGroupId_SittingId_Last(long groupId,
		long sittingId, OrderByComparator orderByComparator)
		throws NoSuchMemberSittingException, SystemException {
		MemberSitting memberSitting = fetchByGroupId_SittingId_Last(groupId,
				sittingId, orderByComparator);

		if (memberSitting != null) {
			return memberSitting;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", sittingId=");
		msg.append(sittingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMemberSittingException(msg.toString());
	}

	/**
	 * Returns the last member sitting in the ordered set where groupId = &#63; and sittingId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param sittingId the sitting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member sitting, or <code>null</code> if a matching member sitting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting fetchByGroupId_SittingId_Last(long groupId,
		long sittingId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupId_SittingId(groupId, sittingId);

		if (count == 0) {
			return null;
		}

		List<MemberSitting> list = findByGroupId_SittingId(groupId, sittingId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the member sittings before and after the current member sitting in the ordered set where groupId = &#63; and sittingId = &#63;.
	 *
	 * @param memberSittingId the primary key of the current member sitting
	 * @param groupId the group ID
	 * @param sittingId the sitting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a member sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting[] findByGroupId_SittingId_PrevAndNext(
		long memberSittingId, long groupId, long sittingId,
		OrderByComparator orderByComparator)
		throws NoSuchMemberSittingException, SystemException {
		MemberSitting memberSitting = findByPrimaryKey(memberSittingId);

		Session session = null;

		try {
			session = openSession();

			MemberSitting[] array = new MemberSittingImpl[3];

			array[0] = getByGroupId_SittingId_PrevAndNext(session,
					memberSitting, groupId, sittingId, orderByComparator, true);

			array[1] = memberSitting;

			array[2] = getByGroupId_SittingId_PrevAndNext(session,
					memberSitting, groupId, sittingId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MemberSitting getByGroupId_SittingId_PrevAndNext(
		Session session, MemberSitting memberSitting, long groupId,
		long sittingId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSITTING_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_SITTINGID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPID_SITTINGID_SITTINGID_2);

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
			query.append(MemberSittingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(sittingId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(memberSitting);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MemberSitting> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the member sittings where groupId = &#63; and sittingId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param sittingId the sitting ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId_SittingId(long groupId, long sittingId)
		throws SystemException {
		for (MemberSitting memberSitting : findByGroupId_SittingId(groupId,
				sittingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(memberSitting);
		}
	}

	/**
	 * Returns the number of member sittings where groupId = &#63; and sittingId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param sittingId the sitting ID
	 * @return the number of matching member sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId_SittingId(long groupId, long sittingId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID_SITTINGID;

		Object[] finderArgs = new Object[] { groupId, sittingId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MEMBERSITTING_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_SITTINGID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_SITTINGID_SITTINGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(sittingId);

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

	private static final String _FINDER_COLUMN_GROUPID_SITTINGID_GROUPID_2 = "memberSitting.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_SITTINGID_SITTINGID_2 = "memberSitting.sittingId = ?";

	public MemberSittingPersistenceImpl() {
		setModelClass(MemberSitting.class);
	}

	/**
	 * Caches the member sitting in the entity cache if it is enabled.
	 *
	 * @param memberSitting the member sitting
	 */
	@Override
	public void cacheResult(MemberSitting memberSitting) {
		EntityCacheUtil.putResult(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
			MemberSittingImpl.class, memberSitting.getPrimaryKey(),
			memberSitting);

		memberSitting.resetOriginalValues();
	}

	/**
	 * Caches the member sittings in the entity cache if it is enabled.
	 *
	 * @param memberSittings the member sittings
	 */
	@Override
	public void cacheResult(List<MemberSitting> memberSittings) {
		for (MemberSitting memberSitting : memberSittings) {
			if (EntityCacheUtil.getResult(
						MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
						MemberSittingImpl.class, memberSitting.getPrimaryKey()) == null) {
				cacheResult(memberSitting);
			}
			else {
				memberSitting.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all member sittings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MemberSittingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MemberSittingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the member sitting.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MemberSitting memberSitting) {
		EntityCacheUtil.removeResult(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
			MemberSittingImpl.class, memberSitting.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MemberSitting> memberSittings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MemberSitting memberSitting : memberSittings) {
			EntityCacheUtil.removeResult(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
				MemberSittingImpl.class, memberSitting.getPrimaryKey());
		}
	}

	/**
	 * Creates a new member sitting with the primary key. Does not add the member sitting to the database.
	 *
	 * @param memberSittingId the primary key for the new member sitting
	 * @return the new member sitting
	 */
	@Override
	public MemberSitting create(long memberSittingId) {
		MemberSitting memberSitting = new MemberSittingImpl();

		memberSitting.setNew(true);
		memberSitting.setPrimaryKey(memberSittingId);

		return memberSitting;
	}

	/**
	 * Removes the member sitting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberSittingId the primary key of the member sitting
	 * @return the member sitting that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a member sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting remove(long memberSittingId)
		throws NoSuchMemberSittingException, SystemException {
		return remove((Serializable)memberSittingId);
	}

	/**
	 * Removes the member sitting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the member sitting
	 * @return the member sitting that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a member sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting remove(Serializable primaryKey)
		throws NoSuchMemberSittingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MemberSitting memberSitting = (MemberSitting)session.get(MemberSittingImpl.class,
					primaryKey);

			if (memberSitting == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMemberSittingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(memberSitting);
		}
		catch (NoSuchMemberSittingException nsee) {
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
	protected MemberSitting removeImpl(MemberSitting memberSitting)
		throws SystemException {
		memberSitting = toUnwrappedModel(memberSitting);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(memberSitting)) {
				memberSitting = (MemberSitting)session.get(MemberSittingImpl.class,
						memberSitting.getPrimaryKeyObj());
			}

			if (memberSitting != null) {
				session.delete(memberSitting);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (memberSitting != null) {
			clearCache(memberSitting);
		}

		return memberSitting;
	}

	@Override
	public MemberSitting updateImpl(
		cmr.fandenatech.ndjangui.model.MemberSitting memberSitting)
		throws SystemException {
		memberSitting = toUnwrappedModel(memberSitting);

		boolean isNew = memberSitting.isNew();

		MemberSittingModelImpl memberSittingModelImpl = (MemberSittingModelImpl)memberSitting;

		Session session = null;

		try {
			session = openSession();

			if (memberSitting.isNew()) {
				session.save(memberSitting);

				memberSitting.setNew(false);
			}
			else {
				session.merge(memberSitting);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MemberSittingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((memberSittingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						memberSittingModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { memberSittingModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((memberSittingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_SITTINGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						memberSittingModelImpl.getOriginalGroupId(),
						memberSittingModelImpl.getOriginalSittingId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_SITTINGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_SITTINGID,
					args);

				args = new Object[] {
						memberSittingModelImpl.getGroupId(),
						memberSittingModelImpl.getSittingId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_SITTINGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_SITTINGID,
					args);
			}
		}

		EntityCacheUtil.putResult(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
			MemberSittingImpl.class, memberSitting.getPrimaryKey(),
			memberSitting);

		return memberSitting;
	}

	protected MemberSitting toUnwrappedModel(MemberSitting memberSitting) {
		if (memberSitting instanceof MemberSittingImpl) {
			return memberSitting;
		}

		MemberSittingImpl memberSittingImpl = new MemberSittingImpl();

		memberSittingImpl.setNew(memberSitting.isNew());
		memberSittingImpl.setPrimaryKey(memberSitting.getPrimaryKey());

		memberSittingImpl.setMemberSittingId(memberSitting.getMemberSittingId());
		memberSittingImpl.setUserId(memberSitting.getUserId());
		memberSittingImpl.setGroupId(memberSitting.getGroupId());
		memberSittingImpl.setCompanyId(memberSitting.getCompanyId());
		memberSittingImpl.setUserName(memberSitting.getUserName());
		memberSittingImpl.setCreateDate(memberSitting.getCreateDate());
		memberSittingImpl.setModifiedDate(memberSitting.getModifiedDate());
		memberSittingImpl.setMemberId(memberSitting.getMemberId());
		memberSittingImpl.setSittingId(memberSitting.getSittingId());
		memberSittingImpl.setMemberName(memberSitting.getMemberName());
		memberSittingImpl.setSittingName(memberSitting.getSittingName());

		return memberSittingImpl;
	}

	/**
	 * Returns the member sitting with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the member sitting
	 * @return the member sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a member sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMemberSittingException, SystemException {
		MemberSitting memberSitting = fetchByPrimaryKey(primaryKey);

		if (memberSitting == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMemberSittingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return memberSitting;
	}

	/**
	 * Returns the member sitting with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchMemberSittingException} if it could not be found.
	 *
	 * @param memberSittingId the primary key of the member sitting
	 * @return the member sitting
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a member sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting findByPrimaryKey(long memberSittingId)
		throws NoSuchMemberSittingException, SystemException {
		return findByPrimaryKey((Serializable)memberSittingId);
	}

	/**
	 * Returns the member sitting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the member sitting
	 * @return the member sitting, or <code>null</code> if a member sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MemberSitting memberSitting = (MemberSitting)EntityCacheUtil.getResult(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
				MemberSittingImpl.class, primaryKey);

		if (memberSitting == _nullMemberSitting) {
			return null;
		}

		if (memberSitting == null) {
			Session session = null;

			try {
				session = openSession();

				memberSitting = (MemberSitting)session.get(MemberSittingImpl.class,
						primaryKey);

				if (memberSitting != null) {
					cacheResult(memberSitting);
				}
				else {
					EntityCacheUtil.putResult(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
						MemberSittingImpl.class, primaryKey, _nullMemberSitting);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MemberSittingModelImpl.ENTITY_CACHE_ENABLED,
					MemberSittingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return memberSitting;
	}

	/**
	 * Returns the member sitting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberSittingId the primary key of the member sitting
	 * @return the member sitting, or <code>null</code> if a member sitting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberSitting fetchByPrimaryKey(long memberSittingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)memberSittingId);
	}

	/**
	 * Returns all the member sittings.
	 *
	 * @return the member sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MemberSitting> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the member sittings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of member sittings
	 * @param end the upper bound of the range of member sittings (not inclusive)
	 * @return the range of member sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MemberSitting> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the member sittings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of member sittings
	 * @param end the upper bound of the range of member sittings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of member sittings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MemberSitting> findAll(int start, int end,
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

		List<MemberSitting> list = (List<MemberSitting>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBERSITTING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBERSITTING;

				if (pagination) {
					sql = sql.concat(MemberSittingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MemberSitting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MemberSitting>(list);
				}
				else {
					list = (List<MemberSitting>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the member sittings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MemberSitting memberSitting : findAll()) {
			remove(memberSitting);
		}
	}

	/**
	 * Returns the number of member sittings.
	 *
	 * @return the number of member sittings
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

				Query q = session.createQuery(_SQL_COUNT_MEMBERSITTING);

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
	 * Initializes the member sitting persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.cmr.fandenatech.ndjangui.model.MemberSitting")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MemberSitting>> listenersList = new ArrayList<ModelListener<MemberSitting>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MemberSitting>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MemberSittingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MEMBERSITTING = "SELECT memberSitting FROM MemberSitting memberSitting";
	private static final String _SQL_SELECT_MEMBERSITTING_WHERE = "SELECT memberSitting FROM MemberSitting memberSitting WHERE ";
	private static final String _SQL_COUNT_MEMBERSITTING = "SELECT COUNT(memberSitting) FROM MemberSitting memberSitting";
	private static final String _SQL_COUNT_MEMBERSITTING_WHERE = "SELECT COUNT(memberSitting) FROM MemberSitting memberSitting WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "memberSitting.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MemberSitting exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MemberSitting exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MemberSittingPersistenceImpl.class);
	private static MemberSitting _nullMemberSitting = new MemberSittingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MemberSitting> toCacheModel() {
				return _nullMemberSittingCacheModel;
			}
		};

	private static CacheModel<MemberSitting> _nullMemberSittingCacheModel = new CacheModel<MemberSitting>() {
			@Override
			public MemberSitting toEntityModel() {
				return _nullMemberSitting;
			}
		};
}