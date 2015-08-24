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

import cmr.fandenatech.ndjangui.model.Operation_Fund;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the operation_ fund service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see Operation_FundPersistenceImpl
 * @see Operation_FundUtil
 * @generated
 */
public interface Operation_FundPersistence extends BasePersistence<Operation_Fund> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Operation_FundUtil} to access the operation_ fund persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the operation_ fund in the entity cache if it is enabled.
	*
	* @param operation_Fund the operation_ fund
	*/
	public void cacheResult(
		cmr.fandenatech.ndjangui.model.Operation_Fund operation_Fund);

	/**
	* Caches the operation_ funds in the entity cache if it is enabled.
	*
	* @param operation_Funds the operation_ funds
	*/
	public void cacheResult(
		java.util.List<cmr.fandenatech.ndjangui.model.Operation_Fund> operation_Funds);

	/**
	* Creates a new operation_ fund with the primary key. Does not add the operation_ fund to the database.
	*
	* @param operationFundId the primary key for the new operation_ fund
	* @return the new operation_ fund
	*/
	public cmr.fandenatech.ndjangui.model.Operation_Fund create(
		long operationFundId);

	/**
	* Removes the operation_ fund with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param operationFundId the primary key of the operation_ fund
	* @return the operation_ fund that was removed
	* @throws cmr.fandenatech.ndjangui.NoSuchOperation_FundException if a operation_ fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.Operation_Fund remove(
		long operationFundId)
		throws cmr.fandenatech.ndjangui.NoSuchOperation_FundException,
			com.liferay.portal.kernel.exception.SystemException;

	public cmr.fandenatech.ndjangui.model.Operation_Fund updateImpl(
		cmr.fandenatech.ndjangui.model.Operation_Fund operation_Fund)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the operation_ fund with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchOperation_FundException} if it could not be found.
	*
	* @param operationFundId the primary key of the operation_ fund
	* @return the operation_ fund
	* @throws cmr.fandenatech.ndjangui.NoSuchOperation_FundException if a operation_ fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.Operation_Fund findByPrimaryKey(
		long operationFundId)
		throws cmr.fandenatech.ndjangui.NoSuchOperation_FundException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the operation_ fund with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param operationFundId the primary key of the operation_ fund
	* @return the operation_ fund, or <code>null</code> if a operation_ fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.Operation_Fund fetchByPrimaryKey(
		long operationFundId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the operation_ funds.
	*
	* @return the operation_ funds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.Operation_Fund> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<cmr.fandenatech.ndjangui.model.Operation_Fund> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<cmr.fandenatech.ndjangui.model.Operation_Fund> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the operation_ funds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of operation_ funds.
	*
	* @return the number of operation_ funds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}