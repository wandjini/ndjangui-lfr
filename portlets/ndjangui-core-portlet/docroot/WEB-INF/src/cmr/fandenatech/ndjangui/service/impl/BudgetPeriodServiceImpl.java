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

package cmr.fandenatech.ndjangui.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;

import cmr.fandenatech.ndjangui.model.BudgetPeriod;
import cmr.fandenatech.ndjangui.permission.BudgetPeriodPermission;
import cmr.fandenatech.ndjangui.service.BudgetPeriodLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.base.BudgetPeriodServiceBaseImpl;

/**
 * The implementation of the budget period remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link cmr.fandenatech.ndjangui.service.BudgetPeriodService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.base.BudgetPeriodServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.BudgetPeriodServiceUtil
 */
public class BudgetPeriodServiceImpl extends BudgetPeriodServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link cmr.fandenatech.ndjangui.service.BudgetPeriodServiceUtil} to access the budget period remote service.
	 */
	public BudgetPeriod addBudgetPeriod(long groupId,long userId, String name,
			String shortDescription, Date startDate, Date endDate, ServiceContext serviceContext ) 
					throws PortalException, SystemException{
		return BudgetPeriodLocalServiceUtil.addBudgetPeriod(groupId, userId, name,
				shortDescription,startDate, endDate, serviceContext);
	
	}
	
	public BudgetPeriod updateBudgetPeriod(long userId, long budgetPeriodId, String name,
			String shortDescription,  Date startDate, Date endDate) 
					throws PortalException, SystemException{
		BudgetPeriodPermission.check(getPermissionChecker(), budgetPeriodId, ActionKeys.UPDATE);
		return BudgetPeriodLocalServiceUtil.updateBudgetPeriod(userId, budgetPeriodId, name, shortDescription,startDate, endDate);
	}
	
	public BudgetPeriod updateBudgetPeriodStatus(long userId, long budgetPeriodId, int status) 
			throws PortalException, SystemException{
		BudgetPeriodPermission.check(getPermissionChecker(), budgetPeriodId, ActionKeys.UPDATE);
		return BudgetPeriodLocalServiceUtil.updateBudgetPeriodStatus(userId, budgetPeriodId, status);
	}

}