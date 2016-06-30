package com.pjzc.framework.system.user.test;

import org.jboss.logging.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pjzc.framework.system.user.model.User;
import com.pjzc.framework.system.user.service.IUserService;

/**
*类说明
* @author 王艳飞   E-mail:813.wangyanfei@163.com
* @version 创建时间：2016年6月28日 下午7:34:46
* @version 1.0 
* @parameter  
* @since  
* @return
*/
public class UserTest {
	private static Logger log = Logger.getLogger(UserTest.class);
	/**
	 * @author wyf
	 */
	@SuppressWarnings("resource")
	@Test
	public void loginTest(){
		ApplicationContext applicationContext = null;
		applicationContext = new ClassPathXmlApplicationContext(new String[] { "classpath:applicationContext.xml" });
		User user = new User();
		user.setUserName("wangyanfei");
		user.setUserPwd("123");
		IUserService userService = (IUserService) applicationContext.getBean("userService");
		userService.addUser(user);
		log.info("添加数据成功");
	}
}
