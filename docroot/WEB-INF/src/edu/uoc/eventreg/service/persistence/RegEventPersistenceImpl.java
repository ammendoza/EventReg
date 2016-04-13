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

import edu.uoc.eventreg.NoSuchRegEventException;
import edu.uoc.eventreg.model.RegEvent;
import edu.uoc.eventreg.model.impl.RegEventImpl;
import edu.uoc.eventreg.model.impl.RegEventModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the reg event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ana Mendoza
 * @see RegEventPersistence
 * @see RegEventUtil
 * @generated
 */
public class RegEventPersistenceImpl extends BasePersistenceImpl<RegEvent>
	implements RegEventPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RegEventUtil} to access the reg event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RegEventImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RegEventModelImpl.ENTITY_CACHE_ENABLED,
			RegEventModelImpl.FINDER_CACHE_ENABLED, RegEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RegEventModelImpl.ENTITY_CACHE_ENABLED,
			RegEventModelImpl.FINDER_CACHE_ENABLED, RegEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RegEventModelImpl.ENTITY_CACHE_ENABLED,
			RegEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RegEventPersistenceImpl() {
		setModelClass(RegEvent.class);
	}

	/**
	 * Caches the reg event in the entity cache if it is enabled.
	 *
	 * @param regEvent the reg event
	 */
	@Override
	public void cacheResult(RegEvent regEvent) {
		EntityCacheUtil.putResult(RegEventModelImpl.ENTITY_CACHE_ENABLED,
			RegEventImpl.class, regEvent.getPrimaryKey(), regEvent);

		regEvent.resetOriginalValues();
	}

	/**
	 * Caches the reg events in the entity cache if it is enabled.
	 *
	 * @param regEvents the reg events
	 */
	@Override
	public void cacheResult(List<RegEvent> regEvents) {
		for (RegEvent regEvent : regEvents) {
			if (EntityCacheUtil.getResult(
						RegEventModelImpl.ENTITY_CACHE_ENABLED,
						RegEventImpl.class, regEvent.getPrimaryKey()) == null) {
				cacheResult(regEvent);
			}
			else {
				regEvent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all reg events.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RegEventImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RegEventImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the reg event.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RegEvent regEvent) {
		EntityCacheUtil.removeResult(RegEventModelImpl.ENTITY_CACHE_ENABLED,
			RegEventImpl.class, regEvent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RegEvent> regEvents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RegEvent regEvent : regEvents) {
			EntityCacheUtil.removeResult(RegEventModelImpl.ENTITY_CACHE_ENABLED,
				RegEventImpl.class, regEvent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new reg event with the primary key. Does not add the reg event to the database.
	 *
	 * @param id the primary key for the new reg event
	 * @return the new reg event
	 */
	@Override
	public RegEvent create(long id) {
		RegEvent regEvent = new RegEventImpl();

		regEvent.setNew(true);
		regEvent.setPrimaryKey(id);

		return regEvent;
	}

	/**
	 * Removes the reg event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the reg event
	 * @return the reg event that was removed
	 * @throws edu.uoc.eventreg.NoSuchRegEventException if a reg event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RegEvent remove(long id)
		throws NoSuchRegEventException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the reg event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the reg event
	 * @return the reg event that was removed
	 * @throws edu.uoc.eventreg.NoSuchRegEventException if a reg event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RegEvent remove(Serializable primaryKey)
		throws NoSuchRegEventException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RegEvent regEvent = (RegEvent)session.get(RegEventImpl.class,
					primaryKey);

			if (regEvent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRegEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(regEvent);
		}
		catch (NoSuchRegEventException nsee) {
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
	protected RegEvent removeImpl(RegEvent regEvent) throws SystemException {
		regEvent = toUnwrappedModel(regEvent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(regEvent)) {
				regEvent = (RegEvent)session.get(RegEventImpl.class,
						regEvent.getPrimaryKeyObj());
			}

			if (regEvent != null) {
				session.delete(regEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (regEvent != null) {
			clearCache(regEvent);
		}

		return regEvent;
	}

	@Override
	public RegEvent updateImpl(edu.uoc.eventreg.model.RegEvent regEvent)
		throws SystemException {
		regEvent = toUnwrappedModel(regEvent);

		boolean isNew = regEvent.isNew();

		Session session = null;

		try {
			session = openSession();

			if (regEvent.isNew()) {
				session.save(regEvent);

				regEvent.setNew(false);
			}
			else {
				session.merge(regEvent);
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

		EntityCacheUtil.putResult(RegEventModelImpl.ENTITY_CACHE_ENABLED,
			RegEventImpl.class, regEvent.getPrimaryKey(), regEvent);

		return regEvent;
	}

	protected RegEvent toUnwrappedModel(RegEvent regEvent) {
		if (regEvent instanceof RegEventImpl) {
			return regEvent;
		}

		RegEventImpl regEventImpl = new RegEventImpl();

		regEventImpl.setNew(regEvent.isNew());
		regEventImpl.setPrimaryKey(regEvent.getPrimaryKey());

		regEventImpl.setId(regEvent.getId());
		regEventImpl.setCompanyId(regEvent.getCompanyId());
		regEventImpl.setGroupId(regEvent.getGroupId());
		regEventImpl.setTitle(regEvent.getTitle());
		regEventImpl.setDescription(regEvent.getDescription());
		regEventImpl.setAddress(regEvent.getAddress());
		regEventImpl.setLocation(regEvent.getLocation());
		regEventImpl.setCoordX(regEvent.getCoordX());
		regEventImpl.setCoordY(regEvent.getCoordY());
		regEventImpl.setCreateDate(regEvent.getCreateDate());
		regEventImpl.setModifiedDate(regEvent.getModifiedDate());
		regEventImpl.setRequiresApproval(regEvent.isRequiresApproval());
		regEventImpl.setStatus(regEvent.getStatus());

		return regEventImpl;
	}

	/**
	 * Returns the reg event with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the reg event
	 * @return the reg event
	 * @throws edu.uoc.eventreg.NoSuchRegEventException if a reg event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RegEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRegEventException, SystemException {
		RegEvent regEvent = fetchByPrimaryKey(primaryKey);

		if (regEvent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRegEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return regEvent;
	}

	/**
	 * Returns the reg event with the primary key or throws a {@link edu.uoc.eventreg.NoSuchRegEventException} if it could not be found.
	 *
	 * @param id the primary key of the reg event
	 * @return the reg event
	 * @throws edu.uoc.eventreg.NoSuchRegEventException if a reg event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RegEvent findByPrimaryKey(long id)
		throws NoSuchRegEventException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the reg event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the reg event
	 * @return the reg event, or <code>null</code> if a reg event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RegEvent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RegEvent regEvent = (RegEvent)EntityCacheUtil.getResult(RegEventModelImpl.ENTITY_CACHE_ENABLED,
				RegEventImpl.class, primaryKey);

		if (regEvent == _nullRegEvent) {
			return null;
		}

		if (regEvent == null) {
			Session session = null;

			try {
				session = openSession();

				regEvent = (RegEvent)session.get(RegEventImpl.class, primaryKey);

				if (regEvent != null) {
					cacheResult(regEvent);
				}
				else {
					EntityCacheUtil.putResult(RegEventModelImpl.ENTITY_CACHE_ENABLED,
						RegEventImpl.class, primaryKey, _nullRegEvent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RegEventModelImpl.ENTITY_CACHE_ENABLED,
					RegEventImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return regEvent;
	}

	/**
	 * Returns the reg event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the reg event
	 * @return the reg event, or <code>null</code> if a reg event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RegEvent fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the reg events.
	 *
	 * @return the reg events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RegEvent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<RegEvent> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<RegEvent> findAll(int start, int end,
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

		List<RegEvent> list = (List<RegEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REGEVENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REGEVENT;

				if (pagination) {
					sql = sql.concat(RegEventModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RegEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RegEvent>(list);
				}
				else {
					list = (List<RegEvent>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the reg events from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RegEvent regEvent : findAll()) {
			remove(regEvent);
		}
	}

	/**
	 * Returns the number of reg events.
	 *
	 * @return the number of reg events
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

				Query q = session.createQuery(_SQL_COUNT_REGEVENT);

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
	 * Initializes the reg event persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.edu.uoc.eventreg.model.RegEvent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RegEvent>> listenersList = new ArrayList<ModelListener<RegEvent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RegEvent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RegEventImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_REGEVENT = "SELECT regEvent FROM RegEvent regEvent";
	private static final String _SQL_COUNT_REGEVENT = "SELECT COUNT(regEvent) FROM RegEvent regEvent";
	private static final String _ORDER_BY_ENTITY_ALIAS = "regEvent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RegEvent exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RegEventPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static RegEvent _nullRegEvent = new RegEventImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RegEvent> toCacheModel() {
				return _nullRegEventCacheModel;
			}
		};

	private static CacheModel<RegEvent> _nullRegEventCacheModel = new CacheModel<RegEvent>() {
			@Override
			public RegEvent toEntityModel() {
				return _nullRegEvent;
			}
		};
}