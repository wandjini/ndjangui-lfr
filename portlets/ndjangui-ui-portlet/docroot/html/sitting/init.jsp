<%@ include file="/html/init.jsp"%>
<%@page import="cmr.fandenatech.ndjangui.service.SittingLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.service.SittingServiceUtil"%>
<portlet:renderURL var="createNewSittingURL">
	<portlet:param name="mvcPath" value="/html/sitting/create_or_update_sitting.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="sittingsURL">
	<portlet:param name="mvcPath" value="/html/sitting/view.jsp"/>
	<portlet:param name="toolbarItem" value="sittings"/>
</portlet:renderURL>

<portlet:renderURL var="sittingURL">
	<portlet:param name="mvcPath" value="/html/sitting/view.jsp"/>
</portlet:renderURL>