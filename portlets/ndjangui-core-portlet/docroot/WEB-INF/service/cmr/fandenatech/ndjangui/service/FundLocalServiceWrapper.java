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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FundLocalService}.
 *
 * @author guyw
 * @see FundLocalService
 * @generated
 */
public class FundLocalServiceWrapper implements FundLocalService,
	ServiceWrapper<FundLocalService> {
	public FundLocalServiceWrapper(FundLocalService fundLocalService) {
		_fundLocalService = fundLocalService;
	}

	/**
	* Adds the fund to the database. Also notifies the appropriate model listeners.
	*
	* @param fund the fund
	* @return the fund that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Fund addFund(
		cmr.fandenatech.ndjangui.model.Fund fund)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.addFund(fund);
	}

	/**
	* Creates a new fund with the primary key. Does not add the fund to the database.
	*
	* @param fundId the primary key for the new fund
	* @return the new fund
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Fund createFund(long fundId) {
		return _fundLocalService.createFund(fundId);
	}

	/**
	* Deletes the fund with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fundId the primary key of the fund
	* @return the fund that was removed
	* @throws PortalException if a fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Fund deleteFund(long fundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.deleteFund(fundId);
	}

	/**
	* Deletes the fund from the database. Also notifies the appropriate model listeners.
	*
	* @param fund the fund
	* @return the fund that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Fund deleteFund(
		cmr.fandenatech.ndjangui.model.Fund fund)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.deleteFund(fund);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fundLocalService.dynamicQuery();
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
		return _fundLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fundLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fundLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _fundLocalService.dynamicQueryCount(dynamicQuery);
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
		return _fundLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Fund fetchFund(long fundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.fetchFund(fundId);
	}

	/**
	* Returns the fund with the primary key.
	*
	* @param fundId the primary key of the fund
	* @return the fund
	* @throws PortalException if a fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Fund getFund(long fundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.getFund(fundId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the funds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of funds
	* @param end the upper bound of the range of funds (not inclusive)
	* @return the range of funds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Fund> getFunds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.getFunds(start, end);
	}

	/**
	* Returns the number of funds.
	*
	* @return the number of funds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFundsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.getFundsCount();
	}

	/**
	* Updates the fund in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fund the fund
	* @return the fund that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Fund updateFund(
		cmr.fandenatech.ndjangui.model.Fund fund)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.updateFund(fund);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _fundLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_fundLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _fundLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Fund addFund(long groupId,
		long userId, java.lang.String name, long budgetPeriodId,
		long fundTypeId, java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.addFund(groupId, userId, name, budgetPeriodId,
			fundTypeId, shortDescription, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Fund updateFund(long groupId,
		long userId, long fundId, java.lang.String name, long budgetPeriodId,
		long fundTypeId, java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.updateFund(groupId, userId, fundId, name,
			budgetPeriodId, fundTypeId, shortDescription, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Fund closeFund(long userId,
		long fundId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.closeFund(userId, fundId, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Fund openFund(long userId,
		long fundId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.openFund(userId, fundId, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Fund deleteFund(long userId,
		long fundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.deleteFund(userId, fundId);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Fund> getFundByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.getFundByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.MemberFund> getMembersFund(
		long groupId, long fundId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.getMembersFund(groupId, fundId, start, end);
	}

	@Override
	public int countMembersFund(long groupId, long fundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.countMembersFund(groupId, fundId);
	}

	@Override
	public int countFundsByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.countFundsByGroupId(groupId);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Fund> getFundByGroupId_Status(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.getFundByGroupId_Status(groupId, status);
	}

	@Override
	public int countFundByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundLocalService.countFundByGroupId_Status(groupId, status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FundLocalService getWrappedFundLocalService() {
		return _fundLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFundLocalService(FundLocalService fundLocalService) {
		_fundLocalService = fundLocalService;
	}

	@Override
	public FundLocalService getWrappedService() {
		return _fundLocalService;
	}

	@Override
	public void setWrappedService(FundLocalService fundLocalService) {
		_fundLocalService = fundLocalService;
	}

	private FundLocalService _fundLocalService;
}