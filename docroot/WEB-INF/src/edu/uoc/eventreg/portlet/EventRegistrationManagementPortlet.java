package edu.uoc.eventreg.portlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import edu.uoc.eventreg.model.Event;
import edu.uoc.eventreg.model.impl.EventImpl;
import edu.uoc.eventreg.service.EventLocalServiceUtil;

/**
 * Portlet implementation class EventRegistrationManagementPortlet
 */
public class EventRegistrationManagementPortlet extends MVCPortlet {
 
	public void doView (RenderRequest request, RenderResponse response) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		request.setAttribute("companyId", themeDisplay.getCompanyId());
		request.setAttribute("groupId", themeDisplay.getDoAsGroupId());
		
		super.doView(request, response);
	}
	
	public void addEventForm(ActionRequest request, ActionResponse response) {
		
		response.setRenderParameter("mvcPath", "/html/management/event_form.jsp");
	}
	
	public void saveEvent(ActionRequest request, ActionResponse response) {

		long id = ParamUtil.getLong(request, "id");
		Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(request, "title");
		Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(request, "description");
		Map<Locale, String> addressMap = LocalizationUtil.getLocalizationMap(request, "address");
		Map<Locale, String> locationMap = LocalizationUtil.getLocalizationMap(request, "location");
		String coordX = ParamUtil.getString(request, "coord-x");
		String coordY = ParamUtil.getString(request, "coord-y");
		boolean requiresApproval = ParamUtil.getBoolean(request, "requires-approval");
		String saveStatus = ParamUtil.getString(request, "cmd");
		Date createDate = new Date();
		User user = (User) request.getAttribute(WebKeys.USER);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		Event event = null;
		if (Validator.isNull(id)) {
			event = new EventImpl();
		} else {
			try {
				event = EventLocalServiceUtil.getEvent(id);
			} catch (PortalException | SystemException e) {
				e.printStackTrace();
			}
		}
		
		event.setTitleMap(titleMap);
		event.setDescriptionMap(descriptionMap);
		event.setAddressMap(addressMap);
		event.setLocationMap(locationMap);
		event.setCoordX(coordX);
		event.setCoordY(coordY);
		event.setRequiresApproval(requiresApproval);
		event.setModifiedDate(createDate);
		
		if (saveStatus.equals("save-draft")) {
			event.setStatus(WorkflowConstants.STATUS_DRAFT);
		} else {
			event.setStatus(WorkflowConstants.STATUS_APPROVED);
		}
		
		try {
			if (Validator.isNull(id)) {
				event.setCompanyId(themeDisplay.getCompanyId());
				event.setGroupId(themeDisplay.getDoAsGroupId());
				event.setCreatedBy(user.getUserId());
				event.setCreateDate(createDate);
				
				EventLocalServiceUtil.addEvent(event);
			} else {
				event.persist();
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		SessionMessages.add(request, "event-added-successfuly");
		
	}
	
	public void deleteEvent (ActionRequest request, ActionResponse response) {
		
		long eventId = ParamUtil.getLong(request, "id");
		
		try {
			EventLocalServiceUtil.deleteEvent(eventId);
			SessionMessages.add(request, "event-deleted-successfuly");
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void editEventForm (ActionRequest request, ActionResponse response) {
		
		long eventId = ParamUtil.getLong(request, "id");
		try {
			Event event = (Event) EventLocalServiceUtil.getEvent(eventId);
			request.setAttribute("event", event);
			response.setRenderParameter("mvcPath", "/html/management/event_form.jsp");
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listAttendees(ActionRequest request, ActionResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		request.setAttribute("companyId", themeDisplay.getCompanyId());
		request.setAttribute("groupId", themeDisplay.getDoAsGroupId());
		
		response.setRenderParameter("mvcPath", "/html/management/attendee_list.jsp");
	}

}
