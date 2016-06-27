package com.pjzc.framework.common.base;

import java.io.Serializable;
import java.util.LinkedHashMap;

import com.pjzc.framework.common.util.QueryResult;

/**
 * 通用的数据层方法
 * 
 * @author mhsdong
 * 
 * @param <T>
 *            T对应的实体对象名称如：User
 */
public interface Dao<T> {
	/**
	 * sql插入数据
	 * 
	 * @param sql
	 * @return
	 */
	public boolean executeSql(String sql);

	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            实体对象
	 */
	public void save(T entity);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 *            实体对象
	 */
	public void update(T entity);

	/**
	 * 删除实体
	 * 
	 * @param entityid
	 *            实体标识
	 */
	public void delete(Serializable entityid);

	/**
	 * 获胜实体
	 * 
	 * @param entityid
	 *            实体标识
	 * @return 实体对象
	 */
	public T find(Serializable entityid);

	/**
	 * 获取实体的总记录数
	 * 
	 * @return 总记录数
	 */
	public long getCount();

	/**
	 * 分页获取所有记录
	 * 
	 * @return
	 */
	public QueryResult<T> getScrollData();

	/**
	 * 分页获取记录
	 * 
	 * @param firstResult
	 *            开始索引,如果输入值为-1,即获取全部数据
	 * @param maxResult
	 *            每页获取的记录数,如果输入值为-1,即获取全部数据
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult);

	/**
	 * 分页获取记录
	 * 
	 * @param firstResult
	 *            开始索引,如果输入值为-1,即获取全部数据
	 * @param maxResult
	 *            每页获取的记录数,如果输入值为-1,即获取全部数据
	 * @param orderby
	 *            排序,Key为排序属性,Value为asc/desc,如: LinkedHashMap<String, String> orderby = new
	 *            LinkedHashMap<String, String>(); orderby.put("email", "asc");
	 *            orderby.put("password", "desc");
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult, LinkedHashMap<String, String> orderby);

	/**
	 * 分页获取记录
	 * 
	 * @param firstResult
	 *            开始索引,如果输入值为-1,即获取全部数据
	 * @param maxResult
	 *            每页获取的记录数,如果输入值为-1,即获取全部数据
	 * @param where
	 *            条件语句,不带where关键字,条件语句参数 "o.username like :uname" LinkedHashMap<String, String>
	 *            params = new LinkedHashMap<String, String>(); params.put("uname", "%"+uname+"%");
	 * @param params
	 *            条件语句出现的位置参数值
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult, String where, LinkedHashMap<String, String> params);

	/**
	 * 分页获取记录
	 * 
	 * @param firstResult
	 *            开始索引,如果输入值为-1,即获取全部数据
	 * @param maxResult
	 *            每页获取的记录数,如果输入值为-1,即获取全部数据
	 * @param where
	 *            条件语句,不带where关键字,条件语句参数 "o.username like :uname" LinkedHashMap<String, String>
	 *            params = new LinkedHashMap<String, String>(); params.put("uname", "%"+uname+"%");
	 * @param orderby
	 *            排序,Key为排序属性,Value为asc/desc,如: LinkedHashMap<String, String> orderby = new
	 *            LinkedHashMap<String, String>(); orderby.put("email", "asc");
	 *            orderby.put("password", "desc");
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult, String where, LinkedHashMap<String, String> params, LinkedHashMap<String, String> orderby);

	public QueryResult<T> getSqlData(int firstResult, int maxResult, String listSql, String sqlCount);

	public boolean executeUpdateSql(final String sql);
}
