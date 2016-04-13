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
 * Provides a wrapper for {@link RegEventLocalService}.
 *
 * @author Ana Mendoza
 * @see RegEventLocalService
 * @generated
 */
public class RegEventLocalServiceWrapper implements RegEventLocalService,
	ServiceWrapper<RegEventLocalService> {
	public RegEventLocalServiceWrapper(
		RegEventLocalService regEventLocalService) {
		_regEventLocalService = regEventLocalService;
	}

	/**
	* Adds the reg event to the database. Also notifies the appropriate model listeners.
	*
	* @param regEvent the reg event
	* @return the reg event that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.RegEvent addRegEvent(
		edu.uoc.eventreg.model.RegEvent regEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _regEventLocalService.addRegEvent(regEvent);
	}

	/**
	* Creates a new reg event with the primary key. Does not add the reg event to the database.
	*
	* @param id the primary key for the new reg event
	* @return the new reg event
	*/
	@Override
	public edu.uoc.eventreg.model.RegEvent createRegEvent(long id) {
		return _regEventLocalService.createRegEvent(id);
	}

	/**
	* Deletes the reg event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the reg event
	* @return the reg event that was removed
	* @throws PortalException if a reg event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.RegEvent deleteRegEvent(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _regEventLocalService.deleteRegEvent(id);
	}

	/**
	* Deletes the reg event from the database. Also notifies the appropriate model listeners.
	*
	* @param regEvent the reg event
	* @return the reg event that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.RegEvent deleteRegEvent(
		edu.uoc.eventreg.model.RegEvent regEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _regEventLocalService.deleteRegEvent(regEvent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _regEventLocalService.dynamicQuery();
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
		return _regEventLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.RegEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _regEventLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.RegEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _regEventLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _regEventLocalService.dynamicQueryCount(dynamicQuery);
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
		return _regEventLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public edu.uoc.eventreg.model.RegEvent fetchRegEvent(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _regEventLocalService.fetchRegEvent(id);
	}

	/**
	* Returns the reg event with the primary key.
	*
	* @param id the primary key of the reg event
	* @return the reg event
	* @throws PortalException if a reg event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.RegEvent getRegEvent(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _regEventLocalService.getRegEvent(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _regEventLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<edu.uoc.eventreg.model.RegEvent> getRegEvents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _regEventLocalService.getRegEvents(start, end);
	}

	/**
	* Returns the number of reg events.
	*
	* @return the number of reg events
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRegEventsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _regEventLocalService.getRegEventsCount();
	}

	/**
	* Updates the reg event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param regEvent the reg event
	* @return the reg event that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.RegEvent updateRegEvent(
		edu.uoc.eventreg.model.RegEvent regEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _regEventLocalService.updateRegEvent(regEvent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _regEventLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_regEventLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _regEventLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RegEventLocalService getWrappedRegEventLocalService() {
		return _regEventLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRegEventLocalService(
		RegEventLocalService regEventLocalService) {
		_regEventLocalService = regEventLocalService;
	}

	@Override
	public RegEventLocalService getWrappedService() {
		return _regEventLocalService;
	}

	@Override
	public void setWrappedService(RegEventLocalService regEventLocalService) {
		_regEventLocalService = regEventLocalService;
	}

	private RegEventLocalService _regEventLocalService;
}