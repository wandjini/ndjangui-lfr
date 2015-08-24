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

package cmr.fandenatech.ndjangui.service.messaging;

import cmr.fandenatech.ndjangui.service.AddressLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.AddressServiceUtil;
import cmr.fandenatech.ndjangui.service.BudgetPeriodLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.BudgetPeriodServiceUtil;
import cmr.fandenatech.ndjangui.service.ClpSerializer;
import cmr.fandenatech.ndjangui.service.FundLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.FundServiceUtil;
import cmr.fandenatech.ndjangui.service.FundTypeLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.FundTypeServiceUtil;
import cmr.fandenatech.ndjangui.service.MemberFundLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.MemberFundServiceUtil;
import cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.MemberServiceUtil;
import cmr.fandenatech.ndjangui.service.MemberSittingLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.MemberSittingServiceUtil;
import cmr.fandenatech.ndjangui.service.OperationLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.OperationServiceUtil;
import cmr.fandenatech.ndjangui.service.OperationTypeLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.OperationTypeServiceUtil;
import cmr.fandenatech.ndjangui.service.Operation_FundLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.Operation_FundServiceUtil;
import cmr.fandenatech.ndjangui.service.SanctionLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.SanctionServiceUtil;
import cmr.fandenatech.ndjangui.service.SanctionTypeLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.SanctionTypeServiceUtil;
import cmr.fandenatech.ndjangui.service.SittingLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.SittingServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author guyw
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AddressLocalServiceUtil.clearService();

			AddressServiceUtil.clearService();
			BudgetPeriodLocalServiceUtil.clearService();

			BudgetPeriodServiceUtil.clearService();
			FundLocalServiceUtil.clearService();

			FundServiceUtil.clearService();
			FundTypeLocalServiceUtil.clearService();

			FundTypeServiceUtil.clearService();
			MemberLocalServiceUtil.clearService();

			MemberServiceUtil.clearService();
			MemberFundLocalServiceUtil.clearService();

			MemberFundServiceUtil.clearService();
			MemberSittingLocalServiceUtil.clearService();

			MemberSittingServiceUtil.clearService();
			OperationLocalServiceUtil.clearService();

			OperationServiceUtil.clearService();
			Operation_FundLocalServiceUtil.clearService();

			Operation_FundServiceUtil.clearService();
			OperationTypeLocalServiceUtil.clearService();

			OperationTypeServiceUtil.clearService();
			SanctionLocalServiceUtil.clearService();

			SanctionServiceUtil.clearService();
			SanctionTypeLocalServiceUtil.clearService();

			SanctionTypeServiceUtil.clearService();
			SittingLocalServiceUtil.clearService();

			SittingServiceUtil.clearService();
		}
	}
}