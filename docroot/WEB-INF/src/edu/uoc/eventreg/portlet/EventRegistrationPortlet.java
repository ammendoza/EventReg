package edu.uoc.eventreg.portlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.PwdGenerator;
import com.liferay.util.bridges.mvc.MVCPortlet;

import edu.uoc.eventreg.model.Attendee;
import edu.uoc.eventreg.model.Event;
import edu.uoc.eventreg.model.EventOption;
import edu.uoc.eventreg.model.Image;
import edu.uoc.eventreg.model.impl.AttendeeImpl;
import edu.uoc.eventreg.service.AttendeeLocalServiceUtil;
import edu.uoc.eventreg.service.EventLocalServiceUtil;
import edu.uoc.eventreg.service.EventOptionLocalServiceUtil;
import edu.uoc.eventreg.service.ImageLocalServiceUtil;

public class EventRegistrationPortlet extends MVCPortlet {
	 
	public void doView (RenderRequest request, RenderResponse response) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		request.setAttribute("companyId", themeDisplay.getCompanyId());
		request.setAttribute("groupId", themeDisplay.getLayout().getGroupId());
		
		super.doView(request, response);
	}
	
	public void viewEvent (ActionRequest request, ActionResponse response) {
		long eventId = ParamUtil.getLong(request, "id");
		Event event = null;
		List<EventOption> eventOptions = null;
		List<Image> imageList = null;
				
		try {
			event = (Event) EventLocalServiceUtil.getEvent(eventId);
			eventOptions = (List<EventOption>) EventOptionLocalServiceUtil.findEventOptions(eventId);
			imageList = (List<Image>) ImageLocalServiceUtil.findByEvent(eventId);
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("event", event);
		request.setAttribute("eventOptions", eventOptions);
		request.setAttribute("imageList", imageList);
		response.setRenderParameter("mvcPath", "/html/registration/view_event.jsp");
	}
	
	public void registerForm(ActionRequest request, ActionResponse response) {
		
		String eventOptionId = ParamUtil.getString(request, "eventOptionId");
		long eventId = ParamUtil.getLong(request, "eventId");
		Event event = null;
				
		try {
			event = (Event) EventLocalServiceUtil.getEvent(eventId);
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("requiresApproval", event.getRequiresApproval());
		request.setAttribute("eventOptionId", eventOptionId);
		
		response.setRenderParameter("mvcPath", "/html/registration/register_form.jsp");
	}
	
	public void saveRegisterForm(ActionRequest request, ActionResponse response) {
		
		long eventOptionId = ParamUtil.getLong(request, "eventOptionId");
		EventOption eventOption = null;
		Event event = null;
		Attendee attendee = null;
		
		String name = ParamUtil.getString(request, "name");
		String surname = ParamUtil.getString(request, "surname");
		String company = ParamUtil.getString(request, "company");
		String email = ParamUtil.getString(request, "email");
		String phone = ParamUtil.getString(request, "phone");
		String reservationCode = PwdGenerator.getPassword(10) + "-" + eventOptionId;
				
		try {
			eventOption = (EventOption) EventOptionLocalServiceUtil.getEventOption(eventOptionId);
			event = (Event) EventLocalServiceUtil.getEvent(eventOption.getEventId());
			
			attendee = new AttendeeImpl();
			attendee.setGroupId(eventOption.getGroupId());
			attendee.setCompanyId(eventOption.getCompanyId());
			attendee.setName(name);
			attendee.setSurname(surname);
			attendee.setCompany(company);
			attendee.setEmail(email);
			attendee.setPhone(phone);
			attendee.setReservationCode(reservationCode);
			attendee.setRegisterDate(new Date());
			attendee.setEventOptionId(eventOptionId);
			
			if (event.getRequiresApproval())
				attendee.setStatus(WorkflowConstants.STATUS_PENDING);
			else
				attendee.setStatus(WorkflowConstants.STATUS_APPROVED);
			
			AttendeeLocalServiceUtil.addAttendee(attendee);
			
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("event", event);
		request.setAttribute("eventOption", eventOption);
		request.setAttribute("attendee", attendee);
		
		SessionMessages.add(request, "registration-success");
		
		response.setRenderParameter("mvcPath", "/html/registration/register_details.jsp");
	}
	
}
