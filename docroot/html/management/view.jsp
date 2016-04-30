<%@ page import="edu.uoc.eventreg.model.Event" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<% 
	List<Event> events = (List<Event>) request.getAttribute("events");
	Locale locale = request.getLocale();
%>

<portlet:defineObjects />

<liferay-ui:search-container emptyResultsMessage="there-are-no-events">

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
		</aui:nav>
	
		<!-- <aui:nav-bar-search cssClass="pull-right" file="/html/portlet/journal/article_search.jsp" /> -->
	</aui:nav-bar>

	<liferay-ui:search-container-results
		results="<%= events %>"
		total="<%= events.size() %>" 
	/>
		
		<liferay-ui:search-container-row
			className="edu.uoc.eventreg.model.Event"
			modelVar="event"
		>
					
			<liferay-ui:search-container-column-text
				name="title"
				value="<%= event.getTitle(locale) %>"
			/>
			
		</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="<%= true %>" />

</liferay-ui:search-container>
