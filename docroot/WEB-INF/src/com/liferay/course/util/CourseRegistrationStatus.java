
package com.liferay.course.util;

public enum CourseRegistrationStatus {
	APPROVED(1), DELETED(2), REJECTED(-1), WAITING_APPROVAL(0);

	private final int _statusNumber;

	CourseRegistrationStatus(int statusNumber) {

		_statusNumber = statusNumber;
	}

	public int getStatusNumber() {

		return _statusNumber;
	}
}
