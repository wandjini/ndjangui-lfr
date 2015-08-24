<%@include file="toolbar.jsp" %>
<portlet:defineObjects />
<c:if test="<%=currentSitting==null%>">
	<div class="alert alert-error">
		<liferay-ui:message key="no-siiting-was-opened"/>
	</div>
</c:if>
<c:if test="<%=currentSitting!=null%>">
	<div class="content-list">
		<c:if test='<%=toolbarItem.equalsIgnoreCase("presences") %>'>
			<liferay-util:include page="/html/currentsitting/presences.jsp" servletContext="<%= this.getServletContext() %>" />
		</c:if>	
		<c:if test='<%=toolbarItem.equalsIgnoreCase("sanctions") %>'>
			<liferay-util:include page="/html/currentsitting/sanctions.jsp" servletContext="<%= this.getServletContext() %>" />
		
		</c:if>
		<c:if test='<%=toolbarItem.equalsIgnoreCase("contributions") %>'>

			<liferay-util:include page="/html/currentsitting/contributions.jsp" servletContext="<%= this.getServletContext() %>" />
		
		</c:if>
		<c:if test='<%=toolbarItem.equalsIgnoreCase("events") %>'>

			<liferay-util:include page="/html/currentsitting/events.jsp" servletContext="<%= this.getServletContext() %>" />
		
		</c:if>
	</div>
</c:if>	