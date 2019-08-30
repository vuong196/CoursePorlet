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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the course registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ces
 * @see CourseRegistrationPersistenceImpl
 * @see CourseRegistrationUtil
 * @generated
 */
public interface CourseRegistrationPersistence extends BasePersistence<CourseRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseRegistrationUtil} to access the course registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the course registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.course.model.CourseRegistration> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration[] findByUuid_PrevAndNext(
		long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course registrations that the user has permission to view where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration[] filterFindByUuid_PrevAndNext(
		long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course registrations that the user has permission to view where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course registration where courseId = &#63; and userId = &#63; or throws a {@link com.liferay.course.NoSuchCourseRegistrationException} if it could not be found.
	*
	* @param courseId the course ID
	* @param userId the user ID
	* @return the matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration findByCourse_User(
		long courseId, long userId)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course registration where courseId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param courseId the course ID
	* @param userId the user ID
	* @return the matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByCourse_User(
		long courseId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course registration where courseId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param courseId the course ID
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByCourse_User(
		long courseId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the course registration where courseId = &#63; and userId = &#63; from the database.
	*
	* @param courseId the course ID
	* @param userId the user ID
	* @return the course registration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration removeByCourse_User(
		long courseId, long userId)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course registrations where courseId = &#63; and userId = &#63;.
	*
	* @param courseId the course ID
	* @param userId the user ID
	* @return the number of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourse_User(long courseId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course registrations where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @return the matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.course.model.CourseRegistration> findByUser_Status(
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> findByUser_Status(
		long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> findByUser_Status(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration findByUser_Status_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course registration in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByUser_Status_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration findByUser_Status_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course registration in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByUser_Status_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration[] findByUser_Status_PrevAndNext(
		long id, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course registrations that the user has permission to view where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @return the matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUser_Status(
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUser_Status(
		long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUser_Status(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration[] filterFindByUser_Status_PrevAndNext(
		long id, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course registrations where userId = &#63; and status = &#63; from the database.
	*
	* @param userId the user ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser_Status(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course registrations where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @return the number of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser_Status(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course registrations that the user has permission to view where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @return the number of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByUser_Status(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course registrations where status = &#63;.
	*
	* @param status the status
	* @return the matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.course.model.CourseRegistration> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course registration in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course registration in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course registration in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course registration in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration[] findByStatus_PrevAndNext(
		long id, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course registrations that the user has permission to view where status = &#63;.
	*
	* @param status the status
	* @return the matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration[] filterFindByStatus_PrevAndNext(
		long id, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course registrations where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course registrations where status = &#63;.
	*
	* @param status the status
	* @return the number of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course registrations that the user has permission to view where status = &#63;.
	*
	* @param status the status
	* @return the number of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course registrations where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.course.model.CourseRegistration> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration[] findByUserId_PrevAndNext(
		long id, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course registrations that the user has permission to view where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration[] filterFindByUserId_PrevAndNext(
		long id, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course registrations where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course registrations where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course registrations that the user has permission to view where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course registrations where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.course.model.CourseRegistration> findByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> findByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> findByCourseId(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course registration in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration findByCourseId_First(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course registration in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByCourseId_First(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course registration in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration findByCourseId_Last(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course registration in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByCourseId_Last(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration[] findByCourseId_PrevAndNext(
		long id, long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course registrations that the user has permission to view where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByCourseId(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration[] filterFindByCourseId_PrevAndNext(
		long id, long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course registrations where courseId = &#63; from the database.
	*
	* @param courseId the course ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course registrations where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the number of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course registrations that the user has permission to view where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the number of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course registrations where courseId = &#63; and status = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @return the matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.course.model.CourseRegistration> findByCourse_Status(
		long courseId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> findByCourse_Status(
		long courseId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> findByCourse_Status(
		long courseId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration findByCourse_Status_First(
		long courseId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course registration in the ordered set where courseId = &#63; and status = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByCourse_Status_First(
		long courseId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration findByCourse_Status_Last(
		long courseId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course registration in the ordered set where courseId = &#63; and status = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByCourse_Status_Last(
		long courseId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration[] findByCourse_Status_PrevAndNext(
		long id, long courseId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course registrations that the user has permission to view where courseId = &#63; and status = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @return the matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByCourse_Status(
		long courseId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByCourse_Status(
		long courseId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> filterFindByCourse_Status(
		long courseId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.course.model.CourseRegistration[] filterFindByCourse_Status_PrevAndNext(
		long id, long courseId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course registrations where courseId = &#63; and status = &#63; from the database.
	*
	* @param courseId the course ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourse_Status(long courseId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course registrations where courseId = &#63; and status = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @return the number of matching course registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourse_Status(long courseId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course registrations that the user has permission to view where courseId = &#63; and status = &#63;.
	*
	* @param courseId the course ID
	* @param status the status
	* @return the number of matching course registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCourse_Status(long courseId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the course registration in the entity cache if it is enabled.
	*
	* @param courseRegistration the course registration
	*/
	public void cacheResult(
		com.liferay.course.model.CourseRegistration courseRegistration);

	/**
	* Caches the course registrations in the entity cache if it is enabled.
	*
	* @param courseRegistrations the course registrations
	*/
	public void cacheResult(
		java.util.List<com.liferay.course.model.CourseRegistration> courseRegistrations);

	/**
	* Creates a new course registration with the primary key. Does not add the course registration to the database.
	*
	* @param id the primary key for the new course registration
	* @return the new course registration
	*/
	public com.liferay.course.model.CourseRegistration create(long id);

	/**
	* Removes the course registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the course registration
	* @return the course registration that was removed
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration remove(long id)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.course.model.CourseRegistration updateImpl(
		com.liferay.course.model.CourseRegistration courseRegistration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course registration with the primary key or throws a {@link com.liferay.course.NoSuchCourseRegistrationException} if it could not be found.
	*
	* @param id the primary key of the course registration
	* @return the course registration
	* @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration findByPrimaryKey(long id)
		throws com.liferay.course.NoSuchCourseRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the course registration
	* @return the course registration, or <code>null</code> if a course registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.course.model.CourseRegistration fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course registrations.
	*
	* @return the course registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.course.model.CourseRegistration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.course.model.CourseRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course registrations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course registrations.
	*
	* @return the number of course registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}