package com.joe.myblog.oa.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.joe.myblog.oa.po.TMessageBoard;
import com.joe.myblog.oa.service.MessageBoardService;
import com.joe.myblog.oa.utils.ConstantVo;
@Controller
public class MessageBoardController extends BaseController{

	@Autowired
	private MessageBoardService messageBoardService;
	public PageInfo<TMessageBoard> pageInfo;
	
	public List<TMessageBoard> list;
	/**
	* Title: MessageBoardController.java
	* Description: 留言列表
	* @param model
	* @return
	* @author HuangJian
	* @date 2017年5月25日
	*/
	@RequestMapping("/blog/messboardlist")
	public String list(Model model,
			@RequestParam(defaultValue="1",required=true) Integer pageNum,
			@RequestParam(defaultValue=ConstantVo.PAGE_SIZE,required=true) Integer pageSize){
		
		PageHelper.startPage(pageNum, pageSize);
		list = messageBoardService.findMessageBoard(1);
		pageInfo = new PageInfo<>(list);
		
		model.addAttribute("mbs", pageInfo);
		return "/systemManage/messboard/list";
	}
	/**
	* Title: MessageBoardController.java
	* Description: 去编辑页面
	* @return
	* @author HuangJian
	* @date 2017年5月25日
	*/
	@RequestMapping("/blog/messboardadd")
	public String toEditPage(){
		
		return "/systemManage/messboard/edit";
	}
	/**
	* Title: MessageBoardController.java
	* Description: 保存或修改
	* @param messageBoard
	* @return
	* @author HuangJian
	* @date 2017年5月25日
	*/
	@RequestMapping("/blog/messboardsave")
	@ResponseBody
	public String saveMessBoard(TMessageBoard messageBoard){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> param=new HashMap<>();
		Integer key=0;
		if(null == messageBoard.getMessageId()){
			messageBoard.setMessageDate(sdf.format(new Date()));
			key =  messageBoardService.saveMessageBoard(messageBoard);
			if(key > 0){
				PageHelper.startPage(1, Integer.parseInt(ConstantVo.PAGE_SIZE));
				list = messageBoardService.findMessageBoard(1);
				pageInfo = new PageInfo<>(list);
				param.put("lys", pageInfo);
			}
		}else{
			key = messageBoardService.updateMessageBoard(messageBoard);
		}
		param.put("result", key);
		return new Gson().toJson(param);
	}
	
}
