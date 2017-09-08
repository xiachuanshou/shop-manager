package com.xialiu.shop.user.dto;

import java.io.Serializable;

public class UserDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4203182274918834803L;

	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 密码
	 */
	private String passwd;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "UserDto [userName=" + userName + ", passwd=" + passwd + "]";
	}
}
