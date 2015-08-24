package cmr.fandenatech.ndjangui.permission;

import cmr.fandenatech.ndjangui.model.Operation;
import cmr.fandenatech.ndjangui.service.OperationLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class OperationPermission {

	public static void check(
			PermissionChecker permissionChecker, Operation operation, String actionId)
		throws PortalException {

			if (!contains(permissionChecker, operation, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static void check(
				PermissionChecker permissionChecker, long operationId, String actionId)
			throws PortalException, SystemException {
		
			if (!contains(permissionChecker, operationId, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static boolean contains(
			PermissionChecker permissionChecker, Operation operation, String actionId) {
		
			if (permissionChecker.hasOwnerPermission(
				operation.getCompanyId(), Operation.class.getName(), operation.getOperationId(),
				operation.getUserId(), actionId)) {
		
				return true;
			}
		
			return permissionChecker.hasPermission(
				0 , Operation.class.getName(), operation.getOperationId(),
				actionId);
		}
		
		public static boolean contains(
				PermissionChecker permissionChecker, long operationId, String actionId)
			throws PortalException, SystemException {
		
			Operation operation = OperationLocalServiceUtil.getOperation(operationId);
			
			return contains(permissionChecker, operation, actionId);
		}	

	
}
