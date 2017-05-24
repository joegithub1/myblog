/**
* @author HuangJian
* @date 2017年3月9日
*/
package com.joe.myblog.oa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.joe.myblog.oa.service.ConfigService;
import com.joe.myblog.oa.vo.UserVo;



public class BaseController {

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected HttpSession session;
	
	@Autowired
	private ConfigService configService;
	
	@ModelAttribute
	public void initController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}
	
	protected Integer getLogUserId() {
		UserVo userVo = (UserVo) session.getAttribute("userVo");
		return userVo.getUser().getBackuserId();
	}
	
	/**
	* Title: BaseController.java
	* Description: 根据名称查询value
	* @param key
	* @return
	* @author HuangJian
	* @date 2017年5月16日
	*/
	protected String selectValueByKey(String key) {
		
		return configService.selectValueByKey(key);
	}
}

