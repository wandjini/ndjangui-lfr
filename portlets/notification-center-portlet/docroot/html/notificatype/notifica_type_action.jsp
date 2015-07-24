
<%@ include file="init.jsp" %>


<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	NotificaType notificaType = (NotificaType) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if test="<%=NotificaTypePermission.contains(permissionChecker, notificaType, ActionKeys.UPDATE)%>">
		
		<portlet:renderURL var="editNotificaTypeURL">
			<portlet:param name="notificaTypeId" value="<%= String.valueOf(notificaType.getNotificaTypeId()) %>" />
			<portlet:param name="mvcPath" value="/html/notificatype/edit_notifica_type.jsp" />
			<portlet:param name="redirect" value="<%= notificaTypeURL %>" />
			<portlet:param name="backURL" value="<%= notificaTypeURL %>" />
			
		</portlet:renderURL>
				
		<liferay-ui:icon
			image="edit"
			url="<%=editNotificaTypeURL.toString()%>"
		/>
		
		
	</c:if>

	
</liferay-ui:icon-menu>