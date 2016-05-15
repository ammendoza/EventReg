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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Ana Mendoza
 */
public class AttendeeFinderUtil {
	public static java.util.List<edu.uoc.eventreg.model.Attendee> findByEvent(
		long eventId) {
		return getFinder().findByEvent(eventId);
	}

	public static AttendeeFinder getFinder() {
		if (_finder == null) {
			_finder = (AttendeeFinder)PortletBeanLocatorUtil.locate(edu.uoc.eventreg.service.ClpSerializer.getServletContextName(),
					AttendeeFinder.class.getName());

			ReferenceRegistry.registerReference(AttendeeFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AttendeeFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AttendeeFinderUtil.class, "_finder");
	}

	private static AttendeeFinder _finder;
}