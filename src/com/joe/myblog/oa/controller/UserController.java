/**
* @author HuangJian
* @date 2017年3月9日
*/
package com.joe.myblog.oa.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joe.myblog.oa.po.TAdmin;
import com.joe.myblog.oa.service.UserService;
import com.joe.myblog.oa.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Title: userLoginPage Description: 去登录页面
	 * 
	 * @return
	 * @author HuangJian
	 * @date 2017年3月9日
	 */
	@RequestMapping(value = "/blog")
	public String userLoginPage() {

		return "/login/login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/blog/bloglogin")
	public String blogLogin(Model model, TAdmin user) {
		int result = userService.userLogin(user);
		String errInfo = "ok";
		switch (result) {
		case UserVo.USER_VAIL_RESULT_NULL:
			errInfo = "账号不存在";
			break;
		case UserVo.USER_VAIL_RESULT_JIAN:
			errInfo = "ok";
			break;
		case UserVo.USER_VAIL_RESULT_PSERR:
			errInfo = "密码错误";
			break;
		case UserVo.USER_VAIL_RESULT_TING:
			errInfo = "账号已经停用";
			break;
		case UserVo.USER_VAIL_RESULT_YC:
			errInfo = "账号异常,请联系管理员";
			break;
		}

		if ("ok".equals(errInfo)) {
			return "redirect:/blog/home";
		} else {
			model.addAttribute("err", errInfo);
			return "forward:/blog";
		}

	}

	@RequestMapping(value = "/blog/home")
	public String loginHome(Model model) {

		return "/layout/bloghome";
	}

	@RequestMapping("/blog/logout")
	public String gymLogout() {
		//Subject subject = SecurityUtils.getSubject();
		try {
			//subject.logout();
			this.userService.logOut();
		} catch (Exception e) {

		}

		return "redirect:/blog";
	}

}
