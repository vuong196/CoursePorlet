<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%@ include file="/html/registrationapproval/init.jsp"%>
<%
	int waitingApprovalStatus = 0;
	User u = themeDisplay.getUser();
	long userId = u.getUserId();
	List<CourseRegistration> waitingApprovalCourseRegistrationList = CourseRegistrationServiceUtil.getCourseRegistrationByStatus(waitingApprovalStatus);
%>
<%
	PortletURL viewCourseUrl = renderResponse.createRenderURL();
	viewCourseUrl.setParameter("mvcPath", "/registrationapproval/view.jsp");
%>

<h2>Waiting Approval Course Registration</h2>
<liferay-ui:search-container emptyResultsMessage="No registration found" iteratorURL="<%=viewCourseUrl %>" >
	<liferay-ui:search-container-results results="<%= waitingApprovalCourseRegistrationList %>" >
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="com.liferay.course.model.CourseRegistration" modelVar="courseRegistration" keyProperty="id" >

		<portlet:actionURL var="approveCourseRegistrationURL" name="approveCourseRegistration">
			<portlet:param name="id" value="${courseRegistration.id}"/>
			<portlet:param name="userId" value="${userId }"/>
			<portlet:param name="courseId" value="${courseRegistration.courseId}"/>
		</portlet:actionURL>

		<portlet:actionURL var="rejectCourseRegistrationURL" name="rejectCourseRegistration">
			<portlet:param name="id" value="${courseRegistration.id}"/>
			<portlet:param name="userId" value="${userId }"/>
			<portlet:param name="courseId" value="${courseRegistration.courseId}"/>
		</portlet:actionURL>

		<liferay-ui:search-container-column-text name="Course Registration">
			<%
				long courseId = courseRegistration.getCourseId();
				Course course = CourseServiceUtil.getCourseById(courseId);
			%>
			<%=course.getName() %>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Actions">
			<aui:button name='' value='Approve' onClick='${approveCourseRegistrationURL}' />
			<aui:button name='' value='Reject' onClick='${rejectCourseRegistrationURL}' />
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>