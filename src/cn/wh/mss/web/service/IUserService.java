package cn.wh.mss.web.service;

import java.util.List;

import cn.wh.mss.doamin.User;

public interface IUserService {

	public int save(User u);
	
	public List<User> query();

	public void checkThis(String username, String password);
}
