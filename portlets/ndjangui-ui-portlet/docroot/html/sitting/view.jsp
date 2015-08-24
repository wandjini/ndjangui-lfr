<%@include file="toolbar.jsp" %>
<portlet:defineObjects />
	<div class="member-list">
		<c:if test='<%=toolbarItem.equalsIgnoreCase("sittings") %>'>
			<liferay-util:include page="/html/sitting/sittings.jsp" servletContext="<%= this.getServletContext() %>" />
		</c:if>	
	</div>

