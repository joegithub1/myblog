package com.joe.myblog.oa.mapper;

import com.joe.myblog.oa.po.TMenu;
import com.joe.myblog.oa.po.TMenuExample;
import com.joe.myblog.oa.vo.MenuVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TMenuMapper {
    int countByExample(TMenuExample example);

    int deleteByExample(TMenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(TMenu record);

    int insertSelective(TMenu record);

    List<TMenu> selectByExample(TMenuExample example);

    TMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") TMenu record, @Param("example") TMenuExample example);

    int updateByExample(@Param("record") TMenu record, @Param("example") TMenuExample example);

    int updateByPrimaryKeySelective(TMenu record);

    int updateByPrimaryKey(TMenu record);
    
    List<TMenu> selectUserMenuByUserId(Map<String, Object> param);
   
    
    /**
    * Title: TMenuMapper.java
    * Description: 查询所有菜单
    * @return
    * @author HuangJian
    * @date 2017年3月13日
    */
    List<MenuVo> selectMenu();
    /**
     * 
    * Title: 
    * Description:查询健身房菜单  
    *    菜单管理：展示时需要去重
   		权限管理：展示时不需要去重
     */
    List<MenuVo> findBaseMenuTree(@Param("param") Map<String, Object> param);
    /**
     * 
    * Title: 
    * Description:删除根节点 修改操作
     */
    int updateBaseMenuByPid(Integer pId);
    /**
     * 
    * Title: 
    * Description:删除子节点 修改操作
     */
    int updateBaseMenuById(Integer id);
    
    
}