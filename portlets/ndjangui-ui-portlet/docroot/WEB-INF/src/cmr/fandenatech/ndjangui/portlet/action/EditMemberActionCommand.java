package cmr.fandenatech.ndjangui.portlet.action;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import cmr.fandenatech.ndjangui.model.Member;
import cmr.fandenatech.ndjangui.service.MemberServiceUtil;
import cmr.fandenatech.ndjangui.util.ActionKeys;
import cmr.fandenatech.ndjangui.util.Command;

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.ActionCommand;

public class EditMemberActionCommand implements ActionCommand {

	@Override
	public boolean processCommand(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortletException {
		// TODO Auto-generated method stub
		String cmd = ParamUtil.getString(portletRequest , Constants.CMD);
	
		if(cmd.equalsIgnoreCase(Constants.ADD)){
			try {
				addMember(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}	
		else if(cmd.equalsIgnoreCase(ActionKeys.ACTIVATE_MEMBER)){
			try {
				activateMember(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equalsIgnoreCase(ActionKeys.DE_ACTIVATE_MEMBER)){
			try {
				deleteMember(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equalsIgnoreCase( Constants.UPDATE)){
			try {
				updateMember(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else
			return false;
		
		return true;
	}

	protected void addMember(PortletRequest portletRequest, PortletResponse portletResponse) throws Exception{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
				
		String name = ParamUtil.getString(portletRequest, "name");
		String surname = ParamUtil.getString(portletRequest, "surname");
		String email = ParamUtil.getString(portletRequest, "email");
		String cardNumber = ParamUtil.getString(portletRequest, "cardNumber");
		String phoneNumber = ParamUtil.getString(portletRequest, "phoneNumber");
		
		ServiceContext serviceContext =
	            ServiceContextFactory.getInstance(Member.class.getName(),
	            portletRequest);
		try {
				MemberServiceUtil.addMember(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
					themeDisplay.getUserId(), name, surname, 
					email, cardNumber, phoneNumber,serviceContext);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	protected void updateMember(PortletRequest portletRequest, PortletResponse portletResponse) throws Exception{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
				
		long memberId = ParamUtil.getLong(portletRequest, "memberId");
		String name = ParamUtil.getString(portletRequest, "name");
		String surname = ParamUtil.getString(portletRequest, "surname");
		String email = ParamUtil.getString(portletRequest, "email");
		String cardNumber = ParamUtil.getString(portletRequest, "cardNumber");
		String phoneNumber = ParamUtil.getString(portletRequest, "phoneNumber");
		ServiceContext serviceContext =
	            ServiceContextFactory.getInstance(Member.class.getName(),
	            portletRequest);
		try {
				MemberServiceUtil.updateMember(memberId, 
					themeDisplay.getUserId(), name, surname, 
					email, cardNumber, phoneNumber, serviceContext);
		} catch (Exception e) {
			throw e;
		}
	}

	protected void deleteMember(PortletRequest portletRequest, PortletResponse portletResponse) throws Exception{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
				
		long memberId = ParamUtil.getLong(portletRequest, "memberId");
		ServiceContext serviceContext =
	            ServiceContextFactory.getInstance(Member.class.getName(),
	            portletRequest);
		try {
				MemberServiceUtil.deleteMember(memberId, 
					themeDisplay.getUserId(),serviceContext);
		} catch (Exception e) {
			throw e;
		}
	}
	
	protected void activateMember(PortletRequest request, PortletResponse response) throws Exception{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				
		long memberId = ParamUtil.getLong(request, "memberId");
		
		try {
				MemberServiceUtil.activateMember(memberId, 
					themeDisplay.getUserId());
		} catch (Exception e) {
			throw e;
		}
	}

}
