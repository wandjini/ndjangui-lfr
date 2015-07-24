<%@ include file="init.jsp"%>
<%

Notifica notifica = currentNotifica;

String page2show  = request.getParameter("page2show");


String[] mainSections =  null;
String[] scopeSections = null;
String[] summarySections = null;

String[] _CATEGORY_NAMES = null;

if(notifica == null){
	mainSections = new String[] {"details"};
	_CATEGORY_NAMES = new String[]  {"notifica-information"};
}
else{
	mainSections = new String[] {"details","emailTemplate"};
	scopeSections =  new String[] {"user-groups"};
	summarySections =  new String[] {"users"};
	_CATEGORY_NAMES = new String[]  {"notifica-information","notifica-scope","summary"};
}

String[][] categorySections = null;

if(notifica == null){
	categorySections = new String[][] {mainSections};
}
else{
	categorySections =  new String[][]{mainSections,scopeSections,summarySections};
}
%>


<portlet:actionURL name="updateNotifica" var="updateNotificaURL">
	<portlet:param name="mvcPath"
		value="/html/notificationcenter/edit_notifica.jsp" />
</portlet:actionURL>

<liferay-ui:header backURL="<%=notificationCenterURL.toString()%>"
	localizeTitle="<%=notifica == null%>"
	title='<%=(notifica == null) ? "new-notifica" : notifica.getName()%>' />



<aui:form action="<%=updateNotificaURL%>" method="post"
	name="editNotificaFm">
	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=(notifica == null) ? Constants.ADD : Constants.UPDATE%>" />
	<aui:input name="redirect" type="hidden" value="<%=currentURL%>" />
	<aui:input name="notificaId" type="hidden" value="<%=notificaId%>" />



	<liferay-util:buffer var="htmlTop">
		<c:if test="<%=notifica != null%>">
			<div class="notifica-info">
				<div class="float-container">
					<span class="user-name"><%=HtmlUtil.escape(notifica.getName())%></span>
				</div>
			</div>
		</c:if>
	</liferay-util:buffer>

	<liferay-util:buffer var="htmlBottom">

		<c:if test="<%=notifica != null%>">
			<%
				boolean hasSendNotificaInstantanea = NotificationCenterPermission.contains(permissionChecker, scopeGroupId, ActionKeys.SEND_INSTANT_NOTIFICA);
				NotificaType notificaType = NotificaTypeServiceUtil.getNotificaType(notifica.getNotificaTypeId());
			%>


			<c:if
				test="<%=notificaType.getName().equals(WebKeys.INSTANT_NOTIFICATION) && hasSendNotificaInstantanea%>">

				<aui:button-row>

					<aui:button cssClass="instantNotificaSendNow" name="instantNotificaSendNow" value="send-now"></aui:button>

				</aui:button-row>

			</c:if>
		</c:if>
	</liferay-util:buffer>

	<liferay-ui:form-navigator showButtons="<%=true%>"
		backURL="<%=notificationCenterURL.toString()%>"
		categoryNames="<%=_CATEGORY_NAMES%>"
		categorySections="<%=categorySections%>"
		htmlBottom="<%=htmlBottom%>" htmlTop="<%=htmlTop%>"
		jspPath="/html/notificationcenter/notifica/" />



</aui:form>

<aui:script use="aui-base">
	var el = A.one("#<portlet:namespace/>instantNotificaSendNow");
	if(el){
	
	el.on("click", function(e){
			
			if(confirm("<liferay-ui:message key="send-now-displaimer" />")){
				if(confirm("<liferay-ui:message key="send-now-confirm" />")){
					
					A.one("#<portlet:namespace /><%=Constants.CMD%>").val("SEND_INSTANT_NOTIFICA");
					submitForm(document.<portlet:namespace />editNotificaFm);
					
				}
			}
			
			
	
		});
	}
	
</aui:script>

<script type="text/javascript">

	AUI().use(function(A) {   
		
		<%if(page2show != null && page2show != ""){%>
		
		
		A.one('#<portlet:namespace/>detailsLink').ancestors("li").removeClass("selected");
		A.one('#<portlet:namespace/>details').removeClass("selected");
		
		A.one('#<portlet:namespace/>details').addClass("aui-helper-hidden-accessible");
		A.one('#<portlet:namespace/><%=page2show%>').addClass("selected");
		 A.one('#<portlet:namespace/><%=page2show%>Link').ancestors("li").addClass("selected");
		A.one('#<portlet:namespace/><%=page2show%>').removeClass("aui-helper-hidden-accessible");
		A.one('#<portlet:namespace/><%=page2show%>
	').removeClass(
						"aui-helper-hidden-accessible");
<%}%>
	});
</script>


