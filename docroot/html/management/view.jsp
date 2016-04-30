<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

This is the <b>Event Registration Management</b> portlet in View mode.

<liferay-portlet:actionURL name="addEventForm" var="addEventFormURL"></liferay-portlet:actionURL>

<aui:a href="<%= addEventFormURL %>"><liferay-ui:message key="add-event" /></aui:a>
