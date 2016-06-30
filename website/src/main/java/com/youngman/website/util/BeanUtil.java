package com.youngman.website.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.youngman.website.util.validate.ValidateUtils;

/**
 * 自动封装实体
 * @author yzzhouyalei@foxmail.com
 * Copyright (c) 2016-6-3 by 北京盖勒克斯环保科技有限公司
 */
public class BeanUtil {

	/**
	 * 获取request中提交的参数,封装到实体
	 * @author yzzhouyalei@foxmail.com
	 * @param request HttpServletRequest
	 * @param t Class
	 * @return 封装后的对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(HttpServletRequest request, Class<T> object) {
		try {
			InputStream is = request.getInputStream();
			BufferedReader in2 = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String y = "";
			StringBuffer sb = new StringBuffer();
			while ((y = in2.readLine()) != null) {
				sb.append(y);
			}
			String json = "";
			if (!ValidateUtils.isNotBlank(sb.toString())) {
				json = "{}";
			}
			
			if (ValidateUtils.isNotBlank(sb.toString())) {
				json = sb.toString().replace("\"userId\":\"\"", "\"userId\":\"0\"");
			}
			
			Gson gson = new Gson();
			T o = (T) gson.fromJson(json,(Type) object);
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("参数不合法");
			return null;
		}
	}
	
	/**
	 * 将json字符串封装到实体, 
	 * 如果json字符串为空,实例化一个实体返回
	 * @author yzzhouyalei@foxmail.com
	 * @param json
	 * @param t Class
	 * @return 返回一个非空对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String json, Class<T> t) {
		try {
			Gson gson = new Gson();
			T o = (T) gson.fromJson(json,(Type) t);
			return o==null?(T)t.newInstance():o;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("json to bean -----参数不合法");
			return null;
		}
	}
}