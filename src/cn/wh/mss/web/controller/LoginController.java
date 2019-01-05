package cn.wh.mss.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wh.mss.util.UserContext;
import cn.wh.mss.web.service.IUserService;

@Controller
public class LoginController {

	@Resource
	private IUserService userServi;

	// @RequestMapping("/login")
	// public String login(@RequestParam("user_name") String username,
	// @RequestParam("pass_word") String password,
	// HttpSession session) {
	// boolean b = userServi.checkThis(username, password);
	//
	// if (false == b) {
	// session.setAttribute("errMsg", "账号或密码错误");
	// return "redirect:/login.jsp";
	// }
	//
	// session.setAttribute("username", username);
	// return "redirect:/myTT/query2";
	// }

	@RequestMapping("/login")
	public String login(@RequestParam(value = "user_name", required = false) String username,
			@RequestParam(name = "pass_word", required = false) String password, HttpSession session) {
		System.out.println("LoginController.login()");
		try {
			userServi.checkThis(username, password);
		} catch (Exception e) {
			session.setAttribute("errMsg", e.getMessage());
			return "redirect:/login.jsp";
		}

		// session.setAttribute(UserContext.USER_IN_SESSION, UserContext.getUser());
		return "redirect:/myTT/query2";
	}
}
