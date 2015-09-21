<%@page import="cmr.fandenatech.ndjangui.model.Fund"%>
<%@page import="cmr.fandenatech.ndjangui.service.FundLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.Member"%>
<%@page import="cmr.fandenatech.ndjangui.permission.MemberPermission"%>
<%@page import="cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.service.SittingLocalServiceUtil"%>

<%@ include file="init.jsp" %>
<%
	long sittingId= currentSitting.getSittingId();
	List<Member> saveFundMemmbers = FundLocalServiceUtil.getMembersByFund(themeDisplay.getScopeGroupId(), 1, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<Fund> funds = FundLocalServiceUtil.getFundByGroupId(themeDisplay.getScopeGroupId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS );

%>
<script type="text/javascript">
	window.initData ={
			currentSittingId:<%=sittingId%>,
			budgetPeriodId:<%=currentBudgetPeriodId%>,
			fundId:<%=funds.get(0).getFundId() %>
			
	}
<!--

//-->
</script>
	<portlet:actionURL name="editOperation" var="addOperationURL">
			<portlet:param name="<%=Constants.CMD %>" value="<%=ActionKeys.ADD_CONTRIBUTION %>"/>
			<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent()  %>"/>
	</portlet:actionURL>

<liferay-ui:error  key="error-adding-operation" message="error-adding-operation"/>
<div ng-controller="SittingController" ng-init="init()">
	<input name="sittingId" type="hidden" ng-init="sittingId='<%=sittingId%>'"/>
	<input name="budgetPeriodId" type="hidden" ng-init="budgetPeriodId='<%=currentBudgetPeriodId%>'"/>
	<input name="currentFundId" type="hidden" ng-init="currentFundId='<%=funds.get(0).getFundId()%>'"/>

	<select name="fundId" label="destination-fund" ng-model="currentFundId">
		<% for(Fund fund:funds){%>
			<option value="<%=fund.getFundId() %>"><%=fund.getName() %></option>
	<%} %>
	</select>
	
	<div class="alert" ng-show="errors">{{errors}}</div>
	<div class="success" ng-show="messages">{{messages}}</div>
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
		<tbody ng-repeat="member in members">
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
	<aui:button name="add-contributions" ng-click="saveOperations()" value="save-contributions" > 
	
	</aui:button>
</div>
<script>
function <portlet:namespace/>addContribution(memberId){
	
	var url = Liferay.PortletURL.createURL('<%= addOperationURL%>');
	var amount = AUI().one('#<portlet:namespace/>member_'+memberId);
	if(!amount || !parseInt(amount.val())){
		alert(Liferay.Language.get('invalid-amount'));
		return;
	
	}
	var fundId = AUI().one('#<portlet:namespace/>fundId');
	url.setParameter('amount',amount.val());
	url.setParameter('memberId', memberId);
	url.setParameter('fundId', fundId);
	url.setParameter('budgetPeriodId', <%=currentBudgetPeriodId%>);
	url.setParameter('sittingId', <%=sittingId %>);
	window.location.href=url;
}
</script>