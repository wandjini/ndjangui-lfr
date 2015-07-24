


<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	QueuedEmail queuedEmail = (QueuedEmail) row.getObject();
%>

<liferay-ui:icon-menu>
		
	<portlet:renderURL var="editQueuedEmailURL">
		<portlet:param name="queuedEmailId" value="<%= String.valueOf(queuedEmail.getQueuedEmailId()) %>" />
		<portlet:param name="mvcPath" value="/html/queuedemail/view_queued_email.jsp" />
		<portlet:param name="redirect" value="<%= queuedEmailURL %>" />
		<portlet:param name="backURL" value="<%= queuedEmailURL %>" />
	</portlet:renderURL>
			
	<liferay-ui:icon
		image="view"
		url="<%=editQueuedEmailURL.toString()%>"
	/>
	
	


	
</liferay-ui:icon-menu>