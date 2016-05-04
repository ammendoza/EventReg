<%@ include file="init.jsp" %>
<% 
	List<Event> events = (List<Event>) request.getAttribute("events");
	Locale locale = request.getLocale();
	String defaultUsername = "";
%>

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
			
			<liferay-ui:search-container-column-text
				name="created-by"
				value="<%= PortalUtil.getUserName(event.getCreatedBy(), defaultUsername) %>"
			/>
			
			<liferay-ui:search-container-column-date
				name="create-date"
				value="<%= event.getCreateDate() %>"
			/>
			
			<liferay-ui:search-container-column-jsp 
				path="/html/management/event_action.jsp" 
			/>
			
		</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="<%= true %>" />

</liferay-ui:search-container>
