
<%@page import="cmr.fandenatech.ndjangui.service.SanctionTypeLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.SanctionType"%>
<%@ include file="/html/admin/init.jsp"%>
<%
	SanctionType sanctionType = null;
	long sanctionTypeId = ParamUtil.getLong(request, "sanctionTypeId",0l);
	if(sanctionTypeId !=0)
		sanctionType = SanctionTypeLocalServiceUtil.getSanctionType(sanctionTypeId);
		
%>
<portlet:actionURL name="editSanctionType" var="editSanctionTypeURL" >
	<portlet:param name="redirect" value="<%=sanctionTypesURL %>"/>
	<portlet:param name="<%=Constants.CMD %>" value="<%=sanctionTypeId ==0 ? ActionKeys.ADD_SANCTION_TYPE : Constants.UPDATE %>"/>
</portlet:actionURL>
<h5>
	<a class="previous-level" href="<%= sanctionTypesURL %>" title="<liferay-ui:message key="back" />">
		<i class="control-panel-back-icon icon-circle-arrow-left"></i>

		<span class="helper-hidden-accessible">
			<liferay-ui:message key="back" />
		</span>
	</a>		
	<liferay-ui:message key="new-sanction-type"/></h5>
<aui:form action="<%=editSanctionTypeURL %>" name="fm" method="post" >
	<aui:model-context bean="<%= sanctionType %>" model="<%= SanctionType.class %>" />
	<aui:input name="sanctionTypeId" value="<%=sanctionTypeId%>" type="hidden" ></aui:input>
	<aui:fieldset>
		<aui:column columnWidth="50">
			<aui:input name="name" label="name">
				<aui:validator name="required"/>
			</aui:input>
			<aui:input name="amount" label="amount">
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