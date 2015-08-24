
<%@page import="cmr.fandenatech.ndjangui.model.MemberFund"%>
<%@page import="cmr.fandenatech.ndjangui.service.FundServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.Member"%>
<%@page import="cmr.fandenatech.ndjangui.service.FundTypeLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.FundType"%>
<%@page import="cmr.fandenatech.ndjangui.service.FundLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.Fund"%>

<%@ include file="/html/admin/init.jsp"%>
<%
	Fund fund = null;
	List<Member> membersGroup=null;
	List<MemberFund> fundMembers=null;
	
	long fundId = ParamUtil.getLong(request, "fundId",0l);
	
	if(fundId !=0){
		fund = FundLocalServiceUtil.getFund(fundId);
		membersGroup = MemberLocalServiceUtil.getMembersByGroupId(scopeGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		fundMembers = FundServiceUtil.getMembersFund(scopeGroupId, fundId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

	}
	List<FundType> fundTypes = FundTypeLocalServiceUtil.getFundTypesByGroupId(scopeGroupId, QueryUtil.ALL_POS ,QueryUtil.ALL_POS);
%>
<liferay-portlet:renderURL var="addFundMemberURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>"  >
	<portlet:param name="mvcPath" value="/html/admin/fund/members_list.jsp"/>
	<portlet:param name="fundId" value="<%=String.valueOf(fundId) %>"/>
</liferay-portlet:renderURL>

<portlet:actionURL name="editFund" var="editFundURL" >
	<portlet:param name="redirect" value="<%=fundsURL  %>"/>
	<portlet:param name="<%=Constants.CMD %>" value="<%=fundId ==0 ? Constants.ADD : Constants.UPDATE %>"/>
</portlet:actionURL>
<h5>
	<a class="previous-level" href="<%= fundsURL %>" title="<liferay-ui:message key="back" />">
		<i class="control-panel-back-icon icon-circle-arrow-left"></i>

		<span class="helper-hidden-accessible">
			<liferay-ui:message key="back" />
		</span>
	</a>		
	<liferay-ui:message key="new-fund-type"/></h5>
<aui:form action="<%=editFundURL %>" name="fm" method="post" >
	<aui:model-context bean="<%= fund %>" model="<%= Fund.class %>" />
	<aui:input name="budgetPeriodId" value="<%=currentBudgetPeriodId%>" type="hidden" ></aui:input>
	<aui:input name="fundId" value="<%=fundId%>" type="hidden" ></aui:input>

	<aui:fieldset>
		<aui:column columnWidth="50">
			<aui:input name="name" label="name">
				<aui:validator name="required"/>
			</aui:input>
		</aui:column>
		<aui:column columnWidth="50">
			<aui:select name="fundTypeId" label="fund-type">
				<%
					if(fundTypes != null && fundTypes.size()>0){
						for(FundType fundType : fundTypes){
					
				%>
					<aui:option value="<%=String.valueOf(fundType.getFundTypeId()) %>"><%=fundType.getName() %></aui:option>
				<%}
				} %>
				
			</aui:select>
		</aui:column>
				
		<aui:column columnWidth="100">	
			<aui:input type="textarea" name="shortDescription" label="description">
				<aui:validator name="required"/>
			</aui:input>
		</aui:column>
	</aui:fieldset>
	<c:if test="<%=fundMembers !=null && fundMembers.size() > 0 %>">
		<aui:fieldset>
			<%@ include file="fund_members.jspf" %>
		</aui:fieldset>
	</c:if>
	<c:if test="<%=fundId !=0 %>">
		<aui:button class="btn" href="<%=addFundMemberURL %>" useDialog="<%=true %>" value="add-member"></aui:button>
	</c:if>
	<aui:button-row>
		<aui:button  type="submit"></aui:button>
	</aui:button-row>
</aui:form>
