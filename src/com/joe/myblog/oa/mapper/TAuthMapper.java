package com.joe.myblog.oa.mapper;

import com.joe.myblog.oa.po.TAuth;
import com.joe.myblog.oa.po.TAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAuthMapper {
    int countByExample(TAuthExample example);

    int deleteByExample(TAuthExample example);

    int deleteByPrimaryKey(Integer authId);

    int insert(TAuth record);

    int insertSelective(TAuth record);

    List<TAuth> selectByExample(TAuthExample example);

    TAuth selectByPrimaryKey(Integer authId);

    int updateByExampleSelective(@Param("record") TAuth record, @Param("example") TAuthExample example);

    int updateByExample(@Param("record") TAuth record, @Param("example") TAuthExample example);

    int updateByPrimaryKeySelective(TAuth record);

    int updateByPrimaryKey(TAuth record);
}