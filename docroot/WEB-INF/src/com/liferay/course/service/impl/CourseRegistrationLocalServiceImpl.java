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

import com.liferay.course.NoSuchCourseRegistrationException;
import com.liferay.course.model.Course;
import com.liferay.course.model.CourseRegistration;
import com.liferay.course.service.base.CourseRegistrationLocalServiceBaseImpl;
import com.liferay.course.service.persistence.CourseRegistrationUtil;
import com.liferay.course.service.persistence.CourseUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the course registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.course.service.CourseRegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author ces
 * @see com.liferay.course.service.base.CourseRegistrationLocalServiceBaseImpl
 * @see com.liferay.course.service.CourseRegistrationLocalServiceUtil
 */
public class CourseRegistrationLocalServiceImpl extends CourseRegistrationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.liferay.course.service.CourseRegistrationLocalServiceUtil} to access
	 * the course registration local service.
	 */

	@Override
	public List<CourseRegistration> getAvailableCourseRegistrationsByUserId(long userId) throws SystemException {

		return CourseRegistrationUtil.findByUser_Status(userId, 1);
	}
	
	public List<CourseRegistration> getCourseRegistrationsByUserId(long userId) throws SystemException {

		return CourseRegistrationUtil.findByUserId(userId);
	}

	@Override
	public List<CourseRegistration> getCourseRegistrationByCourseId(long courseId) throws SystemException {

		return CourseRegistrationUtil.findByCourseId(courseId);
	}

	@Override
	public List<CourseRegistration> getCourseRegistrationByCourseIdAndStatus(long courseId, int status)
		throws SystemException {

		return CourseRegistrationUtil.findByCourse_Status(courseId, status);
	}

	@Override
	public CourseRegistration getCourseRegistrationByUserIdAndCourseId(long userId, long courseId)
		throws SystemException, NoSuchCourseRegistrationException {

		return CourseRegistrationUtil.findByCourse_User(courseId, userId);
	}

	@Override
	public List<CourseRegistration> getCourseRegistrationsByStatus(int status) throws SystemException {

		return CourseRegistrationUtil.findByStatus(status);
	}

	@Override
	public List<CourseRegistration> getCourseRegistrationsByUserIdAndStatus(long userId, int status)
		throws SystemException {

		return CourseRegistrationUtil.findByUser_Status(userId, status);
	}

	@Override
	public List<Course> getCoursesByStatus(int status) throws SystemException {

		return CourseUtil.findBystatus(status);
	}
}