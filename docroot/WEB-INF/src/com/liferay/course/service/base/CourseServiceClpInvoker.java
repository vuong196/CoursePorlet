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

import com.liferay.course.service.CourseServiceUtil;

import java.util.Arrays;

/**
 * @author ces
 * @generated
 */
public class CourseServiceClpInvoker {
	public CourseServiceClpInvoker() {
		_methodName36 = "getBeanIdentifier";

		_methodParameterTypes36 = new String[] {  };

		_methodName37 = "setBeanIdentifier";

		_methodParameterTypes37 = new String[] { "java.lang.String" };

		_methodName42 = "addCourse";

		_methodParameterTypes42 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName43 = "deleteCourse";

		_methodParameterTypes43 = new String[] { "long", "long" };

		_methodName44 = "getAllCourses";

		_methodParameterTypes44 = new String[] {  };

		_methodName45 = "getCourseById";

		_methodParameterTypes45 = new String[] { "long" };

		_methodName46 = "getCoursesByStatus";

		_methodParameterTypes46 = new String[] { "int" };

		_methodName47 = "getCoursesCount";

		_methodParameterTypes47 = new String[] {  };

		_methodName48 = "updateCourse";

		_methodParameterTypes48 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return CourseServiceUtil.getBeanIdentifier();
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			CourseServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return CourseServiceUtil.addCourse(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return CourseServiceUtil.deleteCourse(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return CourseServiceUtil.getAllCourses();
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return CourseServiceUtil.getCourseById(((Long)arguments[0]).longValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return CourseServiceUtil.getCoursesByStatus(((Integer)arguments[0]).intValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return CourseServiceUtil.getCoursesCount();
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return CourseServiceUtil.updateCourse(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
}