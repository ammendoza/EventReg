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
public class EventOptionFinderUtil {
	public static long findAvailableSeats(long eventOptionId) {
		return getFinder().findAvailableSeats(eventOptionId);
	}

	public static EventOptionFinder getFinder() {
		if (_finder == null) {
			_finder = (EventOptionFinder)PortletBeanLocatorUtil.locate(edu.uoc.eventreg.service.ClpSerializer.getServletContextName(),
					EventOptionFinder.class.getName());

			ReferenceRegistry.registerReference(EventOptionFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(EventOptionFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(EventOptionFinderUtil.class,
			"_finder");
	}

	private static EventOptionFinder _finder;
}