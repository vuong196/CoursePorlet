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
 * Provides a wrapper for {@link CourseRegistrationService}.
 *
 * @author ces
 * @see CourseRegistrationService
 * @generated
 */
public class CourseRegistrationServiceWrapper
	implements CourseRegistrationService,
		ServiceWrapper<CourseRegistrationService> {
	public CourseRegistrationServiceWrapper(
		CourseRegistrationService courseRegistrationService) {
		_courseRegistrationService = courseRegistrationService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _courseRegistrationService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_courseRegistrationService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _courseRegistrationService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.course.model.CourseRegistration addCourseRegistration(
		long groupId, long courseId, long userId) throws java.lang.Exception {
		return _courseRegistrationService.addCourseRegistration(groupId,
			courseId, userId);
	}

	@Override
	public com.liferay.course.model.CourseRegistration changeCourseRegistrationStatus(
		long groupId, long id, int status) throws java.lang.Exception {
		return _courseRegistrationService.changeCourseRegistrationStatus(groupId,
			id, status);
	}

	@Override
	public com.liferay.course.model.CourseRegistration deleteCourseRegistration(
		long groupId, long id) throws java.lang.Exception {
		return _courseRegistrationService.deleteCourseRegistration(groupId, id);
	}

	@Override
	public java.util.List<com.liferay.course.model.CourseRegistration> getAvailableCourseRegistrationsByUserId(
		long userId) throws java.lang.Exception {
		return _courseRegistrationService.getAvailableCourseRegistrationsByUserId(userId);
	}

	@Override
	public java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationByCourseIdAndStatus(
		long courseId, int status) throws java.lang.Exception {
		return _courseRegistrationService.getCourseRegistrationByCourseIdAndStatus(courseId,
			status);
	}

	@Override
	public com.liferay.course.model.CourseRegistration getCourseRegistrationById(
		long id) throws java.lang.Exception {
		return _courseRegistrationService.getCourseRegistrationById(id);
	}

	@Override
	public java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return _courseRegistrationService.getCourseRegistrationByStatus(status);
	}

	@Override
	public com.liferay.course.model.CourseRegistration getCourseRegistrationByUserIdAndCourseId(
		long userId, long courseId) throws java.lang.Exception {
		return _courseRegistrationService.getCourseRegistrationByUserIdAndCourseId(userId,
			courseId);
	}

	@Override
	public java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationsByUserId(
		long userId) throws java.lang.Exception {
		return _courseRegistrationService.getCourseRegistrationsByUserId(userId);
	}

	@Override
	public boolean isFullRegistered(long courseId) throws java.lang.Exception {
		return _courseRegistrationService.isFullRegistered(courseId);
	}

	@Override
	public void updateStatusOfCourseRegistration(long id, int status)
		throws java.lang.Exception {
		_courseRegistrationService.updateStatusOfCourseRegistration(id, status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CourseRegistrationService getWrappedCourseRegistrationService() {
		return _courseRegistrationService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCourseRegistrationService(
		CourseRegistrationService courseRegistrationService) {
		_courseRegistrationService = courseRegistrationService;
	}

	@Override
	public CourseRegistrationService getWrappedService() {
		return _courseRegistrationService;
	}

	@Override
	public void setWrappedService(
		CourseRegistrationService courseRegistrationService) {
		_courseRegistrationService = courseRegistrationService;
	}

	private CourseRegistrationService _courseRegistrationService;
}