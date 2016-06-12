<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="edu.uoc.eventreg.portlet.search.AttendeeDisplayTerms" %>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
AttendeeDisplayTerms displayTerms = (AttendeeDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-portlet:actionURL name="listAttendees" var="searchFormURL" />

<aui:form action="<%= searchFormURL %>" method="post" name="searchForm">
	<liferay-ui:search-toggle
		buttonLabel="search"
		displayTerms="<%= displayTerms %>"
		id="<%= renderResponse.getNamespace() %>"
	>
		<aui:fieldset>
			<aui:input name="<%= displayTerms.NAME %>" size="20" type="text" value="<%= displayTerms.getName() %>" />

			<aui:input name="<%= displayTerms.SURNAME %>" label="last-name" size="20" type="text" value="<%= displayTerms.getSurname() %>" />

			<aui:input name="<%= displayTerms.EMAIL %>" size="20" type="text" value="<%= displayTerms.getEmail() %>" />

			<aui:select name="<%= displayTerms.STATUS %>">
				<aui:option value="0" label="all" />
				<aui:option value="<%= WorkflowConstants.STATUS_PENDING %>" label="<%= WorkflowConstants.getStatusLabel(WorkflowConstants.STATUS_PENDING) %>" />
 				<aui:option value="<%= WorkflowConstants.STATUS_APPROVED %>" label="<%= WorkflowConstants.getStatusLabel(WorkflowConstants.STATUS_APPROVED) %>" />
 				<aui:option value="<%= WorkflowConstants.STATUS_DENIED %>" label="<%= WorkflowConstants.getStatusLabel(WorkflowConstants.STATUS_DENIED) %>" />
 			</aui:select>

		</aui:fieldset>
	</liferay-ui:search-toggle>
</aui:form>