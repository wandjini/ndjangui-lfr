

<%@ include file="init.jsp" %>


<%
	String toolbarItem = ParamUtil.getString(renderRequest, "toolbarItem","fund_types");
	
%>
	<h5><%=themeDisplay.getScopeGroupName() %>&nbsp;&nbsp;<liferay-ui:message key="configuration"/></h5>
	<aui:nav cssClass="nav-tabs">
			<aui:nav-item href="<%= fundTypesURL %>" label="fund-types"  
				selected='<%=toolbarItem.equals("fund_types") %>'  
				>
			</aui:nav-item>
			<aui:nav-item href="<%= operationTypesURL %>"  label="operation-types"  
				selected='<%=toolbarItem.equals("operation_types") %>' 
				>
				
			</aui:nav-item>
			<aui:nav-item href="<%= sanctionTypesURL %>"  label="sanction-types"  
				selected='<%=toolbarItem.equals("sanction_types") %>' 
				>
				
			</aui:nav-item>
			<aui:nav-item href="<%= budgetPeriodsURL %>"  label="budget-periods"  
				selected='<%=toolbarItem.equals("budget_periods") %>' 
				>
				
			</aui:nav-item>
			<aui:nav-item href="<%= fundsURL %>"  label="funds"  
				selected='<%=toolbarItem.equals("funds") %>' 
				>
				
			</aui:nav-item>
	</aui:nav>