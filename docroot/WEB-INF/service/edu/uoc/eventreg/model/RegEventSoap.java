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
 * This class is used by SOAP remote services, specifically {@link edu.uoc.eventreg.service.http.RegEventServiceSoap}.
 *
 * @author Ana Mendoza
 * @see edu.uoc.eventreg.service.http.RegEventServiceSoap
 * @generated
 */
public class RegEventSoap implements Serializable {
	public static RegEventSoap toSoapModel(RegEvent model) {
		RegEventSoap soapModel = new RegEventSoap();

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

		return soapModel;
	}

	public static RegEventSoap[] toSoapModels(RegEvent[] models) {
		RegEventSoap[] soapModels = new RegEventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RegEventSoap[][] toSoapModels(RegEvent[][] models) {
		RegEventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RegEventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RegEventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RegEventSoap[] toSoapModels(List<RegEvent> models) {
		List<RegEventSoap> soapModels = new ArrayList<RegEventSoap>(models.size());

		for (RegEvent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RegEventSoap[soapModels.size()]);
	}

	public RegEventSoap() {
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
}