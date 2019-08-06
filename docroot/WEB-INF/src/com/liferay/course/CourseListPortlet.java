
package com.liferay.course;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.course.model.Course;
import com.liferay.course.service.CourseServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CourseListPortlet
 */
public class CourseListPortlet extends MVCPortlet {

	public void addCourse(final ActionRequest actionRequest, final ActionResponse actionResponse) throws Exception {

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		String lecturer = ParamUtil.getString(actionRequest, "lecturer");
		int duration = ParamUtil.getInteger(actionRequest, "duration");
		boolean status = ParamUtil.getBoolean(actionRequest, "status");

		CourseServiceUtil.addCourse(name, description, lecturer, duration, status);
	}

	public void deleteCourse(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long id = ParamUtil.getLong(actionRequest, "courseId");

		CourseServiceUtil.deleteCourse(id);
	}

	public List<Course> getAllCourses(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		return CourseServiceUtil.getAllCourses();
	}

	public Course getCourseById(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long id = ParamUtil.getLong(actionRequest, "courseId");

		return CourseServiceUtil.getCourseById(id);
	}

	public void updateCourse(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long id = ParamUtil.getLong(actionRequest, "courseId");
		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		String lecturer = ParamUtil.getString(actionRequest, "lecturer");
		int duration = ParamUtil.getInteger(actionRequest, "duration");
		boolean status = ParamUtil.getBoolean(actionRequest, "status");

		CourseServiceUtil.updateCourse(id, name, description, lecturer, duration, status);
	}
}
