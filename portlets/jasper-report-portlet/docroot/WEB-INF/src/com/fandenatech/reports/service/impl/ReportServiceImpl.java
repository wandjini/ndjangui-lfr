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

package com.fandenatech.reports.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import com.fandenatech.reports.service.base.ReportServiceBaseImpl;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

/**
 * The implementation of the report remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.prjteam.reports.service.ReportService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author marcoleo
 * @see com.fandenatech.reports.service.base.ReportServiceBaseImpl
 * @see com.prjteam.reports.service.ReportServiceUtil
 */
public class ReportServiceImpl extends ReportServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.prjteam.reports.service.ReportServiceUtil} to access the report remote service.
	 */
	
	public Log _log = LogFactoryUtil.getLog(ReportServiceImpl.class);
	
	public JasperPrint getJasperPrint(
		long fileEntryId, Collection<?> beanCollection,
		Map<String, Object> parameters)
		throws SystemException {
		
		JasperDesign jasperDesign;
		JasperReport jasperReport;
		JasperPrint jasperPrint = null;

		try {

			DLFileEntry report =
				DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
			InputStream inputStream = report.getContentStream();

			jasperDesign = JRXmlLoader.load(inputStream);

			jasperReport = JasperCompileManager.compileReport(jasperDesign);
			JRBeanCollectionDataSource ds =
				new JRBeanCollectionDataSource(beanCollection);
			
			jasperPrint =
				JasperFillManager.fillReport(jasperReport, parameters, ds);
			
		}
		
		catch (Exception e) {
			_log.error("Error during report generation");
			_log.error(e);
		}
		return 	jasperPrint;
	}
	
	public JasperPrint getJasperPrint(
		long fileEntryId, String sql,
		Map<String, Object> parameters)
		throws SystemException {
		
		JasperDesign jasperDesign;
		JasperReport jasperReport;
		JasperPrint jasperPrint = null;

		try {

			DLFileEntry report =
				DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
			InputStream inputStream = report.getContentStream();

			jasperDesign = JRXmlLoader.load(inputStream);

			jasperReport = JasperCompileManager.compileReport(jasperDesign);
			
			
			Connection connection = DataAccess.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			JRResultSetDataSource resultSetDataSource  = new JRResultSetDataSource(resultSet);
			
			jasperPrint =
							JasperFillManager.fillReport(jasperReport, parameters, resultSetDataSource);

			
		}
		catch (JRException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 	jasperPrint;
	}
	
	public OutputStream exportPdf(JasperPrint jasperPrint) 
					throws JRException{
		
		OutputStream outputStream = new ByteArrayOutputStream();
		
		JasperExportManager.exportReportToPdfStream(
			jasperPrint, outputStream);
		
		return outputStream;
	}
	
	public OutputStream exportCsv(JasperPrint jasperPrint) 
			throws JRException{

OutputStream outputStream = new ByteArrayOutputStream();
		
		JRExporter exporter = new JRCsvExporter();

		// Configura exporter
		exporter.setParameter(
				
				JRCsvExporterParameter.OUTPUT_STREAM, outputStream);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(
				JRCsvExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);
		
		// Exporta Excel
		exporter.exportReport();
		
		
		return outputStream;
	}
	
	public OutputStream exportExcel(JasperPrint jasperPrint) 
					throws JRException{
		
		OutputStream outputStream = new ByteArrayOutputStream();
		
		JRExporter exporter = new JExcelApiExporter();

		// Configura exporter
		exporter.setParameter(
			JRExporterParameter.OUTPUT_STREAM, outputStream);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(
			JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
		exporter.setParameter(
			JRXlsExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);
		exporter.setParameter(
			JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		exporter.setParameter(
			JRXlsExporterParameter.IS_IGNORE_GRAPHICS, Boolean.TRUE);
		exporter.setParameter(
			JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN, Boolean.TRUE);

		// Exporta Excel
		exporter.exportReport();
		
		return outputStream;
	}
	
	public OutputStream exportPdf(
		long fileEntryId, Collection<?> beanCollection,
		Map<String, Object> parameters)
		throws SystemException, PortalException {

		try {
			JasperPrint jasperPrint=
							getJasperPrint(fileEntryId, beanCollection, parameters);
			return exportPdf(jasperPrint);
		}
		catch (Exception e) {
			
			throw new PortalException(e.getMessage());
		}
	}
	public OutputStream exportCsv(
			long fileEntryId, Collection<?> beanCollection,
			Map<String, Object> parameters)
			throws SystemException,  PortalException {
			try {
				JasperPrint jasperPrint=
								getJasperPrint(fileEntryId, beanCollection, parameters);
				return exportCsv(jasperPrint);
			}
			catch (Exception e) {
				
				throw new PortalException(e.getMessage());
			}
		}
	public OutputStream exportExcel(
		long fileEntryId, Collection<?> beanCollection,
		Map<String, Object> parameters)
		throws SystemException,  PortalException {
		try {
			JasperPrint jasperPrint=
							getJasperPrint(fileEntryId, beanCollection, parameters);
			return exportExcel(jasperPrint);
		}
		catch (Exception e) {
			
			throw new PortalException(e.getMessage());
		}
	}
	
	public OutputStream exportPdf(
		long fileEntryId, String sql,
		Map<String, Object> parameters)
		throws SystemException, PortalException {

		try {
			JasperPrint jasperPrint=
							getJasperPrint(fileEntryId, sql, parameters);
			return exportPdf(jasperPrint);
		}
		catch (JRException e) {
			
			throw new PortalException(e.getMessage());
		}
	}
	
	public OutputStream exportExcel(
		long fileEntryId, String sql,
		Map<String, Object> parameters)
		throws SystemException,  PortalException {
		try {
			JasperPrint jasperPrint=
							getJasperPrint(fileEntryId, sql, parameters);
			return exportExcel(jasperPrint);
		}
		catch (JRException e) {
			
			throw new PortalException(e.getMessage());
		}
	}
}