
<%@page import="cmr.fandenatech.ndjangui.service.OperationTypeLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.OperationType"%>
<%@ include file="/html/admin/init.jsp"%>
<%
	OperationType operationType = null;
	long operationTypeId = ParamUtil.getLong(request, "operationTypeId",0l);
	if(operationTypeId !=0)
		operationType = OperationTypeLocalServiceUtil.getOperationType(operationTypeId);
		
%>
<portlet:actionURL name="editOperationType" var="editOperationTypeURL" >
	<portlet:param name="redirect" value="<%=operationTypesURL %>"/>
	<portlet:param name="<%=Constants.CMD %>" value="<%=operationTypeId ==0 ? ActionKeys.ADD_OPERATION_TYPE : Constants.UPDATE %>"/>
</portlet:actionURL>
<h5>
	<a class="previous-level" href="<%= operationTypesURL %>" title="<liferay-ui:message key="back" />">
		<i class="control-panel-back-icon icon-circle-arrow-left"></i>

		<span class="helper-hidden-accessible">
			<liferay-ui:message key="back" />
		</span>
	</a>		
	<liferay-ui:message key="new-operation-type"/></h5>
<aui:form action="<%=editOperationTypeURL %>" name="fm" method="post" >
	<aui:model-context bean="<%= operationType %>" model="<%= OperationType.class %>" />
	<aui:input name="operationTypeId" value="<%=operationTypeId%>" type="hidden" ></aui:input>
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