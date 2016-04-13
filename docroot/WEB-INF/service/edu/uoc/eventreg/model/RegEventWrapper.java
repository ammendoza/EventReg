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
 * This class is a wrapper for {@link RegEvent}.
 * </p>
 *
 * @author Ana Mendoza
 * @see RegEvent
 * @generated
 */
public class RegEventWrapper implements RegEvent, ModelWrapper<RegEvent> {
	public RegEventWrapper(RegEvent regEvent) {
		_regEvent = regEvent;
	}

	@Override
	public Class<?> getModelClass() {
		return RegEvent.class;
	}

	@Override
	public String getModelClassName() {
		return RegEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("address", getAddress());
		attributes.put("location", getLocation());
		attributes.put("coordX", getCoordX());
		attributes.put("coordY", getCoordY());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("requiresApproval", getRequiresApproval());
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String coordX = (String)attributes.get("coordX");

		if (coordX != null) {
			setCoordX(coordX);
		}

		String coordY = (String)attributes.get("coordY");

		if (coordY != null) {
			setCoordY(coordY);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean requiresApproval = (Boolean)attributes.get("requiresApproval");

		if (requiresApproval != null) {
			setRequiresApproval(requiresApproval);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this reg event.
	*
	* @return the primary key of this reg event
	*/
	@Override
	public long getPrimaryKey() {
		return _regEvent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this reg event.
	*
	* @param primaryKey the primary key of this reg event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_regEvent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this reg event.
	*
	* @return the ID of this reg event
	*/
	@Override
	public long getId() {
		return _regEvent.getId();
	}

	/**
	* Sets the ID of this reg event.
	*
	* @param id the ID of this reg event
	*/
	@Override
	public void setId(long id) {
		_regEvent.setId(id);
	}

	/**
	* Returns the company ID of this reg event.
	*
	* @return the company ID of this reg event
	*/
	@Override
	public long getCompanyId() {
		return _regEvent.getCompanyId();
	}

	/**
	* Sets the company ID of this reg event.
	*
	* @param companyId the company ID of this reg event
	*/
	@Override
	public void setCompanyId(long companyId) {
		_regEvent.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this reg event.
	*
	* @return the group ID of this reg event
	*/
	@Override
	public long getGroupId() {
		return _regEvent.getGroupId();
	}

	/**
	* Sets the group ID of this reg event.
	*
	* @param groupId the group ID of this reg event
	*/
	@Override
	public void setGroupId(long groupId) {
		_regEvent.setGroupId(groupId);
	}

	/**
	* Returns the title of this reg event.
	*
	* @return the title of this reg event
	*/
	@Override
	public java.lang.String getTitle() {
		return _regEvent.getTitle();
	}

	/**
	* Sets the title of this reg event.
	*
	* @param title the title of this reg event
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_regEvent.setTitle(title);
	}

	/**
	* Returns the description of this reg event.
	*
	* @return the description of this reg event
	*/
	@Override
	public java.lang.String getDescription() {
		return _regEvent.getDescription();
	}

	/**
	* Sets the description of this reg event.
	*
	* @param description the description of this reg event
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_regEvent.setDescription(description);
	}

	/**
	* Returns the address of this reg event.
	*
	* @return the address of this reg event
	*/
	@Override
	public java.lang.String getAddress() {
		return _regEvent.getAddress();
	}

	/**
	* Sets the address of this reg event.
	*
	* @param address the address of this reg event
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_regEvent.setAddress(address);
	}

	/**
	* Returns the location of this reg event.
	*
	* @return the location of this reg event
	*/
	@Override
	public java.lang.String getLocation() {
		return _regEvent.getLocation();
	}

	/**
	* Sets the location of this reg event.
	*
	* @param location the location of this reg event
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_regEvent.setLocation(location);
	}

	/**
	* Returns the coord x of this reg event.
	*
	* @return the coord x of this reg event
	*/
	@Override
	public java.lang.String getCoordX() {
		return _regEvent.getCoordX();
	}

	/**
	* Sets the coord x of this reg event.
	*
	* @param coordX the coord x of this reg event
	*/
	@Override
	public void setCoordX(java.lang.String coordX) {
		_regEvent.setCoordX(coordX);
	}

	/**
	* Returns the coord y of this reg event.
	*
	* @return the coord y of this reg event
	*/
	@Override
	public java.lang.String getCoordY() {
		return _regEvent.getCoordY();
	}

	/**
	* Sets the coord y of this reg event.
	*
	* @param coordY the coord y of this reg event
	*/
	@Override
	public void setCoordY(java.lang.String coordY) {
		_regEvent.setCoordY(coordY);
	}

	/**
	* Returns the create date of this reg event.
	*
	* @return the create date of this reg event
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _regEvent.getCreateDate();
	}

	/**
	* Sets the create date of this reg event.
	*
	* @param createDate the create date of this reg event
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_regEvent.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this reg event.
	*
	* @return the modified date of this reg event
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _regEvent.getModifiedDate();
	}

	/**
	* Sets the modified date of this reg event.
	*
	* @param modifiedDate the modified date of this reg event
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_regEvent.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the requires approval of this reg event.
	*
	* @return the requires approval of this reg event
	*/
	@Override
	public boolean getRequiresApproval() {
		return _regEvent.getRequiresApproval();
	}

	/**
	* Returns <code>true</code> if this reg event is requires approval.
	*
	* @return <code>true</code> if this reg event is requires approval; <code>false</code> otherwise
	*/
	@Override
	public boolean isRequiresApproval() {
		return _regEvent.isRequiresApproval();
	}

	/**
	* Sets whether this reg event is requires approval.
	*
	* @param requiresApproval the requires approval of this reg event
	*/
	@Override
	public void setRequiresApproval(boolean requiresApproval) {
		_regEvent.setRequiresApproval(requiresApproval);
	}

	/**
	* Returns the status of this reg event.
	*
	* @return the status of this reg event
	*/
	@Override
	public int getStatus() {
		return _regEvent.getStatus();
	}

	/**
	* Sets the status of this reg event.
	*
	* @param status the status of this reg event
	*/
	@Override
	public void setStatus(int status) {
		_regEvent.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _regEvent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_regEvent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _regEvent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_regEvent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _regEvent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _regEvent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_regEvent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _regEvent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_regEvent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_regEvent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_regEvent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RegEventWrapper((RegEvent)_regEvent.clone());
	}

	@Override
	public int compareTo(edu.uoc.eventreg.model.RegEvent regEvent) {
		return _regEvent.compareTo(regEvent);
	}

	@Override
	public int hashCode() {
		return _regEvent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<edu.uoc.eventreg.model.RegEvent> toCacheModel() {
		return _regEvent.toCacheModel();
	}

	@Override
	public edu.uoc.eventreg.model.RegEvent toEscapedModel() {
		return new RegEventWrapper(_regEvent.toEscapedModel());
	}

	@Override
	public edu.uoc.eventreg.model.RegEvent toUnescapedModel() {
		return new RegEventWrapper(_regEvent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _regEvent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _regEvent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_regEvent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RegEventWrapper)) {
			return false;
		}

		RegEventWrapper regEventWrapper = (RegEventWrapper)obj;

		if (Validator.equals(_regEvent, regEventWrapper._regEvent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RegEvent getWrappedRegEvent() {
		return _regEvent;
	}

	@Override
	public RegEvent getWrappedModel() {
		return _regEvent;
	}

	@Override
	public void resetOriginalValues() {
		_regEvent.resetOriginalValues();
	}

	private RegEvent _regEvent;
}