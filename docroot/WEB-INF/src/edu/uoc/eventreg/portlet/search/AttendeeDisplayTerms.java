package edu.uoc.eventreg.portlet.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class AttendeeDisplayTerms extends DisplayTerms {
	
	public static final String NAME = "name";
	public static final String SURNAME = "surname";
	public static final String EMAIL = "email";
	public static final String STATUS = "status";

	public AttendeeDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		name = ParamUtil.getString(portletRequest, NAME);
		surname = ParamUtil.getString(portletRequest, SURNAME);
		email = ParamUtil.getString(portletRequest, EMAIL);
		status = ParamUtil.getInteger(portletRequest, STATUS);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	protected String name;
	protected String surname;
	protected String email;
	protected int status;
}