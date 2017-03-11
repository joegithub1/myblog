/**
* @author HuangJian
* @date 2017年3月9日
*/
package com.joe.myblog.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.swing.internal.plaf.metal.resources.metal;


@Controller
public class UserController {

	/**
	* Title: userLoginPage
	* Description: 去登录页面
	* @return
	* @author HuangJian
	* @date 2017年3月9日
	*/
	@RequestMapping(value="/blog")
	public String userLoginPage(){
		
		
		return "/login/login";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/blog/bloglogin")
	public String blogLogin(){
		
		
		return "redirect:/blog/home";
	}
	
	@RequestMapping(value = "/blog/home")
	public String loginHome(Model model){
		
		
		return "/layout/bloghome";
	}
}

