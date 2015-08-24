
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="cmr.fandenatech.ndjangui.permission.MemberPermission"%>
<%@page import="cmr.fandenatech.ndjangui.model.Member"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	Member member = (Member) row.getObject();
	long memberId = member.getMemberId();
	
	
%>
	<liferay-portlet:renderURL var="editMemberURL" >
		<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
		<portlet:param name="memberId" value="<%=String.valueOf( memberId ) %>"></portlet:param>
		<portlet:param name="mvcPath" value="/html/members/create_or_update_member.jsp"></portlet:param>
	</liferay-portlet:renderURL>
	<c:if test="<%= member.getStatus() == WorkflowConstants.STATUS_APPROVED  && MemberPermission.contains(permissionChecker, memberId, ActionKeys.UPDATE)%>">
		<a href="<%= editMemberURL %>" class="icon-edit icon"  title="<liferay-ui:message key='edit'/>"></a>
	</c:if>	
	<c:if test="<%=member.getStatus() == WorkflowConstants.STATUS_INACTIVE %>">


		<portlet:actionURL name="editMember"  var="restoreUserURL">
			<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.ACTIVATE_MEMBER %>" />
			<portlet:param name="memberId" value="<%= String.valueOf(memberId) %>" />
			
		</portlet:actionURL>

		<a href="<%= restoreUserURL %>" class="icon icon-plus-sign"  title="<liferay-ui:message key='unlock'/>"></a>
	</c:if>

	
	<portlet:actionURL name="editMember" var="deleteUserURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= ActionKeys.DE_ACTIVATE_MEMBER %>" />
		<portlet:param name="memberId" value="<%= String.valueOf(memberId) %>" />
	</portlet:actionURL>
	<c:if test="<%= member.getStatus() == WorkflowConstants.STATUS_APPROVED  && MemberPermission.contains(permissionChecker, memberId, ActionKeys.DELETE)%>">
		<a href="<%= deleteUserURL %>" class="icon-lock icon"  title="<liferay-ui:message key='lock'/>"></a>
			
	</c:if>
		
	
