package com.youngman.website.system.user.service;

import com.youngman.website.common.dao.support.SqlParameter;
import com.youngman.website.system.user.entity.User;

public interface IUserService {

	public User read(final Class<User> clazz, final String sqlId, final SqlParameter parameter);
	
	public long addUser(User user);
}
