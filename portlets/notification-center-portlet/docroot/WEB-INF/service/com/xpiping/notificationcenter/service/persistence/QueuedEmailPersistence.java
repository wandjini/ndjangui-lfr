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
import com.ndjangui.notificationcenter.service.persistence.QueuedEmailPersistenceImpl;
import com.xpiping.notificationcenter.model.QueuedEmail;

/**
 * The persistence interface for the queued email service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author marcoleo
 * @see QueuedEmailPersistenceImpl
 * @see QueuedEmailUtil
 * @generated
 */
public interface QueuedEmailPersistence extends BasePersistence<QueuedEmail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QueuedEmailUtil} to access the queued email persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the queued emails where sentOn = &#63;.
	*
	* @param sentOn the sent on
	* @return the matching queued emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findBySentDate(
		java.util.Date sentOn)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findBySentDate(
		java.util.Date sentOn, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findBySentDate(
		java.util.Date sentOn, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first queued email in the ordered set where sentOn = &#63;.
	*
	* @param sentOn the sent on
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching queued email
	* @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.QueuedEmail findBySentDate_First(
		java.util.Date sentOn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException;

	/**
	* Returns the first queued email in the ordered set where sentOn = &#63;.
	*
	* @param sentOn the sent on
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching queued email, or <code>null</code> if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.QueuedEmail fetchBySentDate_First(
		java.util.Date sentOn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last queued email in the ordered set where sentOn = &#63;.
	*
	* @param sentOn the sent on
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching queued email
	* @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.QueuedEmail findBySentDate_Last(
		java.util.Date sentOn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException;

	/**
	* Returns the last queued email in the ordered set where sentOn = &#63;.
	*
	* @param sentOn the sent on
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching queued email, or <code>null</code> if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.QueuedEmail fetchBySentDate_Last(
		java.util.Date sentOn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.xpiping.notificationcenter.model.QueuedEmail[] findBySentDate_PrevAndNext(
		long queuedEmailId, java.util.Date sentOn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException;

	/**
	* Removes all the queued emails where sentOn = &#63; from the database.
	*
	* @param sentOn the sent on
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySentDate(java.util.Date sentOn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of queued emails where sentOn = &#63;.
	*
	* @param sentOn the sent on
	* @return the number of matching queued emails
	* @throws SystemException if a system exception occurred
	*/
	public int countBySentDate(java.util.Date sentOn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the queued emails where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching queued emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first queued email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching queued email
	* @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.QueuedEmail findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException;

	/**
	* Returns the first queued email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching queued email, or <code>null</code> if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.QueuedEmail fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last queued email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching queued email
	* @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.QueuedEmail findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException;

	/**
	* Returns the last queued email in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching queued email, or <code>null</code> if a matching queued email could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.QueuedEmail fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.xpiping.notificationcenter.model.QueuedEmail[] findByCompanyId_PrevAndNext(
		long queuedEmailId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException;

	/**
	* Removes all the queued emails where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of queued emails where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching queued emails
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the queued email in the entity cache if it is enabled.
	*
	* @param queuedEmail the queued email
	*/
	public void cacheResult(
		com.xpiping.notificationcenter.model.QueuedEmail queuedEmail);

	/**
	* Caches the queued emails in the entity cache if it is enabled.
	*
	* @param queuedEmails the queued emails
	*/
	public void cacheResult(
		java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> queuedEmails);

	/**
	* Creates a new queued email with the primary key. Does not add the queued email to the database.
	*
	* @param queuedEmailId the primary key for the new queued email
	* @return the new queued email
	*/
	public com.xpiping.notificationcenter.model.QueuedEmail create(
		long queuedEmailId);

	/**
	* Removes the queued email with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param queuedEmailId the primary key of the queued email
	* @return the queued email that was removed
	* @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a queued email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.QueuedEmail remove(
		long queuedEmailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException;

	public com.xpiping.notificationcenter.model.QueuedEmail updateImpl(
		com.xpiping.notificationcenter.model.QueuedEmail queuedEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the queued email with the primary key or throws a {@link com.xpiping.notificationcenter.NoSuchQueuedEmailException} if it could not be found.
	*
	* @param queuedEmailId the primary key of the queued email
	* @return the queued email
	* @throws com.xpiping.notificationcenter.NoSuchQueuedEmailException if a queued email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.QueuedEmail findByPrimaryKey(
		long queuedEmailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.xpiping.notificationcenter.NoSuchQueuedEmailException;

	/**
	* Returns the queued email with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param queuedEmailId the primary key of the queued email
	* @return the queued email, or <code>null</code> if a queued email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.xpiping.notificationcenter.model.QueuedEmail fetchByPrimaryKey(
		long queuedEmailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the queued emails.
	*
	* @return the queued emails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.xpiping.notificationcenter.model.QueuedEmail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the queued emails from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of queued emails.
	*
	* @return the number of queued emails
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}