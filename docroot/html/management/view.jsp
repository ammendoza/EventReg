<%@page import="edu.uoc.eventreg.service.EventLocalServiceUtil"%>
<%@ page import="edu.uoc.eventreg.portlet.search.EventDisplayTerms" %>
<%@ include file="/html/init.jsp" %>
<% 
	String eventStats = (String) request.getAttribute("eventStats");
	String attendeeStats = (String) request.getAttribute("attendeeStats");
	String categoryStats = (String) request.getAttribute("categoryStats");
	long companyId = (Long) request.getAttribute("companyId");
	long groupId = (Long) request.getAttribute("groupId");
	Locale locale = request.getLocale();
	String defaultUsername = "";
	
	String currentURL = PortalUtil.getCurrentURL(request);
	String title = ParamUtil.getString(request, "title");
	String description = ParamUtil.getString(request, "description");
	String location = ParamUtil.getString(request, "location");
	int status = ParamUtil.getInteger(request, "status");
%>

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
			total = EventLocalServiceUtil.searchEventsCount(companyId, groupId, title, description, location, status, false, displayTerms.isAndOperator());
			results = EventLocalServiceUtil.searchEvents(companyId, groupId, title, description, location, status, false, displayTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd());
		} else {
			String searchkeywords = displayTerms.getKeywords().trim();
			
			if (searchkeywords.isEmpty()) {
				results = EventLocalServiceUtil.findGroupEvents(companyId, groupId);
				total = results.size();
				results = ListUtil.subList(results, searchContainer.getStart(), searchContainer.getEnd());
			} else {
				total = EventLocalServiceUtil.searchEventsCount(companyId, groupId, searchkeywords, searchkeywords, searchkeywords, 0, false, false);
				results = EventLocalServiceUtil.searchEvents(companyId, groupId, searchkeywords, searchkeywords, searchkeywords, 0, false, false, searchContainer.getStart(), searchContainer.getEnd());
			}
		}
		
		searchContainer.setTotal(total);
		searchContainer.setResults(results);
		
		%>
	</liferay-ui:search-container-results>

	<aui:nav-bar>
		<aui:nav collapsible="<%= false %>" cssClass="nav-display-style-buttons pull-right" id="displayStyleButtons">
			<aui:nav-item>
				<span class="pull-left display-style-buttons-container" id="<portlet:namespace />displayStyleButtonsContainer">
					
				</span>
			</aui:nav-item>
		</aui:nav>
	
		<aui:nav id="toolbarContainer">
			<liferay-portlet:actionURL name="addEventForm" var="addEventFormURL" />
			<aui:nav-item href="<%= addEventFormURL %>" iconCssClass="icon-plus" label="add-event" />
			
			<liferay-portlet:actionURL name="listAttendees" var="listAttendeesURL" />
			<aui:nav-item href="<%= listAttendeesURL %>" iconCssClass="icon-th-list" label="view-registered" />
		</aui:nav>
	
		<c:if test="<%= results != null && results.size() != 0 %>">
			<aui:nav-bar-search cssClass="pull-right">
				<liferay-ui:search-form servletContext="<%= this.getServletContext()%>"
					 page="/html/management/event_search.jsp" />
			</aui:nav-bar-search>
		</c:if>
	</aui:nav-bar>
	
	<script src="http://code.highcharts.com/highcharts.js"></script>
	<div id="container" style="height: 300px"></div>
	<script type="text/javascript">
		$(function () {
		    $('#container').highcharts({
		        chart: {
		            type: 'area'
		        },
		        title:{
		            text: null
		        },
		        xAxis: {
		            categories: [<%= categoryStats %>],
		            reversed: true
		        },
		        yAxis: {
		            title: {
		                text: null
		            }
		        },
		        plotOptions: {
		            area: {
		                fillOpacity: 0.5
		            }
		        },
		        series: [{
		            name: '<liferay-ui:message key="users-registered" />',
		            data: [<%= attendeeStats %>]
		        }, {
		            name: '<liferay-ui:message key="events" />',
		            data: [<%= eventStats %>]
		        }],
		    });
		});
	</script>
		
	<liferay-ui:search-container-row
		className="edu.uoc.eventreg.model.Event"
		modelVar="event"
	>
				
		<liferay-ui:search-container-column-text
			name="title"
			value="<%= event.getTitle(locale) %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="created-by"
			value="<%= PortalUtil.getUserName(event.getCreatedBy(), defaultUsername) %>"
		/>
		
		<liferay-ui:search-container-column-date
			name="create-date"
			value="<%= event.getCreateDate() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="status"
			value="<%= WorkflowConstants.getStatusLabel(event.getStatus()) %>"
			translate="true"
		/>
					
		<liferay-ui:search-container-column-jsp 
			path="/html/management/event_action.jsp" 
		/>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="<%= true %>" />

</liferay-ui:search-container>
