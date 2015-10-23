package com.spy.mvc.mybatis.test.service;

import java.util.Random;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spy.mvc.mybatis.common.Const;
import com.spy.mvc.mybatis.datasource.DataSourceContextHolder;
import com.spy.mvc.mybatis.datasource.annotation.Master;
import com.spy.mvc.mybatis.datasource.annotation.Slave;
import com.spy.mvc.mybatis.model.User;
import com.spy.mvc.mybatis.service.UserService;

/**
 * @author spy
 *
 * @datetime 2015年10月23日 下午1:12:32
 */
public class DynamicDataSourceTest extends BaseSpringTest {
	private final static Logger logger = LoggerFactory.getLogger(DynamicDataSourceTest.class);

	@Autowired
	private UserService userService;

	@Test
	public void insertSlaveDB() {
		// 向slave中插入数据
		DataSourceContextHolder.setContextType(Const.DATASOURCE_SLAVE);
		int ret = userService.saveUser(createUser());
		DataSourceContextHolder.removeContextType(); // 读写完后，最好清理下
		logger.debug("ret value {}", ret);
	}

	// 以下是注解方式

	@Test
	@Master
	public void insertMasterDB() {
		userService.saveUser(createUser());
	}

	@Test
	public void insertSlaveDB2() {
		userService.saveUser(createUser());
	}

	private User createUser() {
		User user = new User();
		Random random = new Random();
		user.setId(random.nextInt(1000));
		user.setName("cc");
		user.setUserCode("spy");
		user.setPassword("123");
		user.setAge(22);
		return user;
	}
}
