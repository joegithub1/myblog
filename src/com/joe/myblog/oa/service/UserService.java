package com.joe.myblog.oa.service;

import java.util.List;
import java.util.Set;

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
	
	/**
	* Title: UserService.java
	* Description: 修改用户
	* @param user
	* @return
	* @author HuangJian
	* @date 2017年3月18日
	*/
	public Integer updateUser(TAdmin user);
	
	/**
	* Title: UserService.java
	* Description: 根据用户名查询角色
	* @param username
	* @return
	* @author HuangJian
	* @date 2017年4月8日
	*/
	public Set<String> findRolesByUserName(String userName);
	
	/**
	* Title: UserService.java
	* Description: 根据用户名查询菜单权限标识
	* @param userName
	* @return
	* @author HuangJian
	* @date 2017年4月8日
	*/
	public Set<String> findPermissions(String userName);
	
	/**
	* Title: UserService.java
	* Description: 保存用户
	* @param user
	* @return
	* @author HuangJian
	* @date 2017年5月9日
	*/
	public Integer saveUser(TAdmin user);
	
	/**
	* Title: UserService.java
	* Description: 根据用户名精确查询
	* @param userName
	* @return
	* @author HuangJian
	* @date 2017年5月9日
	*/
	public List<TAdmin> getUserByUserName(String userName);
	
	/**
	* Title: UserService.java
	* Description: 查询手机号码是否存在 返回总行数
	* @param mobilePhone
	* @return
	* @author HuangJian
	* @date 2017年5月10日
	*/
	public Integer getIsExistMobilePhone(String mobilePhone);
	
	/**
	* Title: UserService.java
	* Description: 根据手机号码查询用户
	* @param mobilePhone
	* @return
	* @author HuangJian
	* @date 2017年5月10日
	*/
	public TAdmin selectUserByMobilePhone(String mobilePhone);
}
