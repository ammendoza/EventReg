package edu.uoc.eventreg.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
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
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMessages;

import edu.uoc.eventreg.model.Attendee;
import edu.uoc.eventreg.model.Event;
import edu.uoc.eventreg.model.EventOption;
import edu.uoc.eventreg.model.Image;
import edu.uoc.eventreg.model.impl.EventImpl;
import edu.uoc.eventreg.model.impl.EventOptionImpl;
import edu.uoc.eventreg.model.impl.ImageImpl;
import edu.uoc.eventreg.service.AttendeeLocalServiceUtil;
import edu.uoc.eventreg.service.EventLocalServiceUtil;
import edu.uoc.eventreg.service.EventOptionLocalServiceUtil;
import edu.uoc.eventreg.service.ImageLocalServiceUtil;

/**
 * Portlet implementation class EventRegistrationManagementPortlet
 */
public class EventRegistrationManagementPortlet extends MVCPortlet {
 
	public void doView (RenderRequest request, RenderResponse response) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getDoAsGroupId();
		List<Object[]> eventDayCount = EventLocalServiceUtil.findDayCount(companyId, groupId);
		List<Object[]> attendeeDayCount = AttendeeLocalServiceUtil.findDayCount(companyId, groupId);
		
		setStatistics(request, eventDayCount, attendeeDayCount, ParamUtil.getString(request, "lastDay"));
		
		request.setAttribute("companyId", companyId);
		request.setAttribute("groupId", groupId);
		
