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
import com.liferay.course.model.Course;
import com.liferay.course.service.CourseLocalServiceUtil;
import com.liferay.course.service.base.CourseServiceBaseImpl;

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

	public void addCourse(String name, String description, String lecturer, int duration, boolean status)
			throws Exception {

		Course course = CourseLocalServiceUtil.createCourse(CounterLocalServiceUtil.increment());

		course.setName(name);
		course.setDescription(description);
		course.setLecturer(lecturer);
		course.setDuration(duration);
		course.setStatus(status);

		CourseLocalServiceUtil.addCourse(course);
	}

	public void deleteCourse(long id) throws Exception {

		CourseLocalServiceUtil.deleteCourse(id);
	}

	public List<Course> getAllCourses() throws Exception {

		return CourseLocalServiceUtil.getCourses(-1, -1);
	}

	public Course getCourseById(long id) throws Exception {

		return CourseLocalServiceUtil.getCourse(id);
	}

	public int getCoursesCount() throws Exception {

		return CourseLocalServiceUtil.getCoursesCount();
	}

	public void updateCourse(long id, String name, String description, String lecturer, int duration, boolean status)
			throws Exception {

		Course course = CourseLocalServiceUtil.fetchCourse(id);

		course.setName(name);
		course.setDescription(description);
		course.setLecturer(lecturer);
		course.setDuration(duration);
		course.setStatus(status);

		CourseLocalServiceUtil.updateCourse(course);
	}
}