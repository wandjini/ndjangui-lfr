package cmr.fandenatech.ndjangui.portlet.action;

import java.util.Date;

import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

import cmr.fandenatech.ndjangui.model.Fund;
import cmr.fandenatech.ndjangui.model.BudgetPeriod;
import cmr.fandenatech.ndjangui.service.BudgetPeriodServiceUtil;
import cmr.fandenatech.ndjangui.util.ActionKeys;
import cmr.fandenatech.ndjangui.util.FormatUtil;
import cmr.fandenatech.ndjangui.util.PortletKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.ActionCommand;

public class EditBudgetPeriodActionCommand implements ActionCommand {

	@Override
	public boolean processCommand(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortletException {
		String cmd = ParamUtil.getString(portletRequest, Constants.CMD);
		
		if(cmd.equals(ActionKeys.ADD_BUDGET_PERIOD)){
			try {
				addBudgetPeriod(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(Constants.UPDATE)){
			try {
				updateBudgetPeriod(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		else if(cmd.equals(ActionKeys.CLOSE_BUDGET_PERIOD)){
			try {
				closeBudgetPeriod(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(ActionKeys.OPEN_BUDGET_PERIOD)){
			try {
				openBudgetPeriod(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(ActionKeys.DELETE)){
			try {
				openBudgetPeriod(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(ActionKeys.DELETE_BUDGET_PERIOD)){
			try {
				deleteBudgetPeriod(portletRequest, portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		setRedirectPage(portletResponse);
		return false;
	}
	
	protected void addBudgetPeriod(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(BudgetPeriod.class.getName(),
			            portletRequest);
		String name = ParamUtil.getString(portletRequest, "name");
		String shortDescription = ParamUtil.getString(portletRequest, "shortDescription");
		Date startDate = ParamUtil.getDate(portletRequest, "startDate", FormatUtil.getFormatDateTimeFormat(themeDisplay.getLocale()));
		Date endDate = ParamUtil.getDate(portletRequest, "endDate", FormatUtil.getFormatDateTimeFormat(themeDisplay.getLocale()));
		
		BudgetPeriodServiceUtil.addBudgetPeriod(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), 
				name, shortDescription,startDate, endDate, serviceContext);
	}

	protected void updateBudgetPeriod(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long budgetPeriodId = ParamUtil.getLong(portletRequest, "budgetPeriodId");
		String name = ParamUtil.getString(portletRequest, "name");
		String shortDescription = ParamUtil.getString(portletRequest, "shortDescription");
		Date startDate = ParamUtil.getDate(portletRequest, "startDate", FormatUtil.getFormatDateTimeFormat(themeDisplay.getLocale()));
		Date endDate = ParamUtil.getDate(portletRequest, "endDate", FormatUtil.getFormatDateTimeFormat(themeDisplay.getLocale()));
		
		BudgetPeriodServiceUtil.updateBudgetPeriod (themeDisplay.getUserId(), 
				budgetPeriodId, name, shortDescription, startDate, endDate);
	}
	protected void closeBudgetPeriod(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long budgetPeriodId = ParamUtil.getLong(portletRequest, "budgetPeriodId");
		BudgetPeriodServiceUtil.updateBudgetPeriodStatus(themeDisplay.getUserId(), budgetPeriodId, WorkflowConstants.STATUS_INACTIVE);
	}
	protected void openBudgetPeriod(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long budgetPeriodId = ParamUtil.getLong(portletRequest, "budgetPeriodId");
		BudgetPeriodServiceUtil.updateBudgetPeriodStatus(themeDisplay.getUserId(), budgetPeriodId, 1	);
		PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);
		portalPreferences.setUserId(themeDisplay.getUserId());
		portalPreferences.setValue(PortletKeys.ADMIN_PORTLET, "currentBudgetPeriodId", String.valueOf(budgetPeriodId));		
	}

	protected void deleteBudgetPeriod(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortalException, SystemException{
		
		long budgetPeriodId = ParamUtil.getLong(portletRequest, "budgetPeriodId");
		//BudgetPeriodServiceUtil.deleBudgetPeriod( budgetPeriodId);
	}
	private void setRedirectPage(PortletResponse portletResponse){
		ActionResponse actionResponse = (ActionResponse)portletResponse;
		actionResponse.setRenderParameter("toolbarItem", "budget_periods");
		portletResponse = (PortletResponse) actionResponse;

	}

}
