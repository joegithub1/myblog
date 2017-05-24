package com.joe.myblog.oa.service;


import java.util.List;
import java.util.Map;

import com.joe.myblog.oa.po.TAuth;
import com.joe.myblog.oa.po.TRole;


public interface AuthService {


    int insertRole(TRole role,String[] authStr,String[] menuStr)throws Exception;

   // List<TRole> selectRolesByStudioId(Integer studioId);

    /**
    * Title: AuthService.java
    * Description: 删除角色
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年3月18日
    */
    int delectRoleById(Map<String, Object> param);

    List<Integer> selectMenuIdsByRoleId(Integer roleId);

    List<Integer> selectAutoIdsByRoleId(Integer roleId);

    int updateRole(TRole role,String[] authStr,String[] menuStr,Integer operatorId)throws Exception;
    /**
     * 
    * Title: 
    * Description:根据角色名称查询角色
    * @author HuangJian
    * @date 2016年11月11日
     */
    List<TRole> selectRoleByName(String roleName);
    /**
     * 
    * Title: 
    * Description:排重角色名称
    * @author Li XiaoYang
    * @date 2016年11月28日
     */
    Integer selectRoleName(String roleName);

	Integer updateAuthRole(String oldUserId, String newUserId, Integer roleId);
	
	/**
	* Title: AuthService.java
	* Description: 查询可用的角色
	* @return
	* @author HuangJian
	* @date 2017年3月18日
	*/
	List<TRole> findRole();
	 
	/**
	* Title: AuthService.java
	* Description: 查询所有的用户
	* @return
	* @author HuangJian
	* @date 2017年3月13日
	*/
	List<Map<String,Object>> selectUser();
	
	List<Map<String,Object>> selectBUByTypeARole(Integer roleId);
	
	/**
	* Title: AuthService.java
	* Description: 全查按钮或根据菜单查询按钮
	* @param menuId
	* @return
	* @author HuangJian
	* @date 2017年4月4日
	*/
	List<Map<String, Object>> findAuths(Integer menuId,Integer authId);
	
	/**
	* Title: AuthService.java
	* Description: 保存按钮权限
	* @param auth
	* @return
	* @author HuangJian
	* @date 2017年4月4日
	*/
	Integer saveAuth(TAuth auth);
	
	/**
	* Title: AuthService.java
	* Description: 修改按钮
	* @param auth
	* @return
	* @author HuangJian
	* @date 2017年4月4日
	*/
	Integer updateAuth(TAuth auth);
	
	/**
	* Title: AuthService.java
	* Description: 根据ID查询
	* @param authId
	* @return
	* @author HuangJian
	* @date 2017年4月4日
	*/
	TAuth getTauthById(Integer authId);
	
	/**
	* Title: AuthService.java
	* Description: 删除
	* @param authId
	* @return
	* @author HuangJian
	* @date 2017年4月4日
	*/
	Integer deleteAuthById(Integer authId);
	
	/**
	* Title: AuthService.java
	* Description: 根据角色ID查询
	* @param roleId
	* @return
	* @author HuangJian
	* @date 2017年4月8日
	*/
	TRole getRoleById(Integer roleId);
}
