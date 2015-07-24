<%@ include file="init.jsp" %>
<%


NotificaType notificaType = currentNotificaType;

String page2show  = request.getParameter("page2show");

//List<ProdottiCampagna> prodottiCampagna = ProdottoCampagnaUtil.get


String[] mainSections = null;

//se sto creando la promozione non rendo visibile la parte di inserimento prodotti


mainSections = new String[] {"details"};


String[][] categorySections = {mainSections};

%>


<portlet:actionURL name="updateNotificaType" var="updateNotificaTypeURL">
	<portlet:param name="mvcPath" value="/html/notificationcenter/edit_notifica.jsp" />
</portlet:actionURL>

<liferay-ui:header
		backURL="<%= notificaTypeURL.toString() %>"
		localizeTitle="<%= notificaType == null %>"
		title='<%= (notificaType == null) ? "new-notifica" : notificaType.getName()  %>'
	/>



<aui:form action="<%= updateNotificaTypeURL %>" method="post" name="editCampagnaFm" >
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= (notificaType == null) ? Constants.ADD : Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="notificaTypeId" type="hidden" value="<%= notificaTypeId %>" />


	<liferay-util:buffer var="htmlTop">
		<c:if test="<%= notificaType != null %>">
			<div class="notifica-type-info">
				<div class="float-container">
					<span class="user-name"><%= HtmlUtil.escape(notificaType.getName()) %></span>
				</div>
			</div>
		</c:if>
	</liferay-util:buffer>

	<liferay-util:buffer var="htmlBottom">
		
	</liferay-util:buffer>
	
	<liferay-ui:form-navigator
		showButtons="<%= true %>"
		backURL="<%= notificaTypeURL.toString() %>"
		categoryNames="<%= _CATEGORY_NAMES %>"
		categorySections="<%= categorySections %>"
		htmlBottom="<%= htmlBottom %>"
		htmlTop="<%= htmlTop %>"
		jspPath="/html/notificatype/notificaType/"
	/>

	
	
</aui:form>

<script type="text/javascript">

	AUI().use(function(A) {   
		
		<% if(page2show != null && page2show != ""){ %>
		
		
		A.one('#<portlet:namespace/>detailsLink').ancestors("li").removeClass("selected");
		A.one('#<portlet:namespace/>details').removeClass("selected");
		
		A.one('#<portlet:namespace/>details').addClass("aui-helper-hidden-accessible");
		A.one('#<portlet:namespace/><%=page2show%>').addClass("selected");
		 A.one('#<portlet:namespace/><%=page2show%>Link').ancestors("li").addClass("selected");
		A.one('#<portlet:namespace/><%=page2show%>').removeClass("aui-helper-hidden-accessible");
		A.one('#<portlet:namespace/><%=page2show%>').removeClass("aui-helper-hidden-accessible");
		
		<%}%>
		
	});

	
</script>


<%!
private static String[] _CATEGORY_NAMES = {"notifica-type-information"};
%>
