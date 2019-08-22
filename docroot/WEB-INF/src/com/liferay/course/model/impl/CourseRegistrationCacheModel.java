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

package com.liferay.course.model.impl;

import com.liferay.course.model.CourseRegistration;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CourseRegistration in entity cache.
 *
 * @author ces
 * @see CourseRegistration
 * @generated
 */
public class CourseRegistrationCacheModel implements CacheModel<CourseRegistration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CourseRegistration toEntityModel() {
		CourseRegistrationImpl courseRegistrationImpl = new CourseRegistrationImpl();

		if (uuid == null) {
			courseRegistrationImpl.setUuid(StringPool.BLANK);
		}
		else {
			courseRegistrationImpl.setUuid(uuid);
		}

		courseRegistrationImpl.setId(id);
		courseRegistrationImpl.setCourseId(courseId);
		courseRegistrationImpl.setUserId(userId);
		courseRegistrationImpl.setStatus(status);

		courseRegistrationImpl.resetOriginalValues();

		return courseRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		id = objectInput.readLong();
		courseId = objectInput.readLong();
		userId = objectInput.readLong();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);
		objectOutput.writeLong(courseId);
		objectOutput.writeLong(userId);
		objectOutput.writeInt(status);
	}

	public String uuid;
	public long id;
	public long courseId;
	public long userId;
	public int status;
}