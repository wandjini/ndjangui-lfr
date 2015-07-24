
<%@page import="com.xpiping.notificationcenter.service.QueuedEmailLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<%

PortletURL iteratorUrl = PortletURLUtil.getCurrent(renderRequest,renderResponse);

long queuedEmailId = ParamUtil.getLong(request, "queuedEmailId");

QueuedEmail queuedEmail = QueuedEmailLocalServiceUtil.getQueuedEmail(queuedEmailId);

%>


<liferay-util:include page="/html/queuedemail/toolbar.jsp" servletContext="<%=this.getServletContext() %>">
	
</liferay-util:include>
<liferay-ui:header
		backURL="<%= backURL %>"
		localizeTitle="<%= false%>"
		title='<%= queuedEmail.getTo()  %>'
	/>

<c:if test="<%=NotificationCenterPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW)%>">

	<div>
		<%= queuedEmail.getBody() %>
	</div>
	
</c:if>
