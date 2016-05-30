<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="edu.uoc.eventreg.portlet.search.EventDisplayTerms" %>

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

		</aui:fieldset>
	</liferay-ui:search-toggle>
</aui:form>