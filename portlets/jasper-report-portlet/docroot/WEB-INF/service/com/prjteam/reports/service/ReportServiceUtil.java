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

package com.prjteam.reports.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Report. This utility wraps
 * {@link com.fandenatech.reports.service.impl.ReportServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author marcoleo
 * @see ReportService
 * @see com.fandenatech.reports.service.base.ReportServiceBaseImpl
 * @see com.fandenatech.reports.service.impl.ReportServiceImpl
 * @generated
 */
public class ReportServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.prjteam.reports.service.impl.ReportServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

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

	public static net.sf.jasperreports.engine.JasperPrint getJasperPrint(
		long fileEntryId, java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJasperPrint(fileEntryId, beanCollection, parameters);
	}

	public static net.sf.jasperreports.engine.JasperPrint getJasperPrint(
		long fileEntryId, java.lang.String sql,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJasperPrint(fileEntryId, sql, parameters);
	}

	public static java.io.OutputStream exportPdf(
		net.sf.jasperreports.engine.JasperPrint jasperPrint)
		throws net.sf.jasperreports.engine.JRException {
		return getService().exportPdf(jasperPrint);
	}

	public static java.io.OutputStream exportCsv(
		net.sf.jasperreports.engine.JasperPrint jasperPrint)
		throws net.sf.jasperreports.engine.JRException {
		return getService().exportCsv(jasperPrint);
	}

	public static java.io.OutputStream exportExcel(
		net.sf.jasperreports.engine.JasperPrint jasperPrint)
		throws net.sf.jasperreports.engine.JRException {
		return getService().exportExcel(jasperPrint);
	}

	public static java.io.OutputStream exportPdf(long fileEntryId,
		java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().exportPdf(fileEntryId, beanCollection, parameters);
	}

	public static java.io.OutputStream exportCsv(long fileEntryId,
		java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().exportCsv(fileEntryId, beanCollection, parameters);
	}

	public static java.io.OutputStream exportExcel(long fileEntryId,
		java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().exportExcel(fileEntryId, beanCollection, parameters);
	}

	public static java.io.OutputStream exportPdf(long fileEntryId,
		java.lang.String sql,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().exportPdf(fileEntryId, sql, parameters);
	}

	public static java.io.OutputStream exportExcel(long fileEntryId,
		java.lang.String sql,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().exportExcel(fileEntryId, sql, parameters);
	}

	public static void clearService() {
		_service = null;
	}

	public static ReportService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ReportService.class.getName());

			if (invokableService instanceof ReportService) {
				_service = (ReportService)invokableService;
			}
			else {
				_service = new ReportServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ReportServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ReportService service) {
	}

	private static ReportService _service;
}