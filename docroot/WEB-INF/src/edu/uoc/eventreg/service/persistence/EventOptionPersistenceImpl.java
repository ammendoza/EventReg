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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import edu.uoc.eventreg.NoSuchEventOptionException;
import edu.uoc.eventreg.model.EventOption;
import edu.uoc.eventreg.model.impl.EventOptionImpl;
import edu.uoc.eventreg.model.impl.EventOptionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the event option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ana Mendoza
 * @see EventOptionPersistence
 * @see EventOptionUtil
 * @generated
 */
public class EventOptionPersistenceImpl extends BasePersistenceImpl<EventOption>
	implements EventOptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventOptionUtil} to access the event option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventOptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventOptionModelImpl.ENTITY_CACHE_ENABLED,
			EventOptionModelImpl.FINDER_CACHE_ENABLED, EventOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventOptionModelImpl.ENTITY_CACHE_ENABLED,
			EventOptionModelImpl.FINDER_CACHE_ENABLED, EventOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventOptionModelImpl.ENTITY_CACHE_ENABLED,
			EventOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EventOptionPersistenceImpl() {
		setModelClass(EventOption.class);
	}

	/**
	 * Caches the event option in the entity cache if it is enabled.
	 *
	 * @param eventOption the event option
	 */
	@Override
	public void cacheResult(EventOption eventOption) {
		EntityCacheUtil.putResult(EventOptionModelImpl.ENTITY_CACHE_ENABLED,
			EventOptionImpl.class, eventOption.getPrimaryKey(), eventOption);

		eventOption.resetOriginalValues();
	}

	/**
	 * Caches the event options in the entity cache if it is enabled.
	 *
	 * @param eventOptions the event options
	 */
	@Override
	public void cacheResult(List<EventOption> eventOptions) {
		for (EventOption eventOption : eventOptions) {
			if (EntityCacheUtil.getResult(
						EventOptionModelImpl.ENTITY_CACHE_ENABLED,
						EventOptionImpl.class, eventOption.getPrimaryKey()) == null) {
				cacheResult(eventOption);
			}
			else {
				eventOption.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all event options.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EventOptionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EventOptionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the event option.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventOption eventOption) {
		EntityCacheUtil.removeResult(EventOptionModelImpl.ENTITY_CACHE_ENABLED,
			EventOptionImpl.class, eventOption.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EventOption> eventOptions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EventOption eventOption : eventOptions) {
			EntityCacheUtil.removeResult(EventOptionModelImpl.ENTITY_CACHE_ENABLED,
				EventOptionImpl.class, eventOption.getPrimaryKey());
		}
	}

	/**
	 * Creates a new event option with the primary key. Does not add the event option to the database.
	 *
	 * @param id the primary key for the new event option
	 * @return the new event option
	 */
	@Override
	public EventOption create(long id) {
		EventOption eventOption = new EventOptionImpl();

		eventOption.setNew(true);
		eventOption.setPrimaryKey(id);

		return eventOption;
	}

	/**
	 * Removes the event option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event option
	 * @return the event option that was removed
	 * @throws edu.uoc.eventreg.NoSuchEventOptionException if a event option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventOption remove(long id)
		throws NoSuchEventOptionException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the event option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event option
	 * @return the event option that was removed
	 * @throws edu.uoc.eventreg.NoSuchEventOptionException if a event option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventOption remove(Serializable primaryKey)
		throws NoSuchEventOptionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EventOption eventOption = (EventOption)session.get(EventOptionImpl.class,
					primaryKey);

			if (eventOption == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eventOption);
		}
		catch (NoSuchEventOptionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EventOption removeImpl(EventOption eventOption)
		throws SystemException {
		eventOption = toUnwrappedModel(eventOption);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventOption)) {
				eventOption = (EventOption)session.get(EventOptionImpl.class,
						eventOption.getPrimaryKeyObj());
			}

			if (eventOption != null) {
				session.delete(eventOption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eventOption != null) {
			clearCache(eventOption);
		}

		return eventOption;
	}

	@Override
	public EventOption updateImpl(
		edu.uoc.eventreg.model.EventOption eventOption)
		throws SystemException {
		eventOption = toUnwrappedModel(eventOption);

		boolean isNew = eventOption.isNew();

		Session session = null;

		try {
			session = openSession();

			if (eventOption.isNew()) {
				session.save(eventOption);

				eventOption.setNew(false);
			}
			else {
				session.merge(eventOption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EventOptionModelImpl.ENTITY_CACHE_ENABLED,
			EventOptionImpl.class, eventOption.getPrimaryKey(), eventOption);

		return eventOption;
	}

	protected EventOption toUnwrappedModel(EventOption eventOption) {
		if (eventOption instanceof EventOptionImpl) {
			return eventOption;
		}

		EventOptionImpl eventOptionImpl = new EventOptionImpl();

		eventOptionImpl.setNew(eventOption.isNew());
		eventOptionImpl.setPrimaryKey(eventOption.getPrimaryKey());

		eventOptionImpl.setId(eventOption.getId());
		eventOptionImpl.setCompanyId(eventOption.getCompanyId());
		eventOptionImpl.setGroupId(eventOption.getGroupId());
		eventOptionImpl.setStartDate(eventOption.getStartDate());
		eventOptionImpl.setEndDate(eventOption.getEndDate());
		eventOptionImpl.setPrice(eventOption.getPrice());

		return eventOptionImpl;
	}

	/**
	 * Returns the event option with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the event option
	 * @return the event option
	 * @throws edu.uoc.eventreg.NoSuchEventOptionException if a event option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventOption findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventOptionException, SystemException {
		EventOption eventOption = fetchByPrimaryKey(primaryKey);

		if (eventOption == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eventOption;
	}

	/**
	 * Returns the event option with the primary key or throws a {@link edu.uoc.eventreg.NoSuchEventOptionException} if it could not be found.
	 *
	 * @param id the primary key of the event option
	 * @return the event option
	 * @throws edu.uoc.eventreg.NoSuchEventOptionException if a event option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventOption findByPrimaryKey(long id)
		throws NoSuchEventOptionException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the event option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event option
	 * @return the event option, or <code>null</code> if a event option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventOption fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EventOption eventOption = (EventOption)EntityCacheUtil.getResult(EventOptionModelImpl.ENTITY_CACHE_ENABLED,
				EventOptionImpl.class, primaryKey);

		if (eventOption == _nullEventOption) {
			return null;
		}

		if (eventOption == null) {
			Session session = null;

			try {
				session = openSession();

				eventOption = (EventOption)session.get(EventOptionImpl.class,
						primaryKey);

				if (eventOption != null) {
					cacheResult(eventOption);
				}
				else {
					EntityCacheUtil.putResult(EventOptionModelImpl.ENTITY_CACHE_ENABLED,
						EventOptionImpl.class, primaryKey, _nullEventOption);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EventOptionModelImpl.ENTITY_CACHE_ENABLED,
					EventOptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eventOption;
	}

	/**
	 * Returns the event option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the event option
	 * @return the event option, or <code>null</code> if a event option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventOption fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the event options.
	 *
	 * @return the event options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventOption> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<EventOption> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the event options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.EventOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event options
	 * @param end the upper bound of the range of event options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventOption> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<EventOption> list = (List<EventOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVENTOPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTOPTION;

				if (pagination) {
					sql = sql.concat(EventOptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EventOption>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventOption>(list);
				}
				else {
					list = (List<EventOption>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the event options from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EventOption eventOption : findAll()) {
			remove(eventOption);
		}
	}

	/**
	 * Returns the number of event options.
	 *
	 * @return the number of event options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EVENTOPTION);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the event option persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.edu.uoc.eventreg.model.EventOption")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EventOption>> listenersList = new ArrayList<ModelListener<EventOption>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EventOption>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EventOptionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EVENTOPTION = "SELECT eventOption FROM EventOption eventOption";
	private static final String _SQL_COUNT_EVENTOPTION = "SELECT COUNT(eventOption) FROM EventOption eventOption";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eventOption.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventOption exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EventOptionPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static EventOption _nullEventOption = new EventOptionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EventOption> toCacheModel() {
				return _nullEventOptionCacheModel;
			}
		};

	private static CacheModel<EventOption> _nullEventOptionCacheModel = new CacheModel<EventOption>() {
			@Override
			public EventOption toEntityModel() {
				return _nullEventOption;
			}
		};
}