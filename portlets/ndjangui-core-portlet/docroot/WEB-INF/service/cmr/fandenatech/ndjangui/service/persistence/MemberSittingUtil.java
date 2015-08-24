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

import cmr.fandenatech.ndjangui.model.MemberSitting;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the member sitting service. This utility wraps {@link MemberSittingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see MemberSittingPersistence
 * @see MemberSittingPersistenceImpl
 * @generated
 */
public class MemberSittingUtil {
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
	public static void clearCache(MemberSitting memberSitting) {
		getPersistence().clearCache(memberSitting);
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
	public static List<MemberSitting> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MemberSitting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MemberSitting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MemberSitting update(MemberSitting memberSitting)
		throws SystemException {
		return getPersistence().update(memberSitting);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MemberSitting update(MemberSitting memberSitting,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(memberSitting, serviceContext);
	}

	/**
	* Returns all the member sittings where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching member sittings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the member sittings where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of member sittings
	* @param end the upper bound of the range of member sittings (not inclusive)
	* @return the range of matching member sittings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the member sittings where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of member sittings
	* @param end the upper bound of the range of member sittings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching member sittings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first member sitting in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching member sitting
	* @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a matching member sitting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first member sitting in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching member sitting, or <code>null</code> if a matching member sitting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last member sitting in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching member sitting
	* @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a matching member sitting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last member sitting in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching member sitting, or <code>null</code> if a matching member sitting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the member sittings before and after the current member sitting in the ordered set where groupId = &#63;.
	*
	* @param memberSittingId the primary key of the current member sitting
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next member sitting
	* @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a member sitting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting[] findByGroupId_PrevAndNext(
		long memberSittingId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(memberSittingId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the member sittings where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of member sittings where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching member sittings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the member sittings where groupId = &#63; and sittingId = &#63;.
	*
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @return the matching member sittings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findByGroupId_SittingId(
		long groupId, long sittingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_SittingId(groupId, sittingId);
	}

	/**
	* Returns a range of all the member sittings where groupId = &#63; and sittingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @param start the lower bound of the range of member sittings
	* @param end the upper bound of the range of member sittings (not inclusive)
	* @return the range of matching member sittings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findByGroupId_SittingId(
		long groupId, long sittingId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_SittingId(groupId, sittingId, start, end);
	}

	/**
	* Returns an ordered range of all the member sittings where groupId = &#63; and sittingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @param start the lower bound of the range of member sittings
	* @param end the upper bound of the range of member sittings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching member sittings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findByGroupId_SittingId(
		long groupId, long sittingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_SittingId(groupId, sittingId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first member sitting in the ordered set where groupId = &#63; and sittingId = &#63;.
	*
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching member sitting
	* @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a matching member sitting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting findByGroupId_SittingId_First(
		long groupId, long sittingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_SittingId_First(groupId, sittingId,
			orderByComparator);
	}

	/**
	* Returns the first member sitting in the ordered set where groupId = &#63; and sittingId = &#63;.
	*
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching member sitting, or <code>null</code> if a matching member sitting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting fetchByGroupId_SittingId_First(
		long groupId, long sittingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupId_SittingId_First(groupId, sittingId,
			orderByComparator);
	}

	/**
	* Returns the last member sitting in the ordered set where groupId = &#63; and sittingId = &#63;.
	*
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching member sitting
	* @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a matching member sitting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting findByGroupId_SittingId_Last(
		long groupId, long sittingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_SittingId_Last(groupId, sittingId,
			orderByComparator);
	}

	/**
	* Returns the last member sitting in the ordered set where groupId = &#63; and sittingId = &#63;.
	*
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching member sitting, or <code>null</code> if a matching member sitting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting fetchByGroupId_SittingId_Last(
		long groupId, long sittingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupId_SittingId_Last(groupId, sittingId,
			orderByComparator);
	}

	/**
	* Returns the member sittings before and after the current member sitting in the ordered set where groupId = &#63; and sittingId = &#63;.
	*
	* @param memberSittingId the primary key of the current member sitting
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next member sitting
	* @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a member sitting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting[] findByGroupId_SittingId_PrevAndNext(
		long memberSittingId, long groupId, long sittingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_SittingId_PrevAndNext(memberSittingId,
			groupId, sittingId, orderByComparator);
	}

	/**
	* Removes all the member sittings where groupId = &#63; and sittingId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId_SittingId(long groupId, long sittingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId_SittingId(groupId, sittingId);
	}

	/**
	* Returns the number of member sittings where groupId = &#63; and sittingId = &#63;.
	*
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @return the number of matching member sittings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId_SittingId(long groupId, long sittingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId_SittingId(groupId, sittingId);
	}

	/**
	* Caches the member sitting in the entity cache if it is enabled.
	*
	* @param memberSitting the member sitting
	*/
	public static void cacheResult(
		cmr.fandenatech.ndjangui.model.MemberSitting memberSitting) {
		getPersistence().cacheResult(memberSitting);
	}

	/**
	* Caches the member sittings in the entity cache if it is enabled.
	*
	* @param memberSittings the member sittings
	*/
	public static void cacheResult(
		java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> memberSittings) {
		getPersistence().cacheResult(memberSittings);
	}

	/**
	* Creates a new member sitting with the primary key. Does not add the member sitting to the database.
	*
	* @param memberSittingId the primary key for the new member sitting
	* @return the new member sitting
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting create(
		long memberSittingId) {
		return getPersistence().create(memberSittingId);
	}

	/**
	* Removes the member sitting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param memberSittingId the primary key of the member sitting
	* @return the member sitting that was removed
	* @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a member sitting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting remove(
		long memberSittingId)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(memberSittingId);
	}

	public static cmr.fandenatech.ndjangui.model.MemberSitting updateImpl(
		cmr.fandenatech.ndjangui.model.MemberSitting memberSitting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(memberSitting);
	}

	/**
	* Returns the member sitting with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchMemberSittingException} if it could not be found.
	*
	* @param memberSittingId the primary key of the member sitting
	* @return the member sitting
	* @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a member sitting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting findByPrimaryKey(
		long memberSittingId)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(memberSittingId);
	}

	/**
	* Returns the member sitting with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param memberSittingId the primary key of the member sitting
	* @return the member sitting, or <code>null</code> if a member sitting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting fetchByPrimaryKey(
		long memberSittingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(memberSittingId);
	}

	/**
	* Returns all the member sittings.
	*
	* @return the member sittings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the member sittings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of member sittings
	* @param end the upper bound of the range of member sittings (not inclusive)
	* @return the range of member sittings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the member sittings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of member sittings
	* @param end the upper bound of the range of member sittings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of member sittings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the member sittings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of member sittings.
	*
	* @return the number of member sittings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MemberSittingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MemberSittingPersistence)PortletBeanLocatorUtil.locate(cmr.fandenatech.ndjangui.service.ClpSerializer.getServletContextName(),
					MemberSittingPersistence.class.getName());

			ReferenceRegistry.registerReference(MemberSittingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MemberSittingPersistence persistence) {
	}

	private static MemberSittingPersistence _persistence;
}