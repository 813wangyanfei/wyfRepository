package com.youngman.website.common.dao.support;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;


public class SqlParameter {
	private Map<String, Object> criteria = new HashMap<String, Object>();
	
	private SqlParameter() {
		
	}
	
	public static SqlParameter getSqlParameter() {
		return new SqlParameter();
	}
	
	public SqlParameter clear() {
		criteria.clear();
		return this;
	}
	
	public SqlParameter addQuery(String key, Object value) {
		criteria.put("query" + key.substring(0,1).toUpperCase() + key.substring(1), value);
		return this;
	}
	
	public SqlParameter addUpdate(String key, Object value) {
		criteria.put("update" + key.substring(0,1).toUpperCase() + key.substring(1), value);
		return this;
	}
	
	public SqlParameter addQueryNull(String key, Object value) {
		criteria.put("null" + key.substring(0,1).toUpperCase() + key.substring(1), value);
		return this;
	}
	
	public SqlParameter addQueryNotNull(String key, Object value) {
		criteria.put("notNull" + key.substring(0,1).toUpperCase() + key.substring(1), value);
		return this;
	}
	
	public SqlParameter addPageNo(long pageNo) {
		criteria.put("pageNo", pageNo);
		return this;
	}
	
	public SqlParameter addPageSize(long pageSize) {
		criteria.put("pageSize", pageSize);
		return this;
	}
	
	public SqlParameter addOrder(String column, Order order) {
		criteria.put("orderBy", column + " " + order.getCode());
		return this;
	}
	public SqlParameter addOrderMap(Map<String,Order> map) {
		  StringBuffer sb=new StringBuffer();
		 for (Entry<String, Order> entry : map.entrySet()) {
			   sb.append( entry.getKey()+" "+entry.getValue()+",");
		}
		 criteria.put("orderBy", sb.toString().substring(0, sb.toString().length()-1));
		return this;
	}
	public SqlParameter addOrderList(List<Map<String,Order>> list){
		StringBuffer sb=new StringBuffer();
		for (Map<String, Order> m : list) {
			for (Entry<String, Order> entry : m.entrySet()) {
				sb.append( entry.getKey()+" "+entry.getValue()+",");
			}
		}
		criteria.put("orderBy", sb.toString().substring(0, sb.toString().length()-1));
		
		return this;
	}
	public SqlParameter addStartDate(Date startDate) {
		criteria.put("startDate", startDate);
		return this;
	}
	
	public SqlParameter addEndDate(Date endDate) {
		criteria.put("endDate", endDate);
		return this;
	}
	
	public SqlParameter addFields(String[] fields) {
		if (fields != null) {
			criteria.put("fields", StringUtils.join(fields, ","));
		}
		return this;
	} 
	
	public Map<String, Object> getCriteria() {
		return criteria;
	}
}
