/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.xpiping.notificationcenter.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;
import com.ndjangui.notificationcenter.service.persistence.NotificaTypePersistenceImpl;
import com.xpiping.notificationcenter.model.NotificaType;

/**
 * The persistence interface for the notifica type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcoleo
 * @see NotificaTypePersistenceImpl
 * @see NotificaTypeUtil
 * @generated
 */
public interface NotificaTypePersistence extends BasePersistence<NotificaType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotificaTypeUtil} to access the notifica type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the notifica types where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching notifica types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.NotificaType> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the notifica types where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of notifica types
	* @param end the upper bound of the range of notifica types (not inclusive)
	* @return the range of matching notifica types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.NotificaType> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the notifica types where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of notifica types
	* @param end the upper bound of the range of notifica types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notifica types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.NotificaType> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first notifica type in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica type
	* @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a matching notifica type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaType findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaTypeException;

	/**
	* Returns the first notifica type in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica type, or <code>null</code> if a matching notifica type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaType fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last notifica type in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica type
	* @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a matching notifica type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaType findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaTypeException;

	/**
	* Returns the last notifica type in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica type, or <code>null</code> if a matching notifica type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaType fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notifica types before and after the current notifica type in the ordered set where companyId = &#63;.
	*
	* @param notificaTypeId the primary key of the current notifica type
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notifica type
	* @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a notifica type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaType[] findByCompanyId_PrevAndNext(
		long notificaTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaTypeException;

	/**
	* Returns all the notifica types that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching notifica types that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.NotificaType> filterFindByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the notifica types that the user has permission to view where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of notifica types
	* @param end the upper bound of the range of notifica types (not inclusive)
	* @return the range of matching notifica types that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.NotificaType> filterFindByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the notifica types that the user has permissions to view where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of notifica types
	* @param end the upper bound of the range of notifica types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notifica types that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.NotificaType> filterFindByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notifica types before and after the current notifica type in the ordered set of notifica types that the user has permission to view where companyId = &#63;.
	*
	* @param notificaTypeId the primary key of the current notifica type
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notifica type
	* @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a notifica type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaType[] filterFindByCompanyId_PrevAndNext(
		long notificaTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaTypeException;

	/**
	* Removes all the notifica types where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notifica types where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching notifica types
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notifica types that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching notifica types that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notifica type where name = &#63; or throws a {@link com.xpiping.notificationcenter.NoSuchNotificaTypeException} if it could not be found.
	*
	* @param name the name
	* @return the matching notifica type
	* @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a matching notifica type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaType findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaTypeException;

	/**
	* Returns the notifica type where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching notifica type, or <code>null</code> if a matching notifica type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaType fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notifica type where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching notifica type, or <code>null</code> if a matching notifica type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaType fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the notifica type where name = &#63; from the database.
	*
	* @param name the name
	* @return the notifica type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaType removeByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaTypeException;

	/**
	* Returns the number of notifica types where name = &#63;.
	*
	* @param name the name
	* @return the number of matching notifica types
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the notifica type in the entity cache if it is enabled.
	*
	* @param notificaType the notifica type
	*/
	public void cacheResult(
		com.xpiping.notificationcenter.model.NotificaType notificaType);

	/**
	* Caches the notifica types in the entity cache if it is enabled.
	*
	* @param notificaTypes the notifica types
	*/
	public void cacheResult(
		java.util.List<com.xpiping.notificationcenter.model.NotificaType> notificaTypes);

	/**
	* Creates a new notifica type with the primary key. Does not add the notifica type to the database.
	*
	* @param notificaTypeId the primary key for the new notifica type
	* @return the new notifica type
	*/
	public com.xpiping.notificationcenter.model.NotificaType create(
		long notificaTypeId);

	/**
	* Removes the notifica type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificaTypeId the primary key of the notifica type
	* @return the notifica type that was removed
	* @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a notifica type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaType remove(
		long notificaTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaTypeException;

	public com.xpiping.notificationcenter.model.NotificaType updateImpl(
		com.xpiping.notificationcenter.model.NotificaType notificaType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notifica type with the primary key or throws a {@link com.xpiping.notificationcenter.NoSuchNotificaTypeException} if it could not be found.
	*
	* @param notificaTypeId the primary key of the notifica type
	* @return the notifica type
	* @throws com.xpiping.notificationcenter.NoSuchNotificaTypeException if a notifica type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaType findByPrimaryKey(
		long notificaTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaTypeException;

	/**
	* Returns the notifica type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notificaTypeId the primary key of the notifica type
	* @return the notifica type, or <code>null</code> if a notifica type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaType fetchByPrimaryKey(
		long notificaTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the notifica types.
	*
	* @return the notifica types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.NotificaType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the notifica types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notifica types
	* @param end the upper bound of the range of notifica types (not inclusive)
	* @return the range of notifica types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.NotificaType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the notifica types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notifica types
	* @param end the upper bound of the range of notifica types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of notifica types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.NotificaType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the notifica types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notifica types.
	*
	* @return the number of notifica types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}