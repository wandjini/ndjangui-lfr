
<%@page import="cmr.fandenatech.ndjangui.permission.FundPermission"%>
<%@page import="cmr.fandenatech.ndjangui.model.Fund"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/admin/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	Fund fund = (Fund) row.getObject();
	long fundId = fund.getFundId();
	
	
%>
	<liferay-portlet:renderURL var="editFundURL" >
		<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
		<portlet:param name="fundId" value="<%=String.valueOf( fundId ) %>"></portlet:param>
		<portlet:param name="mvcPath" value="/html/admin/fund/create_fund.jsp"></portlet:param>
	</liferay-portlet:renderURL>
	<c:if test="<%= FundPermission.contains(permissionChecker, fundId, ActionKeys.UPDATE)%>">
		<a href="<%= editFundURL %>" class="icon-edit icon"  title="<liferay-ui:message key='edit'/>"></a>
	</c:if>	
	

	
	<portlet:actionURL name="editFund" var="deleteFundURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.DELETE %>" />
		<portlet:param name="fundId" value="<%= String.valueOf(fundId) %>" />
	</portlet:actionURL>
	<c:if test="<%= FundPermission.contains(permissionChecker, fundId, ActionKeys.DELETE)%>">
		<a href="<%= deleteFundURL %>" class="icon-trash icon" onclick="javascript:<portlet:namespace/>deleteFund()" title="<liferay-ui:message key='delete'/>"></a>
			
	</c:if>
	
	
	<script>
	
		function <portlet:namespace/>deleteFund(){
			
			if(confirm(Liferay.Language.get('are-you-sure'))){
				
				window.location.href='<%=deleteFundURL %>';
			}
		}
	</script>
