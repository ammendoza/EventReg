<%@ include file="/html/init.jsp" %>
<%
	String eventStats = (String) request.getAttribute("eventStats");
	String attendeeStats = (String) request.getAttribute("attendeeStats");
	String categoryStats = (String) request.getAttribute("categoryStats");
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
		        }],
		    });
		});
	</script>