/**
 * 
 */
package com.youngman.website.system.user.dao.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.youngman.website.common.base.DaoImpl;
import com.youngman.website.system.user.dao.IUserDao;
import com.youngman.website.system.user.model.User;

/**
 * @author wangyanfei
 * 
 */
@Repository
public class UserDaoImpl extends DaoImpl<User> implements IUserDao {

	public int findOnLineCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public User login(String uname, String upass) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> param = new LinkedHashMap<String, String>();
		param.put("uname", uname);
//		param.put("upwd", new MD5().getMD5ofStr(upass));
		param.put("upwd", upass);
		List<User> user = this.getScrollData(-1,-1,"o.userName = :uname and o.userPwd = :upwd " ,param).getResultlist();
		if(user!=null && user.size()>0){
			return user.get(0);
		}
		return null;
	}

	public User getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addUser(User user){
		getSessionFactory().getCurrentSession().save(user);
	}

}
