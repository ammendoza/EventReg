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

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setPrice(model.getPrice());

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
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
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

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	private long _id;
	private long _companyId;
	private long _groupId;
	private Date _startDate;
	private Date _endDate;
	private double _price;
}