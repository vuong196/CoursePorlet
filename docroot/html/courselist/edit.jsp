<%@ include file="/html/courselist/init.jsp"%>

<portlet:actionURL var="editCourseURL" name="editCourse">
</portlet:actionURL>

<%
	String courseId = (request.getParameter("courseId")).toString();
	Course c = CourseServiceUtil.getCourseById(Long.parseLong(courseId));
%>
<center>
	<h1> Edit Course </h1>
</center>
<aui:form action="<%=editCourseURL%>" method="post">
	<aui:input label="Id" name="id" value="${courseId }">
		<aui:validator name="readonly" />
	</aui:input>
	<aui:input label="Name" name="name" type="text" value="<%=c.getName() %>" >
		<aui:validator name="required" />
		<aui:validator name="maxLength">75</aui:validator>
	</aui:input>
	<aui:input label="Description" name="description" type="text" value="<%=c.getDescription() %>" >
		<aui:validator name="maxLength">2000</aui:validator>
	</aui:input>
	<aui:input label="Lecturer" name="lecturer" type="text" value="<%=c.getLecturer() %>" >
		<aui:validator name="required" />
		<aui:validator name="maxLength">75</aui:validator>
	</aui:input>
	<aui:input label="Duration" name="duration" type="number" value="<%=c.getDuration() %>"  >
		<aui:validator name="required" />
		<aui:validator name="range">[1,40]</aui:validator>
	</aui:input>
	<aui:input label="Available" name="status" type="checkbox" value="<%=c.getStatus() %>" />

	<aui:button type="submit" />
</aui:form>
