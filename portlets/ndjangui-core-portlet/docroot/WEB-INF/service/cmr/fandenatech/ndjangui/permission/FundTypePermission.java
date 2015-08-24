package cmr.fandenatech.ndjangui.permission;

import cmr.fandenatech.ndjangui.model.FundType;
import cmr.fandenatech.ndjangui.service.FundTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class FundTypePermission {

	public static void check(
			PermissionChecker permissionChecker, FundType fundType, String actionId)
		throws PortalException {

			if (!contains(permissionChecker, fundType, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static void check(
				PermissionChecker permissionChecker, long fundTypeId, String actionId)
			throws PortalException, SystemException {
		
			if (!contains(permissionChecker, fundTypeId, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static boolean contains(
			PermissionChecker permissionChecker, FundType fundType, String actionId) {
		
			if (permissionChecker.hasOwnerPermission(
				fundType.getCompanyId(), FundType.class.getName(), fundType.getFundTypeId(),
				fundType.getUserId(), actionId)) {
		
				return true;
			}
		
			return permissionChecker.hasPermission(
				0 , FundType.class.getName(), fundType.getFundTypeId(),
				actionId);
		}
		
		public static boolean contains(
				PermissionChecker permissionChecker, long fundTypeId, String actionId)
			throws PortalException, SystemException {
		
			FundType fundType = FundTypeLocalServiceUtil.getFundType(fundTypeId);
			
			return contains(permissionChecker, fundType, actionId);
		}	

	
}
