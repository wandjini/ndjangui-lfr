<%@page import="cmr.fandenatech.ndjangui.service.SanctionTypeLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.service.SanctionLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.SanctionType"%>
<%@page import="cmr.fandenatech.ndjangui.model.Fund"%>
<%@page import="cmr.fandenatech.ndjangui.service.FundLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.Member"%>
<%@page import="cmr.fandenatech.ndjangui.permission.MemberPermission"%>
<%@page import="cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.service.SittingLocalServiceUtil"%>

<%@ include file="init.jsp" %>
<%
	long sittingId= currentSitting.getSittingId();
	List<SanctionType> sanctionTypes = SanctionTypeLocalServiceUtil.getSanctionTypesByGroupId(themeDisplay.getScopeGroupId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS );

%>
<script type="text/javascript">
	window.initData ={
			currentSittingId:<%=sittingId%>,
			budgetPeriodId:<%=currentBudgetPeriodId%>,
			
			
	}
<!--

//-->
</script>

<liferay-ui:error  key="error-adding-operation" message="error-adding-operation"/>
<div ng-controller="SittingController" ng-init="init()">
	<input name="sittingId" type="hidden" ng-init="sittingId='<%=sittingId%>'"/>
	<input name="budgetPeriodId" type="hidden" ng-init="budgetPeriodId='<%=currentBudgetPeriodId%>'"/>
	<input name="currentSanctionTypeId" type="hidden" ng-init="currentSanctionTypeId='<%= sanctionTypes.get(0).getSanctionTypeId()%>'"/>

	<select name="currentSanctionType" label="sanction-type" ng-model="currentSanctionTypeId">
		<% for(SanctionType sanctionType: sanctionTypes){%>
			<option value="<%=sanctionType.getSanctionTypeId() %>"><%=sanctionType.getName() %></option>
	<%} %>
	</select>
	
	<div class="alert" ng-show="errors">{{errors}}</div>
	<div class="alert-success" ng-show="messages">{{messages}}</div>
	<form name="myForm">
	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th><liferay-ui:message key="name"/></th>
				<th><liferay-ui:message key="surname"/></th>
				<th><liferay-ui:message key="email"/></th>
				<th><liferay-ui:message key="amount"/></th>
			</tr>
		</thead>
		<tbody ng-repeat="member in allMembers">
			<tr>
				<td>{{member.name}}</td>
				<td>{{member.surname}}</td>
				<td>{{member.email}}</td>
				<td><input type="number" name="{{member.memberId}}" ng-model="member.amount" required/>
					
				</td>
			</tr>
		</tbody>
	</table>
	</form>
	<aui:button name="save-sanctions" ng-click="saveSanctions()" value="save-sanctions" > 
	
	</aui:button>
</div>

