
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
		<aui:nav-item href="<%= notificaTypeURL %>" label="view-all" selected='<%= toolbarItem.equals("view-all")%>'/>
		
	<c:if test="<%= NotificationCenterPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ADD_NOTIFICA_TYPE) %>">
		<portlet:renderURL var="addNotificaTypeURL">
			<portlet:param name="mvcPath" value="/html/notificatype/edit_notifica_type.jsp" />
			<portlet:param name="redirect" value="<%= notificaTypeURL %>" />
			<portlet:param name="backURL" value="<%= notificaTypeURL %>" />
		</portlet:renderURL>
		<aui:nav-item  href="<%=addNotificaTypeURL %>" label="add-notifica-type" selected='<%= toolbarItem.equals("add")%>'/>
	</c:if>
		
		
	</aui:nav>

</aui:nav-bar>	
