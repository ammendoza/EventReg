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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import edu.uoc.eventreg.model.Event;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Event in entity cache.
 *
 * @author Ana Mendoza
 * @see Event
 * @generated
 */
public class EventCacheModel implements CacheModel<Event>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{eventId=");
		sb.append(eventId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", address=");
		sb.append(address);
		sb.append(", location=");
		sb.append(location);
		sb.append(", price=");
		sb.append(price);
		sb.append(", coordX=");
		sb.append(coordX);
		sb.append(", coordY=");
		sb.append(coordY);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", requiresApproval=");
		sb.append(requiresApproval);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Event toEntityModel() {
		EventImpl eventImpl = new EventImpl();

		eventImpl.setEventId(eventId);
		eventImpl.setCompanyId(companyId);
		eventImpl.setGroupId(groupId);

		if (title == null) {
			eventImpl.setTitle(StringPool.BLANK);
		}
		else {
			eventImpl.setTitle(title);
		}

		if (description == null) {
			eventImpl.setDescription(StringPool.BLANK);
		}
		else {
			eventImpl.setDescription(description);
		}

		if (address == null) {
			eventImpl.setAddress(StringPool.BLANK);
		}
		else {
			eventImpl.setAddress(address);
		}

		if (location == null) {
			eventImpl.setLocation(StringPool.BLANK);
		}
		else {
			eventImpl.setLocation(location);
		}

		eventImpl.setPrice(price);

		if (coordX == null) {
			eventImpl.setCoordX(StringPool.BLANK);
		}
		else {
			eventImpl.setCoordX(coordX);
		}

		if (coordY == null) {
			eventImpl.setCoordY(StringPool.BLANK);
		}
		else {
			eventImpl.setCoordY(coordY);
		}

		if (createDate == Long.MIN_VALUE) {
			eventImpl.setCreateDate(null);
		}
		else {
			eventImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventImpl.setModifiedDate(null);
		}
		else {
			eventImpl.setModifiedDate(new Date(modifiedDate));
		}

		eventImpl.setRequiresApproval(requiresApproval);
		eventImpl.setStatus(status);
		eventImpl.setCreatedBy(createdBy);

		if (startDate == Long.MIN_VALUE) {
			eventImpl.setStartDate(null);
		}
		else {
			eventImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			eventImpl.setEndDate(null);
		}
		else {
			eventImpl.setEndDate(new Date(endDate));
		}

		eventImpl.resetOriginalValues();

		return eventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eventId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		address = objectInput.readUTF();
		location = objectInput.readUTF();
		price = objectInput.readDouble();
		coordX = objectInput.readUTF();
		coordY = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		requiresApproval = objectInput.readBoolean();
		status = objectInput.readInt();
		createdBy = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eventId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}

		objectOutput.writeDouble(price);

		if (coordX == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(coordX);
		}

		if (coordY == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(coordY);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeBoolean(requiresApproval);
		objectOutput.writeInt(status);
		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public long eventId;
	public long companyId;
	public long groupId;
	public String title;
	public String description;
	public String address;
	public String location;
	public double price;
	public String coordX;
	public String coordY;
	public long createDate;
	public long modifiedDate;
	public boolean requiresApproval;
	public int status;
	public long createdBy;
	public long startDate;
	public long endDate;
}