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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Image}.
 * </p>
 *
 * @author Ana Mendoza
 * @see Image
 * @generated
 */
public class ImageWrapper implements Image, ModelWrapper<Image> {
	public ImageWrapper(Image image) {
		_image = image;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

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
	}

	/**
	* Returns the primary key of this image.
	*
	* @return the primary key of this image
	*/
	@Override
	public long getPrimaryKey() {
		return _image.getPrimaryKey();
	}

	/**
	* Sets the primary key of this image.
	*
	* @param primaryKey the primary key of this image
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_image.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this image.
	*
	* @return the ID of this image
	*/
	@Override
	public long getId() {
		return _image.getId();
	}

	/**
	* Sets the ID of this image.
	*
	* @param id the ID of this image
	*/
	@Override
	public void setId(long id) {
		_image.setId(id);
	}

	/**
	* Returns the company ID of this image.
	*
	* @return the company ID of this image
	*/
	@Override
	public long getCompanyId() {
		return _image.getCompanyId();
	}

	/**
	* Sets the company ID of this image.
	*
	* @param companyId the company ID of this image
	*/
	@Override
	public void setCompanyId(long companyId) {
		_image.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this image.
	*
	* @return the group ID of this image
	*/
	@Override
	public long getGroupId() {
		return _image.getGroupId();
	}

	/**
	* Sets the group ID of this image.
	*
	* @param groupId the group ID of this image
	*/
	@Override
	public void setGroupId(long groupId) {
		_image.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _image.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_image.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _image.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_image.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _image.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _image.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_image.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _image.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_image.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_image.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_image.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ImageWrapper((Image)_image.clone());
	}

	@Override
	public int compareTo(edu.uoc.eventreg.model.Image image) {
		return _image.compareTo(image);
	}

	@Override
	public int hashCode() {
		return _image.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<edu.uoc.eventreg.model.Image> toCacheModel() {
		return _image.toCacheModel();
	}

	@Override
	public edu.uoc.eventreg.model.Image toEscapedModel() {
		return new ImageWrapper(_image.toEscapedModel());
	}

	@Override
	public edu.uoc.eventreg.model.Image toUnescapedModel() {
		return new ImageWrapper(_image.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _image.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _image.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_image.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImageWrapper)) {
			return false;
		}

		ImageWrapper imageWrapper = (ImageWrapper)obj;

		if (Validator.equals(_image, imageWrapper._image)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Image getWrappedImage() {
		return _image;
	}

	@Override
	public Image getWrappedModel() {
		return _image;
	}

	@Override
	public void resetOriginalValues() {
		_image.resetOriginalValues();
	}

	private Image _image;
}