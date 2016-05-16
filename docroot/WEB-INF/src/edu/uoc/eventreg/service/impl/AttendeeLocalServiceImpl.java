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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import edu.uoc.eventreg.model.Attendee;
import edu.uoc.eventreg.service.AttendeeLocalServiceUtil;
import edu.uoc.eventreg.service.EventLocalServiceUtil;
import edu.uoc.eventreg.service.base.AttendeeLocalServiceBaseImpl;
import edu.uoc.eventreg.service.persistence.AttendeeFinderUtil;
import edu.uoc.eventreg.service.persistence.AttendeeUtil;

/**
 * The implementation of the attendee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link edu.uoc.eventreg.service.AttendeeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ana Mendoza
 * @see edu.uoc.eventreg.service.base.AttendeeLocalServiceBaseImpl
 * @see edu.uoc.eventreg.service.AttendeeLocalServiceUtil
 */
public class AttendeeLocalServiceImpl extends AttendeeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link edu.uoc.eventreg.service.AttendeeLocalServiceUtil} to access the attendee local service.
	 */
	
	public List<Attendee> findByEvent (long eventId) {

		List<Attendee> list = AttendeeFinderUtil.findByEvent(eventId);
		
		return list;
	}
	
	public List<Attendee> findGroupAttendees (long companyId, long groupId) {
		List<Attendee> attendees = null;
		
		try {
			return AttendeeUtil.findByGroupAttendees(companyId, groupId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return attendees;
	}
	
	public List<Attendee> searchAttendees (long companyId, long groupId, String name, String surname, String email, int status, boolean andSearch, int start, int end) {
			
		List<Attendee> attendees = null;
		
		DynamicQuery dynamicQuery = searchAttendeesQuery(companyId, groupId, name, surname, email, status, andSearch);
		
		try {
			attendees = (List<Attendee>) AttendeeLocalServiceUtil.dynamicQuery(dynamicQuery, start, end);
		} catch (SystemException e) {
			e.printStackTrace();
		}
			
		return attendees;
	}
	
	public int searchAttendeeCount (long companyId, long groupId, String name, String surname, String email, int status, boolean andSearch) {

		int count = 0;
		DynamicQuery dynamicQuery = searchAttendeesQuery(companyId, groupId, name, surname, email, status, andSearch);
			
		try {
			count = (int) EventLocalServiceUtil.dynamicQueryCount(dynamicQuery);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	private DynamicQuery searchAttendeesQuery (long companyId, long groupId, String name, String surname, String email, int status, boolean andSearch) {
		
		Junction junction = null;
		if(andSearch)
			junction = RestrictionsFactoryUtil.conjunction();
		else
			junction = RestrictionsFactoryUtil.disjunction();
		
		if (Validator.isNotNull(name) && !name.isEmpty())
			junction.add(RestrictionsFactoryUtil.ilike("name", "%"+name+"%"));
		
		if (Validator.isNotNull(surname) && !surname.isEmpty())
			junction.add(RestrictionsFactoryUtil.ilike("surname", "%"+surname+"%"));
		
		if (Validator.isNotNull(email) && !email.isEmpty())
			junction.add(RestrictionsFactoryUtil.ilike("email", "%"+email+"%"));
	
		if (status != 0)
			junction.add(RestrictionsFactoryUtil.eq("status", status));
		
		Junction groupJunction = RestrictionsFactoryUtil.conjunction();
		groupJunction.add(junction);
		groupJunction.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		groupJunction.add(RestrictionsFactoryUtil.eq("groupId", groupId));
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Attendee.class, getClassLoader());
		dynamicQuery.add(junction);

		return dynamicQuery;
	}
}