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
import com.ndjangui.notificationcenter.service.persistence.NotificaMessagePersistenceImpl;
import com.xpiping.notificationcenter.model.NotificaMessage;

/**
 * The persistence interface for the notifica message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcoleo
 * @see NotificaMessagePersistenceImpl
 * @see NotificaMessageUtil
 * @generated
 */
public interface NotificaMessagePersistence extends BasePersistence<NotificaMessage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotificaMessageUtil} to access the notifica message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the notifica messages where notificaId = &#63;.
	*
	* @param notificaId the notifica ID
	* @return the matching notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findByNotificaId(
		long notificaId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findByNotificaId(
		long notificaId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findByNotificaId(
		long notificaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first notifica message in the ordered set where notificaId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica message
	* @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a matching notifica message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaMessage findByNotificaId_First(
		long notificaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException;

	/**
	* Returns the first notifica message in the ordered set where notificaId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notifica message, or <code>null</code> if a matching notifica message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaMessage fetchByNotificaId_First(
		long notificaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last notifica message in the ordered set where notificaId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica message
	* @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a matching notifica message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaMessage findByNotificaId_Last(
		long notificaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException;

	/**
	* Returns the last notifica message in the ordered set where notificaId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notifica message, or <code>null</code> if a matching notifica message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaMessage fetchByNotificaId_Last(
		long notificaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.xpiping.notificationcenter.model.NotificaMessage[] findByNotificaId_PrevAndNext(
		long notificaMessageId, long notificaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException;

	/**
	* Removes all the notifica messages where notificaId = &#63; from the database.
	*
	* @param notificaId the notifica ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNotificaId(long notificaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notifica messages where notificaId = &#63;.
	*
	* @param notificaId the notifica ID
	* @return the number of matching notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByNotificaId(long notificaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the notifica messages where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param entityName the entity name
	* @param entityId the entity ID
	* @return the matching notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findByN_E_E(
		long notificaId, java.lang.String entityName, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findByN_E_E(
		long notificaId, java.lang.String entityName, long entityId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findByN_E_E(
		long notificaId, java.lang.String entityName, long entityId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.xpiping.notificationcenter.model.NotificaMessage findByN_E_E_First(
		long notificaId, java.lang.String entityName, long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException;

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
	public com.xpiping.notificationcenter.model.NotificaMessage fetchByN_E_E_First(
		long notificaId, java.lang.String entityName, long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.xpiping.notificationcenter.model.NotificaMessage findByN_E_E_Last(
		long notificaId, java.lang.String entityName, long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException;

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
	public com.xpiping.notificationcenter.model.NotificaMessage fetchByN_E_E_Last(
		long notificaId, java.lang.String entityName, long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.xpiping.notificationcenter.model.NotificaMessage[] findByN_E_E_PrevAndNext(
		long notificaMessageId, long notificaId, java.lang.String entityName,
		long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException;

	/**
	* Removes all the notifica messages where notificaId = &#63; and entityName = &#63; and entityId = &#63; from the database.
	*
	* @param notificaId the notifica ID
	* @param entityName the entity name
	* @param entityId the entity ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_E_E(long notificaId, java.lang.String entityName,
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notifica messages where notificaId = &#63; and entityName = &#63; and entityId = &#63;.
	*
	* @param notificaId the notifica ID
	* @param entityName the entity name
	* @param entityId the entity ID
	* @return the number of matching notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_E_E(long notificaId, java.lang.String entityName,
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the notifica message in the entity cache if it is enabled.
	*
	* @param notificaMessage the notifica message
	*/
	public void cacheResult(
		com.xpiping.notificationcenter.model.NotificaMessage notificaMessage);

	/**
	* Caches the notifica messages in the entity cache if it is enabled.
	*
	* @param notificaMessages the notifica messages
	*/
	public void cacheResult(
		java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> notificaMessages);

	/**
	* Creates a new notifica message with the primary key. Does not add the notifica message to the database.
	*
	* @param notificaMessageId the primary key for the new notifica message
	* @return the new notifica message
	*/
	public com.xpiping.notificationcenter.model.NotificaMessage create(
		long notificaMessageId);

	/**
	* Removes the notifica message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificaMessageId the primary key of the notifica message
	* @return the notifica message that was removed
	* @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a notifica message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaMessage remove(
		long notificaMessageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException;

	public com.xpiping.notificationcenter.model.NotificaMessage updateImpl(
		com.xpiping.notificationcenter.model.NotificaMessage notificaMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notifica message with the primary key or throws a {@link com.xpiping.notificationcenter.NoSuchNotificaMessageException} if it could not be found.
	*
	* @param notificaMessageId the primary key of the notifica message
	* @return the notifica message
	* @throws com.xpiping.notificationcenter.NoSuchNotificaMessageException if a notifica message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaMessage findByPrimaryKey(
		long notificaMessageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchNotificaMessageException;

	/**
	* Returns the notifica message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notificaMessageId the primary key of the notifica message
	* @return the notifica message, or <code>null</code> if a notifica message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.NotificaMessage fetchByPrimaryKey(
		long notificaMessageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the notifica messages.
	*
	* @return the notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the notifica messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notifica messages.
	*
	* @return the number of notifica messages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}