<%@page import="cmr.fandenatech.ndjangui.permission.OperationTypePermission"%>
<%@page import="cmr.fandenatech.ndjangui.service.OperationTypeLocalServiceUtil"%>
<%@ include file="/html/admin/init.jsp" %>
<portlet:defineObjects />
<liferay-ui:error  key="error-adding-operation-type" message="error-adding-operation-type"/>

<%
%>
	
<aui:button href="<%=createNewOperationTypeURL %>"  value='create-new-operation-type' ></aui:button>
<liferay-ui:search-container delta="10"  iteratorURL="<%=portletURL %>" >


	<liferay-ui:search-container-results 
		results="<%=OperationTypeLocalServiceUtil.getOperationTypesByGroupId(scopeGroupId, searchContainer.getStart() ,searchContainer.getEnd()) %>"
		total="<%=OperationTypeLocalServiceUtil.countOperationTypesByGroupId(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row className="cmr.fandenatech.ndjangui.model.OperationType" modelVar="operationType">
	
		<c:if test="<%=OperationTypePermission.contains(permissionChecker, operationType, ActionKeys.VIEW) %>">
			<liferay-ui:search-container-column-text  property="name"   />
			<liferay-ui:search-container-column-text  property="shortDescription" />
			<liferay-ui:search-container-column-text  property="status" />
			<liferay-ui:search-container-column-jsp   path="/html/admin/operation_type/operation_type_actions.jsp"/>
			
		
		</c:if>	
	</liferay-ui:search-container-row>
	
	

	<liferay-ui:search-iterator />
</liferay-ui:search-container>