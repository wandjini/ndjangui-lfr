

<%@page import="com.xpiping.notificationcenter.service.NotificaLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ include file="../init.jsp"%>



<%
	Notifica notifica = currentNotifica;
%>

<%
	List<User> users= NotificaLocalServiceUtil.getUsersPerNotifica(notificaId);
%>

<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%= users %>"
		total="<%= users.size() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.User"
		modelVar="user2"
	>
		<liferay-ui:search-container-column-text
			name="first-name"
			orderable="<%= true %>"
			property="firstName"
		/>

		<liferay-ui:search-container-column-text
			name="last-name"
			orderable="<%= true %>"
			property="lastName"
		/>
		<liferay-ui:search-container-column-text
					name="organizations">
			<liferay-ui:write bean="<%= user2 %>" property="organizations" />
		</liferay-ui:search-container-column-text>
				
		<liferay-ui:search-container-column-text
			name="user-groups"
		>
			<liferay-ui:write bean="<%= user2 %>" property="user-groups" />
		</liferay-ui:search-container-column-text>
		
		
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="<%= false %>" />
</liferay-ui:search-container>
<aui:script use="liferay-search-container">
	var searchContainer = Liferay.SearchContainer.get('<portlet:namespace />usersSearchContainer');

	
	searchContainer.get('contentBox').delegate(
		'click',
		function(event) {
			var link = event.currentTarget;
			
			showOrganizationDetail(link.html());
		},
		'.col-organizations'
	);
</aui:script>

<aui:script>

Liferay.provide(
	window,
	'showOrganizationDetail',
	function(name) {
		
		AUI().use('liferay-portlet-url','aui-modal', 'aui-io', function(A) {
			
			
		
		var renderURL = Liferay.PortletURL.createRenderURL();
			
		renderURL.setParameter("mvcPath", "/html/notificationcenter/organization_detail.jsp");
		renderURL.setParameter("organizationName", name);
		renderURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId()%>');
		
		renderURL.setWindowState('<%= LiferayWindowState.POP_UP.toString() %>');
		var dialog = new A.Modal(
			{
				centered: true,
	            height: 250,
	            title: name,
	            modal:true,
	            width: 500,
	            destroyOnClose: true
			}
		).plug(
			A.Plugin.IO,
				{
					uri: renderURL.toString()
				}
		).render();
		
		});
	},
	['aui-modal']
); 
</aui:script>
<style>
	.col-organizations
	{
       cursor: pointer;
     }
</style>