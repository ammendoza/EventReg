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

package edu.uoc.eventreg.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import edu.uoc.eventreg.model.EventOption;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EventOption in entity cache.
 *
 * @author Ana Mendoza
 * @see EventOption
 * @generated
 */
public class EventOptionCacheModel implements CacheModel<EventOption>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", price=");
		sb.append(price);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventOption toEntityModel() {
		EventOptionImpl eventOptionImpl = new EventOptionImpl();

		eventOptionImpl.setId(id);
		eventOptionImpl.setCompanyId(companyId);
		eventOptionImpl.setGroupId(groupId);

		if (startDate == Long.MIN_VALUE) {
			eventOptionImpl.setStartDate(null);
		}
		else {
			eventOptionImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			eventOptionImpl.setEndDate(null);
		}
		else {
			eventOptionImpl.setEndDate(new Date(endDate));
		}

		eventOptionImpl.setPrice(price);

		eventOptionImpl.resetOriginalValues();

		return eventOptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		price = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeDouble(price);
	}

	public long id;
	public long companyId;
	public long groupId;
	public long startDate;
	public long endDate;
	public double price;
}