package com.youngman.website.common.dao;

import java.util.Collection;

import com.youngman.website.common.dao.support.SqlParameter;
import com.youngman.website.common.entity.Entity;

public interface WriteDao {
	
	public int create(final Class<?> clazz, final String sqlId, final Entity t);
	
	public int saveOrUpdate(final Class<?> clazz, final String createSqlId, final String updateSqlId, final Entity t);
	
	public int update(final Class<?> clazz, final String sqlId, final Entity t);
	
	public int update(final Class<?> clazz, final String sqlId, final long value);
	
	public int update(final Class<?> clazz, final String sqlId, final String value);
	
	public int update(final Class<?> clazz, final String sqlId, final SqlParameter parameter);
	
	public int delete(final Class<?> clazz, final String sqlId, final long value);
	
	public int delete(final Class<?> clazz, final String sqlId, final String value);
	
	public int delete(final Class<?> clazz, final String sqlId, final SqlParameter parameter);
	
	public void batch(final Class<?> clazz, final String sqlId, final Collection<?> list);
	
	public int batchUpdate(final Class<?> clazz, final String sqlId, final Collection<?> list);
}
