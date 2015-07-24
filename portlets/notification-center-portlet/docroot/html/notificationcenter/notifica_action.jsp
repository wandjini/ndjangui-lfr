<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	Notifica notifica = (Notifica) row.getObject();
%>


<liferay-ui:icon-menu>
	<c:if test="<%=NotificaPermission.contains(permissionChecker, notifica, ActionKeys.UPDATE)%>">
		
		<portlet:renderURL var="editNotificaURL">
			<portlet:param name="notificaId" value="<%= String.valueOf(notifica.getNotificaId()) %>" />
			<portlet:param name="mvcPath" value="/html/notificationcenter/edit_notifica.jsp" />
			<portlet:param name="redirect" value="<%= notificationCenterURL %>" />
			<portlet:param name="backURL" value="<%= notificationCenterURL %>" />
			
		</portlet:renderURL>
				
		<liferay-ui:icon
			image="edit"
			url="<%=editNotificaURL.toString()%>"
		/>
		
		
	</c:if>
	<c:if test="<%=NotificaPermission.contains(permissionChecker, notifica, ActionKeys.DELETE)%>">
		
		<portlet:actionURL name="updateNotifica" var="deleteNotificaURL">
			<portlet:param  name="<%=Constants.CMD%>" value="<%= Constants.DELETE %>" />
			<portlet:param  name="redirect" value="<%=currentURL%>" />
			<portlet:param  name="notificaId" value="<%= String.valueOf(notifica.getNotificaId()) %>" />
			<portlet:param name="mvcPath"
				value="/html/notificationcenter/edit_notifica.jsp" />
		</portlet:actionURL>
	
				
		<liferay-ui:icon-delete
			url="<%=deleteNotificaURL.toString()%>"
		/>
		
		
	</c:if>
	
</liferay-ui:icon-menu>