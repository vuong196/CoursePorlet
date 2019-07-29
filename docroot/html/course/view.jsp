<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<portlet:defineObjects />

<%@ include file="/html/course/init.jsp"%>

<center>
	<h1> Course List </h1>

	<portlet:renderURL var="addCourse">
		<portlet:param name="mvcPath" value="/html/course/add.jsp" />
	</portlet:renderURL>
	<center>
		<aui:button name="" value="Add New Course" onClick="<%=addCourse %>" ></aui:button>
	</center>
	<br>
	<center>
	<table border='1' cellpadding='4' width='60%'>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Lecturer</th>
			<th>Duration</th>
			<th>Status</th>
			<th>Actions</th>
		</tr>
		<%
			List<Course> courses = CourseLocalServiceUtil.getCourses(-1,-1);
			for(Course c : courses) {

		%>
			<tr>
				<td><%=c.getCourseId()%></td>
				<td><%=c.getName()%></td>
				<td><%=c.getDescription()%></td>
				<td><%=c.getLecturer()%></td>
				<td><%=c.getDuration()%></td>
				<% if (c.getStatus()) {%>
				<td>Available</td>
				<% } else { %>
				<td>Unvailable</td>
				<% } %>
				<td>
					<center>
					<portlet:renderURL var="editCourse">
						<portlet:param name="jspPage" value="/html/course/edit.jsp" />
						<portlet:param name="courseId" value="<%=Long.toString(c.getCourseId())%>"/>
					</portlet:renderURL>
						<aui:button name="" value="Update" onClick="<%=editCourse %>" ></aui:button>
					<portlet:actionURL var="deleteCourseURL" name="deleteCourse">
						<portlet:param name="courseId" value="<%=Long.toString(c.getCourseId())%>"/>
					</portlet:actionURL>
						<aui:button name="" value="Delete" onClick="<%=deleteCourseURL %>" ></aui:button>
					</center>
				</td>
			</tr>
		<%} %>
	</table>
	</center>
</center>


