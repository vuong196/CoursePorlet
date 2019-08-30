
package com.liferay.course.listener;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import java.util.List;

import com.liferay.course.model.Course;
import com.liferay.course.model.CourseRegistration;
import com.liferay.course.service.CourseLocalServiceUtil;
import com.liferay.course.service.CourseRegistrationServiceUtil;
import com.liferay.course.service.CourseServiceUtil;
import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;

public class CourseRegistrationListener extends BaseModelListener<CourseRegistration> {

	static int approvedStatus = 2;

	@Override
	public void onAfterCreate(CourseRegistration CourseRegistration) throws ModelListenerException {

		try {

			List<CourseRegistration> CourseRegistrationList = CourseRegistrationServiceUtil
				.getCourseRegistrationByCourseIdAndStatus(CourseRegistration.getCourseId(), approvedStatus);

			if (CourseRegistrationList.size() > 19) {

				Course course = CourseServiceUtil.getCourseById(CourseRegistration.getCourseId());

				course.setStatus(approvedStatus);

				CourseLocalServiceUtil.updateCourse(course);
			}
		}
		catch (Exception e) {

			_log.info(e.getCause());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CourseRegistrationListener.class);

}
