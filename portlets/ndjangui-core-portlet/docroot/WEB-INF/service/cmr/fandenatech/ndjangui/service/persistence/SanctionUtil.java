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

import cmr.fandenatech.ndjangui.model.Sanction;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the sanction service. This utility wraps {@link SanctionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see SanctionPersistence
 * @see SanctionPersistenceImpl
 * @generated
 */
public class SanctionUtil {
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
	public static void clearCache(Sanction sanction) {
		getPersistence().clearCache(sanction);
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
	public static List<Sanction> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Sanction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Sanction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Sanction update(Sanction sanction) throws SystemException {
		return getPersistence().update(sanction);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Sanction update(Sanction sanction,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(sanction, serviceContext);
	}

	/**
	* Returns all the sanctions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching sanctions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.Sanction> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the sanctions where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of sanctions
	* @param end the upper bound of the range of sanctions (not inclusive)
	* @return the range of matching sanctions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.Sanction> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the sanctions where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of sanctions
	* @param end the upper bound of the range of sanctions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sanctions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.Sanction> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first sanction in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sanction
	* @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a matching sanction could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchSanctionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first sanction in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sanction, or <code>null</code> if a matching sanction could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last sanction in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sanction
	* @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a matching sanction could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchSanctionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last sanction in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sanction, or <code>null</code> if a matching sanction could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the sanctions before and after the current sanction in the ordered set where groupId = &#63;.
	*
	* @param sanctionId the primary key of the current sanction
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sanction
	* @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a sanction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction[] findByGroupId_PrevAndNext(
		long sanctionId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchSanctionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(sanctionId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the sanctions where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of sanctions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching sanctions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the sanctions where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching sanctions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.Sanction> findByGroupId_Status(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Status(groupId, status);
	}

	/**
	* Returns a range of all the sanctions where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of sanctions
	* @param end the upper bound of the range of sanctions (not inclusive)
	* @return the range of matching sanctions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.Sanction> findByGroupId_Status(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Status(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the sanctions where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of sanctions
	* @param end the upper bound of the range of sanctions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sanctions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.Sanction> findByGroupId_Status(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_Status(groupId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first sanction in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sanction
	* @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a matching sanction could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction findByGroupId_Status_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchSanctionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_Status_First(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the first sanction in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sanction, or <code>null</code> if a matching sanction could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction fetchByGroupId_Status_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupId_Status_First(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the last sanction in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sanction
	* @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a matching sanction could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction findByGroupId_Status_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchSanctionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_Status_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last sanction in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sanction, or <code>null</code> if a matching sanction could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction fetchByGroupId_Status_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupId_Status_Last(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the sanctions before and after the current sanction in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param sanctionId the primary key of the current sanction
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sanction
	* @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a sanction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction[] findByGroupId_Status_PrevAndNext(
		long sanctionId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchSanctionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_Status_PrevAndNext(sanctionId, groupId,
			status, orderByComparator);
	}

	/**
	* Removes all the sanctions where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId_Status(groupId, status);
	}

	/**
	* Returns the number of sanctions where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching sanctions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId_Status(groupId, status);
	}

	/**
	* Caches the sanction in the entity cache if it is enabled.
	*
	* @param sanction the sanction
	*/
	public static void cacheResult(
		cmr.fandenatech.ndjangui.model.Sanction sanction) {
		getPersistence().cacheResult(sanction);
	}

	/**
	* Caches the sanctions in the entity cache if it is enabled.
	*
	* @param sanctions the sanctions
	*/
	public static void cacheResult(
		java.util.List<cmr.fandenatech.ndjangui.model.Sanction> sanctions) {
		getPersistence().cacheResult(sanctions);
	}

	/**
	* Creates a new sanction with the primary key. Does not add the sanction to the database.
	*
	* @param sanctionId the primary key for the new sanction
	* @return the new sanction
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction create(
		long sanctionId) {
		return getPersistence().create(sanctionId);
	}

	/**
	* Removes the sanction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sanctionId the primary key of the sanction
	* @return the sanction that was removed
	* @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a sanction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction remove(
		long sanctionId)
		throws cmr.fandenatech.ndjangui.NoSuchSanctionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(sanctionId);
	}

	public static cmr.fandenatech.ndjangui.model.Sanction updateImpl(
		cmr.fandenatech.ndjangui.model.Sanction sanction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(sanction);
	}

	/**
	* Returns the sanction with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchSanctionException} if it could not be found.
	*
	* @param sanctionId the primary key of the sanction
	* @return the sanction
	* @throws cmr.fandenatech.ndjangui.NoSuchSanctionException if a sanction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction findByPrimaryKey(
		long sanctionId)
		throws cmr.fandenatech.ndjangui.NoSuchSanctionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(sanctionId);
	}

	/**
	* Returns the sanction with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sanctionId the primary key of the sanction
	* @return the sanction, or <code>null</code> if a sanction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction fetchByPrimaryKey(
		long sanctionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(sanctionId);
	}

	/**
	* Returns all the sanctions.
	*
	* @return the sanctions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.Sanction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the sanctions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sanctions
	* @param end the upper bound of the range of sanctions (not inclusive)
	* @return the range of sanctions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.Sanction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sanctions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sanctions
	* @param end the upper bound of the range of sanctions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sanctions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.Sanction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sanctions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sanctions.
	*
	* @return the number of sanctions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SanctionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SanctionPersistence)PortletBeanLocatorUtil.locate(cmr.fandenatech.ndjangui.service.ClpSerializer.getServletContextName(),
					SanctionPersistence.class.getName());

			ReferenceRegistry.registerReference(SanctionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SanctionPersistence persistence) {
	}

	private static SanctionPersistence _persistence;
}