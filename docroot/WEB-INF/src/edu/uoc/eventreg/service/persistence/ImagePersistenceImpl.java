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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import edu.uoc.eventreg.NoSuchImageException;
import edu.uoc.eventreg.model.Image;
import edu.uoc.eventreg.model.impl.ImageImpl;
import edu.uoc.eventreg.model.impl.ImageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ana Mendoza
 * @see ImagePersistence
 * @see ImageUtil
 * @generated
 */
public class ImagePersistenceImpl extends BasePersistenceImpl<Image>
	implements ImagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ImageUtil} to access the image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ImageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ImagePersistenceImpl() {
		setModelClass(Image.class);
	}

	/**
	 * Caches the image in the entity cache if it is enabled.
	 *
	 * @param image the image
	 */
	@Override
	public void cacheResult(Image image) {
		EntityCacheUtil.putResult(ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageImpl.class, image.getPrimaryKey(), image);

		image.resetOriginalValues();
	}

	/**
	 * Caches the images in the entity cache if it is enabled.
	 *
	 * @param images the images
	 */
	@Override
	public void cacheResult(List<Image> images) {
		for (Image image : images) {
			if (EntityCacheUtil.getResult(ImageModelImpl.ENTITY_CACHE_ENABLED,
						ImageImpl.class, image.getPrimaryKey()) == null) {
				cacheResult(image);
			}
			else {
				image.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ImageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ImageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the image.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Image image) {
		EntityCacheUtil.removeResult(ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageImpl.class, image.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Image> images) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Image image : images) {
			EntityCacheUtil.removeResult(ImageModelImpl.ENTITY_CACHE_ENABLED,
				ImageImpl.class, image.getPrimaryKey());
		}
	}

	/**
	 * Creates a new image with the primary key. Does not add the image to the database.
	 *
	 * @param imageId the primary key for the new image
	 * @return the new image
	 */
	@Override
	public Image create(long imageId) {
		Image image = new ImageImpl();

		image.setNew(true);
		image.setPrimaryKey(imageId);

		return image;
	}

	/**
	 * Removes the image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param imageId the primary key of the image
	 * @return the image that was removed
	 * @throws edu.uoc.eventreg.NoSuchImageException if a image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Image remove(long imageId)
		throws NoSuchImageException, SystemException {
		return remove((Serializable)imageId);
	}

	/**
	 * Removes the image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the image
	 * @return the image that was removed
	 * @throws edu.uoc.eventreg.NoSuchImageException if a image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Image remove(Serializable primaryKey)
		throws NoSuchImageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Image image = (Image)session.get(ImageImpl.class, primaryKey);

			if (image == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(image);
		}
		catch (NoSuchImageException nsee) {
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
	protected Image removeImpl(Image image) throws SystemException {
		image = toUnwrappedModel(image);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(image)) {
				image = (Image)session.get(ImageImpl.class,
						image.getPrimaryKeyObj());
			}

			if (image != null) {
				session.delete(image);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (image != null) {
			clearCache(image);
		}

		return image;
	}

	@Override
	public Image updateImpl(edu.uoc.eventreg.model.Image image)
		throws SystemException {
		image = toUnwrappedModel(image);

		boolean isNew = image.isNew();

		Session session = null;

		try {
			session = openSession();

			if (image.isNew()) {
				session.save(image);

				image.setNew(false);
			}
			else {
				session.merge(image);
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

		EntityCacheUtil.putResult(ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageImpl.class, image.getPrimaryKey(), image);

		return image;
	}

	protected Image toUnwrappedModel(Image image) {
		if (image instanceof ImageImpl) {
			return image;
		}

		ImageImpl imageImpl = new ImageImpl();

		imageImpl.setNew(image.isNew());
		imageImpl.setPrimaryKey(image.getPrimaryKey());

		imageImpl.setImageId(image.getImageId());
		imageImpl.setCompanyId(image.getCompanyId());
		imageImpl.setGroupId(image.getGroupId());

		return imageImpl;
	}

	/**
	 * Returns the image with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the image
	 * @return the image
	 * @throws edu.uoc.eventreg.NoSuchImageException if a image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Image findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImageException, SystemException {
		Image image = fetchByPrimaryKey(primaryKey);

		if (image == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return image;
	}

	/**
	 * Returns the image with the primary key or throws a {@link edu.uoc.eventreg.NoSuchImageException} if it could not be found.
	 *
	 * @param imageId the primary key of the image
	 * @return the image
	 * @throws edu.uoc.eventreg.NoSuchImageException if a image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Image findByPrimaryKey(long imageId)
		throws NoSuchImageException, SystemException {
		return findByPrimaryKey((Serializable)imageId);
	}

	/**
	 * Returns the image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the image
	 * @return the image, or <code>null</code> if a image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Image fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Image image = (Image)EntityCacheUtil.getResult(ImageModelImpl.ENTITY_CACHE_ENABLED,
				ImageImpl.class, primaryKey);

		if (image == _nullImage) {
			return null;
		}

		if (image == null) {
			Session session = null;

			try {
				session = openSession();

				image = (Image)session.get(ImageImpl.class, primaryKey);

				if (image != null) {
					cacheResult(image);
				}
				else {
					EntityCacheUtil.putResult(ImageModelImpl.ENTITY_CACHE_ENABLED,
						ImageImpl.class, primaryKey, _nullImage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ImageModelImpl.ENTITY_CACHE_ENABLED,
					ImageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return image;
	}

	/**
	 * Returns the image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param imageId the primary key of the image
	 * @return the image, or <code>null</code> if a image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Image fetchByPrimaryKey(long imageId) throws SystemException {
		return fetchByPrimaryKey((Serializable)imageId);
	}

	/**
	 * Returns all the images.
	 *
	 * @return the images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Image> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.ImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @return the range of images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Image> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.ImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Image> findAll(int start, int end,
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

		List<Image> list = (List<Image>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_IMAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMAGE;

				if (pagination) {
					sql = sql.concat(ImageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Image>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Image>(list);
				}
				else {
					list = (List<Image>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the images from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Image image : findAll()) {
			remove(image);
		}
	}

	/**
	 * Returns the number of images.
	 *
	 * @return the number of images
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

				Query q = session.createQuery(_SQL_COUNT_IMAGE);

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

	/**
	 * Initializes the image persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.edu.uoc.eventreg.model.Image")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Image>> listenersList = new ArrayList<ModelListener<Image>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Image>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ImageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_IMAGE = "SELECT image FROM Image image";
	private static final String _SQL_COUNT_IMAGE = "SELECT COUNT(image) FROM Image image";
	private static final String _ORDER_BY_ENTITY_ALIAS = "image.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Image exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ImagePersistenceImpl.class);
	private static Image _nullImage = new ImageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Image> toCacheModel() {
				return _nullImageCacheModel;
			}
		};

	private static CacheModel<Image> _nullImageCacheModel = new CacheModel<Image>() {
			@Override
			public Image toEntityModel() {
				return _nullImage;
			}
		};
}