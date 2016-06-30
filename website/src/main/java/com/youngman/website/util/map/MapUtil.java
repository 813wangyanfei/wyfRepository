package com.youngman.website.util.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 简化Map操作
 * 调用时Map<String, Object> page = MapUtil.getMapController().put("pageNo", 1).put("pageSize", 100).getMap();
 * @author yzzhouyalei@foxmail.com
 */
public class MapUtil {
	private Map<String, Object> criteria = new HashMap<String, Object>();
	private MapUtil(){}

	public static MapUtil getMapController() {
		return new MapUtil();
	}

	public MapUtil put(String key, Object value) {
		criteria.put(key, value);
		return this;
	}
	public Map<String,Object> getMap(){
		return criteria;
	}
}