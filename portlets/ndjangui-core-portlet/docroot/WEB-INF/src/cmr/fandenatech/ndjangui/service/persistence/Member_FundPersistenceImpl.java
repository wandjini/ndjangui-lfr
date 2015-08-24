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

import cmr.fandenatech.ndjangui.NoSuchMember_FundException;
import cmr.fandenatech.ndjangui.model.Member_Fund;
import cmr.fandenatech.ndjangui.model.impl.Member_FundImpl;
import cmr.fandenatech.ndjangui.model.impl.Member_FundModelImpl;

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
 * The persistence implementation for the member_ fund service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see Member_FundPersistence
 * @see Member_FundUtil
 * @generated
 */
public class Member_FundPersistenceImpl extends BasePersistenceImpl<Member_Fund>
	implements Member_FundPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Member_FundUtil} to access the member_ fund persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Member_FundImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Member_FundModelImpl.ENTITY_CACHE_ENABLED,
			Member_FundModelImpl.FINDER_CACHE_ENABLED, Member_FundImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Member_FundModelImpl.ENTITY_CACHE_ENABLED,
			Member_FundModelImpl.FINDER_CACHE_ENABLED, Member_FundImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Member_FundModelImpl.ENTITY_CACHE_ENABLED,
			Member_FundModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public Member_FundPersistenceImpl() {
		setModelClass(Member_Fund.class);
	}

	/**
	 * Caches the member_ fund in the entity cache if it is enabled.
	 *
	 * @param member_Fund the member_ fund
	 */
	@Override
	public void cacheResult(Member_Fund member_Fund) {
		EntityCacheUtil.putResult(Member_FundModelImpl.ENTITY_CACHE_ENABLED,
			Member_FundImpl.class, member_Fund.getPrimaryKey(), member_Fund);

		member_Fund.resetOriginalValues();
	}

	/**
	 * Caches the member_ funds in the entity cache if it is enabled.
	 *
	 * @param member_Funds the member_ funds
	 */
	@Override
	public void cacheResult(List<Member_Fund> member_Funds) {
		for (Member_Fund member_Fund : member_Funds) {
			if (EntityCacheUtil.getResult(
						Member_FundModelImpl.ENTITY_CACHE_ENABLED,
						Member_FundImpl.class, member_Fund.getPrimaryKey()) == null) {
				cacheResult(member_Fund);
			}
			else {
				member_Fund.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all member_ funds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Member_FundImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Member_FundImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the member_ fund.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Member_Fund member_Fund) {
		EntityCacheUtil.removeResult(Member_FundModelImpl.ENTITY_CACHE_ENABLED,
			Member_FundImpl.class, member_Fund.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Member_Fund> member_Funds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Member_Fund member_Fund : member_Funds) {
			EntityCacheUtil.removeResult(Member_FundModelImpl.ENTITY_CACHE_ENABLED,
				Member_FundImpl.class, member_Fund.getPrimaryKey());
		}
	}

	/**
	 * Creates a new member_ fund with the primary key. Does not add the member_ fund to the database.
	 *
	 * @param memberFundId the primary key for the new member_ fund
	 * @return the new member_ fund
	 */
	@Override
	public Member_Fund create(long memberFundId) {
		Member_Fund member_Fund = new Member_FundImpl();

		member_Fund.setNew(true);
		member_Fund.setPrimaryKey(memberFundId);

		return member_Fund;
	}

	/**
	 * Removes the member_ fund with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberFundId the primary key of the member_ fund
	 * @return the member_ fund that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchMember_FundException if a member_ fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member_Fund remove(long memberFundId)
		throws NoSuchMember_FundException, SystemException {
		return remove((Serializable)memberFundId);
	}

	/**
	 * Removes the member_ fund with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the member_ fund
	 * @return the member_ fund that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchMember_FundException if a member_ fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member_Fund remove(Serializable primaryKey)
		throws NoSuchMember_FundException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Member_Fund member_Fund = (Member_Fund)session.get(Member_FundImpl.class,
					primaryKey);

			if (member_Fund == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMember_FundException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(member_Fund);
		}
		catch (NoSuchMember_FundException nsee) {
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
	protected Member_Fund removeImpl(Member_Fund member_Fund)
		throws SystemException {
		member_Fund = toUnwrappedModel(member_Fund);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(member_Fund)) {
				member_Fund = (Member_Fund)session.get(Member_FundImpl.class,
						member_Fund.getPrimaryKeyObj());
			}

			if (member_Fund != null) {
				session.delete(member_Fund);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (member_Fund != null) {
			clearCache(member_Fund);
		}

		return member_Fund;
	}

	@Override
	public Member_Fund updateImpl(
		cmr.fandenatech.ndjangui.model.Member_Fund member_Fund)
		throws SystemException {
		member_Fund = toUnwrappedModel(member_Fund);

		boolean isNew = member_Fund.isNew();

		Session session = null;

		try {
			session = openSession();

			if (member_Fund.isNew()) {
				session.save(member_Fund);

				member_Fund.setNew(false);
			}
			else {
				session.merge(member_Fund);
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

		EntityCacheUtil.putResult(Member_FundModelImpl.ENTITY_CACHE_ENABLED,
			Member_FundImpl.class, member_Fund.getPrimaryKey(), member_Fund);

		return member_Fund;
	}

	protected Member_Fund toUnwrappedModel(Member_Fund member_Fund) {
		if (member_Fund instanceof Member_FundImpl) {
			return member_Fund;
		}

		Member_FundImpl member_FundImpl = new Member_FundImpl();

		member_FundImpl.setNew(member_Fund.isNew());
		member_FundImpl.setPrimaryKey(member_Fund.getPrimaryKey());

		member_FundImpl.setMemberFundId(member_Fund.getMemberFundId());
		member_FundImpl.setCreateDate(member_Fund.getCreateDate());
		member_FundImpl.setModifiedDate(member_Fund.getModifiedDate());
		member_FundImpl.setMemberId(member_Fund.getMemberId());
		member_FundImpl.setFundId(member_Fund.getFundId());

		return member_FundImpl;
	}

	/**
	 * Returns the member_ fund with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the member_ fund
	 * @return the member_ fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchMember_FundException if a member_ fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member_Fund findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMember_FundException, SystemException {
		Member_Fund member_Fund = fetchByPrimaryKey(primaryKey);

		if (member_Fund == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMember_FundException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return member_Fund;
	}

	/**
	 * Returns the member_ fund with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchMember_FundException} if it could not be found.
	 *
	 * @param memberFundId the primary key of the member_ fund
	 * @return the member_ fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchMember_FundException if a member_ fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member_Fund findByPrimaryKey(long memberFundId)
		throws NoSuchMember_FundException, SystemException {
		return findByPrimaryKey((Serializable)memberFundId);
	}

	/**
	 * Returns the member_ fund with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the member_ fund
	 * @return the member_ fund, or <code>null</code> if a member_ fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member_Fund fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Member_Fund member_Fund = (Member_Fund)EntityCacheUtil.getResult(Member_FundModelImpl.ENTITY_CACHE_ENABLED,
				Member_FundImpl.class, primaryKey);

		if (member_Fund == _nullMember_Fund) {
			return null;
		}

		if (member_Fund == null) {
			Session session = null;

			try {
				session = openSession();

				member_Fund = (Member_Fund)session.get(Member_FundImpl.class,
						primaryKey);

				if (member_Fund != null) {
					cacheResult(member_Fund);
				}
				else {
					EntityCacheUtil.putResult(Member_FundModelImpl.ENTITY_CACHE_ENABLED,
						Member_FundImpl.class, primaryKey, _nullMember_Fund);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Member_FundModelImpl.ENTITY_CACHE_ENABLED,
					Member_FundImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return member_Fund;
	}

	/**
	 * Returns the member_ fund with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberFundId the primary key of the member_ fund
	 * @return the member_ fund, or <code>null</code> if a member_ fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member_Fund fetchByPrimaryKey(long memberFundId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)memberFundId);
	}

	/**
	 * Returns all the member_ funds.
	 *
	 * @return the member_ funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Member_Fund> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the member_ funds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.Member_FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of member_ funds
	 * @param end the upper bound of the range of member_ funds (not inclusive)
	 * @return the range of member_ funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Member_Fund> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the member_ funds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.Member_FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of member_ funds
	 * @param end the upper bound of the range of member_ funds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of member_ funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Member_Fund> findAll(int start, int end,
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

		List<Member_Fund> list = (List<Member_Fund>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBER_FUND);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBER_FUND;

				if (pagination) {
					sql = sql.concat(Member_FundModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Member_Fund>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Member_Fund>(list);
				}
				else {
					list = (List<Member_Fund>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the member_ funds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Member_Fund member_Fund : findAll()) {
			remove(member_Fund);
		}
	}

	/**
	 * Returns the number of member_ funds.
	 *
	 * @return the number of member_ funds
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

				Query q = session.createQuery(_SQL_COUNT_MEMBER_FUND);

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
	 * Initializes the member_ fund persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.cmr.fandenatech.ndjangui.model.Member_Fund")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Member_Fund>> listenersList = new ArrayList<ModelListener<Member_Fund>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Member_Fund>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Member_FundImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MEMBER_FUND = "SELECT member_Fund FROM Member_Fund member_Fund";
	private static final String _SQL_COUNT_MEMBER_FUND = "SELECT COUNT(member_Fund) FROM Member_Fund member_Fund";
	private static final String _ORDER_BY_ENTITY_ALIAS = "member_Fund.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Member_Fund exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Member_FundPersistenceImpl.class);
	private static Member_Fund _nullMember_Fund = new Member_FundImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Member_Fund> toCacheModel() {
				return _nullMember_FundCacheModel;
			}
		};

	private static CacheModel<Member_Fund> _nullMember_FundCacheModel = new CacheModel<Member_Fund>() {
			@Override
			public Member_Fund toEntityModel() {
				return _nullMember_Fund;
			}
		};
}