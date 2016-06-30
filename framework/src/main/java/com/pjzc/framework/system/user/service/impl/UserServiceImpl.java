/**
 * 
 */
package com.pjzc.framework.system.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pjzc.framework.system.user.dao.IUserDao;
import com.pjzc.framework.system.user.model.User;
import com.pjzc.framework.system.user.service.IUserService;

/**
 * @author wangyanfei
 * 
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
	@Resource
	IUserDao userDaoImpl;

	public User findUserByLogin(User user) {
		return userDaoImpl.login(user.getUserName(), user.getUserPwd());
	}

	public void addUser(User user){
		userDaoImpl.addUser(user);
	}
	
	public List<User> findUserAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findUser(int updateId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}


}
