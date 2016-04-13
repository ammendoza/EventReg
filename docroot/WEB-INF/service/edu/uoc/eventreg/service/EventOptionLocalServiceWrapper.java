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
 * Provides a wrapper for {@link EventOptionLocalService}.
 *
 * @author Ana Mendoza
 * @see EventOptionLocalService
 * @generated
 */
public class EventOptionLocalServiceWrapper implements EventOptionLocalService,
	ServiceWrapper<EventOptionLocalService> {
	public EventOptionLocalServiceWrapper(
		EventOptionLocalService eventOptionLocalService) {
		_eventOptionLocalService = eventOptionLocalService;
	}

	/**
	* Adds the event option to the database. Also notifies the appropriate model listeners.
	*
	* @param eventOption the event option
	* @return the event option that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.EventOption addEventOption(
		edu.uoc.eventreg.model.EventOption eventOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventOptionLocalService.addEventOption(eventOption);
	}

	/**
	* Creates a new event option with the primary key. Does not add the event option to the database.
	*
	* @param id the primary key for the new event option
	* @return the new event option
	*/
	@Override
	public edu.uoc.eventreg.model.EventOption createEventOption(long id) {
		return _eventOptionLocalService.createEventOption(id);
	}

	/**
	* Deletes the event option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the event option
	* @return the event option that was removed
	* @throws PortalException if a event option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.EventOption deleteEventOption(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventOptionLocalService.deleteEventOption(id);
	}

	/**
	* Deletes the event option from the database. Also notifies the appropriate model listeners.
	*
	* @param eventOption the event option
	* @return the event option that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.EventOption deleteEventOption(
		edu.uoc.eventreg.model.EventOption eventOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventOptionLocalService.deleteEventOption(eventOption);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventOptionLocalService.dynamicQuery();
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
		return _eventOptionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.EventOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eventOptionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.EventOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eventOptionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _eventOptionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _eventOptionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public edu.uoc.eventreg.model.EventOption fetchEventOption(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventOptionLocalService.fetchEventOption(id);
	}

	/**
	* Returns the event option with the primary key.
	*
	* @param id the primary key of the event option
	* @return the event option
	* @throws PortalException if a event option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.EventOption getEventOption(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventOptionLocalService.getEventOption(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventOptionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the event options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.EventOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event options
	* @param end the upper bound of the range of event options (not inclusive)
	* @return the range of event options
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<edu.uoc.eventreg.model.EventOption> getEventOptions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventOptionLocalService.getEventOptions(start, end);
	}

	/**
	* Returns the number of event options.
	*
	* @return the number of event options
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEventOptionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventOptionLocalService.getEventOptionsCount();
	}

	/**
	* Updates the event option in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventOption the event option
	* @return the event option that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.uoc.eventreg.model.EventOption updateEventOption(
		edu.uoc.eventreg.model.EventOption eventOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventOptionLocalService.updateEventOption(eventOption);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eventOptionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eventOptionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eventOptionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EventOptionLocalService getWrappedEventOptionLocalService() {
		return _eventOptionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEventOptionLocalService(
		EventOptionLocalService eventOptionLocalService) {
		_eventOptionLocalService = eventOptionLocalService;
	}

	@Override
	public EventOptionLocalService getWrappedService() {
		return _eventOptionLocalService;
	}

	@Override
	public void setWrappedService(
		EventOptionLocalService eventOptionLocalService) {
		_eventOptionLocalService = eventOptionLocalService;
	}

	private EventOptionLocalService _eventOptionLocalService;
}