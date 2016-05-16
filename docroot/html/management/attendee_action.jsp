<%@ include file="/html/init.jsp" %>
<%
	String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Attendee attendee = null;
	String attendeeId = "";

	if (row != null) {
		attendee = (Attendee)row.getObject();
		attendeeId = String.valueOf(attendee.getAttendeeId());
	}
%>

<span class="entry-action overlay">
	<liferay-ui:icon-menu direction="down" extended="<%= false %>" icon="<%= StringPool.BLANK %>" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>" triggerCssClass="btn">

			<portlet:actionURL var="viewURL" name="viewAttendee">
				<portlet:param name="attendeeId" value="<%= attendeeId %>"/>
			</portlet:actionURL>

			<liferay-ui:icon
				image="view"
				url="<%= viewURL %>"
			/>
			
			<portlet:actionURL var="approveAttendeeURL" name="approveAttendee">
				<portlet:param name="attendeeId" value="<%= attendeeId %>"/>
			</portlet:actionURL>

			<liferay-ui:icon
				image="check"
				message="approve"
				useDialog="approve-user-confirmation"
				url="<%= approveAttendeeURL %>"
			/>

			<portlet:actionURL var="rejectAttendeeURL" name="rejectAttendee">
				<portlet:param name="attendeeId" value="<%= attendeeId %>"/>
			</portlet:actionURL>

			<liferay-ui:icon-delete
				message="reject"
				confirmation="reject-user-confirmation"
				url="<%= rejectAttendeeURL %>"
			/>
			
	</liferay-ui:icon-menu>
</span>