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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;
import com.ndjangui.notificationcenter.service.persistence.NotificaPersistenceImpl;
import com.xpiping.notificationcenter.model.Notifica;

import java.util.List;

/**
 * The persistence utility for the notifica service. This utility wraps {@link NotificaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcoleo
 * @see NotificaPersistence
 * @see NotificaPersistenceImpl
 * @generated
 */
public class NotificaUtil {
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
	public static void clearCache(Notifica notifica) {
		getPersistence().clearCache(notifica);
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
	public static List<Notifica> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Notifica> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Notifica> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Notifica update(Notifica notifica) throws SystemException {
		return getPersistence().update(notifica);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Notifica update(Notifica notifica,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(notifica, serviceContext);
	}

	/**
	* Returns all the notificas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching notificas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

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
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

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
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first notifica in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first notifica in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica, or <code>null</code> if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last notifica in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last notifica in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica, or <code>null</code> if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

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
	public static com.xpiping.notificationcenter.model.Notifica[] findByCompanyId_PrevAndNext(
		long notificaId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(notificaId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the notificas that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching notificas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> filterFindByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCompanyId(companyId);
	}

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
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> filterFindByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCompanyId(companyId, start, end);
	}

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
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> filterFindByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCompanyId(companyId, start, end,
			orderByComparator);
	}

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
	public static com.xpiping.notificationcenter.model.Notifica[] filterFindByCompanyId_PrevAndNext(
		long notificaId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException {
		return getPersistence()
				   .filterFindByCompanyId_PrevAndNext(notificaId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the notificas where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of notificas where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching notificas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of notificas that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching notificas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByCompanyId(companyId);
	}

	/**
	* Returns all the notificas where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @return the matching notificas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> findByNotificaTypeId(
		long notificaTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotificaTypeId(notificaTypeId);
	}

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
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> findByNotificaTypeId(
		long notificaTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotificaTypeId(notificaTypeId, start, end);
	}

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
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> findByNotificaTypeId(
		long notificaTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNotificaTypeId(notificaTypeId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first notifica in the ordered set where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica findByNotificaTypeId_First(
		long notificaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException {
		return getPersistence()
				   .findByNotificaTypeId_First(notificaTypeId, orderByComparator);
	}

	/**
	* Returns the first notifica in the ordered set where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica, or <code>null</code> if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica fetchByNotificaTypeId_First(
		long notificaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNotificaTypeId_First(notificaTypeId,
			orderByComparator);
	}

	/**
	* Returns the last notifica in the ordered set where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica findByNotificaTypeId_Last(
		long notificaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException {
		return getPersistence()
				   .findByNotificaTypeId_Last(notificaTypeId, orderByComparator);
	}

	/**
	* Returns the last notifica in the ordered set where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica, or <code>null</code> if a matching notifica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica fetchByNotificaTypeId_Last(
		long notificaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNotificaTypeId_Last(notificaTypeId, orderByComparator);
	}

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
	public static com.xpiping.notificationcenter.model.Notifica[] findByNotificaTypeId_PrevAndNext(
		long notificaId, long notificaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException {
		return getPersistence()
				   .findByNotificaTypeId_PrevAndNext(notificaId,
			notificaTypeId, orderByComparator);
	}

	/**
	* Returns all the notificas that the user has permission to view where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @return the matching notificas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> filterFindByNotificaTypeId(
		long notificaTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByNotificaTypeId(notificaTypeId);
	}

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
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> filterFindByNotificaTypeId(
		long notificaTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByNotificaTypeId(notificaTypeId, start, end);
	}

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
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> filterFindByNotificaTypeId(
		long notificaTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByNotificaTypeId(notificaTypeId, start, end,
			orderByComparator);
	}

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
	public static com.xpiping.notificationcenter.model.Notifica[] filterFindByNotificaTypeId_PrevAndNext(
		long notificaId, long notificaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException {
		return getPersistence()
				   .filterFindByNotificaTypeId_PrevAndNext(notificaId,
			notificaTypeId, orderByComparator);
	}

	/**
	* Removes all the notificas where notificaTypeId = &#63; from the database.
	*
	* @param notificaTypeId the notifica type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNotificaTypeId(long notificaTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNotificaTypeId(notificaTypeId);
	}

	/**
	* Returns the number of notificas where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @return the number of matching notificas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNotificaTypeId(long notificaTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNotificaTypeId(notificaTypeId);
	}

	/**
	* Returns the number of notificas that the user has permission to view where notificaTypeId = &#63;.
	*
	* @param notificaTypeId the notifica type ID
	* @return the number of matching notificas that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByNotificaTypeId(long notificaTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByNotificaTypeId(notificaTypeId);
	}

	/**
	* Caches the notifica in the entity cache if it is enabled.
	*
	* @param notifica the notifica
	*/
	public static void cacheResult(
		com.xpiping.notificationcenter.model.Notifica notifica) {
		getPersistence().cacheResult(notifica);
	}

	/**
	* Caches the notificas in the entity cache if it is enabled.
	*
	* @param notificas the notificas
	*/
	public static void cacheResult(
		java.util.List<com.xpiping.notificationcenter.model.Notifica> notificas) {
		getPersistence().cacheResult(notificas);
	}

	/**
	* Creates a new notifica with the primary key. Does not add the notifica to the database.
	*
	* @param notificaId the primary key for the new notifica
	* @return the new notifica
	*/
	public static com.xpiping.notificationcenter.model.Notifica create(
		long notificaId) {
		return getPersistence().create(notificaId);
	}

	/**
	* Removes the notifica with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificaId the primary key of the notifica
	* @return the notifica that was removed
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica remove(
		long notificaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException {
		return getPersistence().remove(notificaId);
	}

	public static com.xpiping.notificationcenter.model.Notifica updateImpl(
		com.xpiping.notificationcenter.model.Notifica notifica)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(notifica);
	}

	/**
	* Returns the notifica with the primary key or throws a {@link com.xpiping.notificationcenter.NoSuchNotificaException} if it could not be found.
	*
	* @param notificaId the primary key of the notifica
	* @return the notifica
	* @throws com.xpiping.notificationcenter.NoSuchNotificaException if a notifica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica findByPrimaryKey(
		long notificaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaException {
		return getPersistence().findByPrimaryKey(notificaId);
	}

	/**
	* Returns the notifica with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notificaId the primary key of the notifica
	* @return the notifica, or <code>null</code> if a notifica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica fetchByPrimaryKey(
		long notificaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(notificaId);
	}

	/**
	* Returns all the notificas.
	*
	* @return the notificas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the notificas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of notificas.
	*
	* @return the number of notificas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NotificaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NotificaPersistence)PortletBeanLocatorUtil.locate(com.xpiping.notificationcenter.service.ClpSerializer.getServletContextName(),
					NotificaPersistence.class.getName());

			ReferenceRegistry.registerReference(NotificaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(NotificaPersistence persistence) {
	}

	private static NotificaPersistence _persistence;
}