package com.youngman.website.common.dao.impl;

import java.util.Collection;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.youngman.website.common.dao.WriteDao;
import com.youngman.website.common.dao.support.SqlParameter;
import com.youngman.website.common.entity.Entity;


public class WriteDaoImpl extends SqlSessionDaoSupport implements WriteDao {

	@Override
	public int create(Class<?> clazz, final String sqlId, Entity t) {
		return this.getSqlSession().insert(sqlId, t);
	}

	@Override
	public int saveOrUpdate(Class<?> clazz, final String createSqlId, final String updateSqlId, Entity t) {
		int value = update(clazz, updateSqlId, t);
		if (value > 0) {
			return value;
		}
		return create(clazz, createSqlId, t);
	}

	@Override
	public int update(Class<?> clazz, final String sqlId, Entity t) {
		return getSqlSession().update(sqlId, t);
	}

	@Override
	public int update(Class<?> clazz, String sqlId, SqlParameter parameter) {
		return getSqlSession().update(sqlId, parameter.getCriteria());
	}

	@Override
	public int delete(Class<?> clazz, String sqlId, long parameter) {
		return getSqlSession().delete(sqlId, parameter);
	}

	@Override
	public int delete(Class<?> clazz, String sqlId, String parameter) {
		return getSqlSession().delete(sqlId, parameter);
	}

	@Override
	public int delete(Class<?> clazz, String sqlId, SqlParameter parameter) {
		return getSqlSession().delete(sqlId, parameter.getCriteria());
	}

	@Override
	public void batch(Class<?> clazz, final String sqlId, Collection<?> list) {
		this.getSqlSession().insert(sqlId, list);
	}

	@Override
	public int update(Class<?> clazz, String sqlId, long value) {
		return getSqlSession().update(sqlId, value);
	}

	@Override
	public int update(Class<?> clazz, String sqlId, String value) {
		return getSqlSession().update(sqlId, value);
	}

	@Override
	public int batchUpdate(Class<?> clazz, String sqlId, Collection<?> list) {
		return getSqlSession().update(sqlId, list);
	}
}
