package cn.wh.mss.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.wh.mss.dao.IUserDao;
import cn.wh.mss.doamin.User;

public class UserDaoImpl implements IUserDao {

	private JdbcTemplate jt;

	public void setJt(DataSource ds) {
		this.jt = new JdbcTemplate(ds);
		System.out.println("dataSource: " + ds);
		System.out.println("JdbcTemplate: " + jt);
	}

	// public void setJt(JdbcTemplate jt) {
	// this.jt = jt;
	// }

	@Override
	public int save(User u) {
		return jt.update("insert into student values(?,?,?,?)", u.getId(), u.getName(), u.getAge(), u.getHireDate());
	}

	@Override
	public List<User> query() {
		List<User> query = jt.query("select * from student", new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int num) throws SQLException {
				// System.out.println(num);
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setAge(rs.getInt("age"));
				u.setHireDate(rs.getDate("hireDate"));
				return u;
			}
		});

		return query;
	}

	@Override
	public boolean checkThis(String username, String password) {
		List<Integer> i = jt.query("select count(1) from student where name=? and age=?",
				new Object[] { username, password }, new RowMapper<Integer>() {
					@Override
					public Integer mapRow(ResultSet rs, int rownum) throws SQLException {
						return rs.getInt(1);
					}
				});
		return i.get(0) == 1 ? true : false;
	}

}
