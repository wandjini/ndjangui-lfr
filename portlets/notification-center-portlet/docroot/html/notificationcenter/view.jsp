<%@page import="com.xpiping.notificationcenter.service.NotificaTypeLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<%

PortletURL iteratorUrl = PortletURLUtil.getCurrent(renderRequest,renderResponse);

%>


<liferay-util:include page="/html/notificationcenter/toolbar.jsp" servletContext="<%=this.getServletContext() %>">
	<liferay-util:param name="toolbarItem" value="view-all" />
</liferay-util:include>

<div class="searchResult">
	<c:if test="<%=NotificationCenterPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW)%>">
	
		<liferay-ui:search-container emptyResultsMessage="no-notifiche-were-found" 	>
		
			<liferay-ui:search-container-results
				results="<%= NotificaServiceUtil.getNotifiche(company.getCompanyId(), searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=NotificaServiceUtil.countNotifiche(company.getCompanyId())%>"
			/>
			
			<liferay-ui:search-container-row
				className="com.xpiping.notificationcenter.model.Notifica"
				modelVar="notifica"
				keyProperty="notificaId"
				>
				
				<liferay-ui:search-container-column-text
					property="notificaId" />
			
				<liferay-ui:search-container-column-text
					property="name" name="nome-notifica"/>
				
				<liferay-ui:search-container-column-text
					property="description" />
				
					
					
				<liferay-ui:search-container-column-text
					align="center">
					
					<%=  NotificaTypeLocalServiceUtil.getNotificaType(notifica.getNotificaTypeId()).getName() %>
					
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					align="center"
					name="aviable" title="notifica-aviable"
				>
					<liferay-ui:icon
						image='<%= "../messages/" + ((notifica.getAviable()) ? "success" : "error") %>'
						message='<%= notifica.getAviable() ? "yes" : "no" %>'
					/>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-jsp
					align="right"
					path="/html/notificationcenter/notifica_action.jsp"
				/>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
			
		</liferay-ui:search-container>
		
	</c:if>
</div>