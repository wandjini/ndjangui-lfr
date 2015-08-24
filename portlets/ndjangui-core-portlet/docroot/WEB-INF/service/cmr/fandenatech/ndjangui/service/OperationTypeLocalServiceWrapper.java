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
 * Provides a wrapper for {@link OperationTypeLocalService}.
 *
 * @author guyw
 * @see OperationTypeLocalService
 * @generated
 */
public class OperationTypeLocalServiceWrapper
	implements OperationTypeLocalService,
		ServiceWrapper<OperationTypeLocalService> {
	public OperationTypeLocalServiceWrapper(
		OperationTypeLocalService operationTypeLocalService) {
		_operationTypeLocalService = operationTypeLocalService;
	}

	/**
	* Adds the operation type to the database. Also notifies the appropriate model listeners.
	*
	* @param operationType the operation type
	* @return the operation type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.OperationType addOperationType(
		cmr.fandenatech.ndjangui.model.OperationType operationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.addOperationType(operationType);
	}

	/**
	* Creates a new operation type with the primary key. Does not add the operation type to the database.
	*
	* @param operationTypeId the primary key for the new operation type
	* @return the new operation type
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.OperationType createOperationType(
		long operationTypeId) {
		return _operationTypeLocalService.createOperationType(operationTypeId);
	}

	/**
	* Deletes the operation type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param operationTypeId the primary key of the operation type
	* @return the operation type that was removed
	* @throws PortalException if a operation type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.OperationType deleteOperationType(
		long operationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.deleteOperationType(operationTypeId);
	}

	/**
	* Deletes the operation type from the database. Also notifies the appropriate model listeners.
	*
	* @param operationType the operation type
	* @return the operation type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.OperationType deleteOperationType(
		cmr.fandenatech.ndjangui.model.OperationType operationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.deleteOperationType(operationType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _operationTypeLocalService.dynamicQuery();
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
		return _operationTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _operationTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _operationTypeLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _operationTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _operationTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.OperationType fetchOperationType(
		long operationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.fetchOperationType(operationTypeId);
	}

	/**
	* Returns the operation type with the primary key.
	*
	* @param operationTypeId the primary key of the operation type
	* @return the operation type
	* @throws PortalException if a operation type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.OperationType getOperationType(
		long operationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.getOperationType(operationTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the operation types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of operation types
	* @param end the upper bound of the range of operation types (not inclusive)
	* @return the range of operation types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.OperationType> getOperationTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.getOperationTypes(start, end);
	}

	/**
	* Returns the number of operation types.
	*
	* @return the number of operation types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOperationTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.getOperationTypesCount();
	}

	/**
	* Updates the operation type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param operationType the operation type
	* @return the operation type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.OperationType updateOperationType(
		cmr.fandenatech.ndjangui.model.OperationType operationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.updateOperationType(operationType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _operationTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_operationTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _operationTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.OperationType addOperationType(
		long groupId, long userId, java.lang.String name,
		java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.addOperationType(groupId, userId,
			name, shortDescription, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.OperationType updateOperationType(
		long userId, long operationTypeId, java.lang.String name,
		java.lang.String shortDescription)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.updateOperationType(userId,
			operationTypeId, name, shortDescription);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.OperationType updateOperationTypeStatus(
		long userId, long operationTypeId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.updateOperationTypeStatus(userId,
			operationTypeId, status);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.OperationType> getOperationTypesByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.getOperationTypesByGroupId(groupId,
			start, end);
	}

	@Override
	public int countOperationTypesByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.countOperationTypesByGroupId(groupId);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.OperationType> getOperationTypesByGroupId_Status(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.getOperationTypesByGroupId_Status(groupId,
			status, start, end);
	}

	@Override
	public int countOperationTypesByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeLocalService.countOperationTypesByGroupId_Status(groupId,
			status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OperationTypeLocalService getWrappedOperationTypeLocalService() {
		return _operationTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOperationTypeLocalService(
		OperationTypeLocalService operationTypeLocalService) {
		_operationTypeLocalService = operationTypeLocalService;
	}

	@Override
	public OperationTypeLocalService getWrappedService() {
		return _operationTypeLocalService;
	}

	@Override
	public void setWrappedService(
		OperationTypeLocalService operationTypeLocalService) {
		_operationTypeLocalService = operationTypeLocalService;
	}

	private OperationTypeLocalService _operationTypeLocalService;
}