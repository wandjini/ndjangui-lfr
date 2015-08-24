<%@ include file="init.jsp"%>
<%
	String toolbarItem = ParamUtil.getString(request, "toolbarItem","sittings");// 
	
%>
	<h5><%=themeDisplay.getScopeGroupName() %>&nbsp;&nbsp;<liferay-ui:message key="sittings"/></h5>
	<aui:nav cssClass="nav-tabs">
			<aui:nav-item href="<%= sittingsURL %>" label="sittings"  
				selected='<%=toolbarItem.equals("sittings") %>' 
				>
			</aui:nav-item>

		
	</aui:nav>