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

package cmr.fandenatech.ndjangui.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for BudgetPeriod. This utility wraps
 * {@link cmr.fandenatech.ndjangui.service.impl.BudgetPeriodLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author guyw
 * @see BudgetPeriodLocalService
 * @see cmr.fandenatech.ndjangui.service.base.BudgetPeriodLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.impl.BudgetPeriodLocalServiceImpl
 * @generated
 */
public class BudgetPeriodLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link cmr.fandenatech.ndjangui.service.impl.BudgetPeriodLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the budget period to the database. Also notifies the appropriate model listeners.
	*
	* @param budgetPeriod the budget period
	* @return the budget period that was added
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.BudgetPeriod addBudgetPeriod(
		cmr.fandenatech.ndjangui.model.BudgetPeriod budgetPeriod)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBudgetPeriod(budgetPeriod);
	}

	/**
	* Creates a new budget period with the primary key. Does not add the budget period to the database.
	*
	* @param budgetPeriodId the primary key for the new budget period
	* @return the new budget period
	*/
	public static cmr.fandenatech.ndjangui.model.BudgetPeriod createBudgetPeriod(
		long budgetPeriodId) {
		return getService().createBudgetPeriod(budgetPeriodId);
	}

	/**
	* Deletes the budget period with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param budgetPeriodId the primary key of the budget period
	* @return the budget period that was removed
	* @throws PortalException if a budget period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.BudgetPeriod deleteBudgetPeriod(
		long budgetPeriodId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBudgetPeriod(budgetPeriodId);
	}

	/**
	* Deletes the budget period from the database. Also notifies the appropriate model listeners.
	*
	* @param budgetPeriod the budget period
	* @return the budget period that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.BudgetPeriod deleteBudgetPeriod(
		cmr.fandenatech.ndjangui.model.BudgetPeriod budgetPeriod)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBudgetPeriod(budgetPeriod);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.BudgetPeriodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static cmr.fandenatech.ndjangui.model.BudgetPeriod fetchBudgetPeriod(
		long budgetPeriodId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBudgetPeriod(budgetPeriodId);
	}

	/**
	* Returns the budget period with the primary key.
	*
	* @param budgetPeriodId the primary key of the budget period
	* @return the budget period
	* @throws PortalException if a budget period with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.BudgetPeriod getBudgetPeriod(
		long budgetPeriodId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBudgetPeriod(budgetPeriodId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<cmr.fandenatech.ndjangui.model.BudgetPeriod> getBudgetPeriods(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBudgetPeriods(start, end);
	}

	/**
	* Returns the number of budget periods.
	*
	* @return the number of budget periods
	* @throws SystemException if a system exception occurred
	*/
	public static int getBudgetPeriodsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBudgetPeriodsCount();
	}

	/**
	* Updates the budget period in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param budgetPeriod the budget period
	* @return the budget period that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.BudgetPeriod updateBudgetPeriod(
		cmr.fandenatech.ndjangui.model.BudgetPeriod budgetPeriod)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBudgetPeriod(budgetPeriod);
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

	public static cmr.fandenatech.ndjangui.model.BudgetPeriod addBudgetPeriod(
		long groupId, long userId, java.lang.String name,
		java.lang.String shortDescription, java.util.Date startDate,
		java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addBudgetPeriod(groupId, userId, name, shortDescription,
			startDate, endDate, serviceContext);
	}

	public static cmr.fandenatech.ndjangui.model.BudgetPeriod updateBudgetPeriod(
		long userId, long budgetPeriodId, java.lang.String name,
		java.lang.String shortDescription, java.util.Date startDate,
		java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBudgetPeriod(userId, budgetPeriodId, name,
			shortDescription, startDate, endDate);
	}

	public static cmr.fandenatech.ndjangui.model.BudgetPeriod updateBudgetPeriodStatus(
		long userId, long budgetPeriodId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBudgetPeriodStatus(userId, budgetPeriodId, status);
	}

	public static cmr.fandenatech.ndjangui.model.BudgetPeriod closeBudgetPeriod(
		long userId, long budgetPeriodId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().closeBudgetPeriod(userId, budgetPeriodId);
	}

	public static java.util.List<cmr.fandenatech.ndjangui.model.BudgetPeriod> getBudgetPeriodsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBudgetPeriodsByGroupId(groupId, start, end);
	}

	public static int countBudgetPeriodsByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countBudgetPeriodsByGroupId(groupId);
	}

	public static java.util.List<cmr.fandenatech.ndjangui.model.BudgetPeriod> getBudgetPeriodsByGroupId_Status(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBudgetPeriodsByGroupId_Status(groupId, status);
	}

	public static int countBudgetPeriodsByGroupId_Status(long groupId,
		int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countBudgetPeriodsByGroupId_Status(groupId, status);
	}

	public static void clearService() {
		_service = null;
	}

	public static BudgetPeriodLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BudgetPeriodLocalService.class.getName());

			if (invokableLocalService instanceof BudgetPeriodLocalService) {
				_service = (BudgetPeriodLocalService)invokableLocalService;
			}
			else {
				_service = new BudgetPeriodLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BudgetPeriodLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BudgetPeriodLocalService service) {
	}

	private static BudgetPeriodLocalService _service;
}