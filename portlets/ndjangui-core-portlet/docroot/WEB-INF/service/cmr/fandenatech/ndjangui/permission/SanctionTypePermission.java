package cmr.fandenatech.ndjangui.permission;

import cmr.fandenatech.ndjangui.model.SanctionType;
import cmr.fandenatech.ndjangui.service.SanctionTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class SanctionTypePermission {

	public static void check(
			PermissionChecker permissionChecker, SanctionType sanctionType, String actionId)
		throws PortalException {

			if (!contains(permissionChecker, sanctionType, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static void check(
				PermissionChecker permissionChecker, long sanctionTypeId, String actionId)
			throws PortalException, SystemException {
		
			if (!contains(permissionChecker, sanctionTypeId, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static boolean contains(
			PermissionChecker permissionChecker, SanctionType sanctionType, String actionId) {
		
			if (permissionChecker.hasOwnerPermission(
				sanctionType.getCompanyId(), SanctionType.class.getName(), sanctionType.getSanctionTypeId(),
				sanctionType.getUserId(), actionId)) {
		
				return true;
			}
		
			return permissionChecker.hasPermission(
				0 , SanctionType.class.getName(), sanctionType.getSanctionTypeId(),
				actionId);
		}
		
		public static boolean contains(
				PermissionChecker permissionChecker, long sanctionTypeId, String actionId)
			throws PortalException, SystemException {
		
			SanctionType sanctionType = SanctionTypeLocalServiceUtil.getSanctionType(sanctionTypeId);
			
			return contains(permissionChecker, sanctionType, actionId);
		}	

	
}
