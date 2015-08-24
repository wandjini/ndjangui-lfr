
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="cmr.fandenatech.ndjangui.service.MemberSittingLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.MemberSitting"%>
<%@page import="cmr.fandenatech.ndjangui.service.SittingServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.service.MemberLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.Member"%>
<%@page import="cmr.fandenatech.ndjangui.service.SittingLocalServiceUtil"%>
<%@page import="cmr.fandenatech.ndjangui.model.Sitting"%>

<%@ include file="/html/sitting/init.jsp"%>
<%
	Sitting sitting = null;
	List<Member> membersGroup=null;
	int countSittingMembers=0;
	
	long sittingId = ParamUtil.getLong(request, "sittingId",0l);
	
	if(sittingId !=0){
		sitting = SittingLocalServiceUtil.getSitting(sittingId);
		membersGroup = MemberLocalServiceUtil.getMembersByGroupId(scopeGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		countSittingMembers = MemberSittingLocalServiceUtil.contMembersSittingByGroupId(scopeGroupId, sittingId);

	}
	List<Sitting> sittings = SittingLocalServiceUtil.getSittingsByGroupId(scopeGroupId, QueryUtil.ALL_POS ,QueryUtil.ALL_POS);
%>
<liferay-portlet:renderURL var="addSittingMemberURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>"  >
	<portlet:param name="mvcPath" value="/html/sitting/members_list.jsp"/>
	<portlet:param name="sittingId" value="<%=String.valueOf(sittingId) %>"/>
</liferay-portlet:renderURL>

<portlet:actionURL name="editSitting" var="editSittingURL" >
	<portlet:param name="redirect" value="<%=sittingsURL  %>"/>
	<portlet:param name="<%=Constants.CMD %>" value="<%=sittingId ==0 ? Constants.ADD : Constants.UPDATE %>"/>
</portlet:actionURL>
<h5>
	<a class="previous-level" href="<%= sittingsURL %>" title="<liferay-ui:message key="back" />">
		<i class="control-panel-back-icon icon-circle-arrow-left"></i>

		<span class="helper-hidden-accessible">
			<liferay-ui:message key="back" />
		</span>
	</a>		
	<liferay-ui:message key="new-sitting"/></h5>
<aui:form action="<%=editSittingURL %>" name="fm" method="post" >
	<aui:model-context bean="<%= sitting %>" model="<%= Sitting.class %>" />
	<aui:input name="budgetPeriodId" value="<%=currentBudgetPeriodId%>" type="hidden" ></aui:input>
	<aui:input name="sittingId" value="<%=sittingId%>" type="hidden" ></aui:input>

	<aui:fieldset>
		<aui:column columnWidth="50">
			<aui:input name="name" label="name">
				<aui:validator name="required"/>
			</aui:input>
		</aui:column>
		
				
		<aui:column columnWidth="100">	
			<aui:input type="textarea" name="dayPlan" cssClass="big-area">
				<aui:validator name="required"/>
			</aui:input>
		</aui:column>
		<aui:column columnWidth="100">	
			<aui:input type="textarea" name="notes">
				<aui:validator name="required"/>
			</aui:input>
		</aui:column>
		
	</aui:fieldset>
	<c:if test="<%=countSittingMembers > 0 %>">
		<aui:fieldset>
			<%@ include file="sitting_members.jspf" %>
		</aui:fieldset>
	</c:if>
	<c:if test="<%=sittingId !=0 %>">
		<aui:button class="btn" href="<%=addSittingMemberURL %>" useDialog="<%=true %>" value="add-member"></aui:button>
	</c:if>
	<aui:button-row>
		<aui:button  type="submit"></aui:button>
	</aui:button-row>
</aui:form>
