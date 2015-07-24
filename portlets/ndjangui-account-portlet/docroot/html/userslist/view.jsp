<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.service.PortletLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>

<%@include file="/html/init.jsp"  %>
<%
	List<Organization> orgs = OrganizationLocalServiceUtil.getUserOrganizations(user.getUserId());

	
	List<User> users = null;
	
	if(!orgs.isEmpty() && orgs.size()>0)
		
				users =	UserLocalServiceUtil.getOrganizationUsers(orgs.get(0).getOrganizationId());
	if(!users.isEmpty() && users.size() > 0)
		users.remove(user);

	int count = !users.isEmpty()? users.size():0;
	
%>
<h5><liferay-ui:message key="users-list"/></h5>


<liferay-ui:search-container delta="10"  iteratorURL="<%=portletURL %>">


	<liferay-ui:search-container-results 
		results="<%= users%>"
		total="<%= count %>"
	/>

	<liferay-ui:search-container-row
		className = "com.liferay.portal.model.User"
		modelVar="selectedUser"
	>
	<liferay-ui:search-container-column-text property="firstName" />
	<liferay-ui:search-container-column-text property="lastName" />
	<liferay-ui:search-container-column-text property="screenName" />
	<liferay-ui:search-container-column-text
				name="userStatus">
			
			
			<%
			String statusMessage =
							WorkflowConstants.getStatusLabel(selectedUser.getStatus());
			%>
				
			
			<div class="taglib-workflow-status">
				
				<strong class='label <%= selectedUser.getStatus() == WorkflowConstants.STATUS_APPROVED ?  "label-success" : "label-warning" %> workflow-value workflow-status-<%=  statusMessage %>'><liferay-ui:message key="<%= statusMessage %>" /></strong>
				
			</div>
		</liferay-ui:search-container-column-text>
	
	<liferay-ui:search-container-column-jsp path="/html/userslist/user_action.jsp"></liferay-ui:search-container-column-jsp>
		
	</liferay-ui:search-container-row>
	
	

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
