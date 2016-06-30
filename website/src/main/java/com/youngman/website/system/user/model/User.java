package com.youngman.website.system.user.model;

import java.sql.Date;

import com.youngman.website.common.entity.Entity;

public class User extends Entity {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8739621636790054779L;
	
	private String userName;
	private String userPwd;
	private String userPwd2;
	private Integer userLevel;
	private Integer isDelete;
	private Date createDate;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String userName, String userPwd, Integer userLevel) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.userLevel = userLevel;
	}


	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	/**
	 * @return the userPwd2
	 */
	public String getUserPwd2() {
		return userPwd2;
	}

	/**
	 * @param userPwd2
	 *            the userPwd2 to set
	 */
	public void setUserPwd2(String userPwd2) {
		this.userPwd2 = userPwd2;
	}

	public Integer getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

}