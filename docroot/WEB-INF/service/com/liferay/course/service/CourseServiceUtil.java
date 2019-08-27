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
 * Provides the remote service utility for Course. This utility wraps
 * {@link com.liferay.course.service.impl.CourseServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author ces
 * @see CourseService
 * @see com.liferay.course.service.base.CourseServiceBaseImpl
 * @see com.liferay.course.service.impl.CourseServiceImpl
 * @generated
 */
public class CourseServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.course.service.impl.CourseServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.course.model.Course addCourse(
		java.lang.String name, java.lang.String description,
		java.lang.String lecturer, int duration, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		return getService()
				   .addCourse(name, description, lecturer, duration, status,
			serviceContext);
	}

	public static com.liferay.course.model.Course deleteCourse(long groupId,
		long id) throws java.lang.Exception {
		return getService().deleteCourse(groupId, id);
	}

	public static java.util.List<com.liferay.course.model.Course> getAllCourses()
		throws java.lang.Exception {
		return getService().getAllCourses();
	}

	public static com.liferay.course.model.Course getCourseById(long id)
		throws java.lang.Exception {
		return getService().getCourseById(id);
	}

	public static java.util.List<com.liferay.course.model.Course> getCoursesByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCoursesByStatus(status);
	}

	public static int getCoursesCount() throws java.lang.Exception {
		return getService().getCoursesCount();
	}

	public static com.liferay.course.model.Course updateCourse(long id,
		java.lang.String name, java.lang.String description,
		java.lang.String lecturer, int duration, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		return getService()
				   .updateCourse(id, name, description, lecturer, duration,
			status, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static CourseService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CourseService.class.getName());

			if (invokableService instanceof CourseService) {
				_service = (CourseService)invokableService;
			}
			else {
				_service = new CourseServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(CourseServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CourseService service) {
	}

	private static CourseService _service;
}