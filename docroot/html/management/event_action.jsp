<%@ include file="/html/init.jsp" %>
<%
	String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Event event = null;
	String eventId = "";

	if (row != null) {
		event = (Event)row.getObject();
		eventId = String.valueOf(event.getEventId());
	}
%>

<span class="entry-action overlay">
	<liferay-ui:icon-menu direction="down" extended="<%= false %>" icon="<%= StringPool.BLANK %>" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>" triggerCssClass="btn">

			<portlet:actionURL var="editURL" name="editEventForm">
				<portlet:param name="id" value="<%= eventId %>"/>
			</portlet:actionURL>

			<liferay-ui:icon
				image="edit"
				url="<%= editURL %>"
			/>

			<portlet:actionURL var="deleteURL" name="deleteEvent">
				<portlet:param name="id" value="<%= eventId %>"/>
			</portlet:actionURL>

			<liferay-ui:icon-delete
				label="delete"
				url="<%= deleteURL %>"
			/>
			
			<portlet:actionURL var="manageRegistrationURL" name="manageRegistration">
				<portlet:param name="eventId" value="<%= eventId %>"/>
			</portlet:actionURL>

			<liferay-ui:icon
				image="assign-user-group-roles"
				label="manage-registrations"
				url="<%= manageRegistrationURL %>"
			/>
	</liferay-ui:icon-menu>
</span>