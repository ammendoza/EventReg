package edu.uoc.eventreg.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.mail.MailEngine;

import edu.uoc.eventreg.model.Attendee;
import edu.uoc.eventreg.model.Event;
import edu.uoc.eventreg.model.EventOption;
import edu.uoc.eventreg.model.impl.EventImpl;
import edu.uoc.eventreg.model.impl.EventOptionImpl;
import edu.uoc.eventreg.service.AttendeeLocalServiceUtil;
import edu.uoc.eventreg.service.EventLocalServiceUtil;
import edu.uoc.eventreg.service.EventOptionLocalServiceUtil;

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
		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getDoAsGroupId();
		
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
				event.setCompanyId(companyId);
				event.setGroupId(groupId);
				event.setCreatedBy(user.getUserId());
				event.setCreateDate(createDate);
				
				event = EventLocalServiceUtil.addEvent(event);
			} else {
				event.persist();
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		//Add event options
		String[] eventOptionIds = ParamUtil.getParameterValues(request, "eventOptionId");
		String[] startDates = ParamUtil.getParameterValues(request, "startDate");
		String[] startHours = ParamUtil.getParameterValues(request, "startHour");
		String[] endDates = ParamUtil.getParameterValues(request, "endDate");
		String[] endHours = ParamUtil.getParameterValues(request, "endHour");
		String[] seats = ParamUtil.getParameterValues(request, "seats");
		
		System.out.println("startDate " + startDates[0] + " | num: " + startDates.length);
		System.out.println("endDate " + endDates[0] + " | num: " + endDates.length);
		System.out.println("startHour " + startHours[0] + " - " + startHours[1] + " | num: " + startHours.length);
		System.out.println("endHour " + endHours[0] + " - " + endHours[1] + " | num: " + endHours.length);
		System.out.println("seats " + seats[0] + " | num: " + seats.length);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy HH:mm");
		int hourCount = 0;
		
		if (Validator.isNull(id)) {
			
			for (int i=0; i<startDates.length; i++) {
				EventOption eventOption = new EventOptionImpl();
				eventOption.setGroupId(groupId);
				eventOption.setCompanyId(companyId);
				eventOption.setEventId(event.getEventId());
				
				try {
					Date startDate = formatter.parse(startDates[i] + " " + startHours[hourCount]);
					Date endDate = formatter.parse(endDates[i] + " " + endHours[hourCount]);
					eventOption.setStartDate(startDate);
					eventOption.setEndDate(endDate);
					
					int seatNum = Integer.parseInt(seats[i]);
					eventOption.setSeats(seatNum);
					
					EventOptionLocalServiceUtil.addEventOption(eventOption);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				hourCount = hourCount + 2;
			}
		} else {
			
			for (int i=0; i<startDates.length; i++) {
				int eventOptionId = Integer.parseInt(eventOptionIds[i]);
				EventOption eventOption = null;
				
				try {
					if (eventOptionId != 0) {
						eventOption = EventOptionLocalServiceUtil.getEventOption(eventOptionId);
					} else {
						eventOption = new EventOptionImpl();
						eventOption.setGroupId(groupId);
						eventOption.setCompanyId(companyId);
						eventOption.setEventId(event.getEventId());
					}

					Date startDate = formatter.parse(startDates[i] + " " + startHours[hourCount]);
					Date endDate = formatter.parse(endDates[i] + " " + endHours[hourCount]);
					eventOption.setStartDate(startDate);
					eventOption.setEndDate(endDate);
					
					int seatNum = Integer.parseInt(seats[i]);
					eventOption.setSeats(seatNum);
					
					if (eventOptionId != 0) {
						EventOptionLocalServiceUtil.addEventOption(eventOption);
					} else {
						eventOption.persist();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				hourCount = hourCount + 2;
			}
			
		}
		
		SessionMessages.add(request, "event-added-successfuly");
		
	}
	
	public void deleteEvent (ActionRequest request, ActionResponse response) {
		
		long eventId = ParamUtil.getLong(request, "id");
		
		try {
			EventLocalServiceUtil.deleteEvent(eventId);
			SessionMessages.add(request, "event-deleted-successfuly");
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		
	}
	
	public void editEventForm (ActionRequest request, ActionResponse response) {
		
		long eventId = ParamUtil.getLong(request, "id");
		Event event = null;
		List<EventOption> eventOptions = null;
		
		try {
			event = (Event) EventLocalServiceUtil.getEvent(eventId);
			eventOptions = (List<EventOption>) EventOptionLocalServiceUtil.findEventOptions(eventId);
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("event", event);
		request.setAttribute("eventOptions", eventOptions);
		response.setRenderParameter("mvcPath", "/html/management/event_form.jsp");
	}
	
	public void listAttendees(ActionRequest request, ActionResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long eventId = ParamUtil.getLong(request, "eventId");
		
		request.setAttribute("companyId", themeDisplay.getCompanyId());
		request.setAttribute("groupId", themeDisplay.getDoAsGroupId());
		request.setAttribute("eventId", eventId);
		
		response.setRenderParameter("mvcPath", "/html/management/attendee_list.jsp");
	}
	
	public void viewAttendee(ActionRequest request, ActionResponse response) {
		long attendeeId = ParamUtil.getLong(request, "attendeeId");
		
		Attendee attendee = null;
		EventOption eventOption = null;
		Event event = null;
		
		try {
			attendee = AttendeeLocalServiceUtil.getAttendee(attendeeId);
			eventOption = EventOptionLocalServiceUtil.getEventOption(attendee.getEventOptionId());
			event = EventLocalServiceUtil.getEvent(eventOption.getEventId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("attendee", attendee);
		request.setAttribute("eventOption", eventOption);
		request.setAttribute("event", event);
		
		response.setRenderParameter("mvcPath", "/html/management/attendee_view.jsp");
	}
	
	public void changeAttendeeStatus(ActionRequest request, ActionResponse response){
		
		long attendeeId = ParamUtil.getLong(request, "attendeeId");
		int status = ParamUtil.getInteger(request, "status");
		
		request.setAttribute("attendeeId", attendeeId);
		request.setAttribute("status", status);
		response.setRenderParameter("mvcPath", "/html/management/attendee_send_email.jsp");
		
	}
	
	public void changeAttendeeStatusSend(ActionRequest request, ActionResponse response){
		
		long attendeeId = ParamUtil.getLong(request, "attendeeId");
		int status = ParamUtil.getInteger(request, "status");
		String message = ParamUtil.getString(request, "message");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		PortletConfig portletConfig = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		
		Attendee attendee = null;

		try {
			attendee = AttendeeLocalServiceUtil.getAttendee(attendeeId);
			
			String fromAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			String emailBodyKey = "";
			String subjectKey = "";
			if (status == WorkflowConstants.STATUS_APPROVED) {
					emailBodyKey = "email-body-accepted";
					subjectKey = "email-subject-accepted";
			} else {
					emailBodyKey = "email-body-rejected";
					subjectKey = "email-subject-rejected";
			}
			String emailBody = LanguageUtil.get(portletConfig, locale, emailBodyKey).replace("{0}", attendee.getReservationCode());
			
			if (!message.isEmpty()) {
				emailBody += "\n\n" + LanguageUtil.get(portletConfig, locale, "reviewer-message");
				emailBody += "\n" + message;
			}
			
			MailMessage mail = new MailMessage();
			mail.setSubject(LanguageUtil.get(portletConfig, locale, subjectKey));
			mail.setFrom(new InternetAddress(fromAddress));
			mail.setTo(new InternetAddress(attendee.getEmail(), attendee.getName()));
			mail.setBody(emailBody);
			MailEngine.send(mail);
			
			attendee.setStatus(status);
			attendee.persist();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SessionMessages.add(request, "the-email-was-sent-successfully");
		listAttendees(request, response);
	}

}
