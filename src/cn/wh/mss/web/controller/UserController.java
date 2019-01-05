package cn.wh.mss.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wh.mss.doamin.User;
import cn.wh.mss.web.service.IUserService;

//@RestController
@Controller
@RequestMapping("/myTT")
public class UserController {

	@Autowired
	private IUserService userTool;

	public void setUserTool(IUserService userTool) {
		this.userTool = userTool;
	}

	@RequestMapping("/save")
	@ResponseBody
	public User save(User u) {
		System.out.println(u);
		userTool.save(u);
		return u;
	}

	@RequestMapping("/save2")
	public String save2(User u, HttpServletRequest req) {
		System.out.println(u);
		userTool.save(u);
		return "redirect:" + /*req.getContextPath() +*/ "/myTT/query2";
	}

	@RequestMapping("/input")
	public String input(Model model) {
		return "input2";
	}

	@RequestMapping("/query")
	public List<User> query() {
		return userTool.query();
	}

	@RequestMapping("/query2")
	public String query2(Model model) {
		System.out.println("UserController.query2()");
		model.addAttribute("emps", userTool.query());
		return "all";
	}

}
