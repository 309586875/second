package cn.wh.mss.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.wh.mss.doamin.User;

public class UserContext {

	public static final String USER_IN_SESSION = "user_in_session";

	private static HttpSession getSession() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	}

	public static void setUser(User u) {
//		if (u == null) {
//			getSession().invalidate();
//		} else {
			getSession().setAttribute(USER_IN_SESSION, u);
//		}
	}

	public static User getUser() {
		return (User) getSession().getAttribute(USER_IN_SESSION);
	}

}
