package com.joe.myblog.oa.mapper;

import com.joe.myblog.oa.po.Test;
import com.joe.myblog.oa.po.TestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
    int countByExample(TestExample example);

    int deleteByExample(TestExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExample(TestExample example);

    Test selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}