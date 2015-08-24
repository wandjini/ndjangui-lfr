package cmr.fandenatech.ndjangui.portlet.action;

import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import cmr.fandenatech.ndjangui.model.Fund;
import cmr.fandenatech.ndjangui.model.SanctionType;
import cmr.fandenatech.ndjangui.service.SanctionTypeServiceUtil;
import cmr.fandenatech.ndjangui.util.ActionKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.ActionCommand;

public class EditSanctionTypeActionCommand implements ActionCommand {

	@Override
	public boolean processCommand(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortletException {
			String cmd = ParamUtil.getString(portletRequest, Constants.CMD);
		
		if(cmd.equals(ActionKeys.ADD_SANCTION_TYPE)){
			try {
				addSanctionType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(Constants.UPDATE)){
			try {
				updateSanctionType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		else if(cmd.equals(ActionKeys.DISABLE_SANCTION_TYPE)){
			try {
				disableSanctionType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(ActionKeys.ENABLE_SANCTION_TYPE)){
			try {
				enableSanctionType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(ActionKeys.DELETE)){
			try {
				enableSanctionType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(ActionKeys.DELETE_SANCTION_TYPE)){
			try {
				deleteSanctionType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		setRedirectPage(portletResponse);
		return false;
	}
	
	protected void addSanctionType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(SanctionType.class.getName(),
			            portletRequest);
		String name = ParamUtil.getString(portletRequest, "name");
		String shortDescription = ParamUtil.getString(portletRequest, "shortDescription");
		double amount = ParamUtil.getDouble(portletRequest, "amount");
		SanctionTypeServiceUtil.addSanctionType(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), 
				name, shortDescription, amount,serviceContext);
	}

	protected void updateSanctionType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(SanctionType.class.getName(),
			            portletRequest);
		long sanctionTypeId = ParamUtil.getLong(portletRequest, "sanctionTypeId");
		String name = ParamUtil.getString(portletRequest, "name");
		String shortDescription = ParamUtil.getString(portletRequest, "shortDescription");
		double amount = ParamUtil.getDouble(portletRequest, "amount");
		SanctionTypeServiceUtil.updateSanctionType(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), 
				sanctionTypeId, name, shortDescription,amount, serviceContext);
	}
	protected void disableSanctionType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long sanctionTypeId = ParamUtil.getLong(portletRequest, "sanctionTypeId");
		SanctionTypeServiceUtil.updateSanctionTypeStatus(themeDisplay.getUserId(), sanctionTypeId, WorkflowConstants.STATUS_INACTIVE);
	}
	protected void enableSanctionType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long sanctionTypeId = ParamUtil.getLong(portletRequest, "sanctionTypeId");
		SanctionTypeServiceUtil.updateSanctionTypeStatus(themeDisplay.getUserId(), sanctionTypeId, WorkflowConstants.STATUS_APPROVED);
	}

	protected void deleteSanctionType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		long sanctionTypeId = ParamUtil.getLong(portletRequest, "sanctionTypeId");
		SanctionTypeServiceUtil.deleSanctionType( sanctionTypeId);
	}
	private void setRedirectPage(PortletResponse portletResponse){
		ActionResponse actionResponse = (ActionResponse)portletResponse;
		actionResponse.setRenderParameter("toolbarItem", "sanction_types");
		portletResponse = (PortletResponse) actionResponse;

	}

}
