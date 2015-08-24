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

import cmr.fandenatech.ndjangui.service.MemberServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link cmr.fandenatech.ndjangui.service.MemberServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link cmr.fandenatech.ndjangui.model.MemberSoap}.
 * If the method in the service utility returns a
 * {@link cmr.fandenatech.ndjangui.model.Member}, that is translated to a
 * {@link cmr.fandenatech.ndjangui.model.MemberSoap}. Methods that SOAP cannot
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
 * @see MemberServiceHttp
 * @see cmr.fandenatech.ndjangui.model.MemberSoap
 * @see cmr.fandenatech.ndjangui.service.MemberServiceUtil
 * @generated
 */
public class MemberServiceSoap {
	public static cmr.fandenatech.ndjangui.model.MemberSoap addMember(
		long companyId, long groupId, long userId, java.lang.String name,
		java.lang.String surname, java.lang.String email,
		java.lang.String cardNumber, java.lang.String phoneNumber,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			cmr.fandenatech.ndjangui.model.Member returnValue = MemberServiceUtil.addMember(companyId,
					groupId, userId, name, surname, email, cardNumber,
					phoneNumber, serviceContext);

			return cmr.fandenatech.ndjangui.model.MemberSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static cmr.fandenatech.ndjangui.model.MemberSoap updateMember(
		long memberId, long userId, java.lang.String name,
		java.lang.String surname, java.lang.String email,
		java.lang.String cardNumber, java.lang.String phoneNumber,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			cmr.fandenatech.ndjangui.model.Member returnValue = MemberServiceUtil.updateMember(memberId,
					userId, name, surname, email, cardNumber, phoneNumber,
					serviceContext);

			return cmr.fandenatech.ndjangui.model.MemberSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static cmr.fandenatech.ndjangui.model.MemberSoap deleteMember(
		long memberId, long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			cmr.fandenatech.ndjangui.model.Member returnValue = MemberServiceUtil.deleteMember(memberId,
					userId, serviceContext);

			return cmr.fandenatech.ndjangui.model.MemberSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static cmr.fandenatech.ndjangui.model.MemberSoap activateMember(
		long memberId, long userId) throws RemoteException {
		try {
			cmr.fandenatech.ndjangui.model.Member returnValue = MemberServiceUtil.activateMember(memberId,
					userId);

			return cmr.fandenatech.ndjangui.model.MemberSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MemberServiceSoap.class);
}