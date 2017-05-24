package com.joe.myblog.oa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.joe.myblog.oa.po.TComment;
import com.joe.myblog.oa.service.CommentService;

/**
* Title: CommentController
* Description: 评论
* @author HuangJian
* @date 2017年5月5日
*
*/
@RequestMapping("/blog")
@Controller
public class CommentController extends BaseController{

	@Autowired
	private CommentService commentService;
	
	public Map<String, Object> param;
	public Map<String, Object> temp;
	/**
	* Title: CommentController.java
	* Description: 保存评论
	* @param commment
	* @return
	* @author HuangJian
	* @date 2017年5月5日
	*/
	@RequestMapping("/comment/save")
	@ResponseBody
	public String saveComment(TComment comment) {
		int result=0;
		param=new HashMap<>();
		temp=new HashMap<>();
		result = commentService.saveComment(comment);
		
		temp.put("articleId", comment.getArticleId());
		List<Map<String, Object>> comms =  commentService.findComment(temp);
		
		param.put("comment", comms);
		param.put("result", result);
		return new Gson().toJson(param);
	}
}
