package com.youngman.website.common.base;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.youngman.website.common.util.GenericsUtils;
import com.youngman.website.common.util.QueryResult;

@Repository
public abstract class DaoImpl<T> extends HibernateDaoSupport implements Dao<T> {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void init(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
		this.sessionFactory = sessionFactory;
	}
	
	
	/**
	 * 通过获取当前运行实例得到当前类
	 */
	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(getClass());

	public boolean executeSql(final String sql) {
		SQLQuery query =  sessionFactory.getCurrentSession().createSQLQuery(sql);
		return 1 == query.executeUpdate();
	}

	/**
	 * 删除实体
	 * 
	 * @param entityid
	 *            实体标识
	 */
	public void delete(Serializable entityid) {
		sessionFactory.getCurrentSession().delete(find(entityid));
	}

	/**
	 * 获胜实体
	 * 
	 * @param entityid
	 *            实体标识
	 * @return 实体对象
	 */
	@SuppressWarnings({ "unchecked" })
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public T find(final Serializable entityid) {
		return (T) sessionFactory.getCurrentSession().get(entityClass, entityid);
	}

	/**
	 * 获取实体的总记录数
	 * 
	 * @return 总记录数
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public long getCount() {
		return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from " + getEntityName(entityClass) + " o").uniqueResult();
	}

	/**
	 * 获取实体名称
	 * 
	 * @return
	 */
	protected static <E> String getEntityName(Class<E> entityClass) {
		String entityName = entityClass.getSimpleName();
		Entity entity = entityClass.getAnnotation(Entity.class);
		if (entity.name() != null && !"".equals(entity.name()))
			entityName = entity.name();
		return entityName;
	}

	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            实体对象
	 */
	public void save(T entity) {
		sessionFactory.getCurrentSession().persist(entity);
	}

	/**
	 * 更新实体
	 * 
	 * @param entity
	 *            实体对象
	 */
	public void update(T entity) {
		sessionFactory.getCurrentSession().merge(entity);
	}

	/**
	 * 分页获取所有记录
	 * 
	 * @return
	 */
	public QueryResult<T> getScrollData() {
		return getScrollData(-1, -1, null, null, null);
	}

	/**
	 * 分页获取记录
	 * 
	 * @param firstResult
	 *            开始索引,如果输入值为-1,即获取全部数据
	 * @param maxResult
	 *            每页获取的记录数,如果输入值为-1,即获取全部数据
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult) {
		return getScrollData(firstResult, maxResult, null, null, null);
	}

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
	public QueryResult<T> getScrollData(int firstResult, int maxResult, LinkedHashMap<String, String> orderby) {
		return getScrollData(firstResult, maxResult, null, null, orderby);
	}

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
	public QueryResult<T> getScrollData(int firstResult, int maxResult, String where, LinkedHashMap<String, String> params) {
		return getScrollData(firstResult, maxResult, where, params, null);
	}

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
	@SuppressWarnings({ "unchecked"})
	public QueryResult<T> getScrollData(int firstResult, int maxResult, String where, LinkedHashMap<String, String> params, LinkedHashMap<String, String> orderbyStr) {

		final int first = firstResult;
		final int max = maxResult;
		final LinkedHashMap<String, String> param = params;
		final String entityName = getEntityName(entityClass);
		final String whereql = where != null && !"".equals(where.trim()) ? " where " + where : "";
		final LinkedHashMap<String, String> orderby = orderbyStr;

		
		String strSql = " from " + entityName + " o" + whereql + buildOrderby(orderby);
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery(strSql);
		if (first != -1 && max != -1) {
			query.setFirstResult(first).setMaxResults(max);
		}
		setQueryParameter(query, param);
		// 获取列表集合
		List<T> listEntity = query.list();
		
		
		Query queryCount  = session.createQuery("select count(o) from " + entityName + " o" + whereql);
		setQueryParameter(queryCount, param);
		// 获取查询结果所有行条数
		Long count = (Long) queryCount.uniqueResult();

		QueryResult<T> qr = new QueryResult<T>();
		qr.setResultlist(listEntity);
		qr.setTotalrecord(count);
		return qr;
	}

	/**
	 * 设置查询参数
	 * 
	 * @param query
	 *            查询对象
	 * @param params
	 *            参数值
	 */
	public static void setQueryParameter(Query query, LinkedHashMap<String, String> params) {
		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				query.setString(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * 构建排序语句
	 * 
	 * @param orderby
	 *            排序属性与asc/desc, Key为属性,Value为asc/desc
	 * @return
	 */
	public static String buildOrderby(LinkedHashMap<String, String> orderby) {
		StringBuilder sb = new StringBuilder();
		if (orderby != null && !orderby.isEmpty()) {
			sb.append(" order by ");
			for (Map.Entry<String, String> entry : orderby.entrySet()) {
				sb.append("o.").append(entry.getKey()).append(" ").append(entry.getValue()).append(',');
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	@SuppressWarnings({ "unchecked" })
	public QueryResult<T> getSqlData(int firstResult, int maxResult, String listSql, String sqlCount) {

		final int first = firstResult;
		final int max = maxResult;
		final String strList = listSql;
		final String strCount = sqlCount;
		
		Session session = sessionFactory.getCurrentSession();

		QueryResult<T> qr = new QueryResult<T>();
		if (listSql != null) {
			
			
			SQLQuery query = session.createSQLQuery(strList);
			if (first != -1 && max != -1) {
				query.setFirstResult(first).setMaxResults(max);
			}
			query.addEntity(entityClass);
			List<T> listEntity =  query.list();
			
			qr.setResultlist(listEntity);
		}
		if (sqlCount != null) {
			// 获取查询结果所有行条数 null==str||"".equals(str)
			SQLQuery query = session.createSQLQuery(strCount);
			String count = query.uniqueResult() + "";
			qr.setResultString(count);
		}
		return qr;
	}

	/**
	 * 
	 * 执行删除或者修改的SQL语句
	 */
	public boolean executeUpdateSql(final String sql) {
       String re = "false";
		try {
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.executeUpdate();
			re = "true";
		} catch (HibernateException e) {
			re = "false";
		}
		/* 返回结果 */
		return Boolean.parseBoolean(re);
	}

	@Override
	protected HibernateTemplate createHibernateTemplate(
			SessionFactory sessionFactory) {
		return super.createHibernateTemplate(sessionFactory);
	}
}
