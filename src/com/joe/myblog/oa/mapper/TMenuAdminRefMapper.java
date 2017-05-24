package com.joe.myblog.oa.mapper;

import com.joe.myblog.oa.po.TMenuAdminRef;
import com.joe.myblog.oa.po.TMenuAdminRefExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TMenuAdminRefMapper {
    int countByExample(TMenuAdminRefExample example);

    int deleteByExample(TMenuAdminRefExample example);

    int deleteByPrimaryKey(Integer menuRoleId);

    int insert(TMenuAdminRef record);

    int insertSelective(TMenuAdminRef record);

    List<TMenuAdminRef> selectByExample(TMenuAdminRefExample example);

    TMenuAdminRef selectByPrimaryKey(Integer menuRoleId);

    int updateByExampleSelective(@Param("record") TMenuAdminRef record, @Param("example") TMenuAdminRefExample example);

    int updateByExample(@Param("record") TMenuAdminRef record, @Param("example") TMenuAdminRefExample example);

    int updateByPrimaryKeySelective(TMenuAdminRef record);

    int updateByPrimaryKey(TMenuAdminRef record);
    
    /**
    * Title: TMenuAdminRefMapper.java
    * Description: 根据角色ID查询权限标识
    * @param rId
    * @return
    * @author HuangJian
    * @date 2017年5月5日
    */
    List<Map<String, Object>> selectMenuRoleRefMyRoleId(@Param("rId") Integer rId);
    
    /**
    * Title: TMenuAdminRefMapper.java
    * Description: 
    * @param mrlist
    * @return
    * @author HuangJian
    * @date 2017年3月13日
    */
    int insertMenuRoleRefs(List<TMenuAdminRef> mrlist);
}