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

import com.liferay.portal.service.persistence.BasePersistence;

import edu.uoc.eventreg.model.Attendee;

/**
 * The persistence interface for the attendee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ana Mendoza
 * @see AttendeePersistenceImpl
 * @see AttendeeUtil
 * @generated
 */
public interface AttendeePersistence extends BasePersistence<Attendee> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AttendeeUtil} to access the attendee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the attendees where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.Attendee> findByGroupAttendees(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the attendees where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.AttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of attendees
	* @param end the upper bound of the range of attendees (not inclusive)
	* @return the range of matching attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.Attendee> findByGroupAttendees(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the attendees where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.AttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of attendees
	* @param end the upper bound of the range of attendees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.Attendee> findByGroupAttendees(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first attendee in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attendee
	* @throws edu.uoc.eventreg.NoSuchAttendeeException if a matching attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.Attendee findByGroupAttendees_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.uoc.eventreg.NoSuchAttendeeException;

	/**
	* Returns the first attendee in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attendee, or <code>null</code> if a matching attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.Attendee fetchByGroupAttendees_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last attendee in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attendee
	* @throws edu.uoc.eventreg.NoSuchAttendeeException if a matching attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.Attendee findByGroupAttendees_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.uoc.eventreg.NoSuchAttendeeException;

	/**
	* Returns the last attendee in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attendee, or <code>null</code> if a matching attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.Attendee fetchByGroupAttendees_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the attendees before and after the current attendee in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param attendeeId the primary key of the current attendee
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attendee
	* @throws edu.uoc.eventreg.NoSuchAttendeeException if a attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.Attendee[] findByGroupAttendees_PrevAndNext(
		long attendeeId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.uoc.eventreg.NoSuchAttendeeException;

	/**
	* Removes all the attendees where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupAttendees(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of attendees where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching attendees
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupAttendees(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the attendees where email = &#63; and eventOptionId = &#63;.
	*
	* @param email the email
	* @param eventOptionId the event option ID
	* @return the matching attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.Attendee> findByEmailAndEventOption(
		java.lang.String email, long eventOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the attendees where email = &#63; and eventOptionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.AttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param eventOptionId the event option ID
	* @param start the lower bound of the range of attendees
	* @param end the upper bound of the range of attendees (not inclusive)
	* @return the range of matching attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.Attendee> findByEmailAndEventOption(
		java.lang.String email, long eventOptionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the attendees where email = &#63; and eventOptionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.AttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param eventOptionId the event option ID
	* @param start the lower bound of the range of attendees
	* @param end the upper bound of the range of attendees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.Attendee> findByEmailAndEventOption(
		java.lang.String email, long eventOptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first attendee in the ordered set where email = &#63; and eventOptionId = &#63;.
	*
	* @param email the email
	* @param eventOptionId the event option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attendee
	* @throws edu.uoc.eventreg.NoSuchAttendeeException if a matching attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.Attendee findByEmailAndEventOption_First(
		java.lang.String email, long eventOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.uoc.eventreg.NoSuchAttendeeException;

	/**
	* Returns the first attendee in the ordered set where email = &#63; and eventOptionId = &#63;.
	*
	* @param email the email
	* @param eventOptionId the event option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attendee, or <code>null</code> if a matching attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.Attendee fetchByEmailAndEventOption_First(
		java.lang.String email, long eventOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last attendee in the ordered set where email = &#63; and eventOptionId = &#63;.
	*
	* @param email the email
	* @param eventOptionId the event option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attendee
	* @throws edu.uoc.eventreg.NoSuchAttendeeException if a matching attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.Attendee findByEmailAndEventOption_Last(
		java.lang.String email, long eventOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.uoc.eventreg.NoSuchAttendeeException;

	/**
	* Returns the last attendee in the ordered set where email = &#63; and eventOptionId = &#63;.
	*
	* @param email the email
	* @param eventOptionId the event option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attendee, or <code>null</code> if a matching attendee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.Attendee fetchByEmailAndEventOption_Last(
		java.lang.String email, long eventOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the attendees before and after the current attendee in the ordered set where email = &#63; and eventOptionId = &#63;.
	*
	* @param attendeeId the primary key of the current attendee
	* @param email the email
	* @param eventOptionId the event option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attendee
	* @throws edu.uoc.eventreg.NoSuchAttendeeException if a attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.Attendee[] findByEmailAndEventOption_PrevAndNext(
		long attendeeId, java.lang.String email, long eventOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.uoc.eventreg.NoSuchAttendeeException;

	/**
	* Removes all the attendees where email = &#63; and eventOptionId = &#63; from the database.
	*
	* @param email the email
	* @param eventOptionId the event option ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmailAndEventOption(java.lang.String email,
		long eventOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of attendees where email = &#63; and eventOptionId = &#63;.
	*
	* @param email the email
	* @param eventOptionId the event option ID
	* @return the number of matching attendees
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailAndEventOption(java.lang.String email,
		long eventOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the attendee in the entity cache if it is enabled.
	*
	* @param attendee the attendee
	*/
	public void cacheResult(edu.uoc.eventreg.model.Attendee attendee);

	/**
	* Caches the attendees in the entity cache if it is enabled.
	*
	* @param attendees the attendees
	*/
	public void cacheResult(
		java.util.List<edu.uoc.eventreg.model.Attendee> attendees);

	/**
	* Creates a new attendee with the primary key. Does not add the attendee to the database.
	*
	* @param attendeeId the primary key for the new attendee
	* @return the new attendee
	*/
	public edu.uoc.eventreg.model.Attendee create(long attendeeId);

	/**
	* Removes the attendee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attendeeId the primary key of the attendee
	* @return the attendee that was removed
	* @throws edu.uoc.eventreg.NoSuchAttendeeException if a attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.Attendee remove(long attendeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.uoc.eventreg.NoSuchAttendeeException;

	public edu.uoc.eventreg.model.Attendee updateImpl(
		edu.uoc.eventreg.model.Attendee attendee)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the attendee with the primary key or throws a {@link edu.uoc.eventreg.NoSuchAttendeeException} if it could not be found.
	*
	* @param attendeeId the primary key of the attendee
	* @return the attendee
	* @throws edu.uoc.eventreg.NoSuchAttendeeException if a attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.Attendee findByPrimaryKey(long attendeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.uoc.eventreg.NoSuchAttendeeException;

	/**
	* Returns the attendee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param attendeeId the primary key of the attendee
	* @return the attendee, or <code>null</code> if a attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.Attendee fetchByPrimaryKey(long attendeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the attendees.
	*
	* @return the attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.Attendee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the attendees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.AttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendees
	* @param end the upper bound of the range of attendees (not inclusive)
	* @return the range of attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.Attendee> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the attendees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.AttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attendees
	* @param end the upper bound of the range of attendees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of attendees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.Attendee> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the attendees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of attendees.
	*
	* @return the number of attendees
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}