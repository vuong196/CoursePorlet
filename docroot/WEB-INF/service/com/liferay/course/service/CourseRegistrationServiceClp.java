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

import com.liferay.portal.service.InvokableService;

/**
 * @author ces
 * @generated
 */
public class CourseRegistrationServiceClp implements CourseRegistrationService {
	public CourseRegistrationServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "addCourseRegistration";

		_methodParameterTypes3 = new String[] { "long", "long", "long" };

		_methodName4 = "changeCourseRegistrationStatus";

		_methodParameterTypes4 = new String[] { "long", "long", "int" };

		_methodName5 = "deleteCourseRegistration";

		_methodParameterTypes5 = new String[] { "long", "long" };

		_methodName6 = "getAvailableCourseRegistrationsByUserId";

		_methodParameterTypes6 = new String[] { "long" };

		_methodName7 = "getCourseRegistrationByCourseIdAndStatus";

		_methodParameterTypes7 = new String[] { "long", "int" };

		_methodName8 = "getCourseRegistrationById";

		_methodParameterTypes8 = new String[] { "long" };

		_methodName9 = "getCourseRegistrationByStatus";

		_methodParameterTypes9 = new String[] { "int" };

		_methodName10 = "getCourseRegistrationByUserIdAndCourseId";

		_methodParameterTypes10 = new String[] { "long", "long" };

		_methodName11 = "getCourseRegistrationsByUserId";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "isFullRegistered";

		_methodParameterTypes12 = new String[] { "long" };

		_methodName13 = "updateStatusOfCourseRegistration";

		_methodParameterTypes13 = new String[] { "long", "int" };
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public com.liferay.course.model.CourseRegistration addCourseRegistration(
		long groupId, long courseId, long userId) throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { groupId, courseId, userId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.course.model.CourseRegistration)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.course.model.CourseRegistration changeCourseRegistrationStatus(
		long groupId, long id, int status) throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] { groupId, id, status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.course.model.CourseRegistration)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.course.model.CourseRegistration deleteCourseRegistration(
		long groupId, long id) throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5, new Object[] { groupId, id });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.course.model.CourseRegistration)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.course.model.CourseRegistration> getAvailableCourseRegistrationsByUserId(
		long userId) throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6, new Object[] { userId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.course.model.CourseRegistration>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationByCourseIdAndStatus(
		long courseId, int status) throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7, new Object[] { courseId, status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.course.model.CourseRegistration>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.course.model.CourseRegistration getCourseRegistrationById(
		long id) throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName8,
					_methodParameterTypes8, new Object[] { id });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.course.model.CourseRegistration)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName9,
					_methodParameterTypes9, new Object[] { status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.course.model.CourseRegistration>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.course.model.CourseRegistration getCourseRegistrationByUserIdAndCourseId(
		long userId, long courseId) throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName10,
					_methodParameterTypes10, new Object[] { userId, courseId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.course.model.CourseRegistration)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationsByUserId(
		long userId) throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName11,
					_methodParameterTypes11, new Object[] { userId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.course.model.CourseRegistration>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean isFullRegistered(long courseId) throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName12,
					_methodParameterTypes12, new Object[] { courseId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public void updateStatusOfCourseRegistration(long id, int status)
		throws java.lang.Exception {
		try {
			_invokableService.invokeMethod(_methodName13,
				_methodParameterTypes13, new Object[] { id, status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
}