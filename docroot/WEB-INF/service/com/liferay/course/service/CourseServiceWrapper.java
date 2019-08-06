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

package com.liferay.course.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CourseService}.
 *
 * @author ces
 * @see CourseService
 * @generated
 */
public class CourseServiceWrapper implements CourseService,
	ServiceWrapper<CourseService> {
	public CourseServiceWrapper(CourseService courseService) {
		_courseService = courseService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _courseService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_courseService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _courseService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void addCourse(java.lang.String name, java.lang.String description,
		java.lang.String lecturer, int duration, boolean status)
		throws java.lang.Exception {
		_courseService.addCourse(name, description, lecturer, duration, status);
	}

	@Override
	public void deleteCourse(long id) throws java.lang.Exception {
		_courseService.deleteCourse(id);
	}

	@Override
	public java.util.List<com.liferay.course.model.Course> getAllCourses()
		throws java.lang.Exception {
		return _courseService.getAllCourses();
	}

	@Override
	public com.liferay.course.model.Course getCourseById(long id)
		throws java.lang.Exception {
		return _courseService.getCourseById(id);
	}

	@Override
	public int getCoursesCount() throws java.lang.Exception {
		return _courseService.getCoursesCount();
	}

	@Override
	public void updateCourse(long id, java.lang.String name,
		java.lang.String description, java.lang.String lecturer, int duration,
		boolean status) throws java.lang.Exception {
		_courseService.updateCourse(id, name, description, lecturer, duration,
			status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CourseService getWrappedCourseService() {
		return _courseService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCourseService(CourseService courseService) {
		_courseService = courseService;
	}

	@Override
	public CourseService getWrappedService() {
		return _courseService;
	}

	@Override
	public void setWrappedService(CourseService courseService) {
		_courseService = courseService;
	}

	private CourseService _courseService;
}