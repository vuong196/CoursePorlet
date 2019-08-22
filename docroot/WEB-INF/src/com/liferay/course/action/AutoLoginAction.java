
package com.liferay.course.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AutoLogin;
import com.liferay.portal.security.auth.AutoLoginException;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class AutoLoginAction implements AutoLogin {

	@Override
	public String[] handleException(HttpServletRequest arg0, HttpServletResponse arg1, Exception arg2)
		throws AutoLoginException {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] login(HttpServletRequest request, HttpServletResponse response) throws AutoLoginException {

		String emailAddress = request.getParameter("emailAddress");
		if (emailAddress == null || emailAddress.isEmpty()) {

			return null;
		}
		try {

			long companyId = PortalUtil.getCompanyId(request);
			User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			List<Role> roleList = user.getRoles();

			if (_isStaff(roleList)) {
				request.setAttribute(AutoLogin.AUTO_LOGIN_REDIRECT, request.getContextPath()
					+ "/web/courses/course-management");
			}
			else {
				request.setAttribute(AutoLogin.AUTO_LOGIN_REDIRECT, request.getContextPath()
					+ "/web/register/course-register");
			}
		}
		catch (Exception e) {

			return null;
		}
		finally {

			return null;
		}
	}
	
	private boolean _isStaff(List<Role> roleList) {

		for (Role role : roleList) {
			if (role.getName().equalsIgnoreCase("Staff")) {
				
				return true;
			}
		}
		return false;
	}
}
