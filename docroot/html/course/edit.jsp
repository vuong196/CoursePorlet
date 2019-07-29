<%@ include file="/html/course/init.jsp"%>

<portlet:actionURL var="editCourseURL" name="editCourse">
</portlet:actionURL>

<%
	String courseId = (request.getParameter("courseId")).toString();
	Course c = CourseLocalServiceUtil.getCourse(Long.parseLong(courseId));
%>
<center>
	<h1> Edit Course </h1>
</center>
<aui:form action="<%=editCourseURL%>" method="post">
	<aui:input label="Id" name="id" type="text" value="<%=courseId %>"/>
	<aui:input label="Name" name="name" type="text" value="<%=c.getName() %>" />
	<aui:input label="Description" name="description" type="text" value="<%=c.getDescription() %>" />
	<aui:input label="Lecturer" name="lecturer" type="text" value="<%=c.getLecturer() %>" />
	<aui:input label="Duration" name="duration" type="number" value="<%=c.getDuration() %>" />
	<aui:input label="Available" name="status" type="checkbox" value="<%=c.getStatus() %>" />

	<aui:button type="submit" />
</aui:form>