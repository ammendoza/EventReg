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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import edu.uoc.eventreg.service.ClpSerializer;
import edu.uoc.eventreg.service.ImageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ana Mendoza
 */
public class ImageClp extends BaseModelImpl<Image> implements Image {
	public ImageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Image.class;
	}

	@Override
	public String getModelClassName() {
		return Image.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _imageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setImageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _imageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("imageId", getImageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("eventId", getEventId());
		attributes.put("dlFileEntryId", getDlFileEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String dlFileEntryId = (String)attributes.get("dlFileEntryId");

		if (dlFileEntryId != null) {
			setDlFileEntryId(dlFileEntryId);
		}
	}

	@Override
	public long getImageId() {
		return _imageId;
	}

	@Override
	public void setImageId(long imageId) {
		_imageId = imageId;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageId", long.class);

				method.invoke(_imageRemoteModel, imageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_imageRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_imageRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_eventId = eventId;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setEventId", long.class);

				method.invoke(_imageRemoteModel, eventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDlFileEntryId() {
		return _dlFileEntryId;
	}

	@Override
	public void setDlFileEntryId(String dlFileEntryId) {
		_dlFileEntryId = dlFileEntryId;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setDlFileEntryId", String.class);

				method.invoke(_imageRemoteModel, dlFileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getImageRemoteModel() {
		return _imageRemoteModel;
	}

	public void setImageRemoteModel(BaseModel<?> imageRemoteModel) {
		_imageRemoteModel = imageRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _imageRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_imageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ImageLocalServiceUtil.addImage(this);
		}
		else {
			ImageLocalServiceUtil.updateImage(this);
		}
	}

	@Override
	public Image toEscapedModel() {
		return (Image)ProxyUtil.newProxyInstance(Image.class.getClassLoader(),
			new Class[] { Image.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ImageClp clone = new ImageClp();

		clone.setImageId(getImageId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setEventId(getEventId());
		clone.setDlFileEntryId(getDlFileEntryId());

		return clone;
	}

	@Override
	public int compareTo(Image image) {
		int value = 0;

		if (getImageId() < image.getImageId()) {
			value = -1;
		}
		else if (getImageId() > image.getImageId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImageClp)) {
			return false;
		}

		ImageClp image = (ImageClp)obj;

		long primaryKey = image.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{imageId=");
		sb.append(getImageId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", eventId=");
		sb.append(getEventId());
		sb.append(", dlFileEntryId=");
		sb.append(getDlFileEntryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("edu.uoc.eventreg.model.Image");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>imageId</column-name><column-value><![CDATA[");
		sb.append(getImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dlFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getDlFileEntryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _imageId;
	private long _companyId;
	private long _groupId;
	private long _eventId;
	private String _dlFileEntryId;
	private BaseModel<?> _imageRemoteModel;
	private Class<?> _clpSerializerClass = edu.uoc.eventreg.service.ClpSerializer.class;
}