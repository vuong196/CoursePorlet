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

package com.liferay.course.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the CourseRegistration service. Represents a row in the &quot;CourseRegistration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.course.model.impl.CourseRegistrationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.course.model.impl.CourseRegistrationImpl}.
 * </p>
 *
 * @author ces
 * @see CourseRegistration
 * @see com.liferay.course.model.impl.CourseRegistrationImpl
 * @see com.liferay.course.model.impl.CourseRegistrationModelImpl
 * @generated
 */
public interface CourseRegistrationModel extends BaseModel<CourseRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a course registration model instance should use the {@link CourseRegistration} interface instead.
	 */

	/**
	 * Returns the primary key of this course registration.
	 *
	 * @return the primary key of this course registration
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this course registration.
	 *
	 * @param primaryKey the primary key of this course registration
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this course registration.
	 *
	 * @return the uuid of this course registration
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this course registration.
	 *
	 * @param uuid the uuid of this course registration
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this course registration.
	 *
	 * @return the ID of this course registration
	 */
	public long getId();

	/**
	 * Sets the ID of this course registration.
	 *
	 * @param id the ID of this course registration
	 */
	public void setId(long id);

	/**
	 * Returns the course ID of this course registration.
	 *
	 * @return the course ID of this course registration
	 */
	public long getCourseId();

	/**
	 * Sets the course ID of this course registration.
	 *
	 * @param courseId the course ID of this course registration
	 */
	public void setCourseId(long courseId);

	/**
	 * Returns the user ID of this course registration.
	 *
	 * @return the user ID of this course registration
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this course registration.
	 *
	 * @param userId the user ID of this course registration
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this course registration.
	 *
	 * @return the user uuid of this course registration
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this course registration.
	 *
	 * @param userUuid the user uuid of this course registration
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the status of this course registration.
	 *
	 * @return the status of this course registration
	 */
	public int getStatus();

	/**
	 * Sets the status of this course registration.
	 *
	 * @param status the status of this course registration
	 */
	public void setStatus(int status);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(CourseRegistration courseRegistration);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CourseRegistration> toCacheModel();

	@Override
	public CourseRegistration toEscapedModel();

	@Override
	public CourseRegistration toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}