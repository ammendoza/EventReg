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
	* Returns the localized title of this reg event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this reg event
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _regEvent.getTitle(locale);
	}

	/**
	* Returns the localized title of this reg event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this reg event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _regEvent.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this reg event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this reg event
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _regEvent.getTitle(languageId);
	}

	/**
	* Returns the localized title of this reg event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this reg event
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _regEvent.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _regEvent.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _regEvent.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this reg event.
	*
	* @return the locales and localized titles of this reg event
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _regEvent.getTitleMap();
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
	* Sets the localized title of this reg event in the language.
	*
	* @param title the localized title of this reg event
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_regEvent.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this reg event in the language, and sets the default locale.
	*
	* @param title the localized title of this reg event
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_regEvent.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_regEvent.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this reg event from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this reg event
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap) {
		_regEvent.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this reg event from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this reg event
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_regEvent.setTitleMap(titleMap, defaultLocale);
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
	* Returns the localized description of this reg event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this reg event
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _regEvent.getDescription(locale);
	}

	/**
	* Returns the localized description of this reg event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this reg event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _regEvent.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this reg event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this reg event
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _regEvent.getDescription(languageId);
	}

	/**
	* Returns the localized description of this reg event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this reg event
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _regEvent.getDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _regEvent.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _regEvent.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this reg event.
	*
	* @return the locales and localized descriptions of this reg event
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _regEvent.getDescriptionMap();
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
	* Sets the localized description of this reg event in the language.
	*
	* @param description the localized description of this reg event
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_regEvent.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this reg event in the language, and sets the default locale.
	*
	* @param description the localized description of this reg event
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_regEvent.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_regEvent.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this reg event from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this reg event
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
		_regEvent.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this reg event from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this reg event
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_regEvent.setDescriptionMap(descriptionMap, defaultLocale);
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
	* Returns the localized address of this reg event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized address of this reg event
	*/
	@Override
	public java.lang.String getAddress(java.util.Locale locale) {
		return _regEvent.getAddress(locale);
	}

	/**
	* Returns the localized address of this reg event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized address of this reg event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getAddress(java.util.Locale locale,
		boolean useDefault) {
		return _regEvent.getAddress(locale, useDefault);
	}

	/**
	* Returns the localized address of this reg event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized address of this reg event
	*/
	@Override
	public java.lang.String getAddress(java.lang.String languageId) {
		return _regEvent.getAddress(languageId);
	}

	/**
	* Returns the localized address of this reg event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized address of this reg event
	*/
	@Override
	public java.lang.String getAddress(java.lang.String languageId,
		boolean useDefault) {
		return _regEvent.getAddress(languageId, useDefault);
	}

	@Override
	public java.lang.String getAddressCurrentLanguageId() {
		return _regEvent.getAddressCurrentLanguageId();
	}

	@Override
	public java.lang.String getAddressCurrentValue() {
		return _regEvent.getAddressCurrentValue();
	}

	/**
	* Returns a map of the locales and localized addresses of this reg event.
	*
	* @return the locales and localized addresses of this reg event
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getAddressMap() {
		return _regEvent.getAddressMap();
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
	* Sets the localized address of this reg event in the language.
	*
	* @param address the localized address of this reg event
	* @param locale the locale of the language
	*/
	@Override
	public void setAddress(java.lang.String address, java.util.Locale locale) {
		_regEvent.setAddress(address, locale);
	}

	/**
	* Sets the localized address of this reg event in the language, and sets the default locale.
	*
	* @param address the localized address of this reg event
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setAddress(java.lang.String address, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_regEvent.setAddress(address, locale, defaultLocale);
	}

	@Override
	public void setAddressCurrentLanguageId(java.lang.String languageId) {
		_regEvent.setAddressCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized addresses of this reg event from the map of locales and localized addresses.
	*
	* @param addressMap the locales and localized addresses of this reg event
	*/
	@Override
	public void setAddressMap(
		java.util.Map<java.util.Locale, java.lang.String> addressMap) {
		_regEvent.setAddressMap(addressMap);
	}

	/**
	* Sets the localized addresses of this reg event from the map of locales and localized addresses, and sets the default locale.
	*
	* @param addressMap the locales and localized addresses of this reg event
	* @param defaultLocale the default locale
	*/
	@Override
	public void setAddressMap(
		java.util.Map<java.util.Locale, java.lang.String> addressMap,
		java.util.Locale defaultLocale) {
		_regEvent.setAddressMap(addressMap, defaultLocale);
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
	* Returns the localized location of this reg event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized location of this reg event
	*/
	@Override
	public java.lang.String getLocation(java.util.Locale locale) {
		return _regEvent.getLocation(locale);
	}

	/**
	* Returns the localized location of this reg event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized location of this reg event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getLocation(java.util.Locale locale,
		boolean useDefault) {
		return _regEvent.getLocation(locale, useDefault);
	}

	/**
	* Returns the localized location of this reg event in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized location of this reg event
	*/
	@Override
	public java.lang.String getLocation(java.lang.String languageId) {
		return _regEvent.getLocation(languageId);
	}

	/**
	* Returns the localized location of this reg event in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized location of this reg event
	*/
	@Override
	public java.lang.String getLocation(java.lang.String languageId,
		boolean useDefault) {
		return _regEvent.getLocation(languageId, useDefault);
	}

	@Override
	public java.lang.String getLocationCurrentLanguageId() {
		return _regEvent.getLocationCurrentLanguageId();
	}

	@Override
	public java.lang.String getLocationCurrentValue() {
		return _regEvent.getLocationCurrentValue();
	}

	/**
	* Returns a map of the locales and localized locations of this reg event.
	*
	* @return the locales and localized locations of this reg event
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getLocationMap() {
		return _regEvent.getLocationMap();
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
	* Sets the localized location of this reg event in the language.
	*
	* @param location the localized location of this reg event
	* @param locale the locale of the language
	*/
	@Override
	public void setLocation(java.lang.String location, java.util.Locale locale) {
		_regEvent.setLocation(location, locale);
	}

	/**
	* Sets the localized location of this reg event in the language, and sets the default locale.
	*
	* @param location the localized location of this reg event
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setLocation(java.lang.String location, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_regEvent.setLocation(location, locale, defaultLocale);
	}

	@Override
	public void setLocationCurrentLanguageId(java.lang.String languageId) {
		_regEvent.setLocationCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized locations of this reg event from the map of locales and localized locations.
	*
	* @param locationMap the locales and localized locations of this reg event
	*/
	@Override
	public void setLocationMap(
		java.util.Map<java.util.Locale, java.lang.String> locationMap) {
		_regEvent.setLocationMap(locationMap);
	}

	/**
	* Sets the localized locations of this reg event from the map of locales and localized locations, and sets the default locale.
	*
	* @param locationMap the locales and localized locations of this reg event
	* @param defaultLocale the default locale
	*/
	@Override
	public void setLocationMap(
		java.util.Map<java.util.Locale, java.lang.String> locationMap,
		java.util.Locale defaultLocale) {
		_regEvent.setLocationMap(locationMap, defaultLocale);
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

	/**
	* Returns the created by of this reg event.
	*
	* @return the created by of this reg event
	*/
	@Override
	public long getCreatedBy() {
		return _regEvent.getCreatedBy();
	}

	/**
	* Sets the created by of this reg event.
	*
	* @param createdBy the created by of this reg event
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_regEvent.setCreatedBy(createdBy);
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
	public java.lang.String[] getAvailableLanguageIds() {
		return _regEvent.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _regEvent.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_regEvent.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_regEvent.prepareLocalizedFieldsForImport(defaultImportLocale);
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