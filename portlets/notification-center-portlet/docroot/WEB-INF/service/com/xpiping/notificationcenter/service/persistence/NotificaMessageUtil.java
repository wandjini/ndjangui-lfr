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
import com.ndjangui.notificationcenter.service.persistence.NotificaMessagePersistenceImpl;
import com.xpiping.notificationcenter.model.NotificaMessage;

import java.util.List;

/**
 * The persistence utility for the notifica message service. This utility wraps {@link NotificaMessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcoleo
 * @see NotificaMessagePersistence
 * @see NotificaMessagePersistenceImpl
 * @generated
 */
public class NotificaMessageUtil {
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
	public static void clearCache(NotificaMessage notificaMessage) {
		getPersistence().clearCache(notificaMessage);
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
	public static List<NotificaMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NotificaMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NotificaMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static NotificaMessage update(NotificaMessage notificaMessage)
		throws SystemException {
		return getPersistence().update(notificaMessage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static NotificaMessage update(NotificaMessage notificaMessage,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(notificaMessage, serviceContext);
	}

	/**
	* Returns all the notifica messages where notificaId = &#63;.
	*
	* @param notificaId the notifica ID
	* @return the matching notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findByNotificaId(
		long notificaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotificaId(notificaId);
	}

	/**
	* Returns a range of all the notifica messages where notificaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param notificaId the notifica ID
	* @param start the lower bound of the range of notifica messages
	* @param end the upper bound of the range of notifica messages (not inclusive)
	* @return the range of matching notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findByNotificaId(
		long notificaId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotificaId(notificaId, start, end);
	}

	/**
	* Returns an ordered range of all the notifica messages where notificaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param notificaId the notifica ID
	* @param start the lower bound of the range of notifica messages
	* @param end the upper bound of the range of notifica messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findByNotificaId(
		long notificaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNotificaId(notificaId, start, end, orderByComparator);
	}

	/**
	* Returns the first notifica message in the ordered set where notificaId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica message
	* @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a matching notifica message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaMessage findByNotificaId_First(
		long notificaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException {
		return getPersistence()
				   .findByNotificaId_First(notificaId, orderByComparator);
	}

	/**
	* Returns the first notifica message in the ordered set where notificaId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica message, or <code>null</code> if a matching notifica message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaMessage fetchByNotificaId_First(
		long notificaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNotificaId_First(notificaId, orderByComparator);
	}

	/**
	* Returns the last notifica message in the ordered set where notificaId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica message
	* @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a matching notifica message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaMessage findByNotificaId_Last(
		long notificaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException {
		return getPersistence()
				   .findByNotificaId_Last(notificaId, orderByComparator);
	}

	/**
	* Returns the last notifica message in the ordered set where notificaId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica message, or <code>null</code> if a matching notifica message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaMessage fetchByNotificaId_Last(
		long notificaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNotificaId_Last(notificaId, orderByComparator);
	}

	/**
	* Returns the notifica messages before and after the current notifica message in the ordered set where notificaId = &#63;.
	*
	* @param notificaMessageId the primary key of the current notifica message
	* @param notificaId the notifica ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notifica message
	* @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a notifica message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaMessage[] findByNotificaId_PrevAndNext(
		long notificaMessageId, long notificaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException {
		return getPersistence()
				   .findByNotificaId_PrevAndNext(notificaMessageId, notificaId,
			orderByComparator);
	}

	/**
	* Removes all the notifica messages where notificaId = &#63; from the database.
	*
	* @param notificaId the notifica ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNotificaId(long notificaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNotificaId(notificaId);
	}

	/**
	* Returns the number of notifica messages where notificaId = &#63;.
	*
	* @param notificaId the notifica ID
	* @return the number of matching notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNotificaId(long notificaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNotificaId(notificaId);
	}

	/**
	* Returns all the notifica messages where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param entityName the entity name
	* @param entityId the entity ID
	* @return the matching notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findByN_E_E(
		long notificaId, java.lang.String entityName, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByN_E_E(notificaId, entityName, entityId);
	}

	/**
	* Returns a range of all the notifica messages where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param notificaId the notifica ID
	* @param entityName the entity name
	* @param entityId the entity ID
	* @param start the lower bound of the range of notifica messages
	* @param end the upper bound of the range of notifica messages (not inclusive)
	* @return the range of matching notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findByN_E_E(
		long notificaId, java.lang.String entityName, long entityId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByN_E_E(notificaId, entityName, entityId, start, end);
	}

	/**
	* Returns an ordered range of all the notifica messages where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param notificaId the notifica ID
	* @param entityName the entity name
	* @param entityId the entity ID
	* @param start the lower bound of the range of notifica messages
	* @param end the upper bound of the range of notifica messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findByN_E_E(
		long notificaId, java.lang.String entityName, long entityId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByN_E_E(notificaId, entityName, entityId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first notifica message in the ordered set where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param entityName the entity name
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica message
	* @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a matching notifica message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaMessage findByN_E_E_First(
		long notificaId, java.lang.String entityName, long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException {
		return getPersistence()
				   .findByN_E_E_First(notificaId, entityName, entityId,
			orderByComparator);
	}

	/**
	* Returns the first notifica message in the ordered set where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param entityName the entity name
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica message, or <code>null</code> if a matching notifica message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaMessage fetchByN_E_E_First(
		long notificaId, java.lang.String entityName, long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByN_E_E_First(notificaId, entityName, entityId,
			orderByComparator);
	}

	/**
	* Returns the last notifica message in the ordered set where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param entityName the entity name
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica message
	* @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a matching notifica message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaMessage findByN_E_E_Last(
		long notificaId, java.lang.String entityName, long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException {
		return getPersistence()
				   .findByN_E_E_Last(notificaId, entityName, entityId,
			orderByComparator);
	}

	/**
	* Returns the last notifica message in the ordered set where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param entityName the entity name
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica message, or <code>null</code> if a matching notifica message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaMessage fetchByN_E_E_Last(
		long notificaId, java.lang.String entityName, long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByN_E_E_Last(notificaId, entityName, entityId,
			orderByComparator);
	}

	/**
	* Returns the notifica messages before and after the current notifica message in the ordered set where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	*
	* @param notificaMessageId the primary key of the current notifica message
	* @param notificaId the notifica ID
	* @param entityName the entity name
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notifica message
	* @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a notifica message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaMessage[] findByN_E_E_PrevAndNext(
		long notificaMessageId, long notificaId, java.lang.String entityName,
		long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException {
		return getPersistence()
				   .findByN_E_E_PrevAndNext(notificaMessageId, notificaId,
			entityName, entityId, orderByComparator);
	}

	/**
	* Removes all the notifica messages where notificaId = &#63; and entityName = &#63; and entityId = &#63; from the database.
	*
	* @param notificaId the notifica ID
	* @param entityName the entity name
	* @param entityId the entity ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByN_E_E(long notificaId,
		java.lang.String entityName, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByN_E_E(notificaId, entityName, entityId);
	}

	/**
	* Returns the number of notifica messages where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param entityName the entity name
	* @param entityId the entity ID
	* @return the number of matching notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByN_E_E(long notificaId,
		java.lang.String entityName, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByN_E_E(notificaId, entityName, entityId);
	}

	/**
	* Caches the notifica message in the entity cache if it is enabled.
	*
	* @param notificaMessage the notifica message
	*/
	public static void cacheResult(
		com.xpiping.notificationcenter.model.NotificaMessage notificaMessage) {
		getPersistence().cacheResult(notificaMessage);
	}

	/**
	* Caches the notifica messages in the entity cache if it is enabled.
	*
	* @param notificaMessages the notifica messages
	*/
	public static void cacheResult(
		java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> notificaMessages) {
		getPersistence().cacheResult(notificaMessages);
	}

	/**
	* Creates a new notifica message with the primary key. Does not add the notifica message to the database.
	*
	* @param notificaMessageId the primary key for the new notifica message
	* @return the new notifica message
	*/
	public static com.xpiping.notificationcenter.model.NotificaMessage create(
		long notificaMessageId) {
		return getPersistence().create(notificaMessageId);
	}

	/**
	* Removes the notifica message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificaMessageId the primary key of the notifica message
	* @return the notifica message that was removed
	* @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a notifica message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaMessage remove(
		long notificaMessageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException {
		return getPersistence().remove(notificaMessageId);
	}

	public static com.xpiping.notificationcenter.model.NotificaMessage updateImpl(
		com.xpiping.notificationcenter.model.NotificaMessage notificaMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(notificaMessage);
	}

	/**
	* Returns the notifica message with the primary key or throws a {@link com.xpiping.notificationcenter.NoSuchNotificaMessageException} if it could not be found.
	*
	* @param notificaMessageId the primary key of the notifica message
	* @return the notifica message
	* @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a notifica message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaMessage findByPrimaryKey(
		long notificaMessageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException {
		return getPersistence().findByPrimaryKey(notificaMessageId);
	}

	/**
	* Returns the notifica message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notificaMessageId the primary key of the notifica message
	* @return the notifica message, or <code>null</code> if a notifica message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaMessage fetchByPrimaryKey(
		long notificaMessageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(notificaMessageId);
	}

	/**
	* Returns all the notifica messages.
	*
	* @return the notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the notifica messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notifica messages
	* @param end the upper bound of the range of notifica messages (not inclusive)
	* @return the range of notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the notifica messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notifica messages
	* @param end the upper bound of the range of notifica messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the notifica messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of notifica messages.
	*
	* @return the number of notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NotificaMessagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NotificaMessagePersistence)PortletBeanLocatorUtil.locate(com.xpiping.notificationcenter.service.ClpSerializer.getServletContextName(),
					NotificaMessagePersistence.class.getName());

			ReferenceRegistry.registerReference(NotificaMessageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(NotificaMessagePersistence persistence) {
	}

	private static NotificaMessagePersistence _persistence;
}