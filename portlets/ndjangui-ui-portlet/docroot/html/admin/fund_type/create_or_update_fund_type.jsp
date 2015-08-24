
<%@page import="cmr.fandenatech.ndjangui.service.FundTypeLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.FundType"%>
<%@page import="cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.service.MemberLocalService"%>
<%@page import="cmr.fandenatech.ndjangui.service.MemberServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.Member"%>
<%@ include file="/html/admin/init.jsp"%>
<%
	FundType fundType = null;
	long fundTypeId = ParamUtil.getLong(request, "fundTypeId",0l);
	if(fundTypeId !=0)
		fundType = FundTypeLocalServiceUtil.getFundType(fundTypeId);
		
%>
<portlet:actionURL name="editFundType" var="editFundTypeURL" >
	<portlet:param name="redirect" value="<%=fundTypesURL %>"/>
	<portlet:param name="<%=Constants.CMD %>" value="<%=fundTypeId ==0 ? ActionKeys.ADD_FUND_TYPE : Constants.UPDATE %>"/>
</portlet:actionURL>
<h5>
	<a class="previous-level" href="<%= fundTypesURL %>" title="<liferay-ui:message key="back" />">
		<i class="control-panel-back-icon icon-circle-arrow-left"></i>

		<span class="helper-hidden-accessible">
			<liferay-ui:message key="back" />
		</span>
	</a>		
	<liferay-ui:message key="new-fund-type"/></h5>
<aui:form action="<%=editFundTypeURL %>" name="fm" method="post" >
	<aui:model-context bean="<%= fundType %>" model="<%= FundType.class %>" />
	<aui:input name="fundTypeId" value="<%=fundTypeId%>" type="hidden" ></aui:input>
	<aui:fieldset>
		<aui:column columnWidth="50">
			<aui:input name="name" label="name">
				<aui:validator name="required"/>
			</aui:input>
			<aui:input type="textarea" name="shortDescription">
				<aui:validator name="required"/>
			</aui:input>
		</aui:column>
	</aui:fieldset>
	<aui:button-row>
		<aui:button  type="submit"></aui:button>
	</aui:button-row>
</aui:form>