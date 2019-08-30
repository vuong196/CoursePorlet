<%@include file="/html/courselist/init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords");
	long courseId = ParamUtil.getLong(renderRequest, "courseId");
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/html/courselist/view_search.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
	<portlet:param name="mvcPath" value="/html/courselist/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="${searchURL}" name="fm">
	<liferay-ui:header backURL="${viewURL}" title="back" />
	<div class="row">
		<div class="col-md-8">
			<aui:input inlineLabel="left" label="" name="keywords" placeholder="search-entries" size="256" />
		</div>
		<div class="col-md-4">
			<aui:button type="submit" value="search" />
		</div>
	</div>
</aui:form>

<%
	_log.info("Search Course");
	SearchContext searchContext = SearchContextFactory.getInstance(request);
	searchContext.setAttribute("paginationType", "more");
	searchContext.setAttribute("name",keywords);
	
	Indexer indexer = IndexerRegistryUtil.getIndexer(Course.class);

	Hits hits = indexer.search(searchContext);
	System.out.println(hits.getLength());

	List<Course> courses = new ArrayList<Course>();

	for (int i = 0; i < hits.getDocs().length; i++) {

		Document doc = hits.doc(i);

		long entryId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

		Course course = null;
		
		try {

			course = CourseLocalServiceUtil.getCourse(entryId);
			_log.info("Addding course");
		} catch (PortalException pe) {

			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {

			_log.error(se.getLocalizedMessage());
		}

		courses.add(course);
	}

	List<Course> coursess = CourseLocalServiceUtil.getCourses(-1, -1);

	Map<String, String> courseMap = new HashMap<String, String>();

	for (Course course : coursess) {

		courseMap.put(Long.toString(course.getCourseId()), course.getName());
	}
%>

<liferay-ui:search-container delta="10" emptyResultsMessage="no-entries-were-found">
	<liferay-ui:search-container-results
	results="<%= courses %>"
	total="<%= courses.size() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.course.model.Course"
		keyProperty="courseId" modelVar="course" escapedModel="<%=true%>">
	<liferay-ui:search-container-column-text name="course"
		value="<%=courseMap.get(Long.toString(course.getCourseId()))%>" />

	<liferay-ui:search-container-column-text property="name" />
	<liferay-ui:search-container-column-text property="description" />


	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<%
	if (Validator.isNotNull(keywords)) {
		String currentURL = PortalUtil.getCurrentURL(request);
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "search") + ": " + keywords, currentURL);
	}
%>

<%!
	private static Log _log = LogFactoryUtil.getLog("docroot.html.courselist.view_search_jsp");
%>