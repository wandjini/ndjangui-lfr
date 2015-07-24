<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>
<%@ include file="init.jsp" %>


<%
String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view-all");
%>
<aui:nav-bar>
	<aui:nav>
		<aui:nav-item href="<%= notificationCenterURL %>" label="view-all" selected='<%= toolbarItem.equals("view-all")%>'/>
		
		<c:if test="<%= NotificationCenterPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ADD_NOTIFICA) %>">
			<portlet:renderURL var="addNotificaURL">
				<portlet:param name="mvcPath" value="/html/notificationcenter/edit_notifica.jsp" />
				<portlet:param name="redirect" value="<%= notificationCenterURL %>" />
				<portlet:param name="backURL" value="<%= notificationCenterURL %>" />
			</portlet:renderURL>
			<aui:nav-item  href="<%=addNotificaURL %>" label="add-notifica" selected='<%= toolbarItem.equals("add")%>'/>
		</c:if>
		
		
	</aui:nav>

</aui:nav-bar>	
