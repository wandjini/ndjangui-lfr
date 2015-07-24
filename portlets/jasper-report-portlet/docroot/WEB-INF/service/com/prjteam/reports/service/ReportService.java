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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for Report. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author marcoleo
 * @see ReportServiceUtil
 * @see com.fandenatech.reports.service.base.ReportServiceBaseImpl
 * @see com.fandenatech.reports.service.impl.ReportServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ReportService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReportServiceUtil} to access the report remote service. Add custom service methods to {@link com.prjteam.reports.service.impl.ReportServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public net.sf.jasperreports.engine.JasperPrint getJasperPrint(
		long fileEntryId, java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public net.sf.jasperreports.engine.JasperPrint getJasperPrint(
		long fileEntryId, java.lang.String sql,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.io.OutputStream exportPdf(
		net.sf.jasperreports.engine.JasperPrint jasperPrint)
		throws net.sf.jasperreports.engine.JRException;

	public java.io.OutputStream exportCsv(
		net.sf.jasperreports.engine.JasperPrint jasperPrint)
		throws net.sf.jasperreports.engine.JRException;

	public java.io.OutputStream exportExcel(
		net.sf.jasperreports.engine.JasperPrint jasperPrint)
		throws net.sf.jasperreports.engine.JRException;

	public java.io.OutputStream exportPdf(long fileEntryId,
		java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.io.OutputStream exportCsv(long fileEntryId,
		java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.io.OutputStream exportExcel(long fileEntryId,
		java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.io.OutputStream exportPdf(long fileEntryId,
		java.lang.String sql,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.io.OutputStream exportExcel(long fileEntryId,
		java.lang.String sql,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}