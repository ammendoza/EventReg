package edu.uoc.eventreg.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import edu.uoc.eventreg.model.Event;
import edu.uoc.eventreg.model.EventOption;
import edu.uoc.eventreg.service.EventLocalServiceUtil;
import edu.uoc.eventreg.service.EventOptionLocalServiceUtil;

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
				
		try {
			event = (Event) EventLocalServiceUtil.getEvent(eventId);
			eventOptions = (List<EventOption>) EventOptionLocalServiceUtil.findEventOptions(eventId);
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("event", event);
		request.setAttribute("eventOptions", eventOptions);
		response.setRenderParameter("mvcPath", "/html/registration/view_event.jsp");
	}
	
	public void registerForm(ActionRequest request, ActionResponse response) {
		
		long eventId = ParamUtil.getLong(request, "eventId");
		Event event = null;
				
		try {
			event = (Event) EventLocalServiceUtil.getEvent(eventId);
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("requiresApproval", event.getRequiresApproval());
		request.setAttribute("eventOptionId", request.getAttribute("eventOptionId"));
		
		response.setRenderParameter("mvcPath", "/html/registration/register_form.jsp");
	}
	
}
