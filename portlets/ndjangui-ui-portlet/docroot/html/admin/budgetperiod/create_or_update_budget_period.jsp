
<%@page import="cmr.fandenatech.ndjangui.service.BudgetPeriodLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.BudgetPeriod"%>
<%@ include file="/html/admin/init.jsp"%>
<%
	BudgetPeriod budgetPeriod = null;
	long budgetPeriodId = ParamUtil.getLong(request, "budgetPeriodId",0l);
	if(budgetPeriodId !=0)
		budgetPeriod = BudgetPeriodLocalServiceUtil.getBudgetPeriod(budgetPeriodId);
		
%>
<portlet:actionURL name="editBudgetPeriod" var="editBudgetPeriodURL" >
	<portlet:param name="redirect" value="<%=budgetPeriodsURL %>"/>
	<portlet:param name="<%=Constants.CMD %>" value="<%=budgetPeriodId ==0 ? ActionKeys.ADD_BUDGET_PERIOD : Constants.UPDATE %>"/>
</portlet:actionURL>
<h5>
	<a class="previous-level" href="<%= budgetPeriodsURL %>" title="<liferay-ui:message key="back" />">
		<i class="control-panel-back-icon icon-circle-arrow-left"></i>

		<span class="helper-hidden-accessible">
			<liferay-ui:message key="back" />
		</span>
	</a>		
	<liferay-ui:message key="new-budget-period"/></h5>
<aui:form action="<%=editBudgetPeriodURL %>" name="fm" method="post" >
	<aui:model-context bean="<%= budgetPeriod %>" model="<%= BudgetPeriod.class %>" />
	<aui:input name="budgetPeriodId" value="<%=budgetPeriodId%>" type="hidden" ></aui:input>
	<aui:fieldset>
		<aui:column columnWidth="50">
			<aui:input name="name" label="name" placeholder="20015-2016">
				<aui:validator name="required"/>
			</aui:input>
			<aui:input type="textarea" name="shortDescription">
				<aui:validator name="required"/>
			</aui:input>
		</aui:column>
		<aui:column columnWidth="50">
			<aui:input class="date-control" name="startDate" label="start-date">
				<aui:validator name="required"/>
			</aui:input>
			<aui:input class="date-control" name="endDate" >
				<aui:validator name="required"/>
			</aui:input>
		</aui:column>
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button  type="submit"></aui:button>
	</aui:button-row>
</aui:form>
<script>
AUI().use(
		  'aui-datepicker',
		  function(A) {
		    var datepicker = new A.DatePicker(
		      {
		        trigger: 'input.date-control',
		        mask: '%d/%m/%Y',
		        popover: {
		          zIndex: 1
		        }
		      }
		    );
		    A.one('#<portlet:namespace/>startDateTime').hide();
			A.one('#<portlet:namespace/>endDateTime').hide();
		  }
		);
		

</script>