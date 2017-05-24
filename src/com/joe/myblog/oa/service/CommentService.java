package com.joe.myblog.oa.service;

import java.util.List;
import java.util.Map;

import com.joe.myblog.oa.po.TComment;

public interface CommentService {

	/**
	* Title: CommentService.java
	* Description: 全查或条件查询
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年5月5日
	*/
	List<Map<String, Object>> findComment(Map<String, Object> param);
	
	/**
	* Title: CommentService.java
	* Description: 保存评论
	* @param comment
	* @return
	* @author HuangJian
	* @date 2017年5月5日
	*/
	public Integer saveComment(TComment comment);
	
	/**
	* Title: CommentService.java
	* Description: 修改评论
	* @param comms
	* @return
	* @author HuangJian
	* @date 2017年5月18日
	*/
	public Integer updateComment(TComment comms);
}
