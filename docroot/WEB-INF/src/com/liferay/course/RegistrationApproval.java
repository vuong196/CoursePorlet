
package com.liferay.course;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.course.model.CourseRegistration;
import com.liferay.course.service.CourseRegistrationServiceUtil;
import com.liferay.course.util.CourseRegistrationStatus;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class RegistrationApproval
 */
public class RegistrationApproval extends MVCPortlet {

	public void approveCourseRegistration(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long courseId = ParamUtil.getLong(actionRequest, "courseId");

		List<CourseRegistration> c = CourseRegistrationServiceUtil.getCourseRegistrationByCourseIdAndStatus(courseId,
			CourseRegistrationStatus.APPROVED.getStatusNumber());

		if (c.size() < 20) {

			long id = ParamUtil.getLong(actionRequest, "id");

			CourseRegistrationServiceUtil.updateStatusOfCourseRegistration(id,
				CourseRegistrationStatus.APPROVED.getStatusNumber());
		}
		else {

			SessionErrors.add(actionRequest, "error");
		}
	}

	public void rejectCourseRegistration(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long id = ParamUtil.getLong(actionRequest, "id");

		try {

			CourseRegistrationServiceUtil.updateStatusOfCourseRegistration(id,
				CourseRegistrationStatus.REJECTED.getStatusNumber());
		}
		catch(Exception e) {

			SessionErrors.add(actionRequest, "error");
		}
		
	}
}
