<%@ include file="/html/management/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
EventDisplayTerms displayTerms = (EventDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-portlet:renderURL var="searchFormURL" />

<aui:form action="<%= searchFormURL %>" method="post" name="searchForm">
	<liferay-ui:search-toggle
		buttonLabel="search"
		displayTerms="<%= displayTerms %>"
		id="<%= renderResponse.getNamespace() %>"
	>
		<aui:fieldset>
			<aui:input name="<%= displayTerms.TITLE %>" size="20" type="text" value="<%= displayTerms.getTitle() %>" />

			<aui:input label="summary" name="<%= displayTerms.DESCRIPTION %>" size="20" type="text" value="<%= displayTerms.getDescription() %>" />

			<aui:input name="<%= displayTerms.LOCATION %>" size="20" type="text" value="<%= displayTerms.getLocation() %>" />

			<aui:select name="<%= displayTerms.STATUS %>">
				<aui:option value="0" label="all" />
				<aui:option value="<%= WorkflowConstants.STATUS_APPROVED %>" label="<%= WorkflowConstants.getStatusLabel(WorkflowConstants.STATUS_APPROVED) %>" />
				<aui:option value="<%= WorkflowConstants.STATUS_DRAFT %>" label="<%= WorkflowConstants.getStatusLabel(WorkflowConstants.STATUS_DRAFT) %>" />
 			</aui:select>

		</aui:fieldset>
	</liferay-ui:search-toggle>
</aui:form>