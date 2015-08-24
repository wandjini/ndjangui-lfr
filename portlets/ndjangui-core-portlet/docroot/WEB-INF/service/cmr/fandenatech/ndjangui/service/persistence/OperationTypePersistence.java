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

import cmr.fandenatech.ndjangui.model.OperationType;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the operation type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see OperationTypePersistenceImpl
 * @see OperationTypeUtil
 * @generated
 */
public interface OperationTypePersistence extends BasePersistence<OperationType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OperationTypeUtil} to access the operation type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the operation types where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching operation types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.OperationType> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the operation types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of operation types
	* @param end the upper bound of the range of operation types (not inclusive)
	* @return the range of matching operation types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.OperationType> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the operation types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of operation types
	* @param end the upper bound of the range of operation types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching operation types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.OperationType> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first operation type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching operation type
	* @throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException if a matching operation type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first operation type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching operation type, or <code>null</code> if a matching operation type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last operation type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching operation type
	* @throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException if a matching operation type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last operation type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching operation type, or <code>null</code> if a matching operation type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the operation types before and after the current operation type in the ordered set where groupId = &#63;.
	*
	* @param operationTypeId the primary key of the current operation type
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next operation type
	* @throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException if a operation type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType[] findByGroupId_PrevAndNext(
		long operationTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the operation types where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of operation types where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching operation types
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the operation types where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching operation types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.OperationType> findByGroupId_Status(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the operation types where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of operation types
	* @param end the upper bound of the range of operation types (not inclusive)
	* @return the range of matching operation types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.OperationType> findByGroupId_Status(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the operation types where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of operation types
	* @param end the upper bound of the range of operation types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching operation types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.OperationType> findByGroupId_Status(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first operation type in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching operation type
	* @throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException if a matching operation type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType findByGroupId_Status_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first operation type in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching operation type, or <code>null</code> if a matching operation type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType fetchByGroupId_Status_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last operation type in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching operation type
	* @throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException if a matching operation type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType findByGroupId_Status_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last operation type in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching operation type, or <code>null</code> if a matching operation type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType fetchByGroupId_Status_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the operation types before and after the current operation type in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param operationTypeId the primary key of the current operation type
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next operation type
	* @throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException if a operation type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType[] findByGroupId_Status_PrevAndNext(
		long operationTypeId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the operation types where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of operation types where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching operation types
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the operation type where groupId = &#63; and name = &#63; or throws a {@link cmr.fandenatech.ndjangui.NoSuchOperationTypeException} if it could not be found.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the matching operation type
	* @throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException if a matching operation type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType findByGroupId_Name(
		long groupId, java.lang.String name)
		throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the operation type where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the matching operation type, or <code>null</code> if a matching operation type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType fetchByGroupId_Name(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the operation type where groupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching operation type, or <code>null</code> if a matching operation type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType fetchByGroupId_Name(
		long groupId, java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the operation type where groupId = &#63; and name = &#63; from the database.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the operation type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType removeByGroupId_Name(
		long groupId, java.lang.String name)
		throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of operation types where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the number of matching operation types
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId_Name(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the operation type in the entity cache if it is enabled.
	*
	* @param operationType the operation type
	*/
	public void cacheResult(
		cmr.fandenatech.ndjangui.model.OperationType operationType);

	/**
	* Caches the operation types in the entity cache if it is enabled.
	*
	* @param operationTypes the operation types
	*/
	public void cacheResult(
		java.util.List<cmr.fandenatech.ndjangui.model.OperationType> operationTypes);

	/**
	* Creates a new operation type with the primary key. Does not add the operation type to the database.
	*
	* @param operationTypeId the primary key for the new operation type
	* @return the new operation type
	*/
	public cmr.fandenatech.ndjangui.model.OperationType create(
		long operationTypeId);

	/**
	* Removes the operation type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param operationTypeId the primary key of the operation type
	* @return the operation type that was removed
	* @throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException if a operation type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType remove(
		long operationTypeId)
		throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	public cmr.fandenatech.ndjangui.model.OperationType updateImpl(
		cmr.fandenatech.ndjangui.model.OperationType operationType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the operation type with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchOperationTypeException} if it could not be found.
	*
	* @param operationTypeId the primary key of the operation type
	* @return the operation type
	* @throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException if a operation type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType findByPrimaryKey(
		long operationTypeId)
		throws cmr.fandenatech.ndjangui.NoSuchOperationTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the operation type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param operationTypeId the primary key of the operation type
	* @return the operation type, or <code>null</code> if a operation type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.OperationType fetchByPrimaryKey(
		long operationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the operation types.
	*
	* @return the operation types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.OperationType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the operation types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of operation types
	* @param end the upper bound of the range of operation types (not inclusive)
	* @return the range of operation types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.OperationType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the operation types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of operation types
	* @param end the upper bound of the range of operation types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of operation types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.OperationType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the operation types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of operation types.
	*
	* @return the number of operation types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}