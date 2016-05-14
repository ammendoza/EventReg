package edu.uoc.eventreg.portlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class EventRegistrationPortlet extends MVCPortlet {
	 
	public void doView (RenderRequest request, RenderResponse response) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		request.setAttribute("companyId", themeDisplay.getCompanyId());
		request.setAttribute("groupId", themeDisplay.getLayout().getGroupId());
		
		super.doView(request, response);
	}
	
}
