package cn.wh.mss.web.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.wh.mss.dao.IUserDao;
import cn.wh.mss.doamin.User;
import cn.wh.mss.util.UserContext;
import cn.wh.mss.web.service.IUserService;

@Transactional
public class UserServiceImpl implements IUserService {

	private IUserDao userDao ;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public int save(User u) {
		return userDao.save(u);
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> query() {
		return userDao.query();
	}

//	@Override
//	public boolean checkThis(String username, String password) {
//		return userDao.checkThis(username, password);
//	}

	@Override
	@Transactional(readOnly=true)
	public void checkThis(String username, String password) {
		if(userDao.checkThis(username, password)==false) {
			UserContext.setUser(null);
			throw new RuntimeException("账号胡密码错误！");
		}
		
		User u = new User();
		u.setName(username);
		UserContext.setUser(u);
		
//		return true;
	}
}
