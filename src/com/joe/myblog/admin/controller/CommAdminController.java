package com.joe.myblog.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.joe.myblog.oa.controller.BaseController;
import com.joe.myblog.oa.po.TComment;
import com.joe.myblog.oa.service.CommentService;

/**
* Title: CommAdminController
* Description: 评论管理
* @author HuangJian
* @date 2017年5月17日
*
*/
@RequestMapping("/blog")
@Controller
public class CommAdminController extends BaseController{

	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/commadmin/updatestatus")
	@ResponseBody
	public String updateStatus(Integer id,Integer status){
		TComment comms = new TComment();
		comms.setId(id);
		comms.setStatus(status);
		int res = commentService.updateComment(comms);
		return new Gson().toJson(res);
	}
}
