package com.joe.myblog.oa.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.lookup.TypeIds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.joe.myblog.oa.po.TArticle;
import com.joe.myblog.oa.service.ArticleService;
import com.joe.myblog.oa.service.CommentService;
import com.joe.myblog.oa.utils.ConstantVo;
@RequestMapping("/blog")
@Controller
public class ArticleController extends BaseController{

	@Autowired
	private ArticleService articleService;
	@Autowired
	private CommentService commentService;
	
	public List<Map<String, Object>> result;
	public Map<String, Object> param;
	public PageInfo<Map<String, Object>> pageInfoList;
	public List<Map<String, Object>> commentList;
	/**
	* Title: ArticleController.java
	* Description: 根据类型查询文章
	* @param model
	* @param typeId 文章类型ID
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年5月4日
	*/
	@RequestMapping("/article/list/{typeId}")
	public String findArticle(Model model,@PathVariable(value="typeId") Integer typeId,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		param=new HashMap<>();
		param.put("type", typeId);
		param.put("userId", this.selectValueByKey(ConstantVo.DEFAULT_ADMIN_USER_ID));
		PageHelper.startPage(pageNum, pageSize);
		result = articleService.findArticleList(param);
		pageInfoList = new PageInfo<>(result);
		model.addAttribute("list", pageInfoList);
		model.addAttribute("typeId", typeId);
		return "/systemManage/browse/broList";
	}
	@RequestMapping("/article/detail")
	public String getArticleById(Model model,Integer id){
		TArticle article = new TArticle();
		
		article = articleService.getArticleById(id);
		//增加阅读量
		article.setReadNum(article.getReadNum()+1);
		
		articleService.updateArticle(article);
		
		param=new HashMap<>();
		param.put("articleId", id);
		param.put("status", "1");//区分状态 状态=1
		//查询评论
		commentList = commentService.findComment(param);
		model.addAttribute("article", article);
		model.addAttribute("comms", commentList);
		return "/systemManage/browse/broDetail";
	}
}
