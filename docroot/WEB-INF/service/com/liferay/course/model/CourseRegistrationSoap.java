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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.course.service.http.CourseRegistrationServiceSoap}.
 *
 * @author ces
 * @see com.liferay.course.service.http.CourseRegistrationServiceSoap
 * @generated
 */
public class CourseRegistrationSoap implements Serializable {
	public static CourseRegistrationSoap toSoapModel(CourseRegistration model) {
		CourseRegistrationSoap soapModel = new CourseRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setUserId(model.getUserId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static CourseRegistrationSoap[] toSoapModels(
		CourseRegistration[] models) {
		CourseRegistrationSoap[] soapModels = new CourseRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CourseRegistrationSoap[][] toSoapModels(
		CourseRegistration[][] models) {
		CourseRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CourseRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CourseRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CourseRegistrationSoap[] toSoapModels(
		List<CourseRegistration> models) {
		List<CourseRegistrationSoap> soapModels = new ArrayList<CourseRegistrationSoap>(models.size());

		for (CourseRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CourseRegistrationSoap[soapModels.size()]);
	}

	public CourseRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private String _uuid;
	private long _id;
	private long _courseId;
	private long _userId;
	private int _status;
}