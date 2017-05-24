package com.joe.myblog.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MessageBoardController extends BaseController{

	@RequestMapping("/blog/messboard")
	public String list(Model model){
		System.out.println("ok");
		return "/systemManage/messboard/messboard";
	}
}
