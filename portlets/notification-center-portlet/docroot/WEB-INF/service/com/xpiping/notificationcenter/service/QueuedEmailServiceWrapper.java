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

package com.xpiping.notificationcenter.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link QueuedEmailService}.
 *
 * @author marcoleo
 * @see QueuedEmailService
 * @generated
 */
public class QueuedEmailServiceWrapper implements QueuedEmailService,
	ServiceWrapper<QueuedEmailService> {
	public QueuedEmailServiceWrapper(QueuedEmailService queuedEmailService) {
		_queuedEmailService = queuedEmailService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _queuedEmailService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_queuedEmailService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _queuedEmailService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public QueuedEmailService getWrappedQueuedEmailService() {
		return _queuedEmailService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedQueuedEmailService(
		QueuedEmailService queuedEmailService) {
		_queuedEmailService = queuedEmailService;
	}

	@Override
	public QueuedEmailService getWrappedService() {
		return _queuedEmailService;
	}

	@Override
	public void setWrappedService(QueuedEmailService queuedEmailService) {
		_queuedEmailService = queuedEmailService;
	}

	private QueuedEmailService _queuedEmailService;
}