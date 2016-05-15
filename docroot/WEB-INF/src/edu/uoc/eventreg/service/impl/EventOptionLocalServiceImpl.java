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

package edu.uoc.eventreg.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import edu.uoc.eventreg.model.EventOption;
import edu.uoc.eventreg.service.base.EventOptionLocalServiceBaseImpl;
import edu.uoc.eventreg.service.persistence.EventOptionUtil;

/**
 * The implementation of the event option local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link edu.uoc.eventreg.service.EventOptionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ana Mendoza
 * @see edu.uoc.eventreg.service.base.EventOptionLocalServiceBaseImpl
 * @see edu.uoc.eventreg.service.EventOptionLocalServiceUtil
 */
public class EventOptionLocalServiceImpl extends EventOptionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link edu.uoc.eventreg.service.EventOptionLocalServiceUtil} to access the event option local service.
	 */
	
	public List<EventOption> findEventOptions (long eventId) {
		List<EventOption> eventOptions = null;
		
		try {
			eventOptions = EventOptionUtil.findByeventId(eventId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return eventOptions;
	}
}