		super.doView(request, response);
	}
	
	private void setStatistics(PortletRequest request,
			List<Object[]> eventDayCount, List<Object[]> attendeeDayCount, String dateParam) {
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		Calendar lastDay = Calendar.getInstance();
		if (dateParam != null && !dateParam.isEmpty()) {
			try {
				date = formatter.parse(dateParam);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			lastDay.setTime(date);
		}
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		if (lastDay != null) {
			cal.set(Calendar.DAY_OF_MONTH, lastDay.get(Calendar.DAY_OF_MONTH));
			cal.set(Calendar.MONTH, lastDay.get(Calendar.MONTH));
			cal.set(Calendar.YEAR, lastDay.get(Calendar.YEAR));
		}
		cal.add(Calendar.DAY_OF_MONTH, -1);
		
		int eventIndex = 0;
		int attendeeIndex = 0;
		Date eventDate = (eventDayCount != null && eventDayCount.get(0) != null) ? (Date) eventDayCount.get(eventIndex)[0] : cal.getTime();
		Date attendeeDate = (Date) attendeeDayCount.get(attendeeIndex)[0];
		String eventStats = "";
		String attendeeStats = "";
		String categoryStats = "";
		
		if (!eventDate.before(cal.getTime())) {
			for (int i=0; i < eventDayCount.size(); i++) {
				eventDate = (Date) eventDayCount.get(i)[0];
				if (eventDate.before(cal.getTime())) {
					eventIndex = i;
					break;
				}
			}
		}
		
		if (!attendeeDate.before(cal.getTime())) {
			for (int i=0; i < attendeeDayCount.size(); i++) {
				attendeeDate = (Date) attendeeDayCount.get(i)[0];
				if (attendeeDate.before(cal.getTime())) {
					attendeeIndex = i;
					break;
				}
			}
		}
		
		for (int i=0; i<=30; i++) {
			if (i > 0) {
				cal.add(Calendar.DAY_OF_MONTH, -1);
			}
			
			if (i != 0) {
				if (eventDayCount != null) {
					eventStats += ",";
				}
				attendeeStats += ",";
				categoryStats += ",";
			}
			
			categoryStats += "'"+ cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH)+1) + "'";
			
			if (eventDayCount != null && eventIndex < eventDayCount.size() && cal.getTimeInMillis() == eventDate.getTime()) {
				eventStats += eventDayCount.get(eventIndex)[1];
				eventIndex++;
				if (eventIndex < eventDayCount.size())
					eventDate = (Date) eventDayCount.get(eventIndex)[0];
			} else if (eventDayCount != null) {
				eventStats += "0";
			}
			
			if (attendeeDayCount != null && attendeeIndex < attendeeDayCount.size() && cal.getTimeInMillis() == attendeeDate.getTime()) {
				attendeeStats += attendeeDayCount.get(attendeeIndex)[1];
				attendeeIndex++;
				if (attendeeIndex < attendeeDayCount.size())
					attendeeDate = (Date) attendeeDayCount.get(attendeeIndex)[0];
			} else {
				attendeeStats += "0";
			}
			
		}

		Calendar prevStats = Calendar.getInstance();
		Calendar nextStats = Calendar.getInstance();
		
		if (lastDay != null) {
			prevStats.setTime(lastDay.getTime());
			nextStats.setTime(lastDay.getTime());
		}

		prevStats.add(Calendar.DAY_OF_MONTH, -31);
		String prevStatsLink = formatter.format(prevStats.getTime());

		nextStats.add(Calendar.DAY_OF_MONTH, 31);
		String nextStatsLink = "";
		if (nextStats.before(Calendar.getInstance())) {
			nextStatsLink = formatter.format(nextStats.getTime());
		}
		
		request.setAttribute("prevStatsLink", prevStatsLink);
		request.setAttribute("nextStatsLink", nextStatsLink);
		
		request.setAttribute("categoryStats", categoryStats);
		request.setAttribute("eventStats", eventStats);
		request.setAttribute("attendeeStats", attendeeStats);
		
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
		
		Date minDate = null;
		Date maxDate = null;
		
		int totalSeats = 0;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
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
					
					if (minDate == null || minDate.compareTo(startDate) == 1)
						minDate = startDate;
					
					if (maxDate == null || maxDate.compareTo(endDate) == -1)
						maxDate = endDate;
					
					int seatNum = Integer.parseInt(seats[i]);
					eventOption.setSeats(seatNum);
					totalSeats += seatNum;
					
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
					
					if (startDate.before(endDate)) {
					
						eventOption.setStartDate(startDate);
						eventOption.setEndDate(endDate);
						
						
						if (minDate == null || minDate.compareTo(startDate) == 1)
							minDate = startDate;
						
						if (maxDate == null || maxDate.compareTo(endDate) == -1)
							maxDate = endDate;
						
						int seatNum = Integer.parseInt(seats[i]);
						eventOption.setSeats(seatNum);
						totalSeats += seatNum;
						
						if (eventOptionId == 0) {
							EventOptionLocalServiceUtil.addEventOption(eventOption);
						} else {
							eventOption.persist();
						}
					} else {
						SessionErrors.add(request, "error-start-date-before-end-date");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				hourCount = hourCount + 2;
			}
			
		}
		
		try {
			if (SessionErrors.isEmpty(request)) {
				event.setStartDate(minDate);
				event.setEndDate(maxDate);
				
				event.persist();
				
				SessionMessages.add(request, "event-added-successfuly");
			} else {
				editEventForm(request, response);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
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
	
	public void eventStats (ActionRequest request, ActionResponse response) {
		
		long eventId = ParamUtil.getLong(request, "eventId");
		List<Object[]> attendeeDayCount = AttendeeLocalServiceUtil.findDayCount(eventId);
		
		setStatistics(request, null, attendeeDayCount, ParamUtil.getString(request, "lastDay"));
		
		request.setAttribute("eventId", String.valueOf(eventId));
		
		response.setRenderParameter("mvcPath", "/html/management/event_stats.jsp");
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
	
	public void listImages (ActionRequest request, ActionResponse response) {
		
		long eventId = ParamUtil.getLong(request, "eventId");
		
		List<Image> imageList = ImageLocalServiceUtil.findByEvent(eventId);
		
		request.setAttribute("imageList", imageList);
		request.setAttribute("eventId", eventId);
		response.setRenderParameter("mvcPath", "/html/management/event_images.jsp");
	}
	
	public void imageForm (ActionRequest request, ActionResponse response) {
		
		long imageId = ParamUtil.getLong(request, "imageId");
		long eventId = ParamUtil.getLong(request, "eventId");
		Image image = null;
		
		if (imageId > 0) {
			try {
				image = (Image) ImageLocalServiceUtil.getImage(imageId);
			} catch (PortalException | SystemException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("image", image);
		request.setAttribute("eventId", eventId);
		response.setRenderParameter("mvcPath", "/html/management/event_image_form.jsp");
	}
	
	public void saveImage (ActionRequest request, ActionResponse response) {
		
		long imageId = ParamUtil.getLong(request, "imageId");
		long eventId = ParamUtil.getLong(request, "eventId");
		String dlFileEntryUuid = ParamUtil.getString(request, "fileId");
		long groupId = ParamUtil.getLong(request, "groupId");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		
		Image image = null;
		
		try {
			if (imageId > 0) {
				image = (Image) ImageLocalServiceUtil.getImage(imageId);
				image.setDlFileEntryId(dlFileEntryUuid);
				image.setGroupId(groupId);
				image.persist();
			} else {
				image = new ImageImpl();
				image.setDlFileEntryId(dlFileEntryUuid);
				image.setGroupId(groupId);
				image.setEventId(eventId);
				image.setCompanyId(companyId);
				
				ImageLocalServiceUtil.addImage(image);
			}
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		
		SessionMessages.add(request, "the-image-was-saved-successfully");
		listImages(request, response);
		
	}
	
	public void deleteImage (ActionRequest request, ActionResponse response) {
		
		long imageId = ParamUtil.getLong(request, "imageId");
		
		try {
			ImageLocalServiceUtil.deleteImage(imageId);
			SessionMessages.add(request, "image-deleted-successfuly");
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		
		listImages(request, response);
	}
	
	public void serveResource (ResourceRequest request, ResourceResponse response) {
		
		long eventId = ParamUtil.getLong(request, "eventId");
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Event #" + eventId);
		
		int rowNum = 0;
		Row row = sheet.createRow(rowNum);
		
		row.createCell(0).setCellValue("Name");
		row.createCell(1).setCellValue("Surname");
		row.createCell(2).setCellValue("Company");
		row.createCell(3).setCellValue("E-mail");
		row.createCell(4).setCellValue("Phone");
		
		List<Attendee> list = AttendeeLocalServiceUtil.findByEvent(eventId);
		
		for (Attendee attendee : list) {
			rowNum++;
			row = sheet.createRow(rowNum);
			
			row.createCell(0).setCellValue(attendee.getName());
			row.createCell(1).setCellValue(attendee.getSurname());
			row.createCell(2).setCellValue(attendee.getCompany());
			row.createCell(3).setCellValue(attendee.getEmail());
			row.createCell(4).setCellValue(attendee.getPhone());
			
		}
		
		 response.setContentType("application/vnd.ms-excel");
		 response.setProperty("Content-Disposition", "attachment; filename= user_export_" + Calendar.getInstance().getTimeInMillis() + ".xls");

		 try {
			workbook.write(response.getPortletOutputStream());
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}

}
