<%@ include file="/html/init.jsp" %>
<%
	String eventStats = (String) request.getAttribute("eventStats");
	String attendeeStats = (String) request.getAttribute("attendeeStats");
	String categoryStats = (String) request.getAttribute("categoryStats");
	String prevStatsLink = (String) request.getAttribute("prevStatsLink");
	String nextStatsLink = (String) request.getAttribute("nextStatsLink");
	String eventId = (String) request.getAttribute("eventId");
%>


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
	        }
	        <c:if test="<%= !eventStats.isEmpty() %>">
		        , {
		            name: '<liferay-ui:message key="events" />',
		            data: [<%= eventStats %>]
		        }
	        </c:if>
	        ],
	    });
	});
</script>

<portlet:renderURL var="prevStatsURL">
	<portlet:param name="lastDay" value="<%= prevStatsLink %>"/>
</portlet:renderURL>

<portlet:renderURL var="nextStatsURL">
	<portlet:param name="lastDay" value="<%= nextStatsLink %>"/>
</portlet:renderURL>

<portlet:actionURL var="prevStatsActionURL" name="eventStats">
	<portlet:param name="lastDay" value="<%= prevStatsLink %>"/>
	<portlet:param name="eventId" value="<%= eventId %>" />
</portlet:actionURL>

<portlet:actionURL var="nextStatsActionURL" name="eventStats">
	<portlet:param name="lastDay" value="<%= nextStatsLink %>"/>
	<portlet:param name="eventId" value="<%= eventId %>" />
</portlet:actionURL>

	
<a href="<%= (eventStats.isEmpty()) ? prevStatsActionURL : prevStatsURL %>" class="btn">
	<i class="icon icon-chevron-left"></i> <liferay-ui:message key="previous" />
</a>
	
<c:if test="<%= !nextStatsLink.isEmpty() %>">
	<a href="<%= (eventStats.isEmpty()) ? nextStatsActionURL : nextStatsURL %>" class="btn pull-right">
		<liferay-ui:message key="next" /> <i class="icon icon-chevron-right"></i>
	</a>
</c:if>