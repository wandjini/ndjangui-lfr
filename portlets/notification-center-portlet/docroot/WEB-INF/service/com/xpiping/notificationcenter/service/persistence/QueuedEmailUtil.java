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
import com.ndjangui.notificationcenter.service.persistence.QueuedEmailPersistenceImpl;
import com.xpiping.notificationcenter.model.QueuedEmail;

import java.util.List;

/**
 * The persistence utility for the queued email service. This utility wraps {@link QueuedEmailPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcoleo
 * @see QueuedEmailPersistence
 * @see QueuedEmailPersistenceImpl
 * @generated
 */
public class QueuedEmailUtil {
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
	public static void clearCache(QueuedEmail queuedEmail) {
		getPersistence().clearCache(queuedEmail);
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
	public static List<QueuedEmail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QueuedEmail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QueuedEmail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static QueuedEmail update(QueuedEmail queuedEmail)
		throws SystemException {
		return getPersistence().update(queuedEmail);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static QueuedEmail update(QueuedEmail queuedEmail,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(queuedEmail, serviceContext);
	}

	/**
	* Returns all the queued emails where sentOn = &#63;.
	*
	* @param sentOn the sent on
	* @return the matching queued emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findBySentDate(
		java.util.Date sentOn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySentDate(sentOn);
	}

	/**
	* Returns a range of all the queued emails where sentOn = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sentOn the sent on
	* @param start the lower bound of the range of queued emails
	* @param end the upper bound of the range of queued emails (not inclusive)
	* @return the range of matching queued emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findBySentDate(
		java.util.Date sentOn, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySentDate(sentOn, start, end);
	}

	/**
	* Returns an ordered range of all the queued emails where sentOn = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sentOn the sent on
	* @param start the lower bound of the range of queued emails
	* @param end the upper bound of the range of queued emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching queued emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findBySentDate(
		java.util.Date sentOn, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySentDate(sentOn, start, end, orderByComparator);
	}

	/**
	* Returns the first queued email in the ordered set where sentOn = &#63;.
	*
	* @param sentOn the sent on
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching queued email
	* @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail findBySentDate_First(
		java.util.Date sentOn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException {
		return getPersistence().findBySentDate_First(sentOn, orderByComparator);
	}

	/**
	* Returns the first queued email in the ordered set where sentOn = &#63;.
	*
	* @param sentOn the sent on
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching queued email, or <code>null</code> if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail fetchBySentDate_First(
		java.util.Date sentOn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySentDate_First(sentOn, orderByComparator);
	}

	/**
	* Returns the last queued email in the ordered set where sentOn = &#63;.
	*
	* @param sentOn the sent on
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching queued email
	* @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail findBySentDate_Last(
		java.util.Date sentOn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException {
		return getPersistence().findBySentDate_Last(sentOn, orderByComparator);
	}

	/**
	* Returns the last queued email in the ordered set where sentOn = &#63;.
	*
	* @param sentOn the sent on
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching queued email, or <code>null</code> if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail fetchBySentDate_Last(
		java.util.Date sentOn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySentDate_Last(sentOn, orderByComparator);
	}

	/**
	* Returns the queued emails before and after the current queued email in the ordered set where sentOn = &#63;.
	*
	* @param queuedEmailId the primary key of the current queued email
	* @param sentOn the sent on
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next queued email
	* @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a queued email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail[] findBySentDate_PrevAndNext(
		long queuedEmailId, java.util.Date sentOn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException {
		return getPersistence()
				   .findBySentDate_PrevAndNext(queuedEmailId, sentOn,
			orderByComparator);
	}

	/**
	* Removes all the queued emails where sentOn = &#63; from the database.
	*
	* @param sentOn the sent on
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySentDate(java.util.Date sentOn)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySentDate(sentOn);
	}

	/**
	* Returns the number of queued emails where sentOn = &#63;.
	*
	* @param sentOn the sent on
	* @return the number of matching queued emails
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySentDate(java.util.Date sentOn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySentDate(sentOn);
	}

	/**
	* Returns all the queued emails where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching queued emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the queued emails where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of queued emails
	* @param end the upper bound of the range of queued emails (not inclusive)
	* @return the range of matching queued emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the queued emails where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of queued emails
	* @param end the upper bound of the range of queued emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching queued emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first queued email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching queued email
	* @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first queued email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching queued email, or <code>null</code> if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last queued email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching queued email
	* @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last queued email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching queued email, or <code>null</code> if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the queued emails before and after the current queued email in the ordered set where companyId = &#63;.
	*
	* @param queuedEmailId the primary key of the current queued email
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next queued email
	* @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a queued email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail[] findByCompanyId_PrevAndNext(
		long queuedEmailId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(queuedEmailId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the queued emails where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of queued emails where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching queued emails
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Caches the queued email in the entity cache if it is enabled.
	*
	* @param queuedEmail the queued email
	*/
	public static void cacheResult(
		com.xpiping.notificationcenter.model.QueuedEmail queuedEmail) {
		getPersistence().cacheResult(queuedEmail);
	}

	/**
	* Caches the queued emails in the entity cache if it is enabled.
	*
	* @param queuedEmails the queued emails
	*/
	public static void cacheResult(
		java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> queuedEmails) {
		getPersistence().cacheResult(queuedEmails);
	}

	/**
	* Creates a new queued email with the primary key. Does not add the queued email to the database.
	*
	* @param queuedEmailId the primary key for the new queued email
	* @return the new queued email
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail create(
		long queuedEmailId) {
		return getPersistence().create(queuedEmailId);
	}

	/**
	* Removes the queued email with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param queuedEmailId the primary key of the queued email
	* @return the queued email that was removed
	* @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a queued email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail remove(
		long queuedEmailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException {
		return getPersistence().remove(queuedEmailId);
	}

	public static com.xpiping.notificationcenter.model.QueuedEmail updateImpl(
		com.xpiping.notificationcenter.model.QueuedEmail queuedEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(queuedEmail);
	}

	/**
	* Returns the queued email with the primary key or throws a {@link com.xpiping.notificationcenter.NoSuchQueuedEmailException} if it could not be found.
	*
	* @param queuedEmailId the primary key of the queued email
	* @return the queued email
	* @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a queued email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail findByPrimaryKey(
		long queuedEmailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException {
		return getPersistence().findByPrimaryKey(queuedEmailId);
	}

	/**
	* Returns the queued email with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param queuedEmailId the primary key of the queued email
	* @return the queued email, or <code>null</code> if a queued email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.xpiping.notificationcenter.model.QueuedEmail fetchByPrimaryKey(
		long queuedEmailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(queuedEmailId);
	}

	/**
	* Returns all the queued emails.
	*
	* @return the queued emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the queued emails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of queued emails
	* @param end the upper bound of the range of queued emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of queued emails
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the queued emails from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of queued emails.
	*
	* @return the number of queued emails
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static QueuedEmailPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (QueuedEmailPersistence)PortletBeanLocatorUtil.locate(com.xpiping.notificationcenter.service.ClpSerializer.getServletContextName(),
					QueuedEmailPersistence.class.getName());

			ReferenceRegistry.registerReference(QueuedEmailUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(QueuedEmailPersistence persistence) {
	}

	private static QueuedEmailPersistence _persistence;
}