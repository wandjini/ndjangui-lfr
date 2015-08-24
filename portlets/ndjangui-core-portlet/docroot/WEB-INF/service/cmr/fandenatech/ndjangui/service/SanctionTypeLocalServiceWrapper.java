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
 * Provides a wrapper for {@link SanctionTypeLocalService}.
 *
 * @author guyw
 * @see SanctionTypeLocalService
 * @generated
 */
public class SanctionTypeLocalServiceWrapper implements SanctionTypeLocalService,
	ServiceWrapper<SanctionTypeLocalService> {
	public SanctionTypeLocalServiceWrapper(
		SanctionTypeLocalService sanctionTypeLocalService) {
		_sanctionTypeLocalService = sanctionTypeLocalService;
	}

	/**
	* Adds the sanction type to the database. Also notifies the appropriate model listeners.
	*
	* @param sanctionType the sanction type
	* @return the sanction type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType addSanctionType(
		cmr.fandenatech.ndjangui.model.SanctionType sanctionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.addSanctionType(sanctionType);
	}

	/**
	* Creates a new sanction type with the primary key. Does not add the sanction type to the database.
	*
	* @param sanctionTypeId the primary key for the new sanction type
	* @return the new sanction type
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType createSanctionType(
		long sanctionTypeId) {
		return _sanctionTypeLocalService.createSanctionType(sanctionTypeId);
	}

	/**
	* Deletes the sanction type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sanctionTypeId the primary key of the sanction type
	* @return the sanction type that was removed
	* @throws PortalException if a sanction type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType deleteSanctionType(
		long sanctionTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.deleteSanctionType(sanctionTypeId);
	}

	/**
	* Deletes the sanction type from the database. Also notifies the appropriate model listeners.
	*
	* @param sanctionType the sanction type
	* @return the sanction type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType deleteSanctionType(
		cmr.fandenatech.ndjangui.model.SanctionType sanctionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.deleteSanctionType(sanctionType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sanctionTypeLocalService.dynamicQuery();
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
		return _sanctionTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _sanctionTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _sanctionTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _sanctionTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _sanctionTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType fetchSanctionType(
		long sanctionTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.fetchSanctionType(sanctionTypeId);
	}

	/**
	* Returns the sanction type with the primary key.
	*
	* @param sanctionTypeId the primary key of the sanction type
	* @return the sanction type
	* @throws PortalException if a sanction type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType getSanctionType(
		long sanctionTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.getSanctionType(sanctionTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the sanction types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sanction types
	* @param end the upper bound of the range of sanction types (not inclusive)
	* @return the range of sanction types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.SanctionType> getSanctionTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.getSanctionTypes(start, end);
	}

	/**
	* Returns the number of sanction types.
	*
	* @return the number of sanction types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSanctionTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.getSanctionTypesCount();
	}

	/**
	* Updates the sanction type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sanctionType the sanction type
	* @return the sanction type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType updateSanctionType(
		cmr.fandenatech.ndjangui.model.SanctionType sanctionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.updateSanctionType(sanctionType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _sanctionTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sanctionTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sanctionTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType addSanctionType(
		long groupId, long userId, java.lang.String name,
		java.lang.String shortDescription, double amount,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.addSanctionType(groupId, userId, name,
			shortDescription, amount, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType updateSanctionType(
		long userId, long sanctionTypeId, java.lang.String name,
		java.lang.String shortDescription, double amount)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.updateSanctionType(userId,
			sanctionTypeId, name, shortDescription, amount);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.SanctionType updateSanctionTypeStatus(
		long userId, long sanctionTypeId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.updateSanctionTypeStatus(userId,
			sanctionTypeId, status);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.SanctionType> getSanctionTypesByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.getSanctionTypesByGroupId(groupId,
			start, end);
	}

	@Override
	public int countSanctionTypesByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.countSanctionTypesByGroupId(groupId);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.SanctionType> getSanctionTypesByGroupId_Status(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.getSanctionTypesByGroupId_Status(groupId,
			status, start, end);
	}

	@Override
	public int countSanctionTypesByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionTypeLocalService.countSanctionTypesByGroupId_Status(groupId,
			status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SanctionTypeLocalService getWrappedSanctionTypeLocalService() {
		return _sanctionTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSanctionTypeLocalService(
		SanctionTypeLocalService sanctionTypeLocalService) {
		_sanctionTypeLocalService = sanctionTypeLocalService;
	}

	@Override
	public SanctionTypeLocalService getWrappedService() {
		return _sanctionTypeLocalService;
	}

	@Override
	public void setWrappedService(
		SanctionTypeLocalService sanctionTypeLocalService) {
		_sanctionTypeLocalService = sanctionTypeLocalService;
	}

	private SanctionTypeLocalService _sanctionTypeLocalService;
}