package cn.wh.mss.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import cn.wh.mss.util.UserContext;

//@Component
public class CheckLoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("CheckLoginInterceptor.preHandle()");

		if (UserContext.getUser() == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return false;
		}

		return true;
	}
}
