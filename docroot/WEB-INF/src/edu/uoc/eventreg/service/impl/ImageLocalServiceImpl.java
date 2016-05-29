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

package edu.uoc.eventreg.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import edu.uoc.eventreg.model.Image;
import edu.uoc.eventreg.service.base.ImageLocalServiceBaseImpl;
import edu.uoc.eventreg.service.persistence.ImageUtil;

/**
 * The implementation of the image local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link edu.uoc.eventreg.service.ImageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ana Mendoza
 * @see edu.uoc.eventreg.service.base.ImageLocalServiceBaseImpl
 * @see edu.uoc.eventreg.service.ImageLocalServiceUtil
 */
public class ImageLocalServiceImpl extends ImageLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link edu.uoc.eventreg.service.ImageLocalServiceUtil} to access the image local service.
	 */
	
	public List<Image> findByEvent(long eventId) {
		List<Image> images = null;
		
		try {
			images = ImageUtil.findByeventId(eventId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return images;
	}
	
}