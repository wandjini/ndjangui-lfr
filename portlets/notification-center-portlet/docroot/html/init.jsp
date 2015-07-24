<%@page import="com.xpiping.notificationcenter.service.NotificaTypeServiceUtil"%>
<%@page import="com.xpiping.notificationcenter.model.NotificaType"%>
<%@page import="com.xpiping.notificationcenter.util.WebKeys"%>
<%@page import="java.text.Format"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>

<%@page import="javax.portlet.PortletURL"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>


<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@ page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.liferay.portal.model.Organization"%>
<%@ page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil"%>

<%@page import="com.xpiping.notificationcenter.util.ActionKeys"%>
<%@page import="com.xpiping.notificationcenter.model.Notifica"%>

<%@page import="com.xpiping.notificationcenter.permission.NotificaPermission"%>
<%@page import="com.xpiping.notificationcenter.permission.NotificaTypePermission"%>
<%@page import="com.xpiping.notificationcenter.permission.NotificationCenterPermission"%>
<%@page import="com.xpiping.notificationcenter.service.NotificaServiceUtil"%>


<%@page import="com.liferay.portal.model.UserGroup"%>
<%@page import="com.xpiping.notificationcenter.util.PortletKeys"%>
<%@page import="com.liferay.portal.service.UserGroupLocalServiceUtil"%>

<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.rolesadmin.util.RolesAdminUtil"%>
<%@page import="com.liferay.portal.model.Role"%>


<%@page import="com.xpiping.notificationcenter.model.QueuedEmail"%>

<portlet:defineObjects />

<liferay-theme:defineObjects />


<%
String currentURL = PortalUtil.getCurrentURL(renderRequest);

String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL", redirect);


Format formatDateTimeFormat = FastDateFormatFactoryUtil.getDate(locale);


NumberFormat doubleFormat = NumberFormat.getNumberInstance(locale);

doubleFormat.setMaximumFractionDigits(2);
doubleFormat.setMinimumFractionDigits(2);

PortletURL portletURL = renderResponse.createRenderURL();


long companyId = company.getCompanyId();

Notifica currentNotifica = (Notifica) request.getAttribute(WebKeys.NOTIFICA);

long notificaId = 0;

if (currentNotifica != null) {
	notificaId = currentNotifica.getNotificaId();
}
else{
	notificaId = GetterUtil.getLong(request.getAttribute("notificaId"));
	
	if(notificaId > 0){
		currentNotifica = NotificaServiceUtil.getNotifica(notificaId);
	}
	
}


NotificaType currentNotificaType = (NotificaType) request.getAttribute(WebKeys.NOTIFICA_TYPE);

long notificaTypeId = 0;

if (currentNotificaType != null) {
	notificaTypeId = currentNotificaType.getNotificaTypeId();
}
else{
	notificaTypeId = GetterUtil.getLong(request.getAttribute("notificaTypeId"));
	
	if(notificaTypeId > 0){
		currentNotificaType = NotificaTypeServiceUtil.getNotificaType(notificaTypeId);
	}
	
}




 %>

<portlet:renderURL var="notificationCenterURL">
	<portlet:param name="mvcPath" value="/html/notificationcenter/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="notificaTypeURL">
	<portlet:param name="mvcPath" value="/html/notificatype/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="queuedEmailURL">
	<portlet:param name="mvcPath" value="/html/queuedemail/view.jsp" />
</portlet:renderURL>