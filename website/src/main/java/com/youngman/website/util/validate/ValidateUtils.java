package com.youngman.website.util.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * 验证工具类
 * @author yzzhouyalei@foxmail.com
 */
public class ValidateUtils {
	
	/**
	 * 判断当前请求是否为ajax
	 * @param request
	 * @return
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header))
			return true;
		else
			return false;
	}
	
	/**
	 * 手机号码验证
	 * @param mobile
	 * @return 正确/错误 ；true/false
	 */
	public static boolean  isMobile(String mobile){
		return mobile!=null&&!"".equals(mobile)&&mobile.length()==11?true:false;
	}
	/**
	 * email 验证
	 * @param email
	 * @return 正确/错误 ；true/false
	 */
	public static boolean  isEmail(String email){
		Pattern regex = Pattern.compile("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$");
		if(StringUtils.isNotBlank(email.trim())){
			return regex.matcher(email).matches();
		}else{
			return false;
		}
	}
	
	public static boolean isNotBlank(String key){
		if (key!=null&&!"".equals(key)&&!"".equals(key.trim())) {
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isDateTime(String time){
		Pattern pt = Pattern.compile("^(?:19|20)[0-9][0-9]-(?:(?:0[1-9])|(?:1[0-2]))-(?:(?:[0-2][1-9])|(?:[1-3][0-1])) (?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]:[0-5][0-9]$");
		return ValidateUtils.isNotBlank(time)?pt.matcher(time).matches():false;
	}
	
	public static boolean isIp(String ip){
		Pattern pt = Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}");
		return ValidateUtils.isNotBlank(ip)?pt.matcher(ip).matches():false;
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
}