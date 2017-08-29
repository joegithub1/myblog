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

	@RequestMapping("/blog/test123")
	public String test(Model model){
		System.out.println("hello world");
		System.out.println("helloworld");
		
		
		System.out.println("----------------controller");
		show();
		return "/systemManage/tempDemo/form";
	}
	public void show(){
		System.out.println("show is hahhahahaahha");
		
		String name="zhang san";
		System.out.println(name+":names");
	}
}

