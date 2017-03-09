package com.joe.myblog.oa.vo;


import java.util.List;



/**
 * 
 */
public class UserVo {



    //private List<TMenu> menuList ;

    //private TAdmin user;

    private String menuJson;

  

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

    //验证result
    public static final int USER_VAIL_RESULT_NULL = 0;
    //总控系统
    public static final int USER_VAIL_RESULT_ZONG = 1;
    //健身房系统
    public static final int USER_VAIL_RESULT_JIAN = 2;
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

}
