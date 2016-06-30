package com.youngman.website.common.entity;

import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.youngman.website.common.entity.validate.ValidateUtils;


/**
 * 所有领域对象的超类.
 * 默认实现了主键、创建时间、最后更新时间三个字段.
 */
public class Entity implements IEntity<String> {
	private static final long serialVersionUID = 1L;
	protected long id;			//主键
	protected String tableName;	//表名
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
 
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	public Map<String, String> validate() {
		return ValidateUtils.validate(this);
	}
}
