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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link edu.uoc.eventreg.service.http.ImageServiceSoap}.
 *
 * @author Ana Mendoza
 * @see edu.uoc.eventreg.service.http.ImageServiceSoap
 * @generated
 */
public class ImageSoap implements Serializable {
	public static ImageSoap toSoapModel(Image model) {
		ImageSoap soapModel = new ImageSoap();

		soapModel.setImageId(model.getImageId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setEventId(model.getEventId());
		soapModel.setDlFileEntryId(model.getDlFileEntryId());

		return soapModel;
	}

	public static ImageSoap[] toSoapModels(Image[] models) {
		ImageSoap[] soapModels = new ImageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ImageSoap[][] toSoapModels(Image[][] models) {
		ImageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ImageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ImageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ImageSoap[] toSoapModels(List<Image> models) {
		List<ImageSoap> soapModels = new ArrayList<ImageSoap>(models.size());

		for (Image model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ImageSoap[soapModels.size()]);
	}

	public ImageSoap() {
	}

	public long getPrimaryKey() {
		return _imageId;
	}

	public void setPrimaryKey(long pk) {
		setImageId(pk);
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
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

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public String getDlFileEntryId() {
		return _dlFileEntryId;
	}

	public void setDlFileEntryId(String dlFileEntryId) {
		_dlFileEntryId = dlFileEntryId;
	}

	private long _imageId;
	private long _companyId;
	private long _groupId;
	private long _eventId;
	private String _dlFileEntryId;
}