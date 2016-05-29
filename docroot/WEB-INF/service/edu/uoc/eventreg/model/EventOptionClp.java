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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import edu.uoc.eventreg.service.ClpSerializer;
import edu.uoc.eventreg.service.EventOptionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ana Mendoza
 */
public class EventOptionClp extends BaseModelImpl<EventOption>
	implements EventOption {
	public EventOptionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EventOption.class;
	}

	@Override
	public String getModelClassName() {
		return EventOption.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eventOptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventOptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventOptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventOptionId", getEventOptionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("seats", getSeats());
		attributes.put("eventId", getEventId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventOptionId = (Long)attributes.get("eventOptionId");

		if (eventOptionId != null) {
			setEventOptionId(eventOptionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer seats = (Integer)attributes.get("seats");

		if (seats != null) {
			setSeats(seats);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}
	}

	@Override
	public long getEventOptionId() {
		return _eventOptionId;
	}

	@Override
	public void setEventOptionId(long eventOptionId) {
		_eventOptionId = eventOptionId;

		if (_eventOptionRemoteModel != null) {
			try {
				Class<?> clazz = _eventOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setEventOptionId", long.class);

				method.invoke(_eventOptionRemoteModel, eventOptionId);
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

		if (_eventOptionRemoteModel != null) {
			try {
				Class<?> clazz = _eventOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eventOptionRemoteModel, companyId);
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

		if (_eventOptionRemoteModel != null) {
			try {
				Class<?> clazz = _eventOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_eventOptionRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_eventOptionRemoteModel != null) {
			try {
				Class<?> clazz = _eventOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_eventOptionRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_eventOptionRemoteModel != null) {
			try {
				Class<?> clazz = _eventOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_eventOptionRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSeats() {
		return _seats;
	}

	@Override
	public void setSeats(int seats) {
		_seats = seats;

		if (_eventOptionRemoteModel != null) {
			try {
				Class<?> clazz = _eventOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setSeats", int.class);

				method.invoke(_eventOptionRemoteModel, seats);
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

		if (_eventOptionRemoteModel != null) {
			try {
				Class<?> clazz = _eventOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setEventId", long.class);

				method.invoke(_eventOptionRemoteModel, eventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAvailableSeats() {
		try {
			String methodName = "getAvailableSeats";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Long returnObj = (Long)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getEventOptionRemoteModel() {
		return _eventOptionRemoteModel;
	}

	public void setEventOptionRemoteModel(BaseModel<?> eventOptionRemoteModel) {
		_eventOptionRemoteModel = eventOptionRemoteModel;
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

		Class<?> remoteModelClass = _eventOptionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eventOptionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EventOptionLocalServiceUtil.addEventOption(this);
		}
		else {
			EventOptionLocalServiceUtil.updateEventOption(this);
		}
	}

	@Override
	public EventOption toEscapedModel() {
		return (EventOption)ProxyUtil.newProxyInstance(EventOption.class.getClassLoader(),
			new Class[] { EventOption.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EventOptionClp clone = new EventOptionClp();

		clone.setEventOptionId(getEventOptionId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setSeats(getSeats());
		clone.setEventId(getEventId());

		return clone;
	}

	@Override
	public int compareTo(EventOption eventOption) {
		int value = 0;

		value = DateUtil.compareTo(getStartDate(), eventOption.getStartDate());

		value = value * -1;

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

		if (!(obj instanceof EventOptionClp)) {
			return false;
		}

		EventOptionClp eventOption = (EventOptionClp)obj;

		long primaryKey = eventOption.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{eventOptionId=");
		sb.append(getEventOptionId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", seats=");
		sb.append(getSeats());
		sb.append(", eventId=");
		sb.append(getEventId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("edu.uoc.eventreg.model.EventOption");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventOptionId</column-name><column-value><![CDATA[");
		sb.append(getEventOptionId());
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
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seats</column-name><column-value><![CDATA[");
		sb.append(getSeats());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventOptionId;
	private long _companyId;
	private long _groupId;
	private Date _startDate;
	private Date _endDate;
	private int _seats;
	private long _eventId;
	private BaseModel<?> _eventOptionRemoteModel;
	private Class<?> _clpSerializerClass = edu.uoc.eventreg.service.ClpSerializer.class;
}