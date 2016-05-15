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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Attendee}.
 * </p>
 *
 * @author Ana Mendoza
 * @see Attendee
 * @generated
 */
public class AttendeeWrapper implements Attendee, ModelWrapper<Attendee> {
	public AttendeeWrapper(Attendee attendee) {
		_attendee = attendee;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attendeeId", getAttendeeId());
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
		attributes.put("managedBy", getManagedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attendeeId = (Long)attributes.get("attendeeId");

		if (attendeeId != null) {
			setAttendeeId(attendeeId);
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

		Long managedBy = (Long)attributes.get("managedBy");

		if (managedBy != null) {
			setManagedBy(managedBy);
		}
	}

	/**
	* Returns the primary key of this attendee.
	*
	* @return the primary key of this attendee
	*/
	@Override
	public long getPrimaryKey() {
		return _attendee.getPrimaryKey();
	}

	/**
	* Sets the primary key of this attendee.
	*
	* @param primaryKey the primary key of this attendee
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_attendee.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the attendee ID of this attendee.
	*
	* @return the attendee ID of this attendee
	*/
	@Override
	public long getAttendeeId() {
		return _attendee.getAttendeeId();
	}

	/**
	* Sets the attendee ID of this attendee.
	*
	* @param attendeeId the attendee ID of this attendee
	*/
	@Override
	public void setAttendeeId(long attendeeId) {
		_attendee.setAttendeeId(attendeeId);
	}

	/**
	* Returns the company ID of this attendee.
	*
	* @return the company ID of this attendee
	*/
	@Override
	public long getCompanyId() {
		return _attendee.getCompanyId();
	}

	/**
	* Sets the company ID of this attendee.
	*
	* @param companyId the company ID of this attendee
	*/
	@Override
	public void setCompanyId(long companyId) {
		_attendee.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this attendee.
	*
	* @return the group ID of this attendee
	*/
	@Override
	public long getGroupId() {
		return _attendee.getGroupId();
	}

	/**
	* Sets the group ID of this attendee.
	*
	* @param groupId the group ID of this attendee
	*/
	@Override
	public void setGroupId(long groupId) {
		_attendee.setGroupId(groupId);
	}

	/**
	* Returns the name of this attendee.
	*
	* @return the name of this attendee
	*/
	@Override
	public java.lang.String getName() {
		return _attendee.getName();
	}

	/**
	* Sets the name of this attendee.
	*
	* @param name the name of this attendee
	*/
	@Override
	public void setName(java.lang.String name) {
		_attendee.setName(name);
	}

	/**
	* Returns the surname of this attendee.
	*
	* @return the surname of this attendee
	*/
	@Override
	public java.lang.String getSurname() {
		return _attendee.getSurname();
	}

	/**
	* Sets the surname of this attendee.
	*
	* @param surname the surname of this attendee
	*/
	@Override
	public void setSurname(java.lang.String surname) {
		_attendee.setSurname(surname);
	}

	/**
	* Returns the company of this attendee.
	*
	* @return the company of this attendee
	*/
	@Override
	public java.lang.String getCompany() {
		return _attendee.getCompany();
	}

	/**
	* Sets the company of this attendee.
	*
	* @param company the company of this attendee
	*/
	@Override
	public void setCompany(java.lang.String company) {
		_attendee.setCompany(company);
	}

	/**
	* Returns the email of this attendee.
	*
	* @return the email of this attendee
	*/
	@Override
	public java.lang.String getEmail() {
		return _attendee.getEmail();
	}

	/**
	* Sets the email of this attendee.
	*
	* @param email the email of this attendee
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_attendee.setEmail(email);
	}

	/**
	* Returns the phone of this attendee.
	*
	* @return the phone of this attendee
	*/
	@Override
	public java.lang.String getPhone() {
		return _attendee.getPhone();
	}

	/**
	* Sets the phone of this attendee.
	*
	* @param phone the phone of this attendee
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_attendee.setPhone(phone);
	}

	/**
	* Returns the register date of this attendee.
	*
	* @return the register date of this attendee
	*/
	@Override
	public java.util.Date getRegisterDate() {
		return _attendee.getRegisterDate();
	}

	/**
	* Sets the register date of this attendee.
	*
	* @param registerDate the register date of this attendee
	*/
	@Override
	public void setRegisterDate(java.util.Date registerDate) {
		_attendee.setRegisterDate(registerDate);
	}

	/**
	* Returns the reservation code of this attendee.
	*
	* @return the reservation code of this attendee
	*/
	@Override
	public java.lang.String getReservationCode() {
		return _attendee.getReservationCode();
	}

	/**
	* Sets the reservation code of this attendee.
	*
	* @param reservationCode the reservation code of this attendee
	*/
	@Override
	public void setReservationCode(java.lang.String reservationCode) {
		_attendee.setReservationCode(reservationCode);
	}

	/**
	* Returns the status of this attendee.
	*
	* @return the status of this attendee
	*/
	@Override
	public int getStatus() {
		return _attendee.getStatus();
	}

	/**
	* Sets the status of this attendee.
	*
	* @param status the status of this attendee
	*/
	@Override
	public void setStatus(int status) {
		_attendee.setStatus(status);
	}

	/**
	* Returns the managed by of this attendee.
	*
	* @return the managed by of this attendee
	*/
	@Override
	public long getManagedBy() {
		return _attendee.getManagedBy();
	}

	/**
	* Sets the managed by of this attendee.
	*
	* @param managedBy the managed by of this attendee
	*/
	@Override
	public void setManagedBy(long managedBy) {
		_attendee.setManagedBy(managedBy);
	}

	@Override
	public boolean isNew() {
		return _attendee.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_attendee.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _attendee.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_attendee.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _attendee.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _attendee.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_attendee.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _attendee.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_attendee.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_attendee.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_attendee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AttendeeWrapper((Attendee)_attendee.clone());
	}

	@Override
	public int compareTo(edu.uoc.eventreg.model.Attendee attendee) {
		return _attendee.compareTo(attendee);
	}

	@Override
	public int hashCode() {
		return _attendee.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<edu.uoc.eventreg.model.Attendee> toCacheModel() {
		return _attendee.toCacheModel();
	}

	@Override
	public edu.uoc.eventreg.model.Attendee toEscapedModel() {
		return new AttendeeWrapper(_attendee.toEscapedModel());
	}

	@Override
	public edu.uoc.eventreg.model.Attendee toUnescapedModel() {
		return new AttendeeWrapper(_attendee.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _attendee.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _attendee.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_attendee.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttendeeWrapper)) {
			return false;
		}

		AttendeeWrapper attendeeWrapper = (AttendeeWrapper)obj;

		if (Validator.equals(_attendee, attendeeWrapper._attendee)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Attendee getWrappedAttendee() {
		return _attendee;
	}

	@Override
	public Attendee getWrappedModel() {
		return _attendee;
	}

	@Override
	public void resetOriginalValues() {
		_attendee.resetOriginalValues();
	}

	private Attendee _attendee;
}