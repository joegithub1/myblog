/**
* @author HuangJian
* @date 2017年3月9日
*/
package com.joe.myblog.oa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;


public class BaseController {

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected HttpSession session;
	
	@ModelAttribute
	public void initController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}
	
	protected Integer getLogUserId() {
		System.out.println("hello word---冲突文件 同时更改一行代码");
		return 1;
	}
}

