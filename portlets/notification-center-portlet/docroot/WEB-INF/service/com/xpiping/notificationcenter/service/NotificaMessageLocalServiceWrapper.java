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

package com.xpiping.notificationcenter.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NotificaMessageLocalService}.
 *
 * @author marcoleo
 * @see NotificaMessageLocalService
 * @generated
 */
public class NotificaMessageLocalServiceWrapper
	implements NotificaMessageLocalService,
		ServiceWrapper<NotificaMessageLocalService> {
	public NotificaMessageLocalServiceWrapper(
		NotificaMessageLocalService notificaMessageLocalService) {
		_notificaMessageLocalService = notificaMessageLocalService;
	}

	/**
	* Adds the notifica message to the database. Also notifies the appropriate model listeners.
	*
	* @param notificaMessage the notifica message
	* @return the notifica message that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.xpiping.notificationcenter.model.NotificaMessage addNotificaMessage(
		com.xpiping.notificationcenter.model.NotificaMessage notificaMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.addNotificaMessage(notificaMessage);
	}

	/**
	* Creates a new notifica message with the primary key. Does not add the notifica message to the database.
	*
	* @param notificaMessageId the primary key for the new notifica message
	* @return the new notifica message
	*/
	@Override
	public com.xpiping.notificationcenter.model.NotificaMessage createNotificaMessage(
		long notificaMessageId) {
		return _notificaMessageLocalService.createNotificaMessage(notificaMessageId);
	}

	/**
	* Deletes the notifica message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificaMessageId the primary key of the notifica message
	* @return the notifica message that was removed
	* @throws PortalException if a notifica message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.xpiping.notificationcenter.model.NotificaMessage deleteNotificaMessage(
		long notificaMessageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.deleteNotificaMessage(notificaMessageId);
	}

	/**
	* Deletes the notifica message from the database. Also notifies the appropriate model listeners.
	*
	* @param notificaMessage the notifica message
	* @return the notifica message that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.xpiping.notificationcenter.model.NotificaMessage deleteNotificaMessage(
		com.xpiping.notificationcenter.model.NotificaMessage notificaMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.deleteNotificaMessage(notificaMessage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _notificaMessageLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.xpiping.notificationcenter.model.NotificaMessage fetchNotificaMessage(
		long notificaMessageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.fetchNotificaMessage(notificaMessageId);
	}

	/**
	* Returns the notifica message with the primary key.
	*
	* @param notificaMessageId the primary key of the notifica message
	* @return the notifica message
	* @throws PortalException if a notifica message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.xpiping.notificationcenter.model.NotificaMessage getNotificaMessage(
		long notificaMessageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.getNotificaMessage(notificaMessageId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> getNotificaMessages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.getNotificaMessages(start, end);
	}

	/**
	* Returns the number of notifica messages.
	*
	* @return the number of notifica messages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getNotificaMessagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.getNotificaMessagesCount();
	}

	/**
	* Updates the notifica message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notificaMessage the notifica message
	* @return the notifica message that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.xpiping.notificationcenter.model.NotificaMessage updateNotificaMessage(
		com.xpiping.notificationcenter.model.NotificaMessage notificaMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.updateNotificaMessage(notificaMessage);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _notificaMessageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_notificaMessageLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _notificaMessageLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.xpiping.notificationcenter.model.NotificaMessage addNotificaMessage(
		long companyId, long notificaId, com.liferay.portal.model.User user,
		long entityId, java.lang.String entityName, java.lang.String bcc,
		java.lang.String body, java.lang.String subject)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.addNotificaMessage(companyId,
			notificaId, user, entityId, entityName, bcc, body, subject);
	}

	@Override
	public java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> getNotificaMessages(
		long notificaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.getNotificaMessages(notificaId);
	}

	@Override
	public java.util.List<com.xpiping.notificationcenter.model.NotificaMessage> getNotificaMessages_N_E_E(
		long notificaId, java.lang.String entityName, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificaMessageLocalService.getNotificaMessages_N_E_E(notificaId,
			entityName, entityId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public NotificaMessageLocalService getWrappedNotificaMessageLocalService() {
		return _notificaMessageLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedNotificaMessageLocalService(
		NotificaMessageLocalService notificaMessageLocalService) {
		_notificaMessageLocalService = notificaMessageLocalService;
	}

	@Override
	public NotificaMessageLocalService getWrappedService() {
		return _notificaMessageLocalService;
	}

	@Override
	public void setWrappedService(
		NotificaMessageLocalService notificaMessageLocalService) {
		_notificaMessageLocalService = notificaMessageLocalService;
	}

	private NotificaMessageLocalService _notificaMessageLocalService;
}