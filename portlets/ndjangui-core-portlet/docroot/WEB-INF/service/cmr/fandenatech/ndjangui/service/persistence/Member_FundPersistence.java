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

import cmr.fandenatech.ndjangui.model.Member_Fund;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the member_ fund service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see Member_FundPersistenceImpl
 * @see Member_FundUtil
 * @generated
 */
public interface Member_FundPersistence extends BasePersistence<Member_Fund> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Member_FundUtil} to access the member_ fund persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the member_ fund in the entity cache if it is enabled.
	*
	* @param member_Fund the member_ fund
	*/
	public void cacheResult(
		cmr.fandenatech.ndjangui.model.Member_Fund member_Fund);

	/**
	* Caches the member_ funds in the entity cache if it is enabled.
	*
	* @param member_Funds the member_ funds
	*/
	public void cacheResult(
		java.util.List<cmr.fandenatech.ndjangui.model.Member_Fund> member_Funds);

	/**
	* Creates a new member_ fund with the primary key. Does not add the member_ fund to the database.
	*
	* @param memberFundId the primary key for the new member_ fund
	* @return the new member_ fund
	*/
	public cmr.fandenatech.ndjangui.model.Member_Fund create(long memberFundId);

	/**
	* Removes the member_ fund with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param memberFundId the primary key of the member_ fund
	* @return the member_ fund that was removed
	* @throws cmr.fandenatech.ndjangui.NoSuchMember_FundException if a member_ fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.Member_Fund remove(long memberFundId)
		throws cmr.fandenatech.ndjangui.NoSuchMember_FundException,
			com.liferay.portal.kernel.exception.SystemException;

	public cmr.fandenatech.ndjangui.model.Member_Fund updateImpl(
		cmr.fandenatech.ndjangui.model.Member_Fund member_Fund)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the member_ fund with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchMember_FundException} if it could not be found.
	*
	* @param memberFundId the primary key of the member_ fund
	* @return the member_ fund
	* @throws cmr.fandenatech.ndjangui.NoSuchMember_FundException if a member_ fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.Member_Fund findByPrimaryKey(
		long memberFundId)
		throws cmr.fandenatech.ndjangui.NoSuchMember_FundException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the member_ fund with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param memberFundId the primary key of the member_ fund
	* @return the member_ fund, or <code>null</code> if a member_ fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.Member_Fund fetchByPrimaryKey(
		long memberFundId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the member_ funds.
	*
	* @return the member_ funds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.Member_Fund> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<cmr.fandenatech.ndjangui.model.Member_Fund> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<cmr.fandenatech.ndjangui.model.Member_Fund> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the member_ funds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of member_ funds.
	*
	* @return the number of member_ funds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}