package com.spy.mvc.mybatis.test.service;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.context.ContextLoader;

import com.spy.mvc.mybatis.dao.UserDAO;
import com.spy.mvc.mybatis.model.User;
import com.spy.mvc.mybatis.service.UserService;
import com.spy.mvc.mybatis.utils.SpringContextUtil;

/**
 * @author spy
 *
 * @datetime 2015年10月20日 下午1:47:10
 */
public class UserServiceTest extends BaseSpringTest {
	private final static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserDAO userDAO;

	@Test
	public void getUser() {
		User user = userService.getUserById(1);

		logger.debug(user.toString());
	}

	@Test
	// @Transactional
	// 在Text Context上，会进行事务回滚
	public void addUser() throws Exception {
		User user = createUser();

		logger.debug("return value {}", userService.addUser(user));
		// throw new Exception("asdf");// 测试事务
	}

	@Test
	public void tianjiaUser() {
		User user = createUser();
		logger.debug("return value {}", userService.tianjiaUser(user));
	}

	@Test
	public void deleteUser() {
		userService.deleteUser(999999);
	}

	// 编程式控制事务

	@Test
	public void manualControlTransaction() throws Exception {

		DataSourceTransactionManager txManager = (DataSourceTransactionManager) ctx.getBean("transactionManager");
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = txManager.getTransaction(def);
		try {
			User user = createUser();
			userDAO.addUser(user);
		} catch (Exception ex) {
			txManager.rollback(status);
			throw ex;
		}
		txManager.commit(status);
	}

	@Test
	public void spring() {
		// 这些只适用于web
		// null, 不能再测试类中这样使用
		System.out.println(ContextLoader.getCurrentWebApplicationContext());
		// null
		System.out.println(SpringContextUtil.getApplicationContext());
	}

	@Test
	@Transactional
	// 业务不纯
	public void compositeOperation() {
		User user1 = createUser();
		User user2 = createUser();
		userService.saveUser(user1);
		userService.addUser(user2);
	}

	@Test
	public void updateUser() {
		userService.updateUser(1, "asdfasdf");
	}

	@Test
	public void searchUser() {
		List<User> users = userService.searchUserByName("cc");
		if (users == null) {
			System.out.println("user is null");
		}
		for (int i = 0, j = users.size(); i < j; i++) {
			User user = users.get(i);
			System.out.println(user);
		}

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
