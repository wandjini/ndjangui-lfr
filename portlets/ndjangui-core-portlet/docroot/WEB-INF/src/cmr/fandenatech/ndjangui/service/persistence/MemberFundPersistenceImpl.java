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

import cmr.fandenatech.ndjangui.NoSuchMemberFundException;
import cmr.fandenatech.ndjangui.model.MemberFund;
import cmr.fandenatech.ndjangui.model.impl.MemberFundImpl;
import cmr.fandenatech.ndjangui.model.impl.MemberFundModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the member fund service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see MemberFundPersistence
 * @see MemberFundUtil
 * @generated
 */
public class MemberFundPersistenceImpl extends BasePersistenceImpl<MemberFund>
	implements MemberFundPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MemberFundUtil} to access the member fund persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MemberFundImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MemberFundModelImpl.ENTITY_CACHE_ENABLED,
			MemberFundModelImpl.FINDER_CACHE_ENABLED, MemberFundImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MemberFundModelImpl.ENTITY_CACHE_ENABLED,
			MemberFundModelImpl.FINDER_CACHE_ENABLED, MemberFundImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MemberFundModelImpl.ENTITY_CACHE_ENABLED,
			MemberFundModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public MemberFundPersistenceImpl() {
		setModelClass(MemberFund.class);
	}

	/**
	 * Caches the member fund in the entity cache if it is enabled.
	 *
	 * @param memberFund the member fund
	 */
	@Override
	public void cacheResult(MemberFund memberFund) {
		EntityCacheUtil.putResult(MemberFundModelImpl.ENTITY_CACHE_ENABLED,
			MemberFundImpl.class, memberFund.getPrimaryKey(), memberFund);

		memberFund.resetOriginalValues();
	}

	/**
	 * Caches the member funds in the entity cache if it is enabled.
	 *
	 * @param memberFunds the member funds
	 */
	@Override
	public void cacheResult(List<MemberFund> memberFunds) {
		for (MemberFund memberFund : memberFunds) {
			if (EntityCacheUtil.getResult(
						MemberFundModelImpl.ENTITY_CACHE_ENABLED,
						MemberFundImpl.class, memberFund.getPrimaryKey()) == null) {
				cacheResult(memberFund);
			}
			else {
				memberFund.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all member funds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MemberFundImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MemberFundImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the member fund.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MemberFund memberFund) {
		EntityCacheUtil.removeResult(MemberFundModelImpl.ENTITY_CACHE_ENABLED,
			MemberFundImpl.class, memberFund.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MemberFund> memberFunds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MemberFund memberFund : memberFunds) {
			EntityCacheUtil.removeResult(MemberFundModelImpl.ENTITY_CACHE_ENABLED,
				MemberFundImpl.class, memberFund.getPrimaryKey());
		}
	}

	/**
	 * Creates a new member fund with the primary key. Does not add the member fund to the database.
	 *
	 * @param memberFundId the primary key for the new member fund
	 * @return the new member fund
	 */
	@Override
	public MemberFund create(long memberFundId) {
		MemberFund memberFund = new MemberFundImpl();

		memberFund.setNew(true);
		memberFund.setPrimaryKey(memberFundId);

		return memberFund;
	}

	/**
	 * Removes the member fund with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberFundId the primary key of the member fund
	 * @return the member fund that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberFundException if a member fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberFund remove(long memberFundId)
		throws NoSuchMemberFundException, SystemException {
		return remove((Serializable)memberFundId);
	}

	/**
	 * Removes the member fund with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the member fund
	 * @return the member fund that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberFundException if a member fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberFund remove(Serializable primaryKey)
		throws NoSuchMemberFundException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MemberFund memberFund = (MemberFund)session.get(MemberFundImpl.class,
					primaryKey);

			if (memberFund == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMemberFundException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(memberFund);
		}
		catch (NoSuchMemberFundException nsee) {
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
	protected MemberFund removeImpl(MemberFund memberFund)
		throws SystemException {
		memberFund = toUnwrappedModel(memberFund);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(memberFund)) {
				memberFund = (MemberFund)session.get(MemberFundImpl.class,
						memberFund.getPrimaryKeyObj());
			}

			if (memberFund != null) {
				session.delete(memberFund);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (memberFund != null) {
			clearCache(memberFund);
		}

		return memberFund;
	}

	@Override
	public MemberFund updateImpl(
		cmr.fandenatech.ndjangui.model.MemberFund memberFund)
		throws SystemException {
		memberFund = toUnwrappedModel(memberFund);

		boolean isNew = memberFund.isNew();

		Session session = null;

		try {
			session = openSession();

			if (memberFund.isNew()) {
				session.save(memberFund);

				memberFund.setNew(false);
			}
			else {
				session.merge(memberFund);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(MemberFundModelImpl.ENTITY_CACHE_ENABLED,
			MemberFundImpl.class, memberFund.getPrimaryKey(), memberFund);

		return memberFund;
	}

	protected MemberFund toUnwrappedModel(MemberFund memberFund) {
		if (memberFund instanceof MemberFundImpl) {
			return memberFund;
		}

		MemberFundImpl memberFundImpl = new MemberFundImpl();

		memberFundImpl.setNew(memberFund.isNew());
		memberFundImpl.setPrimaryKey(memberFund.getPrimaryKey());

		memberFundImpl.setMemberFundId(memberFund.getMemberFundId());
		memberFundImpl.setUserId(memberFund.getUserId());
		memberFundImpl.setGroupId(memberFund.getGroupId());
		memberFundImpl.setCompanyId(memberFund.getCompanyId());
		memberFundImpl.setUserName(memberFund.getUserName());
		memberFundImpl.setCreateDate(memberFund.getCreateDate());
		memberFundImpl.setModifiedDate(memberFund.getModifiedDate());
		memberFundImpl.setMemberId(memberFund.getMemberId());
		memberFundImpl.setFundId(memberFund.getFundId());
		memberFundImpl.setMemberName(memberFund.getMemberName());
		memberFundImpl.setFundName(memberFund.getFundName());

		return memberFundImpl;
	}

	/**
	 * Returns the member fund with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the member fund
	 * @return the member fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberFundException if a member fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberFund findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMemberFundException, SystemException {
		MemberFund memberFund = fetchByPrimaryKey(primaryKey);

		if (memberFund == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMemberFundException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return memberFund;
	}

	/**
	 * Returns the member fund with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchMemberFundException} if it could not be found.
	 *
	 * @param memberFundId the primary key of the member fund
	 * @return the member fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchMemberFundException if a member fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberFund findByPrimaryKey(long memberFundId)
		throws NoSuchMemberFundException, SystemException {
		return findByPrimaryKey((Serializable)memberFundId);
	}

	/**
	 * Returns the member fund with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the member fund
	 * @return the member fund, or <code>null</code> if a member fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberFund fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MemberFund memberFund = (MemberFund)EntityCacheUtil.getResult(MemberFundModelImpl.ENTITY_CACHE_ENABLED,
				MemberFundImpl.class, primaryKey);

		if (memberFund == _nullMemberFund) {
			return null;
		}

		if (memberFund == null) {
			Session session = null;

			try {
				session = openSession();

				memberFund = (MemberFund)session.get(MemberFundImpl.class,
						primaryKey);

				if (memberFund != null) {
					cacheResult(memberFund);
				}
				else {
					EntityCacheUtil.putResult(MemberFundModelImpl.ENTITY_CACHE_ENABLED,
						MemberFundImpl.class, primaryKey, _nullMemberFund);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MemberFundModelImpl.ENTITY_CACHE_ENABLED,
					MemberFundImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return memberFund;
	}

	/**
	 * Returns the member fund with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberFundId the primary key of the member fund
	 * @return the member fund, or <code>null</code> if a member fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MemberFund fetchByPrimaryKey(long memberFundId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)memberFundId);
	}

	/**
	 * Returns all the member funds.
	 *
	 * @return the member funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MemberFund> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the member funds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberFundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of member funds
	 * @param end the upper bound of the range of member funds (not inclusive)
	 * @return the range of member funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MemberFund> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the member funds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberFundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of member funds
	 * @param end the upper bound of the range of member funds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of member funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MemberFund> findAll(int start, int end,
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

		List<MemberFund> list = (List<MemberFund>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBERFUND);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBERFUND;

				if (pagination) {
					sql = sql.concat(MemberFundModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MemberFund>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MemberFund>(list);
				}
				else {
					list = (List<MemberFund>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the member funds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MemberFund memberFund : findAll()) {
			remove(memberFund);
		}
	}

	/**
	 * Returns the number of member funds.
	 *
	 * @return the number of member funds
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

				Query q = session.createQuery(_SQL_COUNT_MEMBERFUND);

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
	 * Initializes the member fund persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.cmr.fandenatech.ndjangui.model.MemberFund")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MemberFund>> listenersList = new ArrayList<ModelListener<MemberFund>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MemberFund>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MemberFundImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MEMBERFUND = "SELECT memberFund FROM MemberFund memberFund";
	private static final String _SQL_COUNT_MEMBERFUND = "SELECT COUNT(memberFund) FROM MemberFund memberFund";
	private static final String _ORDER_BY_ENTITY_ALIAS = "memberFund.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MemberFund exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MemberFundPersistenceImpl.class);
	private static MemberFund _nullMemberFund = new MemberFundImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MemberFund> toCacheModel() {
				return _nullMemberFundCacheModel;
			}
		};

	private static CacheModel<MemberFund> _nullMemberFundCacheModel = new CacheModel<MemberFund>() {
			@Override
			public MemberFund toEntityModel() {
				return _nullMemberFund;
			}
		};
}