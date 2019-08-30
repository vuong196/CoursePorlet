<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%@ include file="/html/courseregistration/init.jsp"%>
<%
	User u = themeDisplay.getUser();
	List<Course> availableCourses = CourseServiceUtil.getCoursesByStatus(1);
	List<CourseRegistration> ownerCourseRegistrations = CourseRegistrationServiceUtil.getCourseRegistrationsByUserId(u.getUserId());
	PortletURL viewCourseUrl = renderResponse.createRenderURL();
	viewCourseUrl.setParameter("mvcPath", "/courseregistration/view.jsp");
%>
<h2>Your Courses</h2>
<liferay-ui:search-container emptyResultsMessage="You haven't registered any course yet." iteratorURL="<%=viewCourseUrl %>" >
	<liferay-ui:search-container-results results="<%= ownerCourseRegistrations %>" >
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="com.liferay.course.model.CourseRegistration" modelVar="courseRegistration" keyProperty="id" >
		<portlet:actionURL var="deleteOwnerCourseRegistrationURL" name="deleteOwnerCourseRegistration">
			<portlet:param name="id" value="${courseRegistration.id }"/>
		</portlet:actionURL>
		<liferay-ui:search-container-column-text name="Course Registration">
			<%
				long courseId = courseRegistration.getCourseId();
				Course course = CourseServiceUtil.getCourseById(courseId);
			%>
			<h3><%=course.getName() %>
			<%=
				courseRegistration.getStatus()==0 ? "<span class='badge badge-info'>Waiting-approval</span>" : 
				courseRegistration.getStatus()==1 ? "<span class='badge badge-success'>Approved</span>": 
													"<span class='badge badge-primary'>Rejected</span>"
			%>
			<aui:button name="" value="Delete" onClick="${deleteOwnerCourseRegistrationURL}" disabled="<%= courseRegistration.getStatus()==-1 ? false : true%>"/>
			</h3>
			<p> Description: <b><%=course.getDescription() %> </b></p>
			<p> Lecturer: <b><%=course.getLecturer() %></b> </p>
			<p> Duration: <b><%=course.getDuration() %></b></p>
			<p> Status: <%=course.getStatus()==2 ? "Full Registered" : course.getStatus()== 1 ?"Available" : "Unavailable" %>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<h2> Available Courses</h2>
<liferay-ui:search-container emptyResultsMessage="No course found" iteratorURL="<%=viewCourseUrl %>" >
	<liferay-ui:search-container-results results="<%= availableCourses %>" >
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="com.liferay.course.model.Course" modelVar="course" keyProperty="courseId" >

		<portlet:actionURL var="registerCourseURL" name="registerCourse">
			<portlet:param name="courseId" value="${course.courseId}"/>
		</portlet:actionURL>	

		<liferay-ui:search-container-column-text name="Courses">
			<details>
				<summary>
					<b>${course.name }</b>
					<span class="label label-success">
						<% boolean isFullRegistered = CourseRegistrationServiceUtil.isFullRegistered(course.getCourseId()); %>
						<%=course.getStatus()==2 ? "Full Registered" : course.getStatus()== 1 ?"Available" : "Unavailable" %>
					</span>
				</summary>
				</br>
				<p> <b>Description: </b> ${course.description}</p>
				<p> <b>Lecturer: </b> ${course.lecturer}</p>
				<p> <b>Duration: </b> ${course.duration}</p>
			</details>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Actions">
			<aui:button cssClass="btn btn-info" name="" value="Register" onClick="${registerCourseURL}" />
		</liferay-ui:search-container-column-text> 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>