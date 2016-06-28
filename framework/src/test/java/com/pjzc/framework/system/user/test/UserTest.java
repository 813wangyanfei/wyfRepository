package com.pjzc.framework.system.user.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	
	/**
	 * @author wyf
	 */
	@Test
	public void loginTest(){
		ApplicationContext applicationContext = null;
		applicationContext = new ClassPathXmlApplicationContext(new String[] { "classpath:applicationContext.xml" });
		
	}
}
