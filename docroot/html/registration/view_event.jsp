<%@ page import="edu.uoc.eventreg.model.Image" %>
<%@ page import="edu.uoc.eventreg.portlet.EventRegistrationUtil" %>
<%@ include file="/html/init.jsp" %>

<%
	Locale locale = request.getLocale();
	Event event = (Event) request.getAttribute("event");
	List<EventOption> eventOptions = (List<EventOption>) request.getAttribute("eventOptions");
	List<Image> imageList = (List<Image>) request.getAttribute("imageList");
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MMM d k:mm");
	SimpleDateFormat timeFormat = new SimpleDateFormat("k:mm");
	
	int optionNum = 1;
%>

<% if (event != null) { %>

	<div id="eventImages" class="carousel slide pull-right">
	  <div class="carousel-inner">
	  	<% 
	  	boolean firstImage = true;
	  	for (Image image: imageList) { %>
		    <div class="item <%= firstImage ? "active" : StringPool.BLANK %>">
		    	<img src="<%= EventRegistrationUtil.getImageUrl(image.getDlFileEntryId(), request) %>" alt="" />
		    </div>
	    <% 
	    	firstImage = false;
	    } 
	    %>
	  </div>
	  <a class="carousel-control left" href="#eventImages" data-slide="prev">&lsaquo;</a>
	  <a class="carousel-control right" href="#eventImages" data-slide="next">&rsaquo;</a>
	</div>

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
					
			<liferay-ui:search-container-column-text
				href="<%= registerFormURL %>">
			
				<span class="event-title"><liferay-ui:message key="session" /> <%= optionNum %></span>
				<%
						optionNum++;
				
						Calendar startDate = Calendar.getInstance();
						startDate.setTime(option.getStartDate());
						
						Calendar endDate = Calendar.getInstance();
						endDate.setTime(option.getEndDate());
						
						boolean sameDay = false;
						if (startDate.get(Calendar.DAY_OF_MONTH) == endDate.get(Calendar.DAY_OF_MONTH) &&
								startDate.get(Calendar.MONTH) == endDate.get(Calendar.MONTH) &&
								startDate.get(Calendar.YEAR) == endDate.get(Calendar.YEAR))
							sameDay = true;
					%>
					<c:choose>
						<c:when test="<%= sameDay %>">
							<%= dateFormat.format(option.getStartDate()) %> | 
							<%= timeFormat.format(option.getStartDate()) %> - 
							<%= timeFormat.format(option.getEndDate()) %>
						</c:when>
						<c:otherwise>
							<%= dateTimeFormat.format(option.getStartDate()) %> | 
							<%= dateTimeFormat.format(option.getEndDate()) %>
						</c:otherwise>
					</c:choose>
			
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text
				name="available-seats"
				value="<%= String.valueOf(option.getAvailableSeats()) %>"
				/>
			
			<liferay-ui:search-container-column-text
				align="right">
			<aui:button value="register" href="<%= registerFormURL %>" cssClass="btn btn-primary" />
		</liferay-ui:search-container-column-text>
			
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