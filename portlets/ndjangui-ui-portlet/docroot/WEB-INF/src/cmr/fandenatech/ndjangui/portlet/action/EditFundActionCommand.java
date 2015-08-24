package cmr.fandenatech.ndjangui.portlet.action;

import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import cmr.fandenatech.ndjangui.model.Fund;
import cmr.fandenatech.ndjangui.service.FundServiceUtil;
import cmr.fandenatech.ndjangui.service.MemberFundServiceUtil;
import cmr.fandenatech.ndjangui.util.ActionKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.ActionCommand;

public class EditFundActionCommand implements ActionCommand {

	@Override
	public boolean processCommand(PortletRequest portletRequest, PortletResponse portletResponse)
			throws PortletException {
		String cmd = ParamUtil.getString(portletRequest, Constants.CMD);
		if(cmd.equals(Constants.ADD)){
			try {
				addFund(portletRequest, portletResponse);
				setRedirectPage(portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(Constants.UPDATE)){
			try {
				updateFund(portletRequest, portletResponse);
				setRedirectPage(portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equals(Constants.DELETE)){
			
			try {
				removeFund(portletRequest, portletResponse);
				setRedirectPage(portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}

		else if(cmd.equals(ActionKeys.ADD_FUND_MEMBER)){
			
			try {
				addFundMember(portletRequest, portletResponse);	
				setFundMemberRedirectPage(portletRequest,portletResponse);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		else if(cmd.equals(ActionKeys.REMOVE_FUND_MEMBER)){
			
			try {
				removeFundMember(portletRequest, portletResponse);	
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		return false;
	}

	private void addFund(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Fund.class.getName(), portletRequest);
		long fundTypeId = ParamUtil.getLong(portletRequest, "fundTypeId");
		String name = ParamUtil.getString(portletRequest, "name");
		String shortDescription = ParamUtil.getString(portletRequest, "shortDescription");
		long budgetPeriodId = ParamUtil.getLong(portletRequest, "budgetPeriodId");
		
		FundServiceUtil.addFund(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), name, budgetPeriodId, 
				fundTypeId, shortDescription, serviceContext);
	}
	
	private void updateFund(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Fund.class.getName(), portletRequest);
		long fundId = ParamUtil.getLong(portletRequest, "fundId");
		long fundTypeId = ParamUtil.getLong(portletRequest, "fundTypeId");
		String name = ParamUtil.getString(portletRequest, "name");
		String shortDescription = ParamUtil.getString(portletRequest, "shortDescription");
		long budgetPeriodId = ParamUtil.getLong(portletRequest, "budgetPeriodId");
		
		FundServiceUtil.updateFund(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),fundId, name, budgetPeriodId, 
				fundTypeId, shortDescription, serviceContext);
	}
	private void removeFund(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Fund.class.getName(), portletRequest);
		long fundId = ParamUtil.getLong(portletRequest, "fundId");
		
		FundServiceUtil.deleteFund(themeDisplay.getUserId(), fundId);
	}
	private void addFundMember(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortalException, SystemException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long fundId = ParamUtil.getLong(portletRequest, "fundId");
		long memberId = ParamUtil.getLong(portletRequest, "memberId");
		MemberFundServiceUtil.addMemberFund(themeDisplay.getScopeGroupId(), themeDisplay.getUserId() , memberId, fundId);
	}
	private void removeFundMember(PortletRequest portletRequest, PortletResponse portletResponse) 
			throws PortalException, SystemException{
		
		
		long fundId = ParamUtil.getLong(portletRequest, "fundId");
		long memberFundId = ParamUtil.getLong(portletRequest, "memberFundId");
		
		MemberFundServiceUtil.removeMemberFund(memberFundId, fundId);
		ActionResponse actionResponse = (ActionResponse)portletResponse;
		actionResponse.setRenderParameter("jspPage", "/html/admin/fund/create_fund.jsp");
		actionResponse.setRenderParameter("fundId",String.valueOf(fundId));
		portletResponse = (PortletResponse) actionResponse;

	}
	private void setRedirectPage(PortletResponse portletResponse){
		ActionResponse actionResponse = (ActionResponse)portletResponse;
		actionResponse.setRenderParameter("toolbarItem", "funds");
		portletResponse = (PortletResponse) actionResponse;

	}
	private void setFundMemberRedirectPage(PortletRequest portletRequest, PortletResponse portletResponse){
		String fundId = ParamUtil.getString(portletRequest, "fundId");
		ActionResponse actionResponse = (ActionResponse)portletResponse;
		actionResponse.setRenderParameter("jspPage", "/html/admin/fund/members_list.jsp");
		actionResponse.setRenderParameter("fundId", fundId);
		//actionResponse.setRenderParameters(portletRequest.getParameterMap());
		portletResponse = (PortletResponse) actionResponse;
		
	}
}
