package com.youngman.website.util.basic;

import com.youngman.website.util.validate.ValidateUtils;

/**
 * String 工具类
 * @author yzzhouyalei@foxmail.com
 */
public class StringUtils {
	
	/**
	 * 把String数组转换成String字符串
	 * @author yzzhouyalei@foxmail.com
	 * @param String数组
	 * @return 拼接字符串 "a,b,c"
	 */
	public static String getArrayString(String[] strs){
		if (strs==null||strs.length<=0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (String str : strs) {
			sb.append(","+str);
		}
		String result = sb.toString();
		
		return result.startsWith(",")?result.substring(1):result;
	}
	
	/**
	 * 过滤空的json字符串,设置默认值{}
	 * @author yzzhouyalei@foxmail.com
	 * @param str json字符串
	 * @return 不为空的json字符串
	 */
	public static String filterNull(String str){
		if (!ValidateUtils.isNotBlank(str)||"null".equals(str.toLowerCase())) {
			return "{}";
		}
		return str;
	}
}