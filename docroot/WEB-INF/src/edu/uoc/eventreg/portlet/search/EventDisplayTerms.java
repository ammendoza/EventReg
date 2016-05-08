package edu.uoc.eventreg.portlet.search;
import java.util.Date;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class EventDisplayTerms extends DisplayTerms {
	
	public static final String TITLE = "title";
	public static final String DESCRIPTION = "description";
	public static final String LOCATION = "location";
	//public static final String START_DATE = "startDate";
	public static final String STATUS = "status";

	public EventDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		title = ParamUtil.getString(portletRequest, TITLE);
		description = ParamUtil.getString(portletRequest, DESCRIPTION);
		location = ParamUtil.getString(portletRequest, LOCATION);
		//startDate = ParamUtil.getString(portletRequest, START_DATE);
		status = ParamUtil.getInteger(portletRequest, STATUS);
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	protected String title;
	protected String description;
	protected String location;
	//protected Date startDate;
	protected int status;
}