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

package com.liferay.course.service.base;

import com.liferay.course.service.CourseRegistrationServiceUtil;

import java.util.Arrays;

/**
 * @author ces
 * @generated
 */
public class CourseRegistrationServiceClpInvoker {
	public CourseRegistrationServiceClpInvoker() {
		_methodName24 = "getBeanIdentifier";

		_methodParameterTypes24 = new String[] {  };

		_methodName25 = "setBeanIdentifier";

		_methodParameterTypes25 = new String[] { "java.lang.String" };

		_methodName30 = "addCourseRegistration";

		_methodParameterTypes30 = new String[] { "long", "long", "long" };

		_methodName31 = "changeCourseRegistrationStatus";

		_methodParameterTypes31 = new String[] { "long", "long", "int" };

		_methodName32 = "deleteCourseRegistration";

		_methodParameterTypes32 = new String[] { "long", "long" };

		_methodName33 = "getAvailableCourseRegistrationsByUserId";

		_methodParameterTypes33 = new String[] { "long" };

		_methodName34 = "getCourseRegistrationByCourseIdAndStatus";

		_methodParameterTypes34 = new String[] { "long", "int" };

		_methodName35 = "getCourseRegistrationById";

		_methodParameterTypes35 = new String[] { "long" };

		_methodName36 = "getCourseRegistrationByStatus";

		_methodParameterTypes36 = new String[] { "int" };

		_methodName37 = "getCourseRegistrationByUserIdAndCourseId";

		_methodParameterTypes37 = new String[] { "long", "long" };

		_methodName38 = "getCourseRegistrationsByUserId";

		_methodParameterTypes38 = new String[] { "long" };

		_methodName39 = "isFullRegistered";

		_methodParameterTypes39 = new String[] { "long" };

		_methodName40 = "updateStatusOfCourseRegistration";

		_methodParameterTypes40 = new String[] { "long", "int" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return CourseRegistrationServiceUtil.getBeanIdentifier();
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			CourseRegistrationServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return CourseRegistrationServiceUtil.addCourseRegistration(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			return CourseRegistrationServiceUtil.changeCourseRegistrationStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return CourseRegistrationServiceUtil.deleteCourseRegistration(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return CourseRegistrationServiceUtil.getAvailableCourseRegistrationsByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return CourseRegistrationServiceUtil.getCourseRegistrationByCourseIdAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			return CourseRegistrationServiceUtil.getCourseRegistrationById(((Long)arguments[0]).longValue());
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return CourseRegistrationServiceUtil.getCourseRegistrationByStatus(((Integer)arguments[0]).intValue());
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return CourseRegistrationServiceUtil.getCourseRegistrationByUserIdAndCourseId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return CourseRegistrationServiceUtil.getCourseRegistrationsByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			return CourseRegistrationServiceUtil.isFullRegistered(((Long)arguments[0]).longValue());
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return CourseRegistrationServiceUtil.updateStatusOfCourseRegistration(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
}