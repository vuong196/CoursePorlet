
package com.liferay.course.indexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.course.model.Course;
import com.liferay.course.service.CourseLocalServiceUtil;
import com.liferay.course.service.permission.CoursePermission;
import com.liferay.course.service.persistence.CourseActionableDynamicQuery;
import com.liferay.course.util.MyActionKeys;
import com.liferay.course.util.PortletKeys;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;

public class CourseIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = { Course.class.getName() };

	public static final String PORTLET_ID = PortletKeys.COURSE_ADMIN;

	public CourseIndexer() {

		setPermissionAware(true);
	}

	@Override
	public String[] getClassNames() {

		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {

		return PORTLET_ID;
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String courseClassName, long entryClassPK,
		String actionId) throws Exception {

		return CoursePermission.contains(permissionChecker, entryClassPK, MyActionKeys.VIEW);
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

		Course course = (Course) obj;
		long companyId = CompanyThreadLocal.getCompanyId();
		deleteDocument(companyId, course.getCourseId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {

		Course course = (Course) obj;

		String courseName = course.getName();
		String courseDescription = course.getDescription();
		String courseLecturer = course.getLecturer();
		long courseDuration = course.getDuration();
		int courseStatus = course.getStatus();

		Document document = getBaseModelDocument(PORTLET_ID, course);

		document.addKeyword(Field.PORTLET_ID, PORTLET_ID);
		document.addText(Field.TITLE, courseName);
		document.addText(Field.DESCRIPTION, courseDescription);
		document.addText("lecturer", courseLecturer);
		document.addKeyword("duration", courseDuration);
		document.addKeyword("status", courseStatus);

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

		long companyId = CompanyThreadLocal.getCompanyId();
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

		final Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery = new CourseActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {

			}

			@Override
			protected void performAction(Object object) throws PortalException {

				Course course = (Course) object;

				Document document = getDocument(course);

				documents.add(document);
			}

		};

		actionableDynamicQuery.setCompanyId(companyId);

		actionableDynamicQuery.performActions();

		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents);
	}

}
