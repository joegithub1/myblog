package com.joe.myblog.oa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jdt.internal.compiler.lookup.ReductionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.myblog.oa.mapper.TAdminMapper;
import com.joe.myblog.oa.mapper.TMenuMapper;
import com.joe.myblog.oa.po.TAdmin;
import com.joe.myblog.oa.po.TMenu;
import com.joe.myblog.oa.service.UserService;
import com.joe.myblog.oa.utils.MD5Util;
import com.joe.myblog.oa.vo.UserVo;

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
	
	/**
	 * 健身房工作人员
	 * 
	 * @param userId
	 * @return
	 */
	private List<TMenu> getWorkerList(int userId) {
		Map<String,Object> map = new HashMap<>();
		map.put("userId", userId);
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
				if (lb.size() > 1) {
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
	private String initUserMenu(int userId) {
		return this.resoleMenu(getWorkerList(userId));
	}
	/**
	 * 初始化用户信息
	 * 
	 * @param userId
	 */
	public void initUserInfo(Integer userId) {
		TAdmin user = this.adminMapper.selectByPrimaryKey(userId);
		String menuJson = initUserMenu(userId);
		UserVo userVo = new UserVo();
		user.setBackuserPwd(null);
		userVo.setUser(user);
		userVo.setMenuJson(menuJson);
		
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
				return UserVo.USER_VAIL_RESULT_JIAN;
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
	
	

}
