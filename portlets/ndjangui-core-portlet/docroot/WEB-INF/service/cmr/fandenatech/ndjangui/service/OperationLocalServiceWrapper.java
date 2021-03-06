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
 * Provides a wrapper for {@link OperationLocalService}.
 *
 * @author guyw
 * @see OperationLocalService
 * @generated
 */
public class OperationLocalServiceWrapper implements OperationLocalService,
	ServiceWrapper<OperationLocalService> {
	public OperationLocalServiceWrapper(
		OperationLocalService operationLocalService) {
		_operationLocalService = operationLocalService;
	}

	/**
	* Adds the operation to the database. Also notifies the appropriate model listeners.
	*
	* @param operation the operation
	* @return the operation that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Operation addOperation(
		cmr.fandenatech.ndjangui.model.Operation operation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.addOperation(operation);
	}

	/**
	* Creates a new operation with the primary key. Does not add the operation to the database.
	*
	* @param operationId the primary key for the new operation
	* @return the new operation
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Operation createOperation(
		long operationId) {
		return _operationLocalService.createOperation(operationId);
	}

	/**
	* Deletes the operation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param operationId the primary key of the operation
	* @return the operation that was removed
	* @throws PortalException if a operation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Operation deleteOperation(
		long operationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.deleteOperation(operationId);
	}

	/**
	* Deletes the operation from the database. Also notifies the appropriate model listeners.
	*
	* @param operation the operation
	* @return the operation that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Operation deleteOperation(
		cmr.fandenatech.ndjangui.model.Operation operation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.deleteOperation(operation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _operationLocalService.dynamicQuery();
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
		return _operationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _operationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _operationLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _operationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _operationLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Operation fetchOperation(
		long operationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.fetchOperation(operationId);
	}

	/**
	* Returns the operation with the primary key.
	*
	* @param operationId the primary key of the operation
	* @return the operation
	* @throws PortalException if a operation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Operation getOperation(
		long operationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.getOperation(operationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the operations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.OperationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of operations
	* @param end the upper bound of the range of operations (not inclusive)
	* @return the range of operations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Operation> getOperations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.getOperations(start, end);
	}

	/**
	* Returns the number of operations.
	*
	* @return the number of operations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOperationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.getOperationsCount();
	}

	/**
	* Updates the operation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param operation the operation
	* @return the operation that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Operation updateOperation(
		cmr.fandenatech.ndjangui.model.Operation operation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.updateOperation(operation);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _operationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_operationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _operationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Operation addOperation(long groupId,
		long userId, java.lang.String name, long budgetPeriodId,
		long operationTypeId, long sittingId,
		java.lang.String shortDescription, long srcFundClassPK,
		long destFundClassPK, java.lang.String srcFundClassName,
		java.lang.String destFundClassName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.addOperation(groupId, userId, name,
			budgetPeriodId, operationTypeId, sittingId, shortDescription,
			srcFundClassPK, destFundClassPK, srcFundClassName,
			destFundClassName, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Operation updateOperation(
		long groupId, long userId, long operationId, java.lang.String name,
		long budgetPeriodId, long operationTypeId, long sittingId,
		java.lang.String shortDescription, long srcFundClassPK,
		long destFundClassPK, java.lang.String srcFundClassName,
		java.lang.String destFundClassName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.updateOperation(groupId, userId,
			operationId, name, budgetPeriodId, operationTypeId, sittingId,
			shortDescription, srcFundClassPK, destFundClassPK,
			srcFundClassName, destFundClassName, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Operation confirmOperation(
		long userId, long operationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.confirmOperation(userId, operationId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Operation openOperation(long userId,
		long operationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.openOperation(userId, operationId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Operation deleteOperation(
		long userId, long operationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.deleteOperation(userId, operationId);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Operation> getOperationByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.getOperationByGroupId(groupId, start, end);
	}

	@Override
	public int countOperationsByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.countOperationsByGroupId(groupId);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Operation> getOperationsByGroupId_Status(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.getOperationsByGroupId_Status(groupId,
			status, start, end);
	}

	@Override
	public int countOperationsByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationLocalService.countOperationsByGroupId_Status(groupId,
			status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OperationLocalService getWrappedOperationLocalService() {
		return _operationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOperationLocalService(
		OperationLocalService operationLocalService) {
		_operationLocalService = operationLocalService;
	}

	@Override
	public OperationLocalService getWrappedService() {
		return _operationLocalService;
	}

	@Override
	public void setWrappedService(OperationLocalService operationLocalService) {
		_operationLocalService = operationLocalService;
	}

	private OperationLocalService _operationLocalService;
}