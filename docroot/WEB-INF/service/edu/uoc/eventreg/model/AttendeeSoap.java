/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package edu.uoc.eventreg.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link edu.uoc.eventreg.service.http.AttendeeServiceSoap}.
 *
 * @author Ana Mendoza
 * @see edu.uoc.eventreg.service.http.AttendeeServiceSoap
 * @generated
 */
public class AttendeeSoap implements Serializable {
	public static AttendeeSoap toSoapModel(Attendee model) {
		AttendeeSoap soapModel = new AttendeeSoap();

		soapModel.setAttendeeId(model.getAttendeeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setName(model.getName());
		soapModel.setSurname(model.getSurname());
		soapModel.setCompany(model.getCompany());
		soapModel.setEmail(model.getEmail());
		soapModel.setPhone(model.getPhone());
		soapModel.setRegisterDate(model.getRegisterDate());
		soapModel.setReservationCode(model.getReservationCode());
		soapModel.setStatus(model.getStatus());
		soapModel.setEventOptionId(model.getEventOptionId());
		soapModel.setManagedBy(model.getManagedBy());

		return soapModel;
	}

	public static AttendeeSoap[] toSoapModels(Attendee[] models) {
		AttendeeSoap[] soapModels = new AttendeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AttendeeSoap[][] toSoapModels(Attendee[][] models) {
		AttendeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AttendeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AttendeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AttendeeSoap[] toSoapModels(List<Attendee> models) {
		List<AttendeeSoap> soapModels = new ArrayList<AttendeeSoap>(models.size());

		for (Attendee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AttendeeSoap[soapModels.size()]);
	}

	public AttendeeSoap() {
	}

	public long getPrimaryKey() {
		return _attendeeId;
	}

	public void setPrimaryKey(long pk) {
		setAttendeeId(pk);
	}

	public long getAttendeeId() {
		return _attendeeId;
	}

	public void setAttendeeId(long attendeeId) {
		_attendeeId = attendeeId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getSurname() {
		return _surname;
	}

	public void setSurname(String surname) {
		_surname = surname;
	}

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public Date getRegisterDate() {
		return _registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		_registerDate = registerDate;
	}

	public String getReservationCode() {
		return _reservationCode;
	}

	public void setReservationCode(String reservationCode) {
		_reservationCode = reservationCode;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getEventOptionId() {
		return _eventOptionId;
	}

	public void setEventOptionId(long eventOptionId) {
		_eventOptionId = eventOptionId;
	}

	public long getManagedBy() {
		return _managedBy;
	}

	public void setManagedBy(long managedBy) {
		_managedBy = managedBy;
	}

	private long _attendeeId;
	private long _companyId;
	private long _groupId;
	private String _name;
	private String _surname;
	private String _company;
	private String _email;
	private String _phone;
	private Date _registerDate;
	private String _reservationCode;
	private int _status;
	private long _eventOptionId;
	private long _managedBy;
}