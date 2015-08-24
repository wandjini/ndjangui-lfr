
<%@page import="cmr.fandenatech.ndjangui.permission.SittingPermission"%>
<%@page import="cmr.fandenatech.ndjangui.service.SittingLocalServiceUtil"%>

<%@ include file="/html/sitting/init.jsp" %>
<portlet:defineObjects />
<liferay-ui:error  key="error-adding-sitting-type" message="error-adding-sitting-type"/>

<%
%>
	
<aui:button href="<%=createNewSittingURL %>"  value='create-new-sitting' ></aui:button>
<liferay-ui:search-container delta="10"  iteratorURL="<%=portletURL %>" >


	<liferay-ui:search-container-results 
		results="<%=SittingLocalServiceUtil.getSittingsByGroupId(scopeGroupId, searchContainer.getStart() ,searchContainer.getEnd()) %>"
		total="<%=SittingLocalServiceUtil.countSittingsByGroupId(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row className="cmr.fandenatech.ndjangui.model.Sitting" modelVar="sitting">
	
		<c:if test="<%=SittingPermission.contains(permissionChecker, sitting, ActionKeys.VIEW) %>">
			<liferay-ui:search-container-column-text  property="name"   />
			<liferay-ui:search-container-column-text  property="notes" />
			<liferay-ui:search-container-column-text  property="status" />
			<liferay-ui:search-container-column-jsp   path="/html/sitting/sitting_actions.jsp"/>
			
		
		</c:if>	
	</liferay-ui:search-container-row>
	
	

	<liferay-ui:search-iterator />
</liferay-ui:search-container>