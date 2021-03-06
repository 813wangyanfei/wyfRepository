package com.pjzc.framework.system.user.service;

import java.util.List;

import com.pjzc.framework.system.user.model.User;

public interface IUserService {

	public User findUserByLogin(User user);

	public List<User> findUserAll();

	public User findUser(int updateId);

	/**
	 * 
	 * 
	 * @param User
	 */
	public void updateUser(User user);

	public void deleteUser(User user);
	
	public void addUser(User user);
}
