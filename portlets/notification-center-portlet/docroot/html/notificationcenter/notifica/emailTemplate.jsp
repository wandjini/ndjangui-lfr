<%@ include file="../init.jsp"%>

<%
	Notifica notifica = currentNotifica;
	
	String notificaText = "";
	
	if (notifica != null) {
		notificaText = notifica.getText();
	}
%>

<aui:model-context bean="<%=notifica%>" model="<%=Notifica.class%>" />

<h3>
	<liferay-ui:message key="emailTemplate" />
</h3>



	
	<%	
		if(notifica != null && notifica.getNotificaTypeId() > 0){
	%>
	<aui:fieldset column="<%=true%>">
		<liferay-ui:error key="notificaSubject"
			message="please-enter-a-valid-subject" />
	
		<aui:input cssClass="lfr-input-text-container" name='subject'
			type="text" />
	
		<liferay-ui:error key="notificaBody"
			message="please-enter-a-valid-body" />
	
		<aui:field-wrapper label="body">
			<liferay-ui:input-editor editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>"
				initMethod='<%="initNotificaTextEditor"%>' name="text"
				toolbarSet="email" width="470" />
	
		</aui:field-wrapper>
		
		
	</aui:fieldset>
	<aui:fieldset column="<%=true%>" >
		
		<%
			NotificaType notificaType = NotificaTypeServiceUtil.getNotificaType(notifica.getNotificaTypeId());
		
			String[] placeHolders = StringUtil.split(notificaType.getPlaceHolders(), StringPool.COMMA) ;
		
		%>
		
		<h4><liferay-ui:message key="definition-of-terms" /></h4>
		
		<dl>
			<%for(String placeHolder : placeHolders) {%>
				<dt>
					<%=placeHolder %>
				</dt>
			<%} %>
			
		</dl>
		
	</aui:fieldset>
		
		
		
		
		
		<aui:script>
			
			function <portlet:namespace />initNotificaTextEditor() {
				return "<%=UnicodeFormatter.toString(notificaText)%>";
			}
		</aui:script>
		<%!public static final String EDITOR_WYSIWYG_IMPL_KEY =
				"editor.wysiwyg.portal-web.docroot.html.portlet.portal_settings.email_notifications.jsp";%>
		
		
		<% }
		else
		{%>
			<liferay-ui:message key="salvare-prima-la-notifica" ></liferay-ui:message>
		<%}%>


