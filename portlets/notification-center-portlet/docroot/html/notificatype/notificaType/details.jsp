

<%@ include file="../init.jsp" %>



<%
NotificaType notificaType = currentNotificaType; 



%>

<liferay-ui:error-marker key="errorSection" value="details" />

<aui:model-context bean="<%= notificaType %>" model="<%= NotificaType.class %>" />

<h3><liferay-ui:message key="details" /></h3>

<aui:fieldset column="<%= true %>" cssClass="aui-w50">

	<aui:input name="name"  disabled="<%= notificaType != null  %>"  />
	<aui:input name="description"/>
	<aui:input name="messageDestination"/>
	<aui:input name="placeHolders"/>
	<aui:input name="aviable"  label="notifica-type-aviable" type="checkbox" checked="<%=(notificaType != null && notificaType.getAviable()) %>"/>
	
</aui:fieldset>



