package cmr.fandenatech.ndjangui.permission;

import cmr.fandenatech.ndjangui.model.Sanction;
import cmr.fandenatech.ndjangui.service.SanctionLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class SanctionPermission {
	public static void check(
			PermissionChecker permissionChecker, Sanction sanction, String actionId)
		throws PortalException {

			if (!contains(permissionChecker, sanction, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static void check(
				PermissionChecker permissionChecker, long sanctionId, String actionId)
			throws PortalException, SystemException {
		
			if (!contains(permissionChecker, sanctionId, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static boolean contains(
			PermissionChecker permissionChecker, Sanction sanction, String actionId) {
		
			if (permissionChecker.hasOwnerPermission(
				sanction.getCompanyId(), Sanction.class.getName(), sanction.getSanctionId(),
				sanction.getUserId(), actionId)) {
		
				return true;
			}
		
			return permissionChecker.hasPermission(
				0 , Sanction.class.getName(), sanction.getSanctionId(),
				actionId);
		}
		
		public static boolean contains(
				PermissionChecker permissionChecker, long sanctionId, String actionId)
			throws PortalException, SystemException {
		
			Sanction sanction = SanctionLocalServiceUtil.getSanction(sanctionId);
			
			return contains(permissionChecker, sanction, actionId);
		}	


}
