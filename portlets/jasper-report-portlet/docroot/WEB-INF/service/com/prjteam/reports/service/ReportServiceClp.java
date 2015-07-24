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

import com.liferay.portal.service.InvokableService;

/**
 * @author marcoleo
 * @generated
 */
public class ReportServiceClp implements ReportService {
	public ReportServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getJasperPrint";

		_methodParameterTypes3 = new String[] {
				"long", "java.util.Collection", "java.util.Map"
			};

		_methodName4 = "getJasperPrint";

		_methodParameterTypes4 = new String[] {
				"long", "java.lang.String", "java.util.Map"
			};

		_methodName5 = "exportPdf";

		_methodParameterTypes5 = new String[] {
				"net.sf.jasperreports.engine.JasperPrint"
			};

		_methodName6 = "exportCsv";

		_methodParameterTypes6 = new String[] {
				"net.sf.jasperreports.engine.JasperPrint"
			};

		_methodName7 = "exportExcel";

		_methodParameterTypes7 = new String[] {
				"net.sf.jasperreports.engine.JasperPrint"
			};

		_methodName8 = "exportPdf";

		_methodParameterTypes8 = new String[] {
				"long", "java.util.Collection", "java.util.Map"
			};

		_methodName9 = "exportCsv";

		_methodParameterTypes9 = new String[] {
				"long", "java.util.Collection", "java.util.Map"
			};

		_methodName10 = "exportExcel";

		_methodParameterTypes10 = new String[] {
				"long", "java.util.Collection", "java.util.Map"
			};

		_methodName11 = "exportPdf";

		_methodParameterTypes11 = new String[] {
				"long", "java.lang.String", "java.util.Map"
			};

		_methodName12 = "exportExcel";

		_methodParameterTypes12 = new String[] {
				"long", "java.lang.String", "java.util.Map"
			};
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public net.sf.jasperreports.engine.JasperPrint getJasperPrint(
		long fileEntryId, java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						fileEntryId,
						
					ClpSerializer.translateInput(beanCollection),
						
					ClpSerializer.translateInput(parameters)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (net.sf.jasperreports.engine.JasperPrint)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public net.sf.jasperreports.engine.JasperPrint getJasperPrint(
		long fileEntryId, java.lang.String sql,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] {
						fileEntryId,
						
					ClpSerializer.translateInput(sql),
						
					ClpSerializer.translateInput(parameters)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (net.sf.jasperreports.engine.JasperPrint)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.io.OutputStream exportPdf(
		net.sf.jasperreports.engine.JasperPrint jasperPrint)
		throws net.sf.jasperreports.engine.JRException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(jasperPrint) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof net.sf.jasperreports.engine.JRException) {
				throw (net.sf.jasperreports.engine.JRException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.io.OutputStream)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.io.OutputStream exportCsv(
		net.sf.jasperreports.engine.JasperPrint jasperPrint)
		throws net.sf.jasperreports.engine.JRException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] { ClpSerializer.translateInput(jasperPrint) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof net.sf.jasperreports.engine.JRException) {
				throw (net.sf.jasperreports.engine.JRException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.io.OutputStream)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.io.OutputStream exportExcel(
		net.sf.jasperreports.engine.JasperPrint jasperPrint)
		throws net.sf.jasperreports.engine.JRException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] { ClpSerializer.translateInput(jasperPrint) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof net.sf.jasperreports.engine.JRException) {
				throw (net.sf.jasperreports.engine.JRException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.io.OutputStream)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.io.OutputStream exportPdf(long fileEntryId,
		java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] {
						fileEntryId,
						
					ClpSerializer.translateInput(beanCollection),
						
					ClpSerializer.translateInput(parameters)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.io.OutputStream)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.io.OutputStream exportCsv(long fileEntryId,
		java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						fileEntryId,
						
					ClpSerializer.translateInput(beanCollection),
						
					ClpSerializer.translateInput(parameters)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.io.OutputStream)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.io.OutputStream exportExcel(long fileEntryId,
		java.util.Collection<?> beanCollection,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] {
						fileEntryId,
						
					ClpSerializer.translateInput(beanCollection),
						
					ClpSerializer.translateInput(parameters)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.io.OutputStream)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.io.OutputStream exportPdf(long fileEntryId,
		java.lang.String sql,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] {
						fileEntryId,
						
					ClpSerializer.translateInput(sql),
						
					ClpSerializer.translateInput(parameters)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.io.OutputStream)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.io.OutputStream exportExcel(long fileEntryId,
		java.lang.String sql,
		java.util.Map<java.lang.String, java.lang.Object> parameters)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] {
						fileEntryId,
						
					ClpSerializer.translateInput(sql),
						
					ClpSerializer.translateInput(parameters)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.io.OutputStream)ClpSerializer.translateOutput(returnObj);
	}

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
}