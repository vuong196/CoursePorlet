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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for CourseRegistration. This utility wraps
 * {@link com.liferay.course.service.impl.CourseRegistrationServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author ces
 * @see CourseRegistrationService
 * @see com.liferay.course.service.base.CourseRegistrationServiceBaseImpl
 * @see com.liferay.course.service.impl.CourseRegistrationServiceImpl
 * @generated
 */
public class CourseRegistrationServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.course.service.impl.CourseRegistrationServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.course.model.CourseRegistration addCourseRegistration(
		long groupId, long courseId, long userId) throws java.lang.Exception {
		return getService().addCourseRegistration(groupId, courseId, userId);
	}

	public static com.liferay.course.model.CourseRegistration changeCourseRegistrationStatus(
		long groupId, long id, int status) throws java.lang.Exception {
		return getService().changeCourseRegistrationStatus(groupId, id, status);
	}

	public static com.liferay.course.model.CourseRegistration deleteCourseRegistration(
		long groupId, long id) throws java.lang.Exception {
		return getService().deleteCourseRegistration(groupId, id);
	}

	public static java.util.List<com.liferay.course.model.CourseRegistration> getAvailableCourseRegistrationsByUserId(
		long userId) throws java.lang.Exception {
		return getService().getAvailableCourseRegistrationsByUserId(userId);
	}

	public static java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationByCourseIdAndStatus(
		long courseId, int status) throws java.lang.Exception {
		return getService()
				   .getCourseRegistrationByCourseIdAndStatus(courseId, status);
	}

	public static com.liferay.course.model.CourseRegistration getCourseRegistrationById(
		long id) throws java.lang.Exception {
		return getService().getCourseRegistrationById(id);
	}

	public static java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCourseRegistrationByStatus(status);
	}

	public static com.liferay.course.model.CourseRegistration getCourseRegistrationByUserIdAndCourseId(
		long userId, long courseId) throws java.lang.Exception {
		return getService()
				   .getCourseRegistrationByUserIdAndCourseId(userId, courseId);
	}

	public static java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationsByUserId(
		long userId) throws java.lang.Exception {
		return getService().getCourseRegistrationsByUserId(userId);
	}

	public static boolean isFullRegistered(long courseId)
		throws java.lang.Exception {
		return getService().isFullRegistered(courseId);
	}

	public static void updateStatusOfCourseRegistration(long id, int status)
		throws java.lang.Exception {
		getService().updateStatusOfCourseRegistration(id, status);
	}

	public static void clearService() {
		_service = null;
	}

	public static CourseRegistrationService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CourseRegistrationService.class.getName());

			if (invokableService instanceof CourseRegistrationService) {
				_service = (CourseRegistrationService)invokableService;
			}
			else {
				_service = new CourseRegistrationServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(CourseRegistrationServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CourseRegistrationService service) {
	}

	private static CourseRegistrationService _service;
}