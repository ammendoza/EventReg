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
 * This class is a wrapper for {@link Event}.
 * </p>
 *
 * @author Ana Mendoza
 * @see Event
 * @generated
 */
public class EventWrapper implements Event, ModelWrapper<Event> {
	public EventWrapper(Event event) {
		_event = event;
	}

	@Override
	public Class<?> getModelClass() {
		return Event.class;
	}

	@Override
	public String getModelClassName() {
		return Event.class.getName();
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
		attributes.put("createdBy", getCreatedBy());

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

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}
	}

	/**
	* Returns the primary key of this event.
	*
	* @return the primary key of this event
	*/
	@Override
	public long getPrimaryKey() {
		return _event.getPrimaryKey();
	}

	/**
	* Sets the primary key of this event.
	*
	* @param primaryKey the primary key of this event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_event.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this event.
	*
	* @return the ID of this event
	*/
	@Override
	public long getId() {
		return _event.getId();
	}

	/**
	* Sets the ID of this event.
	*
	* @param id the ID of this event
	*/
	@Override
	public void setId(long id) {
		_event.setId(id);
	}

	/**
	* Returns the company ID of this event.
	*
	* @return the company ID of this event
	*/
	@Override
	public long getCompanyId() {
		return _event.getCompanyId();
	}

	/**
	* Sets the company ID of this event.
	*
	* @param companyId the company ID of this event
	*/
	@Override
	public void setCompanyId(long companyId) {
		_event.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this event.
	*
	* @return the group ID of this event
	*/
	@Override
	public long getGroupId() {
		return _event.getGroupId();
	}

	/**
	* Sets the group ID of this event.
	*
	* @param groupId the group ID of this event
	*/
	@Override
	public void setGroupId(long groupId) {
		_event.setGroupId(groupId);
	}

	/**
	* Returns the title of this event.
	*
	* @return the title of this event
	*/
	@Override
	public java.lang.String getTitle() {
		return _event.getTitle();
	}

	/**
	* Returns the localized title of this event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this event
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _event.getTitle(locale);
	}

	/**
	* Returns the localized title of this event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _event.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this event
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _event.getTitle(languageId);
	}

	/**
	* Returns the localized title of this event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this event
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _event.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _event.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _event.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this event.
	*
	* @return the locales and localized titles of this event
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _event.getTitleMap();
	}

	/**
	* Sets the title of this event.
	*
	* @param title the title of this event
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_event.setTitle(title);
	}

	/**
	* Sets the localized title of this event in the language.
	*
	* @param title the localized title of this event
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_event.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this event in the language, and sets the default locale.
	*
	* @param title the localized title of this event
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_event.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_event.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this event from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this event
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap) {
		_event.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this event from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this event
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_event.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Returns the description of this event.
	*
	* @return the description of this event
	*/
	@Override
	public java.lang.String getDescription() {
		return _event.getDescription();
	}

	/**
	* Returns the localized description of this event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this event
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _event.getDescription(locale);
	}

	/**
	* Returns the localized description of this event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _event.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this event
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _event.getDescription(languageId);
	}

	/**
	* Returns the localized description of this event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this event
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _event.getDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _event.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _event.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this event.
	*
	* @return the locales and localized descriptions of this event
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _event.getDescriptionMap();
	}

	/**
	* Sets the description of this event.
	*
	* @param description the description of this event
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_event.setDescription(description);
	}

	/**
	* Sets the localized description of this event in the language.
	*
	* @param description the localized description of this event
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_event.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this event in the language, and sets the default locale.
	*
	* @param description the localized description of this event
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_event.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_event.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this event from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this event
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
		_event.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this event from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this event
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_event.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	* Returns the address of this event.
	*
	* @return the address of this event
	*/
	@Override
	public java.lang.String getAddress() {
		return _event.getAddress();
	}

	/**
	* Returns the localized address of this event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized address of this event
	*/
	@Override
	public java.lang.String getAddress(java.util.Locale locale) {
		return _event.getAddress(locale);
	}

	/**
	* Returns the localized address of this event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized address of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getAddress(java.util.Locale locale,
		boolean useDefault) {
		return _event.getAddress(locale, useDefault);
	}

	/**
	* Returns the localized address of this event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized address of this event
	*/
	@Override
	public java.lang.String getAddress(java.lang.String languageId) {
		return _event.getAddress(languageId);
	}

	/**
	* Returns the localized address of this event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized address of this event
	*/
	@Override
	public java.lang.String getAddress(java.lang.String languageId,
		boolean useDefault) {
		return _event.getAddress(languageId, useDefault);
	}

	@Override
	public java.lang.String getAddressCurrentLanguageId() {
		return _event.getAddressCurrentLanguageId();
	}

	@Override
	public java.lang.String getAddressCurrentValue() {
		return _event.getAddressCurrentValue();
	}

	/**
	* Returns a map of the locales and localized addresses of this event.
	*
	* @return the locales and localized addresses of this event
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getAddressMap() {
		return _event.getAddressMap();
	}

	/**
	* Sets the address of this event.
	*
	* @param address the address of this event
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_event.setAddress(address);
	}

	/**
	* Sets the localized address of this event in the language.
	*
	* @param address the localized address of this event
	* @param locale the locale of the language
	*/
	@Override
	public void setAddress(java.lang.String address, java.util.Locale locale) {
		_event.setAddress(address, locale);
	}

	/**
	* Sets the localized address of this event in the language, and sets the default locale.
	*
	* @param address the localized address of this event
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setAddress(java.lang.String address, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_event.setAddress(address, locale, defaultLocale);
	}

	@Override
	public void setAddressCurrentLanguageId(java.lang.String languageId) {
		_event.setAddressCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized addresses of this event from the map of locales and localized addresses.
	*
	* @param addressMap the locales and localized addresses of this event
	*/
	@Override
	public void setAddressMap(
		java.util.Map<java.util.Locale, java.lang.String> addressMap) {
		_event.setAddressMap(addressMap);
	}

	/**
	* Sets the localized addresses of this event from the map of locales and localized addresses, and sets the default locale.
	*
	* @param addressMap the locales and localized addresses of this event
	* @param defaultLocale the default locale
	*/
	@Override
	public void setAddressMap(
		java.util.Map<java.util.Locale, java.lang.String> addressMap,
		java.util.Locale defaultLocale) {
		_event.setAddressMap(addressMap, defaultLocale);
	}

	/**
	* Returns the location of this event.
	*
	* @return the location of this event
	*/
	@Override
	public java.lang.String getLocation() {
		return _event.getLocation();
	}

	/**
	* Returns the localized location of this event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized location of this event
	*/
	@Override
	public java.lang.String getLocation(java.util.Locale locale) {
		return _event.getLocation(locale);
	}

	/**
	* Returns the localized location of this event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized location of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getLocation(java.util.Locale locale,
		boolean useDefault) {
		return _event.getLocation(locale, useDefault);
	}

	/**
	* Returns the localized location of this event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized location of this event
	*/
	@Override
	public java.lang.String getLocation(java.lang.String languageId) {
		return _event.getLocation(languageId);
	}

	/**
	* Returns the localized location of this event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized location of this event
	*/
	@Override
	public java.lang.String getLocation(java.lang.String languageId,
		boolean useDefault) {
		return _event.getLocation(languageId, useDefault);
	}

	@Override
	public java.lang.String getLocationCurrentLanguageId() {
		return _event.getLocationCurrentLanguageId();
	}

	@Override
	public java.lang.String getLocationCurrentValue() {
		return _event.getLocationCurrentValue();
	}

	/**
	* Returns a map of the locales and localized locations of this event.
	*
	* @return the locales and localized locations of this event
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getLocationMap() {
		return _event.getLocationMap();
	}

	/**
	* Sets the location of this event.
	*
	* @param location the location of this event
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_event.setLocation(location);
	}

	/**
	* Sets the localized location of this event in the language.
	*
	* @param location the localized location of this event
	* @param locale the locale of the language
	*/
	@Override
	public void setLocation(java.lang.String location, java.util.Locale locale) {
		_event.setLocation(location, locale);
	}

	/**
	* Sets the localized location of this event in the language, and sets the default locale.
	*
	* @param location the localized location of this event
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setLocation(java.lang.String location, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_event.setLocation(location, locale, defaultLocale);
	}

	@Override
	public void setLocationCurrentLanguageId(java.lang.String languageId) {
		_event.setLocationCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized locations of this event from the map of locales and localized locations.
	*
	* @param locationMap the locales and localized locations of this event
	*/
	@Override
	public void setLocationMap(
		java.util.Map<java.util.Locale, java.lang.String> locationMap) {
		_event.setLocationMap(locationMap);
	}

	/**
	* Sets the localized locations of this event from the map of locales and localized locations, and sets the default locale.
	*
	* @param locationMap the locales and localized locations of this event
	* @param defaultLocale the default locale
	*/
	@Override
	public void setLocationMap(
		java.util.Map<java.util.Locale, java.lang.String> locationMap,
		java.util.Locale defaultLocale) {
		_event.setLocationMap(locationMap, defaultLocale);
	}

	/**
	* Returns the coord x of this event.
	*
	* @return the coord x of this event
	*/
	@Override
	public java.lang.String getCoordX() {
		return _event.getCoordX();
	}

	/**
	* Sets the coord x of this event.
	*
	* @param coordX the coord x of this event
	*/
	@Override
	public void setCoordX(java.lang.String coordX) {
		_event.setCoordX(coordX);
	}

	/**
	* Returns the coord y of this event.
	*
	* @return the coord y of this event
	*/
	@Override
	public java.lang.String getCoordY() {
		return _event.getCoordY();
	}

	/**
	* Sets the coord y of this event.
	*
	* @param coordY the coord y of this event
	*/
	@Override
	public void setCoordY(java.lang.String coordY) {
		_event.setCoordY(coordY);
	}

	/**
	* Returns the create date of this event.
	*
	* @return the create date of this event
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _event.getCreateDate();
	}

	/**
	* Sets the create date of this event.
	*
	* @param createDate the create date of this event
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_event.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this event.
	*
	* @return the modified date of this event
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _event.getModifiedDate();
	}

	/**
	* Sets the modified date of this event.
	*
	* @param modifiedDate the modified date of this event
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_event.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the requires approval of this event.
	*
	* @return the requires approval of this event
	*/
	@Override
	public boolean getRequiresApproval() {
		return _event.getRequiresApproval();
	}

	/**
	* Returns <code>true</code> if this event is requires approval.
	*
	* @return <code>true</code> if this event is requires approval; <code>false</code> otherwise
	*/
	@Override
	public boolean isRequiresApproval() {
		return _event.isRequiresApproval();
	}

	/**
	* Sets whether this event is requires approval.
	*
	* @param requiresApproval the requires approval of this event
	*/
	@Override
	public void setRequiresApproval(boolean requiresApproval) {
		_event.setRequiresApproval(requiresApproval);
	}

	/**
	* Returns the status of this event.
	*
	* @return the status of this event
	*/
	@Override
	public int getStatus() {
		return _event.getStatus();
	}

	/**
	* Sets the status of this event.
	*
	* @param status the status of this event
	*/
	@Override
	public void setStatus(int status) {
		_event.setStatus(status);
	}

	/**
	* Returns the created by of this event.
	*
	* @return the created by of this event
	*/
	@Override
	public long getCreatedBy() {
		return _event.getCreatedBy();
	}

	/**
	* Sets the created by of this event.
	*
	* @param createdBy the created by of this event
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_event.setCreatedBy(createdBy);
	}

	@Override
	public boolean isNew() {
		return _event.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_event.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _event.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_event.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _event.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _event.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_event.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _event.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_event.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_event.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_event.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _event.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _event.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_event.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_event.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new EventWrapper((Event)_event.clone());
	}

	@Override
	public int compareTo(edu.uoc.eventreg.model.Event event) {
		return _event.compareTo(event);
	}

	@Override
	public int hashCode() {
		return _event.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<edu.uoc.eventreg.model.Event> toCacheModel() {
		return _event.toCacheModel();
	}

	@Override
	public edu.uoc.eventreg.model.Event toEscapedModel() {
		return new EventWrapper(_event.toEscapedModel());
	}

	@Override
	public edu.uoc.eventreg.model.Event toUnescapedModel() {
		return new EventWrapper(_event.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _event.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _event.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_event.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventWrapper)) {
			return false;
		}

		EventWrapper eventWrapper = (EventWrapper)obj;

		if (Validator.equals(_event, eventWrapper._event)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Event getWrappedEvent() {
		return _event;
	}

	@Override
	public Event getWrappedModel() {
		return _event;
	}

	@Override
	public void resetOriginalValues() {
		_event.resetOriginalValues();
	}

	private Event _event;
}