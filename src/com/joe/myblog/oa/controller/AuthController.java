package com.joe.myblog.oa.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.joe.myblog.oa.po.TRole;
import com.joe.myblog.oa.service.AuthService;
import com.joe.myblog.oa.service.MenuService;
import com.joe.myblog.oa.service.UserService;
import com.joe.myblog.oa.utils.ConstantVo;
import com.joe.myblog.oa.vo.MenuVo;
import com.joe.myblog.oa.vo.UserVo;

import net.sf.json.JSONObject;

@Controller
public class AuthController extends BaseController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;


    /**
     * 权限管理页面
     * @param model
     * @return
     */
    @RequestMapping("/blog/auth")
    public String rolemanage(Model model ,@RequestParam(defaultValue="1") Integer pageNum,@RequestParam(defaultValue=ConstantVo.pageSize,required=true) Integer pageSize){
    	PageHelper.startPage(pageNum, pageSize);
        List<TRole> roles = this.authService.findRole();
        PageInfo<TRole> pi = new PageInfo<>(roles);
        List<MenuVo> menuVos = this.menuService.selectMenu();
        List<Map<String, Object>> userAll = this.authService.selectUser();
        List<Map<String, Object>> noAuth = new ArrayList<>();
        for (Map<String, Object> a : userAll) {
 			if((Integer)a.get("backuser_role_id") == 0){
 				noAuth.add(a);
 			}
 		}
        model.addAttribute("noAuth",noAuth);
        model.addAttribute("menuVos",menuVos);
        model.addAttribute("roles",pi);
        return "/systemManage/auth/authManage";
    }

    /**
     * 查询角色下的菜单和权限id集合
     * @param roleId
     */
    @RequestMapping("/yundongjia/selectWorkerAuth/{roleId}")
    public String selectWorkerAuth(@PathVariable(value = "roleId") Integer roleId) throws IOException {
    	 List<Map<String,Object>> userAll = this.authService.searchBUByTypeARole(roleId);
         List<Map<String,Object>> haveAuth = new ArrayList<>();
         for (Map<String,Object> a : userAll) {
 			if((Integer)a.get("backuserRoleId") != 0){
 				haveAuth.add(a);
 			}
 		}
        JSONObject json = new JSONObject();
        json.put("haveAuth",haveAuth);
       // this.writeJSONStr(json.toString());
        return new Gson().toJson(json.toString());
    }
    
    /**
     * 添加角色
     * @param role
     * @param authStr
     * @param menuStr
     * @return
     * @throws Exception
     */
    @RequestMapping("/yundongjia/saverole")
    @ResponseBody
    public String saveRole(TRole role,@RequestParam(value = "authStr",required = false) String[] authStr,@RequestParam(value = "menuStr",required = false) String[] menuStr) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	role.setRoleCreatedate(simpleDateFormat.format(new Date()));
        role.setRoleOperatorid(this.getLogUserId());
        role.setRoleIsdel("0");
        int result = this.authService.insertRole(role,authStr,menuStr);
        Map info = new HashMap();
		if (result != 0) {
			info.put("result", true);
			info.put("message", "角色保存成功!");
		} else {
			info.put("result", false);
			info.put("message", "角色保存失败！");
		}
        return new Gson().toJson(info);
    }

    @RequestMapping("/yundongjia/delrole/{roleId}")
    @ResponseBody
    public String delRole(@PathVariable(value = "roleId") Integer roleId){
    	Map<String, Object> param=new HashMap<>();
    	param.put("roleId", roleId);
    	param.put("operation", this.getLogUserId());
        int result = this.authService.delectRoleById(param);
        Map info = new HashMap();
		if (result != 0) {
			info.put("result", true);
			info.put("message", "角色删除成功!");
		} else {
			info.put("result", false);
			info.put("message", "角色删除失败！");
		}
        return new Gson().toJson(info);
    }

    /**
     * 查询角色下的菜单和权限id集合
     * @param roleId
     */
    @RequestMapping("/yundongjia/getroleinfo/{roleId}")
    public String getRoleInfo(@PathVariable(value = "roleId") Integer roleId) throws IOException {
        List<Integer> authIds = this.authService.selectAutoIdsByRoleId(roleId);
        List<Integer> menuIds = this.authService.selectMenuIdsByRoleId(roleId);
        JSONObject json = new JSONObject();
        json.put("authIds",authIds);
        json.put("menuIds",menuIds);
        //this.writeJSONStr(json.toString());
        return new Gson().toJson(json.toString());
    }

    @RequestMapping("/yundongjia/updaterole")
    @ResponseBody
    public String updateRole(TRole role,@RequestParam(value = "authStr",required = false) String[] authStr,@RequestParam(value = "menuStr",required = false) String[] menuStr) throws Exception{
        int result = this.authService.updateRole(role,authStr,menuStr,this.getLogUserId());
        Map info = new HashMap();
		if (result != 0) {
			info.put("result", true);
			info.put("message", "角色更新成功!");
			//重新存入权限标识
			/*try {
				UserVo user = (UserVo) this.request.getSession().getAttribute("userVo");
				Subject subject = SecurityUtils.getSubject(); 
				 
				SimplePrincipalCollection principalCollection = new SimplePrincipalCollection(user.getUser().getBackusername(), userRealm.GYM_REAML_NAME);
				subject.runAs(principalCollection);
				gymRealm.getAuthorizationCache().remove(subject.getPrincipals());
				subject.releaseRunAs();
			} catch (Exception e) {
				 
			}
		} else {*/
			info.put("result", false);
			info.put("message", "角色更新失败！");
		}
        return new Gson().toJson(info);
    }

    @RequestMapping("/yundongjia/selectRoleName")
    @ResponseBody
    public String  selectRoleName(String roleName){
    	Integer result = this.authService.selectRoleName(roleName);
        Map info = new HashMap();
		if (result != 0) {
			info.put("result", true);
		} else {
			info.put("result", false);
		}
        return new Gson().toJson(info);
    }
    
    @RequestMapping("/yundongjia/updateAuthRole")
    @ResponseBody
    public String updateAuthRole(String oldUserId , String newUserId , Integer roleId){
    	Integer result = authService.updateAuthRole(oldUserId , newUserId , roleId);
        Map info = new HashMap();
		if (result != 0) {
			info.put("result", true);
			info.put("message", "权限分配成功!");
		} else {
			info.put("result", false);
			info.put("message", "权限分配失败！");
		}
        return new Gson().toJson(info);
    }

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
    
}
