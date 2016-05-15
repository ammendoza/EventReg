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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for EventOption. This utility wraps
 * {@link edu.uoc.eventreg.service.impl.EventOptionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ana Mendoza
 * @see EventOptionLocalService
 * @see edu.uoc.eventreg.service.base.EventOptionLocalServiceBaseImpl
 * @see edu.uoc.eventreg.service.impl.EventOptionLocalServiceImpl
 * @generated
 */
public class EventOptionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link edu.uoc.eventreg.service.impl.EventOptionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the event option to the database. Also notifies the appropriate model listeners.
	*
	* @param eventOption the event option
	* @return the event option that was added
	* @throws SystemException if a system exception occurred
	*/
	public static edu.uoc.eventreg.model.EventOption addEventOption(
		edu.uoc.eventreg.model.EventOption eventOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEventOption(eventOption);
	}

	/**
	* Creates a new event option with the primary key. Does not add the event option to the database.
	*
	* @param eventOptionId the primary key for the new event option
	* @return the new event option
	*/
	public static edu.uoc.eventreg.model.EventOption createEventOption(
		long eventOptionId) {
		return getService().createEventOption(eventOptionId);
	}

	/**
	* Deletes the event option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventOptionId the primary key of the event option
	* @return the event option that was removed
	* @throws PortalException if a event option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.uoc.eventreg.model.EventOption deleteEventOption(
		long eventOptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEventOption(eventOptionId);
	}

	/**
	* Deletes the event option from the database. Also notifies the appropriate model listeners.
	*
	* @param eventOption the event option
	* @return the event option that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static edu.uoc.eventreg.model.EventOption deleteEventOption(
		edu.uoc.eventreg.model.EventOption eventOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEventOption(eventOption);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static edu.uoc.eventreg.model.EventOption fetchEventOption(
		long eventOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEventOption(eventOptionId);
	}

	/**
	* Returns the event option with the primary key.
	*
	* @param eventOptionId the primary key of the event option
	* @return the event option
	* @throws PortalException if a event option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.uoc.eventreg.model.EventOption getEventOption(
		long eventOptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventOption(eventOptionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<edu.uoc.eventreg.model.EventOption> getEventOptions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventOptions(start, end);
	}

	/**
	* Returns the number of event options.
	*
	* @return the number of event options
	* @throws SystemException if a system exception occurred
	*/
	public static int getEventOptionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventOptionsCount();
	}

	/**
	* Updates the event option in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventOption the event option
	* @return the event option that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static edu.uoc.eventreg.model.EventOption updateEventOption(
		edu.uoc.eventreg.model.EventOption eventOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEventOption(eventOption);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<edu.uoc.eventreg.model.EventOption> findEventOptions(
		long eventId) {
		return getService().findEventOptions(eventId);
	}

	public static void clearService() {
		_service = null;
	}

	public static EventOptionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EventOptionLocalService.class.getName());

			if (invokableLocalService instanceof EventOptionLocalService) {
				_service = (EventOptionLocalService)invokableLocalService;
			}
			else {
				_service = new EventOptionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EventOptionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EventOptionLocalService service) {
	}

	private static EventOptionLocalService _service;
}