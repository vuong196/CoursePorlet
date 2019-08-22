
package com.liferay.course;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.course.model.Course;
import com.liferay.course.model.CourseRegistration;
import com.liferay.course.service.CourseRegistrationServiceUtil;
import com.liferay.course.service.CourseServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CourseRegistrationPortlet
 */
public class CourseRegistrationPortlet extends MVCPortlet {

	public void deleteCourse(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long userId = ParamUtil.getLong(actionRequest, "userId");
		long groupId = ParamUtil.getLong(actionRequest, "groupId");
		long id = ParamUtil.getLong(actionRequest, "id");
		CourseRegistration CourseRegistration = CourseRegistrationServiceUtil.getCourseRegistrationById(id);

		if (CourseRegistration.getStatus() == -1 && CourseRegistration.getUserId() == userId) {

			CourseRegistrationServiceUtil.deleteCourseRegistration(groupId, id);
		}
	}

	public void deleteOwnerCourseRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long id = ParamUtil.getLong(actionRequest, "id");

		CourseRegistrationServiceUtil.updateStatusOfCourseRegistration(id, 2);
	}

	public List<CourseRegistration> getAvailableCourseRegistrationsByUserId(ActionRequest actionRequest,
		ActionResponse actionResponse) throws Exception {

		long userId = ParamUtil.getLong(actionRequest, "userId");

		System.out.println(userId);
		return CourseRegistrationServiceUtil.getAvailableCourseRegistrationsByUserId(userId);
	}

	public List<Course> getAvailableCoursesByUserId(ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		return CourseServiceUtil.getCoursesByStatus(1);
	}

	public void registerCourse(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long userId = PortalUtil.getUserId(actionRequest);
		long groupId = PortalUtil.getScopeGroupId(actionRequest);
		long courseId = ParamUtil.getLong(actionRequest, "courseId");
		try {

			CourseRegistrationServiceUtil.getCourseRegistrationByUserIdAndCourseId(userId, courseId);
		}
		catch (NoSuchCourseRegistrationException e) {

			CourseRegistrationServiceUtil.addCourseRegistration(groupId, courseId, userId);
		}

	}
}
