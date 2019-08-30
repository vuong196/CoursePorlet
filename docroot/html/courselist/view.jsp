<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/courselist/init.jsp"%>
<portlet:defineObjects />

<%
	List<Course> courses = CourseServiceUtil.getAllCourses();
	PortletURL viewCourseUrl = renderResponse.createRenderURL();
	viewCourseUrl.setParameter("mvcPath", "/courselist/view.jsp");
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/html/courselist/view_search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" />
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<h1> Course List </h1>

<portlet:renderURL var="addCourse">
	<portlet:param name="mvcPath" value="/html/courselist/add.jsp" />
</portlet:renderURL>
<aui:button name="" cssClass="btn btn-success" value="Add New Course" onClick="<%=addCourse %>" ></aui:button>

<liferay-ui:search-container emptyResultsMessage="No course found" iteratorURL="<%=viewCourseUrl %>" >
	<liferay-ui:search-container-results results="<%= courses %>" >
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="com.liferay.course.model.Course" modelVar="course" keyProperty="courseId" > 
		<portlet:renderURL var="editCourse">
			<portlet:param name="jspPage" value="/html/courselist/edit.jsp" />
			<portlet:param name="courseId" value="${course.courseId }"/>
		</portlet:renderURL>
		<portlet:actionURL var="deleteCourseURL" name="deleteCourse">
			<portlet:param name="courseId" value="${course.courseId }"/>
		</portlet:actionURL>
		<liferay-ui:search-container-column-text property="name" name="Course Name"/>
		<liferay-ui:search-container-column-text property="description" name="Description"/>
		<liferay-ui:search-container-column-text property="lecturer" name="Lecturer"/>
		<liferay-ui:search-container-column-text property="duration" name="Duration"/>
		<liferay-ui:search-container-column-text property="status" name="Status"/>
		<liferay-ui:search-container-column-text name="Actions">
			<aui:button cssClass="btn btn-primary" type="button" name="" value="Update" onClick="${editCourse}" ></aui:button>
			<aui:button cssClass="btn btn-danger" name="" value="Delete" onClick="${deleteCourseURL}" ></aui:button>
		</liferay-ui:search-container-column-text> 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
