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

package edu.uoc.eventreg.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AttendeeLocalService}.
 *
 * @author Ana Mendoza
 * @see AttendeeLocalService
 * @generated
 */
public class AttendeeLocalServiceWrapper implements AttendeeLocalService,
	ServiceWrapper<AttendeeLocalService> {
	public AttendeeLocalServiceWrapper(
		AttendeeLocalService attendeeLocalService) {
		_attendeeLocalService = attendeeLocalService;
	}

	/**
	* Adds the attendee to the database. Also notifies the appropriate model listeners.
	*
	* @param attendee the attendee
	* @return the attendee that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.Attendee addAttendee(
		edu.uoc.eventreg.model.Attendee attendee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attendeeLocalService.addAttendee(attendee);
	}

	/**
	* Creates a new attendee with the primary key. Does not add the attendee to the database.
	*
	* @param attendeeId the primary key for the new attendee
	* @return the new attendee
	*/
	@Override
	public edu.uoc.eventreg.model.Attendee createAttendee(long attendeeId) {
		return _attendeeLocalService.createAttendee(attendeeId);
	}

	/**
	* Deletes the attendee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attendeeId the primary key of the attendee
	* @return the attendee that was removed
	* @throws PortalException if a attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.Attendee deleteAttendee(long attendeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _attendeeLocalService.deleteAttendee(attendeeId);
	}

	/**
	* Deletes the attendee from the database. Also notifies the appropriate model listeners.
	*
	* @param attendee the attendee
	* @return the attendee that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.Attendee deleteAttendee(
		edu.uoc.eventreg.model.Attendee attendee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attendeeLocalService.deleteAttendee(attendee);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _attendeeLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attendeeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.AttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _attendeeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.AttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attendeeLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attendeeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attendeeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public edu.uoc.eventreg.model.Attendee fetchAttendee(long attendeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attendeeLocalService.fetchAttendee(attendeeId);
	}

	/**
	* Returns the attendee with the primary key.
	*
	* @param attendeeId the primary key of the attendee
	* @return the attendee
	* @throws PortalException if a attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.Attendee getAttendee(long attendeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _attendeeLocalService.getAttendee(attendeeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _attendeeLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<edu.uoc.eventreg.model.Attendee> getAttendees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attendeeLocalService.getAttendees(start, end);
	}

	/**
	* Returns the number of attendees.
	*
	* @return the number of attendees
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAttendeesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attendeeLocalService.getAttendeesCount();
	}

	/**
	* Updates the attendee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param attendee the attendee
	* @return the attendee that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.Attendee updateAttendee(
		edu.uoc.eventreg.model.Attendee attendee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attendeeLocalService.updateAttendee(attendee);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _attendeeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_attendeeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _attendeeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<edu.uoc.eventreg.model.Attendee> findByEvent(
		long eventId) {
		return _attendeeLocalService.findByEvent(eventId);
	}

	@Override
	public java.util.List<java.lang.Object[]> findDayCount(long companyId,
		long groupId) {
		return _attendeeLocalService.findDayCount(companyId, groupId);
	}

	@Override
	public java.util.List<java.lang.Object[]> findDayCount(long eventId) {
		return _attendeeLocalService.findDayCount(eventId);
	}

	@Override
	public java.util.List<edu.uoc.eventreg.model.Attendee> findGroupAttendees(
		long companyId, long groupId) {
		return _attendeeLocalService.findGroupAttendees(companyId, groupId);
	}

	@Override
	public java.util.List<edu.uoc.eventreg.model.Attendee> searchAttendees(
		long companyId, long groupId, java.lang.String name,
		java.lang.String surname, java.lang.String email, int status,
		boolean andSearch, int start, int end) {
		return _attendeeLocalService.searchAttendees(companyId, groupId, name,
			surname, email, status, andSearch, start, end);
	}

	@Override
	public int searchAttendeeCount(long companyId, long groupId,
		java.lang.String name, java.lang.String surname,
		java.lang.String email, int status, boolean andSearch) {
		return _attendeeLocalService.searchAttendeeCount(companyId, groupId,
			name, surname, email, status, andSearch);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AttendeeLocalService getWrappedAttendeeLocalService() {
		return _attendeeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAttendeeLocalService(
		AttendeeLocalService attendeeLocalService) {
		_attendeeLocalService = attendeeLocalService;
	}

	@Override
	public AttendeeLocalService getWrappedService() {
		return _attendeeLocalService;
	}

	@Override
	public void setWrappedService(AttendeeLocalService attendeeLocalService) {
		_attendeeLocalService = attendeeLocalService;
	}

	private AttendeeLocalService _attendeeLocalService;
}