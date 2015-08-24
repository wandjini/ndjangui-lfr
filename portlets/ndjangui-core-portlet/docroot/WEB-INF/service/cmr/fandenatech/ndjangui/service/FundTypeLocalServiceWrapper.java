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
 * Provides a wrapper for {@link FundTypeLocalService}.
 *
 * @author guyw
 * @see FundTypeLocalService
 * @generated
 */
public class FundTypeLocalServiceWrapper implements FundTypeLocalService,
	ServiceWrapper<FundTypeLocalService> {
	public FundTypeLocalServiceWrapper(
		FundTypeLocalService fundTypeLocalService) {
		_fundTypeLocalService = fundTypeLocalService;
	}

	/**
	* Adds the fund type to the database. Also notifies the appropriate model listeners.
	*
	* @param fundType the fund type
	* @return the fund type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.FundType addFundType(
		cmr.fandenatech.ndjangui.model.FundType fundType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.addFundType(fundType);
	}

	/**
	* Creates a new fund type with the primary key. Does not add the fund type to the database.
	*
	* @param fundTypeId the primary key for the new fund type
	* @return the new fund type
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.FundType createFundType(
		long fundTypeId) {
		return _fundTypeLocalService.createFundType(fundTypeId);
	}

	/**
	* Deletes the fund type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fundTypeId the primary key of the fund type
	* @return the fund type that was removed
	* @throws PortalException if a fund type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.FundType deleteFundType(
		long fundTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.deleteFundType(fundTypeId);
	}

	/**
	* Deletes the fund type from the database. Also notifies the appropriate model listeners.
	*
	* @param fundType the fund type
	* @return the fund type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.FundType deleteFundType(
		cmr.fandenatech.ndjangui.model.FundType fundType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.deleteFundType(fundType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fundTypeLocalService.dynamicQuery();
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
		return _fundTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fundTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fundTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _fundTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _fundTypeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.FundType fetchFundType(
		long fundTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.fetchFundType(fundTypeId);
	}

	/**
	* Returns the fund type with the primary key.
	*
	* @param fundTypeId the primary key of the fund type
	* @return the fund type
	* @throws PortalException if a fund type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.FundType getFundType(long fundTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.getFundType(fundTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fund types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.FundTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund types
	* @param end the upper bound of the range of fund types (not inclusive)
	* @return the range of fund types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.FundType> getFundTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.getFundTypes(start, end);
	}

	/**
	* Returns the number of fund types.
	*
	* @return the number of fund types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFundTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.getFundTypesCount();
	}

	/**
	* Updates the fund type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fundType the fund type
	* @return the fund type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.FundType updateFundType(
		cmr.fandenatech.ndjangui.model.FundType fundType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.updateFundType(fundType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _fundTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_fundTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _fundTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.FundType addFundType(long groupId,
		long userId, java.lang.String name, java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.addFundType(groupId, userId, name,
			shortDescription, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.FundType updateFundType(long userId,
		long fundTypeId, java.lang.String name,
		java.lang.String shortDescription)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.updateFundType(userId, fundTypeId, name,
			shortDescription);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.FundType updateFundTypeStatus(
		long userId, long fundTypeId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.updateFundTypeStatus(userId, fundTypeId,
			status);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.FundType> getFundTypesByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.getFundTypesByGroupId(groupId, start, end);
	}

	@Override
	public int countFundTypesByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.countFundTypesByGroupId(groupId);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.FundType> getFundTypesByGroupId_Status(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.getFundTypesByGroupId_Status(groupId,
			status, start, end);
	}

	@Override
	public int countFundTypesByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundTypeLocalService.countFundTypesByGroupId_Status(groupId,
			status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FundTypeLocalService getWrappedFundTypeLocalService() {
		return _fundTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFundTypeLocalService(
		FundTypeLocalService fundTypeLocalService) {
		_fundTypeLocalService = fundTypeLocalService;
	}

	@Override
	public FundTypeLocalService getWrappedService() {
		return _fundTypeLocalService;
	}

	@Override
	public void setWrappedService(FundTypeLocalService fundTypeLocalService) {
		_fundTypeLocalService = fundTypeLocalService;
	}

	private FundTypeLocalService _fundTypeLocalService;
}