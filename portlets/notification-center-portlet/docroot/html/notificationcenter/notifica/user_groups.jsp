
<%@ include file="../init.jsp"%>



<%
	Notifica notifica = currentNotifica;
%>

<%
	List<UserGroup> userGroups= UserGroupLocalServiceUtil.getUserGroups( StringUtil.split(notifica.getGroupsIds(), 0L));
%>

<liferay-util:buffer var="removeUserGroupIcon">
	<liferay-ui:icon
		image="unlink"
		label="<%= true %>"
		message="remove"
	/>
</liferay-util:buffer>

<h3><liferay-ui:message key="user-groups" /></h3>

<liferay-ui:search-container
	headerNames="name,null"
>
	<liferay-ui:search-container-results
		results="<%= userGroups %>"
		total="<%= userGroups.size() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.UserGroup"
		escapedModel="<%= true %>"
		keyProperty="userGroupId"
		modelVar="userGroup"
	>
		<liferay-ui:search-container-column-text
			name="name"
			property="name"
		/>

	
		<liferay-ui:search-container-column-text>
			<a class="modify-link" data-rowId="<%= userGroup.getUserGroupId() %>" href="javascript:;"><%= removeUserGroupIcon %></a>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="<%= false %>" />
</liferay-ui:search-container>


<br />

	<liferay-ui:icon
		cssClass="modify-link"
		iconCssClass="icon-search"
		id="openUserGroupsLink"
		label="<%= true %>"
		linkCssClass="btn"
		message="select"
		url="javascript:;"
	/>

	<liferay-portlet:renderURL var="selectUserGroupURL" 
		windowState="<%= LiferayWindowState.POP_UP.toString() %>" 
	  portletName="<%=PortletKeys.USERS_ADMIN %>">
		<portlet:param name="struts_action" value="/users_admin/select_user_group" />
		<portlet:param name="eventName" value='<%=  renderResponse.getNamespace() + "selectUserGroup" %>' />
	</liferay-portlet:renderURL>

	<aui:script use="aui-base,escape">
		A.one('#<portlet:namespace />openUserGroupsLink').on(
			'click',
			function(event) {
				Liferay.Util.selectEntity(
					{
						dialog: {
							constrain: true,
							modal: true,
							width: 680
						},
						eventName : '<portlet:namespace />selectUserGroup',
						id: '<portlet:namespace />selectUserGroup',
						title: '<liferay-ui:message arguments="user-group" key="select-x" />',
						uri: '<%= selectUserGroupURL.toString() %>'
					},
					function(event) {
						var A = AUI();

						var searchContainer = Liferay.SearchContainer.get('<portlet:namespace />userGroupsSearchContainer');

						var rowColumns = [];

						rowColumns.push(A.Escape.html(event.usergroupname));
						rowColumns.push('<a class="modify-link" data-rowId="' + event.usergroupid + '" href="javascript:;"><%= UnicodeFormatter.toString(removeUserGroupIcon) %></a>');

						searchContainer.addRow(rowColumns, event.usergroupid);
						searchContainer.updateDataStore();
					}
				);
			}
		);
	</aui:script>



<aui:script use="liferay-search-container">
	var searchContainer = Liferay.SearchContainer.get('<portlet:namespace />userGroupsSearchContainer');

	searchContainer.get('contentBox').delegate(
		'click',
		function(event) {
			var link = event.currentTarget;
			var tr = link.ancestor('tr');

			searchContainer.deleteRow(tr, link.getAttribute('data-rowId'));
		},
		'.modify-link'
	);
</aui:script>
