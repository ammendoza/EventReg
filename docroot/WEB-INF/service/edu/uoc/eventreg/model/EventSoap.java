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
 * This class is used by SOAP remote services, specifically {@link edu.uoc.eventreg.service.http.EventServiceSoap}.
 *
 * @author Ana Mendoza
 * @see edu.uoc.eventreg.service.http.EventServiceSoap
 * @generated
 */
public class EventSoap implements Serializable {
	public static EventSoap toSoapModel(Event model) {
		EventSoap soapModel = new EventSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setAddress(model.getAddress());
		soapModel.setLocation(model.getLocation());
		soapModel.setCoordX(model.getCoordX());
		soapModel.setCoordY(model.getCoordY());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRequiresApproval(model.getRequiresApproval());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());

		return soapModel;
	}

	public static EventSoap[] toSoapModels(Event[] models) {
		EventSoap[] soapModels = new EventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventSoap[][] toSoapModels(Event[][] models) {
		EventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventSoap[] toSoapModels(List<Event> models) {
		List<EventSoap> soapModels = new ArrayList<EventSoap>(models.size());

		for (Event model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventSoap[soapModels.size()]);
	}

	public EventSoap() {
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public String getCoordX() {
		return _coordX;
	}

	public void setCoordX(String coordX) {
		_coordX = coordX;
	}

	public String getCoordY() {
		return _coordY;
	}

	public void setCoordY(String coordY) {
		_coordY = coordY;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public boolean getRequiresApproval() {
		return _requiresApproval;
	}

	public boolean isRequiresApproval() {
		return _requiresApproval;
	}

	public void setRequiresApproval(boolean requiresApproval) {
		_requiresApproval = requiresApproval;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
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

	private long _id;
	private long _companyId;
	private long _groupId;
	private String _title;
	private String _description;
	private String _address;
	private String _location;
	private String _coordX;
	private String _coordY;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _requiresApproval;
	private int _status;
	private long _createdBy;
	private Date _startDate;
	private Date _endDate;
}