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
 * Provides the local service utility for QueuedEmail. This utility wraps
 * {@link com.ndjangui.notificationcenter.service.impl.QueuedEmailLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author marcoleo
 * @see QueuedEmailLocalService
 * @see com.ndjangui.notificationcenter.service.base.QueuedEmailLocalServiceBaseImpl
 * @see com.ndjangui.notificationcenter.service.impl.QueuedEmailLocalServiceImpl
 * @generated
 */
public class QueuedEmailLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.xpiping.notificationcenter.service.impl.QueuedEmailLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the queued email to the database. Also notifies the appropriate model listeners.
	*
	* @param queuedEmail the queued email
	* @return the queued email that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail addQueuedEmail(
		com.xpiping.notificationcenter.model.QueuedEmail queuedEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addQueuedEmail(queuedEmail);
	}

	/**
	* Creates a new queued email with the primary key. Does not add the queued email to the database.
	*
	* @param queuedEmailId the primary key for the new queued email
	* @return the new queued email
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail createQueuedEmail(
		long queuedEmailId) {
		return getService().createQueuedEmail(queuedEmailId);
	}

	/**
	* Deletes the queued email with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param queuedEmailId the primary key of the queued email
	* @return the queued email that was removed
	* @throws PortalException if a queued email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail deleteQueuedEmail(
		long queuedEmailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteQueuedEmail(queuedEmailId);
	}

	/**
	* Deletes the queued email from the database. Also notifies the appropriate model listeners.
	*
	* @param queuedEmail the queued email
	* @return the queued email that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail deleteQueuedEmail(
		com.xpiping.notificationcenter.model.QueuedEmail queuedEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteQueuedEmail(queuedEmail);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.xpiping.notificationcenter.model.QueuedEmail fetchQueuedEmail(
		long queuedEmailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchQueuedEmail(queuedEmailId);
	}

	/**
	* Returns the queued email with the primary key.
	*
	* @param queuedEmailId the primary key of the queued email
	* @return the queued email
	* @throws PortalException if a queued email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail getQueuedEmail(
		long queuedEmailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getQueuedEmail(queuedEmailId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the queued emails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of queued emails
	* @param end the upper bound of the range of queued emails (not inclusive)
	* @return the range of queued emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> getQueuedEmails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getQueuedEmails(start, end);
	}

	/**
	* Returns the number of queued emails.
	*
	* @return the number of queued emails
	* @throws SystemException if a system exception occurred
	*/
	public static int getQueuedEmailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getQueuedEmailsCount();
	}

	/**
	* Updates the queued email in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param queuedEmail the queued email
	* @return the queued email that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail updateQueuedEmail(
		com.xpiping.notificationcenter.model.QueuedEmail queuedEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateQueuedEmail(queuedEmail);
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

	public static java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> getQueuedEmailToSend()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getQueuedEmailToSend();
	}

	public static com.xpiping.notificationcenter.model.QueuedEmail addQueuedEmail(
		com.liferay.portal.model.User user, java.lang.String bcc,
		java.lang.String body, java.lang.String subject)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addQueuedEmail(user, bcc, body, subject);
	}

	public static com.xpiping.notificationcenter.model.QueuedEmail addQueuedEmail(
		long companyId, java.lang.String to, java.lang.String toName,
		java.lang.String from, java.lang.String fromName, java.lang.String bcc,
		java.lang.String cc, java.lang.String body, java.lang.String subject)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addQueuedEmail(companyId, to, toName, from, fromName, bcc,
			cc, body, subject);
	}

	public static com.xpiping.notificationcenter.model.QueuedEmail setQueuedEmailAsSent(
		long queuedEmailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException {
		return getService().setQueuedEmailAsSent(queuedEmailId);
	}

	public static com.xpiping.notificationcenter.model.QueuedEmail incrementSentTries(
		long queuedEmailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException {
		return getService().incrementSentTries(queuedEmailId);
	}

	public static boolean sendEmail(long queuedEmailId, boolean checkSentTries)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException {
		return getService().sendEmail(queuedEmailId, checkSentTries);
	}

	public static boolean sendEmail(
		com.xpiping.notificationcenter.model.QueuedEmail queuedEmail,
		boolean checkSentTries)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException {
		return getService().sendEmail(queuedEmail, checkSentTries);
	}

	public static java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> getQueuedEmail(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getQueuedEmail(companyId, start, end);
	}

	public static int countQueuedEmail(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countQueuedEmail(companyId);
	}

	public static void clearService() {
		_service = null;
	}

	public static QueuedEmailLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					QueuedEmailLocalService.class.getName());

			if (invokableLocalService instanceof QueuedEmailLocalService) {
				_service = (QueuedEmailLocalService)invokableLocalService;
			}
			else {
				_service = new QueuedEmailLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(QueuedEmailLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(QueuedEmailLocalService service) {
	}

	private static QueuedEmailLocalService _service;
}