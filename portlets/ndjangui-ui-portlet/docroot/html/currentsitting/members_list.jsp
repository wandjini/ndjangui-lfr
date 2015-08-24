<%@page import="cmr.fandenatech.ndjangui.model.Member"%>
<%@page import="cmr.fandenatech.ndjangui.permission.MemberPermission"%>
<%@page import="cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil"%>
<%@ include file="init.jsp" %>
<%
	long sittingId= ParamUtil.getLong(request, "sittingId",0);
%>
<portlet:actionURL name="editSitting" var="addSittingMemberURL">
	<portlet:param name="<%=Constants.CMD %>" value="<%=ActionKeys.ADD_FUND_MEMBER %>"/>
	<portlet:param name="sittingId" value="<%=String.valueOf(sittingId) %>"/>
	<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent()  %>"/>
</portlet:actionURL>

<liferay-ui:error  key="error-adding-member" message="error-adding-member"/>
<liferay-ui:search-container delta="10"  iteratorURL="<%=portletURL %>" >


	<liferay-ui:search-container-results 
		results="<%=MemberLocalServiceUtil.getMembersByGroupId_Status(scopeGroupId, WorkflowConstants.STATUS_APPROVED, searchContainer.getStart(), searchContainer.getEnd())%>"
		
		total="<%=MemberLocalServiceUtil.countMembersByGroupId_Status(scopeGroupId, WorkflowConstants.STATUS_APPROVED) %>"
	/>

	<liferay-ui:search-container-row className="cmr.fandenatech.ndjangui.model.Member" modelVar="member">
	
		<c:if test="<%=MemberPermission.contains(permissionChecker, member, ActionKeys.VIEW) %>">
			<liferay-ui:search-container-column-text  name=""   >
				<input type="checkbox" id="<portlet:namespace/>checked" value="<%=String.valueOf(member.getMemberId()) %>"></input>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text  property="name"   />
			<liferay-ui:search-container-column-text  property="surname" />
			<liferay-ui:search-container-column-text  property="email" />
			<liferay-ui:search-container-column-text  property="phoneNumber"  name="phone-number"/>
			<liferay-ui:search-container-column-text  property="cardNumber" name="card-number"/>
			
		
		</c:if>	
	</liferay-ui:search-container-row>
	
	

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
				
	<aui:button name="add-member"  value="add-member" > 
	</aui:button>

<script>
AUI().ready(function(A){
	A.one('#<portlet:namespace/>add-member').on('click',function(event){
		
		var url = Liferay.PortletURL.createURL('<%= addSittingMemberURL%>');
		url.setParameter("sittingId","<%= sittingId%>");
		alert(A.all('#<portlet:namespace/>checked'));
		window.location.href=url;
	});
});
</script>