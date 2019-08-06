<%@ include file="/html/courselist/init.jsp"%>

<portlet:actionURL var="addCourseURL" name="addCourse">
</portlet:actionURL>
<center>
	<h1> Add New Course </h1>
</center>

<aui:form action="<%=addCourseURL%>" method="post">
	<aui:input label="Name" name="name" type="text" value="">
		<aui:validator name="required" />
		<aui:validator name="maxLength">75</aui:validator>
	</aui:input>
	<aui:input label="Description" name="description" type="text" value="" >
		<aui:validator name="maxLength">2000</aui:validator>
	</aui:input>
	<aui:input label="Lecturer" name="lecturer" type="text" value="" >
		<aui:validator name="required" />
		<aui:validator name="maxLength">75</aui:validator>
	</aui:input>
	<aui:input label="Duration" name="duration" type="number" value="" >
		<aui:validator name="required" />
		<aui:validator name="range">[1,40]</aui:validator>
	</aui:input>
	<aui:input label="Available" name="status" type="checkbox" value="" >
		<aui:validator name="required" />
	</aui:input>

	<aui:button type="submit" />
</aui:form>