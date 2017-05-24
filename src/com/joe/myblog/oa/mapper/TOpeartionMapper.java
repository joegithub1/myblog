package com.joe.myblog.oa.mapper;

import com.joe.myblog.oa.po.TOpeartion;
import com.joe.myblog.oa.po.TOpeartionExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TOpeartionMapper {
    int countByExample(TOpeartionExample example);

    int deleteByExample(TOpeartionExample example);

    int deleteByPrimaryKey(Integer opeartionId);

    int insert(TOpeartion record);

    int insertSelective(TOpeartion record);

    List<TOpeartion> selectByExampleWithBLOBs(TOpeartionExample example);

    List<TOpeartion> selectByExample(TOpeartionExample example);

    TOpeartion selectByPrimaryKey(Integer opeartionId);

    int updateByExampleSelective(@Param("record") TOpeartion record, @Param("example") TOpeartionExample example);

    int updateByExampleWithBLOBs(@Param("record") TOpeartion record, @Param("example") TOpeartionExample example);

    int updateByExample(@Param("record") TOpeartion record, @Param("example") TOpeartionExample example);

    int updateByPrimaryKeySelective(TOpeartion record);

    int updateByPrimaryKeyWithBLOBs(TOpeartion record);

    int updateByPrimaryKey(TOpeartion record);
    
    /*
     * 
    * Title: findOpeartion
    * Description: 根据数据id查询操作记录
    * @author HuangJian
    * @date 2017年1月9日
     */
    List<Map<String, Object>> findOpeartionByDataAndType(Map<String, Object> param);
    
    /**
    * Title: findOpeartionByOpearType
    * Description: 根据菜单类型查询
    * @param opearType
    * @return
    * @author HuangJian
    * @date 2017年1月16日
    */
    List<Map<String, Object>> findOpeartionByOpearType(@Param("opearType") Integer opearType);
    
    /**
    * Title: findOrderOpeartionById
    * Description: 查询订单操作记录
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年2月9日
    */
    List<Map<String, Object>> findOrderOpeartionById(@Param("param") Map<String, Object> param);
    
}