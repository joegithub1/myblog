package com.joe.myblog.oa.mapper;

import com.joe.myblog.oa.po.TAdminAuthRef;
import com.joe.myblog.oa.po.TAdminAuthRefExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TAdminAuthRefMapper {
    int countByExample(TAdminAuthRefExample example);

    int deleteByExample(TAdminAuthRefExample example);

    int deleteByPrimaryKey(Integer adminAuthId);

    int insert(TAdminAuthRef record);

    int insertSelective(TAdminAuthRef record);

    List<TAdminAuthRef> selectByExample(TAdminAuthRefExample example);

    TAdminAuthRef selectByPrimaryKey(Integer adminAuthId);

    int updateByExampleSelective(@Param("record") TAdminAuthRef record, @Param("example") TAdminAuthRefExample example);

    int updateByExample(@Param("record") TAdminAuthRef record, @Param("example") TAdminAuthRefExample example);

    int updateByPrimaryKeySelective(TAdminAuthRef record);

    int updateByPrimaryKey(TAdminAuthRef record);
    
    
    int insertRoleAuthRefs(List<TAdminAuthRef> ualist);
    /**
     * 
    * Title: 
    * Description:根据角色id查询权限
    * @author HuangJian
    * @date 2016年11月8日
     */
    List<Map<String, Object>> selectAuthByRoleId(@Param("param") Map<String, Object> param);
    
}