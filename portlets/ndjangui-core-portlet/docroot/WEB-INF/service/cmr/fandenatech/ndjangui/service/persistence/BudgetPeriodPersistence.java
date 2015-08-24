/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package cmr.fandenatech.ndjangui.service.persistence;

import cmr.fandenatech.ndjangui.model.BudgetPeriod;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the budget period service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guyw
 * @see BudgetPeriodPersistenceImpl
 * @see BudgetPeriodUtil
 * @generated
 */
public interface BudgetPeriodPersistence extends BasePersistence<BudgetPeriod> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BudgetPeriodUtil} to access the budget period persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the budget periods where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching budget periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.BudgetPeriod> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the budget periods where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of budget periods
	* @param end the upper bound of the range of budget periods (not inclusive)
	* @return the range of matching budget periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.BudgetPeriod> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the budget periods where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of budget periods
	* @param end the upper bound of the range of budget periods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching budget periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.BudgetPeriod> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first budget period in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching budget period
	* @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a matching budget period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.BudgetPeriod findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first budget period in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching budget period, or <code>null</code> if a matching budget period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.BudgetPeriod fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last budget period in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching budget period
	* @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a matching budget period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.BudgetPeriod findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last budget period in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching budget period, or <code>null</code> if a matching budget period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.BudgetPeriod fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the budget periods before and after the current budget period in the ordered set where groupId = &#63;.
	*
	* @param budgetPeriodId the primary key of the current budget period
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next budget period
	* @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a budget period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.BudgetPeriod[] findByGroupId_PrevAndNext(
		long budgetPeriodId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the budget periods where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of budget periods where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching budget periods
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the budget periods where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching budget periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.BudgetPeriod> findByGroupId_Status(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the budget periods where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of budget periods
	* @param end the upper bound of the range of budget periods (not inclusive)
	* @return the range of matching budget periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.BudgetPeriod> findByGroupId_Status(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the budget periods where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of budget periods
	* @param end the upper bound of the range of budget periods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching budget periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.BudgetPeriod> findByGroupId_Status(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first budget period in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching budget period
	* @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a matching budget period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.BudgetPeriod findByGroupId_Status_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first budget period in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching budget period, or <code>null</code> if a matching budget period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.BudgetPeriod fetchByGroupId_Status_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last budget period in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching budget period
	* @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a matching budget period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.BudgetPeriod findByGroupId_Status_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last budget period in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching budget period, or <code>null</code> if a matching budget period could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.BudgetPeriod fetchByGroupId_Status_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the budget periods before and after the current budget period in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param budgetPeriodId the primary key of the current budget period
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next budget period
	* @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a budget period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.BudgetPeriod[] findByGroupId_Status_PrevAndNext(
		long budgetPeriodId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the budget periods where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of budget periods where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching budget periods
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the budget period in the entity cache if it is enabled.
	*
	* @param budgetPeriod the budget period
	*/
	public void cacheResult(
		cmr.fandenatech.ndjangui.model.BudgetPeriod budgetPeriod);

	/**
	* Caches the budget periods in the entity cache if it is enabled.
	*
	* @param budgetPeriods the budget periods
	*/
	public void cacheResult(
		java.util.List<cmr.fandenatech.ndjangui.model.BudgetPeriod> budgetPeriods);

	/**
	* Creates a new budget period with the primary key. Does not add the budget period to the database.
	*
	* @param budgetPeriodId the primary key for the new budget period
	* @return the new budget period
	*/
	public cmr.fandenatech.ndjangui.model.BudgetPeriod create(
		long budgetPeriodId);

	/**
	* Removes the budget period with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param budgetPeriodId the primary key of the budget period
	* @return the budget period that was removed
	* @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a budget period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.BudgetPeriod remove(
		long budgetPeriodId)
		throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException,
			com.liferay.portal.kernel.exception.SystemException;

	public cmr.fandenatech.ndjangui.model.BudgetPeriod updateImpl(
		cmr.fandenatech.ndjangui.model.BudgetPeriod budgetPeriod)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the budget period with the primary key or throws a {@link cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException} if it could not be found.
	*
	* @param budgetPeriodId the primary key of the budget period
	* @return the budget period
	* @throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException if a budget period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.BudgetPeriod findByPrimaryKey(
		long budgetPeriodId)
		throws cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the budget period with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param budgetPeriodId the primary key of the budget period
	* @return the budget period, or <code>null</code> if a budget period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public cmr.fandenatech.ndjangui.model.BudgetPeriod fetchByPrimaryKey(
		long budgetPeriodId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the budget periods.
	*
	* @return the budget periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.BudgetPeriod> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the budget periods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of budget periods
	* @param end the upper bound of the range of budget periods (not inclusive)
	* @return the range of budget periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.BudgetPeriod> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the budget periods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of budget periods
	* @param end the upper bound of the range of budget periods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of budget periods
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<cmr.fandenatech.ndjangui.model.BudgetPeriod> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the budget periods from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of budget periods.
	*
	* @return the number of budget periods
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}