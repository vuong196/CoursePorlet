
package com.liferay.course;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.course.model.Course;
import com.liferay.course.service.CourseLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class coursePortlet
 */
public class coursePortlet extends MVCPortlet {

    public void addCourse(final ActionRequest actionRequest, final ActionResponse actionResponse)
	    throws SystemException {

	final String name = ParamUtil.getString(actionRequest, "name");
	final String description = ParamUtil.getString(actionRequest, "description");
	final String lecturer = ParamUtil.getString(actionRequest, "lecturer");
	final int duration = ParamUtil.getInteger(actionRequest, "duration");
	final boolean status = ParamUtil.getBoolean(actionRequest, "status");

	final Course course = CourseLocalServiceUtil.createCourse(CounterLocalServiceUtil.increment());
	course.setName(name);
	course.setDescription(description);
	course.setLecturer(lecturer);
	course.setDuration(duration);
	course.setStatus(status);

	CourseLocalServiceUtil.addCourse(course);
    }

    public void deleteCourse(final ActionRequest actionRequest, final ActionResponse actionResponse)
	    throws SystemException, PortalException {

	CourseLocalServiceUtil.deleteCourse(ParamUtil.getLong(actionRequest, "courseId"));
    }

    public void editCourse(final ActionRequest actionRequest, final ActionResponse actionResponse)
	    throws SystemException, PortalException {

	final String name = ParamUtil.getString(actionRequest, "name");
	final String description = ParamUtil.getString(actionRequest, "description");
	final String lecturer = ParamUtil.getString(actionRequest, "lecturer");
	final int duration = ParamUtil.getInteger(actionRequest, "duration");
	final boolean status = ParamUtil.getBoolean(actionRequest, "status");

	final Course course = CourseLocalServiceUtil.fetchCourse(ParamUtil.getInteger(actionRequest, "id"));
	course.setName(name);
	course.setDescription(description);
	course.setLecturer(lecturer);
	course.setDuration(duration);
	course.setStatus(status);

	CourseLocalServiceUtil.updateCourse(course);
    }
}
