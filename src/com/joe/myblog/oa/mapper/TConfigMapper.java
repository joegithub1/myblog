package com.joe.myblog.oa.mapper;

import com.joe.myblog.oa.po.TConfig;
import com.joe.myblog.oa.po.TConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TConfigMapper {
    int countByExample(TConfigExample example);

    int deleteByExample(TConfigExample example);

    int deleteByPrimaryKey(Integer tId);

    int insert(TConfig record);

    int insertSelective(TConfig record);

    List<TConfig> selectByExample(TConfigExample example);

    TConfig selectByPrimaryKey(Integer tId);

    int updateByExampleSelective(@Param("record") TConfig record, @Param("example") TConfigExample example);

    int updateByExample(@Param("record") TConfig record, @Param("example") TConfigExample example);

    int updateByPrimaryKeySelective(TConfig record);

    int updateByPrimaryKey(TConfig record);
}