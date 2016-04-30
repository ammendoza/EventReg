<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

<h2>Add event</h2>

<liferay-portlet:actionURL name="addEvent" var="addEventURL"></liferay-portlet:actionURL>
<aui:form action="<%= addEventURL %>" method="post">
	
	<aui:field-wrapper label="title" required="true">
		<liferay-ui:input-localized name="title" xml="" ></liferay-ui:input-localized>
	</aui:field-wrapper>
	
	<aui:field-wrapper label="location" required="true">
		<liferay-ui:input-localized name="location" xml=""></liferay-ui:input-localized>
	</aui:field-wrapper>
	
	<aui:field-wrapper label="address">
		<liferay-ui:input-localized name="address" xml=""></liferay-ui:input-localized>
	</aui:field-wrapper>
	
	<aui:input name="coord-x" type="text"></aui:input>
	<aui:input name="coord-y" type="text"></aui:input>
	
	<aui:field-wrapper label="description" required="true">
		<liferay-ui:input-localized name="description" xml="" type="editor"></liferay-ui:input-localized>
	</aui:field-wrapper>
	
	<aui:input name="requires-approval" type="checkbox"></aui:input>
	
	<aui:button type="submit" value="send"></aui:button>

</aui:form>