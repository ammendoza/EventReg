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
 * This class is used by SOAP remote services, specifically {@link edu.uoc.eventreg.service.http.EventOptionServiceSoap}.
 *
 * @author Ana Mendoza
 * @see edu.uoc.eventreg.service.http.EventOptionServiceSoap
 * @generated
 */
public class EventOptionSoap implements Serializable {
	public static EventOptionSoap toSoapModel(EventOption model) {
		EventOptionSoap soapModel = new EventOptionSoap();

		soapModel.setEventOptionId(model.getEventOptionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setSeats(model.getSeats());
		soapModel.setEventId(model.getEventId());

		return soapModel;
	}

	public static EventOptionSoap[] toSoapModels(EventOption[] models) {
		EventOptionSoap[] soapModels = new EventOptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventOptionSoap[][] toSoapModels(EventOption[][] models) {
		EventOptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventOptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventOptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventOptionSoap[] toSoapModels(List<EventOption> models) {
		List<EventOptionSoap> soapModels = new ArrayList<EventOptionSoap>(models.size());

		for (EventOption model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventOptionSoap[soapModels.size()]);
	}

	public EventOptionSoap() {
	}

	public long getPrimaryKey() {
		return _eventOptionId;
	}

	public void setPrimaryKey(long pk) {
		setEventOptionId(pk);
	}

	public long getEventOptionId() {
		return _eventOptionId;
	}

	public void setEventOptionId(long eventOptionId) {
		_eventOptionId = eventOptionId;
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

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public int getSeats() {
		return _seats;
	}

	public void setSeats(int seats) {
		_seats = seats;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	private long _eventOptionId;
	private long _companyId;
	private long _groupId;
	private Date _startDate;
	private Date _endDate;
	private int _seats;
	private long _eventId;
}