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

package com.liferay.course.service.http;

import com.liferay.course.service.CourseServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.course.service.CourseServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.course.model.CourseSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.course.model.Course}, that is translated to a
 * {@link com.liferay.course.model.CourseSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author ces
 * @see CourseServiceHttp
 * @see com.liferay.course.model.CourseSoap
 * @see com.liferay.course.service.CourseServiceUtil
 * @generated
 */
public class CourseServiceSoap {
	public static void addCourse(java.lang.String name,
		java.lang.String description, java.lang.String lecturer, int duration,
		boolean status) throws RemoteException {
		try {
			CourseServiceUtil.addCourse(name, description, lecturer, duration,
				status);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteCourse(long id) throws RemoteException {
		try {
			CourseServiceUtil.deleteCourse(id);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.course.model.CourseSoap[] getAllCourses()
		throws RemoteException {
		try {
			java.util.List<com.liferay.course.model.Course> returnValue = CourseServiceUtil.getAllCourses();

			return com.liferay.course.model.CourseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.course.model.CourseSoap getCourseById(long id)
		throws RemoteException {
		try {
			com.liferay.course.model.Course returnValue = CourseServiceUtil.getCourseById(id);

			return com.liferay.course.model.CourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getCoursesCount() throws RemoteException {
		try {
			int returnValue = CourseServiceUtil.getCoursesCount();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void updateCourse(long id, java.lang.String name,
		java.lang.String description, java.lang.String lecturer, int duration,
		boolean status) throws RemoteException {
		try {
			CourseServiceUtil.updateCourse(id, name, description, lecturer,
				duration, status);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CourseServiceSoap.class);
}