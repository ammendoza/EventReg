<%@ include file="/html/init.jsp" %>
<%@page import="edu.uoc.eventreg.model.Image" %>
<%@page import="edu.uoc.eventreg.portlet.EventRegistrationUtil" %>

<%
	long eventId = (Long) request.getAttribute("eventId");
	List<Image> list = (List<Image>) request.getAttribute("imageList");

%>

<aui:nav-bar>
	<aui:nav id="toolbarContainer">
		<liferay-portlet:renderURL var="viewEventsURL" />
		<aui:nav-item href="<%= viewEventsURL %>" iconCssClass="icon-th-list" label="view-events" />
		
		<liferay-portlet:actionURL name="imageForm" var="imageFormURL">
			<portlet:param name="eventId" value="<%= String.valueOf(eventId) %>" />
		</liferay-portlet:actionURL>
		<aui:nav-item href="<%= imageFormURL %>" iconCssClass="icon-plus" label="add-image" />
	</aui:nav>
</aui:nav-bar>

<div class="event-images">
	<% for (Image image: list) { %>
	
		<div class="row-fluid">
			<div class="span10">
				<img src="<%= EventRegistrationUtil.getImageUrl(image.getDlFileEntryId(), request) %>" alt="" class="img-polaroid" width="200" />
			</div>
			<div class="span2">
				<span class="entry-action overlay">
					<liferay-ui:icon-menu direction="down" extended="<%= false %>" icon="<%= StringPool.BLANK %>" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>" triggerCssClass="btn">

						<portlet:actionURL var="editImageURL" name="imageForm">
							<portlet:param name="imageId" value="<%= String.valueOf(image.getImageId()) %>"/>
							<portlet:param name="eventId" value="<%= String.valueOf(image.getEventId()) %>" />
						</portlet:actionURL>
			
						<liferay-ui:icon
							image="edit"
							message="edit"
							url="<%= editImageURL %>"
						/>
			
						<portlet:actionURL var="deleteImageURL" name="deleteImage">
							<portlet:param name="imageId" value="<%= String.valueOf(image.getImageId()) %>"/>
						</portlet:actionURL>
			
						<liferay-ui:icon
							image="delete"
							message="delete"
							url="<%= deleteImageURL %>"
						/>
							
					</liferay-ui:icon-menu>
				</span>
			</div>
		</div>
		<hr />
	<% } %>
</div>