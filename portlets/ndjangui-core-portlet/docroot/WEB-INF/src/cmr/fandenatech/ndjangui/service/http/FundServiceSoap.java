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

import cmr.fandenatech.ndjangui.service.FundServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link cmr.fandenatech.ndjangui.service.FundServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link cmr.fandenatech.ndjangui.model.FundSoap}.
 * If the method in the service utility returns a
 * {@link cmr.fandenatech.ndjangui.model.Fund}, that is translated to a
 * {@link cmr.fandenatech.ndjangui.model.FundSoap}. Methods that SOAP cannot
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
 * @see FundServiceHttp
 * @see cmr.fandenatech.ndjangui.model.FundSoap
 * @see cmr.fandenatech.ndjangui.service.FundServiceUtil
 * @generated
 */
public class FundServiceSoap {
	public static cmr.fandenatech.ndjangui.model.FundSoap addFund(
		long groupId, long userId, java.lang.String name, long budgetPeriodId,
		long fundTypeId, java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			cmr.fandenatech.ndjangui.model.Fund returnValue = FundServiceUtil.addFund(groupId,
					userId, name, budgetPeriodId, fundTypeId, shortDescription,
					serviceContext);

			return cmr.fandenatech.ndjangui.model.FundSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static cmr.fandenatech.ndjangui.model.FundSoap updateFund(
		long groupId, long userId, long fundId, java.lang.String name,
		long budgetPeriodId, long fundTypeId,
		java.lang.String shortDescription,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			cmr.fandenatech.ndjangui.model.Fund returnValue = FundServiceUtil.updateFund(groupId,
					userId, fundId, name, budgetPeriodId, fundTypeId,
					shortDescription, serviceContext);

			return cmr.fandenatech.ndjangui.model.FundSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static cmr.fandenatech.ndjangui.model.FundSoap closeFund(
		long userId, long fundId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			cmr.fandenatech.ndjangui.model.Fund returnValue = FundServiceUtil.closeFund(userId,
					fundId, serviceContext);

			return cmr.fandenatech.ndjangui.model.FundSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static cmr.fandenatech.ndjangui.model.FundSoap openFund(
		long userId, long fundId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			cmr.fandenatech.ndjangui.model.Fund returnValue = FundServiceUtil.openFund(userId,
					fundId, serviceContext);

			return cmr.fandenatech.ndjangui.model.FundSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static cmr.fandenatech.ndjangui.model.FundSoap deleteFund(
		long userId, long fundId) throws RemoteException {
		try {
			cmr.fandenatech.ndjangui.model.Fund returnValue = FundServiceUtil.deleteFund(userId,
					fundId);

			return cmr.fandenatech.ndjangui.model.FundSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static cmr.fandenatech.ndjangui.model.MemberFundSoap[] getMembersFund(
		long groupId, long fundId, int start, int end)
		throws RemoteException {
		try {
			java.util.List<cmr.fandenatech.ndjangui.model.MemberFund> returnValue =
				FundServiceUtil.getMembersFund(groupId, fundId, start, end);

			return cmr.fandenatech.ndjangui.model.MemberFundSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FundServiceSoap.class);
}