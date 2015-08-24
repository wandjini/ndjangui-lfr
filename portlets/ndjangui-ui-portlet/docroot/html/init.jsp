
<%@page import="cmr.fandenatech.ndjangui.service.SittingLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.Sitting"%>
<%@page import="cmr.fandenatech.ndjangui.service.BudgetPeriodLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.BudgetPeriod"%>
<%@page import="cmr.fandenatech.ndjangui.util.PortletKeys"%>
<%@page import="com.liferay.portlet.PortalPreferences"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>

<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.Format"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>

<%@page import="com.liferay.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.service.ListTypeServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.model.ListType"%>
<%@page import="com.liferay.portal.service.persistence.ListTypeUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.Set"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.permission.UserPermissionUtil"%>
<%@page import="cmr.fandenatech.ndjangui.util.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>

<%
String currentURL = PortalUtil.getCurrentURL(renderRequest);

String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL", redirect);


Format formatDateTimeFormat = FastDateFormatFactoryUtil.getDate(Locale.FRENCH);


NumberFormat doubleFormat = NumberFormat.getNumberInstance(locale);

doubleFormat.setMaximumFractionDigits(3);
doubleFormat.setMinimumFractionDigits(3);

PortletURL portletURL = renderResponse.createRenderURL();


PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(request);
String currentBudgetPeriodId = portalPreferences.getValue(PortletKeys.ADMIN_PORTLET, "currentBudgetPeriodId","0");
BudgetPeriod currentBudgetPeriod = null;
try{
	if(!currentBudgetPeriodId.equals("0"))
		currentBudgetPeriod = BudgetPeriodLocalServiceUtil.getBudgetPeriod(Long.valueOf(currentBudgetPeriodId));
}catch(Exception e){}

String currentSittingId = portalPreferences.getValue(PortletKeys.CURRENT_SITTING_PORTLET, "currentSittingId","0");
Sitting currentSitting = null;
try{
	if(!currentSittingId.equals("0"))
		currentSitting = SittingLocalServiceUtil.getSitting(Long.valueOf(currentSittingId));
}catch(Exception e){}

long companyId = company.getCompanyId();
long organizationId=0l;

 %>