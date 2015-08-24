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

package cmr.fandenatech.ndjangui.service.persistence;

import cmr.fandenatech.ndjangui.model.BudgetPeriod;
import cmr.fandenatech.ndjangui.service.BudgetPeriodLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author guyw
 * @generated
 */
public abstract class BudgetPeriodActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public BudgetPeriodActionableDynamicQuery() throws SystemException {
		setBaseLocalService(BudgetPeriodLocalServiceUtil.getService());
		setClass(BudgetPeriod.class);

		setClassLoader(cmr.fandenatech.ndjangui.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("budgetPeriodId");
	}
}