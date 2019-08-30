<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.liferay.course.model.Course"%>
<%@page import="com.liferay.course.service.CourseServiceUtil"%>

<%@page import="com.liferay.course.model.CourseRegistration"%>
<%@page import="com.liferay.course.service.CourseRegistrationServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
