<%@ include file="/html/management/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
EventDisplayTerms displayTerms = (EventDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-portlet:renderURL var="portletURL" />

<aui:form action="<%= portletURL %>" method="post" name="search">
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
				<aui:option value=""></aui:option>

			</aui:select>

		</aui:fieldset>
	</liferay-ui:search-toggle>
</aui:form>

<aui:script use="aui-node-base,liferay-form">
	var form = Liferay.Form.get('<portlet:namespace />search');

	if (form) {
		form.set(
			'onSubmit',
			function(event) {
				event.preventDefault();
			}
		);
	}
</aui:script>