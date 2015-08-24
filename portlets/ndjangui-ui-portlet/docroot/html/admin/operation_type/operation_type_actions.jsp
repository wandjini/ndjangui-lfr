
<%@page import="cmr.fandenatech.ndjangui.permission.OperationTypePermission"%>
<%@page import="cmr.fandenatech.ndjangui.model.OperationType"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/admin/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	OperationType operationType = (OperationType) row.getObject();
	long operationTypeId = operationType.getOperationTypeId();
	
	
%>
	<liferay-portlet:renderURL var="editOperationTypeURL" >
		<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
		<portlet:param name="operationTypeId" value="<%=String.valueOf( operationTypeId ) %>"></portlet:param>
		<portlet:param name="mvcPath" value="/html/admin/operation_type/create_or_update_op_type.jsp"></portlet:param>
	</liferay-portlet:renderURL>
	<c:if test="<%= OperationTypePermission.contains(permissionChecker, operationTypeId, ActionKeys.UPDATE)%>">
		<a href="<%= editOperationTypeURL %>" class="icon-edit icon"  title="<liferay-ui:message key='edit'/>"></a>
	</c:if>	
	<c:if test="<%=operationType.getStatus() == WorkflowConstants.STATUS_INACTIVE %>">


		<portlet:actionURL name="editOperationType"  var="restoreoperationTypeURL">
			<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.ENABLE_OPERATION_TYPE %>" />
			<portlet:param name="operationTypeId" value="<%= String.valueOf(operationTypeId) %>" />
			
		</portlet:actionURL>
		<c:if test="<%= operationType.getStatus() == WorkflowConstants.STATUS_INACTIVE  && OperationTypePermission.contains(permissionChecker, operationTypeId, ActionKeys.DELETE)%>">		
			<a href="<%= restoreoperationTypeURL %>" class="icon icon-plus-sign"  title="<liferay-ui:message key='unlock'/>"></a>
		</c:if>
	</c:if>

	
	<portlet:actionURL name="editOperationType" var="deleteoperationTypeURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.DISABLE_OPERATION_TYPE %>" />
		<portlet:param name="operationTypeId" value="<%= String.valueOf(operationTypeId) %>" />
	</portlet:actionURL>
	<c:if test="<%= operationType.getStatus() == WorkflowConstants.STATUS_APPROVED  && OperationTypePermission.contains(permissionChecker, operationTypeId, ActionKeys.DELETE)%>">
		<a href="<%= deleteoperationTypeURL %>" class="icon-lock icon"  title="<liferay-ui:message key='lock'/>"></a>
			
	</c:if>
	<portlet:actionURL name="editOperationType" var="removeOperationTypeURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.DELETE_OPERATION_TYPE %>" />
		<portlet:param name="operationTypeId" value="<%= String.valueOf(operationTypeId) %>" />
	</portlet:actionURL>
	<c:if test="<%= operationType.getStatus() == WorkflowConstants.STATUS_APPROVED  && OperationTypePermission.contains(permissionChecker, operationTypeId, ActionKeys.DELETE)%>">
		<a href="<%= removeOperationTypeURL %>" class="icon-trash icon" onclick="javascript:<portlet:namespace/>deleteoperationType()" title="<liferay-ui:message key='remove'/>"></a>
			
	</c:if>	
	
	<script>
	
		function <portlet:namespace/>deleteoperationType(){
			
			if(confirm(Liferay.Language.get('are-you-sure'))){
				
				window.location.href='<%=removeOperationTypeURL %>';
			}
		}
	</script>
