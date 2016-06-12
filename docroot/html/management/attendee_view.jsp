<%@ include file="/html/init.jsp" %>

<%
	Event event = (Event) request.getAttribute("event");
	EventOption eventOption = (EventOption) request.getAttribute("eventOption");
	Attendee attendee = (Attendee) request.getAttribute("attendee");
	Locale locale = request.getLocale();
%>

<dl class="dl-horizontal">
	<dt><liferay-ui:message key="name" /></dt>
	<dd><%= attendee.getName() %>
	<dt><liferay-ui:message key="last-name" /></dt>
	<dd><%= attendee.getSurname() %>
	<c:if test="<%= !attendee.getCompany().isEmpty() %>">
		<dt><liferay-ui:message key="company" /></dt>
		<dd><%= attendee.getCompany() %>
	</c:if>
	<dt><liferay-ui:message key="email" /></dt>
	<dd><%= attendee.getEmail() %>
	<c:if test="<%= !attendee.getPhone().isEmpty() %>">
		<dt><liferay-ui:message key="phone" /></dt>
		<dd><%= attendee.getPhone() %>
	</c:if>
	<dt><liferay-ui:message key="registration-code" /></dt>
	<dd><%= attendee.getReservationCode() %>
	<dt><liferay-ui:message key="register-date" /></dt>
	<dd><%= attendee.getRegisterDate() %></dd>
</dl>