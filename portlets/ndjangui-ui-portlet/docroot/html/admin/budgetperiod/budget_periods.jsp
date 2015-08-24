<%@page import="cmr.fandenatech.ndjangui.permission.BudgetPeriodPermission"%>
<%@ include file="/html/admin/init.jsp" %>
<portlet:defineObjects />
<liferay-ui:error  key="error-adding-operation-type" message="error-adding-operation-type"/>

<aui:button href="<%=createNewBudgetPeriodURL %>"  value='create-new-budget-period' ></aui:button>
<liferay-ui:search-container delta="10"  iteratorURL="<%=portletURL %>" >


	<liferay-ui:search-container-results 
		results="<%=BudgetPeriodLocalServiceUtil.getBudgetPeriodsByGroupId(scopeGroupId, searchContainer.getStart() ,searchContainer.getEnd()) %>"
		total="<%=BudgetPeriodLocalServiceUtil.countBudgetPeriodsByGroupId(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row className="cmr.fandenatech.ndjangui.model.BudgetPeriod" modelVar="budgetPeriod">
	
		<c:if test="<%=BudgetPeriodPermission.contains(permissionChecker, budgetPeriod, ActionKeys.VIEW) %>">
			<liferay-ui:search-container-column-text  property="name"   />
			<liferay-ui:search-container-column-text  property="shortDescription" />
			<liferay-ui:search-container-column-text  name="startDate">
				<%=formatDateTimeFormat.format(budgetPeriod.getStartDate()) %>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text  name="endDate" >
				<%=formatDateTimeFormat.format(budgetPeriod.getEndDate()) %>
			</liferay-ui:search-container-column-text>
				
			<liferay-ui:search-container-column-text  property="status" />
			<liferay-ui:search-container-column-jsp   path="/html/admin/budgetperiod/budget_period_actions.jsp"/>
			
		
		</c:if>	
	</liferay-ui:search-container-row>
	
	

	<liferay-ui:search-iterator />
</liferay-ui:search-container>