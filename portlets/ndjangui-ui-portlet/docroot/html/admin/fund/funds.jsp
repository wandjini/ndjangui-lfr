
<%@page import="cmr.fandenatech.ndjangui.permission.FundPermission"%>
<%@page import="cmr.fandenatech.ndjangui.service.FundLocalServiceUtil"%>

<%@ include file="/html/admin/init.jsp" %>
<portlet:defineObjects />
<liferay-ui:error  key="error-adding-fund-type" message="error-adding-fund-type"/>

<%
%>
	
<aui:button href="<%=createNewFundURL %>"  value='create-new-fund' ></aui:button>
<liferay-ui:search-container delta="10"  iteratorURL="<%=portletURL %>" >


	<liferay-ui:search-container-results 
		results="<%=FundLocalServiceUtil.getFundByGroupId(scopeGroupId, searchContainer.getStart() ,searchContainer.getEnd()) %>"
		total="<%=FundLocalServiceUtil.countFundsByGroupId(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row className="cmr.fandenatech.ndjangui.model.Fund" modelVar="fund">
	
		<c:if test="<%=FundPermission.contains(permissionChecker, fund, ActionKeys.VIEW) %>">
			<liferay-ui:search-container-column-text  property="name"   />
			<liferay-ui:search-container-column-text  property="shortDescription" />
			<liferay-ui:search-container-column-text  property="status" />
			<liferay-ui:search-container-column-jsp   path="/html/admin/fund/fund_actions.jsp"/>
			
		
		</c:if>	
	</liferay-ui:search-container-row>
	
	

	<liferay-ui:search-iterator />
</liferay-ui:search-container>