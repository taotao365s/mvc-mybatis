package com.spy.mvc.mybatis.service;

import java.util.List;

import com.spy.mvc.mybatis.model.User;

/**
 * @author spy
 *
 * @datetime 2015年10月20日 下午1:18:02
 */
public interface UserService {

	public User getUserById(long id);

	public int addUser(User user);

	public int saveUser(User user);

	public int deleteUser(long id);

	public int tianjiaUser(User user);

	public int updateUser(long id, String password);

	public List<User> searchUserByName(String name);
}
