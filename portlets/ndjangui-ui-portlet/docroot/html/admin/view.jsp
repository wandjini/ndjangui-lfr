<%@ include file="toolbar.jsp" %>	


	
	<div class="content-list">
		<c:if test='<%=toolbarItem.equalsIgnoreCase("fund_types") %>'>
			<liferay-util:include page="/html/admin/fund_type/fund_types.jsp" servletContext="<%= this.getServletContext() %>" />
		</c:if>	
		<c:if test='<%=toolbarItem.equalsIgnoreCase("sanction_types") %>'>
			<liferay-util:include page="/html/admin/sanction_type/sanction_types.jsp" servletContext="<%= this.getServletContext() %>" />
		
		</c:if>
		<c:if test='<%=toolbarItem.equalsIgnoreCase("operation_types") %>'>

			<liferay-util:include page="/html/admin/operation_type/operation_types.jsp" servletContext="<%= this.getServletContext() %>" />
		
		</c:if>
		<c:if test='<%=toolbarItem.equalsIgnoreCase("budget_periods") %>'>

			<liferay-util:include page="/html/admin/budgetperiod/budget_periods.jsp" servletContext="<%= this.getServletContext() %>" />
		
		</c:if>
		<c:if test='<%=toolbarItem.equalsIgnoreCase("funds") %>'>

			<liferay-util:include page="/html/admin/fund/funds.jsp" servletContext="<%= this.getServletContext() %>" />
		
		</c:if>
	</div>
	