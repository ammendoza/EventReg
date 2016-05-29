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
 * This class is a wrapper for {@link EventOption}.
 * </p>
 *
 * @author Ana Mendoza
 * @see EventOption
 * @generated
 */
public class EventOptionWrapper implements EventOption,
	ModelWrapper<EventOption> {
	public EventOptionWrapper(EventOption eventOption) {
		_eventOption = eventOption;
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

	/**
	* Returns the primary key of this event option.
	*
	* @return the primary key of this event option
	*/
	@Override
	public long getPrimaryKey() {
		return _eventOption.getPrimaryKey();
	}

	/**
	* Sets the primary key of this event option.
	*
	* @param primaryKey the primary key of this event option
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eventOption.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the event option ID of this event option.
	*
	* @return the event option ID of this event option
	*/
	@Override
	public long getEventOptionId() {
		return _eventOption.getEventOptionId();
	}

	/**
	* Sets the event option ID of this event option.
	*
	* @param eventOptionId the event option ID of this event option
	*/
	@Override
	public void setEventOptionId(long eventOptionId) {
		_eventOption.setEventOptionId(eventOptionId);
	}

	/**
	* Returns the company ID of this event option.
	*
	* @return the company ID of this event option
	*/
	@Override
	public long getCompanyId() {
		return _eventOption.getCompanyId();
	}

	/**
	* Sets the company ID of this event option.
	*
	* @param companyId the company ID of this event option
	*/
	@Override
	public void setCompanyId(long companyId) {
		_eventOption.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this event option.
	*
	* @return the group ID of this event option
	*/
	@Override
	public long getGroupId() {
		return _eventOption.getGroupId();
	}

	/**
	* Sets the group ID of this event option.
	*
	* @param groupId the group ID of this event option
	*/
	@Override
	public void setGroupId(long groupId) {
		_eventOption.setGroupId(groupId);
	}

	/**
	* Returns the start date of this event option.
	*
	* @return the start date of this event option
	*/
	@Override
	public java.util.Date getStartDate() {
		return _eventOption.getStartDate();
	}

	/**
	* Sets the start date of this event option.
	*
	* @param startDate the start date of this event option
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_eventOption.setStartDate(startDate);
	}

	/**
	* Returns the end date of this event option.
	*
	* @return the end date of this event option
	*/
	@Override
	public java.util.Date getEndDate() {
		return _eventOption.getEndDate();
	}

	/**
	* Sets the end date of this event option.
	*
	* @param endDate the end date of this event option
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_eventOption.setEndDate(endDate);
	}

	/**
	* Returns the seats of this event option.
	*
	* @return the seats of this event option
	*/
	@Override
	public int getSeats() {
		return _eventOption.getSeats();
	}

	/**
	* Sets the seats of this event option.
	*
	* @param seats the seats of this event option
	*/
	@Override
	public void setSeats(int seats) {
		_eventOption.setSeats(seats);
	}

	/**
	* Returns the event ID of this event option.
	*
	* @return the event ID of this event option
	*/
	@Override
	public long getEventId() {
		return _eventOption.getEventId();
	}

	/**
	* Sets the event ID of this event option.
	*
	* @param eventId the event ID of this event option
	*/
	@Override
	public void setEventId(long eventId) {
		_eventOption.setEventId(eventId);
	}

	@Override
	public boolean isNew() {
		return _eventOption.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eventOption.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eventOption.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eventOption.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eventOption.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eventOption.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eventOption.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eventOption.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eventOption.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eventOption.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventOption.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EventOptionWrapper((EventOption)_eventOption.clone());
	}

	@Override
	public int compareTo(edu.uoc.eventreg.model.EventOption eventOption) {
		return _eventOption.compareTo(eventOption);
	}

	@Override
	public int hashCode() {
		return _eventOption.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<edu.uoc.eventreg.model.EventOption> toCacheModel() {
		return _eventOption.toCacheModel();
	}

	@Override
	public edu.uoc.eventreg.model.EventOption toEscapedModel() {
		return new EventOptionWrapper(_eventOption.toEscapedModel());
	}

	@Override
	public edu.uoc.eventreg.model.EventOption toUnescapedModel() {
		return new EventOptionWrapper(_eventOption.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eventOption.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eventOption.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eventOption.persist();
	}

	@Override
	public long getAvailableSeats() {
		return _eventOption.getAvailableSeats();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventOptionWrapper)) {
			return false;
		}

		EventOptionWrapper eventOptionWrapper = (EventOptionWrapper)obj;

		if (Validator.equals(_eventOption, eventOptionWrapper._eventOption)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EventOption getWrappedEventOption() {
		return _eventOption;
	}

	@Override
	public EventOption getWrappedModel() {
		return _eventOption;
	}

	@Override
	public void resetOriginalValues() {
		_eventOption.resetOriginalValues();
	}

	private EventOption _eventOption;
}