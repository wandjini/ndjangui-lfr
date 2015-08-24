package cmr.fandenatech.ndjangui.permission;

import cmr.fandenatech.ndjangui.model.BudgetPeriod;
import cmr.fandenatech.ndjangui.service.BudgetPeriodLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class BudgetPeriodPermission {

	public static void check(
			PermissionChecker permissionChecker, BudgetPeriod budgetPeriod, String actionId)
		throws PortalException {

			if (!contains(permissionChecker, budgetPeriod, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static void check(
				PermissionChecker permissionChecker, long budgetPeriodId, String actionId)
			throws PortalException, SystemException {
		
			if (!contains(permissionChecker, budgetPeriodId, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static boolean contains(
			PermissionChecker permissionChecker, BudgetPeriod budgetPeriod, String actionId) {
		
			if (permissionChecker.hasOwnerPermission(
				budgetPeriod.getCompanyId(), BudgetPeriod.class.getName(), budgetPeriod.getBudgetPeriodId(),
				budgetPeriod.getUserId(), actionId)) {
		
				return true;
			}
		
			return permissionChecker.hasPermission(
				0 , BudgetPeriod.class.getName(), budgetPeriod.getBudgetPeriodId(),
				actionId);
		}
		
		public static boolean contains(
				PermissionChecker permissionChecker, long budgetPeriodId, String actionId)
			throws PortalException, SystemException {
		
			BudgetPeriod budgetPeriod = BudgetPeriodLocalServiceUtil.getBudgetPeriod(budgetPeriodId);
			
			return contains(permissionChecker, budgetPeriod, actionId);
		}	


}
