<%@ include file="/html/init.jsp" %>

<%
	long attendeeId = (Long) request.getAttribute("attendeeId");
	long eventId = (Long) request.getAttribute("eventId");
	int status = (Integer) request.getAttribute("status");
	Locale locale = request.getLocale();
%>

<liferay-portlet:actionURL name="changeAttendeeStatusSend" var="sendEmailURL" />

<h2>
	<c:choose>
		<c:when test="<%= status == WorkflowConstants.STATUS_APPROVED %>">
			<liferay-ui:message key="approve-user" />
		</c:when>
		<c:otherwise>
			<liferay-ui:message key="reject-user" />
		</c:otherwise>
	</c:choose>
</h2>

<aui:form action="<%= sendEmailURL %>" method="post" id="fm">

	<p><liferay-ui:message key="attendee-form-info" /> <strong><liferay-ui:message key="<%= WorkflowConstants.getStatusLabel(status) %>" /></strong>.</p>
	
	<aui:input name="eventId" type="hidden" value="<%= eventId %>" />
	<aui:input name="attendeeId" type="hidden" value="<%= attendeeId %>" />
	<aui:input name="status" type="hidden" value="<%= status %>" />
	
	<aui:field-wrapper label="message">
		<liferay-ui:input-textarea param="message" cssClass="email-user-text" />
	</aui:field-wrapper>
	
	<aui:button type="submit" name="send" value="send" />
	
</aui:form>