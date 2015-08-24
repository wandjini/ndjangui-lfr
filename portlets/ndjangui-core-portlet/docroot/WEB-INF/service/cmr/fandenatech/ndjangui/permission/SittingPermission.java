package cmr.fandenatech.ndjangui.permission;

import cmr.fandenatech.ndjangui.model.Sitting;
import cmr.fandenatech.ndjangui.service.SittingLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class SittingPermission {
	public static void check(
			PermissionChecker permissionChecker, Sitting sitting, String actionId)
		throws PortalException {

			if (!contains(permissionChecker, sitting, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static void check(
				PermissionChecker permissionChecker, long sittingId, String actionId)
			throws PortalException, SystemException {
		
			if (!contains(permissionChecker, sittingId, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static boolean contains(
			PermissionChecker permissionChecker, Sitting sitting, String actionId) {
		
			if (permissionChecker.hasOwnerPermission(
				sitting.getCompanyId(), Sitting.class.getName(), sitting.getSittingId(),
				sitting.getUserId(), actionId)) {
		
				return true;
			}
		
			return permissionChecker.hasPermission(
				0 , Sitting.class.getName(), sitting.getSittingId(),
				actionId);
		}
		
		public static boolean contains(
				PermissionChecker permissionChecker, long sittingId, String actionId)
			throws PortalException, SystemException {
		
			Sitting sitting = SittingLocalServiceUtil.getSitting(sittingId);
			
			return contains(permissionChecker, sitting, actionId);
		}	


}
