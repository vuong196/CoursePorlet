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
import com.liferay.course.model.CourseRegistration;
import com.liferay.course.service.CourseRegistrationLocalServiceUtil;
import com.liferay.course.service.base.CourseRegistrationServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the course registration remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.course.service.CourseRegistrationService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author ces
 * @see com.liferay.course.service.base.CourseRegistrationServiceBaseImpl
 * @see com.liferay.course.service.CourseRegistrationServiceUtil
 */
public class CourseRegistrationServiceImpl extends CourseRegistrationServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.liferay.course.service.CourseRegistrationServiceUtil} to access the
	 * course registration remote service.
	 */

	@Override
	public CourseRegistration addCourseRegistration(long groupId, long courseId, long userId) throws Exception {

		if (getPermissionChecker().hasPermission(groupId, "com.liferay.course.model.Course", groupId, "REGISTER")) {

			CourseRegistration courseRegistration = CourseRegistrationLocalServiceUtil
				.createCourseRegistration(CounterLocalServiceUtil.increment());

			courseRegistration.setCourseId(courseId);
			courseRegistration.setUserId(userId);
			courseRegistration.setStatus(0);

			return CourseRegistrationLocalServiceUtil.addCourseRegistration(courseRegistration);
		}
		else {

			return null;
		}
	}

	@Override
	public CourseRegistration changeCourseRegistrationStatus(long groupId, long id, int status) throws Exception {

		if (getPermissionChecker().hasPermission(groupId, "com.liferay.course.model.CourseRegistration", groupId,
			"REGISTER")) {

			CourseRegistration courseRegistration = CourseRegistrationLocalServiceUtil.fetchCourseRegistration(id);

			courseRegistration.setStatus(status);

			return CourseRegistrationLocalServiceUtil.updateCourseRegistration(courseRegistration);
		}
		else {

			return null;
		}

	}

	@Override
	public CourseRegistration deleteCourseRegistration(long groupId, long id) throws Exception {

		if (getPermissionChecker().hasPermission(groupId, "com.liferay.course.model.CourseRegistration", groupId,
			"DELETE")) {

			return CourseRegistrationLocalServiceUtil.deleteCourseRegistration(id);
		}
		else {

			return null;
		}

	}

	@Override
	public List<CourseRegistration> getAvailableCourseRegistrationsByUserId(long userId) throws Exception {

		return CourseRegistrationLocalServiceUtil.getAvailableCourseRegistrationsByUserId(userId);
	}

	@Override
	public List<CourseRegistration> getCourseRegistrationByCourseIdAndStatus(long courseId, int status)
		throws Exception {

		return CourseRegistrationLocalServiceUtil.getCourseRegistrationByCourseIdAndStatus(courseId, status);
	}

	@Override
	public CourseRegistration getCourseRegistrationById(long id) throws Exception {

		return CourseRegistrationLocalServiceUtil.getCourseRegistration(id);
	}

	@Override
	public List<CourseRegistration> getCourseRegistrationByStatus(int status) throws SystemException {

		List<CourseRegistration> courseRegistrationList = null;
		try {

			courseRegistrationList = CourseRegistrationLocalServiceUtil.getCourseRegistrationsByStatus(status);
			return courseRegistrationList;
		}
		catch (Exception e) {

			return courseRegistrationList;
		}
	}

	@Override
	public CourseRegistration getCourseRegistrationByUserIdAndCourseId(long userId, long courseId) throws Exception {

		return CourseRegistrationLocalServiceUtil.getCourseRegistrationByUserIdAndCourseId(userId, courseId);
	}

	@Override
	public List<CourseRegistration> getCourseRegistrationsByUserId(long userId) throws Exception {

		return CourseRegistrationLocalServiceUtil.getCourseRegistrationsByUserId(userId);
	}

	@Override
	public boolean isFullRegistered(long courseId) throws Exception {

		List<CourseRegistration> courseRegistrationList;
		courseRegistrationList = CourseRegistrationLocalServiceUtil.getCourseRegistrationByCourseId(courseId);

		if (courseRegistrationList.size() > 19) {

			return true;
		}
		else {

			return false;
		}
	}

	@Override
	public void updateStatusOfCourseRegistration(long id, int status) throws Exception {

		CourseRegistration courseRegistration = CourseRegistrationLocalServiceUtil.fetchCourseRegistration(id);
		courseRegistration.setStatus(status);
		CourseRegistrationLocalServiceUtil.updateCourseRegistration(courseRegistration);

	}
}