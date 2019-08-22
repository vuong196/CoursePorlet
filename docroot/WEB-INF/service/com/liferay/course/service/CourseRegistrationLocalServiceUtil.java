/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.course.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for CourseRegistration. This utility wraps
 * {@link com.liferay.course.service.impl.CourseRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author ces
 * @see CourseRegistrationLocalService
 * @see com.liferay.course.service.base.CourseRegistrationLocalServiceBaseImpl
 * @see com.liferay.course.service.impl.CourseRegistrationLocalServiceImpl
 * @generated
 */
public class CourseRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.course.service.impl.CourseRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the course registration to the database. Also notifies the appropriate model listeners.
	*
	* @param courseRegistration the course registration
	* @return the course registration that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration addCourseRegistration(
		com.liferay.course.model.CourseRegistration courseRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCourseRegistration(courseRegistration);
	}

	/**
	* Creates a new course registration with the primary key. Does not add the course registration to the database.
	*
	* @param id the primary key for the new course registration
	* @return the new course registration
	*/
	public static com.liferay.course.model.CourseRegistration createCourseRegistration(
		long id) {
		return getService().createCourseRegistration(id);
	}

	/**
	* Deletes the course registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the course registration
	* @return the course registration that was removed
	* @throws PortalException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration deleteCourseRegistration(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCourseRegistration(id);
	}

	/**
	* Deletes the course registration from the database. Also notifies the appropriate model listeners.
	*
	* @param courseRegistration the course registration
	* @return the course registration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration deleteCourseRegistration(
		com.liferay.course.model.CourseRegistration courseRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCourseRegistration(courseRegistration);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.course.model.CourseRegistration fetchCourseRegistration(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCourseRegistration(id);
	}

	/**
	* Returns the course registration with the primary key.
	*
	* @param id the primary key of the course registration
	* @return the course registration
	* @throws PortalException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration getCourseRegistration(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCourseRegistration(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the course registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @return the range of course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCourseRegistrations(start, end);
	}

	/**
	* Returns the number of course registrations.
	*
	* @return the number of course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int getCourseRegistrationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCourseRegistrationsCount();
	}

	/**
	* Updates the course registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param courseRegistration the course registration
	* @return the course registration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration updateCourseRegistration(
		com.liferay.course.model.CourseRegistration courseRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCourseRegistration(courseRegistration);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.liferay.course.model.CourseRegistration> getAvailableCourseRegistrationsByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAvailableCourseRegistrationsByUserId(userId);
	}

	public static java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationsByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCourseRegistrationsByUserId(userId);
	}

	public static java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCourseRegistrationByCourseId(courseId);
	}

	public static java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationByCourseIdAndStatus(
		long courseId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCourseRegistrationByCourseIdAndStatus(courseId, status);
	}

	public static com.liferay.course.model.CourseRegistration getCourseRegistrationByUserIdAndCourseId(
		long userId, long courseId)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCourseRegistrationByUserIdAndCourseId(userId, courseId);
	}

	public static java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationsByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCourseRegistrationsByStatus(status);
	}

	public static java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationsByUserIdAndStatus(
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCourseRegistrationsByUserIdAndStatus(userId, status);
	}

	public static java.util.List<com.liferay.course.model.Course> getCoursesByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCoursesByStatus(status);
	}

	public static void clearService() {
		_service = null;
	}

	public static CourseRegistrationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CourseRegistrationLocalService.class.getName());

			if (invokableLocalService instanceof CourseRegistrationLocalService) {
				_service = (CourseRegistrationLocalService)invokableLocalService;
			}
			else {
				_service = new CourseRegistrationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CourseRegistrationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CourseRegistrationLocalService service) {
	}

	private static CourseRegistrationLocalService _service;
}