package com.joe.myblog.oa.service;

import java.util.List;
import java.util.Map;

import com.joe.myblog.oa.po.TArticle;

public interface ArticleService {

	/**
	* Title: ArticleService.java
	* Description: 查询文章
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年5月3日
	*/
	public List<Map<String, Object>> findArticleList(Map<String, Object> param);
	
	/**
	* Title: ArticleService.java
	* Description: 添加文章
	* @param article
	* @return
	* @author HuangJian
	* @date 2017年5月3日
	*/
	public Integer insertArticle(TArticle article);
	
	/**
	* Title: ArticleService.java
	* Description: 修改文章
	* @param article
	* @return
	* @author HuangJian
	* @date 2017年5月3日
	*/
	public Integer updateArticle(TArticle article);
	
	/**
	* Title: ArticleService.java
	* Description: 根据ID获取文章
	* @param id
	* @return
	* @author HuangJian
	* @date 2017年5月4日
	*/
	public TArticle getArticleById(Integer id);
}
