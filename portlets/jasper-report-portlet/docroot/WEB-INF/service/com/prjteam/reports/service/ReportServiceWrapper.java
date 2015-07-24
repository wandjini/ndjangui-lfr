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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReportService}.
 *
 * @author marcoleo
 * @see ReportService
 * @generated
 */
public class ReportServiceWrapper implements ReportService,
	ServiceWrapper<ReportService> {
	public ReportServiceWrapper(ReportService reportService) {
		_reportService = reportService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _reportService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_reportService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _reportService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public net.sf.jasperreports.engine.JasperPrint getJasperPrint(
		long fileEntryId, java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportService.getJasperPrint(fileEntryId, beanCollection,
			parameters);
	}

	@Override
	public net.sf.jasperreports.engine.JasperPrint getJasperPrint(
		long fileEntryId, java.lang.String sql,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportService.getJasperPrint(fileEntryId, sql, parameters);
	}

	@Override
	public java.io.OutputStream exportPdf(
		net.sf.jasperreports.engine.JasperPrint jasperPrint)
		throws net.sf.jasperreports.engine.JRException {
		return _reportService.exportPdf(jasperPrint);
	}

	@Override
	public java.io.OutputStream exportCsv(
		net.sf.jasperreports.engine.JasperPrint jasperPrint)
		throws net.sf.jasperreports.engine.JRException {
		return _reportService.exportCsv(jasperPrint);
	}

	@Override
	public java.io.OutputStream exportExcel(
		net.sf.jasperreports.engine.JasperPrint jasperPrint)
		throws net.sf.jasperreports.engine.JRException {
		return _reportService.exportExcel(jasperPrint);
	}

	@Override
	public java.io.OutputStream exportPdf(long fileEntryId,
		java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportService.exportPdf(fileEntryId, beanCollection, parameters);
	}

	@Override
	public java.io.OutputStream exportCsv(long fileEntryId,
		java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportService.exportCsv(fileEntryId, beanCollection, parameters);
	}

	@Override
	public java.io.OutputStream exportExcel(long fileEntryId,
		java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportService.exportExcel(fileEntryId, beanCollection,
			parameters);
	}

	@Override
	public java.io.OutputStream exportPdf(long fileEntryId,
		java.lang.String sql,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportService.exportPdf(fileEntryId, sql, parameters);
	}

	@Override
	public java.io.OutputStream exportExcel(long fileEntryId,
		java.lang.String sql,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportService.exportExcel(fileEntryId, sql, parameters);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ReportService getWrappedReportService() {
		return _reportService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedReportService(ReportService reportService) {
		_reportService = reportService;
	}

	@Override
	public ReportService getWrappedService() {
		return _reportService;
	}

	@Override
	public void setWrappedService(ReportService reportService) {
		_reportService = reportService;
	}

	private ReportService _reportService;
}