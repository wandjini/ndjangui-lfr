

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);


	User user2 = (User) row.getObject();
	long userId = user2!=null ? user2.getUserId():0l;
	
	
	
%>


	<%
	boolean hasUpdatePermission = UserPermissionUtil.contains(permissionChecker, userId, ActionKeys.UPDATE);
	%>

	
	
	
	<c:if test="<%= hasUpdatePermission %>">
		<liferay-portlet:renderURL var="editUserURL"  >
			<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
		</liferay-portlet:renderURL>
		
		<a href="<%= editUserURL %>" class="icon-edit icon"  title="<liferay-ui:message key='edit'/>"></a>
			
		
	</c:if>
	<c:if test="<%= UserPermissionUtil.contains(permissionChecker, userId, ActionKeys.DELETE) %>">
		<c:if test="<%= !user2.isActive() %>">
			<portlet:actionURL name="restoreUser"  var="restoreUserURL">
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.RESTORE %>" />
				<portlet:param name="userId" value="<%= String.valueOf(userId) %>" />
				
			</portlet:actionURL>

			<a href="<%= restoreUserURL %>" class="icon icon-plus-sign"  title="<liferay-ui:message key='unlock'/>"></a>

		</c:if>
		
		<portlet:actionURL name="deleteUser" var="deleteUserURL">
			<portlet:param name="<%= Constants.CMD %>" value="<%= user2.isActive() ? Constants.DEACTIVATE : Constants.DELETE %>" />
			<portlet:param name="userId" value="<%= String.valueOf(userId) %>" />
		</portlet:actionURL>
		<c:if test="<%= userId != user.getUserId() %>">
			<c:choose>
				<c:when test="<%= user2.isActive() %>">
					<a href="<%= deleteUserURL %>" class="icon-lock icon"  title="<liferay-ui:message key='lock'/>"></a>
				</c:when>
				
			</c:choose>
		</c:if>
		
	</c:if>
