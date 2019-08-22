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

import com.liferay.course.NoSuchCourseRegistrationException;
import com.liferay.course.model.CourseRegistration;
import com.liferay.course.model.impl.CourseRegistrationImpl;
import com.liferay.course.model.impl.CourseRegistrationModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the course registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ces
 * @see CourseRegistrationPersistence
 * @see CourseRegistrationUtil
 * @generated
 */
public class CourseRegistrationPersistenceImpl extends BasePersistenceImpl<CourseRegistration>
	implements CourseRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseRegistrationUtil} to access the course registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			CourseRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the course registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseRegistration> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CourseRegistration> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CourseRegistration> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<CourseRegistration> list = (List<CourseRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseRegistration courseRegistration : list) {
				if (!Validator.equals(uuid, courseRegistration.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COURSEREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<CourseRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseRegistration>(list);
				}
				else {
					list = (List<CourseRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CourseRegistration findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (courseRegistration != null) {
			return courseRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseRegistrationException(msg.toString());
	}

	/**
	 * Returns the first course registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<CourseRegistration> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CourseRegistration findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (courseRegistration != null) {
			return courseRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseRegistrationException(msg.toString());
	}

	/**
	 * Returns the last course registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CourseRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CourseRegistration[] findByUuid_PrevAndNext(long id, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CourseRegistration[] array = new CourseRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, courseRegistration, uuid,
					orderByComparator, true);

			array[1] = courseRegistration;

			array[2] = getByUuid_PrevAndNext(session, courseRegistration, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseRegistration getByUuid_PrevAndNext(Session session,
		CourseRegistration courseRegistration, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSEREGISTRATION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the course registrations that the user has permission to view where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching course registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseRegistration> filterFindByUuid(String uuid)
		throws SystemException {
		return filterFindByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CourseRegistration> filterFindByUuid(String uuid, int start,
		int end) throws SystemException {
		return filterFindByUuid(uuid, start, end, null);
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
	@Override
	public List<CourseRegistration> filterFindByUuid(String uuid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUuid(uuid, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1_SQL);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3_SQL);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2_SQL);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CourseRegistrationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CourseRegistrationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CourseRegistrationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			if (bindUuid) {
				qPos.add(uuid);
			}

			return (List<CourseRegistration>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public CourseRegistration[] filterFindByUuid_PrevAndNext(long id,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUuid_PrevAndNext(id, uuid, orderByComparator);
		}

		CourseRegistration courseRegistration = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CourseRegistration[] array = new CourseRegistrationImpl[3];

			array[0] = filterGetByUuid_PrevAndNext(session, courseRegistration,
					uuid, orderByComparator, true);

			array[1] = courseRegistration;

			array[2] = filterGetByUuid_PrevAndNext(session, courseRegistration,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseRegistration filterGetByUuid_PrevAndNext(Session session,
		CourseRegistration courseRegistration, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1_SQL);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3_SQL);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2_SQL);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CourseRegistrationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CourseRegistrationImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CourseRegistrationImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (CourseRegistration courseRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseRegistration);
		}
	}

	/**
	 * Returns the number of course registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSEREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of course registrations that the user has permission to view where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching course registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByUuid(String uuid) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByUuid(uuid);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_COURSEREGISTRATION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1_SQL);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3_SQL);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2_SQL);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			if (bindUuid) {
				qPos.add(uuid);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "courseRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "courseRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(courseRegistration.uuid IS NULL OR courseRegistration.uuid = '')";
	private static final String _FINDER_COLUMN_UUID_UUID_1_SQL = "courseRegistration.uuid_ IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2_SQL = "courseRegistration.uuid_ = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3_SQL = "(courseRegistration.uuid_ IS NULL OR courseRegistration.uuid_ = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_COURSE_USER = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCourse_User",
			new String[] { Long.class.getName(), Long.class.getName() },
			CourseRegistrationModelImpl.COURSEID_COLUMN_BITMASK |
			CourseRegistrationModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSE_USER = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourse_User",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the course registration where courseId = &#63; and userId = &#63; or throws a {@link com.liferay.course.NoSuchCourseRegistrationException} if it could not be found.
	 *
	 * @param courseId the course ID
	 * @param userId the user ID
	 * @return the matching course registration
	 * @throws com.liferay.course.NoSuchCourseRegistrationException if a matching course registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration findByCourse_User(long courseId, long userId)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = fetchByCourse_User(courseId,
				userId);

		if (courseRegistration == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("courseId=");
			msg.append(courseId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCourseRegistrationException(msg.toString());
		}

		return courseRegistration;
	}

	/**
	 * Returns the course registration where courseId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param courseId the course ID
	 * @param userId the user ID
	 * @return the matching course registration, or <code>null</code> if a matching course registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration fetchByCourse_User(long courseId, long userId)
		throws SystemException {
		return fetchByCourse_User(courseId, userId, true);
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
	@Override
	public CourseRegistration fetchByCourse_User(long courseId, long userId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { courseId, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COURSE_USER,
					finderArgs, this);
		}

		if (result instanceof CourseRegistration) {
			CourseRegistration courseRegistration = (CourseRegistration)result;

			if ((courseId != courseRegistration.getCourseId()) ||
					(userId != courseRegistration.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_COURSEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_COURSE_USER_COURSEID_2);

			query.append(_FINDER_COLUMN_COURSE_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				qPos.add(userId);

				List<CourseRegistration> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSE_USER,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CourseRegistrationPersistenceImpl.fetchByCourse_User(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CourseRegistration courseRegistration = list.get(0);

					result = courseRegistration;

					cacheResult(courseRegistration);

					if ((courseRegistration.getCourseId() != courseId) ||
							(courseRegistration.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSE_USER,
							finderArgs, courseRegistration);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSE_USER,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CourseRegistration)result;
		}
	}

	/**
	 * Removes the course registration where courseId = &#63; and userId = &#63; from the database.
	 *
	 * @param courseId the course ID
	 * @param userId the user ID
	 * @return the course registration that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration removeByCourse_User(long courseId, long userId)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = findByCourse_User(courseId,
				userId);

		return remove(courseRegistration);
	}

	/**
	 * Returns the number of course registrations where courseId = &#63; and userId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param userId the user ID
	 * @return the number of matching course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourse_User(long courseId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSE_USER;

		Object[] finderArgs = new Object[] { courseId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COURSEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_COURSE_USER_COURSEID_2);

			query.append(_FINDER_COLUMN_COURSE_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COURSE_USER_COURSEID_2 = "courseRegistration.courseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSE_USER_USERID_2 = "courseRegistration.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER_STATUS =
		new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser_Status",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_STATUS =
		new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser_Status",
			new String[] { Long.class.getName(), Integer.class.getName() },
			CourseRegistrationModelImpl.USERID_COLUMN_BITMASK |
			CourseRegistrationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER_STATUS = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser_Status",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the course registrations where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseRegistration> findByUser_Status(long userId, int status)
		throws SystemException {
		return findByUser_Status(userId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CourseRegistration> findByUser_Status(long userId, int status,
		int start, int end) throws SystemException {
		return findByUser_Status(userId, status, start, end, null);
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
	@Override
	public List<CourseRegistration> findByUser_Status(long userId, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_STATUS;
			finderArgs = new Object[] { userId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER_STATUS;
			finderArgs = new Object[] {
					userId, status,
					
					start, end, orderByComparator
				};
		}

		List<CourseRegistration> list = (List<CourseRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseRegistration courseRegistration : list) {
				if ((userId != courseRegistration.getUserId()) ||
						(status != courseRegistration.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_COURSEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USER_STATUS_USERID_2);

			query.append(_FINDER_COLUMN_USER_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(status);

				if (!pagination) {
					list = (List<CourseRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseRegistration>(list);
				}
				else {
					list = (List<CourseRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CourseRegistration findByUser_Status_First(long userId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = fetchByUser_Status_First(userId,
				status, orderByComparator);

		if (courseRegistration != null) {
			return courseRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseRegistrationException(msg.toString());
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
	@Override
	public CourseRegistration fetchByUser_Status_First(long userId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<CourseRegistration> list = findByUser_Status(userId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CourseRegistration findByUser_Status_Last(long userId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = fetchByUser_Status_Last(userId,
				status, orderByComparator);

		if (courseRegistration != null) {
			return courseRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseRegistrationException(msg.toString());
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
	@Override
	public CourseRegistration fetchByUser_Status_Last(long userId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser_Status(userId, status);

		if (count == 0) {
			return null;
		}

		List<CourseRegistration> list = findByUser_Status(userId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CourseRegistration[] findByUser_Status_PrevAndNext(long id,
		long userId, int status, OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CourseRegistration[] array = new CourseRegistrationImpl[3];

			array[0] = getByUser_Status_PrevAndNext(session,
					courseRegistration, userId, status, orderByComparator, true);

			array[1] = courseRegistration;

			array[2] = getByUser_Status_PrevAndNext(session,
					courseRegistration, userId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseRegistration getByUser_Status_PrevAndNext(Session session,
		CourseRegistration courseRegistration, long userId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSEREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_USER_STATUS_USERID_2);

		query.append(_FINDER_COLUMN_USER_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the course registrations that the user has permission to view where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching course registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseRegistration> filterFindByUser_Status(long userId,
		int status) throws SystemException {
		return filterFindByUser_Status(userId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CourseRegistration> filterFindByUser_Status(long userId,
		int status, int start, int end) throws SystemException {
		return filterFindByUser_Status(userId, status, start, end, null);
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
	@Override
	public List<CourseRegistration> filterFindByUser_Status(long userId,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUser_Status(userId, status, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USER_STATUS_USERID_2);

		query.append(_FINDER_COLUMN_USER_STATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CourseRegistrationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CourseRegistrationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CourseRegistrationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			qPos.add(status);

			return (List<CourseRegistration>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public CourseRegistration[] filterFindByUser_Status_PrevAndNext(long id,
		long userId, int status, OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUser_Status_PrevAndNext(id, userId, status,
				orderByComparator);
		}

		CourseRegistration courseRegistration = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CourseRegistration[] array = new CourseRegistrationImpl[3];

			array[0] = filterGetByUser_Status_PrevAndNext(session,
					courseRegistration, userId, status, orderByComparator, true);

			array[1] = courseRegistration;

			array[2] = filterGetByUser_Status_PrevAndNext(session,
					courseRegistration, userId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseRegistration filterGetByUser_Status_PrevAndNext(
		Session session, CourseRegistration courseRegistration, long userId,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USER_STATUS_USERID_2);

		query.append(_FINDER_COLUMN_USER_STATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CourseRegistrationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CourseRegistrationImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CourseRegistrationImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course registrations where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser_Status(long userId, int status)
		throws SystemException {
		for (CourseRegistration courseRegistration : findByUser_Status(userId,
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseRegistration);
		}
	}

	/**
	 * Returns the number of course registrations where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUser_Status(long userId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER_STATUS;

		Object[] finderArgs = new Object[] { userId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COURSEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USER_STATUS_USERID_2);

			query.append(_FINDER_COLUMN_USER_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of course registrations that the user has permission to view where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching course registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByUser_Status(long userId, int status)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByUser_Status(userId, status);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_COURSEREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_USER_STATUS_USERID_2);

		query.append(_FINDER_COLUMN_USER_STATUS_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_USER_STATUS_USERID_2 = "courseRegistration.userId = ? AND ";
	private static final String _FINDER_COLUMN_USER_STATUS_STATUS_2 = "courseRegistration.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			CourseRegistrationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the course registrations where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseRegistration> findByStatus(int status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CourseRegistration> findByStatus(int status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
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
	@Override
	public List<CourseRegistration> findByStatus(int status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<CourseRegistration> list = (List<CourseRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseRegistration courseRegistration : list) {
				if ((status != courseRegistration.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COURSEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<CourseRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseRegistration>(list);
				}
				else {
					list = (List<CourseRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CourseRegistration findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = fetchByStatus_First(status,
				orderByComparator);

		if (courseRegistration != null) {
			return courseRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseRegistrationException(msg.toString());
	}

	/**
	 * Returns the first course registration in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration fetchByStatus_First(int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<CourseRegistration> list = findByStatus(status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CourseRegistration findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = fetchByStatus_Last(status,
				orderByComparator);

		if (courseRegistration != null) {
			return courseRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseRegistrationException(msg.toString());
	}

	/**
	 * Returns the last course registration in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration fetchByStatus_Last(int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<CourseRegistration> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CourseRegistration[] findByStatus_PrevAndNext(long id, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CourseRegistration[] array = new CourseRegistrationImpl[3];

			array[0] = getByStatus_PrevAndNext(session, courseRegistration,
					status, orderByComparator, true);

			array[1] = courseRegistration;

			array[2] = getByStatus_PrevAndNext(session, courseRegistration,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseRegistration getByStatus_PrevAndNext(Session session,
		CourseRegistration courseRegistration, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSEREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the course registrations that the user has permission to view where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching course registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseRegistration> filterFindByStatus(int status)
		throws SystemException {
		return filterFindByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<CourseRegistration> filterFindByStatus(int status, int start,
		int end) throws SystemException {
		return filterFindByStatus(status, start, end, null);
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
	@Override
	public List<CourseRegistration> filterFindByStatus(int status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByStatus(status, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CourseRegistrationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CourseRegistrationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CourseRegistrationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(status);

			return (List<CourseRegistration>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public CourseRegistration[] filterFindByStatus_PrevAndNext(long id,
		int status, OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByStatus_PrevAndNext(id, status, orderByComparator);
		}

		CourseRegistration courseRegistration = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CourseRegistration[] array = new CourseRegistrationImpl[3];

			array[0] = filterGetByStatus_PrevAndNext(session,
					courseRegistration, status, orderByComparator, true);

			array[1] = courseRegistration;

			array[2] = filterGetByStatus_PrevAndNext(session,
					courseRegistration, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseRegistration filterGetByStatus_PrevAndNext(
		Session session, CourseRegistration courseRegistration, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CourseRegistrationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CourseRegistrationImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CourseRegistrationImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course registrations where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(int status) throws SystemException {
		for (CourseRegistration courseRegistration : findByStatus(status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseRegistration);
		}
	}

	/**
	 * Returns the number of course registrations where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of course registrations that the user has permission to view where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching course registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByStatus(int status) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByStatus(status);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_COURSEREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "courseRegistration.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			CourseRegistrationModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the course registrations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseRegistration> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CourseRegistration> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<CourseRegistration> findByUserId(long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<CourseRegistration> list = (List<CourseRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseRegistration courseRegistration : list) {
				if ((userId != courseRegistration.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COURSEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<CourseRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseRegistration>(list);
				}
				else {
					list = (List<CourseRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CourseRegistration findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = fetchByUserId_First(userId,
				orderByComparator);

		if (courseRegistration != null) {
			return courseRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseRegistrationException(msg.toString());
	}

	/**
	 * Returns the first course registration in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CourseRegistration> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CourseRegistration findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = fetchByUserId_Last(userId,
				orderByComparator);

		if (courseRegistration != null) {
			return courseRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseRegistrationException(msg.toString());
	}

	/**
	 * Returns the last course registration in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<CourseRegistration> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CourseRegistration[] findByUserId_PrevAndNext(long id, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CourseRegistration[] array = new CourseRegistrationImpl[3];

			array[0] = getByUserId_PrevAndNext(session, courseRegistration,
					userId, orderByComparator, true);

			array[1] = courseRegistration;

			array[2] = getByUserId_PrevAndNext(session, courseRegistration,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseRegistration getByUserId_PrevAndNext(Session session,
		CourseRegistration courseRegistration, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSEREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the course registrations that the user has permission to view where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching course registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseRegistration> filterFindByUserId(long userId)
		throws SystemException {
		return filterFindByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<CourseRegistration> filterFindByUserId(long userId, int start,
		int end) throws SystemException {
		return filterFindByUserId(userId, start, end, null);
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
	@Override
	public List<CourseRegistration> filterFindByUserId(long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUserId(userId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CourseRegistrationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CourseRegistrationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CourseRegistrationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			return (List<CourseRegistration>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public CourseRegistration[] filterFindByUserId_PrevAndNext(long id,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUserId_PrevAndNext(id, userId, orderByComparator);
		}

		CourseRegistration courseRegistration = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CourseRegistration[] array = new CourseRegistrationImpl[3];

			array[0] = filterGetByUserId_PrevAndNext(session,
					courseRegistration, userId, orderByComparator, true);

			array[1] = courseRegistration;

			array[2] = filterGetByUserId_PrevAndNext(session,
					courseRegistration, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseRegistration filterGetByUserId_PrevAndNext(
		Session session, CourseRegistration courseRegistration, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CourseRegistrationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CourseRegistrationImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CourseRegistrationImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course registrations where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (CourseRegistration courseRegistration : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseRegistration);
		}
	}

	/**
	 * Returns the number of course registrations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of course registrations that the user has permission to view where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching course registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByUserId(long userId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByUserId(userId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_COURSEREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "courseRegistration.userId = ? AND courseRegistration.status!=-1";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID =
		new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseId",
			new String[] { Long.class.getName() },
			CourseRegistrationModelImpl.COURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the course registrations where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the matching course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseRegistration> findByCourseId(long courseId)
		throws SystemException {
		return findByCourseId(courseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<CourseRegistration> findByCourseId(long courseId, int start,
		int end) throws SystemException {
		return findByCourseId(courseId, start, end, null);
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
	@Override
	public List<CourseRegistration> findByCourseId(long courseId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID;
			finderArgs = new Object[] { courseId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID;
			finderArgs = new Object[] { courseId, start, end, orderByComparator };
		}

		List<CourseRegistration> list = (List<CourseRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseRegistration courseRegistration : list) {
				if ((courseId != courseRegistration.getCourseId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COURSEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				if (!pagination) {
					list = (List<CourseRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseRegistration>(list);
				}
				else {
					list = (List<CourseRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CourseRegistration findByCourseId_First(long courseId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = fetchByCourseId_First(courseId,
				orderByComparator);

		if (courseRegistration != null) {
			return courseRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseRegistrationException(msg.toString());
	}

	/**
	 * Returns the first course registration in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course registration, or <code>null</code> if a matching course registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration fetchByCourseId_First(long courseId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CourseRegistration> list = findByCourseId(courseId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CourseRegistration findByCourseId_Last(long courseId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = fetchByCourseId_Last(courseId,
				orderByComparator);

		if (courseRegistration != null) {
			return courseRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseRegistrationException(msg.toString());
	}

	/**
	 * Returns the last course registration in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course registration, or <code>null</code> if a matching course registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration fetchByCourseId_Last(long courseId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCourseId(courseId);

		if (count == 0) {
			return null;
		}

		List<CourseRegistration> list = findByCourseId(courseId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CourseRegistration[] findByCourseId_PrevAndNext(long id,
		long courseId, OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CourseRegistration[] array = new CourseRegistrationImpl[3];

			array[0] = getByCourseId_PrevAndNext(session, courseRegistration,
					courseId, orderByComparator, true);

			array[1] = courseRegistration;

			array[2] = getByCourseId_PrevAndNext(session, courseRegistration,
					courseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseRegistration getByCourseId_PrevAndNext(Session session,
		CourseRegistration courseRegistration, long courseId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSEREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(courseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the course registrations that the user has permission to view where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the matching course registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseRegistration> filterFindByCourseId(long courseId)
		throws SystemException {
		return filterFindByCourseId(courseId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CourseRegistration> filterFindByCourseId(long courseId,
		int start, int end) throws SystemException {
		return filterFindByCourseId(courseId, start, end, null);
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
	@Override
	public List<CourseRegistration> filterFindByCourseId(long courseId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCourseId(courseId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CourseRegistrationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CourseRegistrationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CourseRegistrationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(courseId);

			return (List<CourseRegistration>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public CourseRegistration[] filterFindByCourseId_PrevAndNext(long id,
		long courseId, OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCourseId_PrevAndNext(id, courseId, orderByComparator);
		}

		CourseRegistration courseRegistration = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CourseRegistration[] array = new CourseRegistrationImpl[3];

			array[0] = filterGetByCourseId_PrevAndNext(session,
					courseRegistration, courseId, orderByComparator, true);

			array[1] = courseRegistration;

			array[2] = filterGetByCourseId_PrevAndNext(session,
					courseRegistration, courseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseRegistration filterGetByCourseId_PrevAndNext(
		Session session, CourseRegistration courseRegistration, long courseId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CourseRegistrationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CourseRegistrationImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CourseRegistrationImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(courseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course registrations where courseId = &#63; from the database.
	 *
	 * @param courseId the course ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseId(long courseId) throws SystemException {
		for (CourseRegistration courseRegistration : findByCourseId(courseId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseRegistration);
		}
	}

	/**
	 * Returns the number of course registrations where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the number of matching course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourseId(long courseId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEID;

		Object[] finderArgs = new Object[] { courseId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of course registrations that the user has permission to view where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the number of matching course registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByCourseId(long courseId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByCourseId(courseId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_COURSEREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(courseId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 = "courseRegistration.courseId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSE_STATUS =
		new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourse_Status",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSE_STATUS =
		new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CourseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourse_Status",
			new String[] { Long.class.getName(), Integer.class.getName() },
			CourseRegistrationModelImpl.COURSEID_COLUMN_BITMASK |
			CourseRegistrationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSE_STATUS = new FinderPath(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourse_Status",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the course registrations where courseId = &#63; and status = &#63;.
	 *
	 * @param courseId the course ID
	 * @param status the status
	 * @return the matching course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseRegistration> findByCourse_Status(long courseId,
		int status) throws SystemException {
		return findByCourse_Status(courseId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CourseRegistration> findByCourse_Status(long courseId,
		int status, int start, int end) throws SystemException {
		return findByCourse_Status(courseId, status, start, end, null);
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
	@Override
	public List<CourseRegistration> findByCourse_Status(long courseId,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSE_STATUS;
			finderArgs = new Object[] { courseId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSE_STATUS;
			finderArgs = new Object[] {
					courseId, status,
					
					start, end, orderByComparator
				};
		}

		List<CourseRegistration> list = (List<CourseRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseRegistration courseRegistration : list) {
				if ((courseId != courseRegistration.getCourseId()) ||
						(status != courseRegistration.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_COURSEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_COURSE_STATUS_COURSEID_2);

			query.append(_FINDER_COLUMN_COURSE_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				qPos.add(status);

				if (!pagination) {
					list = (List<CourseRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseRegistration>(list);
				}
				else {
					list = (List<CourseRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CourseRegistration findByCourse_Status_First(long courseId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = fetchByCourse_Status_First(courseId,
				status, orderByComparator);

		if (courseRegistration != null) {
			return courseRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseRegistrationException(msg.toString());
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
	@Override
	public CourseRegistration fetchByCourse_Status_First(long courseId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<CourseRegistration> list = findByCourse_Status(courseId, status,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CourseRegistration findByCourse_Status_Last(long courseId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = fetchByCourse_Status_Last(courseId,
				status, orderByComparator);

		if (courseRegistration != null) {
			return courseRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseRegistrationException(msg.toString());
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
	@Override
	public CourseRegistration fetchByCourse_Status_Last(long courseId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCourse_Status(courseId, status);

		if (count == 0) {
			return null;
		}

		List<CourseRegistration> list = findByCourse_Status(courseId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CourseRegistration[] findByCourse_Status_PrevAndNext(long id,
		long courseId, int status, OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CourseRegistration[] array = new CourseRegistrationImpl[3];

			array[0] = getByCourse_Status_PrevAndNext(session,
					courseRegistration, courseId, status, orderByComparator,
					true);

			array[1] = courseRegistration;

			array[2] = getByCourse_Status_PrevAndNext(session,
					courseRegistration, courseId, status, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseRegistration getByCourse_Status_PrevAndNext(
		Session session, CourseRegistration courseRegistration, long courseId,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSEREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_COURSE_STATUS_COURSEID_2);

		query.append(_FINDER_COLUMN_COURSE_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(courseId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the course registrations that the user has permission to view where courseId = &#63; and status = &#63;.
	 *
	 * @param courseId the course ID
	 * @param status the status
	 * @return the matching course registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseRegistration> filterFindByCourse_Status(long courseId,
		int status) throws SystemException {
		return filterFindByCourse_Status(courseId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CourseRegistration> filterFindByCourse_Status(long courseId,
		int status, int start, int end) throws SystemException {
		return filterFindByCourse_Status(courseId, status, start, end, null);
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
	@Override
	public List<CourseRegistration> filterFindByCourse_Status(long courseId,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCourse_Status(courseId, status, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COURSE_STATUS_COURSEID_2);

		query.append(_FINDER_COLUMN_COURSE_STATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CourseRegistrationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CourseRegistrationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CourseRegistrationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(courseId);

			qPos.add(status);

			return (List<CourseRegistration>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public CourseRegistration[] filterFindByCourse_Status_PrevAndNext(long id,
		long courseId, int status, OrderByComparator orderByComparator)
		throws NoSuchCourseRegistrationException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCourse_Status_PrevAndNext(id, courseId, status,
				orderByComparator);
		}

		CourseRegistration courseRegistration = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CourseRegistration[] array = new CourseRegistrationImpl[3];

			array[0] = filterGetByCourse_Status_PrevAndNext(session,
					courseRegistration, courseId, status, orderByComparator,
					true);

			array[1] = courseRegistration;

			array[2] = filterGetByCourse_Status_PrevAndNext(session,
					courseRegistration, courseId, status, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseRegistration filterGetByCourse_Status_PrevAndNext(
		Session session, CourseRegistration courseRegistration, long courseId,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COURSE_STATUS_COURSEID_2);

		query.append(_FINDER_COLUMN_COURSE_STATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CourseRegistrationModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CourseRegistrationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CourseRegistrationImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CourseRegistrationImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(courseId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course registrations where courseId = &#63; and status = &#63; from the database.
	 *
	 * @param courseId the course ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourse_Status(long courseId, int status)
		throws SystemException {
		for (CourseRegistration courseRegistration : findByCourse_Status(
				courseId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseRegistration);
		}
	}

	/**
	 * Returns the number of course registrations where courseId = &#63; and status = &#63;.
	 *
	 * @param courseId the course ID
	 * @param status the status
	 * @return the number of matching course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourse_Status(long courseId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSE_STATUS;

		Object[] finderArgs = new Object[] { courseId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COURSEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_COURSE_STATUS_COURSEID_2);

			query.append(_FINDER_COLUMN_COURSE_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of course registrations that the user has permission to view where courseId = &#63; and status = &#63;.
	 *
	 * @param courseId the course ID
	 * @param status the status
	 * @return the number of matching course registrations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByCourse_Status(long courseId, int status)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByCourse_Status(courseId, status);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_COURSEREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_COURSE_STATUS_COURSEID_2);

		query.append(_FINDER_COLUMN_COURSE_STATUS_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CourseRegistration.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(courseId);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_COURSE_STATUS_COURSEID_2 = "courseRegistration.courseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSE_STATUS_STATUS_2 = "courseRegistration.status = ?";

	public CourseRegistrationPersistenceImpl() {
		setModelClass(CourseRegistration.class);
	}

	/**
	 * Caches the course registration in the entity cache if it is enabled.
	 *
	 * @param courseRegistration the course registration
	 */
	@Override
	public void cacheResult(CourseRegistration courseRegistration) {
		EntityCacheUtil.putResult(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationImpl.class, courseRegistration.getPrimaryKey(),
			courseRegistration);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSE_USER,
			new Object[] {
				courseRegistration.getCourseId(), courseRegistration.getUserId()
			}, courseRegistration);

		courseRegistration.resetOriginalValues();
	}

	/**
	 * Caches the course registrations in the entity cache if it is enabled.
	 *
	 * @param courseRegistrations the course registrations
	 */
	@Override
	public void cacheResult(List<CourseRegistration> courseRegistrations) {
		for (CourseRegistration courseRegistration : courseRegistrations) {
			if (EntityCacheUtil.getResult(
						CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						CourseRegistrationImpl.class,
						courseRegistration.getPrimaryKey()) == null) {
				cacheResult(courseRegistration);
			}
			else {
				courseRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all course registrations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseRegistrationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseRegistrationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course registration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseRegistration courseRegistration) {
		EntityCacheUtil.removeResult(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationImpl.class, courseRegistration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(courseRegistration);
	}

	@Override
	public void clearCache(List<CourseRegistration> courseRegistrations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CourseRegistration courseRegistration : courseRegistrations) {
			EntityCacheUtil.removeResult(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				CourseRegistrationImpl.class, courseRegistration.getPrimaryKey());

			clearUniqueFindersCache(courseRegistration);
		}
	}

	protected void cacheUniqueFindersCache(
		CourseRegistration courseRegistration) {
		if (courseRegistration.isNew()) {
			Object[] args = new Object[] {
					courseRegistration.getCourseId(),
					courseRegistration.getUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSE_USER, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSE_USER, args,
				courseRegistration);
		}
		else {
			CourseRegistrationModelImpl courseRegistrationModelImpl = (CourseRegistrationModelImpl)courseRegistration;

			if ((courseRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COURSE_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseRegistration.getCourseId(),
						courseRegistration.getUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSE_USER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSE_USER,
					args, courseRegistration);
			}
		}
	}

	protected void clearUniqueFindersCache(
		CourseRegistration courseRegistration) {
		CourseRegistrationModelImpl courseRegistrationModelImpl = (CourseRegistrationModelImpl)courseRegistration;

		Object[] args = new Object[] {
				courseRegistration.getCourseId(), courseRegistration.getUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSE_USER, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSE_USER, args);

		if ((courseRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COURSE_USER.getColumnBitmask()) != 0) {
			args = new Object[] {
					courseRegistrationModelImpl.getOriginalCourseId(),
					courseRegistrationModelImpl.getOriginalUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSE_USER, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSE_USER, args);
		}
	}

	/**
	 * Creates a new course registration with the primary key. Does not add the course registration to the database.
	 *
	 * @param id the primary key for the new course registration
	 * @return the new course registration
	 */
	@Override
	public CourseRegistration create(long id) {
		CourseRegistration courseRegistration = new CourseRegistrationImpl();

		courseRegistration.setNew(true);
		courseRegistration.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		courseRegistration.setUuid(uuid);

		return courseRegistration;
	}

	/**
	 * Removes the course registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the course registration
	 * @return the course registration that was removed
	 * @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration remove(long id)
		throws NoSuchCourseRegistrationException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the course registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course registration
	 * @return the course registration that was removed
	 * @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration remove(Serializable primaryKey)
		throws NoSuchCourseRegistrationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CourseRegistration courseRegistration = (CourseRegistration)session.get(CourseRegistrationImpl.class,
					primaryKey);

			if (courseRegistration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(courseRegistration);
		}
		catch (NoSuchCourseRegistrationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CourseRegistration removeImpl(
		CourseRegistration courseRegistration) throws SystemException {
		courseRegistration = toUnwrappedModel(courseRegistration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(courseRegistration)) {
				courseRegistration = (CourseRegistration)session.get(CourseRegistrationImpl.class,
						courseRegistration.getPrimaryKeyObj());
			}

			if (courseRegistration != null) {
				session.delete(courseRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (courseRegistration != null) {
			clearCache(courseRegistration);
		}

		return courseRegistration;
	}

	@Override
	public CourseRegistration updateImpl(
		com.liferay.course.model.CourseRegistration courseRegistration)
		throws SystemException {
		courseRegistration = toUnwrappedModel(courseRegistration);

		boolean isNew = courseRegistration.isNew();

		CourseRegistrationModelImpl courseRegistrationModelImpl = (CourseRegistrationModelImpl)courseRegistration;

		if (Validator.isNull(courseRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			courseRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (courseRegistration.isNew()) {
				session.save(courseRegistration);

				courseRegistration.setNew(false);
			}
			else {
				session.merge(courseRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((courseRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseRegistrationModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { courseRegistrationModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((courseRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseRegistrationModelImpl.getOriginalUserId(),
						courseRegistrationModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_STATUS,
					args);

				args = new Object[] {
						courseRegistrationModelImpl.getUserId(),
						courseRegistrationModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_STATUS,
					args);
			}

			if ((courseRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseRegistrationModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { courseRegistrationModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((courseRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseRegistrationModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { courseRegistrationModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((courseRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseRegistrationModelImpl.getOriginalCourseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);

				args = new Object[] { courseRegistrationModelImpl.getCourseId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);
			}

			if ((courseRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSE_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseRegistrationModelImpl.getOriginalCourseId(),
						courseRegistrationModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSE_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSE_STATUS,
					args);

				args = new Object[] {
						courseRegistrationModelImpl.getCourseId(),
						courseRegistrationModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSE_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSE_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CourseRegistrationImpl.class, courseRegistration.getPrimaryKey(),
			courseRegistration);

		clearUniqueFindersCache(courseRegistration);
		cacheUniqueFindersCache(courseRegistration);

		return courseRegistration;
	}

	protected CourseRegistration toUnwrappedModel(
		CourseRegistration courseRegistration) {
		if (courseRegistration instanceof CourseRegistrationImpl) {
			return courseRegistration;
		}

		CourseRegistrationImpl courseRegistrationImpl = new CourseRegistrationImpl();

		courseRegistrationImpl.setNew(courseRegistration.isNew());
		courseRegistrationImpl.setPrimaryKey(courseRegistration.getPrimaryKey());

		courseRegistrationImpl.setUuid(courseRegistration.getUuid());
		courseRegistrationImpl.setId(courseRegistration.getId());
		courseRegistrationImpl.setCourseId(courseRegistration.getCourseId());
		courseRegistrationImpl.setUserId(courseRegistration.getUserId());
		courseRegistrationImpl.setStatus(courseRegistration.getStatus());

		return courseRegistrationImpl;
	}

	/**
	 * Returns the course registration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course registration
	 * @return the course registration
	 * @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseRegistrationException, SystemException {
		CourseRegistration courseRegistration = fetchByPrimaryKey(primaryKey);

		if (courseRegistration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return courseRegistration;
	}

	/**
	 * Returns the course registration with the primary key or throws a {@link com.liferay.course.NoSuchCourseRegistrationException} if it could not be found.
	 *
	 * @param id the primary key of the course registration
	 * @return the course registration
	 * @throws com.liferay.course.NoSuchCourseRegistrationException if a course registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration findByPrimaryKey(long id)
		throws NoSuchCourseRegistrationException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the course registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course registration
	 * @return the course registration, or <code>null</code> if a course registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CourseRegistration courseRegistration = (CourseRegistration)EntityCacheUtil.getResult(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				CourseRegistrationImpl.class, primaryKey);

		if (courseRegistration == _nullCourseRegistration) {
			return null;
		}

		if (courseRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				courseRegistration = (CourseRegistration)session.get(CourseRegistrationImpl.class,
						primaryKey);

				if (courseRegistration != null) {
					cacheResult(courseRegistration);
				}
				else {
					EntityCacheUtil.putResult(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						CourseRegistrationImpl.class, primaryKey,
						_nullCourseRegistration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CourseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					CourseRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return courseRegistration;
	}

	/**
	 * Returns the course registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the course registration
	 * @return the course registration, or <code>null</code> if a course registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseRegistration fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the course registrations.
	 *
	 * @return the course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseRegistration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CourseRegistration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<CourseRegistration> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CourseRegistration> list = (List<CourseRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSEREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSEREGISTRATION;

				if (pagination) {
					sql = sql.concat(CourseRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CourseRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseRegistration>(list);
				}
				else {
					list = (List<CourseRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the course registrations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CourseRegistration courseRegistration : findAll()) {
			remove(courseRegistration);
		}
	}

	/**
	 * Returns the number of course registrations.
	 *
	 * @return the number of course registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COURSEREGISTRATION);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the course registration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.course.model.CourseRegistration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CourseRegistration>> listenersList = new ArrayList<ModelListener<CourseRegistration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CourseRegistration>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CourseRegistrationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COURSEREGISTRATION = "SELECT courseRegistration FROM CourseRegistration courseRegistration";
	private static final String _SQL_SELECT_COURSEREGISTRATION_WHERE = "SELECT courseRegistration FROM CourseRegistration courseRegistration WHERE ";
	private static final String _SQL_COUNT_COURSEREGISTRATION = "SELECT COUNT(courseRegistration) FROM CourseRegistration courseRegistration";
	private static final String _SQL_COUNT_COURSEREGISTRATION_WHERE = "SELECT COUNT(courseRegistration) FROM CourseRegistration courseRegistration WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "courseRegistration.id";
	private static final String _FILTER_SQL_SELECT_COURSEREGISTRATION_WHERE = "SELECT DISTINCT {courseRegistration.*} FROM CourseRegistration courseRegistration WHERE ";
	private static final String _FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {CourseRegistration.*} FROM (SELECT DISTINCT courseRegistration.id FROM CourseRegistration courseRegistration WHERE ";
	private static final String _FILTER_SQL_SELECT_COURSEREGISTRATION_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN CourseRegistration ON TEMP_TABLE.id = CourseRegistration.id";
	private static final String _FILTER_SQL_COUNT_COURSEREGISTRATION_WHERE = "SELECT COUNT(DISTINCT courseRegistration.id) AS COUNT_VALUE FROM CourseRegistration courseRegistration WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "courseRegistration";
	private static final String _FILTER_ENTITY_TABLE = "CourseRegistration";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courseRegistration.";
	private static final String _ORDER_BY_ENTITY_TABLE = "CourseRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CourseRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CourseRegistration exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CourseRegistrationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static CourseRegistration _nullCourseRegistration = new CourseRegistrationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CourseRegistration> toCacheModel() {
				return _nullCourseRegistrationCacheModel;
			}
		};

	private static CacheModel<CourseRegistration> _nullCourseRegistrationCacheModel =
		new CacheModel<CourseRegistration>() {
			@Override
			public CourseRegistration toEntityModel() {
				return _nullCourseRegistration;
			}
		};
}