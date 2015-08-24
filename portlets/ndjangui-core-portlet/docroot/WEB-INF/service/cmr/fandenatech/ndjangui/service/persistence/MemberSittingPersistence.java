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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the member sitting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see MemberSittingPersistenceImpl
 * @see MemberSittingUtil
 * @generated
 */
public interface MemberSittingPersistence extends BasePersistence<MemberSitting> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MemberSittingUtil} to access the member sitting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the member sittings where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching member sittings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first member sitting in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching member sitting
	* @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a matching member sitting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.MemberSitting findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first member sitting in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching member sitting, or <code>null</code> if a matching member sitting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.MemberSitting fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last member sitting in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching member sitting
	* @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a matching member sitting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.MemberSitting findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last member sitting in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching member sitting, or <code>null</code> if a matching member sitting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.MemberSitting fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public cmr.fandenatech.ndjangui.model.MemberSitting[] findByGroupId_PrevAndNext(
		long memberSittingId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the member sittings where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of member sittings where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching member sittings
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the member sittings where groupId = &#63; and sittingId = &#63;.
	*
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @return the matching member sittings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findByGroupId_SittingId(
		long groupId, long sittingId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findByGroupId_SittingId(
		long groupId, long sittingId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findByGroupId_SittingId(
		long groupId, long sittingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public cmr.fandenatech.ndjangui.model.MemberSitting findByGroupId_SittingId_First(
		long groupId, long sittingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first member sitting in the ordered set where groupId = &#63; and sittingId = &#63;.
	*
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching member sitting, or <code>null</code> if a matching member sitting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.MemberSitting fetchByGroupId_SittingId_First(
		long groupId, long sittingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public cmr.fandenatech.ndjangui.model.MemberSitting findByGroupId_SittingId_Last(
		long groupId, long sittingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last member sitting in the ordered set where groupId = &#63; and sittingId = &#63;.
	*
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching member sitting, or <code>null</code> if a matching member sitting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.MemberSitting fetchByGroupId_SittingId_Last(
		long groupId, long sittingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public cmr.fandenatech.ndjangui.model.MemberSitting[] findByGroupId_SittingId_PrevAndNext(
		long memberSittingId, long groupId, long sittingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the member sittings where groupId = &#63; and sittingId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId_SittingId(long groupId, long sittingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of member sittings where groupId = &#63; and sittingId = &#63;.
	*
	* @param groupId the group ID
	* @param sittingId the sitting ID
	* @return the number of matching member sittings
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId_SittingId(long groupId, long sittingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the member sitting in the entity cache if it is enabled.
	*
	* @param memberSitting the member sitting
	*/
	public void cacheResult(
		cmr.fandenatech.ndjangui.model.MemberSitting memberSitting);

	/**
	* Caches the member sittings in the entity cache if it is enabled.
	*
	* @param memberSittings the member sittings
	*/
	public void cacheResult(
		java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> memberSittings);

	/**
	* Creates a new member sitting with the primary key. Does not add the member sitting to the database.
	*
	* @param memberSittingId the primary key for the new member sitting
	* @return the new member sitting
	*/
	public cmr.fandenatech.ndjangui.model.MemberSitting create(
		long memberSittingId);

	/**
	* Removes the member sitting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param memberSittingId the primary key of the member sitting
	* @return the member sitting that was removed
	* @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a member sitting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.MemberSitting remove(
		long memberSittingId)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException;

	public cmr.fandenatech.ndjangui.model.MemberSitting updateImpl(
		cmr.fandenatech.ndjangui.model.MemberSitting memberSitting)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the member sitting with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchMemberSittingException} if it could not be found.
	*
	* @param memberSittingId the primary key of the member sitting
	* @return the member sitting
	* @throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException if a member sitting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.MemberSitting findByPrimaryKey(
		long memberSittingId)
		throws cmr.fandenatech.ndjangui.NoSuchMemberSittingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the member sitting with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param memberSittingId the primary key of the member sitting
	* @return the member sitting, or <code>null</code> if a member sitting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.MemberSitting fetchByPrimaryKey(
		long memberSittingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the member sittings.
	*
	* @return the member sittings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the member sittings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of member sittings.
	*
	* @return the number of member sittings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}