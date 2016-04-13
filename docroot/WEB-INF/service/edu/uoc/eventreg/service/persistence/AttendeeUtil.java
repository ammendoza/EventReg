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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import edu.uoc.eventreg.model.Attendee;

import java.util.List;

/**
 * The persistence utility for the attendee service. This utility wraps {@link AttendeePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ana Mendoza
 * @see AttendeePersistence
 * @see AttendeePersistenceImpl
 * @generated
 */
public class AttendeeUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Attendee attendee) {
		getPersistence().clearCache(attendee);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Attendee> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Attendee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Attendee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Attendee update(Attendee attendee) throws SystemException {
		return getPersistence().update(attendee);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Attendee update(Attendee attendee,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(attendee, serviceContext);
	}

	/**
	* Caches the attendee in the entity cache if it is enabled.
	*
	* @param attendee the attendee
	*/
	public static void cacheResult(edu.uoc.eventreg.model.Attendee attendee) {
		getPersistence().cacheResult(attendee);
	}

	/**
	* Caches the attendees in the entity cache if it is enabled.
	*
	* @param attendees the attendees
	*/
	public static void cacheResult(
		java.util.List<edu.uoc.eventreg.model.Attendee> attendees) {
		getPersistence().cacheResult(attendees);
	}

	/**
	* Creates a new attendee with the primary key. Does not add the attendee to the database.
	*
	* @param id the primary key for the new attendee
	* @return the new attendee
	*/
	public static edu.uoc.eventreg.model.Attendee create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the attendee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the attendee
	* @return the attendee that was removed
	* @throws edu.uoc.eventreg.NoSuchAttendeeException if a attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.uoc.eventreg.model.Attendee remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.uoc.eventreg.NoSuchAttendeeException {
		return getPersistence().remove(id);
	}

	public static edu.uoc.eventreg.model.Attendee updateImpl(
		edu.uoc.eventreg.model.Attendee attendee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(attendee);
	}

	/**
	* Returns the attendee with the primary key or throws a {@link edu.uoc.eventreg.NoSuchAttendeeException} if it could not be found.
	*
	* @param id the primary key of the attendee
	* @return the attendee
	* @throws edu.uoc.eventreg.NoSuchAttendeeException if a attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.uoc.eventreg.model.Attendee findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.uoc.eventreg.NoSuchAttendeeException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the attendee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the attendee
	* @return the attendee, or <code>null</code> if a attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.uoc.eventreg.model.Attendee fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the attendees.
	*
	* @return the attendees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.uoc.eventreg.model.Attendee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<edu.uoc.eventreg.model.Attendee> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<edu.uoc.eventreg.model.Attendee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the attendees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of attendees.
	*
	* @return the number of attendees
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AttendeePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AttendeePersistence)PortletBeanLocatorUtil.locate(edu.uoc.eventreg.service.ClpSerializer.getServletContextName(),
					AttendeePersistence.class.getName());

			ReferenceRegistry.registerReference(AttendeeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AttendeePersistence persistence) {
	}

	private static AttendeePersistence _persistence;
}