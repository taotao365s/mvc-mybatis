package com.spy.mvc.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spy.mvc.mybatis.dao.UserDAO;
import com.spy.mvc.mybatis.model.User;
import com.spy.mvc.mybatis.service.UserService;

/**
 * user Serivce
 * 
 * @author spy
 *
 * @datetime 2015年10月20日 下午1:18:51
 */
@Service("UserSerivce")
public class UserSerivceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public User getUserById(long id) {
		return userDAO.getUser(id);
	}

	@Override
	public int saveUser(User user) {
		return userDAO.addUser(user);
	}

	@Override
	public int addUser(User user) {
		int a = userDAO.addUser(user);
		int b = 0;
		System.out.println(a / b);
		return a;
	}

	// test
	@Transactional
	public int tianjiaUser(User user) {
		int a = userDAO.addUser(user);
		int b = 0;

		System.out.println(a / b);// TODO

		return a;
	}

	@Override
	public int deleteUser(long id) {
		return userDAO.deleteUser(id);
	}

	@Override
	public int updateUser(long id, String password) {
		return userDAO.updateUser(id, password);
	}

	@Override
	public List<User> searchUserByName(String name) {
		return userDAO.searchUserByName(name);
	}
}
