package com.youngman.website.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
 
/**
 * Json工具类 封装的Gson相关操作
 * @author yzzhouyalei@foxmail.com
 */
public class JsonUtils {

	private static Gson gson = null;
	
	/**
	 * 通过单例获取gson
	 * @author yzzhouyalei@foxmail.com
	 * @Description: TODO 通过单例获取gson
	 * @throws
	 */
	public static Gson getGson(){
		if(gson==null){
			return new Gson();
		}
		return gson;
	}
	
	/**
	 * 把java对象转换为JSON
	 * @author yzzhouyalei@foxmail.com
	 * @Description: TODO 把java对象转换为JSON
	 * @throws
	 */
	public static String toJson(Object obj){
		return getGson().toJson(obj);
	}
	/**
	 * 返回全部的字段包括NULL值字段
	 * @author yzzhouyalei@foxmail.com
	 * @Description: TODO 返回全部的字段包括NULL值字段
	 * @throws
	 */
	public static String toJsonAll(Object obj){
		GsonBuilder gson = new GsonBuilder().serializeNulls();
		Gson g = gson.create();
		return g.toJson(obj);
	}
	
	/**
	 * 把JSON转换为java对象
	 * @author yzzhouyalei@foxmail.com
	 * @Description: TODO 把JSON转换为java对象
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	public static Object toObject(String str,TypeToken obj ){
		return getGson().fromJson(str, obj.getType());
	}
	
}
