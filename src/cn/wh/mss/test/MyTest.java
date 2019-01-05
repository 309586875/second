package cn.wh.mss.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wh.mss.dao.IUserDao;
import cn.wh.mss.doamin.User;
import cn.wh.mss.web.controller.UserController;
import cn.wh.mss.web.service.IUserService;

public class MyTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println(ctx);
		UserController bean = ctx.getBean("myController", cn.wh.mss.web.controller.UserController.class);
		System.out.println(bean.query());
		
		User u = new User();
		u.setId(8);
		u.setAge(44);
		u.setName("my");
		System.out.println(bean.save(u));
	}
	
}
