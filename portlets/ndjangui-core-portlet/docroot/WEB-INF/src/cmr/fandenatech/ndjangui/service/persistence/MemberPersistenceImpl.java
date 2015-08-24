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

import cmr.fandenatech.ndjangui.NoSuchMemberException;
import cmr.fandenatech.ndjangui.model.Member;
import cmr.fandenatech.ndjangui.model.impl.MemberImpl;
import cmr.fandenatech.ndjangui.model.impl.MemberModelImpl;

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
 * The persistence implementation for the member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see MemberPersistence
 * @see MemberUtil
 * @generated
 */
public class MemberPersistenceImpl extends BasePersistenceImpl<Member>
	implements MemberPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MemberUtil} to access the member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MemberImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, MemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, MemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, MemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, MemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			MemberModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the members where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching members
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Member> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the members where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of matching members
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Member> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the members where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching members
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Member> findByGroupId(long groupId, int start, int end,
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

		List<Member> list = (List<Member>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Member member : list) {
				if ((groupId != member.getGroupId())) {
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

			query.append(_SQL_SELECT_MEMBER__WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MemberModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Member>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Member>(list);
				}
				else {
					list = (List<Member>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first member in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberException if a matching member could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMemberException, SystemException {
		Member member = fetchByGroupId_First(groupId, orderByComparator);

		if (member != null) {
			return member;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMemberException(msg.toString());
	}

	/**
	 * Returns the first member in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member, or <code>null</code> if a matching member could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Member> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last member in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberException if a matching member could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMemberException, SystemException {
		Member member = fetchByGroupId_Last(groupId, orderByComparator);

		if (member != null) {
			return member;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMemberException(msg.toString());
	}

	/**
	 * Returns the last member in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member, or <code>null</code> if a matching member could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Member> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the members before and after the current member in the ordered set where groupId = &#63;.
	 *
	 * @param memberId the primary key of the current member
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberException if a member with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member[] findByGroupId_PrevAndNext(long memberId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMemberException, SystemException {
		Member member = findByPrimaryKey(memberId);

		Session session = null;

		try {
			session = openSession();

			Member[] array = new MemberImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, member, groupId,
					orderByComparator, true);

			array[1] = member;

			array[2] = getByGroupId_PrevAndNext(session, member, groupId,
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

	protected Member getByGroupId_PrevAndNext(Session session, Member member,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBER__WHERE);

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
			query.append(MemberModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(member);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Member> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the members where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Member member : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(member);
		}
	}

	/**
	 * Returns the number of members where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching members
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

			query.append(_SQL_COUNT_MEMBER__WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "member_.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPID_EMAIL = new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, MemberImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByGroupId_Email",
			new String[] { Long.class.getName(), String.class.getName() },
			MemberModelImpl.GROUPID_COLUMN_BITMASK |
			MemberModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_EMAIL = new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId_Email",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the member where groupId = &#63; and email = &#63; or throws a {@link cmr.fandenatech.ndjangui.NoSuchMemberException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param email the email
	 * @return the matching member
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberException if a matching member could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member findByGroupId_Email(long groupId, String email)
		throws NoSuchMemberException, SystemException {
		Member member = fetchByGroupId_Email(groupId, email);

		if (member == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMemberException(msg.toString());
		}

		return member;
	}

	/**
	 * Returns the member where groupId = &#63; and email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param email the email
	 * @return the matching member, or <code>null</code> if a matching member could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member fetchByGroupId_Email(long groupId, String email)
		throws SystemException {
		return fetchByGroupId_Email(groupId, email, true);
	}

	/**
	 * Returns the member where groupId = &#63; and email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param email the email
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching member, or <code>null</code> if a matching member could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member fetchByGroupId_Email(long groupId, String email,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, email };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPID_EMAIL,
					finderArgs, this);
		}

		if (result instanceof Member) {
			Member member = (Member)result;

			if ((groupId != member.getGroupId()) ||
					!Validator.equals(email, member.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MEMBER__WHERE);

			query.append(_FINDER_COLUMN_GROUPID_EMAIL_GROUPID_2);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_GROUPID_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPID_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_GROUPID_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindEmail) {
					qPos.add(email);
				}

				List<Member> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_EMAIL,
						finderArgs, list);
				}
				else {
					Member member = list.get(0);

					result = member;

					cacheResult(member);

					if ((member.getGroupId() != groupId) ||
							(member.getEmail() == null) ||
							!member.getEmail().equals(email)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_EMAIL,
							finderArgs, member);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_EMAIL,
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
			return (Member)result;
		}
	}

	/**
	 * Removes the member where groupId = &#63; and email = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param email the email
	 * @return the member that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member removeByGroupId_Email(long groupId, String email)
		throws NoSuchMemberException, SystemException {
		Member member = findByGroupId_Email(groupId, email);

		return remove(member);
	}

	/**
	 * Returns the number of members where groupId = &#63; and email = &#63;.
	 *
	 * @param groupId the group ID
	 * @param email the email
	 * @return the number of matching members
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId_Email(long groupId, String email)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID_EMAIL;

		Object[] finderArgs = new Object[] { groupId, email };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MEMBER__WHERE);

			query.append(_FINDER_COLUMN_GROUPID_EMAIL_GROUPID_2);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_GROUPID_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPID_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_GROUPID_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindEmail) {
					qPos.add(email);
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

	private static final String _FINDER_COLUMN_GROUPID_EMAIL_GROUPID_2 = "member_.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_EMAIL_EMAIL_1 = "member_.email IS NULL";
	private static final String _FINDER_COLUMN_GROUPID_EMAIL_EMAIL_2 = "member_.email = ?";
	private static final String _FINDER_COLUMN_GROUPID_EMAIL_EMAIL_3 = "(member_.email IS NULL OR member_.email = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPID_CARDNUMBER = new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, MemberImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByGroupId_CardNumber",
			new String[] { Long.class.getName(), String.class.getName() },
			MemberModelImpl.GROUPID_COLUMN_BITMASK |
			MemberModelImpl.CARDNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_CARDNUMBER = new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupId_CardNumber",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the member where groupId = &#63; and cardNumber = &#63; or throws a {@link cmr.fandenatech.ndjangui.NoSuchMemberException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param cardNumber the card number
	 * @return the matching member
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberException if a matching member could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member findByGroupId_CardNumber(long groupId, String cardNumber)
		throws NoSuchMemberException, SystemException {
		Member member = fetchByGroupId_CardNumber(groupId, cardNumber);

		if (member == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", cardNumber=");
			msg.append(cardNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMemberException(msg.toString());
		}

		return member;
	}

	/**
	 * Returns the member where groupId = &#63; and cardNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param cardNumber the card number
	 * @return the matching member, or <code>null</code> if a matching member could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member fetchByGroupId_CardNumber(long groupId, String cardNumber)
		throws SystemException {
		return fetchByGroupId_CardNumber(groupId, cardNumber, true);
	}

	/**
	 * Returns the member where groupId = &#63; and cardNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param cardNumber the card number
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching member, or <code>null</code> if a matching member could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member fetchByGroupId_CardNumber(long groupId, String cardNumber,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, cardNumber };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPID_CARDNUMBER,
					finderArgs, this);
		}

		if (result instanceof Member) {
			Member member = (Member)result;

			if ((groupId != member.getGroupId()) ||
					!Validator.equals(cardNumber, member.getCardNumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MEMBER__WHERE);

			query.append(_FINDER_COLUMN_GROUPID_CARDNUMBER_GROUPID_2);

			boolean bindCardNumber = false;

			if (cardNumber == null) {
				query.append(_FINDER_COLUMN_GROUPID_CARDNUMBER_CARDNUMBER_1);
			}
			else if (cardNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPID_CARDNUMBER_CARDNUMBER_3);
			}
			else {
				bindCardNumber = true;

				query.append(_FINDER_COLUMN_GROUPID_CARDNUMBER_CARDNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindCardNumber) {
					qPos.add(cardNumber);
				}

				List<Member> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_CARDNUMBER,
						finderArgs, list);
				}
				else {
					Member member = list.get(0);

					result = member;

					cacheResult(member);

					if ((member.getGroupId() != groupId) ||
							(member.getCardNumber() == null) ||
							!member.getCardNumber().equals(cardNumber)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_CARDNUMBER,
							finderArgs, member);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_CARDNUMBER,
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
			return (Member)result;
		}
	}

	/**
	 * Removes the member where groupId = &#63; and cardNumber = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param cardNumber the card number
	 * @return the member that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member removeByGroupId_CardNumber(long groupId, String cardNumber)
		throws NoSuchMemberException, SystemException {
		Member member = findByGroupId_CardNumber(groupId, cardNumber);

		return remove(member);
	}

	/**
	 * Returns the number of members where groupId = &#63; and cardNumber = &#63;.
	 *
	 * @param groupId the group ID
	 * @param cardNumber the card number
	 * @return the number of matching members
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId_CardNumber(long groupId, String cardNumber)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID_CARDNUMBER;

		Object[] finderArgs = new Object[] { groupId, cardNumber };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MEMBER__WHERE);

			query.append(_FINDER_COLUMN_GROUPID_CARDNUMBER_GROUPID_2);

			boolean bindCardNumber = false;

			if (cardNumber == null) {
				query.append(_FINDER_COLUMN_GROUPID_CARDNUMBER_CARDNUMBER_1);
			}
			else if (cardNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPID_CARDNUMBER_CARDNUMBER_3);
			}
			else {
				bindCardNumber = true;

				query.append(_FINDER_COLUMN_GROUPID_CARDNUMBER_CARDNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindCardNumber) {
					qPos.add(cardNumber);
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

	private static final String _FINDER_COLUMN_GROUPID_CARDNUMBER_GROUPID_2 = "member_.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_CARDNUMBER_CARDNUMBER_1 = "member_.cardNumber IS NULL";
	private static final String _FINDER_COLUMN_GROUPID_CARDNUMBER_CARDNUMBER_2 = "member_.cardNumber = ?";
	private static final String _FINDER_COLUMN_GROUPID_CARDNUMBER_CARDNUMBER_3 = "(member_.cardNumber IS NULL OR member_.cardNumber = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, MemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId_Status",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS =
		new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, MemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() },
			MemberModelImpl.GROUPID_COLUMN_BITMASK |
			MemberModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_STATUS = new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the members where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching members
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Member> findByGroupId_Status(long groupId, int status)
		throws SystemException {
		return findByGroupId_Status(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the members where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of matching members
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Member> findByGroupId_Status(long groupId, int status,
		int start, int end) throws SystemException {
		return findByGroupId_Status(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the members where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching members
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Member> findByGroupId_Status(long groupId, int status,
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

		List<Member> list = (List<Member>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Member member : list) {
				if ((groupId != member.getGroupId()) ||
						(status != member.getStatus())) {
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

			query.append(_SQL_SELECT_MEMBER__WHERE);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MemberModelImpl.ORDER_BY_JPQL);
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
					list = (List<Member>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Member>(list);
				}
				else {
					list = (List<Member>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first member in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberException if a matching member could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member findByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchMemberException, SystemException {
		Member member = fetchByGroupId_Status_First(groupId, status,
				orderByComparator);

		if (member != null) {
			return member;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMemberException(msg.toString());
	}

	/**
	 * Returns the first member in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member, or <code>null</code> if a matching member could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member fetchByGroupId_Status_First(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Member> list = findByGroupId_Status(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last member in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberException if a matching member could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member findByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchMemberException, SystemException {
		Member member = fetchByGroupId_Status_Last(groupId, status,
				orderByComparator);

		if (member != null) {
			return member;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMemberException(msg.toString());
	}

	/**
	 * Returns the last member in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member, or <code>null</code> if a matching member could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member fetchByGroupId_Status_Last(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId_Status(groupId, status);

		if (count == 0) {
			return null;
		}

		List<Member> list = findByGroupId_Status(groupId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the members before and after the current member in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param memberId the primary key of the current member
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberException if a member with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member[] findByGroupId_Status_PrevAndNext(long memberId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws NoSuchMemberException, SystemException {
		Member member = findByPrimaryKey(memberId);

		Session session = null;

		try {
			session = openSession();

			Member[] array = new MemberImpl[3];

			array[0] = getByGroupId_Status_PrevAndNext(session, member,
					groupId, status, orderByComparator, true);

			array[1] = member;

			array[2] = getByGroupId_Status_PrevAndNext(session, member,
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

	protected Member getByGroupId_Status_PrevAndNext(Session session,
		Member member, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBER__WHERE);

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
			query.append(MemberModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(member);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Member> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the members where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId_Status(long groupId, int status)
		throws SystemException {
		for (Member member : findByGroupId_Status(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(member);
		}
	}

	/**
	 * Returns the number of members where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching members
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

			query.append(_SQL_COUNT_MEMBER__WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_STATUS_GROUPID_2 = "member_.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_STATUS_STATUS_2 = "member_.status = ?";

	public MemberPersistenceImpl() {
		setModelClass(Member.class);
	}

	/**
	 * Caches the member in the entity cache if it is enabled.
	 *
	 * @param member the member
	 */
	@Override
	public void cacheResult(Member member) {
		EntityCacheUtil.putResult(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberImpl.class, member.getPrimaryKey(), member);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_EMAIL,
			new Object[] { member.getGroupId(), member.getEmail() }, member);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_CARDNUMBER,
			new Object[] { member.getGroupId(), member.getCardNumber() }, member);

		member.resetOriginalValues();
	}

	/**
	 * Caches the members in the entity cache if it is enabled.
	 *
	 * @param members the members
	 */
	@Override
	public void cacheResult(List<Member> members) {
		for (Member member : members) {
			if (EntityCacheUtil.getResult(
						MemberModelImpl.ENTITY_CACHE_ENABLED, MemberImpl.class,
						member.getPrimaryKey()) == null) {
				cacheResult(member);
			}
			else {
				member.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all members.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MemberImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MemberImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the member.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Member member) {
		EntityCacheUtil.removeResult(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberImpl.class, member.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(member);
	}

	@Override
	public void clearCache(List<Member> members) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Member member : members) {
			EntityCacheUtil.removeResult(MemberModelImpl.ENTITY_CACHE_ENABLED,
				MemberImpl.class, member.getPrimaryKey());

			clearUniqueFindersCache(member);
		}
	}

	protected void cacheUniqueFindersCache(Member member) {
		if (member.isNew()) {
			Object[] args = new Object[] { member.getGroupId(), member.getEmail() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_EMAIL, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_EMAIL, args,
				member);

			args = new Object[] { member.getGroupId(), member.getCardNumber() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_CARDNUMBER,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_CARDNUMBER,
				args, member);
		}
		else {
			MemberModelImpl memberModelImpl = (MemberModelImpl)member;

			if ((memberModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GROUPID_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						member.getGroupId(), member.getEmail()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_EMAIL,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_EMAIL,
					args, member);
			}

			if ((memberModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GROUPID_CARDNUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						member.getGroupId(), member.getCardNumber()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_CARDNUMBER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_CARDNUMBER,
					args, member);
			}
		}
	}

	protected void clearUniqueFindersCache(Member member) {
		MemberModelImpl memberModelImpl = (MemberModelImpl)member;

		Object[] args = new Object[] { member.getGroupId(), member.getEmail() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_EMAIL, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_EMAIL, args);

		if ((memberModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GROUPID_EMAIL.getColumnBitmask()) != 0) {
			args = new Object[] {
					memberModelImpl.getOriginalGroupId(),
					memberModelImpl.getOriginalEmail()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_EMAIL,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_EMAIL,
				args);
		}

		args = new Object[] { member.getGroupId(), member.getCardNumber() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_CARDNUMBER,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_CARDNUMBER,
			args);

		if ((memberModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GROUPID_CARDNUMBER.getColumnBitmask()) != 0) {
			args = new Object[] {
					memberModelImpl.getOriginalGroupId(),
					memberModelImpl.getOriginalCardNumber()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_CARDNUMBER,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_CARDNUMBER,
				args);
		}
	}

	/**
	 * Creates a new member with the primary key. Does not add the member to the database.
	 *
	 * @param memberId the primary key for the new member
	 * @return the new member
	 */
	@Override
	public Member create(long memberId) {
		Member member = new MemberImpl();

		member.setNew(true);
		member.setPrimaryKey(memberId);

		return member;
	}

	/**
	 * Removes the member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the member
	 * @return the member that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberException if a member with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member remove(long memberId)
		throws NoSuchMemberException, SystemException {
		return remove((Serializable)memberId);
	}

	/**
	 * Removes the member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the member
	 * @return the member that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberException if a member with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member remove(Serializable primaryKey)
		throws NoSuchMemberException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Member member = (Member)session.get(MemberImpl.class, primaryKey);

			if (member == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMemberException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(member);
		}
		catch (NoSuchMemberException nsee) {
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
	protected Member removeImpl(Member member) throws SystemException {
		member = toUnwrappedModel(member);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(member)) {
				member = (Member)session.get(MemberImpl.class,
						member.getPrimaryKeyObj());
			}

			if (member != null) {
				session.delete(member);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (member != null) {
			clearCache(member);
		}

		return member;
	}

	@Override
	public Member updateImpl(cmr.fandenatech.ndjangui.model.Member member)
		throws SystemException {
		member = toUnwrappedModel(member);

		boolean isNew = member.isNew();

		MemberModelImpl memberModelImpl = (MemberModelImpl)member;

		Session session = null;

		try {
			session = openSession();

			if (member.isNew()) {
				session.save(member);

				member.setNew(false);
			}
			else {
				session.merge(member);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MemberModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((memberModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						memberModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { memberModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((memberModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						memberModelImpl.getOriginalGroupId(),
						memberModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);

				args = new Object[] {
						memberModelImpl.getGroupId(),
						memberModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberImpl.class, member.getPrimaryKey(), member);

		clearUniqueFindersCache(member);
		cacheUniqueFindersCache(member);

		return member;
	}

	protected Member toUnwrappedModel(Member member) {
		if (member instanceof MemberImpl) {
			return member;
		}

		MemberImpl memberImpl = new MemberImpl();

		memberImpl.setNew(member.isNew());
		memberImpl.setPrimaryKey(member.getPrimaryKey());

		memberImpl.setMemberId(member.getMemberId());
		memberImpl.setUserId(member.getUserId());
		memberImpl.setGroupId(member.getGroupId());
		memberImpl.setCompanyId(member.getCompanyId());
		memberImpl.setUserName(member.getUserName());
		memberImpl.setCreateDate(member.getCreateDate());
		memberImpl.setModifiedDate(member.getModifiedDate());
		memberImpl.setName(member.getName());
		memberImpl.setSurname(member.getSurname());
		memberImpl.setFullname(member.getFullname());
		memberImpl.setEmail(member.getEmail());
		memberImpl.setCardNumber(member.getCardNumber());
		memberImpl.setPhoneNumber(member.getPhoneNumber());
		memberImpl.setRate(member.getRate());
		memberImpl.setStatus(member.getStatus());

		return memberImpl;
	}

	/**
	 * Returns the member with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the member
	 * @return the member
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberException if a member with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMemberException, SystemException {
		Member member = fetchByPrimaryKey(primaryKey);

		if (member == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMemberException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return member;
	}

	/**
	 * Returns the member with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchMemberException} if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberException if a member with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member findByPrimaryKey(long memberId)
		throws NoSuchMemberException, SystemException {
		return findByPrimaryKey((Serializable)memberId);
	}

	/**
	 * Returns the member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the member
	 * @return the member, or <code>null</code> if a member with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Member member = (Member)EntityCacheUtil.getResult(MemberModelImpl.ENTITY_CACHE_ENABLED,
				MemberImpl.class, primaryKey);

		if (member == _nullMember) {
			return null;
		}

		if (member == null) {
			Session session = null;

			try {
				session = openSession();

				member = (Member)session.get(MemberImpl.class, primaryKey);

				if (member != null) {
					cacheResult(member);
				}
				else {
					EntityCacheUtil.putResult(MemberModelImpl.ENTITY_CACHE_ENABLED,
						MemberImpl.class, primaryKey, _nullMember);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MemberModelImpl.ENTITY_CACHE_ENABLED,
					MemberImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return member;
	}

	/**
	 * Returns the member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member, or <code>null</code> if a member with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member fetchByPrimaryKey(long memberId) throws SystemException {
		return fetchByPrimaryKey((Serializable)memberId);
	}

	/**
	 * Returns all the members.
	 *
	 * @return the members
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Member> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of members
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Member> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of members
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Member> findAll(int start, int end,
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

		List<Member> list = (List<Member>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBER_);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBER_;

				if (pagination) {
					sql = sql.concat(MemberModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Member>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Member>(list);
				}
				else {
					list = (List<Member>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the members from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Member member : findAll()) {
			remove(member);
		}
	}

	/**
	 * Returns the number of members.
	 *
	 * @return the number of members
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

				Query q = session.createQuery(_SQL_COUNT_MEMBER_);

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
	 * Initializes the member persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.cmr.fandenatech.ndjangui.model.Member")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Member>> listenersList = new ArrayList<ModelListener<Member>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Member>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MemberImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MEMBER_ = "SELECT member_ FROM Member member_";
	private static final String _SQL_SELECT_MEMBER__WHERE = "SELECT member_ FROM Member member_ WHERE ";
	private static final String _SQL_COUNT_MEMBER_ = "SELECT COUNT(member_) FROM Member member_";
	private static final String _SQL_COUNT_MEMBER__WHERE = "SELECT COUNT(member_) FROM Member member_ WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "member_.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Member exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Member exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MemberPersistenceImpl.class);
	private static Member _nullMember = new MemberImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Member> toCacheModel() {
				return _nullMemberCacheModel;
			}
		};

	private static CacheModel<Member> _nullMemberCacheModel = new CacheModel<Member>() {
			@Override
			public Member toEntityModel() {
				return _nullMember;
			}
		};
}