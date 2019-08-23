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

import com.liferay.course.service.CourseRegistrationServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.course.service.CourseRegistrationServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.course.model.CourseRegistrationSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.course.model.CourseRegistration}, that is translated to a
 * {@link com.liferay.course.model.CourseRegistrationSoap}. Methods that SOAP cannot
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
 * @see CourseRegistrationServiceHttp
 * @see com.liferay.course.model.CourseRegistrationSoap
 * @see com.liferay.course.service.CourseRegistrationServiceUtil
 * @generated
 */
public class CourseRegistrationServiceSoap {
	public static com.liferay.course.model.CourseRegistrationSoap addCourseRegistration(
		long groupId, long courseId, long userId) throws RemoteException {
		try {
			com.liferay.course.model.CourseRegistration returnValue = CourseRegistrationServiceUtil.addCourseRegistration(groupId,
					courseId, userId);

			return com.liferay.course.model.CourseRegistrationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.course.model.CourseRegistrationSoap changeCourseRegistrationStatus(
		long groupId, long id, int status) throws RemoteException {
		try {
			com.liferay.course.model.CourseRegistration returnValue = CourseRegistrationServiceUtil.changeCourseRegistrationStatus(groupId,
					id, status);

			return com.liferay.course.model.CourseRegistrationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.course.model.CourseRegistrationSoap deleteCourseRegistration(
		long groupId, long id) throws RemoteException {
		try {
			com.liferay.course.model.CourseRegistration returnValue = CourseRegistrationServiceUtil.deleteCourseRegistration(groupId,
					id);

			return com.liferay.course.model.CourseRegistrationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.course.model.CourseRegistrationSoap[] getAvailableCourseRegistrationsByUserId(
		long userId) throws RemoteException {
		try {
			java.util.List<com.liferay.course.model.CourseRegistration> returnValue =
				CourseRegistrationServiceUtil.getAvailableCourseRegistrationsByUserId(userId);

			return com.liferay.course.model.CourseRegistrationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.course.model.CourseRegistrationSoap[] getCourseRegistrationByCourseIdAndStatus(
		long courseId, int status) throws RemoteException {
		try {
			java.util.List<com.liferay.course.model.CourseRegistration> returnValue =
				CourseRegistrationServiceUtil.getCourseRegistrationByCourseIdAndStatus(courseId,
					status);

			return com.liferay.course.model.CourseRegistrationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.course.model.CourseRegistrationSoap getCourseRegistrationById(
		long id) throws RemoteException {
		try {
			com.liferay.course.model.CourseRegistration returnValue = CourseRegistrationServiceUtil.getCourseRegistrationById(id);

			return com.liferay.course.model.CourseRegistrationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.course.model.CourseRegistrationSoap[] getCourseRegistrationByStatus(
		int status) throws RemoteException {
		try {
			java.util.List<com.liferay.course.model.CourseRegistration> returnValue =
				CourseRegistrationServiceUtil.getCourseRegistrationByStatus(status);

			return com.liferay.course.model.CourseRegistrationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.course.model.CourseRegistrationSoap getCourseRegistrationByUserIdAndCourseId(
		long userId, long courseId) throws RemoteException {
		try {
			com.liferay.course.model.CourseRegistration returnValue = CourseRegistrationServiceUtil.getCourseRegistrationByUserIdAndCourseId(userId,
					courseId);

			return com.liferay.course.model.CourseRegistrationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.course.model.CourseRegistrationSoap[] getCourseRegistrationsByUserId(
		long userId) throws RemoteException {
		try {
			java.util.List<com.liferay.course.model.CourseRegistration> returnValue =
				CourseRegistrationServiceUtil.getCourseRegistrationsByUserId(userId);

			return com.liferay.course.model.CourseRegistrationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean isFullRegistered(long courseId)
		throws RemoteException {
		try {
			boolean returnValue = CourseRegistrationServiceUtil.isFullRegistered(courseId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.course.model.CourseRegistrationSoap updateStatusOfCourseRegistration(
		long id, int status) throws RemoteException {
		try {
			com.liferay.course.model.CourseRegistration returnValue = CourseRegistrationServiceUtil.updateStatusOfCourseRegistration(id,
					status);

			return com.liferay.course.model.CourseRegistrationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CourseRegistrationServiceSoap.class);
}