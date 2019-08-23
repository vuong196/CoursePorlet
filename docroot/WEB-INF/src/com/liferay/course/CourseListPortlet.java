
package com.liferay.course;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.course.model.Course;
import com.liferay.course.service.CourseServiceUtil;
import com.liferay.course.util.CourseStatus;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class CourseListPortlet extends MVCPortlet {

	public void addCourse(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long groupId = PortalUtil.getScopeGroupId(actionRequest);
		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		String lecturer = ParamUtil.getString(actionRequest, "lecturer");
		int duration = ParamUtil.getInteger(actionRequest, "duration");
		int status = ParamUtil.getBoolean(actionRequest, "status") ? CourseStatus.AVAILABLE.getStatusNumber()
			: CourseStatus.UNAVAILABLE.getStatusNumber();

		if (CourseServiceUtil.addCourse(groupId, name, description, lecturer, duration, status) == null) {

			SessionErrors.add(actionRequest, "error");
		}
	}

	public void deleteCourse(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long id = ParamUtil.getLong(actionRequest, "courseId");
		long groupId = PortalUtil.getScopeGroupId(actionRequest);

		if (CourseServiceUtil.deleteCourse(groupId, id) == null) {

			SessionErrors.add(actionRequest, "error");
		}
	}

	public List<Course> getAllCourses(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		try {

			return CourseServiceUtil.getAllCourses();
		}
		catch (Exception e) {

			SessionErrors.add(actionRequest, "error");
		}

		return null;

	}

	public List<Course> getAvailableCourse(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		try {

			return CourseServiceUtil.getCoursesByStatus(CourseStatus.AVAILABLE.getStatusNumber());
		}
		catch (Exception e) {

			SessionErrors.add(actionRequest, "error");
		}

		return null;

	}

	public Course getCourseById(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		try {

			long id = ParamUtil.getLong(actionRequest, "courseId");

			return CourseServiceUtil.getCourseById(id);
		}
		catch (Exception e) {

			SessionErrors.add(actionRequest, "error");
		}

		return null;

	}

	public void updateCourse(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long groupId = PortalUtil.getScopeGroupId(actionRequest);
		long id = ParamUtil.getLong(actionRequest, "id");
		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		String lecturer = ParamUtil.getString(actionRequest, "lecturer");
		int duration = ParamUtil.getInteger(actionRequest, "duration");
		int status = ParamUtil.getBoolean(actionRequest, "status") ? CourseStatus.AVAILABLE.getStatusNumber()
			: CourseStatus.UNAVAILABLE.getStatusNumber();

		if (CourseServiceUtil.updateCourse(groupId, id, name, description, lecturer, duration, status) == null) {

			SessionErrors.add(actionRequest, "error");
		}
	}
}

/**
 * Portlet implementation class CourseListPortlet
 */

