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
import com.ndjangui.notificationcenter.model.impl.NotificaMessageImpl;
import com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl;
import com.xpiping.notificationcenter.NoSuchNotificaMessageException;
import com.xpiping.notificationcenter.model.NotificaMessage;
import com.xpiping.notificationcenter.service.persistence.NotificaMessagePersistence;
import com.xpiping.notificationcenter.service.persistence.NotificaMessageUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the notifica message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcoleo
 * @see NotificaMessagePersistence
 * @see NotificaMessageUtil
 * @generated
 */
public class NotificaMessagePersistenceImpl extends BasePersistenceImpl<NotificaMessage>
	implements NotificaMessagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NotificaMessageUtil} to access the notifica message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NotificaMessageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
			NotificaMessageModelImpl.FINDER_CACHE_ENABLED,
			NotificaMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
			NotificaMessageModelImpl.FINDER_CACHE_ENABLED,
			NotificaMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
			NotificaMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTIFICAID =
		new FinderPath(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
			NotificaMessageModelImpl.FINDER_CACHE_ENABLED,
			NotificaMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNotificaId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICAID =
		new FinderPath(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
			NotificaMessageModelImpl.FINDER_CACHE_ENABLED,
			NotificaMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNotificaId",
			new String[] { Long.class.getName() },
			NotificaMessageModelImpl.NOTIFICAID_COLUMN_BITMASK |
			NotificaMessageModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NOTIFICAID = new FinderPath(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
			NotificaMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNotificaId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the notifica messages where notificaId = &#63;.
	 *
	 * @param notificaId the notifica ID
	 * @return the matching notifica messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaMessage> findByNotificaId(long notificaId)
		throws SystemException {
		return findByNotificaId(notificaId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notifica messages where notificaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param notificaId the notifica ID
	 * @param start the lower bound of the range of notifica messages
	 * @param end the upper bound of the range of notifica messages (not inclusive)
	 * @return the range of matching notifica messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaMessage> findByNotificaId(long notificaId, int start,
		int end) throws SystemException {
		return findByNotificaId(notificaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notifica messages where notificaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param notificaId the notifica ID
	 * @param start the lower bound of the range of notifica messages
	 * @param end the upper bound of the range of notifica messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notifica messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaMessage> findByNotificaId(long notificaId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICAID;
			finderArgs = new Object[] { notificaId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTIFICAID;
			finderArgs = new Object[] { notificaId, start, end, orderByComparator };
		}

		List<NotificaMessage> list = (List<NotificaMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (NotificaMessage notificaMessage : list) {
				if ((notificaId != notificaMessage.getNotificaId())) {
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

			query.append(_SQL_SELECT_NOTIFICAMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_NOTIFICAID_NOTIFICAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NotificaMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(notificaId);

				if (!pagination) {
					list = (List<NotificaMessage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NotificaMessage>(list);
				}
				else {
					list = (List<NotificaMessage>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first notifica message in the ordered set where notificaId = &#63;.
	 *
	 * @param notificaId the notifica ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notifica message
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a matching notifica message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage findByNotificaId_First(long notificaId,
		OrderByComparator orderByComparator)
		throws NoSuchNotificaMessageException, SystemException {
		NotificaMessage notificaMessage = fetchByNotificaId_First(notificaId,
				orderByComparator);

		if (notificaMessage != null) {
			return notificaMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("notificaId=");
		msg.append(notificaId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificaMessageException(msg.toString());
	}

	/**
	 * Returns the first notifica message in the ordered set where notificaId = &#63;.
	 *
	 * @param notificaId the notifica ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notifica message, or <code>null</code> if a matching notifica message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage fetchByNotificaId_First(long notificaId,
		OrderByComparator orderByComparator) throws SystemException {
		List<NotificaMessage> list = findByNotificaId(notificaId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notifica message in the ordered set where notificaId = &#63;.
	 *
	 * @param notificaId the notifica ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notifica message
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a matching notifica message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage findByNotificaId_Last(long notificaId,
		OrderByComparator orderByComparator)
		throws NoSuchNotificaMessageException, SystemException {
		NotificaMessage notificaMessage = fetchByNotificaId_Last(notificaId,
				orderByComparator);

		if (notificaMessage != null) {
			return notificaMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("notificaId=");
		msg.append(notificaId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificaMessageException(msg.toString());
	}

	/**
	 * Returns the last notifica message in the ordered set where notificaId = &#63;.
	 *
	 * @param notificaId the notifica ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notifica message, or <code>null</code> if a matching notifica message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage fetchByNotificaId_Last(long notificaId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNotificaId(notificaId);

		if (count == 0) {
			return null;
		}

		List<NotificaMessage> list = findByNotificaId(notificaId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notifica messages before and after the current notifica message in the ordered set where notificaId = &#63;.
	 *
	 * @param notificaMessageId the primary key of the current notifica message
	 * @param notificaId the notifica ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notifica message
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a notifica message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage[] findByNotificaId_PrevAndNext(
		long notificaMessageId, long notificaId,
		OrderByComparator orderByComparator)
		throws NoSuchNotificaMessageException, SystemException {
		NotificaMessage notificaMessage = findByPrimaryKey(notificaMessageId);

		Session session = null;

		try {
			session = openSession();

			NotificaMessage[] array = new NotificaMessageImpl[3];

			array[0] = getByNotificaId_PrevAndNext(session, notificaMessage,
					notificaId, orderByComparator, true);

			array[1] = notificaMessage;

			array[2] = getByNotificaId_PrevAndNext(session, notificaMessage,
					notificaId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected NotificaMessage getByNotificaId_PrevAndNext(Session session,
		NotificaMessage notificaMessage, long notificaId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NOTIFICAMESSAGE_WHERE);

		query.append(_FINDER_COLUMN_NOTIFICAID_NOTIFICAID_2);

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
			query.append(NotificaMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(notificaId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notificaMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NotificaMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notifica messages where notificaId = &#63; from the database.
	 *
	 * @param notificaId the notifica ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNotificaId(long notificaId) throws SystemException {
		for (NotificaMessage notificaMessage : findByNotificaId(notificaId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(notificaMessage);
		}
	}

	/**
	 * Returns the number of notifica messages where notificaId = &#63;.
	 *
	 * @param notificaId the notifica ID
	 * @return the number of matching notifica messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNotificaId(long notificaId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NOTIFICAID;

		Object[] finderArgs = new Object[] { notificaId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NOTIFICAMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_NOTIFICAID_NOTIFICAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(notificaId);

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

	private static final String _FINDER_COLUMN_NOTIFICAID_NOTIFICAID_2 = "notificaMessage.notificaId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_N_E_E = new FinderPath(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
			NotificaMessageModelImpl.FINDER_CACHE_ENABLED,
			NotificaMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByN_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_E_E = new FinderPath(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
			NotificaMessageModelImpl.FINDER_CACHE_ENABLED,
			NotificaMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByN_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			NotificaMessageModelImpl.NOTIFICAID_COLUMN_BITMASK |
			NotificaMessageModelImpl.ENTITYNAME_COLUMN_BITMASK |
			NotificaMessageModelImpl.ENTITYID_COLUMN_BITMASK |
			NotificaMessageModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_N_E_E = new FinderPath(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
			NotificaMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByN_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the notifica messages where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	 *
	 * @param notificaId the notifica ID
	 * @param entityName the entity name
	 * @param entityId the entity ID
	 * @return the matching notifica messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaMessage> findByN_E_E(long notificaId,
		String entityName, long entityId) throws SystemException {
		return findByN_E_E(notificaId, entityName, entityId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notifica messages where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param notificaId the notifica ID
	 * @param entityName the entity name
	 * @param entityId the entity ID
	 * @param start the lower bound of the range of notifica messages
	 * @param end the upper bound of the range of notifica messages (not inclusive)
	 * @return the range of matching notifica messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaMessage> findByN_E_E(long notificaId,
		String entityName, long entityId, int start, int end)
		throws SystemException {
		return findByN_E_E(notificaId, entityName, entityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notifica messages where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param notificaId the notifica ID
	 * @param entityName the entity name
	 * @param entityId the entity ID
	 * @param start the lower bound of the range of notifica messages
	 * @param end the upper bound of the range of notifica messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notifica messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaMessage> findByN_E_E(long notificaId,
		String entityName, long entityId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_E_E;
			finderArgs = new Object[] { notificaId, entityName, entityId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_N_E_E;
			finderArgs = new Object[] {
					notificaId, entityName, entityId,
					
					start, end, orderByComparator
				};
		}

		List<NotificaMessage> list = (List<NotificaMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (NotificaMessage notificaMessage : list) {
				if ((notificaId != notificaMessage.getNotificaId()) ||
						!Validator.equals(entityName,
							notificaMessage.getEntityName()) ||
						(entityId != notificaMessage.getEntityId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_NOTIFICAMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_N_E_E_NOTIFICAID_2);

			boolean bindEntityName = false;

			if (entityName == null) {
				query.append(_FINDER_COLUMN_N_E_E_ENTITYNAME_1);
			}
			else if (entityName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_E_E_ENTITYNAME_3);
			}
			else {
				bindEntityName = true;

				query.append(_FINDER_COLUMN_N_E_E_ENTITYNAME_2);
			}

			query.append(_FINDER_COLUMN_N_E_E_ENTITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NotificaMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(notificaId);

				if (bindEntityName) {
					qPos.add(entityName);
				}

				qPos.add(entityId);

				if (!pagination) {
					list = (List<NotificaMessage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NotificaMessage>(list);
				}
				else {
					list = (List<NotificaMessage>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first notifica message in the ordered set where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	 *
	 * @param notificaId the notifica ID
	 * @param entityName the entity name
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notifica message
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a matching notifica message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage findByN_E_E_First(long notificaId,
		String entityName, long entityId, OrderByComparator orderByComparator)
		throws NoSuchNotificaMessageException, SystemException {
		NotificaMessage notificaMessage = fetchByN_E_E_First(notificaId,
				entityName, entityId, orderByComparator);

		if (notificaMessage != null) {
			return notificaMessage;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("notificaId=");
		msg.append(notificaId);

		msg.append(", entityName=");
		msg.append(entityName);

		msg.append(", entityId=");
		msg.append(entityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificaMessageException(msg.toString());
	}

	/**
	 * Returns the first notifica message in the ordered set where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	 *
	 * @param notificaId the notifica ID
	 * @param entityName the entity name
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notifica message, or <code>null</code> if a matching notifica message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage fetchByN_E_E_First(long notificaId,
		String entityName, long entityId, OrderByComparator orderByComparator)
		throws SystemException {
		List<NotificaMessage> list = findByN_E_E(notificaId, entityName,
				entityId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notifica message in the ordered set where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	 *
	 * @param notificaId the notifica ID
	 * @param entityName the entity name
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notifica message
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a matching notifica message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage findByN_E_E_Last(long notificaId, String entityName,
		long entityId, OrderByComparator orderByComparator)
		throws NoSuchNotificaMessageException, SystemException {
		NotificaMessage notificaMessage = fetchByN_E_E_Last(notificaId,
				entityName, entityId, orderByComparator);

		if (notificaMessage != null) {
			return notificaMessage;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("notificaId=");
		msg.append(notificaId);

		msg.append(", entityName=");
		msg.append(entityName);

		msg.append(", entityId=");
		msg.append(entityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificaMessageException(msg.toString());
	}

	/**
	 * Returns the last notifica message in the ordered set where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	 *
	 * @param notificaId the notifica ID
	 * @param entityName the entity name
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notifica message, or <code>null</code> if a matching notifica message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage fetchByN_E_E_Last(long notificaId,
		String entityName, long entityId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByN_E_E(notificaId, entityName, entityId);

		if (count == 0) {
			return null;
		}

		List<NotificaMessage> list = findByN_E_E(notificaId, entityName,
				entityId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notifica messages before and after the current notifica message in the ordered set where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	 *
	 * @param notificaMessageId the primary key of the current notifica message
	 * @param notificaId the notifica ID
	 * @param entityName the entity name
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notifica message
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a notifica message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage[] findByN_E_E_PrevAndNext(long notificaMessageId,
		long notificaId, String entityName, long entityId,
		OrderByComparator orderByComparator)
		throws NoSuchNotificaMessageException, SystemException {
		NotificaMessage notificaMessage = findByPrimaryKey(notificaMessageId);

		Session session = null;

		try {
			session = openSession();

			NotificaMessage[] array = new NotificaMessageImpl[3];

			array[0] = getByN_E_E_PrevAndNext(session, notificaMessage,
					notificaId, entityName, entityId, orderByComparator, true);

			array[1] = notificaMessage;

			array[2] = getByN_E_E_PrevAndNext(session, notificaMessage,
					notificaId, entityName, entityId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected NotificaMessage getByN_E_E_PrevAndNext(Session session,
		NotificaMessage notificaMessage, long notificaId, String entityName,
		long entityId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NOTIFICAMESSAGE_WHERE);

		query.append(_FINDER_COLUMN_N_E_E_NOTIFICAID_2);

		boolean bindEntityName = false;

		if (entityName == null) {
			query.append(_FINDER_COLUMN_N_E_E_ENTITYNAME_1);
		}
		else if (entityName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_N_E_E_ENTITYNAME_3);
		}
		else {
			bindEntityName = true;

			query.append(_FINDER_COLUMN_N_E_E_ENTITYNAME_2);
		}

		query.append(_FINDER_COLUMN_N_E_E_ENTITYID_2);

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
			query.append(NotificaMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(notificaId);

		if (bindEntityName) {
			qPos.add(entityName);
		}

		qPos.add(entityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notificaMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NotificaMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notifica messages where notificaId = &#63; and entityName = &#63; and entityId = &#63; from the database.
	 *
	 * @param notificaId the notifica ID
	 * @param entityName the entity name
	 * @param entityId the entity ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByN_E_E(long notificaId, String entityName, long entityId)
		throws SystemException {
		for (NotificaMessage notificaMessage : findByN_E_E(notificaId,
				entityName, entityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(notificaMessage);
		}
	}

	/**
	 * Returns the number of notifica messages where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	 *
	 * @param notificaId the notifica ID
	 * @param entityName the entity name
	 * @param entityId the entity ID
	 * @return the number of matching notifica messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByN_E_E(long notificaId, String entityName, long entityId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_N_E_E;

		Object[] finderArgs = new Object[] { notificaId, entityName, entityId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_NOTIFICAMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_N_E_E_NOTIFICAID_2);

			boolean bindEntityName = false;

			if (entityName == null) {
				query.append(_FINDER_COLUMN_N_E_E_ENTITYNAME_1);
			}
			else if (entityName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_E_E_ENTITYNAME_3);
			}
			else {
				bindEntityName = true;

				query.append(_FINDER_COLUMN_N_E_E_ENTITYNAME_2);
			}

			query.append(_FINDER_COLUMN_N_E_E_ENTITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(notificaId);

				if (bindEntityName) {
					qPos.add(entityName);
				}

				qPos.add(entityId);

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

	private static final String _FINDER_COLUMN_N_E_E_NOTIFICAID_2 = "notificaMessage.notificaId = ? AND ";
	private static final String _FINDER_COLUMN_N_E_E_ENTITYNAME_1 = "notificaMessage.entityName IS NULL AND ";
	private static final String _FINDER_COLUMN_N_E_E_ENTITYNAME_2 = "notificaMessage.entityName = ? AND ";
	private static final String _FINDER_COLUMN_N_E_E_ENTITYNAME_3 = "(notificaMessage.entityName IS NULL OR notificaMessage.entityName = '') AND ";
	private static final String _FINDER_COLUMN_N_E_E_ENTITYID_2 = "notificaMessage.entityId = ?";

	public NotificaMessagePersistenceImpl() {
		setModelClass(NotificaMessage.class);
	}

	/**
	 * Caches the notifica message in the entity cache if it is enabled.
	 *
	 * @param notificaMessage the notifica message
	 */
	@Override
	public void cacheResult(NotificaMessage notificaMessage) {
		EntityCacheUtil.putResult(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
			NotificaMessageImpl.class, notificaMessage.getPrimaryKey(),
			notificaMessage);

		notificaMessage.resetOriginalValues();
	}

	/**
	 * Caches the notifica messages in the entity cache if it is enabled.
	 *
	 * @param notificaMessages the notifica messages
	 */
	@Override
	public void cacheResult(List<NotificaMessage> notificaMessages) {
		for (NotificaMessage notificaMessage : notificaMessages) {
			if (EntityCacheUtil.getResult(
						NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
						NotificaMessageImpl.class,
						notificaMessage.getPrimaryKey()) == null) {
				cacheResult(notificaMessage);
			}
			else {
				notificaMessage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all notifica messages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NotificaMessageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NotificaMessageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the notifica message.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NotificaMessage notificaMessage) {
		EntityCacheUtil.removeResult(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
			NotificaMessageImpl.class, notificaMessage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NotificaMessage> notificaMessages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NotificaMessage notificaMessage : notificaMessages) {
			EntityCacheUtil.removeResult(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
				NotificaMessageImpl.class, notificaMessage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new notifica message with the primary key. Does not add the notifica message to the database.
	 *
	 * @param notificaMessageId the primary key for the new notifica message
	 * @return the new notifica message
	 */
	@Override
	public NotificaMessage create(long notificaMessageId) {
		NotificaMessage notificaMessage = new NotificaMessageImpl();

		notificaMessage.setNew(true);
		notificaMessage.setPrimaryKey(notificaMessageId);

		return notificaMessage;
	}

	/**
	 * Removes the notifica message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificaMessageId the primary key of the notifica message
	 * @return the notifica message that was removed
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a notifica message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage remove(long notificaMessageId)
		throws NoSuchNotificaMessageException, SystemException {
		return remove((Serializable)notificaMessageId);
	}

	/**
	 * Removes the notifica message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the notifica message
	 * @return the notifica message that was removed
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a notifica message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage remove(Serializable primaryKey)
		throws NoSuchNotificaMessageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NotificaMessage notificaMessage = (NotificaMessage)session.get(NotificaMessageImpl.class,
					primaryKey);

			if (notificaMessage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotificaMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(notificaMessage);
		}
		catch (NoSuchNotificaMessageException nsee) {
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
	protected NotificaMessage removeImpl(NotificaMessage notificaMessage)
		throws SystemException {
		notificaMessage = toUnwrappedModel(notificaMessage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(notificaMessage)) {
				notificaMessage = (NotificaMessage)session.get(NotificaMessageImpl.class,
						notificaMessage.getPrimaryKeyObj());
			}

			if (notificaMessage != null) {
				session.delete(notificaMessage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (notificaMessage != null) {
			clearCache(notificaMessage);
		}

		return notificaMessage;
	}

	@Override
	public NotificaMessage updateImpl(
		com.xpiping.notificationcenter.model.NotificaMessage notificaMessage)
		throws SystemException {
		notificaMessage = toUnwrappedModel(notificaMessage);

		boolean isNew = notificaMessage.isNew();

		NotificaMessageModelImpl notificaMessageModelImpl = (NotificaMessageModelImpl)notificaMessage;

		Session session = null;

		try {
			session = openSession();

			if (notificaMessage.isNew()) {
				session.save(notificaMessage);

				notificaMessage.setNew(false);
			}
			else {
				session.merge(notificaMessage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NotificaMessageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((notificaMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICAID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						notificaMessageModelImpl.getOriginalNotificaId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTIFICAID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICAID,
					args);

				args = new Object[] { notificaMessageModelImpl.getNotificaId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTIFICAID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICAID,
					args);
			}

			if ((notificaMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_E_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						notificaMessageModelImpl.getOriginalNotificaId(),
						notificaMessageModelImpl.getOriginalEntityName(),
						notificaMessageModelImpl.getOriginalEntityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_N_E_E, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_E_E,
					args);

				args = new Object[] {
						notificaMessageModelImpl.getNotificaId(),
						notificaMessageModelImpl.getEntityName(),
						notificaMessageModelImpl.getEntityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_N_E_E, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_E_E,
					args);
			}
		}

		EntityCacheUtil.putResult(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
			NotificaMessageImpl.class, notificaMessage.getPrimaryKey(),
			notificaMessage);

		return notificaMessage;
	}

	protected NotificaMessage toUnwrappedModel(NotificaMessage notificaMessage) {
		if (notificaMessage instanceof NotificaMessageImpl) {
			return notificaMessage;
		}

		NotificaMessageImpl notificaMessageImpl = new NotificaMessageImpl();

		notificaMessageImpl.setNew(notificaMessage.isNew());
		notificaMessageImpl.setPrimaryKey(notificaMessage.getPrimaryKey());

		notificaMessageImpl.setNotificaMessageId(notificaMessage.getNotificaMessageId());
		notificaMessageImpl.setCompanyId(notificaMessage.getCompanyId());
		notificaMessageImpl.setCreateDate(notificaMessage.getCreateDate());
		notificaMessageImpl.setModifiedDate(notificaMessage.getModifiedDate());
		notificaMessageImpl.setNotificaId(notificaMessage.getNotificaId());
		notificaMessageImpl.setUserId(notificaMessage.getUserId());
		notificaMessageImpl.setEntityId(notificaMessage.getEntityId());
		notificaMessageImpl.setEntityName(notificaMessage.getEntityName());
		notificaMessageImpl.setQueuedEmailId(notificaMessage.getQueuedEmailId());

		return notificaMessageImpl;
	}

	/**
	 * Returns the notifica message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the notifica message
	 * @return the notifica message
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a notifica message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNotificaMessageException, SystemException {
		NotificaMessage notificaMessage = fetchByPrimaryKey(primaryKey);

		if (notificaMessage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNotificaMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return notificaMessage;
	}

	/**
	 * Returns the notifica message with the primary key or throws a {@link com.xpiping.notificationcenter.NoSuchNotificaMessageException} if it could not be found.
	 *
	 * @param notificaMessageId the primary key of the notifica message
	 * @return the notifica message
	 * @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a notifica message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage findByPrimaryKey(long notificaMessageId)
		throws NoSuchNotificaMessageException, SystemException {
		return findByPrimaryKey((Serializable)notificaMessageId);
	}

	/**
	 * Returns the notifica message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the notifica message
	 * @return the notifica message, or <code>null</code> if a notifica message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		NotificaMessage notificaMessage = (NotificaMessage)EntityCacheUtil.getResult(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
				NotificaMessageImpl.class, primaryKey);

		if (notificaMessage == _nullNotificaMessage) {
			return null;
		}

		if (notificaMessage == null) {
			Session session = null;

			try {
				session = openSession();

				notificaMessage = (NotificaMessage)session.get(NotificaMessageImpl.class,
						primaryKey);

				if (notificaMessage != null) {
					cacheResult(notificaMessage);
				}
				else {
					EntityCacheUtil.putResult(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
						NotificaMessageImpl.class, primaryKey,
						_nullNotificaMessage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NotificaMessageModelImpl.ENTITY_CACHE_ENABLED,
					NotificaMessageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return notificaMessage;
	}

	/**
	 * Returns the notifica message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notificaMessageId the primary key of the notifica message
	 * @return the notifica message, or <code>null</code> if a notifica message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificaMessage fetchByPrimaryKey(long notificaMessageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)notificaMessageId);
	}

	/**
	 * Returns all the notifica messages.
	 *
	 * @return the notifica messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaMessage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notifica messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notifica messages
	 * @param end the upper bound of the range of notifica messages (not inclusive)
	 * @return the range of notifica messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaMessage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the notifica messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notifica messages
	 * @param end the upper bound of the range of notifica messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notifica messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificaMessage> findAll(int start, int end,
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

		List<NotificaMessage> list = (List<NotificaMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NOTIFICAMESSAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NOTIFICAMESSAGE;

				if (pagination) {
					sql = sql.concat(NotificaMessageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NotificaMessage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NotificaMessage>(list);
				}
				else {
					list = (List<NotificaMessage>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the notifica messages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (NotificaMessage notificaMessage : findAll()) {
			remove(notificaMessage);
		}
	}

	/**
	 * Returns the number of notifica messages.
	 *
	 * @return the number of notifica messages
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

				Query q = session.createQuery(_SQL_COUNT_NOTIFICAMESSAGE);

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
	 * Initializes the notifica message persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.xpiping.notificationcenter.model.NotificaMessage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NotificaMessage>> listenersList = new ArrayList<ModelListener<NotificaMessage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NotificaMessage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NotificaMessageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NOTIFICAMESSAGE = "SELECT notificaMessage FROM NotificaMessage notificaMessage";
	private static final String _SQL_SELECT_NOTIFICAMESSAGE_WHERE = "SELECT notificaMessage FROM NotificaMessage notificaMessage WHERE ";
	private static final String _SQL_COUNT_NOTIFICAMESSAGE = "SELECT COUNT(notificaMessage) FROM NotificaMessage notificaMessage";
	private static final String _SQL_COUNT_NOTIFICAMESSAGE_WHERE = "SELECT COUNT(notificaMessage) FROM NotificaMessage notificaMessage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "notificaMessage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NotificaMessage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NotificaMessage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NotificaMessagePersistenceImpl.class);
	private static NotificaMessage _nullNotificaMessage = new NotificaMessageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NotificaMessage> toCacheModel() {
				return _nullNotificaMessageCacheModel;
			}
		};

	private static CacheModel<NotificaMessage> _nullNotificaMessageCacheModel = new CacheModel<NotificaMessage>() {
			@Override
			public NotificaMessage toEntityModel() {
				return _nullNotificaMessage;
			}
		};
}