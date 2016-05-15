<%@ include file="/html/init.jsp" %>

<%
	Boolean requiresApproval = (Boolean) request.getAttribute("requiresApproval");
	String eventOptionId = (String) request.getAttribute("eventOptionId");
%>

<liferay-portlet:actionURL name="saveRegisterForm" var="formActionURL">
	<portlet:param name="eventOptionId" value=" <%= eventOptionId %>" />
</liferay-portlet:actionURL>

<c:if test="<%= requiresApproval != null && requiresApproval %>">
	<p><liferay-ui:message key="approval-message" />
</c:if>

<aui:form action="<%= formActionURL %>" method="post" id="fm">

	<aui:input 
		name="name"
		type="text">
		<aui:validator name="required" />
	</aui:input>



	<aui:input
		name="surname"
		label="last-name"
		type="text">
		<aui:validator name="required" />
	</aui:input>


	<aui:input
		name="company"
		type="text"
		/>

	<aui:input
		name="email"
		type="text">
		<aui:validator name="required" />
		<aui:validator name="email" />
	</aui:input>

	<aui:input
		name="phone"
		type="text"
		/>
	
	<aui:button type="submit" name="submit" value="register"></aui:button>
	
</aui:form>
