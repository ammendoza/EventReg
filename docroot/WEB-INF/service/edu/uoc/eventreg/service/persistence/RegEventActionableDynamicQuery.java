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

package edu.uoc.eventreg.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import edu.uoc.eventreg.model.RegEvent;
import edu.uoc.eventreg.service.RegEventLocalServiceUtil;

/**
 * @author Ana Mendoza
 * @generated
 */
public abstract class RegEventActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public RegEventActionableDynamicQuery() throws SystemException {
		setBaseLocalService(RegEventLocalServiceUtil.getService());
		setClass(RegEvent.class);

		setClassLoader(edu.uoc.eventreg.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("id");
	}
}