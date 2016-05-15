<%@ include file="/html/init.jsp" %>

<%
	Event event = (Event) request.getAttribute("event");
	EventOption eventOption = (EventOption) request.getAttribute("eventOption");
	Attendee attendee = (Attendee) request.getAttribute("attendee");
	Locale locale = request.getLocale();
%>

<liferay-ui:icon 
	image="print"
	label="<%= true %>"
	method="get"
	url="javascript:print();"
	cssClass="pull-right"
/>

<p><liferay-ui:message key="registration-success" /></p>

<h2><liferay-ui:message key="event" /></h2>
<dl class="dl-horizontal">
	<dt><liferay-ui:message key="event" /></dt>
	<dd><%= event.getTitle(locale) %>
	<dt><liferay-ui:message key="start-date" /></dt>
	<dd><%= eventOption.getStartDate() %>
	<dt><liferay-ui:message key="end-date" /></dt>
	<dd><%= eventOption.getEndDate() %>
	<dt><liferay-ui:message key="location" /></dt>
	<dd><%= event.getLocation(locale) %>
	<dt><liferay-ui:message key="address" /></dt>
	<dd><%= event.getAddress(locale) %>
	<dt><liferay-ui:message key="reservation-code" /></dt>
	<dd><%= attendee.getReservationCode() %>
	<dt><liferay-ui:message key="status" /></dt>
	<dd><%= event.getAddress(locale) %>
</dl>

<h2><liferay-ui:message key="user-info" /></h2>
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
</dl>