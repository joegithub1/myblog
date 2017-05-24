package com.joe.myblog.oa.mapper;

import com.joe.myblog.oa.po.TArticle;
import com.joe.myblog.oa.po.TArticleExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TArticleMapper {
    int countByExample(TArticleExample example);

    int deleteByExample(TArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TArticle record);

    int insertSelective(TArticle record);

    List<TArticle> selectByExample(TArticleExample example);

    TArticle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TArticle record, @Param("example") TArticleExample example);

    int updateByExample(@Param("record") TArticle record, @Param("example") TArticleExample example);

    int updateByPrimaryKeySelective(TArticle record);

    int updateByPrimaryKey(TArticle record);
    
    /**
     * Title: TArticleMapper.java
     * Description: 查询所有的文章
     * @param param
     * @return
     * @author HuangJian
     * @date 2017年5月4日
     */
     List<Map<String, Object>> findArticleList(@Param("param") Map<String, Object> param);
}