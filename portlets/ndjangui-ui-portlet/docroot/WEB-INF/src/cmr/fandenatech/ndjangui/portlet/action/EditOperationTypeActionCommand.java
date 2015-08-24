package cmr.fandenatech.ndjangui.portlet.action;

import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import cmr.fandenatech.ndjangui.model.Fund;
import cmr.fandenatech.ndjangui.model.OperationType;
import cmr.fandenatech.ndjangui.service.OperationTypeServiceUtil;
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

public class EditOperationTypeActionCommand implements ActionCommand {

	@Override
	public boolean processCommand(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortletException {
		
		String cmd = ParamUtil.getString(portletRequest, Constants.CMD);
		
		if(cmd.equals(ActionKeys.ADD_OPERATION_TYPE)){
			try {
				addOperationType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(Constants.UPDATE)){
			try {
				updateOperationType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		else if(cmd.equals(ActionKeys.DISABLE_OPERATION_TYPE)){
			try {
				disableOperationType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(ActionKeys.ENABLE_OPERATION_TYPE)){
			try {
				enableOperationType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(ActionKeys.DELETE)){
			try {
				enableOperationType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(ActionKeys.DELETE_OPERATION_TYPE)){
			try {
				deleteOperationType(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		setRedirectPage(portletResponse);
		return false;
	}
	
	protected void addOperationType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(OperationType.class.getName(),
			            portletRequest);
		String name = ParamUtil.getString(portletRequest, "name");
		String shortDescription = ParamUtil.getString(portletRequest, "shortDescription");
		OperationTypeServiceUtil.addOperationType(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), 
				name, shortDescription, serviceContext);
	}

	protected void updateOperationType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(OperationType.class.getName(),
			            portletRequest);
		long operationTypeId = ParamUtil.getLong(portletRequest, "operationTypeId");
		String name = ParamUtil.getString(portletRequest, "name");
		String shortDescription = ParamUtil.getString(portletRequest, "shortDescription");
		OperationTypeServiceUtil.updateOperationType(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), 
				operationTypeId, name, shortDescription, serviceContext);
	}
	protected void disableOperationType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long operationTypeId = ParamUtil.getLong(portletRequest, "fundTypeId");
		OperationTypeServiceUtil.updateOperationTypeStatus(themeDisplay.getUserId(), operationTypeId, WorkflowConstants.STATUS_INACTIVE);
	}
	protected void enableOperationType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long operationTypeId = ParamUtil.getLong(portletRequest, "operationTypeId");
		OperationTypeServiceUtil.updateOperationTypeStatus(themeDisplay.getUserId(), operationTypeId, WorkflowConstants.STATUS_APPROVED);
	}

	protected void deleteOperationType(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		long operationTypeId = ParamUtil.getLong(portletRequest, "operationTypeId");
		OperationTypeServiceUtil.deleOperationType( operationTypeId);
	}
	private void setRedirectPage(PortletResponse portletResponse){
		ActionResponse actionResponse = (ActionResponse)portletResponse;
		actionResponse.setRenderParameter("toolbarItem", "operation_types");
		portletResponse = (PortletResponse) actionResponse;

	}

}
