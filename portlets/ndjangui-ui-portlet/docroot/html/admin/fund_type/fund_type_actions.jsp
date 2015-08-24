
<%@page import="cmr.fandenatech.ndjangui.permission.FundTypePermission"%>
<%@page import="cmr.fandenatech.ndjangui.model.FundType"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/admin/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	FundType fundType = (FundType) row.getObject();
	long fundTypeId = fundType.getFundTypeId();
	
	
%>
	<liferay-portlet:renderURL var="editFundTypeURL" >
		<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
		<portlet:param name="fundTypeId" value="<%=String.valueOf( fundTypeId ) %>"></portlet:param>
		<portlet:param name="mvcPath" value="/html/admin/fund_type/create_or_update_fund_type.jsp"></portlet:param>
	</liferay-portlet:renderURL>
	<c:if test="<%= FundTypePermission.contains(permissionChecker, fundTypeId, ActionKeys.UPDATE)%>">
		<a href="<%= editFundTypeURL %>" class="icon-edit icon"  title="<liferay-ui:message key='edit'/>"></a>
	</c:if>	
	<c:if test="<%=fundType.getStatus() == WorkflowConstants.STATUS_INACTIVE %>">


		<portlet:actionURL name="editFundType"  var="restoreFundURL">
			<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.ENABLE_FUND_TYPE %>" />
			<portlet:param name="fundTypeId" value="<%= String.valueOf(fundTypeId) %>" />
			
		</portlet:actionURL>
		<c:if test="<%= fundType.getStatus() == WorkflowConstants.STATUS_INACTIVE  && FundTypePermission.contains(permissionChecker, fundTypeId, ActionKeys.DELETE)%>">		
			<a href="<%= restoreFundURL %>" class="icon icon-plus-sign"  title="<liferay-ui:message key='unlock'/>"></a>
		</c:if>
	</c:if>

	
	<portlet:actionURL name="editFundType" var="deleteFundURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.DISABLE_FUND_TYPE %>" />
		<portlet:param name="fundTypeId" value="<%= String.valueOf(fundTypeId) %>" />
	</portlet:actionURL>
	<c:if test="<%= fundType.getStatus() == WorkflowConstants.STATUS_APPROVED  && FundTypePermission.contains(permissionChecker, fundTypeId, ActionKeys.DELETE)%>">
		<a href="<%= deleteFundURL %>" class="icon-lock icon"  title="<liferay-ui:message key='lock'/>"></a>
			
	</c:if>
	<portlet:actionURL name="editFundType" var="removeFundURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.DELETE_FUND_TYPE %>" />
		<portlet:param name="fundTypeId" value="<%= String.valueOf(fundTypeId) %>" />
	</portlet:actionURL>
	<c:if test="<%= fundType.getStatus() == WorkflowConstants.STATUS_APPROVED  && FundTypePermission.contains(permissionChecker, fundTypeId, ActionKeys.DELETE)%>">
		<a href="<%= removeFundURL %>" class="icon-trash icon" onclick="javascript:<portlet:namespace/>deleteFund()" title="<liferay-ui:message key='remove'/>"></a>
			
	</c:if>	
	
	<script>
	
		function <portlet:namespace/>deleteFund(){
			
			if(confirm(Liferay.Language.get('are-you-sure'))){
				
				window.location.href='<%=removeFundURL %>';
			}
		}
	</script>
