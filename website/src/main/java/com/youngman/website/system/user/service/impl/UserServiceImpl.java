/**
 * 
 */
package com.youngman.website.system.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youngman.website.common.dao.support.SqlParameter;
import com.youngman.website.system.user.dao.UserDao;
import com.youngman.website.system.user.entity.User;
import com.youngman.website.system.user.service.IUserService;

/**
 * @author wangyanfei
 * 
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
	@Resource
	UserDao userDao;

	
	public long addUser(User user){
		return userDao.create(user);
	}
	
	@Override
	public User read(Class<User> clazz, String sqlId, SqlParameter parameter) {
		// TODO Auto-generated method stub
		return userDao.read(parameter);
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
