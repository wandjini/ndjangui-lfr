
<%@page import="cmr.fandenatech.ndjangui.permission.SanctionTypePermission"%>
<%@page import="cmr.fandenatech.ndjangui.model.SanctionType"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/admin/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	SanctionType sanctionType = (SanctionType) row.getObject();
	long sanctionTypeId = sanctionType.getSanctionTypeId();
	
	
%>
	<liferay-portlet:renderURL var="editSanctionTypeURL" >
		<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
		<portlet:param name="sanctionTypeId" value="<%=String.valueOf( sanctionTypeId ) %>"></portlet:param>
		<portlet:param name="mvcPath" value="/html/admin/sanction_type/create_or_update_sanction_type.jsp"></portlet:param>
	</liferay-portlet:renderURL>
	<c:if test="<%= SanctionTypePermission.contains(permissionChecker, sanctionTypeId, ActionKeys.UPDATE)%>">
		<a href="<%= editSanctionTypeURL %>" class="icon-edit icon"  title="<liferay-ui:message key='edit'/>"></a>
	</c:if>	
	<c:if test="<%=sanctionType.getStatus() == WorkflowConstants.STATUS_INACTIVE %>">


		<portlet:actionURL name="editSanctionType"  var="restoreSanctionTypeURL">
			<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.ENABLE_SANCTION_TYPE %>" />
			<portlet:param name="sanctionTypeId" value="<%= String.valueOf(sanctionTypeId) %>" />
			
		</portlet:actionURL>
		<c:if test="<%= sanctionType.getStatus() == WorkflowConstants.STATUS_INACTIVE  && SanctionTypePermission.contains(permissionChecker, sanctionTypeId, ActionKeys.DELETE)%>">		
			<a href="<%= restoreSanctionTypeURL %>" class="icon icon-plus-sign"  title="<liferay-ui:message key='unlock'/>"></a>
		</c:if>
	</c:if>

	
	<portlet:actionURL name="editSanctionType" var="deleteSanctionTypeURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.DISABLE_SANCTION_TYPE %>" />
		<portlet:param name="sanctionTypeId" value="<%= String.valueOf(sanctionTypeId) %>" />
	</portlet:actionURL>
	<c:if test="<%= sanctionType.getStatus() == WorkflowConstants.STATUS_APPROVED  && SanctionTypePermission.contains(permissionChecker, sanctionTypeId, ActionKeys.DELETE)%>">
		<a href="<%= deleteSanctionTypeURL %>" class="icon-lock icon"  title="<liferay-ui:message key='lock'/>"></a>
			
	</c:if>
	<portlet:actionURL name="editSanctionType" var="removeSanctionTypeURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.DELETE_SANCTION_TYPE %>" />
		<portlet:param name="sanctionTypeId" value="<%= String.valueOf(sanctionTypeId) %>" />
	</portlet:actionURL>
	<c:if test="<%= sanctionType.getStatus() == WorkflowConstants.STATUS_APPROVED  && SanctionTypePermission.contains(permissionChecker, sanctionTypeId, ActionKeys.DELETE)%>">
		<a href="<%= removeSanctionTypeURL %>" class="icon-trash icon" onclick="javascript:<portlet:namespace/>deleteSanctionType()" title="<liferay-ui:message key='remove'/>"></a>
			
	</c:if>	
	
	<script>
	
		function <portlet:namespace/>deleteSanctionType(){
			
			if(confirm(Liferay.Language.get('are-you-sure'))){
				
				window.location.href='<%=removeSanctionTypeURL %>';
			}
		}
	</script>
