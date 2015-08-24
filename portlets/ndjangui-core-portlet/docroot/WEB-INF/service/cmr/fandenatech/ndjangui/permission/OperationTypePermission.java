package cmr.fandenatech.ndjangui.permission;

import cmr.fandenatech.ndjangui.model.OperationType;
import cmr.fandenatech.ndjangui.service.OperationTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class OperationTypePermission {
	public static void check(
			PermissionChecker permissionChecker, OperationType operationType, String actionId)
		throws PortalException {

			if (!contains(permissionChecker, operationType, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static void check(
				PermissionChecker permissionChecker, long operationTypeId, String actionId)
			throws PortalException, SystemException {
		
			if (!contains(permissionChecker, operationTypeId, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static boolean contains(
			PermissionChecker permissionChecker, OperationType operationType, String actionId) {
		
			if (permissionChecker.hasOwnerPermission(
				operationType.getCompanyId(), OperationType.class.getName(), operationType.getOperationTypeId(),
				operationType.getUserId(), actionId)) {
		
				return true;
			}
		
			return permissionChecker.hasPermission(
				0 , OperationType.class.getName(), operationType.getOperationTypeId(),
				actionId);
		}
		
		public static boolean contains(
				PermissionChecker permissionChecker, long operationTypeId, String actionId)
			throws PortalException, SystemException {
		
			OperationType operationType = OperationTypeLocalServiceUtil.getOperationType(operationTypeId);
			
			return contains(permissionChecker, operationType, actionId);
		}	


	
}
