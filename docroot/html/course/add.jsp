<%@ include file="/html/course/init.jsp"%>

<portlet:actionURL var="addCourseURL" name="addCourse">
</portlet:actionURL>
<center>
	<h1> Add New Course </h1>
</center>

<aui:form action="<%=addCourseURL%>" method="post">
	<aui:input label="Name" name="name" type="text" value="" />
	<aui:input label="Description" name="description" type="text" value="" />
	<aui:input label="Lecturer" name="lecturer" type="text" value="" />
	<aui:input label="Duration" name="duration" type="number" value="" />
	<aui:input label="Available" name="status" type="checkbox" value="" />

	<aui:button type="submit" />
</aui:form>