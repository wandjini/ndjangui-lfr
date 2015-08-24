
<%@page import="cmr.fandenatech.ndjangui.model.Member"%>
<%@page import="cmr.fandenatech.ndjangui.permission.MemberPermission"%>
<%@page import="cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil"%>
<%@ include file="init.jsp" %>
<portlet:defineObjects />
<liferay-ui:error  key="error-adding-member" message="error-adding-member"/>

<%
%>
	
<aui:button href="<%=createNewMemberURL %>"  value='create-new-member' ></aui:button>
<liferay-ui:search-container delta="10"  iteratorURL="<%=portletURL %>" >


	<liferay-ui:search-container-results 
		results="<%=MemberLocalServiceUtil.getMembersByGroupId_Status(scopeGroupId, WorkflowConstants.STATUS_INACTIVE,searchContainer.getStart() , searchContainer.getEnd())%>"
		total="<%=MemberLocalServiceUtil.countMembersByGroupId_Status(scopeGroupId, WorkflowConstants.STATUS_INACTIVE) %>"
	/>

	<liferay-ui:search-container-row className="cmr.fandenatech.ndjangui.model.Member" modelVar="member">
	
		<c:if test="<%=MemberPermission.contains(permissionChecker, member, ActionKeys.VIEW) %>">
			<liferay-ui:search-container-column-text  property="name"   />
			<liferay-ui:search-container-column-text  property="surname" />
			<liferay-ui:search-container-column-text  property="email" />
			<liferay-ui:search-container-column-text  property="phoneNumber"  name="phone-number"/>
			<liferay-ui:search-container-column-text  property="cardNumber" name="card-number"/>
			<liferay-ui:search-container-column-jsp   path="/html/members/member_actions.jsp"/>
			
		
		</c:if>	
	</liferay-ui:search-container-row>
	
	

	<liferay-ui:search-iterator />
</liferay-ui:search-container>