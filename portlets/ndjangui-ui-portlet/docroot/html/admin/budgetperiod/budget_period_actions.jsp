
<%@page import="cmr.fandenatech.ndjangui.permission.BudgetPeriodPermission"%>
<%@page import="cmr.fandenatech.ndjangui.model.BudgetPeriod"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/admin/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	BudgetPeriod budgetPeriod = (BudgetPeriod) row.getObject();
	long budgetPeriodId = budgetPeriod.getBudgetPeriodId();
	
	
%>
	<liferay-portlet:renderURL var="editBudgetPeriodURL" >
		<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
		<portlet:param name="budgetPeriodId" value="<%=String.valueOf( budgetPeriodId ) %>"></portlet:param>
		<portlet:param name="mvcPath" value="/html/admin/budgetperiod/create_or_update_budget_period.jsp"></portlet:param>
	</liferay-portlet:renderURL>
	<c:if test="<%= BudgetPeriodPermission.contains(permissionChecker, budgetPeriodId, ActionKeys.UPDATE)%>">
		<a href="<%= editBudgetPeriodURL %>" class="icon-edit icon"  title="<liferay-ui:message key='edit'/>"></a>
	</c:if>	
	


	<portlet:actionURL name="editBudgetPeriod"  var="openBudgetPeriodURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.OPEN_BUDGET_PERIOD %>" />
		<portlet:param name="budgetPeriodId" value="<%= String.valueOf(budgetPeriodId) %>" />
		
	</portlet:actionURL>
	<c:if test="<%= budgetPeriod.getStatus() == 0  && BudgetPeriodPermission.contains(permissionChecker, budgetPeriodId, ActionKeys.DELETE)%>">		
		<a href="<%= openBudgetPeriodURL %>" class="icon icon-plus"  title="<liferay-ui:message key='open-budget-period'/>"></a>
	</c:if>
	

	
	<portlet:actionURL name="editBudgetPeriod" var="closeBudgetPeriodURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.CLOSE_BUDGET_PERIOD %>" />
		<portlet:param name="budgetPeriodId" value="<%= String.valueOf(budgetPeriodId) %>" />
	</portlet:actionURL>
	<c:if test="<%= budgetPeriod.getStatus() == 2  && BudgetPeriodPermission.contains(permissionChecker, budgetPeriodId, ActionKeys.DELETE)%>">
		<a href="<%= closeBudgetPeriodURL %>" class="icon-lock icon"  title="<liferay-ui:message key='lock'/>"></a>
			
	</c:if>
	<portlet:actionURL name="editBudgetPeriod" var="removeBudgetPeriodURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.DELETE %>" />
		<portlet:param name="budgetPeriodId" value="<%= String.valueOf(budgetPeriodId) %>" />
	</portlet:actionURL>
	<c:if test="<%= budgetPeriod.getStatus() == 0 && BudgetPeriodPermission.contains(permissionChecker, budgetPeriodId, ActionKeys.DELETE)%>">
		<a href="<%= removeBudgetPeriodURL %>" class="icon-trash icon" onclick="javascript:<portlet:namespace/>deleteBudgetPeriod()" title="<liferay-ui:message key='remove'/>"></a>
			
	</c:if>	
	
	<script>
	
		function <portlet:namespace/>deleteBudgetPeriod(){
			
			if(confirm(Liferay.Language.get('are-you-sure'))){
				
				window.location.href='<%=removeBudgetPeriodURL %>';
			}
		}
	</script>
