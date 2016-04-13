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

import edu.uoc.eventreg.model.RegEvent;

/**
 * The persistence interface for the reg event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ana Mendoza
 * @see RegEventPersistenceImpl
 * @see RegEventUtil
 * @generated
 */
public interface RegEventPersistence extends BasePersistence<RegEvent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RegEventUtil} to access the reg event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the reg event in the entity cache if it is enabled.
	*
	* @param regEvent the reg event
	*/
	public void cacheResult(edu.uoc.eventreg.model.RegEvent regEvent);

	/**
	* Caches the reg events in the entity cache if it is enabled.
	*
	* @param regEvents the reg events
	*/
	public void cacheResult(
		java.util.List<edu.uoc.eventreg.model.RegEvent> regEvents);

	/**
	* Creates a new reg event with the primary key. Does not add the reg event to the database.
	*
	* @param id the primary key for the new reg event
	* @return the new reg event
	*/
	public edu.uoc.eventreg.model.RegEvent create(long id);

	/**
	* Removes the reg event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the reg event
	* @return the reg event that was removed
	* @throws edu.uoc.eventreg.NoSuchRegEventException if a reg event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.RegEvent remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.uoc.eventreg.NoSuchRegEventException;

	public edu.uoc.eventreg.model.RegEvent updateImpl(
		edu.uoc.eventreg.model.RegEvent regEvent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the reg event with the primary key or throws a {@link edu.uoc.eventreg.NoSuchRegEventException} if it could not be found.
	*
	* @param id the primary key of the reg event
	* @return the reg event
	* @throws edu.uoc.eventreg.NoSuchRegEventException if a reg event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.RegEvent findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.uoc.eventreg.NoSuchRegEventException;

	/**
	* Returns the reg event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the reg event
	* @return the reg event, or <code>null</code> if a reg event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.RegEvent fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the reg events.
	*
	* @return the reg events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.RegEvent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the reg events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.RegEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of reg events
	* @param end the upper bound of the range of reg events (not inclusive)
	* @return the range of reg events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.RegEvent> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the reg events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.RegEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of reg events
	* @param end the upper bound of the range of reg events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of reg events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.RegEvent> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reg events from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of reg events.
	*
	* @return the number of reg events
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}