
package com.liferay.course.indexer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.course.model.Course;
import com.liferay.course.service.CourseLocalServiceUtil;
import com.liferay.course.service.permission.CoursePermission;
import com.liferay.course.util.MyActionKeys;
import com.liferay.course.util.PortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.PermissionChecker;

public class CourseIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = { Course.class.getName() };

	public static final String PORTLET_ID = PortletKeys.COURSE_ADMIN;

	private static Log _log = LogFactoryUtil.getLog(CourseIndexer.class);

	private static final boolean _PERMISSION_AWARE = true;

	public CourseIndexer() {

		setPermissionAware(true);
	}

	@Override
	public String[] getClassNames() {

		if (_log.isDebugEnabled()) {
			_log.debug("getClassNames");
		}
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {

		return PORTLET_ID;
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String courseClassName, long courseClassPK,
		String actionId) throws Exception {

		return CoursePermission.contains(permissionChecker, courseClassPK, MyActionKeys.VIEW);
	}

	@Override
	public boolean isPermissionAware() {

		return _PERMISSION_AWARE;
	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, SearchContext searchContext) throws Exception {

		String name = (String) searchContext.getAttribute("name");
		if (Validator.isNotNull(name)) {
			if (searchContext.isAndSearch()) {
				searchQuery.addRequiredTerm("courseName", name);
			}
			else {
				searchQuery.addTerm("courseName", name);
			}
		}
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

		Course course = (Course) obj;
		long companyId = course.getCompanyId();
		deleteDocument(companyId, course.getCourseId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {

		_log.info("Adding course in indexer");
		Course course = (Course) obj;

		String courseName = course.getName();
		String courseDescription = course.getDescription();
		String courseLecturer = course.getLecturer();

		Document document = getBaseModelDocument(PORTLET_ID, course);

		document.addKeyword(Field.GROUP_ID, getSiteGroupId(course.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, course.getGroupId());
		document.addKeyword(Field.ENTRY_CLASS_NAME, Course.class.getName());
		document.addText("courseName", courseName);
		document.addText("courseDescription", courseDescription);
		document.addText("courseLecturer", courseLecturer);

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL)
		throws Exception {

		Summary summary = createSummary(document);

		summary.setMaxContentLength(200);

		return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {

		Course course = (Course) obj;

		Document document = getDocument(course);

		long companyId = course.getCompanyId();

		_log.info(companyId);
		SearchEngineUtil.updateDocument(getSearchEngineId(), companyId, document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {

		Course course = CourseLocalServiceUtil.getCourse(classPK);

		doReindex(course);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);

		reindexEntries(companyId);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {

		return PORTLET_ID;
	}

	protected void reindexEntries(long companyId) throws PortalException, SystemException {

		int courseCount = CourseLocalServiceUtil.getCoursesCount();

		int start = 0;
		int step = 50;
		int end = start + step;
		int page = courseCount / step;
		for (int i = 0; i <= page; i++) {

			List<Course> courses = CourseLocalServiceUtil.getCourses(start, end);
			List<Document> documents = new ArrayList();
			for (Course course : courses) {

				documents.add(getDocument(course));
				System.out.println(course);
			}
			SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents);
			start = end;
			end = start + step;
		}
	}
}
