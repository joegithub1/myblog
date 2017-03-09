/**
* @author HuangJian
* @date 2017年3月9日
*/
package com.joe.myblog.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/blog/test")
	public String test(Model model){
		
		
		System.out.println("----------------controller");
		return "/blog/index";
	}
}

