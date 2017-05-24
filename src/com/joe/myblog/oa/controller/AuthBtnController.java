package com.joe.myblog.oa.controller;

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
import com.joe.myblog.oa.po.TAuth;
import com.joe.myblog.oa.po.TMenu;
import com.joe.myblog.oa.po.TOpeartion;
import com.joe.myblog.oa.service.AuthService;
import com.joe.myblog.oa.service.MenuService;
import com.joe.myblog.oa.service.OpeartionService;
import com.joe.myblog.oa.utils.ConstantVo;
@Controller
public class AuthBtnController extends BaseController{

	@Autowired
	private AuthService authService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private OpeartionService opeartionService;
	public Map<String, Object> retParam;
	
	public PageInfo<Map<String, Object>> pageInfo;
	/**
	* Title: AuthBtnController.java
	* Description: 按钮管理
	* @param model
	* @return
	* @author HuangJian
	* @date 2017年4月4日
	*/
	@RequestMapping("/auth/btnmanage")
	public String authBtnList(Model model,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> auths =  authService.findAuths(null,null);
		pageInfo=new PageInfo<>(auths);
		List<TMenu> menus =  menuService.getMenuByRoot(0);
		model.addAttribute("auths", pageInfo);
		model.addAttribute("menus", menus);
		return "/systemManage/authBtn/btnManage";
	}
	
	/**
	* Title: AuthBtnController.java
	* Description: 保存权限
	* @param auth
	* @return
	* @author HuangJian
	* @date 2017年4月4日
	*/
	@RequestMapping("/authbtn/saveauth")
	@ResponseBody
	public String saveAuthBtn(TAuth auth){
		int result=0;
		retParam=new HashMap<>();
		auth.setAuthOperatorid(this.getLogUserId());
		result = authService.saveAuth(auth);
		retParam.put("status", result);
		if(result > 0){
			retParam.put("message", "添加成功");
		}else{
			retParam.put("message", "添加失败");
		}
		retParam.put("flag", 0);//保存标识
		return new Gson().toJson(retParam);
	}
	
	
	/**
	* Title: AuthBtnController.java
	* Description: 修改按钮权限
	* @param auth
	* @return
	* @author HuangJian
	* @date 2017年4月4日
	*/
	@RequestMapping("/authbtn/updateauth")
	@ResponseBody
	public String updateAuthBtn(TAuth auth){
		retParam=new HashMap<>();
		int result = authService.updateAuth(auth);
		retParam.put("status", result);
		retParam.put("flag", 1);//修改标识
		if(result > 0){
			retParam.put("message", "修改成功");
		}else{
			retParam.put("message", "修改失败");
		}
		TOpeartion op = new TOpeartion();
		op.setOpeartionById(auth.getAuthId());
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionInfo("修改按钮");
		op.setOpeartionType(ConstantVo.OPT_BTN_TYPE);
		opeartionService.saveOpeartion(op);
		return new Gson().toJson(retParam);
	}
	/**
	* Title: AuthBtnController.java
	* Description: 根据ID查询
	* @param authId
	* @return
	* @author HuangJian
	* @date 2017年4月4日
	*/
	@RequestMapping("/authbtn/getauthbyid")
	@ResponseBody
	public String getAuthBtnById(Integer authId){
		
		//List<Map<String, Object>> auths =  authService.findAuths(null, authId);
		TAuth auth = authService.getTauthById(authId);
		return new Gson().toJson(auth);
	}
	/**
	* Title: AuthBtnController.java
	* Description: 删除权限按钮
	* @param auth
	* @return
	* @author HuangJian
	* @date 2017年4月4日
	*/
	@RequestMapping("/authbtn/delauth")
	@ResponseBody
	public String deleteAuthBtn(@RequestParam("ids[]") Integer [] ids){
		int result = 0;
		if(ids.length > 0){
			TOpeartion op=new TOpeartion();
			op.setOpeartionAdminId(this.getLogUserId());
			op.setOpeartionInfo("删除权限按钮");
			op.setOpeartionType(ConstantVo.OPT_BTN_TYPE);
			for(int i=0;i<ids.length;i++){
				result = authService.deleteAuthById(ids[i]);
				op.setOpeartionById(ids[i]);
				opeartionService.saveOpeartion(op);
			}
		}
		
		return new Gson().toJson(result);
	}
}
