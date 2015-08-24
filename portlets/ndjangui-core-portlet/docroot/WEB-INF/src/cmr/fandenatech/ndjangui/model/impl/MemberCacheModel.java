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

package cmr.fandenatech.ndjangui.model.impl;

import cmr.fandenatech.ndjangui.model.Member;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Member in entity cache.
 *
 * @author guyw
 * @see Member
 * @generated
 */
public class MemberCacheModel implements CacheModel<Member>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{memberId=");
		sb.append(memberId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", surname=");
		sb.append(surname);
		sb.append(", fullname=");
		sb.append(fullname);
		sb.append(", email=");
		sb.append(email);
		sb.append(", cardNumber=");
		sb.append(cardNumber);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", rate=");
		sb.append(rate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Member toEntityModel() {
		MemberImpl memberImpl = new MemberImpl();

		memberImpl.setMemberId(memberId);
		memberImpl.setUserId(userId);
		memberImpl.setGroupId(groupId);
		memberImpl.setCompanyId(companyId);

		if (userName == null) {
			memberImpl.setUserName(StringPool.BLANK);
		}
		else {
			memberImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			memberImpl.setCreateDate(null);
		}
		else {
			memberImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			memberImpl.setModifiedDate(null);
		}
		else {
			memberImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			memberImpl.setName(StringPool.BLANK);
		}
		else {
			memberImpl.setName(name);
		}

		if (surname == null) {
			memberImpl.setSurname(StringPool.BLANK);
		}
		else {
			memberImpl.setSurname(surname);
		}

		if (fullname == null) {
			memberImpl.setFullname(StringPool.BLANK);
		}
		else {
			memberImpl.setFullname(fullname);
		}

		if (email == null) {
			memberImpl.setEmail(StringPool.BLANK);
		}
		else {
			memberImpl.setEmail(email);
		}

		if (cardNumber == null) {
			memberImpl.setCardNumber(StringPool.BLANK);
		}
		else {
			memberImpl.setCardNumber(cardNumber);
		}

		if (phoneNumber == null) {
			memberImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			memberImpl.setPhoneNumber(phoneNumber);
		}

		memberImpl.setRate(rate);
		memberImpl.setStatus(status);

		memberImpl.resetOriginalValues();

		return memberImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		memberId = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		surname = objectInput.readUTF();
		fullname = objectInput.readUTF();
		email = objectInput.readUTF();
		cardNumber = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		rate = objectInput.readDouble();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(memberId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

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

		if (fullname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullname);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (cardNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cardNumber);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		objectOutput.writeDouble(rate);
		objectOutput.writeInt(status);
	}

	public long memberId;
	public long userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String surname;
	public String fullname;
	public String email;
	public String cardNumber;
	public String phoneNumber;
	public double rate;
	public int status;
}