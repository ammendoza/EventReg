<%@ page import="edu.uoc.eventreg.model.Image" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.util.PortletKeys" %>
<%@ include file="/html/init.jsp" %>
<%
String portletResource = ParamUtil.getString(request, "portletResource");

	Image image = (Image) request.getAttribute("image");
	long eventId = (Long) request.getAttribute("eventId");
%>

<liferay-portlet:actionURL name="saveImage" var="saveImageURL" />

<liferay-portlet:renderURL
	portletName="<%=PortletKeys.DYNAMIC_DATA_MAPPING %>" 
	var="selectFileURL" windowState="<%= 
	LiferayWindowState.POP_UP.toString() %>">
    	<portlet:param name="struts_action" value='/dynamic_data_mapping/select_document_library' />
</liferay-portlet:renderURL>

<aui:form action="<%= saveImageURL %>" name="fm">

	<c:if test="<%= image != null %>">
		<aui:input type="hidden" name="imageId" value="<%= image.getImageId() %>" />
	</c:if>
	<aui:input type="hidden" name="eventId" value="<%= eventId %>" />
	
    <aui:field-wrapper label="select-image">
        <div class="input-append">
            <aui:input name="fileId" type="hidden" value="<%= (image!=null) ? image.getDlFileEntryId() : StringPool.BLANK %>" />
            <aui:input name="groupId" type="hidden" value="<%= (image!=null) ? image.getGroupId() : StringPool.BLANK %>" />
            <aui:input name="fileName" type="text" readonly="true" label="" value="<%= (image!=null) ? \"current-image\" : StringPool.BLANK %>">
            	<aui:validator name="required" />
            </aui:input>
            <aui:button name="openFileSelectorButton" value="select"/>
        </div>
    </aui:field-wrapper>
    
    <aui:button type="submit" name="save" value="save" />
    
</aui:form>


 <aui:script use="aui-base">
     A.one('#<portlet:namespace />openFileSelectorButton').on(
             'click',
             function(event) {
                 Liferay.Util.selectEntity(
                     {
                         dialog: {
                             constrain: true,
                             modal: true
                         },
                         id: '<portlet:namespace />selectFileFromDocumentLibrary',
                         title: '<liferay-ui:message arguments="file" key="select-x" />',
                         uri: '<%= selectFileURL.toString() %>'
                     },
                     _166_selectDocumentLibrary = function(url, uuid, groupId, fileName, version){
                          document.getElementById("<portlet:namespace/>fileName").value = fileName;
                          document.getElementById("<portlet:namespace/>fileId").value = uuid;
                          document.getElementById("<portlet:namespace/>groupId").value = groupId;
                     }
                 );
             }
     );
 </aui:script>