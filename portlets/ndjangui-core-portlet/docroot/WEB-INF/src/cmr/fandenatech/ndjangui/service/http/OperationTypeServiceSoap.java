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

package cmr.fandenatech.ndjangui.service.http;

import cmr.fandenatech.ndjangui.service.OperationTypeServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link cmr.fandenatech.ndjangui.service.OperationTypeServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link cmr.fandenatech.ndjangui.model.OperationTypeSoap}.
 * If the method in the service utility returns a
 * {@link cmr.fandenatech.ndjangui.model.OperationType}, that is translated to a
 * {@link cmr.fandenatech.ndjangui.model.OperationTypeSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author guyw
 * @see OperationTypeServiceHttp
 * @see cmr.fandenatech.ndjangui.model.OperationTypeSoap
 * @see cmr.fandenatech.ndjangui.service.OperationTypeServiceUtil
 * @generated
 */
public class OperationTypeServiceSoap {
	public static cmr.fandenatech.ndjangui.model.OperationTypeSoap addOperationType(
		long groupId, long userId, java.lang.String name,
		java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			cmr.fandenatech.ndjangui.model.OperationType returnValue = OperationTypeServiceUtil.addOperationType(groupId,
					userId, name, shortDescription, serviceContext);

			return cmr.fandenatech.ndjangui.model.OperationTypeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static cmr.fandenatech.ndjangui.model.OperationTypeSoap updateOperationType(
		long groupId, long userId, long operationTypeId, java.lang.String name,
		java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			cmr.fandenatech.ndjangui.model.OperationType returnValue = OperationTypeServiceUtil.updateOperationType(groupId,
					userId, operationTypeId, name, shortDescription,
					serviceContext);

			return cmr.fandenatech.ndjangui.model.OperationTypeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static cmr.fandenatech.ndjangui.model.OperationTypeSoap updateOperationTypeStatus(
		long userId, long operationTypeId, int status)
		throws RemoteException {
		try {
			cmr.fandenatech.ndjangui.model.OperationType returnValue = OperationTypeServiceUtil.updateOperationTypeStatus(userId,
					operationTypeId, status);

			return cmr.fandenatech.ndjangui.model.OperationTypeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static cmr.fandenatech.ndjangui.model.OperationTypeSoap deleOperationType(
		long operationTypeId) throws RemoteException {
		try {
			cmr.fandenatech.ndjangui.model.OperationType returnValue = OperationTypeServiceUtil.deleOperationType(operationTypeId);

			return cmr.fandenatech.ndjangui.model.OperationTypeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(OperationTypeServiceSoap.class);
}