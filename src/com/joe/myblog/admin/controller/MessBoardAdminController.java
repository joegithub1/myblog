package com.joe.myblog.admin.controller;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
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
import com.joe.myblog.oa.po.TMessageBoard;
import com.joe.myblog.oa.service.MessageBoardService;
import com.joe.myblog.oa.utils.ConstantVo;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
@Controller
public class MessBoardAdminController extends BaseController{

	@Autowired
	private MessageBoardService messageBoardService;
	
	public PageInfo<TMessageBoard> pageInfo;
	public List<TMessageBoard> list; 
	
	@RequestMapping("/blog/messboards")
	public String list(Model model,
			@RequestParam(required=true,defaultValue="1") Integer pageNum,
			@RequestParam(required=true,defaultValue=ConstantVo.PAGE_SIZE) Integer pageSize){
		
		PageHelper.startPage(pageNum, pageSize);
		list = messageBoardService.findMessageBoard(0);
		pageInfo = new PageInfo<>(list);
		
		model.addAttribute("mbs", pageInfo);
		return "/admin/messboard/list";
	}
	
	/**
	* Title: MessBoardAdminController.java
	* Description: 留言状态修改
	* @param ids
	* @return
	* @author HuangJian
	* @date 2017年5月26日
	*/
	@RequestMapping("/blog/updatemsstatus")
	@ResponseBody
	public String updateMessBoardStatus(String ids,Integer status){
		/*int result = messageBoardService.updateMessageBoards(ids, status);*/
		JSONArray array =  JSONArray.fromObject(ids);
		
		int result = messageBoardService.updateMessageBoards(array.toArray(), status);
		return new Gson().toJson(result);
	}
}
