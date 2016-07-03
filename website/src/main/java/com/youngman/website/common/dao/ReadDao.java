package com.youngman.website.common.dao;

import java.util.Collection;
import java.util.Map;

import com.youngman.website.common.dao.support.SqlParameter;


public interface ReadDao {

	public <T> T read(final Class<T> clazz, final String sqlId, final long parameter);
	
	public <T> T read(final Class<T> clazz, final String sqlId, final String parameter);
	
	public <T> T read(final Class<T> clazz, final String sqlId, final SqlParameter parameter);
	
	public long count(final Class<?> clazz, final String sqlId, final long parameter);
	
	public long count(final Class<?> clazz, final String sqlId, final String parameter);
	
	public long count(final Class<?> clazz, final String sqlId, final SqlParameter parameter);
	
	public <T> Collection<T> select(final Class<T> clazz, final String sqlId, final long parameter);
	
	public <T> Collection<T> select(final Class<T> clazz, final String sqlId, final String parameter);
	
	public <T> Collection<T> select(final Class<T> clazz, final String sqlId, final SqlParameter parameter);
	
	public <T, E> Map<T, E> selectMap(String sqlId, SqlParameter parameter, String mapKey);
	
	public <T, E> Map<T, E> selectMap(String sqlId, long parameter, String mapKey);
	
	public <T, E> Map<T, E> selectMap(String sqlId, String parameter, String mapKey);
}
