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

import com.liferay.course.model.Course;
import com.liferay.course.service.base.CourseServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;

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

		if (getPermissionChecker().hasPermission(groupId, "com.liferay.course.model.Course", groupId, "ADD_COURSE")) {

			return courseLocalService.addCourse(name, description, lecturer, duration, status);
		}
		else {

			throw new PrincipalException();
		}
	}

	@Override
	public Course deleteCourse(long groupId, long id) throws Exception {

		if (getPermissionChecker().hasPermission(groupId, "com.liferay.course.model.Course", groupId, "DELETE_COURSE")) {

			return courseLocalService.deleteCourse(id);
		}
		else {

			throw new PrincipalException();
		}
	}

	@Override
	public List<Course> getAllCourses() throws Exception {

		return courseLocalService.getCourses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	@Override
	public Course getCourseById(long id) throws Exception {

		return courseLocalService.getCourse(id);
	}

	@Override
	public List<Course> getCoursesByStatus(int status) throws SystemException {

		return courseLocalService.getCoursesByStatus(status);
	}

	@Override
	public int getCoursesCount() throws Exception {

		return courseLocalService.getCoursesCount();
	}

	@Override
	public Course updateCourse(long groupId, long id, String name, String description, String lecturer, int duration,
		int status) throws Exception {

		if (getPermissionChecker().hasPermission(groupId, "com.liferay.course.model.Course", groupId, "UPDATE_COURSE")) {

			return courseLocalService.updateCourse(id, name, description, lecturer, duration, status);
		}
		else {

			return null;
		}
	}
}