package com.youngman.website.system.user.dao;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.shiro.authc.Account;
import org.springframework.stereotype.Repository;

import com.youngman.website.common.dao.ReadDao;
import com.youngman.website.common.dao.WriteDao;
import com.youngman.website.common.dao.support.SqlParameter;
import com.youngman.website.system.user.model.User;

@Repository
public class UserDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	
	public long create(User appointment) {
		return writeDao.create(User.class, "User_create", appointment);
	}

	public long totalCount(SqlParameter parameter) {
		return readDao.count(User.class, "User_count", parameter);
	}

	public Collection<Account> page(SqlParameter parameter) {
		return readDao.select(User.class, "User_page", parameter);
	}

	public Account read(SqlParameter parameter) {
		return readDao.read(User.class, "User_read", parameter);
	}

	public int delete(SqlParameter parameter) {
		return writeDao.delete(Account.class, "Account_delete", parameter);
	}

	public int update(SqlParameter parameter) {
		return writeDao.update(Account.class, "Account_update", parameter);
	}
	
	public int updatePwd(SqlParameter parameter) {
		return writeDao.update(Account.class, "Account_updatePwd", parameter);
	}
	public int Account_updatePhone(SqlParameter parameter) {
		return writeDao.update(Account.class, "Account_updatePhone", parameter);
	}
	
	
}
