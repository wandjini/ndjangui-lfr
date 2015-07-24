
<%@ include file="init.jsp"%>


<%
	String organizationName =
		ParamUtil.getString(request, "organizationName");

	Organization organization =
		OrganizationLocalServiceUtil.getOrganization(
			companyId, organizationName.trim());

	if(organization == null)
	{
	  	%>
	  		<h2>Organizzazione non trovata</h2>
	  	<%    
     }
	else{
	
	List<Organization> parentOrganizations =
		OrganizationLocalServiceUtil.getParentOrganizations(organization.getOrganizationId());
	
%>


<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%= parentOrganizations %>"
		total="<%= parentOrganizations.size() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.Organization"
		modelVar="organization2"
	>
		<liferay-ui:search-container-column-text
			name="name"
			property="name"
		/>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="<%= false %>" />
</liferay-ui:search-container>
<% }%>


