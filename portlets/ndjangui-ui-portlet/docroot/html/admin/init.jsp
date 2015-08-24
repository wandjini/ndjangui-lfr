<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="/html/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<portlet:renderURL var="createNewOperationTypeURL">
	<portlet:param name="mvcPath" value="/html/admin/operation_type/create_or_update_op_type.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="createNewSanctionTypeURL">
	<portlet:param name="mvcPath" value="/html/admin/sanction_type/create_or_update_sanction_type.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="createNewBudgetPeriodURL">
	<portlet:param name="mvcPath" value="/html/admin/budgetperiod/create_or_update_budget_period.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="createNewFundTypeURL">
	<portlet:param name="mvcPath" value="/html/admin/fund_type/create_or_update_fund_type.jsp"/>
</portlet:renderURL>

<portlet:renderURL var = "operationTypesURL">

	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
	<portlet:param name="toolbarItem" value="operation_types"/>
	
</portlet:renderURL>

<portlet:renderURL var = "sanctionTypesURL">

	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
	<portlet:param name="toolbarItem" value="sanction_types"/>
	
</portlet:renderURL>

<portlet:renderURL var = "fundTypesURL">

	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
	<portlet:param name="toolbarItem" value="fund_types"/>
	
</portlet:renderURL>
<portlet:renderURL var = "fundsURL">

	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
	<portlet:param name="toolbarItem" value="funds"/>
	
</portlet:renderURL>
<portlet:renderURL var = "budgetPeriodsURL">

	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
	<portlet:param name="toolbarItem" value="budget_periods"/>
	
</portlet:renderURL>
<portlet:renderURL var="createNewFundURL">
	<portlet:param name="mvcPath" value="/html/admin/fund/create_fund.jsp"/>
</portlet:renderURL>
