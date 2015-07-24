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
import com.ndjangui.notificationcenter.service.persistence.NotificaPersistenceImpl;
import com.xpiping.notificationcenter.model.Notifica;

/**
 * The persistence interface for the notifica service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcoleo
 * @see NotificaPersistenceImpl
 * @see NotificaUtil
 * @generated
 */
public interface NotificaPersistence extends BasePersistence<Notifica> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotificaUtil} to access the notifica persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the notificas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching notificas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the notificas where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of notificas
	* @param end the upper bound of the range of notificas (not inclusive)
	* @return the range of matching notificas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the notificas where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of notificas
	* @param end the upper bound of the range of notificas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notificas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first notifica in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException;

	/**
	* Returns the first notifica in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica, or <code>null</code> if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last notifica in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException;

	/**
	* Returns the last notifica in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica, or <code>null</code> if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notificas before and after the current notifica in the ordered set where companyId = &#63;.
	*
	* @param notificaId the primary key of the current notifica
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notifica
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica[] findByCompanyId_PrevAndNext(
		long notificaId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException;

	/**
	* Returns all the notificas that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching notificas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> filterFindByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the notificas that the user has permission to view where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of notificas
	* @param end the upper bound of the range of notificas (not inclusive)
	* @return the range of matching notificas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> filterFindByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the notificas that the user has permissions to view where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of notificas
	* @param end the upper bound of the range of notificas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notificas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> filterFindByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notificas before and after the current notifica in the ordered set of notificas that the user has permission to view where companyId = &#63;.
	*
	* @param notificaId the primary key of the current notifica
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notifica
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica[] filterFindByCompanyId_PrevAndNext(
		long notificaId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException;

	/**
	* Removes all the notificas where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notificas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching notificas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notificas that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching notificas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the notificas where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @return the matching notificas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> findByNotificaTypeId(
		long notificaTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the notificas where notificaTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param notificaTypeId the notifica type ID
	* @param start the lower bound of the range of notificas
	* @param end the upper bound of the range of notificas (not inclusive)
	* @return the range of matching notificas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> findByNotificaTypeId(
		long notificaTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the notificas where notificaTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param notificaTypeId the notifica type ID
	* @param start the lower bound of the range of notificas
	* @param end the upper bound of the range of notificas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notificas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> findByNotificaTypeId(
		long notificaTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first notifica in the ordered set where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica findByNotificaTypeId_First(
		long notificaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException;

	/**
	* Returns the first notifica in the ordered set where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica, or <code>null</code> if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica fetchByNotificaTypeId_First(
		long notificaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last notifica in the ordered set where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica findByNotificaTypeId_Last(
		long notificaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException;

	/**
	* Returns the last notifica in the ordered set where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica, or <code>null</code> if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica fetchByNotificaTypeId_Last(
		long notificaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notificas before and after the current notifica in the ordered set where notificaTypeId = &#63;.
	*
	* @param notificaId the primary key of the current notifica
	* @param notificaTypeId the notifica type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notifica
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica[] findByNotificaTypeId_PrevAndNext(
		long notificaId, long notificaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException;

	/**
	* Returns all the notificas that the user has permission to view where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @return the matching notificas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> filterFindByNotificaTypeId(
		long notificaTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the notificas that the user has permission to view where notificaTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param notificaTypeId the notifica type ID
	* @param start the lower bound of the range of notificas
	* @param end the upper bound of the range of notificas (not inclusive)
	* @return the range of matching notificas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> filterFindByNotificaTypeId(
		long notificaTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the notificas that the user has permissions to view where notificaTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param notificaTypeId the notifica type ID
	* @param start the lower bound of the range of notificas
	* @param end the upper bound of the range of notificas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notificas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> filterFindByNotificaTypeId(
		long notificaTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notificas before and after the current notifica in the ordered set of notificas that the user has permission to view where notificaTypeId = &#63;.
	*
	* @param notificaId the primary key of the current notifica
	* @param notificaTypeId the notifica type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notifica
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica[] filterFindByNotificaTypeId_PrevAndNext(
		long notificaId, long notificaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException;

	/**
	* Removes all the notificas where notificaTypeId = &#63; from the database.
	*
	* @param notificaTypeId the notifica type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNotificaTypeId(long notificaTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notificas where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @return the number of matching notificas
	* @throws SystemException if a system exception occurred
	*/
	public int countByNotificaTypeId(long notificaTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notificas that the user has permission to view where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @return the number of matching notificas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByNotificaTypeId(long notificaTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the notifica in the entity cache if it is enabled.
	*
	* @param notifica the notifica
	*/
	public void cacheResult(
		com.xpiping.notificationcenter.model.Notifica notifica);

	/**
	* Caches the notificas in the entity cache if it is enabled.
	*
	* @param notificas the notificas
	*/
	public void cacheResult(
		java.util.List<com.xpiping.notificationcenter.model.Notifica> notificas);

	/**
	* Creates a new notifica with the primary key. Does not add the notifica to the database.
	*
	* @param notificaId the primary key for the new notifica
	* @return the new notifica
	*/
	public com.xpiping.notificationcenter.model.Notifica create(long notificaId);

	/**
	* Removes the notifica with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificaId the primary key of the notifica
	* @return the notifica that was removed
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica remove(long notificaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException;

	public com.xpiping.notificationcenter.model.Notifica updateImpl(
		com.xpiping.notificationcenter.model.Notifica notifica)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notifica with the primary key or throws a {@link com.xpiping.notificationcenter.NoSuchNotificaException} if it could not be found.
	*
	* @param notificaId the primary key of the notifica
	* @return the notifica
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica findByPrimaryKey(
		long notificaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException;

	/**
	* Returns the notifica with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notificaId the primary key of the notifica
	* @return the notifica, or <code>null</code> if a notifica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.Notifica fetchByPrimaryKey(
		long notificaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the notificas.
	*
	* @return the notificas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the notificas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notificas
	* @param end the upper bound of the range of notificas (not inclusive)
	* @return the range of notificas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the notificas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notificas
	* @param end the upper bound of the range of notificas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of notificas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.Notifica> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the notificas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notificas.
	*
	* @return the number of notificas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}