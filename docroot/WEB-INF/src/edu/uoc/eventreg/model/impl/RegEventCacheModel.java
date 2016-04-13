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

import edu.uoc.eventreg.model.RegEvent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RegEvent in entity cache.
 *
 * @author Ana Mendoza
 * @see RegEvent
 * @generated
 */
public class RegEventCacheModel implements CacheModel<RegEvent>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(id);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RegEvent toEntityModel() {
		RegEventImpl regEventImpl = new RegEventImpl();

		regEventImpl.setId(id);
		regEventImpl.setCompanyId(companyId);
		regEventImpl.setGroupId(groupId);

		if (title == null) {
			regEventImpl.setTitle(StringPool.BLANK);
		}
		else {
			regEventImpl.setTitle(title);
		}

		if (description == null) {
			regEventImpl.setDescription(StringPool.BLANK);
		}
		else {
			regEventImpl.setDescription(description);
		}

		if (address == null) {
			regEventImpl.setAddress(StringPool.BLANK);
		}
		else {
			regEventImpl.setAddress(address);
		}

		if (location == null) {
			regEventImpl.setLocation(StringPool.BLANK);
		}
		else {
			regEventImpl.setLocation(location);
		}

		if (coordX == null) {
			regEventImpl.setCoordX(StringPool.BLANK);
		}
		else {
			regEventImpl.setCoordX(coordX);
		}

		if (coordY == null) {
			regEventImpl.setCoordY(StringPool.BLANK);
		}
		else {
			regEventImpl.setCoordY(coordY);
		}

		if (createDate == Long.MIN_VALUE) {
			regEventImpl.setCreateDate(null);
		}
		else {
			regEventImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			regEventImpl.setModifiedDate(null);
		}
		else {
			regEventImpl.setModifiedDate(new Date(modifiedDate));
		}

		regEventImpl.setRequiresApproval(requiresApproval);
		regEventImpl.setStatus(status);

		regEventImpl.resetOriginalValues();

		return regEventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		address = objectInput.readUTF();
		location = objectInput.readUTF();
		coordX = objectInput.readUTF();
		coordY = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		requiresApproval = objectInput.readBoolean();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
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
	}

	public long id;
	public long companyId;
	public long groupId;
	public String title;
	public String description;
	public String address;
	public String location;
	public String coordX;
	public String coordY;
	public long createDate;
	public long modifiedDate;
	public boolean requiresApproval;
	public int status;
}