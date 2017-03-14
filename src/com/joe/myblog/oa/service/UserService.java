package com.joe.myblog.oa.service;

import com.joe.myblog.oa.po.TAdmin;

public interface UserService {

	/**
	* Title: UserService.java
	* Description: 用户登录
	* @param baseUser
	* @return
	* @author HuangJian
	* @date 2017年3月11日
	*/
	public int userLogin(TAdmin baseUser);
	
	/**
	* Title: UserService.java
	* Description: 退出登录
	* @author HuangJian
	* @date 2017年3月13日
	*/
	public void logOut();
}
