package cmr.fandenatech.ndjangui.permission;

import cmr.fandenatech.ndjangui.model.Fund;
import cmr.fandenatech.ndjangui.service.FundLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class FundPermission {
	public static void check(
			PermissionChecker permissionChecker, Fund fund, String actionId)
		throws PortalException {

			if (!contains(permissionChecker, fund, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static void check(
				PermissionChecker permissionChecker, long fundId, String actionId)
			throws PortalException, SystemException {
		
			if (!contains(permissionChecker, fundId, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static boolean contains(
			PermissionChecker permissionChecker, Fund fund, String actionId) {
		
			if (permissionChecker.hasOwnerPermission(
				fund.getCompanyId(), Fund.class.getName(), fund.getFundId(),
				fund.getUserId(), actionId)) {
		
				return true;
			}
		
			return permissionChecker.hasPermission(
				0 , Fund.class.getName(), fund.getFundId(),
				actionId);
		}
		
		public static boolean contains(
				PermissionChecker permissionChecker, long fundId, String actionId)
			throws PortalException, SystemException {
		
			Fund fund = FundLocalServiceUtil.getFund(fundId);
			
			return contains(permissionChecker, fund, actionId);
		}	


}
