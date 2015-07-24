
<%@ include file="../init.jsp"%>


<%
	Notifica notifica = currentNotifica;
%>

<liferay-ui:error-marker key="errorSection" value="details" />

<aui:model-context bean="<%=notifica%>" model="<%=Notifica.class%>" />

<h3>
	<liferay-ui:message key="details" />
</h3>

<aui:fieldset column="<%=true%>" cssClass="aui-w50">

	<aui:input name="name" label="nome-notifica"
		disabled="<%=notifica != null%>" />

	<%
		List<NotificaType> notificaTypeList =
				NotificaTypeServiceUtil.getNotificheType(
					company.getCompanyId(), QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);
	%>

	<aui:select name="notificaTypeId" label="notifica-type"
		showEmptyOption="<%=false%>" disabled="<%=(notifica != null)%>">
		<%
			for (NotificaType notificaType : notificaTypeList) {
		%>
		<aui:option
			value='<%=String.valueOf(notificaType.getNotificaTypeId())%>'
			label="<%=notificaType.getName()%>"
			selected="<%=(notifica != null) &&
							(notificaType.getNotificaTypeId() == notifica.getNotificaTypeId())%>" />

		<%
			}
		%>
	</aui:select>

	<aui:input name="description" />

	
	<aui:input name="aviable" label="notifica-aviable" type="checkbox"
		checked="<%=(notifica != null && notifica.getAviable())%>" />
		
	<aui:input name="ignoreIntersaction" label="notifica-ignore-taget-user-only" type="checkbox"
		checked="<%=(notifica != null && notifica.getIgnoreIntersaction())%>" />

</aui:fieldset>
