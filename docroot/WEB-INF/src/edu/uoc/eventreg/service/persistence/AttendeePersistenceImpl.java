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

import edu.uoc.eventreg.NoSuchAttendeeException;
import edu.uoc.eventreg.model.Attendee;
import edu.uoc.eventreg.model.impl.AttendeeImpl;
import edu.uoc.eventreg.model.impl.AttendeeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the attendee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ana Mendoza
 * @see AttendeePersistence
 * @see AttendeeUtil
 * @generated
 */
public class AttendeePersistenceImpl extends BasePersistenceImpl<Attendee>
	implements AttendeePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AttendeeUtil} to access the attendee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AttendeeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AttendeeModelImpl.ENTITY_CACHE_ENABLED,
			AttendeeModelImpl.FINDER_CACHE_ENABLED, AttendeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AttendeeModelImpl.ENTITY_CACHE_ENABLED,
			AttendeeModelImpl.FINDER_CACHE_ENABLED, AttendeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AttendeeModelImpl.ENTITY_CACHE_ENABLED,
			AttendeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AttendeePersistenceImpl() {
		setModelClass(Attendee.class);
	}

	/**
	 * Caches the attendee in the entity cache if it is enabled.
	 *
	 * @param attendee the attendee
	 */
	@Override
	public void cacheResult(Attendee attendee) {
		EntityCacheUtil.putResult(AttendeeModelImpl.ENTITY_CACHE_ENABLED,
			AttendeeImpl.class, attendee.getPrimaryKey(), attendee);

		attendee.resetOriginalValues();
	}

	/**
	 * Caches the attendees in the entity cache if it is enabled.
	 *
	 * @param attendees the attendees
	 */
	@Override
	public void cacheResult(List<Attendee> attendees) {
		for (Attendee attendee : attendees) {
			if (EntityCacheUtil.getResult(
						AttendeeModelImpl.ENTITY_CACHE_ENABLED,
						AttendeeImpl.class, attendee.getPrimaryKey()) == null) {
				cacheResult(attendee);
			}
			else {
				attendee.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all attendees.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AttendeeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AttendeeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the attendee.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Attendee attendee) {
		EntityCacheUtil.removeResult(AttendeeModelImpl.ENTITY_CACHE_ENABLED,
			AttendeeImpl.class, attendee.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Attendee> attendees) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Attendee attendee : attendees) {
			EntityCacheUtil.removeResult(AttendeeModelImpl.ENTITY_CACHE_ENABLED,
				AttendeeImpl.class, attendee.getPrimaryKey());
		}
	}

	/**
	 * Creates a new attendee with the primary key. Does not add the attendee to the database.
	 *
	 * @param id the primary key for the new attendee
	 * @return the new attendee
	 */
	@Override
	public Attendee create(long id) {
		Attendee attendee = new AttendeeImpl();

		attendee.setNew(true);
		attendee.setPrimaryKey(id);

		return attendee;
	}

	/**
	 * Removes the attendee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the attendee
	 * @return the attendee that was removed
	 * @throws edu.uoc.eventreg.NoSuchAttendeeException if a attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Attendee remove(long id)
		throws NoSuchAttendeeException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the attendee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the attendee
	 * @return the attendee that was removed
	 * @throws edu.uoc.eventreg.NoSuchAttendeeException if a attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Attendee remove(Serializable primaryKey)
		throws NoSuchAttendeeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Attendee attendee = (Attendee)session.get(AttendeeImpl.class,
					primaryKey);

			if (attendee == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAttendeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(attendee);
		}
		catch (NoSuchAttendeeException nsee) {
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
	protected Attendee removeImpl(Attendee attendee) throws SystemException {
		attendee = toUnwrappedModel(attendee);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(attendee)) {
				attendee = (Attendee)session.get(AttendeeImpl.class,
						attendee.getPrimaryKeyObj());
			}

			if (attendee != null) {
				session.delete(attendee);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (attendee != null) {
			clearCache(attendee);
		}

		return attendee;
	}

	@Override
	public Attendee updateImpl(edu.uoc.eventreg.model.Attendee attendee)
		throws SystemException {
		attendee = toUnwrappedModel(attendee);

		boolean isNew = attendee.isNew();

		Session session = null;

		try {
			session = openSession();

			if (attendee.isNew()) {
				session.save(attendee);

				attendee.setNew(false);
			}
			else {
				session.merge(attendee);
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

		EntityCacheUtil.putResult(AttendeeModelImpl.ENTITY_CACHE_ENABLED,
			AttendeeImpl.class, attendee.getPrimaryKey(), attendee);

		return attendee;
	}

	protected Attendee toUnwrappedModel(Attendee attendee) {
		if (attendee instanceof AttendeeImpl) {
			return attendee;
		}

		AttendeeImpl attendeeImpl = new AttendeeImpl();

		attendeeImpl.setNew(attendee.isNew());
		attendeeImpl.setPrimaryKey(attendee.getPrimaryKey());

		attendeeImpl.setId(attendee.getId());
		attendeeImpl.setCompanyId(attendee.getCompanyId());
		attendeeImpl.setGroupId(attendee.getGroupId());
		attendeeImpl.setName(attendee.getName());
		attendeeImpl.setSurname(attendee.getSurname());
		attendeeImpl.setCompany(attendee.getCompany());
		attendeeImpl.setEmail(attendee.getEmail());
		attendeeImpl.setPhone(attendee.getPhone());
		attendeeImpl.setRegisterDate(attendee.getRegisterDate());
		attendeeImpl.setReservationCode(attendee.getReservationCode());
		attendeeImpl.setStatus(attendee.getStatus());
		attendeeImpl.setManagedBy(attendee.getManagedBy());

		return attendeeImpl;
	}

	/**
	 * Returns the attendee with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the attendee
	 * @return the attendee
	 * @throws edu.uoc.eventreg.NoSuchAttendeeException if a attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Attendee findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAttendeeException, SystemException {
		Attendee attendee = fetchByPrimaryKey(primaryKey);

		if (attendee == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAttendeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return attendee;
	}

	/**
	 * Returns the attendee with the primary key or throws a {@link edu.uoc.eventreg.NoSuchAttendeeException} if it could not be found.
	 *
	 * @param id the primary key of the attendee
	 * @return the attendee
	 * @throws edu.uoc.eventreg.NoSuchAttendeeException if a attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Attendee findByPrimaryKey(long id)
		throws NoSuchAttendeeException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the attendee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attendee
	 * @return the attendee, or <code>null</code> if a attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Attendee fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Attendee attendee = (Attendee)EntityCacheUtil.getResult(AttendeeModelImpl.ENTITY_CACHE_ENABLED,
				AttendeeImpl.class, primaryKey);

		if (attendee == _nullAttendee) {
			return null;
		}

		if (attendee == null) {
			Session session = null;

			try {
				session = openSession();

				attendee = (Attendee)session.get(AttendeeImpl.class, primaryKey);

				if (attendee != null) {
					cacheResult(attendee);
				}
				else {
					EntityCacheUtil.putResult(AttendeeModelImpl.ENTITY_CACHE_ENABLED,
						AttendeeImpl.class, primaryKey, _nullAttendee);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AttendeeModelImpl.ENTITY_CACHE_ENABLED,
					AttendeeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return attendee;
	}

	/**
	 * Returns the attendee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the attendee
	 * @return the attendee, or <code>null</code> if a attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Attendee fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the attendees.
	 *
	 * @return the attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Attendee> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Attendee> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Attendee> findAll(int start, int end,
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

		List<Attendee> list = (List<Attendee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ATTENDEE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ATTENDEE;

				if (pagination) {
					sql = sql.concat(AttendeeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Attendee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Attendee>(list);
				}
				else {
					list = (List<Attendee>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the attendees from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Attendee attendee : findAll()) {
			remove(attendee);
		}
	}

	/**
	 * Returns the number of attendees.
	 *
	 * @return the number of attendees
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

				Query q = session.createQuery(_SQL_COUNT_ATTENDEE);

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
	 * Initializes the attendee persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.edu.uoc.eventreg.model.Attendee")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Attendee>> listenersList = new ArrayList<ModelListener<Attendee>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Attendee>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AttendeeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ATTENDEE = "SELECT attendee FROM Attendee attendee";
	private static final String _SQL_COUNT_ATTENDEE = "SELECT COUNT(attendee) FROM Attendee attendee";
	private static final String _ORDER_BY_ENTITY_ALIAS = "attendee.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Attendee exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AttendeePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static Attendee _nullAttendee = new AttendeeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Attendee> toCacheModel() {
				return _nullAttendeeCacheModel;
			}
		};

	private static CacheModel<Attendee> _nullAttendeeCacheModel = new CacheModel<Attendee>() {
			@Override
			public Attendee toEntityModel() {
				return _nullAttendee;
			}
		};
}