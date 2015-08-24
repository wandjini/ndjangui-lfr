<%@page import="cmr.fandenatech.ndjangui.permission.SanctionTypePermission"%>
<%@page import="cmr.fandenatech.ndjangui.service.SanctionTypeLocalServiceUtil"%>
<%@ include file="/html/admin/init.jsp" %>
<portlet:defineObjects />
<liferay-ui:error  key="error-adding-sanction-type" message="error-adding-sanction-type"/>

<%

%>
	
<aui:button href="<%=createNewSanctionTypeURL %>"  value='create-new-sanction-type' ></aui:button>
<liferay-ui:search-container delta="10"  iteratorURL="<%=portletURL %>" >


	<liferay-ui:search-container-results 
		results="<%=SanctionTypeLocalServiceUtil.getSanctionTypesByGroupId(scopeGroupId, searchContainer.getStart() , searchContainer.getEnd()) %>"
		total="<%=SanctionTypeLocalServiceUtil.countSanctionTypesByGroupId(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row className="cmr.fandenatech.ndjangui.model.SanctionType" modelVar="sanctionType">
	
		
		<c:if test="<%= SanctionTypePermission.contains(permissionChecker, sanctionType, ActionKeys.VIEW) %>">
			<liferay-ui:search-container-column-text  property="name"   />
			<liferay-ui:search-container-column-text  property="shortDescription" />
			<liferay-ui:search-container-column-text  property="amount" >
				<%= doubleFormat.format(sanctionType.getCompanyId()) %>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text  property="status" />
			<liferay-ui:search-container-column-jsp   path="/html/admin/sanction_type/sanction_type_actions.jsp"/>
			
		
		</c:if>	
	</liferay-ui:search-container-row>
	
	

	<liferay-ui:search-iterator />
</liferay-ui:search-container>