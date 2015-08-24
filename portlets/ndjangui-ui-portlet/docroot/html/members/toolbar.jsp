

<%@ include file="init.jsp" %>


<%
	String toolbarItem = ParamUtil.getString(request, "toolbarItem","active");// 
	
%>
	<h5><%=themeDisplay.getScopeGroupName() %>&nbsp;&nbsp;<liferay-ui:message key="members"/></h5>
	<aui:nav cssClass="nav-tabs">
			<aui:nav-item href="<%= activeMembersURL %>" label="active-members"  
				selected='<%=toolbarItem.equals("active") %>' 
				>
			</aui:nav-item>
			<aui:nav-item href="<%= lockedMembersURL %>"  label="locked-members"  
				selected='<%=toolbarItem.equals("lock") %>' 
				>
				
			</aui:nav-item>

		
	</aui:nav>