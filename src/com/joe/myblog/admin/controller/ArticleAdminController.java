package com.joe.myblog.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.joe.myblog.oa.controller.BaseController;
import com.joe.myblog.oa.po.TArticle;
import com.joe.myblog.oa.po.TDictionary;
import com.joe.myblog.oa.service.ArticleService;
import com.joe.myblog.oa.service.CommentService;
import com.joe.myblog.oa.service.DictionaryService;
import com.joe.myblog.oa.utils.ConstantVo;
/**
* Title: ArticleAdminController
* Description: 文章管理后台
* @author HuangJian
* @date 2017年5月2日
*
*/
@RequestMapping("/blog")
@Controller
public class ArticleAdminController extends BaseController{

	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CommentService commentService;
	
	
	public Map<String, Object> param;
	public PageInfo<Map<String, Object>> pageInfoList;
	public List<Map<String, Object>> resultListMap;
	/**
	* Title: ArticleAdminController.java
	* Description: 后台文章管理列表
	* @param model
	* @return
	* @author HuangJian
	* @date 2017年5月2日
	*/
	@RequestMapping("/articleadmin/list")
	public String articleList(Model model,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		param=new HashMap<>();
		param.put("type", -1);
		param.put("userId", this.getLogUserId());
		resultListMap = articleService.findArticleList(param);
		pageInfoList = new PageInfo<>(resultListMap);
		model.addAttribute("list", pageInfoList);
		return "/admin/article/article";
	}
	/**
	* Title: ArticleAdminController.java
	* Description: 页面跳转
	* @param model
	* @param id
	* @return
	* @author HuangJian
	* @date 2017年5月3日
	*/
	@RequestMapping("/articleadmin/skip")
	public String articleSkip(Model model,
			@RequestParam(defaultValue="-1",required=true) Integer id){
		param=new HashMap<>();
		param.put("typeNum", 1);
		List<TDictionary> dics =  dictionaryService.getDictionaries(param);
		TArticle article = new TArticle();
		if(-1 != id){
			article = articleService.getArticleById(id);
		}else{
			
		}
		model.addAttribute("article", article);
		model.addAttribute("dics", dics);
		return "/admin/article/add";
	}
	
	/**
	* Title: ArticleAdminController.java
	* Description: 增加或修改
	* @param article
	* @return
	* @author HuangJian
	* @date 2017年5月3日
	*/
	@RequestMapping("/articleadmin/saveorupdate")
	@ResponseBody
	public String saveOrUpdateArticle(TArticle article){
		param = new HashMap<>();
		int result = 0;
		if(null == article.getId()){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			article.setCrateDate(sdf.format(new Date()));
			article.setPublishUseId(this.getLogUserId());
			result = articleService.insertArticle(article);
			if(result > 0){
				param.put("message", "新增成功");
			}else{
				param.put("message", "新增失败");
			}
			param.put("id", result);
			param.put("result", result);
		}else{
			result = articleService.updateArticle(article);
			if(result > 0){
				param.put("message", "编辑成功");
			}else{
				param.put("message", "编辑失败");
			}
			param.put("result", result);
			param.put("id", article.getId());
		}
		
		return new Gson().toJson(param);
	}
	/**
	* Title: ArticleAdminController.java
	* Description: 文章详情
	* @param id
	* @return
	* @author HuangJian
	* @date 2017年5月17日
	*/
	@RequestMapping("/articleadmin/detail")
	public String detail(Model model,Integer id){
		TArticle article =  articleService.getArticleById(id);
		Map<String, Object> param=new HashMap<>();
		param.put("articleId", id);
		param.put("status", "0");//不区分状态 状态=0
		//文章评论
		List<Map<String, Object>> comms =  commentService.findComment(param);
		
		TDictionary dictionary =  dictionaryService.geTDictionaryByIdType(article.getArticleType(), 1);
		model.addAttribute("article", article);
		model.addAttribute("comms", comms);
		model.addAttribute("dictionary", dictionary);
		return "/admin/article/detail";
	}
}
