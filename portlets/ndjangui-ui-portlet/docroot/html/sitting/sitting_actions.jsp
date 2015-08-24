
<%@page import="cmr.fandenatech.ndjangui.permission.SittingPermission"%>
<%@page import="cmr.fandenatech.ndjangui.model.Sitting"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/sitting/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	Sitting sitting = (Sitting) row.getObject();
	long sittingId = sitting.getSittingId();
	
	
%>
	<liferay-portlet:renderURL var="editSittingURL" >
		<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
		<portlet:param name="sittingId" value="<%=String.valueOf( sittingId ) %>"></portlet:param>
		<portlet:param name="mvcPath" value="/html/sitting/create_or_update_sitting.jsp"></portlet:param>
	</liferay-portlet:renderURL>
	<c:if test="<%= SittingPermission.contains(permissionChecker, sittingId, ActionKeys.UPDATE)%>">
		<a href="<%= editSittingURL %>" class="icon-edit icon"  title="<liferay-ui:message key='edit'/>"></a>
	</c:if>	
	
	<liferay-portlet:actionURL name ="editSitting" var="openSittingURL">
		<portlet:param name="<%=Constants.CMD %>" value="<%= ActionKeys.OPEN_SITTING %>"></portlet:param>
		<portlet:param name="sittingId" value="<%=String.valueOf( sittingId ) %>"></portlet:param>
	</liferay-portlet:actionURL>
	<c:if test="<%= SittingPermission.contains(permissionChecker, sittingId, ActionKeys.UPDATE)%>">
		<a href="<%= openSittingURL %>" class="icon-folder-open icon"  title="<liferay-ui:message key='set-as-current-sitting'/>"></a>
	</c:if>	

	
	<portlet:actionURL name="editSitting" var="deleteSittingURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.DELETE %>" />
		<portlet:param name="sittingId" value="<%= String.valueOf(sittingId) %>" />
	</portlet:actionURL>
	<c:if test="<%= SittingPermission.contains(permissionChecker, sittingId, ActionKeys.DELETE)%>">
		<a href="<%= deleteSittingURL %>" class="icon-trash icon" onclick="javascript:<portlet:namespace/>deleteSitting()" title="<liferay-ui:message key='delete'/>"></a>
			
	</c:if>
	
	
	<script>
	
		function <portlet:namespace/>deleteSitting(){
			
			if(confirm(Liferay.Language.get('are-you-sure'))){
				
				window.location.href='<%=deleteSittingURL %>';
			}
		}
	</script>
