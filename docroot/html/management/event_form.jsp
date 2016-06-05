<%@page import="edu.uoc.eventreg.service.EventOptionLocalServiceUtil"%>
<%@ include file="/html/init.jsp" %>
<%
	Event event = (Event) request.getAttribute("event");
	List<EventOption> eventOptions = (List<EventOption>) request.getAttribute("eventOptions");
	Calendar cal = Calendar.getInstance();
%>
<liferay-portlet:actionURL name="saveEvent" var="formActionURL" />

<h2>
	<c:choose>
		<c:when test="<%= event != null %>">
			<liferay-ui:message key="edit-event" />
		</c:when>
		<c:otherwise>
			<liferay-ui:message key="add-event" />
		</c:otherwise>
	</c:choose>
</h2>

<aui:form action="<%= formActionURL %>" method="post" id="fm">

	<aui:input type="hidden" name="cmd" id="cmd" value="save-draft" />
	
	<c:if test="<%= event != null %>">
		<aui:input type="hidden" name="id" value="<%= event.getEventId() %>" />
	</c:if>
	
	<aui:field-wrapper label="title" required="true">
		<liferay-ui:input-localized 
			name="title" 
			xml="<%= (event != null)? event.getTitle() : StringPool.BLANK %>">
		</liferay-ui:input-localized>
	</aui:field-wrapper>
	
	<aui:field-wrapper label="location" required="true">
		<liferay-ui:input-localized 
			name="location" 
			xml="<%= (event != null)? event.getLocation() : StringPool.BLANK %>" 
			/>
	</aui:field-wrapper>
	
	<aui:field-wrapper label="address">
		<liferay-ui:input-localized 
			name="address" 
			xml="<%= (event != null)? event.getAddress() : StringPool.BLANK %>" 
			/>
	</aui:field-wrapper>
	
	<aui:input 
		name="coord-y" 
		type="text" 
		value="<%= (event != null)? event.getCoordY() : StringPool.BLANK %>"
		/>
	
	<aui:input 
		name="coord-x" 
		type="text" 
		value="<%= (event != null)? event.getCoordX() : StringPool.BLANK %>"
		/>
	
	<aui:field-wrapper label="description" required="true">
		<liferay-ui:input-localized 
			name="description" 
			xml="<%= (event != null)? event.getDescription() : StringPool.BLANK %>" 
			type="editor" 
			/>
	</aui:field-wrapper>
	
	<aui:input 
		name="requires-approval" 
		type="checkbox" 
		value="<%= (event != null)? event.getRequiresApproval() : false %>"
		/>
	
	<h2><liferay-ui:message key="event-options" /></h2>
	
	<c:if test="<%= event != null %>">
		<% for (EventOption option : eventOptions) { 
	
			Calendar startDate = Calendar.getInstance();
			startDate.setTime(option.getStartDate());
			
			Calendar endDate = Calendar.getInstance();
			endDate.setTime(option.getEndDate());
		
		%>
			<div id="<portlet:namespace />event-options">
				<div class="event-option">
					<i class="icon-plus-sign pull-right"></i>
					
					<aui:input type="hidden" name="eventOptionId" value="<%= option.getEventOptionId() %>" />
						
					<aui:field-wrapper label="start-date">
						<aui:field-wrapper inlineField="true">
							<liferay-ui:input-date 
								name="startDate"
								dayValue="<%= startDate.get(Calendar.DAY_OF_MONTH) %>"
								monthValue="<%= startDate.get(Calendar.MONTH) %>"
								yearValue="<%= startDate.get(Calendar.YEAR) %>"
								/>
						</aui:field-wrapper>
							
						<aui:field-wrapper inlineField="true">
							<liferay-ui:input-time 
								name="startHour"
								hourParam="startHour"
								amPmParam="startAmPm"
								minuteParam="startMinute"
								hourValue="<%= startDate.get(Calendar.HOUR) %>"
								minuteValue="<%= startDate.get(Calendar.MINUTE) %>"
								amPmValue="<%= startDate.get(Calendar.AM_PM) %>"
								/>
						</aui:field-wrapper>
					</aui:field-wrapper>
						
					<aui:field-wrapper label="end-date">
						<aui:field-wrapper inlineField="true">
							<liferay-ui:input-date 
								name="endDate" 
								dayValue="<%= endDate.get(Calendar.DAY_OF_MONTH) %>"
								monthValue="<%= endDate.get(Calendar.MONTH) %>"
								yearValue="<%= endDate.get(Calendar.YEAR) %>"
								/>
						</aui:field-wrapper>
						
						<aui:field-wrapper inlineField="true">
							<liferay-ui:input-time 
								name="endHour"
								hourParam="endHour"
								amPmParam="endAmPm"
								minuteParam="endMinute"
								hourValue="<%= endDate.get(Calendar.HOUR) %>"
								minuteValue="<%= endDate.get(Calendar.MINUTE) %>"
								amPmValue="<%= endDate.get(Calendar.AM_PM) %>"
								/>
						</aui:field-wrapper>
					</aui:field-wrapper>
						
					<aui:input 
						name="seats"
						value="<%= option.getSeats() %>">
						<aui:validator name="digits" />
					</aui:input>
				</div>
			</div>
		<% } %>
	</c:if>
	
	<c:if test="<%= event == null %>">
		<div id="<portlet:namespace />event-options">
			<div class="event-option">
				<i class="icon-plus-sign pull-right"></i>
				
				<aui:input type="hidden" name="eventOptionId" value="0" />
					
				<aui:field-wrapper label="start-date">
					<aui:field-wrapper inlineField="true">
						<liferay-ui:input-date 
							name="startDate"
							dayValue="<%= cal.get(Calendar.DAY_OF_MONTH) %>"
							monthValue="<%= cal.get(Calendar.MONTH) %>"
							yearValue="<%= cal.get(Calendar.YEAR) %>"
							/>
					</aui:field-wrapper>
						
					<aui:field-wrapper inlineField="true">
						<liferay-ui:input-time 
							name="startHour"
							hourParam="startHour"
							amPmParam="startAmPm"
							minuteParam="startMinute"
							/>
					</aui:field-wrapper>
				</aui:field-wrapper>
					
				<aui:field-wrapper label="end-date">
					<aui:field-wrapper inlineField="true">
						<liferay-ui:input-date 
							name="endDate" 
							dayValue="<%= cal.get(Calendar.DAY_OF_MONTH) %>"
							monthValue="<%= cal.get(Calendar.MONTH) %>"
							yearValue="<%= cal.get(Calendar.YEAR) %>"
							/>
					</aui:field-wrapper>
					
					<aui:field-wrapper inlineField="true">
						<liferay-ui:input-time 
							name="endHour"
							hourParam="endHour"
							amPmParam="endAmPm"
							minuteParam="endMinute"
							/>
					</aui:field-wrapper>
				</aui:field-wrapper>
					
				<aui:input 
					name="seats"
					value="0">
					<aui:validator name="digits" />
				</aui:input>
			</div>
		</div>
	</c:if>
	
	<c:if test="<%= event == null || event.getStatus() == WorkflowConstants.STATUS_DRAFT %>">
		<aui:button type="submit" name="save" value="save-draft" onclick="saveDraft()"></aui:button>
	</c:if>
	<aui:button type="submit" name="save" value="publish" onclick="publish()"></aui:button>

</aui:form>

<script type="text/javascript">
	
	function saveDraft () {
		document.<portlet:namespace />fm.<portlet:namespace />cmd.value="save-draft";
	}
	
	function publish () {
		document.<portlet:namespace />fm.<portlet:namespace />cmd.value="add";
	}
	
	$('#<portlet:namespace />event-options .icon-plus-sign').click(function (event) {
		event.preventDefault();
		var $clone = $(this).parent('.event-option').clone(true, true);
		
		$clone.children("#<portlet:namespace />eventOptionId").val("0");
		
		$clone.appendTo("#<portlet:namespace />event-options");
	});
</script>