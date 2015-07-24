<%@ include file="init.jsp" %>


<%

PortletURL iteratorUrl = PortletURLUtil.getCurrent(renderRequest,renderResponse);

%>


<liferay-util:include page="/html/notificatype/toolbar.jsp" servletContext="<%=this.getServletContext() %>">
	<liferay-util:param name="toolbarItem" value="view-all" />
</liferay-util:include>

<div class="searchResult">
	<c:if test="<%=NotificationCenterPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW)%>">
	
		<liferay-ui:search-container emptyResultsMessage="no-notifiche-type-were-found"	>
		
			<liferay-ui:search-container-results
				results="<%= NotificaTypeServiceUtil.getNotificheType(company.getCompanyId(), searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=NotificaTypeServiceUtil.countNotificheType(company.getCompanyId())%>"
			/>
			
			<liferay-ui:search-container-row
				className="com.xpiping.notificationcenter.model.NotificaType"
				modelVar="notificaType">
			
				<liferay-ui:search-container-column-text
					property="name"/>
					
				<liferay-ui:search-container-column-text
					property="description" />
					
				<liferay-ui:search-container-column-text
					align="center"
					name="aviable" title="notifica-type-aviable"
				>
					<liferay-ui:icon
						image='<%= "../messages/" + ((notificaType.getAviable()) ? "success" : "error") %>'
						message='<%= notificaType.getAviable() ? "yes" : "no" %>'
					/>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-jsp
					align="right"
					path="/html/notificatype/notifica_type_action.jsp"
				/>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
			
		</liferay-ui:search-container>
		
	</c:if>
</div>