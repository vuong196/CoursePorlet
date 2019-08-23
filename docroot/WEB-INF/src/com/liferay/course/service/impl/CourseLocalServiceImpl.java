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

package com.liferay.course.service.impl;

import java.util.List;

import com.liferay.course.EntryDescriptionException;
import com.liferay.course.EntryDurationException;
import com.liferay.course.EntryLecturerException;
import com.liferay.course.EntryNameException;
import com.liferay.course.model.Course;
import com.liferay.course.service.base.CourseLocalServiceBaseImpl;
import com.liferay.course.service.persistence.CourseUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the course local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.course.service.CourseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author ces
 * @see com.liferay.course.service.base.CourseLocalServiceBaseImpl
 * @see com.liferay.course.service.CourseLocalServiceUtil
 */
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.liferay.course.service.CourseLocalServiceUtil} to access the course
	 * local service.
	 */

	@Override
	public Course addCourse(String name, String description, String lecturer, int duration, int status)
		throws PortalException, SystemException {

		_validator(name, description, lecturer, duration, status);

		Course course = courseLocalService.createCourse(counterLocalService.increment(Course.class.getName()));
		course.setName(name);
		course.setDescription(description);
		course.setLecturer(lecturer);
		course.setDuration(duration);
		course.setStatus(status);

		return courseLocalService.addCourse(course);
	}

	@Override
	public List<Course> getCoursesByStatus(int status) throws SystemException {

		return CourseUtil.findBystatus(status);
	}

	@Override
	public Course updateCourse(long id, String name, String description, String lecturer, int duration, int status)
		throws PortalException, SystemException {

		_validator(name, description, lecturer, duration, status);

		Course course = courseLocalService.fetchCourse(id);
		course.setName(name);
		course.setDescription(description);
		course.setLecturer(lecturer);
		course.setDuration(duration);
		course.setStatus(status);
		return CourseUtil.update(course);
	}

	private void _validator(String name, String description, String lecturer, int duration, int status)
		throws PortalException {

		if (Validator.isNull(name) || name.length() > 75) {
			throw new EntryNameException("");
		}

		if (description.length() > 2000) {
			throw new EntryDescriptionException();
		}

		if (Validator.isNull(lecturer) || lecturer.length() > 75) {
			throw new EntryLecturerException();
		}

		if (duration < 1 || duration > 40) {
			throw new EntryDurationException();
		}

		if (Validator.isNull(status)) {
			throw new EntryDurationException();
		}
	}
}