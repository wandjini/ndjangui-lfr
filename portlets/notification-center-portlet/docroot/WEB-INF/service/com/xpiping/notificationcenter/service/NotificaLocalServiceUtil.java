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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Notifica. This utility wraps
 * {@link com.ndjangui.notificationcenter.service.impl.NotificaLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author marcoleo
 * @see NotificaLocalService
 * @see com.ndjangui.notificationcenter.service.base.NotificaLocalServiceBaseImpl
 * @see com.ndjangui.notificationcenter.service.impl.NotificaLocalServiceImpl
 * @generated
 */
public class NotificaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.xpiping.notificationcenter.service.impl.NotificaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the notifica to the database. Also notifies the appropriate model listeners.
	*
	* @param notifica the notifica
	* @return the notifica that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica addNotifica(
		com.xpiping.notificationcenter.model.Notifica notifica)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addNotifica(notifica);
	}

	/**
	* Creates a new notifica with the primary key. Does not add the notifica to the database.
	*
	* @param notificaId the primary key for the new notifica
	* @return the new notifica
	*/
	public static com.xpiping.notificationcenter.model.Notifica createNotifica(
		long notificaId) {
		return getService().createNotifica(notificaId);
	}

	/**
	* Deletes the notifica with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificaId the primary key of the notifica
	* @return the notifica that was removed
	* @throws PortalException if a notifica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica deleteNotifica(
		long notificaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteNotifica(notificaId);
	}

	/**
	* Deletes the notifica from the database. Also notifies the appropriate model listeners.
	*
	* @param notifica the notifica
	* @return the notifica that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica deleteNotifica(
		com.xpiping.notificationcenter.model.Notifica notifica)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteNotifica(notifica);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.xpiping.notificationcenter.model.Notifica fetchNotifica(
		long notificaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchNotifica(notificaId);
	}

	/**
	* Returns the notifica with the primary key.
	*
	* @param notificaId the primary key of the notifica
	* @return the notifica
	* @throws PortalException if a notifica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica getNotifica(
		long notificaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getNotifica(notificaId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> getNotificas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNotificas(start, end);
	}

	/**
	* Returns the number of notificas.
	*
	* @return the number of notificas
	* @throws SystemException if a system exception occurred
	*/
	public static int getNotificasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNotificasCount();
	}

	/**
	* Updates the notifica in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notifica the notifica
	* @return the notifica that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.Notifica updateNotifica(
		com.xpiping.notificationcenter.model.Notifica notifica)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNotifica(notifica);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.xpiping.notificationcenter.model.Notifica addNotifica(
		long notificaTypeId, java.lang.String name, java.lang.String text,
		java.lang.String subject, java.lang.String description,
		java.lang.Boolean aviable, java.lang.Boolean ignoreIntersaction,
		java.lang.String orgsIds, java.lang.String groupsIds,
		java.lang.String rolesIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addNotifica(notificaTypeId, name, text, subject,
			description, aviable, ignoreIntersaction, orgsIds, groupsIds,
			rolesIds, serviceContext);
	}

	public static com.xpiping.notificationcenter.model.Notifica updateNotifica(
		long notificaId, java.lang.String text, java.lang.String subject,
		java.lang.String description, java.lang.Boolean aviable,
		java.lang.Boolean ignoreIntersaction, java.lang.String orgsIds,
		java.lang.String groupsIds, java.lang.String rolesIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateNotifica(notificaId, text, subject, description,
			aviable, ignoreIntersaction, orgsIds, groupsIds, rolesIds,
			serviceContext);
	}

	public static java.util.List<com.xpiping.notificationcenter.model.Notifica> getNotifiche(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNotifiche(companyId, start, end);
	}

	public static int countNotifiche(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countNotifiche(companyId);
	}

	public static java.util.List<com.liferay.portal.model.User> getUsersPerNotifica(
		long notificaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUsersPerNotifica(notificaId);
	}

	public static void sendNotificaType(java.lang.String notificaTypeName,
		java.lang.String entityName, long entityId, long[] userIds,
		java.util.Map<java.lang.String, java.lang.Object> placeHolders,
		boolean forceReSend)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService()
			.sendNotificaType(notificaTypeName, entityName, entityId, userIds,
			placeHolders, forceReSend);
	}

	public static void sendNotifica(long notificaId,
		java.lang.String entityName, long entityId,
		java.util.List<com.liferay.portal.model.User> users,
		java.util.Map<java.lang.String, java.lang.Object> placeHolders,
		boolean forceReSend)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.sendNotifica(notificaId, entityName, entityId, users,
			placeHolders, forceReSend);
	}

	public static void sendNotifica(
		com.xpiping.notificationcenter.model.Notifica notifica,
		java.lang.String entityName, long entityId,
		java.util.List<com.liferay.portal.model.User> users,
		java.util.Map<java.lang.String, java.lang.Object> placeHolders,
		boolean forceReSend)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.sendNotifica(notifica, entityName, entityId, users, placeHolders,
			forceReSend);
	}

	public static java.lang.String formatNotificaText(
		java.lang.String textToReplace,
		java.util.Map<java.lang.String, java.lang.Object> tokens,
		com.liferay.portal.model.User user) {
		return getService().formatNotificaText(textToReplace, tokens, user);
	}

	public static java.lang.Boolean notificaAllreadySent(long notificaId,
		java.lang.String entityName, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .notificaAllreadySent(notificaId, entityName, entityId);
	}

	public static void clearService() {
		_service = null;
	}

	public static NotificaLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					NotificaLocalService.class.getName());

			if (invokableLocalService instanceof NotificaLocalService) {
				_service = (NotificaLocalService)invokableLocalService;
			}
			else {
				_service = new NotificaLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(NotificaLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(NotificaLocalService service) {
	}

	private static NotificaLocalService _service;
}