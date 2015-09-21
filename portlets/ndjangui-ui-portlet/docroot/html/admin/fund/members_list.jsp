<%@page import="cmr.fandenatech.ndjangui.model.Member"%>
<%@page import="cmr.fandenatech.ndjangui.permission.MemberPermission"%>
<%@page import="cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil"%>
<%@ include file="/html/sitting/init.jsp" %>
<portlet:defineObjects />
<%
	long fundId= ParamUtil.getLong(request, "fundId",0);
%>
<liferay-ui:error  key="error-adding-member" message="error-adding-member"/>
<liferay-ui:success  key="member-succesfully-added" message="member-succesfully-added"/>

<liferay-ui:search-container delta="10"  iteratorURL="<%=portletURL %>" >


	<liferay-ui:search-container-results 
		results="<%=MemberLocalServiceUtil.getMembersByGroupId_Status(scopeGroupId, WorkflowConstants.STATUS_APPROVED, searchContainer.getStart(), searchContainer.getEnd())%>"
		
		total="<%=MemberLocalServiceUtil.countMembersByGroupId_Status(scopeGroupId, WorkflowConstants.STATUS_APPROVED) %>"
	/>

	<liferay-ui:search-container-row className="cmr.fandenatech.ndjangui.model.Member" modelVar="member">
	
		<c:if test="<%=MemberPermission.contains(permissionChecker, member, ActionKeys.VIEW) %>">
			<liferay-ui:search-container-column-text  property="name"   />
			<liferay-ui:search-container-column-text  property="surname" />
			<liferay-ui:search-container-column-text  property="email" />
			<liferay-ui:search-container-column-text  property="phoneNumber"  name="phone-number"/>
			<liferay-ui:search-container-column-text  property="cardNumber" name="card-number"/>
			<liferay-ui:search-container-column-text  name="actions">
				<portlet:actionURL name="editFund" var="addFundMemberURL">
					<portlet:param name="<%=Constants.CMD %>" value="<%=ActionKeys.ADD_FUND_MEMBER %>"/>
					<portlet:param name="memberId" value="<%=String.valueOf(member.getMemberId()) %>"/>
					<portlet:param name="fundId" value="<%=String.valueOf(fundId) %>"/>
					<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent()  %>"/>
				</portlet:actionURL>
				
				<aui:button name="choose" href="<%=addFundMemberURL %>" useDialog="<%=false %>" value="choose" > 
				</aui:button>
			</liferay-ui:search-container-column-text>
			
		
		</c:if>	
	</liferay-ui:search-container-row>
	
	

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<script>
AUI().ready(function(A){
	A.one('.close-content').on('click',function(event){
		event.preventDefault();
		alert('closing-popup');
		A.one('.modal-focused').hide();
		var url = Liferay.PortletURL.createURL('<%= createNewSittingURL%>');
		url.setParameter("fundId","<%= fundId%>");
		window.location.href=url;
	});
});
</script>