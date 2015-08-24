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

import cmr.fandenatech.ndjangui.NoSuchOperation_FundException;
import cmr.fandenatech.ndjangui.model.Operation_Fund;
import cmr.fandenatech.ndjangui.model.impl.Operation_FundImpl;
import cmr.fandenatech.ndjangui.model.impl.Operation_FundModelImpl;

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
 * The persistence implementation for the operation_ fund service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see Operation_FundPersistence
 * @see Operation_FundUtil
 * @generated
 */
public class Operation_FundPersistenceImpl extends BasePersistenceImpl<Operation_Fund>
	implements Operation_FundPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Operation_FundUtil} to access the operation_ fund persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Operation_FundImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Operation_FundModelImpl.ENTITY_CACHE_ENABLED,
			Operation_FundModelImpl.FINDER_CACHE_ENABLED,
			Operation_FundImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Operation_FundModelImpl.ENTITY_CACHE_ENABLED,
			Operation_FundModelImpl.FINDER_CACHE_ENABLED,
			Operation_FundImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Operation_FundModelImpl.ENTITY_CACHE_ENABLED,
			Operation_FundModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public Operation_FundPersistenceImpl() {
		setModelClass(Operation_Fund.class);
	}

	/**
	 * Caches the operation_ fund in the entity cache if it is enabled.
	 *
	 * @param operation_Fund the operation_ fund
	 */
	@Override
	public void cacheResult(Operation_Fund operation_Fund) {
		EntityCacheUtil.putResult(Operation_FundModelImpl.ENTITY_CACHE_ENABLED,
			Operation_FundImpl.class, operation_Fund.getPrimaryKey(),
			operation_Fund);

		operation_Fund.resetOriginalValues();
	}

	/**
	 * Caches the operation_ funds in the entity cache if it is enabled.
	 *
	 * @param operation_Funds the operation_ funds
	 */
	@Override
	public void cacheResult(List<Operation_Fund> operation_Funds) {
		for (Operation_Fund operation_Fund : operation_Funds) {
			if (EntityCacheUtil.getResult(
						Operation_FundModelImpl.ENTITY_CACHE_ENABLED,
						Operation_FundImpl.class, operation_Fund.getPrimaryKey()) == null) {
				cacheResult(operation_Fund);
			}
			else {
				operation_Fund.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all operation_ funds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Operation_FundImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Operation_FundImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the operation_ fund.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Operation_Fund operation_Fund) {
		EntityCacheUtil.removeResult(Operation_FundModelImpl.ENTITY_CACHE_ENABLED,
			Operation_FundImpl.class, operation_Fund.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Operation_Fund> operation_Funds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Operation_Fund operation_Fund : operation_Funds) {
			EntityCacheUtil.removeResult(Operation_FundModelImpl.ENTITY_CACHE_ENABLED,
				Operation_FundImpl.class, operation_Fund.getPrimaryKey());
		}
	}

	/**
	 * Creates a new operation_ fund with the primary key. Does not add the operation_ fund to the database.
	 *
	 * @param operationFundId the primary key for the new operation_ fund
	 * @return the new operation_ fund
	 */
	@Override
	public Operation_Fund create(long operationFundId) {
		Operation_Fund operation_Fund = new Operation_FundImpl();

		operation_Fund.setNew(true);
		operation_Fund.setPrimaryKey(operationFundId);

		return operation_Fund;
	}

	/**
	 * Removes the operation_ fund with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param operationFundId the primary key of the operation_ fund
	 * @return the operation_ fund that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchOperation_FundException if a operation_ fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation_Fund remove(long operationFundId)
		throws NoSuchOperation_FundException, SystemException {
		return remove((Serializable)operationFundId);
	}

	/**
	 * Removes the operation_ fund with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the operation_ fund
	 * @return the operation_ fund that was removed
	 * @throws cmr.fandenatech.ndjangui.NoSuchOperation_FundException if a operation_ fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation_Fund remove(Serializable primaryKey)
		throws NoSuchOperation_FundException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Operation_Fund operation_Fund = (Operation_Fund)session.get(Operation_FundImpl.class,
					primaryKey);

			if (operation_Fund == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOperation_FundException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(operation_Fund);
		}
		catch (NoSuchOperation_FundException nsee) {
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
	protected Operation_Fund removeImpl(Operation_Fund operation_Fund)
		throws SystemException {
		operation_Fund = toUnwrappedModel(operation_Fund);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(operation_Fund)) {
				operation_Fund = (Operation_Fund)session.get(Operation_FundImpl.class,
						operation_Fund.getPrimaryKeyObj());
			}

			if (operation_Fund != null) {
				session.delete(operation_Fund);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (operation_Fund != null) {
			clearCache(operation_Fund);
		}

		return operation_Fund;
	}

	@Override
	public Operation_Fund updateImpl(
		cmr.fandenatech.ndjangui.model.Operation_Fund operation_Fund)
		throws SystemException {
		operation_Fund = toUnwrappedModel(operation_Fund);

		boolean isNew = operation_Fund.isNew();

		Session session = null;

		try {
			session = openSession();

			if (operation_Fund.isNew()) {
				session.save(operation_Fund);

				operation_Fund.setNew(false);
			}
			else {
				session.merge(operation_Fund);
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

		EntityCacheUtil.putResult(Operation_FundModelImpl.ENTITY_CACHE_ENABLED,
			Operation_FundImpl.class, operation_Fund.getPrimaryKey(),
			operation_Fund);

		return operation_Fund;
	}

	protected Operation_Fund toUnwrappedModel(Operation_Fund operation_Fund) {
		if (operation_Fund instanceof Operation_FundImpl) {
			return operation_Fund;
		}

		Operation_FundImpl operation_FundImpl = new Operation_FundImpl();

		operation_FundImpl.setNew(operation_Fund.isNew());
		operation_FundImpl.setPrimaryKey(operation_Fund.getPrimaryKey());

		operation_FundImpl.setOperationFundId(operation_Fund.getOperationFundId());
		operation_FundImpl.setUserId(operation_Fund.getUserId());
		operation_FundImpl.setGroupId(operation_Fund.getGroupId());
		operation_FundImpl.setCompanyId(operation_Fund.getCompanyId());
		operation_FundImpl.setUserName(operation_Fund.getUserName());
		operation_FundImpl.setCreateDate(operation_Fund.getCreateDate());
		operation_FundImpl.setModifiedDate(operation_Fund.getModifiedDate());
		operation_FundImpl.setOperationId(operation_Fund.getOperationId());
		operation_FundImpl.setSrcFundClassPK(operation_Fund.getSrcFundClassPK());
		operation_FundImpl.setSrcFundClassName(operation_Fund.getSrcFundClassName());
		operation_FundImpl.setDestFundClassPK(operation_Fund.getDestFundClassPK());
		operation_FundImpl.setDestFundClassName(operation_Fund.getDestFundClassName());

		return operation_FundImpl;
	}

	/**
	 * Returns the operation_ fund with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the operation_ fund
	 * @return the operation_ fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchOperation_FundException if a operation_ fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation_Fund findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOperation_FundException, SystemException {
		Operation_Fund operation_Fund = fetchByPrimaryKey(primaryKey);

		if (operation_Fund == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOperation_FundException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return operation_Fund;
	}

	/**
	 * Returns the operation_ fund with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchOperation_FundException} if it could not be found.
	 *
	 * @param operationFundId the primary key of the operation_ fund
	 * @return the operation_ fund
	 * @throws cmr.fandenatech.ndjangui.NoSuchOperation_FundException if a operation_ fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation_Fund findByPrimaryKey(long operationFundId)
		throws NoSuchOperation_FundException, SystemException {
		return findByPrimaryKey((Serializable)operationFundId);
	}

	/**
	 * Returns the operation_ fund with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the operation_ fund
	 * @return the operation_ fund, or <code>null</code> if a operation_ fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation_Fund fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Operation_Fund operation_Fund = (Operation_Fund)EntityCacheUtil.getResult(Operation_FundModelImpl.ENTITY_CACHE_ENABLED,
				Operation_FundImpl.class, primaryKey);

		if (operation_Fund == _nullOperation_Fund) {
			return null;
		}

		if (operation_Fund == null) {
			Session session = null;

			try {
				session = openSession();

				operation_Fund = (Operation_Fund)session.get(Operation_FundImpl.class,
						primaryKey);

				if (operation_Fund != null) {
					cacheResult(operation_Fund);
				}
				else {
					EntityCacheUtil.putResult(Operation_FundModelImpl.ENTITY_CACHE_ENABLED,
						Operation_FundImpl.class, primaryKey,
						_nullOperation_Fund);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Operation_FundModelImpl.ENTITY_CACHE_ENABLED,
					Operation_FundImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return operation_Fund;
	}

	/**
	 * Returns the operation_ fund with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param operationFundId the primary key of the operation_ fund
	 * @return the operation_ fund, or <code>null</code> if a operation_ fund with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Operation_Fund fetchByPrimaryKey(long operationFundId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)operationFundId);
	}

	/**
	 * Returns all the operation_ funds.
	 *
	 * @return the operation_ funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Operation_Fund> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the operation_ funds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.Operation_FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of operation_ funds
	 * @param end the upper bound of the range of operation_ funds (not inclusive)
	 * @return the range of operation_ funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Operation_Fund> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the operation_ funds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.Operation_FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of operation_ funds
	 * @param end the upper bound of the range of operation_ funds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of operation_ funds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Operation_Fund> findAll(int start, int end,
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

		List<Operation_Fund> list = (List<Operation_Fund>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OPERATION_FUND);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OPERATION_FUND;

				if (pagination) {
					sql = sql.concat(Operation_FundModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Operation_Fund>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Operation_Fund>(list);
				}
				else {
					list = (List<Operation_Fund>)QueryUtil.list(q,
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
	 * Removes all the operation_ funds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Operation_Fund operation_Fund : findAll()) {
			remove(operation_Fund);
		}
	}

	/**
	 * Returns the number of operation_ funds.
	 *
	 * @return the number of operation_ funds
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

				Query q = session.createQuery(_SQL_COUNT_OPERATION_FUND);

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
	 * Initializes the operation_ fund persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.cmr.fandenatech.ndjangui.model.Operation_Fund")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Operation_Fund>> listenersList = new ArrayList<ModelListener<Operation_Fund>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Operation_Fund>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Operation_FundImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OPERATION_FUND = "SELECT operation_Fund FROM Operation_Fund operation_Fund";
	private static final String _SQL_COUNT_OPERATION_FUND = "SELECT COUNT(operation_Fund) FROM Operation_Fund operation_Fund";
	private static final String _ORDER_BY_ENTITY_ALIAS = "operation_Fund.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Operation_Fund exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Operation_FundPersistenceImpl.class);
	private static Operation_Fund _nullOperation_Fund = new Operation_FundImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Operation_Fund> toCacheModel() {
				return _nullOperation_FundCacheModel;
			}
		};

	private static CacheModel<Operation_Fund> _nullOperation_FundCacheModel = new CacheModel<Operation_Fund>() {
			@Override
			public Operation_Fund toEntityModel() {
				return _nullOperation_Fund;
			}
		};
}