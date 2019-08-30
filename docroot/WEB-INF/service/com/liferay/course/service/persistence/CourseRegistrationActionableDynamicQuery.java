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
import com.liferay.course.service.CourseRegistrationLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author ces
 * @generated
 */
public abstract class CourseRegistrationActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public CourseRegistrationActionableDynamicQuery() throws SystemException {
		setBaseLocalService(CourseRegistrationLocalServiceUtil.getService());
		setClass(CourseRegistration.class);

		setClassLoader(com.liferay.course.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("id");
	}
}