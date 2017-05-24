package com.joe.myblog.oa.vo;


import java.util.List;

import com.joe.myblog.oa.po.TAdmin;
import com.joe.myblog.oa.po.TMenu;



/**
 * 
 */
public class UserVo {



    private List<TMenu> menuList ;

    private TAdmin user;

    private String menuJson;

    private int pattern;

    //禁用
    public static final int USER_STATUS_JIN = 0;
    //启用
    public static final int USER_STATUS_QI = 1;
    //未授权
    public static final int USER_STATUS_WEI = 2;

    //账号type
    public static final int USER_TYPE_ZONG_ADMIN = 0;
    public static final int USER_TYPE_ZONG_WORK = 1;
    public static final int USER_TYPE_STUDIO_ADMIN = 2;
    public static final int USER_TYPE_STUDIO_WORK = 3;

    //验证result 用户名不存在
    public static final int USER_VAIL_RESULT_NULL = 0;
    //
    //public static final int USER_VAIL_RESULT_ZONG = 1;
    //博客系统
    public static final int USER_VAIL_RESULT_BLOG = 2;
    //密码错误
    public static final int USER_VAIL_RESULT_PSERR = 3;
    //未激活
    public static final int USER_VAIL_RESULT_WEI = 4;
    //停用
    public static final int USER_VAIL_RESULT_TING = 5;
    //异常
    public static final int USER_VAIL_RESULT_YC = 6;

    //权限禁用
    public static final int ROLE_IS_CLOSE = 1;
    //权限开启
    public static final int ROLE_NOT_CLOSE = 0;
    //权限被删除
    public static final int ROLE_IS_DEL = 1;
    //登录模式
    public static final int LOGIN_PATTERN=1;
    //游客模式
    public static final int VISITOR_PATTERN=2;
    
	public List<TMenu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<TMenu> menuList) {
		this.menuList = menuList;
	}
	public TAdmin getUser() {
		return user;
	}
	public void setUser(TAdmin user) {
		this.user = user;
	}
	public String getMenuJson() {
		return menuJson;
	}
	public void setMenuJson(String menuJson) {
		this.menuJson = menuJson;
	}
	public int getPattern() {
		return pattern;
	}
	public void setPattern(int pattern) {
		this.pattern = pattern;
	}
    
}
