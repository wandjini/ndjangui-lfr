package cmr.fandenatech.ndjangui.portlet.action;

import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import cmr.fandenatech.ndjangui.model.Sitting;
import cmr.fandenatech.ndjangui.service.MemberSittingLocalServiceUtil;
import cmr.fandenatech.ndjangui.service.SittingServiceUtil;
import cmr.fandenatech.ndjangui.service.MemberSittingServiceUtil;
import cmr.fandenatech.ndjangui.util.ActionKeys;
import cmr.fandenatech.ndjangui.util.PortletKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.ActionCommand;

public class EditSittingActionCommand implements ActionCommand {

	@Override
	public boolean processCommand(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortletException {
		
		String cmd = ParamUtil.getString(portletRequest, Constants.CMD);
		if(cmd.equals(Constants.ADD)){
			try {
				addSitting(portletRequest, portletResponse);
				setRedirectPage(portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(Constants.UPDATE)){
			try {
				updateSitting(portletRequest, portletResponse);
				setRedirectPage(portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(Constants.DELETE)){
			
			try {
				removeSitting(portletRequest, portletResponse);
				setRedirectPage(portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	
		else if(cmd.equals(ActionKeys.ADD_SITTING_MEMBER)){
			
			try {
				addSittingMember(portletRequest, portletResponse);	
				setSittingMemberRedirectPage(portletRequest,portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		else if(cmd.equals(ActionKeys.REMOVE_SITTING_MEMBER)){
			
			try {
				removeSittingMember(portletRequest, portletResponse);	
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		else if(cmd.equals(ActionKeys.OPEN_SITTING)){
			
			try {
				openSitting(portletRequest, portletResponse);	
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		return false;
	}
	
	private void addSitting(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Sitting.class.getName(), portletRequest);
		String name = ParamUtil.getString(portletRequest, "name");
		String notes = ParamUtil.getString(portletRequest, "notes");
		String dayPlan = ParamUtil.getString(portletRequest, "dayPlan");
		
		SittingServiceUtil.addSitting(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), name, dayPlan, notes, serviceContext);
	}
	
	private void updateSitting(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long sittingId = ParamUtil.getLong(portletRequest, "sittingId");
		String name = ParamUtil.getString(portletRequest, "name");
		String notes = ParamUtil.getString(portletRequest, "notes");
		String dayPlan = ParamUtil.getString(portletRequest, "dayPlan");
		
		SittingServiceUtil.updateSitting(themeDisplay.getUserId(), sittingId, name, dayPlan, notes);
	}
	private void removeSitting(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortalException, SystemException{
		
		long sittingId = ParamUtil.getLong(portletRequest, "sittingId");
		
		SittingServiceUtil.removeSitting(sittingId);
	}
	private void addSittingMember(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long sittingId = ParamUtil.getLong(portletRequest, "sittingId");
		long[] memberIds = ParamUtil.getLongValues(portletRequest, "checked");
		for(long memberId : memberIds)
			MemberSittingLocalServiceUtil.addMemberSitting(themeDisplay.getScopeGroupId(), themeDisplay.getUserId() , memberId, sittingId);
	}
	private void removeSittingMember(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortalException, SystemException{
		
		
		long sittingId = ParamUtil.getLong(portletRequest, "sittingId");
		long memberSittingId = ParamUtil.getLong(portletRequest, "memberSittingId");
		
		MemberSittingLocalServiceUtil.deleteMemberSitting(memberSittingId);
		ActionResponse actionResponse = (ActionResponse)portletResponse;
		actionResponse.setRenderParameter("jspPage", "/html/sitting/create_or_update_sitting.jsp");
		actionResponse.setRenderParameter("sittingId",String.valueOf(sittingId));
		portletResponse = (PortletResponse) actionResponse;

	}
	private void setRedirectPage(PortletResponse portletResponse){
		ActionResponse actionResponse = (ActionResponse)portletResponse;
		actionResponse.setRenderParameter("toolbarItem", "sittings");
		portletResponse = (PortletResponse) actionResponse;
	
	}
	private void setSittingMemberRedirectPage(PortletRequest portletRequest, PortletResponse portletResponse){
		ActionResponse actionResponse = (ActionResponse)portletResponse;
		String sittingId = ParamUtil.getString(portletRequest, "sittingId");
		actionResponse.setRenderParameter("jspPage", "/html/currentsitting/view.jsp");
		actionResponse.setRenderParameter("sittingId", sittingId);
		actionResponse.setRenderParameter("toolbarItem", "presences");
		portletResponse = (PortletResponse) actionResponse;
	
	}
	private void openSitting(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws SystemException, NumberFormatException, PortalException{
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ActionResponse actionResponse = (ActionResponse)portletResponse;
		long sittingId = ParamUtil.getLong(portletRequest, "sittingId");
		SittingServiceUtil.openSitting(themeDisplay.getUserId(), sittingId);
		actionResponse.setRenderParameter("jspPage", "/html/sitting/sittings.jsp");
		actionResponse.setRenderParameter("sittingId", String.valueOf(sittingId));

		PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);
		portalPreferences.setUserId(themeDisplay.getUserId());
		portalPreferences.setValue(PortletKeys.CURRENT_SITTING_PORTLET, "currentSittingId", String.valueOf(sittingId));		
		portletResponse = (PortletResponse) actionResponse;
	
	}



}
