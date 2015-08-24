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
 * Provides a wrapper for {@link OperationTypeService}.
 *
 * @author guyw
 * @see OperationTypeService
 * @generated
 */
public class OperationTypeServiceWrapper implements OperationTypeService,
	ServiceWrapper<OperationTypeService> {
	public OperationTypeServiceWrapper(
		OperationTypeService operationTypeService) {
		_operationTypeService = operationTypeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _operationTypeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_operationTypeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _operationTypeService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.OperationType addOperationType(
		long groupId, long userId, java.lang.String name,
		java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeService.addOperationType(groupId, userId, name,
			shortDescription, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.OperationType updateOperationType(
		long groupId, long userId, long operationTypeId, java.lang.String name,
		java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeService.updateOperationType(groupId, userId,
			operationTypeId, name, shortDescription, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.OperationType updateOperationTypeStatus(
		long userId, long operationTypeId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeService.updateOperationTypeStatus(userId,
			operationTypeId, status);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.OperationType deleOperationType(
		long operationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _operationTypeService.deleOperationType(operationTypeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OperationTypeService getWrappedOperationTypeService() {
		return _operationTypeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOperationTypeService(
		OperationTypeService operationTypeService) {
		_operationTypeService = operationTypeService;
	}

	@Override
	public OperationTypeService getWrappedService() {
		return _operationTypeService;
	}

	@Override
	public void setWrappedService(OperationTypeService operationTypeService) {
		_operationTypeService = operationTypeService;
	}

	private OperationTypeService _operationTypeService;
}