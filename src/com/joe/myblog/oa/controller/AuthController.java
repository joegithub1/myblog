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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.joe.myblog.oa.po.TAdmin;
import com.joe.myblog.oa.po.TRole;
import com.joe.myblog.oa.service.AuthService;
import com.joe.myblog.oa.service.MenuService;
import com.joe.myblog.oa.service.UserService;
import com.joe.myblog.oa.utils.ConstantVo;
import com.joe.myblog.oa.vo.MenuVo;
@RequestMapping(value="/blog")
@Controller
public class AuthController extends BaseController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

    public Map<String, Object> paramJson;
    /**
     * 权限管理页面
     * @param model
     * @return
     */
    @RequestMapping("/auth/authmanage")
    public String rolemanage(Model model ,@RequestParam(defaultValue="1") Integer pageNum,@RequestParam(defaultValue=ConstantVo.PAGE_SIZE,required=true) Integer pageSize){
    	PageHelper.startPage(pageNum, pageSize);
        List<TRole> roles = this.authService.findRole();
        PageInfo<TRole> pi = new PageInfo<>(roles);
        List<MenuVo> menuVos = this.menuService.selectMenu();
       /* List<Map<String, Object>> userAll = this.authService.selectUser();
        List<Map<String, Object>> noAuth = new ArrayList<>();
        for (Map<String, Object> a : userAll) {
 			if((Integer)a.get("backuser_role_id") == 0){
 				noAuth.add(a);
 			}
 		}
        model.addAttribute("noAuth",noAuth);//未分配的角色        
*/        model.addAttribute("menuVos",menuVos);
        model.addAttribute("roles",pi);
        return "/systemManage/auth/authManage";
    }


    /**
    * Title: AuthController.java
    * Description: 查询已分配的人员和未分配的人员
    * @param roleId
    * @return
    * @throws IOException
    * @author HuangJian
    * @date 2017年4月8日
    */
    @RequestMapping("/auth/selectWorkerAuth")
    @ResponseBody
    public String selectWorkerAuth(Integer roleId) throws IOException {
    	paramJson=new HashMap<>();
		try {
			//已分配
			List<Map<String,Object>> userRoleAll = this.authService.selectBUByTypeARole(roleId);
			//未分配用户
			List<Map<String,Object>> haveAuth = authService.selectBUByTypeARole(ConstantVo.DEFAULT_ROLE);
			
			 paramJson.put("haveAuth", haveAuth);
			 paramJson.put("assiAuth", userRoleAll);
			 return new Gson().toJson(paramJson);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return null;
    }
    
    
    /**
    * Title: AuthController.java
    * Description: 保存角色
    * @param role
    * @param authStr
    * @param menuStr
    * @return
    * @throws Exception
    * @author HuangJian
    * @date 2017年4月8日
    */
    @RequestMapping("/auth/saverole")
    @ResponseBody
    public String saveRole(TRole role,
    		@RequestParam(value = "authStr",required = false) String[] authStr,
    		@RequestParam(value = "menuStr",required = false) String[] menuStr) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	role.setRoleCreatedate(simpleDateFormat.format(new Date()));
        role.setRoleOperatorid(this.getLogUserId());
        role.setRoleIsdel("0");
        int result = this.authService.insertRole(role,authStr,menuStr);
        Map<String,Object> info = new HashMap<>();
		if (result != 0) {
			info.put("status", true);
			info.put("message", "角色保存成功!");
		} else {
			info.put("status", false);
			info.put("message", "角色保存失败！");
		}
        return new Gson().toJson(info);
    }

    /**
    * Title: AuthController.java
    * Description: 删除角色
    * @param roleId
    * @return
    * @author HuangJian
    * @date 2017年3月18日
    */
    @RequestMapping(value="/auth/deleterole/{roleId}",method=RequestMethod.POST)
    @ResponseBody
    public String delRole(@PathVariable(value = "roleId") Integer roleId){
    	Map<String, Object> param=new HashMap<>();
    	param.put("roleId", roleId);
    	param.put("operation", this.getLogUserId());
        int result = this.authService.delectRoleById(param);
        Map<String, Object> info = new HashMap<>();
		if (result != 0) {
			info.put("status", true);
			info.put("message", "删除成功");
		} else {
			info.put("status", false);
			info.put("message", "删除失败");
		}
        return new Gson().toJson(info);
    }


    /**
    * Title: AuthController.java
    * Description: 根据角色ID查询信息
    * @param roleId
    * @return
    * @throws IOException
    * @author HuangJian
    * @date 2017年4月8日
    */
    @RequestMapping("/auth/getrolebyid/{roleId}")
    @ResponseBody
    public String getRoleInfo(@PathVariable(value = "roleId") Integer roleId) throws IOException {
        List<Integer> authIds = this.authService.selectAutoIdsByRoleId(roleId);
        List<Integer> menuIds = this.authService.selectMenuIdsByRoleId(roleId);
        TRole role = authService.getRoleById(roleId);
        paramJson=new HashMap<>();
        paramJson.put("authIds",authIds);
        paramJson.put("menuIds",menuIds);
        
        paramJson.put("roleInfo", role);
        return new Gson().toJson(paramJson);
    }

    /**
    * Title: AuthController.java
    * Description: 修改角色
    * @param role
    * @param authStr
    * @param menuStr
    * @return
    * @throws Exception
    * @author HuangJian
    * @date 2017年4月8日
    */
    @RequestMapping("/auth/updaterole")
    @ResponseBody
    public String updateRole(TRole role,
    		@RequestParam(value = "authStr",required = false) String[] authStr,
    		@RequestParam(value = "menuStr",required = false) String[] menuStr) throws Exception{
        int result = this.authService.updateRole(role,authStr,menuStr,this.getLogUserId());
        Map<String,Object> info = new HashMap<>();
		if (result != 0) {
			info.put("status", true);
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
				 
			}	*/
		} else {
			info.put("status", false);
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
    
    /**
    * Title: AuthController.java
    * Description: 保存分配好的权限
    * @param oldUserId
    * @param newUserId
    * @param roleId
    * @return
    * @author HuangJian
    * @date 2017年3月16日
    */
    @Deprecated
    @RequestMapping("/blog/updateAuthRole")
    @ResponseBody
    public String updateAuthRole(String oldUserId , String newUserId , Integer roleId){
    	Integer result = authService.updateAuthRole(oldUserId , newUserId , roleId);
        paramJson = new HashMap<>();
		if (result != 0) {
			paramJson.put("result", true);
			paramJson.put("message", "权限分配成功!");
		} else {
			paramJson.put("result", false);
			paramJson.put("message", "权限分配失败！");
		}
        return new Gson().toJson(paramJson);
    }

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
    
	/**
	* Title: AuthController.java
	* Description: 修改用户角色根据用户ID
	* @param userId 用户ID
	* @param roleId 角色ID
	* @param flag 1:取消角色分配   0:分配当前角色
	* @return
	* @author HuangJian
	* @date 2017年3月18日
	*/
	@RequestMapping("/auth/updateuserrole")
	@ResponseBody
	public String updateAuthByUserId(Integer userId,Integer roleId,Integer flag){
		Integer result=0;
		TAdmin user = new TAdmin();
		user.setBackuserId(userId);
		if(0 == flag){//分配
			user.setBackuserRoleId(roleId);
		}else if(1 == flag){//取消分配
			user.setBackuserRoleId(0);
		}
		result = userService.updateUser(user);
		return new Gson().toJson(result);
	}
}
