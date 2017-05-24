package com.joe.myblog.oa.mapper;

import com.joe.myblog.oa.po.TComment;
import com.joe.myblog.oa.po.TCommentExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TCommentMapper {
    int countByExample(TCommentExample example);

    int deleteByExample(TCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TComment record);

    int insertSelective(TComment record);

    List<TComment> selectByExample(TCommentExample example);

    TComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TComment record, @Param("example") TCommentExample example);

    int updateByExample(@Param("record") TComment record, @Param("example") TCommentExample example);

    int updateByPrimaryKeySelective(TComment record);

    int updateByPrimaryKey(TComment record);
    
    /**
    * Title: TCommentMapper.java
    * Description:条件或全查评论 
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年5月5日
    */
    List<Map<String, Object>> findComment(@Param("param") Map<String, Object> param);
}