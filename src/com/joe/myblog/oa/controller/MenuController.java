/*
* @author HuangJian
* @date 2017年1月6日
*/
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
import com.joe.myblog.oa.po.TMenu;
import com.joe.myblog.oa.po.TOpeartion;
import com.joe.myblog.oa.service.MenuService;
import com.joe.myblog.oa.service.OpeartionService;
import com.joe.myblog.oa.utils.ConstantVo;
import com.joe.myblog.oa.utils.TreeUtil;
import com.joe.myblog.oa.vo.MenuVo;

/**
 * 
 * Title: com.yundongjia.oa.admin.controller.datemanagecontroller Description:
 * 菜单管理
 * 
 * @author HuangJian
 * @date 2017年1月6日
 */
@Controller
public class MenuController extends BaseController {

	@Autowired
	private MenuService menuService;
	@Autowired
	private OpeartionService opeartionService;

	public Map<String, Object> param;
	
	public Map<String, Object> retParam;

	/*
	 * 
	 * Title: list Description: 菜单全查
	 * 
	 * @author HuangJian
	 * 
	 * @date 2017年1月6日
	 */
	@RequestMapping("/menu/menumanage")
	public String list(Model model,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize) {
		param = new HashMap<>();
		param.put("dis", true);
		PageHelper.startPage(pageNum, pageSize);
		List<MenuVo> menus = menuService.findTreeBulider(param);
		PageInfo<MenuVo> result = new PageInfo<>(menus);

		// 构建树形结构
		List<MenuVo> tResult = TreeUtil.treeBulider(result.getList());
		result.setList(tResult);
		model.addAttribute("menus", result);
		return "/systemManage/menu/menuManage";
	}

	/*
	 * 
	 * Title: add Description: 去添加页面
	 * 
	 * @author HuangJian
	 * 
	 * @date 2017年1月6日
	 */
	@Deprecated
	@RequestMapping("/menu/addmenu")
	public String add(Model model, Integer root, Integer id) {
		// 查询菜单
		if (-1 != id) {
			TMenu menu = menuService.selectBaseMenuById(id);
			model.addAttribute("menu", menu);
		} else {
			model.addAttribute("menu", null);
		}

		model.addAttribute("isRoot", root);
		return "/systemmanage/menu/add";
	}


	/**
	* Title: MenuController.java
	* Description: 添加菜单
	* @param menu
	* @return
	* @author HuangJian
	* @date 2017年4月2日
	*/
	@RequestMapping("/menu/savemenu")
	@ResponseBody
	public String saveMenu(TMenu menu) {
		int result = 0;
		retParam=new HashMap<>();
		boolean r = true;// 是否根节点
		if (menu.getMenuIsroot() == 0) {
			r = false;
		}
		result = menuService.saveBaseMenu(menu, r);

		// 操作记录
		try {
			TOpeartion record = new TOpeartion();
			record.setOpeartionAdminId(this.getLogUserId());
			record.setOpeartionInfo("创建菜单");
			record.setOpeartionById(result);
			record.setOpeartionType(ConstantVo.OPT_MENU_TYPE);
			opeartionService.saveOpeartion(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		retParam.put("status", result);
		String mess="异常";
		if(result > 0){
			mess="增加成功";
		}else{
			mess="增加失败";
		}
		retParam.put("message", mess);
		return new Gson().toJson(retParam);
	}
	 
	/**
	* Title: MenuController.java
	* Description: 修改菜单
	* @param menu
	* @return
	* @author HuangJian
	* @date 2017年4月2日
	*/
	@RequestMapping("/menu/updatemenu")
	@ResponseBody
	public String updateMenu(TMenu menu){
		retParam=new HashMap<>();
		int result = 0;
		result = menuService.updateBaseMenu(menu);
		retParam.put("status", result);
		String msg="异常";
		if(result > 0){
			msg="修改成功";
		}else{
			msg="修改失败";
		}
		retParam.put("message", msg);
		return new Gson().toJson(retParam);
	}
	/**
	* Title: MenuController.java
	* Description: 根据菜单查询
	* @param mId  菜单ID
	* @return
	* @author HuangJian
	* @date 2017年4月4日
	*/
	@RequestMapping("/menu/getmenubyid")
	@ResponseBody
	public String getMenuByMenuId(Integer mId){
		retParam=new HashMap<>();
		TMenu menu =  menuService.selectBaseMenuById(mId);
		TMenu pMenu = menuService.selectBaseMenuByPid(Integer.parseInt(menu.getMenuPid()));
		retParam.put("menu", menu);//菜单
		retParam.put("pMenu", pMenu);//父菜单
		return new Gson().toJson(retParam);
	}
	
	 
	/**
	* Title: MenuController.java
	* Description: 
	* @param id
	* @return
	* @author HuangJian
	* @date 2017年4月4日
	*/
	@RequestMapping("/menu/deletebyid")
	@ResponseBody
	public String deleteMenu(@RequestParam("mids[]") Integer [] mids) {
		int result = 0;
		if(mids.length > 0){
			TOpeartion record = new TOpeartion();
			record.setOpeartionAdminId(this.getLogUserId());
			record.setOpeartionInfo("删除菜单");
			record.setOpeartionType(ConstantVo.OPT_MENU_TYPE);
			for(int i=0;i<mids.length;i++){
				result = menuService.deleteBaseMenuById(mids[i]);
				//操作记录
				record.setOpeartionById(mids[i]);
				opeartionService.saveOpeartion(record);
			}
		}
		return new Gson().toJson(result);
	}

	/*
	 * 
	* Title: checkMenuPowerid
	* Description: 检查标识是否存在
	* @author HuangJian
	* @date 2017年1月9日
	 */
	@RequestMapping("/menu/checkpowerid")
	@ResponseBody
	public String checkMenuPowerid(String powerid) {
		Integer count = 0;
		List<TMenu> list = menuService.selectBaseMenuByPowerid(powerid);
		count = list.size();
		return new Gson().toJson(count);
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

}
