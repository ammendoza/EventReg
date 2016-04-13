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

import edu.uoc.eventreg.service.AttendeeLocalServiceUtil;
import edu.uoc.eventreg.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ana Mendoza
 */
public class AttendeeClp extends BaseModelImpl<Attendee> implements Attendee {
	public AttendeeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Attendee.class;
	}

	@Override
	public String getModelClassName() {
		return Attendee.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("name", getName());
		attributes.put("surname", getSurname());
		attributes.put("company", getCompany());
		attributes.put("email", getEmail());
		attributes.put("phone", getPhone());
		attributes.put("registerDate", getRegisterDate());
		attributes.put("reservationCode", getReservationCode());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String surname = (String)attributes.get("surname");

		if (surname != null) {
			setSurname(surname);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		Date registerDate = (Date)attributes.get("registerDate");

		if (registerDate != null) {
			setRegisterDate(registerDate);
		}

		String reservationCode = (String)attributes.get("reservationCode");

		if (reservationCode != null) {
			setReservationCode(reservationCode);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_attendeeRemoteModel != null) {
			try {
				Class<?> clazz = _attendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_attendeeRemoteModel, id);
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

		if (_attendeeRemoteModel != null) {
			try {
				Class<?> clazz = _attendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_attendeeRemoteModel, companyId);
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

		if (_attendeeRemoteModel != null) {
			try {
				Class<?> clazz = _attendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_attendeeRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_attendeeRemoteModel != null) {
			try {
				Class<?> clazz = _attendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_attendeeRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSurname() {
		return _surname;
	}

	@Override
	public void setSurname(String surname) {
		_surname = surname;

		if (_attendeeRemoteModel != null) {
			try {
				Class<?> clazz = _attendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setSurname", String.class);

				method.invoke(_attendeeRemoteModel, surname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompany() {
		return _company;
	}

	@Override
	public void setCompany(String company) {
		_company = company;

		if (_attendeeRemoteModel != null) {
			try {
				Class<?> clazz = _attendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompany", String.class);

				method.invoke(_attendeeRemoteModel, company);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_attendeeRemoteModel != null) {
			try {
				Class<?> clazz = _attendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_attendeeRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhone() {
		return _phone;
	}

	@Override
	public void setPhone(String phone) {
		_phone = phone;

		if (_attendeeRemoteModel != null) {
			try {
				Class<?> clazz = _attendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setPhone", String.class);

				method.invoke(_attendeeRemoteModel, phone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRegisterDate() {
		return _registerDate;
	}

	@Override
	public void setRegisterDate(Date registerDate) {
		_registerDate = registerDate;

		if (_attendeeRemoteModel != null) {
			try {
				Class<?> clazz = _attendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setRegisterDate", Date.class);

				method.invoke(_attendeeRemoteModel, registerDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReservationCode() {
		return _reservationCode;
	}

	@Override
	public void setReservationCode(String reservationCode) {
		_reservationCode = reservationCode;

		if (_attendeeRemoteModel != null) {
			try {
				Class<?> clazz = _attendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setReservationCode",
						String.class);

				method.invoke(_attendeeRemoteModel, reservationCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_attendeeRemoteModel != null) {
			try {
				Class<?> clazz = _attendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_attendeeRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAttendeeRemoteModel() {
		return _attendeeRemoteModel;
	}

	public void setAttendeeRemoteModel(BaseModel<?> attendeeRemoteModel) {
		_attendeeRemoteModel = attendeeRemoteModel;
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

		Class<?> remoteModelClass = _attendeeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_attendeeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AttendeeLocalServiceUtil.addAttendee(this);
		}
		else {
			AttendeeLocalServiceUtil.updateAttendee(this);
		}
	}

	@Override
	public Attendee toEscapedModel() {
		return (Attendee)ProxyUtil.newProxyInstance(Attendee.class.getClassLoader(),
			new Class[] { Attendee.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AttendeeClp clone = new AttendeeClp();

		clone.setId(getId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setName(getName());
		clone.setSurname(getSurname());
		clone.setCompany(getCompany());
		clone.setEmail(getEmail());
		clone.setPhone(getPhone());
		clone.setRegisterDate(getRegisterDate());
		clone.setReservationCode(getReservationCode());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(Attendee attendee) {
		int value = 0;

		value = getSurname().compareTo(attendee.getSurname());

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

		if (!(obj instanceof AttendeeClp)) {
			return false;
		}

		AttendeeClp attendee = (AttendeeClp)obj;

		long primaryKey = attendee.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", surname=");
		sb.append(getSurname());
		sb.append(", company=");
		sb.append(getCompany());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", registerDate=");
		sb.append(getRegisterDate());
		sb.append(", reservationCode=");
		sb.append(getReservationCode());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("edu.uoc.eventreg.model.Attendee");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surname</column-name><column-value><![CDATA[");
		sb.append(getSurname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>company</column-name><column-value><![CDATA[");
		sb.append(getCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registerDate</column-name><column-value><![CDATA[");
		sb.append(getRegisterDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reservationCode</column-name><column-value><![CDATA[");
		sb.append(getReservationCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
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
	private BaseModel<?> _attendeeRemoteModel;
	private Class<?> _clpSerializerClass = edu.uoc.eventreg.service.ClpSerializer.class;
}