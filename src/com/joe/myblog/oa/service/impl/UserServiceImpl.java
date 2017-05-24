package com.joe.myblog.oa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.myblog.oa.mapper.TAdminAuthRefMapper;
import com.joe.myblog.oa.mapper.TAdminMapper;
import com.joe.myblog.oa.mapper.TMenuAdminRefMapper;
import com.joe.myblog.oa.mapper.TMenuMapper;
import com.joe.myblog.oa.mapper.TRoleMapper;
import com.joe.myblog.oa.po.TAdmin;
import com.joe.myblog.oa.po.TAdminExample;
import com.joe.myblog.oa.po.TMenu;
import com.joe.myblog.oa.po.TRole;
import com.joe.myblog.oa.po.TRoleExample;
import com.joe.myblog.oa.service.UserService;
import com.joe.myblog.oa.utils.MD5Util;
import com.joe.myblog.oa.vo.UserVo;
import com.sun.org.apache.bcel.internal.generic.NEW;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private TAdminMapper adminMapper;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private TMenuMapper menuMapper;
	@Autowired
	private TRoleMapper roleMapper;
	@Autowired
	private TAdminAuthRefMapper adminAuthRefMapper;
	@Autowired
	private TMenuAdminRefMapper menuAdminRefMapper;
	/**
	 * 健身房工作人员
	 * 
	 * @param userId
	 * @return
	 */
	private List<TMenu> getWorkerList(TAdmin user) {
		Map<String,Object> map = new HashMap<>();
		map.put("userId", user.getBackuserId());
		map.put("roleId", user.getBackuserRoleId());
		return this.menuMapper.selectUserMenuByUserId(map);
	}
	/**
	 * 解析用户菜单返回json字符串
	 * 
	 * @param menus
	 * @return
	 */
	private String resoleMenu(List<TMenu> menus) {
		JSONObject json = new JSONObject();
		JSONArray list = new JSONArray();
		JSONObject jtemp = new JSONObject();
		JSONArray menu = null;
		List<Map<Integer, List<TMenu>>> mlist = new ArrayList<Map<Integer, List<TMenu>>>();
		List<List<TMenu>> jlist = new ArrayList<List<TMenu>>();
		if (menus != null) {
			// 第一次 start
			for (TMenu bm : menus) {
				if (bm.getMenuIsdel() == 0 && bm.getMenuIsshow() == 1 && bm.getMenuIsroot() == 1) {
					Map<Integer, List<TMenu>> tmap = new HashMap<Integer, List<TMenu>>();
					List<TMenu> tlist = new ArrayList<TMenu>();
					tlist.add(bm);
					jlist.add(tlist);
					tmap.put(bm.getMenuId(), tlist);
					mlist.add(tmap);
				}
			}
			// 第一次 end
			// 第二次 start
			for (int i = 0; i < menus.size(); i++) {
				TMenu bm = menus.get(i);
				if (bm.getMenuIsdel() == 0 && bm.getMenuIsshow() == 1 && bm.getMenuIsroot() == 0) {
					for (Map<Integer, List<TMenu>> tm : mlist) {
						if (tm.get(Integer.parseInt(bm.getMenuPid())) != null && jlist.indexOf(tm.get(Integer.parseInt(bm.getMenuPid()))) != -1
								&& jlist.get(jlist.indexOf(tm.get(Integer.parseInt(bm.getMenuPid())))).indexOf(bm) == -1) {
							tm.get(Integer.parseInt(bm.getMenuPid())).add(bm);
							// jlist.get(jlist.indexOf(tm.get(bm.getMenuPid()))).add(bm);
						}
					}
				}
			}
			// 第二次 end
			for (List<TMenu> lb : jlist) {
				jtemp.clear();
				//原来 lb.size() >　１
				if (lb.size() > 0) {
					menu = JSONArray.fromObject(lb);
					jtemp.put("menu", menu);
					list.add(jtemp);
				}
			}
			json.put("list", list);
		}
		return json.toString();
	}
	
	/**
	 * 初始化用户菜单
	 * 
	 * @return
	 */
	private String initUserMenu(TAdmin user) {
		return this.resoleMenu(getWorkerList(user));
	}
	/**
	 * 初始化用户信息
	 * 
	 * @param userId
	 */
	public void initUserInfo(Integer userId) {
		TAdmin user = this.adminMapper.selectByPrimaryKey(userId);
		String menuJson = initUserMenu(user);
		UserVo userVo = new UserVo();
		user.setBackuserPwd(null);
		userVo.setUser(user);
		userVo.setMenuJson(menuJson);
		if("游客".equals(user.getBackuserName())){
			userVo.setPattern(userVo.VISITOR_PATTERN);
		}else{
			userVo.setPattern(userVo.LOGIN_PATTERN);
		}
		this.request.getSession().setAttribute("userVo", userVo);
	}
	
	@Override
	public int userLogin(TAdmin baseUser) {
		TAdmin user =  adminMapper.selectByUserName(baseUser);
		if(null != user){
			System.out.println(MD5Util.md5(baseUser.getBackuserPwd()));
			if(MD5Util.md5(baseUser.getBackuserPwd()).equals(user.getBackuserPwd())){
				// 登录成功
				initUserInfo(user.getBackuserId());
				return UserVo.USER_VAIL_RESULT_BLOG;
			}else{
				return UserVo.USER_VAIL_RESULT_PSERR;
			}
		}else{
			return UserVo.USER_VAIL_RESULT_NULL;
		}
		 
	}
	@Override
	public void logOut() {
		this.request.getSession().removeAttribute("userVo");
	}
	@Override
	public Integer updateUser(TAdmin user) {
		
		return adminMapper.updateByPrimaryKeySelective(user);
	}
	@Override
	public Set<String> findRolesByUserName(String userName) {
		Set<String> setList = new HashSet<String>();
		UserVo user = (UserVo) this.request.getSession().getAttribute("userVo");
		if(user == null){
			return setList;
		}
		TRole role =  roleMapper.selectByPrimaryKey(user.getUser().getBackuserRoleId());
		if(role != null){
			setList.add(role.getRoleName());
		}
		
		return setList;
	}
	@Override
	public Set<String> findPermissions(String userName) {
		
		Set<String> authSet=new HashSet<>();
		UserVo user = (UserVo) this.request.getSession().getAttribute("userVo");
		if(user == null){
			return authSet;
		}
		Map<String, Object> param=new HashMap<>();
		param.put("rId", user.getUser().getBackuserRoleId());
		//按钮权限标志
		//根据用户roleID查询权限
		List<Map<String,Object>> resultMap =  adminAuthRefMapper.selectAuthByRoleId(param);
		if(resultMap!=null && resultMap.size() > 0){
			//权限标志放入集合中
			for (int i = 0; i < resultMap.size(); i++) {
				Map<String, Object> temp=resultMap.get(i);
				authSet.add(temp.get("auth_powerid").toString());
			}
		}
		//菜单权限标志
		//根据角色查询菜单标志
		List<Map<String,Object>> menuMap =  menuAdminRefMapper.selectMenuRoleRefMyRoleId(user.getUser().getBackuserRoleId());
		if(menuMap !=null && menuMap.size()>0){
			for (int i = 0; i < menuMap.size(); i++) {
				Map<String, Object> temp=menuMap.get(i);
				authSet.add(temp.get("menu_powerid").toString());
			}
		}
		
		return authSet;
	}
	@Override
	public Integer saveUser(TAdmin user) {
		int result = 0;
		try {
			result = adminMapper.insertSelective(user);
			if(result > 0){
				return user.getBackuserId();
			}
		} catch (Exception e) {
			
		}
		
		return result;
		
	}
	@Override
	public List<TAdmin> getUserByUserName(String userName) {
		TAdminExample example = new TAdminExample();
		example.createCriteria().andBackuserNameEqualTo(userName)
		.andStatusEqualTo(0);
		
		return adminMapper.selectByExample(example);
	}
	@Override
	public Integer getIsExistMobilePhone(String mobilePhone) {
		 
		return adminMapper.selectByPhone(mobilePhone);
	}
	@Override
	public TAdmin selectUserByMobilePhone(String mobilePhone) {
		TAdmin user=new TAdmin();
		user.setBackuserMobliePhone(mobilePhone);
		return adminMapper.selectByUserName(user);
	}
	
	
	

}
