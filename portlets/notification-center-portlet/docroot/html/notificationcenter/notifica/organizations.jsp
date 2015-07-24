
<%@page import="com.xpiping.notificationcenter.util.NotificationCenterUtils"%>
<%@ include file="../init.jsp" %>


<%
	Notifica notifica = currentNotifica;
	
	List<Role> roles = RoleLocalServiceUtil.getRoles( StringUtil.split(notifica.getRolesIds(), 0L));

	String[] organizationsIdsNames = new String[] {
		StringPool.BLANK, StringPool.BLANK
	};
	
	

	if (notifica != null) {
		organizationsIdsNames =
			NotificationCenterUtils.getOrganizationsIdsNames(notifica.getOrgsIds());
	}

	String[] organizationsNames =
		StringUtil.split(
			organizationsIdsNames[1], WebKeys.ORGANIZATON_SEPARATOR);


%>


<h3><liferay-ui:message key="organizations" /></h3>

<aui:field-wrapper label="organizations">
	<div class="lfr-tags-selector-content"
		id="<%=renderResponse.getNamespace()%>assetOrganizationsSelector">
		<aui:input name="organizationsIds" type="hidden" />
	</div>
</aui:field-wrapper>

<%if(notifica != null) %>
<aui:script use="liferay-organization-selector">
	new Liferay.OrganizationsSelector(
	{
		className: '<%=Organization.class.getName()%>',
		contentBox: '#<%=renderResponse.getNamespace()%>assetOrganizationsSelector',
		curEntries: '<%=HtmlUtil.escapeJS(organizationsIdsNames[1])%>',
		curEntryIds: '<%=organizationsIdsNames[0]%>',
		hiddenInput: '#<%=renderResponse.getNamespace()%>organizationsIds',
		instanceVar: '<%=renderResponse.getNamespace()%>',
		portalModelResource: true,
		topOrganizationId: 0
	}).render();

</aui:script>
<% %>
