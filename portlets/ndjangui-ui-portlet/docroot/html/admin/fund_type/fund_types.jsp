
<%@page import="cmr.fandenatech.ndjangui.permission.FundTypePermission"%>
<%@page import="cmr.fandenatech.ndjangui.service.FundTypeLocalServiceUtil"%>

<%@ include file="/html/admin/init.jsp" %>
<portlet:defineObjects />
<liferay-ui:error  key="error-adding-fund-type" message="error-adding-fund-type"/>

<%
%>
	
<aui:button href="<%=createNewFundTypeURL %>"  value='create-new-fund-type' ></aui:button>
<liferay-ui:search-container delta="10"  iteratorURL="<%=portletURL %>" >


	<liferay-ui:search-container-results 
		results="<%=FundTypeLocalServiceUtil.getFundTypesByGroupId(scopeGroupId, searchContainer.getStart() ,searchContainer.getEnd()) %>"
		total="<%=FundTypeLocalServiceUtil.countFundTypesByGroupId(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row className="cmr.fandenatech.ndjangui.model.FundType" modelVar="fundType">
	
		<c:if test="<%=FundTypePermission.contains(permissionChecker, fundType, ActionKeys.VIEW) %>">
			<liferay-ui:search-container-column-text  property="name"   />
			<liferay-ui:search-container-column-text  property="shortDescription" />
			<liferay-ui:search-container-column-text  property="status" />
			<liferay-ui:search-container-column-jsp   path="/html/admin/fund_type/fund_type_actions.jsp"/>
			
		
		</c:if>	
	</liferay-ui:search-container-row>
	
	

	<liferay-ui:search-iterator />
</liferay-ui:search-container>