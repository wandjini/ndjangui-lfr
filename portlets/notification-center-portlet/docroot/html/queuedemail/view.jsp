
<%@page import="com.xpiping.notificationcenter.service.QueuedEmailLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<%


PortletURL iteratorUrl = PortletURLUtil.getCurrent(renderRequest,renderResponse);

%>


<liferay-util:include page="/html/queuedemail/toolbar.jsp" servletContext="<%=this.getServletContext() %>">
	<liferay-util:param name="toolbarItem" value="view-all" />
</liferay-util:include>


<c:if test="<%=NotificationCenterPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW)%>">

	<liferay-ui:search-container emptyResultsMessage="no-emails-were-found"	>
	
		<liferay-ui:search-container-results
			results="<%= QueuedEmailLocalServiceUtil.getQueuedEmail(companyId, searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=QueuedEmailLocalServiceUtil.countQueuedEmail(companyId)%>"
		/>
		
		<liferay-ui:search-container-row
			className="com.xpiping.notificationcenter.model.QueuedEmail"
			keyProperty="queuedEmailId"
			modelVar="queuedEmail">
		
			<%
				Boolean sent = (queuedEmail.getSentOn() != null);
			%>
		
			<liferay-ui:search-container-column-text
				property="queuedEmailId"/>
		
			<liferay-ui:search-container-column-text
				property="to"/>
				
			<liferay-ui:search-container-column-text
				property="subject" />
				
			
			<liferay-ui:search-container-column-text
				align="center"
				name="aviable" title="notifica-type-aviable"
			>
				<liferay-ui:icon
					image='<%= "../messages/" + ((sent) ? "success" : "error") %>'
					message='<%= sent ? "yes" : "no" %>'
				/>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-jsp
				align="right"
				path="/html/queuedemail/queued_email_action.jsp"
			/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
		
	</liferay-ui:search-container>
	
</c:if>
