package edu.uoc.eventreg.portlet;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
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
 
	public void doView (RenderRequest request, RenderResponse response) {
		
		try {
			super.doView(request, response);
		} catch (IOException | PortletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addEventForm(ActionRequest request, ActionResponse response) {
		
		response.setRenderParameter("mvcPath",
                "/html/management/add_event.jsp");
	}
	
	public void addEvent(ActionRequest request, ActionResponse response) {

		Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(request, "title");
		Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(request, "description");
		Map<Locale, String> addressMap = LocalizationUtil.getLocalizationMap(request, "address");
		Map<Locale, String> locationMap = LocalizationUtil.getLocalizationMap(request, "location");
		String coordX = ParamUtil.getString(request, "coord-x");
		String coordY = ParamUtil.getString(request, "coord-y");
		boolean requiresApproval = ParamUtil.getBoolean(request, "requires-approval");
		Date createDate = new Date();
		User user = (User) request.getAttribute(WebKeys.USER);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		Event event = new EventImpl();
		event.setTitleMap(titleMap);
		event.setDescriptionMap(descriptionMap);
		event.setAddressMap(addressMap);
		event.setLocationMap(locationMap);
		event.setCoordX(coordX);
		event.setCoordY(coordY);
		event.setRequiresApproval(requiresApproval);
		event.setCreateDate(createDate);
		event.setModifiedDate(createDate);
		event.setCreatedBy(user.getUserId());
		event.setCompanyId(themeDisplay.getCompanyId());
		event.setGroupId(themeDisplay.getLayout().getGroupId());
		
		try {
			EventLocalServiceUtil.addEvent(event);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		response.setRenderParameter("mvcPath",
                "/html/management/view.jsp");
	}

}
