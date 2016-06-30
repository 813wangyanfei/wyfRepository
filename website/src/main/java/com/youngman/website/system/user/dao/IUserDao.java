package com.youngman.website.system.user.dao;

import com.youngman.website.common.base.Dao;
import com.youngman.website.system.user.model.User;

public interface IUserDao extends Dao<User> {
	/**
	 * 方法描述：查询在线用户数
	 */
	public int findOnLineCount();

	/**
	 * 方法描述：登录操作
	 * 
	 * @param uname
	 *            用户名
	 * @param upass
	 *            密码
	 * @return User 登录成功后的用户信息
	 */
	public User login(String uname, String upass);

	/**
	 * 方法描述：根据用户名查询用户，判断用户是否存在
	 * 
	 * @param name
	 *            用户名
	 * @return User 用户信息
	 */
	public User getByName(String name);
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
}
