<%@ include file="/html/init.jsp"%>

<portlet:renderURL var="createNewMemberURL">
	<portlet:param name="mvcPath" value="/html/members/create_or_update_member.jsp"/>
</portlet:renderURL>

<portlet:renderURL var = "activeMembersURL">

	<portlet:param name="mvcPath" value="/html/members/view.jsp"/>
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
	<portlet:param name="toolbarItem" value="active"/>
	
</portlet:renderURL>

<liferay-portlet:renderURL var="lockedMembersURL" >
	<portlet:param name="mvcPath" value="/html/members/view.jsp"/>
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
	<portlet:param name="toolbarItem" value="lock"/>
</liferay-portlet:renderURL>

