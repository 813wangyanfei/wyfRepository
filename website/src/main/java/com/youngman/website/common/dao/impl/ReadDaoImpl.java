package com.youngman.website.common.dao.impl;

import java.util.Collection;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.youngman.website.common.dao.ReadDao;
import com.youngman.website.common.dao.support.SqlParameter;


public class ReadDaoImpl extends SqlSessionDaoSupport implements ReadDao {

	@Override
	public <T> T read(Class<T> clazz, String sqlId, long parameter) {
		return this.getSqlSession().selectOne(sqlId, parameter);
	}

	@Override
	public <T> T read(Class<T> clazz, String sqlId, String parameter) {
		return this.getSqlSession().selectOne(sqlId, parameter);
	}

	@Override
	public <T> T read(Class<T> clazz, String sqlId, SqlParameter parameter) {
		return this.getSqlSession().selectOne(sqlId, parameter.getCriteria());
	}

	@Override
	public long count(Class<?> clazz, String sqlId, long parameter) {
		Long val = this.getSqlSession().selectOne(sqlId, parameter);
		return (val == null) ? 0 : val;
	}

	@Override
	public long count(Class<?> clazz, String sqlId, String parameter) {
		Long val = this.getSqlSession().selectOne(sqlId, parameter);
		return (val == null) ? 0 : val;
	}

	@Override
	public long count(Class<?> clazz, String sqlId, SqlParameter parameter) {
		Long val = this.getSqlSession().selectOne(sqlId, parameter.getCriteria());
		return (val == null) ? 0 : val;
	}

	@Override
	public <T> Collection<T> select(Class<T> clazz, String sqlId, long parameter) {
		return this.getSqlSession().selectList(sqlId, parameter);
	}

	@Override
	public <T> Collection<T> select(Class<T> clazz, String sqlId, String parameter) {
		return this.getSqlSession().selectList(sqlId, parameter);
	}

	@Override
	public <T> Collection<T> select(Class<T> clazz, String sqlId, SqlParameter parameter) {
		return this.getSqlSession().selectList(sqlId, parameter.getCriteria());
	}
	
	public <T, E> Map<T, E> selectMap(String sqlId, SqlParameter parameter, String mapKey) {
		return this.getSqlSession().selectMap(sqlId, parameter.getCriteria(), mapKey);
	}
	
	public <T, E> Map<T, E> selectMap(String sqlId, long parameter, String mapKey) {
		return this.getSqlSession().selectMap(sqlId, parameter, mapKey);
	}
	
	public <T, E> Map<T, E> selectMap(String sqlId, String parameter, String mapKey) {
		return this.getSqlSession().selectMap(sqlId, parameter, mapKey);
	}
}
