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

import edu.uoc.eventreg.model.Attendee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Attendee in entity cache.
 *
 * @author Ana Mendoza
 * @see Attendee
 * @generated
 */
public class AttendeeCacheModel implements CacheModel<Attendee>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{attendeeId=");
		sb.append(attendeeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", surname=");
		sb.append(surname);
		sb.append(", company=");
		sb.append(company);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", registerDate=");
		sb.append(registerDate);
		sb.append(", reservationCode=");
		sb.append(reservationCode);
		sb.append(", status=");
		sb.append(status);
		sb.append(", eventOptionId=");
		sb.append(eventOptionId);
		sb.append(", managedBy=");
		sb.append(managedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Attendee toEntityModel() {
		AttendeeImpl attendeeImpl = new AttendeeImpl();

		attendeeImpl.setAttendeeId(attendeeId);
		attendeeImpl.setCompanyId(companyId);
		attendeeImpl.setGroupId(groupId);

		if (name == null) {
			attendeeImpl.setName(StringPool.BLANK);
		}
		else {
			attendeeImpl.setName(name);
		}

		if (surname == null) {
			attendeeImpl.setSurname(StringPool.BLANK);
		}
		else {
			attendeeImpl.setSurname(surname);
		}

		if (company == null) {
			attendeeImpl.setCompany(StringPool.BLANK);
		}
		else {
			attendeeImpl.setCompany(company);
		}

		if (email == null) {
			attendeeImpl.setEmail(StringPool.BLANK);
		}
		else {
			attendeeImpl.setEmail(email);
		}

		if (phone == null) {
			attendeeImpl.setPhone(StringPool.BLANK);
		}
		else {
			attendeeImpl.setPhone(phone);
		}

		if (registerDate == Long.MIN_VALUE) {
			attendeeImpl.setRegisterDate(null);
		}
		else {
			attendeeImpl.setRegisterDate(new Date(registerDate));
		}

		if (reservationCode == null) {
			attendeeImpl.setReservationCode(StringPool.BLANK);
		}
		else {
			attendeeImpl.setReservationCode(reservationCode);
		}

		attendeeImpl.setStatus(status);
		attendeeImpl.setEventOptionId(eventOptionId);
		attendeeImpl.setManagedBy(managedBy);

		attendeeImpl.resetOriginalValues();

		return attendeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		attendeeId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		name = objectInput.readUTF();
		surname = objectInput.readUTF();
		company = objectInput.readUTF();
		email = objectInput.readUTF();
		phone = objectInput.readUTF();
		registerDate = objectInput.readLong();
		reservationCode = objectInput.readUTF();
		status = objectInput.readInt();
		eventOptionId = objectInput.readLong();
		managedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(attendeeId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (surname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(surname);
		}

		if (company == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(company);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phone);
		}

		objectOutput.writeLong(registerDate);

		if (reservationCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reservationCode);
		}

		objectOutput.writeInt(status);
		objectOutput.writeLong(eventOptionId);
		objectOutput.writeLong(managedBy);
	}

	public long attendeeId;
	public long companyId;
	public long groupId;
	public String name;
	public String surname;
	public String company;
	public String email;
	public String phone;
	public long registerDate;
	public String reservationCode;
	public int status;
	public long eventOptionId;
	public long managedBy;
}