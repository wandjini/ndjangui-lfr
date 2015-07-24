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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.ndjangui.notificationcenter.model.impl.QueuedEmailImpl;
import com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl;
import com.xpiping.notificationcenter.NoSuchQueuedEmailException;
import com.xpiping.notificationcenter.model.QueuedEmail;
import com.xpiping.notificationcenter.service.persistence.QueuedEmailPersistence;
import com.xpiping.notificationcenter.service.persistence.QueuedEmailUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the queued email service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcoleo
 * @see QueuedEmailPersistence
 * @see QueuedEmailUtil
 * @generated
 */
public class QueuedEmailPersistenceImpl extends BasePersistenceImpl<QueuedEmail>
	implements QueuedEmailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QueuedEmailUtil} to access the queued email persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QueuedEmailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
			QueuedEmailModelImpl.FINDER_CACHE_ENABLED, QueuedEmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
			QueuedEmailModelImpl.FINDER_CACHE_ENABLED, QueuedEmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
			QueuedEmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SENTDATE = new FinderPath(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
			QueuedEmailModelImpl.FINDER_CACHE_ENABLED, QueuedEmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySentDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENTDATE =
		new FinderPath(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
			QueuedEmailModelImpl.FINDER_CACHE_ENABLED, QueuedEmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySentDate",
			new String[] { Date.class.getName() },
			QueuedEmailModelImpl.SENTON_COLUMN_BITMASK |
			QueuedEmailModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SENTDATE = new FinderPath(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
			QueuedEmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySentDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the queued emails where sentOn = &#63;.
	 *
	 * @param sentOn the sent on
	 * @return the matching queued emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<QueuedEmail> findBySentDate(Date sentOn)
		throws SystemException {
		return findBySentDate(sentOn, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the queued emails where sentOn = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sentOn the sent on
	 * @param start the lower bound of the range of queued emails
	 * @param end the upper bound of the range of queued emails (not inclusive)
	 * @return the range of matching queued emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<QueuedEmail> findBySentDate(Date sentOn, int start, int end)
		throws SystemException {
		return findBySentDate(sentOn, start, end, null);
	}

	/**
	 * Returns an ordered range of all the queued emails where sentOn = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sentOn the sent on
	 * @param start the lower bound of the range of queued emails
	 * @param end the upper bound of the range of queued emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching queued emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<QueuedEmail> findBySentDate(Date sentOn, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENTDATE;
			finderArgs = new Object[] { sentOn };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SENTDATE;
			finderArgs = new Object[] { sentOn, start, end, orderByComparator };
		}

		List<QueuedEmail> list = (List<QueuedEmail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (QueuedEmail queuedEmail : list) {
				if (!Validator.equals(sentOn, queuedEmail.getSentOn())) {
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

			query.append(_SQL_SELECT_QUEUEDEMAIL_WHERE);

			boolean bindSentOn = false;

			if (sentOn == null) {
				query.append(_FINDER_COLUMN_SENTDATE_SENTON_1);
			}
			else {
				bindSentOn = true;

				query.append(_FINDER_COLUMN_SENTDATE_SENTON_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(QueuedEmailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSentOn) {
					qPos.add(CalendarUtil.getTimestamp(sentOn));
				}

				if (!pagination) {
					list = (List<QueuedEmail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<QueuedEmail>(list);
				}
				else {
					list = (List<QueuedEmail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first queued email in the ordered set where sentOn = &#63;.
	 *
	 * @param sentOn the sent on
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching queued email
	 * @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a matching queued email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail findBySentDate_First(Date sentOn,
		OrderByComparator orderByComparator)
		throws NoSuchQueuedEmailException, SystemException {
		QueuedEmail queuedEmail = fetchBySentDate_First(sentOn,
				orderByComparator);

		if (queuedEmail != null) {
			return queuedEmail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sentOn=");
		msg.append(sentOn);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQueuedEmailException(msg.toString());
	}

	/**
	 * Returns the first queued email in the ordered set where sentOn = &#63;.
	 *
	 * @param sentOn the sent on
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching queued email, or <code>null</code> if a matching queued email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail fetchBySentDate_First(Date sentOn,
		OrderByComparator orderByComparator) throws SystemException {
		List<QueuedEmail> list = findBySentDate(sentOn, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last queued email in the ordered set where sentOn = &#63;.
	 *
	 * @param sentOn the sent on
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching queued email
	 * @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a matching queued email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail findBySentDate_Last(Date sentOn,
		OrderByComparator orderByComparator)
		throws NoSuchQueuedEmailException, SystemException {
		QueuedEmail queuedEmail = fetchBySentDate_Last(sentOn, orderByComparator);

		if (queuedEmail != null) {
			return queuedEmail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sentOn=");
		msg.append(sentOn);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQueuedEmailException(msg.toString());
	}

	/**
	 * Returns the last queued email in the ordered set where sentOn = &#63;.
	 *
	 * @param sentOn the sent on
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching queued email, or <code>null</code> if a matching queued email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail fetchBySentDate_Last(Date sentOn,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySentDate(sentOn);

		if (count == 0) {
			return null;
		}

		List<QueuedEmail> list = findBySentDate(sentOn, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the queued emails before and after the current queued email in the ordered set where sentOn = &#63;.
	 *
	 * @param queuedEmailId the primary key of the current queued email
	 * @param sentOn the sent on
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next queued email
	 * @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a queued email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail[] findBySentDate_PrevAndNext(long queuedEmailId,
		Date sentOn, OrderByComparator orderByComparator)
		throws NoSuchQueuedEmailException, SystemException {
		QueuedEmail queuedEmail = findByPrimaryKey(queuedEmailId);

		Session session = null;

		try {
			session = openSession();

			QueuedEmail[] array = new QueuedEmailImpl[3];

			array[0] = getBySentDate_PrevAndNext(session, queuedEmail, sentOn,
					orderByComparator, true);

			array[1] = queuedEmail;

			array[2] = getBySentDate_PrevAndNext(session, queuedEmail, sentOn,
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

	protected QueuedEmail getBySentDate_PrevAndNext(Session session,
		QueuedEmail queuedEmail, Date sentOn,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUEUEDEMAIL_WHERE);

		boolean bindSentOn = false;

		if (sentOn == null) {
			query.append(_FINDER_COLUMN_SENTDATE_SENTON_1);
		}
		else {
			bindSentOn = true;

			query.append(_FINDER_COLUMN_SENTDATE_SENTON_2);
		}

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
			query.append(QueuedEmailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSentOn) {
			qPos.add(CalendarUtil.getTimestamp(sentOn));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(queuedEmail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<QueuedEmail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the queued emails where sentOn = &#63; from the database.
	 *
	 * @param sentOn the sent on
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySentDate(Date sentOn) throws SystemException {
		for (QueuedEmail queuedEmail : findBySentDate(sentOn,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(queuedEmail);
		}
	}

	/**
	 * Returns the number of queued emails where sentOn = &#63;.
	 *
	 * @param sentOn the sent on
	 * @return the number of matching queued emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySentDate(Date sentOn) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SENTDATE;

		Object[] finderArgs = new Object[] { sentOn };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUEUEDEMAIL_WHERE);

			boolean bindSentOn = false;

			if (sentOn == null) {
				query.append(_FINDER_COLUMN_SENTDATE_SENTON_1);
			}
			else {
				bindSentOn = true;

				query.append(_FINDER_COLUMN_SENTDATE_SENTON_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSentOn) {
					qPos.add(CalendarUtil.getTimestamp(sentOn));
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

	private static final String _FINDER_COLUMN_SENTDATE_SENTON_1 = "queuedEmail.sentOn IS NULL";
	private static final String _FINDER_COLUMN_SENTDATE_SENTON_2 = "queuedEmail.sentOn = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
			QueuedEmailModelImpl.FINDER_CACHE_ENABLED, QueuedEmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
			QueuedEmailModelImpl.FINDER_CACHE_ENABLED, QueuedEmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			QueuedEmailModelImpl.COMPANYID_COLUMN_BITMASK |
			QueuedEmailModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
			QueuedEmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the queued emails where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching queued emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<QueuedEmail> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the queued emails where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of queued emails
	 * @param end the upper bound of the range of queued emails (not inclusive)
	 * @return the range of matching queued emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<QueuedEmail> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the queued emails where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of queued emails
	 * @param end the upper bound of the range of queued emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching queued emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<QueuedEmail> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<QueuedEmail> list = (List<QueuedEmail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (QueuedEmail queuedEmail : list) {
				if ((companyId != queuedEmail.getCompanyId())) {
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

			query.append(_SQL_SELECT_QUEUEDEMAIL_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(QueuedEmailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<QueuedEmail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<QueuedEmail>(list);
				}
				else {
					list = (List<QueuedEmail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first queued email in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching queued email
	 * @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a matching queued email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchQueuedEmailException, SystemException {
		QueuedEmail queuedEmail = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (queuedEmail != null) {
			return queuedEmail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQueuedEmailException(msg.toString());
	}

	/**
	 * Returns the first queued email in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching queued email, or <code>null</code> if a matching queued email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<QueuedEmail> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last queued email in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching queued email
	 * @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a matching queued email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchQueuedEmailException, SystemException {
		QueuedEmail queuedEmail = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (queuedEmail != null) {
			return queuedEmail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQueuedEmailException(msg.toString());
	}

	/**
	 * Returns the last queued email in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching queued email, or <code>null</code> if a matching queued email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<QueuedEmail> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the queued emails before and after the current queued email in the ordered set where companyId = &#63;.
	 *
	 * @param queuedEmailId the primary key of the current queued email
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next queued email
	 * @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a queued email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail[] findByCompanyId_PrevAndNext(long queuedEmailId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchQueuedEmailException, SystemException {
		QueuedEmail queuedEmail = findByPrimaryKey(queuedEmailId);

		Session session = null;

		try {
			session = openSession();

			QueuedEmail[] array = new QueuedEmailImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, queuedEmail,
					companyId, orderByComparator, true);

			array[1] = queuedEmail;

			array[2] = getByCompanyId_PrevAndNext(session, queuedEmail,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected QueuedEmail getByCompanyId_PrevAndNext(Session session,
		QueuedEmail queuedEmail, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUEUEDEMAIL_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(QueuedEmailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(queuedEmail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<QueuedEmail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the queued emails where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (QueuedEmail queuedEmail : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(queuedEmail);
		}
	}

	/**
	 * Returns the number of queued emails where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching queued emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUEUEDEMAIL_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "queuedEmail.companyId = ?";

	public QueuedEmailPersistenceImpl() {
		setModelClass(QueuedEmail.class);
	}

	/**
	 * Caches the queued email in the entity cache if it is enabled.
	 *
	 * @param queuedEmail the queued email
	 */
	@Override
	public void cacheResult(QueuedEmail queuedEmail) {
		EntityCacheUtil.putResult(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
			QueuedEmailImpl.class, queuedEmail.getPrimaryKey(), queuedEmail);

		queuedEmail.resetOriginalValues();
	}

	/**
	 * Caches the queued emails in the entity cache if it is enabled.
	 *
	 * @param queuedEmails the queued emails
	 */
	@Override
	public void cacheResult(List<QueuedEmail> queuedEmails) {
		for (QueuedEmail queuedEmail : queuedEmails) {
			if (EntityCacheUtil.getResult(
						QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
						QueuedEmailImpl.class, queuedEmail.getPrimaryKey()) == null) {
				cacheResult(queuedEmail);
			}
			else {
				queuedEmail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all queued emails.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(QueuedEmailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(QueuedEmailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the queued email.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QueuedEmail queuedEmail) {
		EntityCacheUtil.removeResult(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
			QueuedEmailImpl.class, queuedEmail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<QueuedEmail> queuedEmails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (QueuedEmail queuedEmail : queuedEmails) {
			EntityCacheUtil.removeResult(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
				QueuedEmailImpl.class, queuedEmail.getPrimaryKey());
		}
	}

	/**
	 * Creates a new queued email with the primary key. Does not add the queued email to the database.
	 *
	 * @param queuedEmailId the primary key for the new queued email
	 * @return the new queued email
	 */
	@Override
	public QueuedEmail create(long queuedEmailId) {
		QueuedEmail queuedEmail = new QueuedEmailImpl();

		queuedEmail.setNew(true);
		queuedEmail.setPrimaryKey(queuedEmailId);

		return queuedEmail;
	}

	/**
	 * Removes the queued email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param queuedEmailId the primary key of the queued email
	 * @return the queued email that was removed
	 * @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a queued email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail remove(long queuedEmailId)
		throws NoSuchQueuedEmailException, SystemException {
		return remove((Serializable)queuedEmailId);
	}

	/**
	 * Removes the queued email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the queued email
	 * @return the queued email that was removed
	 * @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a queued email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail remove(Serializable primaryKey)
		throws NoSuchQueuedEmailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			QueuedEmail queuedEmail = (QueuedEmail)session.get(QueuedEmailImpl.class,
					primaryKey);

			if (queuedEmail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQueuedEmailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(queuedEmail);
		}
		catch (NoSuchQueuedEmailException nsee) {
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
	protected QueuedEmail removeImpl(QueuedEmail queuedEmail)
		throws SystemException {
		queuedEmail = toUnwrappedModel(queuedEmail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(queuedEmail)) {
				queuedEmail = (QueuedEmail)session.get(QueuedEmailImpl.class,
						queuedEmail.getPrimaryKeyObj());
			}

			if (queuedEmail != null) {
				session.delete(queuedEmail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (queuedEmail != null) {
			clearCache(queuedEmail);
		}

		return queuedEmail;
	}

	@Override
	public QueuedEmail updateImpl(
		com.xpiping.notificationcenter.model.QueuedEmail queuedEmail)
		throws SystemException {
		queuedEmail = toUnwrappedModel(queuedEmail);

		boolean isNew = queuedEmail.isNew();

		QueuedEmailModelImpl queuedEmailModelImpl = (QueuedEmailModelImpl)queuedEmail;

		Session session = null;

		try {
			session = openSession();

			if (queuedEmail.isNew()) {
				session.save(queuedEmail);

				queuedEmail.setNew(false);
			}
			else {
				session.merge(queuedEmail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !QueuedEmailModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((queuedEmailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENTDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						queuedEmailModelImpl.getOriginalSentOn()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SENTDATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENTDATE,
					args);

				args = new Object[] { queuedEmailModelImpl.getSentOn() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SENTDATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENTDATE,
					args);
			}

			if ((queuedEmailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						queuedEmailModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { queuedEmailModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
			QueuedEmailImpl.class, queuedEmail.getPrimaryKey(), queuedEmail);

		return queuedEmail;
	}

	protected QueuedEmail toUnwrappedModel(QueuedEmail queuedEmail) {
		if (queuedEmail instanceof QueuedEmailImpl) {
			return queuedEmail;
		}

		QueuedEmailImpl queuedEmailImpl = new QueuedEmailImpl();

		queuedEmailImpl.setNew(queuedEmail.isNew());
		queuedEmailImpl.setPrimaryKey(queuedEmail.getPrimaryKey());

		queuedEmailImpl.setQueuedEmailId(queuedEmail.getQueuedEmailId());
		queuedEmailImpl.setCompanyId(queuedEmail.getCompanyId());
		queuedEmailImpl.setCreateDate(queuedEmail.getCreateDate());
		queuedEmailImpl.setModifiedDate(queuedEmail.getModifiedDate());
		queuedEmailImpl.setFrom(queuedEmail.getFrom());
		queuedEmailImpl.setFromName(queuedEmail.getFromName());
		queuedEmailImpl.setTo(queuedEmail.getTo());
		queuedEmailImpl.setToName(queuedEmail.getToName());
		queuedEmailImpl.setCc(queuedEmail.getCc());
		queuedEmailImpl.setBcc(queuedEmail.getBcc());
		queuedEmailImpl.setSubject(queuedEmail.getSubject());
		queuedEmailImpl.setBody(queuedEmail.getBody());
		queuedEmailImpl.setAttachmentFileName(queuedEmail.getAttachmentFileName());
		queuedEmailImpl.setAttachmentFileEntryId(queuedEmail.getAttachmentFileEntryId());
		queuedEmailImpl.setSentTries(queuedEmail.getSentTries());
		queuedEmailImpl.setSentOn(queuedEmail.getSentOn());

		return queuedEmailImpl;
	}

	/**
	 * Returns the queued email with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the queued email
	 * @return the queued email
	 * @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a queued email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQueuedEmailException, SystemException {
		QueuedEmail queuedEmail = fetchByPrimaryKey(primaryKey);

		if (queuedEmail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQueuedEmailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return queuedEmail;
	}

	/**
	 * Returns the queued email with the primary key or throws a {@link com.xpiping.notificationcenter.NoSuchQueuedEmailException} if it could not be found.
	 *
	 * @param queuedEmailId the primary key of the queued email
	 * @return the queued email
	 * @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a queued email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail findByPrimaryKey(long queuedEmailId)
		throws NoSuchQueuedEmailException, SystemException {
		return findByPrimaryKey((Serializable)queuedEmailId);
	}

	/**
	 * Returns the queued email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the queued email
	 * @return the queued email, or <code>null</code> if a queued email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		QueuedEmail queuedEmail = (QueuedEmail)EntityCacheUtil.getResult(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
				QueuedEmailImpl.class, primaryKey);

		if (queuedEmail == _nullQueuedEmail) {
			return null;
		}

		if (queuedEmail == null) {
			Session session = null;

			try {
				session = openSession();

				queuedEmail = (QueuedEmail)session.get(QueuedEmailImpl.class,
						primaryKey);

				if (queuedEmail != null) {
					cacheResult(queuedEmail);
				}
				else {
					EntityCacheUtil.putResult(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
						QueuedEmailImpl.class, primaryKey, _nullQueuedEmail);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(QueuedEmailModelImpl.ENTITY_CACHE_ENABLED,
					QueuedEmailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return queuedEmail;
	}

	/**
	 * Returns the queued email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param queuedEmailId the primary key of the queued email
	 * @return the queued email, or <code>null</code> if a queued email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail fetchByPrimaryKey(long queuedEmailId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)queuedEmailId);
	}

	/**
	 * Returns all the queued emails.
	 *
	 * @return the queued emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<QueuedEmail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the queued emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of queued emails
	 * @param end the upper bound of the range of queued emails (not inclusive)
	 * @return the range of queued emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<QueuedEmail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the queued emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of queued emails
	 * @param end the upper bound of the range of queued emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of queued emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<QueuedEmail> findAll(int start, int end,
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

		List<QueuedEmail> list = (List<QueuedEmail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_QUEUEDEMAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUEUEDEMAIL;

				if (pagination) {
					sql = sql.concat(QueuedEmailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<QueuedEmail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<QueuedEmail>(list);
				}
				else {
					list = (List<QueuedEmail>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the queued emails from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (QueuedEmail queuedEmail : findAll()) {
			remove(queuedEmail);
		}
	}

	/**
	 * Returns the number of queued emails.
	 *
	 * @return the number of queued emails
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

				Query q = session.createQuery(_SQL_COUNT_QUEUEDEMAIL);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the queued email persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.xpiping.notificationcenter.model.QueuedEmail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<QueuedEmail>> listenersList = new ArrayList<ModelListener<QueuedEmail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<QueuedEmail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(QueuedEmailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_QUEUEDEMAIL = "SELECT queuedEmail FROM QueuedEmail queuedEmail";
	private static final String _SQL_SELECT_QUEUEDEMAIL_WHERE = "SELECT queuedEmail FROM QueuedEmail queuedEmail WHERE ";
	private static final String _SQL_COUNT_QUEUEDEMAIL = "SELECT COUNT(queuedEmail) FROM QueuedEmail queuedEmail";
	private static final String _SQL_COUNT_QUEUEDEMAIL_WHERE = "SELECT COUNT(queuedEmail) FROM QueuedEmail queuedEmail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "queuedEmail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No QueuedEmail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No QueuedEmail exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(QueuedEmailPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"from", "to"
			});
	private static QueuedEmail _nullQueuedEmail = new QueuedEmailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<QueuedEmail> toCacheModel() {
				return _nullQueuedEmailCacheModel;
			}
		};

	private static CacheModel<QueuedEmail> _nullQueuedEmailCacheModel = new CacheModel<QueuedEmail>() {
			@Override
			public QueuedEmail toEntityModel() {
				return _nullQueuedEmail;
			}
		};
}