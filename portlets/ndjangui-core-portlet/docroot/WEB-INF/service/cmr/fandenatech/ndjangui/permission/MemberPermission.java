package cmr.fandenatech.ndjangui.permission;

import cmr.fandenatech.ndjangui.model.Member;
import cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class MemberPermission {

	public static void check(
			PermissionChecker permissionChecker, Member member, String actionId)
		throws PortalException {

			if (!contains(permissionChecker, member, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static void check(
				PermissionChecker permissionChecker, long memberId, String actionId)
			throws PortalException, SystemException {
		
			if (!contains(permissionChecker, memberId, actionId)) {
				throw new PrincipalException();
			}
		}
		
		public static boolean contains(
			PermissionChecker permissionChecker, Member member, String actionId) {
		
			if (permissionChecker.hasOwnerPermission(
				member.getCompanyId(), Member.class.getName(), member.getMemberId(),
				member.getUserId(), actionId)) {
		
				return true;
			}
		
			return permissionChecker.hasPermission(
				0 , Member.class.getName(), member.getMemberId(),
				actionId);
		}
		
		public static boolean contains(
				PermissionChecker permissionChecker, long memberId, String actionId)
			throws PortalException, SystemException {
		
			Member member = MemberLocalServiceUtil.getMember(memberId);
			
			return contains(permissionChecker, member, actionId);
		}	

}
