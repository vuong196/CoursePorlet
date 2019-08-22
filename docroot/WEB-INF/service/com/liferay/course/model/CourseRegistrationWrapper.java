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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CourseRegistration}.
 * </p>
 *
 * @author ces
 * @see CourseRegistration
 * @generated
 */
public class CourseRegistrationWrapper implements CourseRegistration,
	ModelWrapper<CourseRegistration> {
	public CourseRegistrationWrapper(CourseRegistration courseRegistration) {
		_courseRegistration = courseRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return CourseRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return CourseRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("courseId", getCourseId());
		attributes.put("userId", getUserId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this course registration.
	*
	* @return the primary key of this course registration
	*/
	@Override
	public long getPrimaryKey() {
		return _courseRegistration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course registration.
	*
	* @param primaryKey the primary key of this course registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_courseRegistration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this course registration.
	*
	* @return the uuid of this course registration
	*/
	@Override
	public java.lang.String getUuid() {
		return _courseRegistration.getUuid();
	}

	/**
	* Sets the uuid of this course registration.
	*
	* @param uuid the uuid of this course registration
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_courseRegistration.setUuid(uuid);
	}

	/**
	* Returns the ID of this course registration.
	*
	* @return the ID of this course registration
	*/
	@Override
	public long getId() {
		return _courseRegistration.getId();
	}

	/**
	* Sets the ID of this course registration.
	*
	* @param id the ID of this course registration
	*/
	@Override
	public void setId(long id) {
		_courseRegistration.setId(id);
	}

	/**
	* Returns the course ID of this course registration.
	*
	* @return the course ID of this course registration
	*/
	@Override
	public long getCourseId() {
		return _courseRegistration.getCourseId();
	}

	/**
	* Sets the course ID of this course registration.
	*
	* @param courseId the course ID of this course registration
	*/
	@Override
	public void setCourseId(long courseId) {
		_courseRegistration.setCourseId(courseId);
	}

	/**
	* Returns the user ID of this course registration.
	*
	* @return the user ID of this course registration
	*/
	@Override
	public long getUserId() {
		return _courseRegistration.getUserId();
	}

	/**
	* Sets the user ID of this course registration.
	*
	* @param userId the user ID of this course registration
	*/
	@Override
	public void setUserId(long userId) {
		_courseRegistration.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course registration.
	*
	* @return the user uuid of this course registration
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseRegistration.getUserUuid();
	}

	/**
	* Sets the user uuid of this course registration.
	*
	* @param userUuid the user uuid of this course registration
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_courseRegistration.setUserUuid(userUuid);
	}

	/**
	* Returns the status of this course registration.
	*
	* @return the status of this course registration
	*/
	@Override
	public int getStatus() {
		return _courseRegistration.getStatus();
	}

	/**
	* Sets the status of this course registration.
	*
	* @param status the status of this course registration
	*/
	@Override
	public void setStatus(int status) {
		_courseRegistration.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _courseRegistration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_courseRegistration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _courseRegistration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_courseRegistration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _courseRegistration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _courseRegistration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_courseRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _courseRegistration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_courseRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_courseRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_courseRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseRegistrationWrapper((CourseRegistration)_courseRegistration.clone());
	}

	@Override
	public int compareTo(
		com.liferay.course.model.CourseRegistration courseRegistration) {
		return _courseRegistration.compareTo(courseRegistration);
	}

	@Override
	public int hashCode() {
		return _courseRegistration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.course.model.CourseRegistration> toCacheModel() {
		return _courseRegistration.toCacheModel();
	}

	@Override
	public com.liferay.course.model.CourseRegistration toEscapedModel() {
		return new CourseRegistrationWrapper(_courseRegistration.toEscapedModel());
	}

	@Override
	public com.liferay.course.model.CourseRegistration toUnescapedModel() {
		return new CourseRegistrationWrapper(_courseRegistration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _courseRegistration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _courseRegistration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_courseRegistration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseRegistrationWrapper)) {
			return false;
		}

		CourseRegistrationWrapper courseRegistrationWrapper = (CourseRegistrationWrapper)obj;

		if (Validator.equals(_courseRegistration,
					courseRegistrationWrapper._courseRegistration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CourseRegistration getWrappedCourseRegistration() {
		return _courseRegistration;
	}

	@Override
	public CourseRegistration getWrappedModel() {
		return _courseRegistration;
	}

	@Override
	public void resetOriginalValues() {
		_courseRegistration.resetOriginalValues();
	}

	private CourseRegistration _courseRegistration;
}