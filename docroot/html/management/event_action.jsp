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
			
			<portlet:actionURL var="listEventAttendeesURL" name="listAttendees">
				<portlet:param name="eventId" value="<%= eventId %>"/>
			</portlet:actionURL>

			<liferay-ui:icon
				image="assign_user_group_roles"
				message="manage-registered-users"
				url="<%= listEventAttendeesURL %>"
			/>
			
			<portlet:actionURL var="viewStatisticsURL" name="eventStats">
				<portlet:param name="eventId" value="<%= eventId %>"/>
			</portlet:actionURL>

			<liferay-ui:icon
				image="view"
				message="view-statistics"
				url="<%= viewStatisticsURL %>"
			/>
			
			<portlet:actionURL var="listImagesURL" name="listImages">
				<portlet:param name="eventId" value="<%= eventId %>"/>
			</portlet:actionURL>

			<liferay-ui:icon
				image="view_locations"
				message="image-gallery"
				url="<%= listImagesURL %>"
			/>
			
	</liferay-ui:icon-menu>
</span>