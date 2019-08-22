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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.course.EntryDescriptionException;
import com.liferay.course.EntryDurationException;
import com.liferay.course.EntryLecturerException;
import com.liferay.course.EntryNameException;
import com.liferay.course.model.Course;
import com.liferay.course.service.CourseLocalServiceUtil;
import com.liferay.course.service.base.CourseServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the course remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.course.service.CourseService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author ces
 * @see com.liferay.course.service.base.CourseServiceBaseImpl
 * @see com.liferay.course.service.CourseServiceUtil
 */
public class CourseServiceImpl extends CourseServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.liferay.course.service.CourseServiceUtil} to access the course remote
	 * service.
	 */

	@Override
	public Course addCourse(long groupId, String name, String description, String lecturer, int duration, int status)
		throws Exception {

		validator(name, description, lecturer, duration, status);
		if (getPermissionChecker().hasPermission(groupId, "com.liferay.course.model.Course", groupId, "ADD_COURSE")) {

			Course course = CourseLocalServiceUtil.createCourse(CounterLocalServiceUtil.increment());
			course.setName(name);
			course.setDescription(description);
			course.setLecturer(lecturer);
			course.setDuration(duration);
			course.setStatus(status);
			return CourseLocalServiceUtil.addCourse(course);
		}
		else {

			return null;
		}

	}

	@Override
	public Course deleteCourse(long groupId, long id) throws Exception {

		if (getPermissionChecker().hasPermission(groupId, "com.liferay.course.model.Course", groupId, "DELETE_COURSE")) {

			return CourseLocalServiceUtil.deleteCourse(id);
		}
		else {

			return null;
		}

	}

	@Override
	public List<Course> getAllCourses() throws Exception {

		return CourseLocalServiceUtil.getCourses(-1, -1);
	}

	@Override
	public Course getCourseById(long id) throws Exception {

		return CourseLocalServiceUtil.getCourse(id);
	}

	@Override
	public List<Course> getCoursesByStatus(int status) throws SystemException {

		return CourseLocalServiceUtil.getCoursesByStatus(status);
	}

	@Override
	public int getCoursesCount() throws Exception {

		return CourseLocalServiceUtil.getCoursesCount();
	}

	@Override
	public Course updateCourse(long groupId, long id, String name, String description, String lecturer, int duration,
		int status) throws Exception {

		validator(name, description, lecturer, duration, status);

		if (getPermissionChecker().hasPermission(groupId, "com.liferay.course.model.Course", groupId, "UPDATE_COURSE")) {

			Course course = CourseLocalServiceUtil.fetchCourse(id);
			course.setName(name);
			course.setDescription(description);
			course.setLecturer(lecturer);
			course.setDuration(duration);
			course.setStatus(status);
			return CourseLocalServiceUtil.updateCourse(course);
		}
		else {

			return null;
		}
	}

	protected void validator(String name, String description, String lecturer, int duration, int status)
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