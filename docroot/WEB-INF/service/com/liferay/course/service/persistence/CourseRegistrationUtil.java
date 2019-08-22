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

package com.liferay.course.service.persistence;

import com.liferay.course.model.CourseRegistration;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the course registration service. This utility wraps {@link CourseRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ces
 * @see CourseRegistrationPersistence
 * @see CourseRegistrationPersistenceImpl
 * @generated
 */
public class CourseRegistrationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(CourseRegistration courseRegistration) {
		getPersistence().clearCache(courseRegistration);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CourseRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CourseRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CourseRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CourseRegistration update(
		CourseRegistration courseRegistration) throws SystemException {
		return getPersistence().update(courseRegistration);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CourseRegistration update(
		CourseRegistration courseRegistration, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(courseRegistration, serviceContext);
	}

	/**
	* Returns all the course registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the course registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @return the range of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the course registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first course registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first course registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last course registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last course registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the course registrations before and after the current course registration in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current course registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration[] findByUuid_PrevAndNext(
		long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
	}

	/**
	* Returns all the course registrations that the user has permission to view where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUuid(uuid);
	}

	/**
	* Returns a range of all the course registrations that the user has permission to view where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @return the range of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the course registrations that the user has permissions to view where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the course registrations before and after the current course registration in the ordered set of course registrations that the user has permission to view where uuid = &#63;.
	*
	* @param id the primary key of the current course registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration[] filterFindByUuid_PrevAndNext(
		long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUuid_PrevAndNext(id, uuid, orderByComparator);
	}

	/**
	* Removes all the course registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of course registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the number of course registrations that the user has permission to view where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByUuid(uuid);
	}

	/**
	* Returns the course registration where courseId = &#63; and userId = &#63; or throws a {@link com.liferay.course.NoSuchCourseRegistrationException} if it could not be found.
	*
	* @param courseId the course ID
	* @param userId the user ID
	* @return the matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration findByCourse_User(
		long courseId, long userId)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourse_User(courseId, userId);
	}

	/**
	* Returns the course registration where courseId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param courseId the course ID
	* @param userId the user ID
	* @return the matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByCourse_User(
		long courseId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCourse_User(courseId, userId);
	}

	/**
	* Returns the course registration where courseId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param courseId the course ID
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByCourse_User(
		long courseId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourse_User(courseId, userId, retrieveFromCache);
	}

	/**
	* Removes the course registration where courseId = &#63; and userId = &#63; from the database.
	*
	* @param courseId the course ID
	* @param userId the user ID
	* @return the course registration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration removeByCourse_User(
		long courseId, long userId)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCourse_User(courseId, userId);
	}

	/**
	* Returns the number of course registrations where courseId = &#63; and userId = &#63;.
	*
	* @param courseId the course ID
	* @param userId the user ID
	* @return the number of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourse_User(long courseId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourse_User(courseId, userId);
	}

	/**
	* Returns all the course registrations where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @return the matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByUser_Status(
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_Status(userId, status);
	}

	/**
	* Returns a range of all the course registrations where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param status the status
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @return the range of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByUser_Status(
		long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_Status(userId, status, start, end);
	}

	/**
	* Returns an ordered range of all the course registrations where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param status the status
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByUser_Status(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser_Status(userId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first course registration in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration findByUser_Status_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser_Status_First(userId, status, orderByComparator);
	}

	/**
	* Returns the first course registration in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByUser_Status_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUser_Status_First(userId, status, orderByComparator);
	}

	/**
	* Returns the last course registration in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration findByUser_Status_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser_Status_Last(userId, status, orderByComparator);
	}

	/**
	* Returns the last course registration in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByUser_Status_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUser_Status_Last(userId, status, orderByComparator);
	}

	/**
	* Returns the course registrations before and after the current course registration in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param id the primary key of the current course registration
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration[] findByUser_Status_PrevAndNext(
		long id, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser_Status_PrevAndNext(id, userId, status,
			orderByComparator);
	}

	/**
	* Returns all the course registrations that the user has permission to view where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @return the matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUser_Status(
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUser_Status(userId, status);
	}

	/**
	* Returns a range of all the course registrations that the user has permission to view where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param status the status
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @return the range of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUser_Status(
		long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUser_Status(userId, status, start, end);
	}

	/**
	* Returns an ordered range of all the course registrations that the user has permissions to view where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param status the status
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUser_Status(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUser_Status(userId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the course registrations before and after the current course registration in the ordered set of course registrations that the user has permission to view where userId = &#63; and status = &#63;.
	*
	* @param id the primary key of the current course registration
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration[] filterFindByUser_Status_PrevAndNext(
		long id, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUser_Status_PrevAndNext(id, userId, status,
			orderByComparator);
	}

	/**
	* Removes all the course registrations where userId = &#63; and status = &#63; from the database.
	*
	* @param userId the user ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser_Status(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser_Status(userId, status);
	}

	/**
	* Returns the number of course registrations where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @return the number of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser_Status(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser_Status(userId, status);
	}

	/**
	* Returns the number of course registrations that the user has permission to view where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @return the number of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByUser_Status(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByUser_Status(userId, status);
	}

	/**
	* Returns all the course registrations where status = &#63;.
	*
	* @param status the status
	* @return the matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the course registrations where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @return the range of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the course registrations where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first course registration in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first course registration in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last course registration in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last course registration in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the course registrations before and after the current course registration in the ordered set where status = &#63;.
	*
	* @param id the primary key of the current course registration
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration[] findByStatus_PrevAndNext(
		long id, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus_PrevAndNext(id, status, orderByComparator);
	}

	/**
	* Returns all the course registrations that the user has permission to view where status = &#63;.
	*
	* @param status the status
	* @return the matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByStatus(status);
	}

	/**
	* Returns a range of all the course registrations that the user has permission to view where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @return the range of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the course registrations that the user has permissions to view where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the course registrations before and after the current course registration in the ordered set of course registrations that the user has permission to view where status = &#63;.
	*
	* @param id the primary key of the current course registration
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration[] filterFindByStatus_PrevAndNext(
		long id, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatus_PrevAndNext(id, status, orderByComparator);
	}

	/**
	* Removes all the course registrations where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of course registrations where status = &#63;.
	*
	* @param status the status
	* @return the number of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns the number of course registrations that the user has permission to view where status = &#63;.
	*
	* @param status the status
	* @return the number of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByStatus(status);
	}

	/**
	* Returns all the course registrations where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the course registrations where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @return the range of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the course registrations where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first course registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first course registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last course registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last course registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the course registrations before and after the current course registration in the ordered set where userId = &#63;.
	*
	* @param id the primary key of the current course registration
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration[] findByUserId_PrevAndNext(
		long id, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_PrevAndNext(id, userId, orderByComparator);
	}

	/**
	* Returns all the course registrations that the user has permission to view where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUserId(userId);
	}

	/**
	* Returns a range of all the course registrations that the user has permission to view where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @return the range of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the course registrations that the user has permissions to view where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the course registrations before and after the current course registration in the ordered set of course registrations that the user has permission to view where userId = &#63;.
	*
	* @param id the primary key of the current course registration
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration[] filterFindByUserId_PrevAndNext(
		long id, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUserId_PrevAndNext(id, userId, orderByComparator);
	}

	/**
	* Removes all the course registrations where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of course registrations where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of course registrations that the user has permission to view where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByUserId(userId);
	}

	/**
	* Returns all the course registrations where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseId(courseId);
	}

	/**
	* Returns a range of all the course registrations where courseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @return the range of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseId(courseId, start, end);
	}

	/**
	* Returns an ordered range of all the course registrations where courseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByCourseId(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseId(courseId, start, end, orderByComparator);
	}

	/**
	* Returns the first course registration in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration findByCourseId_First(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseId_First(courseId, orderByComparator);
	}

	/**
	* Returns the first course registration in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByCourseId_First(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseId_First(courseId, orderByComparator);
	}

	/**
	* Returns the last course registration in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration findByCourseId_Last(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseId_Last(courseId, orderByComparator);
	}

	/**
	* Returns the last course registration in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByCourseId_Last(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCourseId_Last(courseId, orderByComparator);
	}

	/**
	* Returns the course registrations before and after the current course registration in the ordered set where courseId = &#63;.
	*
	* @param id the primary key of the current course registration
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration[] findByCourseId_PrevAndNext(
		long id, long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseId_PrevAndNext(id, courseId, orderByComparator);
	}

	/**
	* Returns all the course registrations that the user has permission to view where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCourseId(courseId);
	}

	/**
	* Returns a range of all the course registrations that the user has permission to view where courseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @return the range of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCourseId(courseId, start, end);
	}

	/**
	* Returns an ordered range of all the course registrations that the user has permissions to view where courseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByCourseId(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCourseId(courseId, start, end, orderByComparator);
	}

	/**
	* Returns the course registrations before and after the current course registration in the ordered set of course registrations that the user has permission to view where courseId = &#63;.
	*
	* @param id the primary key of the current course registration
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration[] filterFindByCourseId_PrevAndNext(
		long id, long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCourseId_PrevAndNext(id, courseId,
			orderByComparator);
	}

	/**
	* Removes all the course registrations where courseId = &#63; from the database.
	*
	* @param courseId the course ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourseId(courseId);
	}

	/**
	* Returns the number of course registrations where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the number of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseId(courseId);
	}

	/**
	* Returns the number of course registrations that the user has permission to view where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the number of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByCourseId(courseId);
	}

	/**
	* Returns all the course registrations where courseId = &#63; and status = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @return the matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByCourse_Status(
		long courseId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourse_Status(courseId, status);
	}

	/**
	* Returns a range of all the course registrations where courseId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param status the status
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @return the range of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByCourse_Status(
		long courseId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourse_Status(courseId, status, start, end);
	}

	/**
	* Returns an ordered range of all the course registrations where courseId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param status the status
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findByCourse_Status(
		long courseId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourse_Status(courseId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first course registration in the ordered set where courseId = &#63; and status = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration findByCourse_Status_First(
		long courseId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourse_Status_First(courseId, status,
			orderByComparator);
	}

	/**
	* Returns the first course registration in the ordered set where courseId = &#63; and status = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByCourse_Status_First(
		long courseId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourse_Status_First(courseId, status,
			orderByComparator);
	}

	/**
	* Returns the last course registration in the ordered set where courseId = &#63; and status = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration findByCourse_Status_Last(
		long courseId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourse_Status_Last(courseId, status, orderByComparator);
	}

	/**
	* Returns the last course registration in the ordered set where courseId = &#63; and status = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByCourse_Status_Last(
		long courseId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourse_Status_Last(courseId, status,
			orderByComparator);
	}

	/**
	* Returns the course registrations before and after the current course registration in the ordered set where courseId = &#63; and status = &#63;.
	*
	* @param id the primary key of the current course registration
	* @param courseId the course ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration[] findByCourse_Status_PrevAndNext(
		long id, long courseId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourse_Status_PrevAndNext(id, courseId, status,
			orderByComparator);
	}

	/**
	* Returns all the course registrations that the user has permission to view where courseId = &#63; and status = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @return the matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByCourse_Status(
		long courseId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCourse_Status(courseId, status);
	}

	/**
	* Returns a range of all the course registrations that the user has permission to view where courseId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param status the status
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @return the range of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByCourse_Status(
		long courseId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCourse_Status(courseId, status, start, end);
	}

	/**
	* Returns an ordered range of all the course registrations that the user has permissions to view where courseId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param status the status
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> filterFindByCourse_Status(
		long courseId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCourse_Status(courseId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the course registrations before and after the current course registration in the ordered set of course registrations that the user has permission to view where courseId = &#63; and status = &#63;.
	*
	* @param id the primary key of the current course registration
	* @param courseId the course ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration[] filterFindByCourse_Status_PrevAndNext(
		long id, long courseId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCourse_Status_PrevAndNext(id, courseId, status,
			orderByComparator);
	}

	/**
	* Removes all the course registrations where courseId = &#63; and status = &#63; from the database.
	*
	* @param courseId the course ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourse_Status(long courseId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourse_Status(courseId, status);
	}

	/**
	* Returns the number of course registrations where courseId = &#63; and status = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @return the number of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourse_Status(long courseId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourse_Status(courseId, status);
	}

	/**
	* Returns the number of course registrations that the user has permission to view where courseId = &#63; and status = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @return the number of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCourse_Status(long courseId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByCourse_Status(courseId, status);
	}

	/**
	* Caches the course registration in the entity cache if it is enabled.
	*
	* @param courseRegistration the course registration
	*/
	public static void cacheResult(
		com.liferay.course.model.CourseRegistration courseRegistration) {
		getPersistence().cacheResult(courseRegistration);
	}

	/**
	* Caches the course registrations in the entity cache if it is enabled.
	*
	* @param courseRegistrations the course registrations
	*/
	public static void cacheResult(
		java.util.List<com.liferay.course.model.CourseRegistration> courseRegistrations) {
		getPersistence().cacheResult(courseRegistrations);
	}

	/**
	* Creates a new course registration with the primary key. Does not add the course registration to the database.
	*
	* @param id the primary key for the new course registration
	* @return the new course registration
	*/
	public static com.liferay.course.model.CourseRegistration create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the course registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the course registration
	* @return the course registration that was removed
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration remove(long id)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.liferay.course.model.CourseRegistration updateImpl(
		com.liferay.course.model.CourseRegistration courseRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(courseRegistration);
	}

	/**
	* Returns the course registration with the primary key or throws a {@link com.liferay.course.NoSuchCourseRegistrationException} if it could not be found.
	*
	* @param id the primary key of the course registration
	* @return the course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration findByPrimaryKey(
		long id)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the course registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the course registration
	* @return the course registration, or <code>null</code> if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.course.model.CourseRegistration fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the course registrations.
	*
	* @return the course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.course.model.CourseRegistration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the course registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.course.model.impl.CourseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course registrations
	* @param end the upper bound of the range of course registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.course.model.CourseRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the course registrations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of course registrations.
	*
	* @return the number of course registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CourseRegistrationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CourseRegistrationPersistence)PortletBeanLocatorUtil.locate(com.liferay.course.service.ClpSerializer.getServletContextName(),
					CourseRegistrationPersistence.class.getName());

			ReferenceRegistry.registerReference(CourseRegistrationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CourseRegistrationPersistence persistence) {
	}

	private static CourseRegistrationPersistence _persistence;
}