package com.spy.mvc.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spy.mvc.mybatis.model.User;

/**
 * 
 * @author spy
 *
 * @time 2015年10月20日 下午1:10:01
 */
public interface UserDAO {

	public User getUser(long id);

	public int addUser(User user);

	public int deleteUser(long id);

	public int updateUser(@Param(value = "id") long id, @Param(value = "password") String password);

	public List<User> searchUserByName(@Param(value = "name") String name);

}
