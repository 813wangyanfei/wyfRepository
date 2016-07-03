package com.youngman.website.system.user.entity;

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
	private String userPhone;
	private String userEmail;
	private String userUuid;
	private String roleId;
	private String userType;

	// Constructors

	public String getUserPhone() {
		return userPhone;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

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