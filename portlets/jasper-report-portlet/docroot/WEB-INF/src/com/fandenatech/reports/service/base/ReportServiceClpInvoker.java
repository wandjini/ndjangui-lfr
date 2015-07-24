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

package com.fandenatech.reports.service.base;

import com.prjteam.reports.service.ReportServiceUtil;

import java.util.Arrays;

/**
 * @author marcoleo
 * @generated
 */
public class ReportServiceClpInvoker {
	public ReportServiceClpInvoker() {
		_methodName14 = "getBeanIdentifier";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "setBeanIdentifier";

		_methodParameterTypes15 = new String[] { "java.lang.String" };

		_methodName18 = "getJasperPrint";

		_methodParameterTypes18 = new String[] {
				"long", "java.util.Collection", "java.util.Map"
			};

		_methodName19 = "getJasperPrint";

		_methodParameterTypes19 = new String[] {
				"long", "java.lang.String", "java.util.Map"
			};

		_methodName20 = "exportPdf";

		_methodParameterTypes20 = new String[] {
				"net.sf.jasperreports.engine.JasperPrint"
			};

		_methodName21 = "exportCsv";

		_methodParameterTypes21 = new String[] {
				"net.sf.jasperreports.engine.JasperPrint"
			};

		_methodName22 = "exportExcel";

		_methodParameterTypes22 = new String[] {
				"net.sf.jasperreports.engine.JasperPrint"
			};

		_methodName23 = "exportPdf";

		_methodParameterTypes23 = new String[] {
				"long", "java.util.Collection", "java.util.Map"
			};

		_methodName24 = "exportCsv";

		_methodParameterTypes24 = new String[] {
				"long", "java.util.Collection", "java.util.Map"
			};

		_methodName25 = "exportExcel";

		_methodParameterTypes25 = new String[] {
				"long", "java.util.Collection", "java.util.Map"
			};

		_methodName26 = "exportPdf";

		_methodParameterTypes26 = new String[] {
				"long", "java.lang.String", "java.util.Map"
			};

		_methodName27 = "exportExcel";

		_methodParameterTypes27 = new String[] {
				"long", "java.lang.String", "java.util.Map"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ReportServiceUtil.getBeanIdentifier();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			ReportServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ReportServiceUtil.getJasperPrint(((Long)arguments[0]).longValue(),
				(java.util.Collection<?>)arguments[1],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[2]);
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ReportServiceUtil.getJasperPrint(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[2]);
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return ReportServiceUtil.exportPdf((net.sf.jasperreports.engine.JasperPrint)arguments[0]);
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return ReportServiceUtil.exportCsv((net.sf.jasperreports.engine.JasperPrint)arguments[0]);
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return ReportServiceUtil.exportExcel((net.sf.jasperreports.engine.JasperPrint)arguments[0]);
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			return ReportServiceUtil.exportPdf(((Long)arguments[0]).longValue(),
				(java.util.Collection<?>)arguments[1],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[2]);
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return ReportServiceUtil.exportCsv(((Long)arguments[0]).longValue(),
				(java.util.Collection<?>)arguments[1],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[2]);
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return ReportServiceUtil.exportExcel(((Long)arguments[0]).longValue(),
				(java.util.Collection<?>)arguments[1],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[2]);
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return ReportServiceUtil.exportPdf(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[2]);
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return ReportServiceUtil.exportExcel(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[2]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
}