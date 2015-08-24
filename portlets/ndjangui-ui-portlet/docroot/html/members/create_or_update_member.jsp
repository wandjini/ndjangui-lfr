<%@page import="cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.service.MemberLocalService"%>
<%@page import="cmr.fandenatech.ndjangui.service.MemberServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.Member"%>
<%@ include file="init.jsp"%>
<%
	Member member = null;
	long memberId = ParamUtil.getLong(request, "memberId",0l);
	if(memberId !=0)
		member = MemberLocalServiceUtil.getMember(memberId);
		
%>
<portlet:actionURL name="editMember" var="editMemberURL" >
	<portlet:param name="redirect" value="<%=backURL %>"/>
	<portlet:param name="<%=Constants.CMD %>" value="<%=memberId ==0 ? Constants.ADD : Constants.UPDATE %>"/>
</portlet:actionURL>

<aui:form action="<%=editMemberURL %>" name="fm" method="post" >
	<aui:model-context bean="<%= member %>" model="<%= Member.class %>" />
	<aui:input name="memberId" value="<%=memberId%>" type="hidden" ></aui:input>
	<aui:fieldset>
		<aui:column columnWidth="50">
			<aui:input name="name" label="name">
				<aui:validator name="required"/>
			</aui:input>
			<aui:input name="surname" label="surname">
				<aui:validator name="required"/>
			</aui:input>
			<aui:input name="phoneNumber" label="phone-number">
				<aui:validator name="required"/>
			</aui:input>
			
		</aui:column>
		<aui:column columnWidth="50">
			<aui:input name="email" label="email">
				<aui:validator name="email"/>
			</aui:input>
			<aui:input name="cardNumber" label="card-number">
				<aui:validator name="required"/>
			</aui:input>
			
		</aui:column>
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button  type="submit"></aui:button>
	</aui:button-row>
</aui:form>