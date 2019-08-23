
package com.liferay.course.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

public class PostLoginAction extends Action {

	private boolean _isStaff(List<Role> roleList) {

		for (Role role : roleList) {
			if (role.getName().equalsIgnoreCase("Staff")) {

				return true;
			}
		}

		return false;
	}

	protected void doRun(final HttpServletRequest request, final HttpServletResponse response) throws SystemException,
		PortalException {

		String path = getPage(request);

		if (Validator.isBlank(path)) {

			HttpSession session = request.getSession();
			session.setAttribute(WebKeys.LAST_PATH, new LastPath(StringPool.BLANK, path));
		}
	}

	/**
	 * Returns custom landing page path after user login
	 *
	 * @param request
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private String getPage(final HttpServletRequest request) throws PortalException, SystemException {

		User user = PortalUtil.getUser(request);
		List<Role> roleList = user.getRoles();
		if (_isStaff(roleList)) {

			return "/web/courses/course-management";
		}
		else {

			return "/web/register/course-register";
		}

	}

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {

		try {

			doRun(request, response);
		}
		catch (Exception e) {

			throw new ActionException(e);
		}
	}
}
