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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for CourseRegistration. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author ces
 * @see CourseRegistrationServiceUtil
 * @see com.liferay.course.service.base.CourseRegistrationServiceBaseImpl
 * @see com.liferay.course.service.impl.CourseRegistrationServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CourseRegistrationService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseRegistrationServiceUtil} to access the course registration remote service. Add custom service methods to {@link com.liferay.course.service.impl.CourseRegistrationServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public com.liferay.course.model.CourseRegistration addCourseRegistration(
		long groupId, long courseId, long userId) throws java.lang.Exception;

	public com.liferay.course.model.CourseRegistration changeCourseRegistrationStatus(
		long groupId, long id, int status) throws java.lang.Exception;

	public com.liferay.course.model.CourseRegistration deleteCourseRegistration(
		long groupId, long id) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.course.model.CourseRegistration> getAvailableCourseRegistrationsByUserId(
		long userId) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationByCourseIdAndStatus(
		long courseId, int status) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.course.model.CourseRegistration getCourseRegistrationById(
		long id) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.course.model.CourseRegistration getCourseRegistrationByUserIdAndCourseId(
		long userId, long courseId) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.course.model.CourseRegistration> getCourseRegistrationsByUserId(
		long userId) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isFullRegistered(long courseId) throws java.lang.Exception;

	public void updateStatusOfCourseRegistration(long id, int status)
		throws java.lang.Exception;
}