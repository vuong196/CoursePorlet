
package com.liferay.course.util;

public enum CourseStatus {
	AVAILABLE(1), FULL_REGISTRERED(2), UNAVAILABLE(0);

	private final int _statusNumber;

	CourseStatus(int statusNumber) {

		_statusNumber = statusNumber;
	}

	public int getStatusNumber() {

		return _statusNumber;
	}
}
