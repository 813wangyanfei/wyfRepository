package com.youngman.website.common.entity;

import java.io.Serializable;

/**
 * 所有领域对象接口. 
 */
public interface IEntity<PK> extends Serializable {
	
	public long getId();
	
	public void setId(long id);
	
}
