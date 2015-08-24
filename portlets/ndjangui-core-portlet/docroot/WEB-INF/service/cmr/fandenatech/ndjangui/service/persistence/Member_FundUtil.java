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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the member_ fund service. This utility wraps {@link Member_FundPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see Member_FundPersistence
 * @see Member_FundPersistenceImpl
 * @generated
 */
public class Member_FundUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Member_Fund member_Fund) {
		getPersistence().clearCache(member_Fund);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Member_Fund> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Member_Fund> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Member_Fund> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Member_Fund update(Member_Fund member_Fund)
		throws SystemException {
		return getPersistence().update(member_Fund);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Member_Fund update(Member_Fund member_Fund,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(member_Fund, serviceContext);
	}

	/**
	* Caches the member_ fund in the entity cache if it is enabled.
	*
	* @param member_Fund the member_ fund
	*/
	public static void cacheResult(
		cmr.fandenatech.ndjangui.model.Member_Fund member_Fund) {
		getPersistence().cacheResult(member_Fund);
	}

	/**
	* Caches the member_ funds in the entity cache if it is enabled.
	*
	* @param member_Funds the member_ funds
	*/
	public static void cacheResult(
		java.util.List<cmr.fandenatech.ndjangui.model.Member_Fund> member_Funds) {
		getPersistence().cacheResult(member_Funds);
	}

	/**
	* Creates a new member_ fund with the primary key. Does not add the member_ fund to the database.
	*
	* @param memberFundId the primary key for the new member_ fund
	* @return the new member_ fund
	*/
	public static cmr.fandenatech.ndjangui.model.Member_Fund create(
		long memberFundId) {
		return getPersistence().create(memberFundId);
	}

	/**
	* Removes the member_ fund with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param memberFundId the primary key of the member_ fund
	* @return the member_ fund that was removed
	* @throws cmr.fandenatech.ndjangui.NoSuchMember_FundException if a member_ fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Member_Fund remove(
		long memberFundId)
		throws cmr.fandenatech.ndjangui.NoSuchMember_FundException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(memberFundId);
	}

	public static cmr.fandenatech.ndjangui.model.Member_Fund updateImpl(
		cmr.fandenatech.ndjangui.model.Member_Fund member_Fund)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(member_Fund);
	}

	/**
	* Returns the member_ fund with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchMember_FundException} if it could not be found.
	*
	* @param memberFundId the primary key of the member_ fund
	* @return the member_ fund
	* @throws cmr.fandenatech.ndjangui.NoSuchMember_FundException if a member_ fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Member_Fund findByPrimaryKey(
		long memberFundId)
		throws cmr.fandenatech.ndjangui.NoSuchMember_FundException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(memberFundId);
	}

	/**
	* Returns the member_ fund with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param memberFundId the primary key of the member_ fund
	* @return the member_ fund, or <code>null</code> if a member_ fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Member_Fund fetchByPrimaryKey(
		long memberFundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(memberFundId);
	}

	/**
	* Returns all the member_ funds.
	*
	* @return the member_ funds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.Member_Fund> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<cmr.fandenatech.ndjangui.model.Member_Fund> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<cmr.fandenatech.ndjangui.model.Member_Fund> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the member_ funds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of member_ funds.
	*
	* @return the number of member_ funds
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Member_FundPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Member_FundPersistence)PortletBeanLocatorUtil.locate(cmr.fandenatech.ndjangui.service.ClpSerializer.getServletContextName(),
					Member_FundPersistence.class.getName());

			ReferenceRegistry.registerReference(Member_FundUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Member_FundPersistence persistence) {
	}

	private static Member_FundPersistence _persistence;
}