<%@ include file="../init.jsp" %>


<%
	Notifica notifica = currentNotifica;
	
	List<Role> roles = RoleLocalServiceUtil.getRoles( StringUtil.split(notifica.getRolesIds(), 0L));
%>

<liferay-util:buffer var="removeRoleIcon">
	<liferay-ui:icon
		image="unlink"
		label="<%= true %>"
		message="remove"
	/>
</liferay-util:buffer>

<h3><liferay-ui:message key="regular-roles" /></h3>

<liferay-ui:search-container
	headerNames="title,null"
	id="rolesSearchContainer"
>
	<liferay-ui:search-container-results
		results="<%= roles %>"
		total="<%= roles.size() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.Role"
		keyProperty="roleId"
		modelVar="role"
	>
		<liferay-util:param name="className" value="<%= RolesAdminUtil.getCssClassName(role) %>" />
		<liferay-util:param name="classHoverName" value="<%= RolesAdminUtil.getCssClassName(role) %>" />

		<liferay-ui:search-container-column-text
			name="title"
			value="<%= HtmlUtil.escape(role.getTitle(locale)) %>"
		/>

		
		<liferay-ui:search-container-column-text>
			<a class="modify-link" data-rowId="<%= role.getRoleId() %>" href="javascript:;"><%= removeRoleIcon %></a>
		</liferay-ui:search-container-column-text>
	
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="<%= false %>" />
</liferay-ui:search-container>


<liferay-ui:icon
	cssClass="modify-link"
	image="add"
	label="<%= true %>"
	message="select"
	url='<%= "javascript:" + renderResponse.getNamespace() + "openRegularRoleSelector();" %>'
/>

<aui:script>


	function <portlet:namespace />openRegularRoleSelector() {
		<portlet:namespace />openRoleSelector('<liferay-portlet:renderURL portletName="<%=PortletKeys.USERS_ADMIN %>" windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="struts_action" value="/users_admin/select_regular_role" /></liferay-portlet:renderURL>');
	}

	function <portlet:namespace />openRoleSelector(url) {
		var roleWindow = window.open(url, 'role', 'directories=no,height=640,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=680');

		roleWindow.focus();
	}

	Liferay.provide(
		window,
		'_<%=PortletKeys.USERS_ADMIN %>_selectRole',
		function(roleId, name, searchContainer, groupName, groupId) {
			var A = AUI();

			var searchContainerName = '<portlet:namespace />' + searchContainer + 'SearchContainer';

			searchContainer = Liferay.SearchContainer.get(searchContainerName);

			var rowColumns = [];

			rowColumns.push(name);

			
			
			rowColumns.push('<a class="modify-link" data-rowId="' + roleId + '" href="javascript:;"><%= UnicodeFormatter.toString(removeRoleIcon) %></a>');
			

			searchContainer.addRow(rowColumns, roleId);
			searchContainer.updateDataStore();
		},
		['liferay-search-container']
	);
</aui:script>

<aui:script use="liferay-search-container">
	var searchContainer = Liferay.SearchContainer.get('<portlet:namespace />rolesSearchContainer');

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