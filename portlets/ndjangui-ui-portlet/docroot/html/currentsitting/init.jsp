<%@include file="/html/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<portlet:renderURL var="createNewOperationURL">
	<portlet:param name="mvcPath" value="/html/currentsitting/operation/create_or_update_operation.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="createNewSanctionURL">
	<portlet:param name="mvcPath" value="/html/currentsitting/sanction/create_or_update_sanction.jsp"/>
</portlet:renderURL>


<portlet:renderURL var = "contributionsURL">

	<portlet:param name="mvcPath" value="/html/currentsitting/view.jsp"/>
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
	<portlet:param name="toolbarItem" value="contributions"/>
	
</portlet:renderURL>

<portlet:renderURL var = "sanctionsURL">

	<portlet:param name="mvcPath" value="/html/currentsitting/view.jsp"/>
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
	<portlet:param name="toolbarItem" value="sanctions"/>
	
</portlet:renderURL>
<portlet:renderURL var = "presencesURL">

	<portlet:param name="mvcPath" value="/html/currentsitting/view.jsp"/>
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
	<portlet:param name="toolbarItem" value="presences"/>
	
</portlet:renderURL>

<portlet:renderURL var = "eventsURL">

	<portlet:param name="mvcPath" value="/html/currentsitting/view.jsp"/>
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
	<portlet:param name="toolbarItem" value="events"/>
	
</portlet:renderURL>

