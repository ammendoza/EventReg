<%
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="edu.uoc.eventreg.service.EventLocalServiceUtil"%>
<%@ page import="edu.uoc.eventreg.portlet.search.EventDisplayTerms" %>
<%@ include file="/html/init.jsp" %>
<% 
	long companyId = (Long) request.getAttribute("companyId");
	long groupId = (Long) request.getAttribute("groupId");
	Locale locale = request.getLocale();
	String defaultUsername = "";
	
	String currentURL = PortalUtil.getCurrentURL(request);
	String title = ParamUtil.getString(request, "title");
	String description = ParamUtil.getString(request, "description");
	String location = ParamUtil.getString(request, "location");
	int status = WorkflowConstants.STATUS_APPROVED;
	SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MMM d k:mm");
	SimpleDateFormat timeFormat = new SimpleDateFormat("k:mm");
%>

<liferay-ui:calendar year="2016" month="5" />

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="title" value="<%= title %>" />
	<portlet:param name="description" value="<%= description %>" />
	<portlet:param name="location" value="<%= location %>" />
	<portlet:param name="status" value="<%= String.valueOf(status) %>" />
</liferay-portlet:renderURL>

<liferay-ui:search-container 
	emptyResultsMessage="there-are-no-events" 
	displayTerms="<%= new EventDisplayTerms(renderRequest) %>" 
	iteratorURL="<%= iteratorURL %>">

	<liferay-ui:search-container-results>
		<%
		EventDisplayTerms displayTerms = (EventDisplayTerms) searchContainer.getDisplayTerms();
		if (displayTerms.isAdvancedSearch()) {
			total = EventLocalServiceUtil.searchEventsCount(companyId, groupId, title, description, location, status, displayTerms.isAndOperator());
			results = EventLocalServiceUtil.searchEvents(companyId, groupId, title, description, location, status, displayTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd());
		} else {
			String searchkeywords = displayTerms.getKeywords().trim();
			
			if (searchkeywords.isEmpty()) {
				results = EventLocalServiceUtil.findGroupEvents(companyId, groupId);
				total = results.size();
				results = ListUtil.subList(results, searchContainer.getStart(), searchContainer.getEnd());
			} else {
				total = EventLocalServiceUtil.searchEventsCount(companyId, groupId, searchkeywords, searchkeywords, searchkeywords, 0, false);
				results = EventLocalServiceUtil.searchEvents(companyId, groupId, searchkeywords, searchkeywords, searchkeywords, 0, false, searchContainer.getStart(), searchContainer.getEnd());
			}
		}
		
		searchContainer.setTotal(total);
		searchContainer.setResults(results);
		
		%>
	</liferay-ui:search-container-results>
		
	<liferay-ui:search-container-row
		className="edu.uoc.eventreg.model.Event"
		modelVar="event"
	>
		<portlet:actionURL var="viewEventURL" name="viewEvent">
			<portlet:param name="id" value="<%= String.valueOf(event.getEventId()) %>"/>
		</portlet:actionURL>
		
		<%
			long seats = event.getAvailableSeats();
		%>
				
		<liferay-ui:search-container-column-text
			name="title">
			
				<span class="event-title">
					<c:if test="<%= seats != 0 %>">
						<a href="<%= viewEventURL %>">
					</c:if>
					<%= event.getTitle(locale) %>
					<c:if test="<%= seats != 0 %>">
						</a>
					</c:if>
				</span>
				<span class="dates">
					<%
						Calendar startDate = Calendar.getInstance();
						startDate.setTime(event.getStartDate());
						
						Calendar endDate = Calendar.getInstance();
						endDate.setTime(event.getEndDate());
						
						boolean sameDay = false;
						if (startDate.get(Calendar.DAY_OF_MONTH) == endDate.get(Calendar.DAY_OF_MONTH) &&
								startDate.get(Calendar.MONTH) == endDate.get(Calendar.MONTH) &&
								startDate.get(Calendar.YEAR) == endDate.get(Calendar.YEAR))
							sameDay = true;
					%>
					<c:choose>
						<c:when test="<%= sameDay %>">
							<%= dateFormat.format(event.getStartDate()) %> | 
							<%= timeFormat.format(event.getStartDate()) %> - 
							<%= timeFormat.format(event.getEndDate()) %>
						</c:when>
						<c:otherwise>
							<%= dateTimeFormat.format(event.getStartDate()) %> | 
							<%= dateTimeFormat.format(event.getEndDate()) %>
						</c:otherwise>
					</c:choose>
				</span>
				<c:if test="<%= seats < 5 %>">
					<span class="seats"><liferay-ui:message key="last-available-seats" /></span>
				</c:if>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text
			name="price">
				<c:choose>
					<c:when test="<%= event.getPrice() == 0 %>">
						<liferay-ui:message key="free" />
					</c:when>
					<c:otherwise>
						<%= event.getPrice() %>
					</c:otherwise>
				</c:choose>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text
			align="right">
				<aui:button value="<%= (seats == 0) ? \"agotado\" : \"register\" %>" href="<%= viewEventURL %>" cssClass="<%= (seats == 0) ? \"btn\" : \"btn btn-primary\" %>" />
		</liferay-ui:search-container-column-text>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="<%= true %>" />

</liferay-ui:search-container>
