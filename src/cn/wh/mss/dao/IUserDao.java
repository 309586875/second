package cn.wh.mss.dao;

import java.util.List;

import cn.wh.mss.doamin.User;

public interface IUserDao {
	
	public int save(User u);
	public List<User> query();
	public boolean checkThis(String username, String password);

}
