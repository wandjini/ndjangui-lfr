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
 * Provides the local service utility for NotificaType. This utility wraps
 * {@link com.ndjangui.notificationcenter.service.impl.NotificaTypeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author marcoleo
 * @see NotificaTypeLocalService
 * @see com.ndjangui.notificationcenter.service.base.NotificaTypeLocalServiceBaseImpl
 * @see com.ndjangui.notificationcenter.service.impl.NotificaTypeLocalServiceImpl
 * @generated
 */
public class NotificaTypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.xpiping.notificationcenter.service.impl.NotificaTypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the notifica type to the database. Also notifies the appropriate model listeners.
	*
	* @param notificaType the notifica type
	* @return the notifica type that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaType addNotificaType(
		com.xpiping.notificationcenter.model.NotificaType notificaType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addNotificaType(notificaType);
	}

	/**
	* Creates a new notifica type with the primary key. Does not add the notifica type to the database.
	*
	* @param notificaTypeId the primary key for the new notifica type
	* @return the new notifica type
	*/
	public static com.xpiping.notificationcenter.model.NotificaType createNotificaType(
		long notificaTypeId) {
		return getService().createNotificaType(notificaTypeId);
	}

	/**
	* Deletes the notifica type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificaTypeId the primary key of the notifica type
	* @return the notifica type that was removed
	* @throws PortalException if a notifica type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaType deleteNotificaType(
		long notificaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteNotificaType(notificaTypeId);
	}

	/**
	* Deletes the notifica type from the database. Also notifies the appropriate model listeners.
	*
	* @param notificaType the notifica type
	* @return the notifica type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaType deleteNotificaType(
		com.xpiping.notificationcenter.model.NotificaType notificaType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteNotificaType(notificaType);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.NotificaTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.xpiping.notificationcenter.model.NotificaType fetchNotificaType(
		long notificaTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchNotificaType(notificaTypeId);
	}

	/**
	* Returns the notifica type with the primary key.
	*
	* @param notificaTypeId the primary key of the notifica type
	* @return the notifica type
	* @throws PortalException if a notifica type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaType getNotificaType(
		long notificaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getNotificaType(notificaTypeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<com.xpiping.notificationcenter.model.NotificaType> getNotificaTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNotificaTypes(start, end);
	}

	/**
	* Returns the number of notifica types.
	*
	* @return the number of notifica types
	* @throws SystemException if a system exception occurred
	*/
	public static int getNotificaTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNotificaTypesCount();
	}

	/**
	* Updates the notifica type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notificaType the notifica type
	* @return the notifica type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.NotificaType updateNotificaType(
		com.xpiping.notificationcenter.model.NotificaType notificaType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNotificaType(notificaType);
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

	public static com.xpiping.notificationcenter.model.NotificaType addNotificaType(
		java.lang.String name, java.lang.String description,
		java.lang.String messageDestination, java.lang.Boolean aviable,
		java.util.List<java.lang.String> placeHolders,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addNotificaType(name, description, messageDestination,
			aviable, placeHolders, serviceContext);
	}

	public static com.xpiping.notificationcenter.model.NotificaType addNotificaType(
		java.lang.String name, java.lang.String description,
		java.lang.String messageDestination, java.lang.Boolean aviable,
		java.lang.String placeHolders,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addNotificaType(name, description, messageDestination,
			aviable, placeHolders, serviceContext);
	}

	public static com.xpiping.notificationcenter.model.NotificaType updateNotificaType(
		long notificaTypeId, java.lang.String description,
		java.lang.String messageDestination, java.lang.Boolean aviable,
		java.util.List<java.lang.String> placeHolders,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateNotificaType(notificaTypeId, description,
			messageDestination, aviable, placeHolders, serviceContext);
	}

	public static com.xpiping.notificationcenter.model.NotificaType updateNotificaType(
		long notificaTypeId, java.lang.String description,
		java.lang.String messageDestination, java.lang.Boolean aviable,
		java.lang.String placeHolders,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateNotificaType(notificaTypeId, description,
			messageDestination, aviable, placeHolders, serviceContext);
	}

	public static java.util.List<com.xpiping.notificationcenter.model.NotificaType> getNotificheType(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNotificheType(companyId, start, end);
	}

	public static int countNotificheType(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countNotificheType(companyId);
	}

	public static java.lang.Boolean isNotificaTypeAviable(long notificaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().isNotificaTypeAviable(notificaTypeId);
	}

	public static com.xpiping.notificationcenter.model.NotificaType getNotificaTypeByName(
		java.lang.String notificaTypeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNotificaTypeByName(notificaTypeName);
	}

	public static void clearService() {
		_service = null;
	}

	public static NotificaTypeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					NotificaTypeLocalService.class.getName());

			if (invokableLocalService instanceof NotificaTypeLocalService) {
				_service = (NotificaTypeLocalService)invokableLocalService;
			}
			else {
				_service = new NotificaTypeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(NotificaTypeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(NotificaTypeLocalService service) {
	}

	private static NotificaTypeLocalService _service;
}