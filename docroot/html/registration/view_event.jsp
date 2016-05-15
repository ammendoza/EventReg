<%@ include file="/html/init.jsp" %>

<%
	Locale locale = request.getLocale();
	Event event = (Event) request.getAttribute("event");
	List<EventOption> eventOptions = (List<EventOption>) request.getAttribute("eventOptions");
%>

<% if (event != null) { %>

	<p class="address"><%= event.getAddress(locale) %> | <%= event.getLocation() %></p>
	
	<div class="description">
		<%= event.getDescription(locale) %>
	</div>
	
	<liferay-ui:search-container 
		emptyResultsMessage="there-are-no-events">

		<liferay-ui:search-container-results
			results="<%= eventOptions %>"
			total="<%= eventOptions.size() %>"
		/>
			
		<liferay-ui:search-container-row
			className="edu.uoc.eventreg.model.EventOption"
			modelVar="option"
		>
			<portlet:actionURL var="registerFormURL" name="registerForm">
				<portlet:param name="eventId" value="<%= String.valueOf(event.getEventId()) %>" />
				<portlet:param name="eventOptionId" value="<%= String.valueOf(option.getEventOptionId()) %>"/>
			</portlet:actionURL>
					
			<liferay-ui:search-container-column-date
				name="title"
				value="<%= option.getStartDate() %>"
				href="<%= registerFormURL %>"
			/>
			
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator paginate="<%= false %>" />
	
	</liferay-ui:search-container>
	
	<c:if test="<%= !event.getCoordX().isEmpty() && ! event.getCoordY().isEmpty() %>">
		<div id="map"></div>
	    <script>
	
			function initMap() {
			  var myLatLng = {lat: <%= event.getCoordY() %>,  lng: <%= event.getCoordX() %>};
			
			  var map = new google.maps.Map(document.getElementById('map'), {
			    zoom: 4,
			    center: myLatLng
			  });
			
			  var marker = new google.maps.Marker({
			    position: myLatLng,
			    map: map,
			    title: '<%= event.getTitle(locale) %>'
			  });
			}
		
		</script>
		<script async defer
		 	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAyTV7adn2NkYj-3iTLW-PVDy9YbQzL-dc&signed_in=true&callback=initMap"></script>
	</c:if>
	
<% } else { %>

	<p><liferay-ui:message key="event-does-not-exist" /></p>
	
<% } %>