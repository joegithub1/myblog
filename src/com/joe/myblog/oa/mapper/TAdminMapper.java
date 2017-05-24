package com.joe.myblog.oa.mapper;

import com.joe.myblog.oa.po.TAdmin;
import com.joe.myblog.oa.po.TAdminExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TAdminMapper {
    int countByExample(TAdminExample example);

    int deleteByExample(TAdminExample example);

    int deleteByPrimaryKey(Integer backuserId);

    int insert(TAdmin record);

    int insertSelective(TAdmin record);

    List<TAdmin> selectByExample(TAdminExample example);

    TAdmin selectByPrimaryKey(Integer backuserId);

    int updateByExampleSelective(@Param("record") TAdmin record, @Param("example") TAdminExample example);

    int updateByExample(@Param("record") TAdmin record, @Param("example") TAdminExample example);

    int updateByPrimaryKeySelective(TAdmin record);

    int updateByPrimaryKey(TAdmin record);
    
    /**
    * Title: TAdminMapper.java
    * Description: 根据手机号码查询用户(登录)
    * @param user
    * @return
    * @author HuangJian
    * @date 2017年3月13日
    */
    TAdmin selectByUserName(TAdmin user);
    
    
    TAdmin selectByGYMUserName(TAdmin record);
    
    /**
	 * @param baseUser
	 * @return更新会员密码
	 */
	Integer updateByPhone(Map<String, Object> param);
	/**
	 * 
	* Title: 
	* Description:根据角色id删除用户所在的角色
	 */
	int updateBaseUserRoleByRoleIds(@Param("param") Map<String, Object> param);
	
	/**
	* Title: TAdminMapper.java
	* Description: 查询所有的用户
	* @param parm
	* @return
	* @author HuangJian
	* @date 2017年3月13日
	*/
	List<Map<String, Object>> selectUser(Map<String, Object> parm);
	/**
	* Title: TAdminMapper.java
	* Description: 根据角色查询用户
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年4月8日
	*/
	List<Map<String, Object>> selectBUByTypeARole(Map<String, Object> param);

	/**
	* Title: TAdminMapper.java
	* Description: 查询手机号码是否被注册过 返回总数
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年5月9日
	*/
	Integer selectByPhone(@Param("mobilephone") String mobilephone);
	
	 
}