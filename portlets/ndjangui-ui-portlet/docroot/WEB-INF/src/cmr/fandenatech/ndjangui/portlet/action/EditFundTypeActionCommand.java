package cmr.fandenatech.ndjangui.portlet.action;

import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import cmr.fandenatech.ndjangui.model.Fund;
import cmr.fandenatech.ndjangui.model.FundType;
import cmr.fandenatech.ndjangui.model.Member;
import cmr.fandenatech.ndjangui.service.FundTypeServiceUtil;
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

public class EditFundTypeActionCommand implements ActionCommand {

	@Override
	public boolean processCommand(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortletException {
		String cmd = ParamUtil.getString(portletRequest, Constants.CMD);
		
		if(cmd.equals(ActionKeys.ADD_FUND_TYPE)){
			try {
				addFundType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(Constants.UPDATE)){
			try {
				updateFundType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		else if(cmd.equals(ActionKeys.DISABLE_FUND_TYPE)){
			try {
				disableFundType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(ActionKeys.ENABLE_FUND_TYPE)){
			try {
				enableFundType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(ActionKeys.DELETE)){
			try {
				enableFundType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(ActionKeys.DELETE_FUND_TYPE)){
			try {
				deleteFundType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		setRedirectPage(portletResponse);
		return false;
	}
	
	protected void addFundType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(FundType.class.getName(),
			            portletRequest);
		String name = ParamUtil.getString(portletRequest, "name");
		String shortDescription = ParamUtil.getString(portletRequest, "shortDescription");
		FundTypeServiceUtil.addFundType(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), 
				name, shortDescription, serviceContext);
		ActionResponse actionResponse = (ActionResponse)portletResponse;
		actionResponse.setRenderParameter("toolbarItem", "fund_types");
		portletResponse = (PortletResponse) actionResponse;
	}

	protected void updateFundType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(Fund.class.getName(),
			            portletRequest);
		long fundTypeId = ParamUtil.getLong(portletRequest, "fundTypeId");
		String name = ParamUtil.getString(portletRequest, "name");
		String shortDescription = ParamUtil.getString(portletRequest, "shortDescription");
		FundTypeServiceUtil.updateFundType(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), 
				fundTypeId, name, shortDescription, serviceContext);
	}
	protected void disableFundType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long fundTypeId = ParamUtil.getLong(portletRequest, "fundTypeId");
		FundTypeServiceUtil.updateFundTypeStatus(themeDisplay.getUserId(), fundTypeId, WorkflowConstants.STATUS_INACTIVE);
	}
	protected void enableFundType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long fundTypeId = ParamUtil.getLong(portletRequest, "fundTypeId");
		FundTypeServiceUtil.updateFundTypeStatus(themeDisplay.getUserId(), fundTypeId, WorkflowConstants.STATUS_APPROVED);
	}

	protected void deleteFundType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		long fundTypeId = ParamUtil.getLong(portletRequest, "fundTypeId");
		FundTypeServiceUtil.deleFundType( fundTypeId);
	}
	
	private void setRedirectPage(PortletResponse portletResponse){
		ActionResponse actionResponse = (ActionResponse)portletResponse;
		actionResponse.setRenderParameter("toolbarItem", "fund_types");
		portletResponse = (PortletResponse) actionResponse;

	}
}
