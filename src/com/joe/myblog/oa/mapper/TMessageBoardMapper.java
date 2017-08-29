package com.joe.myblog.oa.mapper;

import com.joe.myblog.oa.po.TMessageBoard;
import com.joe.myblog.oa.po.TMessageBoardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMessageBoardMapper {
    int countByExample(TMessageBoardExample example);

    int deleteByExample(TMessageBoardExample example);

    int deleteByPrimaryKey(Integer messageId);

    int insert(TMessageBoard record);

    int insertSelective(TMessageBoard record);

    List<TMessageBoard> selectByExample(TMessageBoardExample example);

    TMessageBoard selectByPrimaryKey(Integer messageId);

    int updateByExampleSelective(@Param("record") TMessageBoard record, @Param("example") TMessageBoardExample example);

    int updateByExample(@Param("record") TMessageBoard record, @Param("example") TMessageBoardExample example);

    int updateByPrimaryKeySelective(TMessageBoard record);

    int updateByPrimaryKey(TMessageBoard record);
    
    /**
    * Title: TMessageBoardMapper.java
    * Description: 根据多个id修改状态 
    * @param ids
    * @param status
    * @return
    * @author HuangJian
    * @date 2017年5月26日
    */
    void updateMessageBoardsStatus(@Param("arr") Object [] ids,@Param("status") Integer status);
}