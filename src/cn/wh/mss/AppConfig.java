package cn.wh.mss;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

import cn.wh.mss.dao.IUserDao;
import cn.wh.mss.dao.impl.UserDaoImpl;
import cn.wh.mss.web.service.impl.UserServiceImpl;

@Configuration
//@ComponentScan(basePackages= {"cn.wh.mss", "cn.wh.mss.web.controller"})
@ComponentScan(basePackages="cn.wh.mss")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class AppConfig {

	@Value("${driverClassName}")
	private String driverClass;
	@Value("${url}")
	private String jdbcUrl;
	@Value("${db.username}")
	private String username;
	@Value("${password}")
	private String password;

	@Bean
	public DataSource dataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driverClass);
		ds.setUrl(jdbcUrl);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	
	@Bean
	public UserDaoImpl userDao(DataSource ds) {
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.setJt(ds);
		return userDao;
	}
	
	@Bean
	public UserServiceImpl userService(IUserDao usedao) {
		UserServiceImpl pl = new UserServiceImpl();
		pl.setUserDao(usedao);
		return pl;
	}
	
	@Bean
	public DataSourceTransactionManager txManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}

}
