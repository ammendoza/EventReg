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
			
			<c:if test="<%= attendee.getStatus() == WorkflowConstants.STATUS_PENDING %>">
				<portlet:actionURL var="approveAttendeeURL" name="changeAttendeeStatus">
					<portlet:param name="attendeeId" value="<%= attendeeId %>"/>
					<portlet:param name="status" value="<%= String.valueOf(WorkflowConstants.STATUS_APPROVED) %>" />
				</portlet:actionURL>
	
				<liferay-ui:icon
					image="check"
					message="approve"
					url="<%= approveAttendeeURL %>"
				/>
	
				<portlet:actionURL var="rejectAttendeeURL" name="changeAttendeeStatus">
					<portlet:param name="attendeeId" value="<%= attendeeId %>"/>
					<portlet:param name="status" value="<%= String.valueOf(WorkflowConstants.STATUS_DENIED) %>" />
				</portlet:actionURL>
	
				<liferay-ui:icon
					image="delete"
					message="reject"
					url="<%= rejectAttendeeURL %>"
				/>
			</c:if>
			
	</liferay-ui:icon-menu>
</span>