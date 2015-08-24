<%@include file="init.jsp"%>
<%
	String toolbarItem = ParamUtil.getString(renderRequest, "toolbarItem","presences");
	
%>
	<h5><%=themeDisplay.getScopeGroupName() %>&nbsp;&nbsp;<liferay-ui:message key="configuration"/></h5>
	<aui:nav cssClass="nav-tabs">
			<aui:nav-item href="<%= presencesURL %>" label="presences"  
				selected='<%=toolbarItem.equals("presences") %>'  
				>
			</aui:nav-item>
			<aui:nav-item href="<%= contributionsURL %>"  label="contributions"  
				selected='<%=toolbarItem.equals("contributions") %>' 
				>
				
			</aui:nav-item>
			<aui:nav-item href="<%= sanctionsURL %>"  label="sanctions"  
				selected='<%=toolbarItem.equals("sanctions") %>' 
				>
				
			</aui:nav-item>
			<aui:nav-item href="<%= eventsURL %>"  label="events"  
				selected='<%=toolbarItem.equals("events") %>' 
				>
				
			</aui:nav-item>
	</aui:nav>