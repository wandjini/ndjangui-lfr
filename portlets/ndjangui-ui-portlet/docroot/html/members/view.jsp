<%@ include file="toolbar.jsp" %>	


	
	<div class="member-list">
		<c:if test='<%=toolbarItem.equalsIgnoreCase("active") %>'>
			<liferay-util:include page="/html/members/active_members.jsp" servletContext="<%= this.getServletContext() %>" />
		</c:if>	
		<c:if test='<%=toolbarItem.equalsIgnoreCase("lock") %>'>
			<liferay-util:include page="/html/members/locked_members.jsp" servletContext="<%= this.getServletContext() %>" />
		
		</c:if>
	</div>
	
