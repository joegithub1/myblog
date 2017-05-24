/**
* @author HuangJian
* @date 2017年3月9日
*/
package com.joe.myblog.oa.controller;

 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.joe.myblog.oa.po.TAdmin;
import com.joe.myblog.oa.service.UserService;
import com.joe.myblog.oa.utils.ConstantVo;
import com.joe.myblog.oa.utils.DES3Util;
import com.joe.myblog.oa.utils.EmailUtil;
import com.joe.myblog.oa.utils.MD5Util;
import com.joe.myblog.oa.vo.UserVo;

@Controller
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	
	/**
	 * Title: userLoginPage Description: 去登录页面
	 * 游客模式
	 * @return
	 * @author HuangJian
	 * @date 2017年3月9日
	 */
	@RequestMapping(value = "/blog",method=RequestMethod.GET)
	public String userLoginPage(Model model) {
		TAdmin user = new TAdmin();
		user.setBackuserMobliePhone(ConstantVo.GUEST_USER_NAME);
		user.setBackuserPwd(ConstantVo.GUEST_USER_PWD);
		int result = userService.userLogin(user);
		
		return "redirect:/blog/home";
		//return "/login/login";
	}
	/**
	* Title: UserController.java
	* Description: 去登录页面
	* @return
	* @author HuangJian
	* @date 2017年5月5日
	*/
	@RequestMapping(value = "/blog/login")
	public String userLoginPagePost() {
		userService.logOut();
		return "/login/login";
	}
	/**
	* Title: UserController.java
	* Description: 用户登录
	* @param model
	* @param user
	* @return
	* @author HuangJian
	* @date 2017年5月5日
	*/
	@RequestMapping(value="/blog/bloglogin",method=RequestMethod.POST)
	public String blogLogin(Model model, TAdmin user) {
		if(null == user || StringUtils.isEmpty(user.getBackuserMobliePhone())){
			model.addAttribute("err", "用户名不能为空");
			return "forward:/blog/login";
		}
		if(StringUtils.isEmpty(user.getBackuserPwd())){
			model.addAttribute("err", "密码不能为空");
			return "forward:/blog/login";
		}
		Subject subject = SecurityUtils.getSubject();
		
		
		int result = userService.userLogin(user);
		String errInfo = "ok";
		switch (result) {
		case UserVo.USER_VAIL_RESULT_NULL:
			errInfo = "账号不存在";
			break;
		case UserVo.USER_VAIL_RESULT_BLOG:
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
		
		try {
			if ("ok".equals(errInfo)) {
				UsernamePasswordToken token = new UsernamePasswordToken(user.getBackuserMobliePhone(), user.getBackuserPwd());
				
				subject.login(token);
				if(subject.isAuthenticated()){
					//登录成功
				}
				model.addAttribute("userName", user.getBackuserName());
				return "redirect:/blog/home";
			} else {
				model.addAttribute("err", errInfo);
				return "forward:/blog/login";
			}
		} catch (AuthenticationException e) {
			model.addAttribute("err", e);
			e.printStackTrace();
			return "forward:/blog/login";
		}
		
		//return null;
	}

	@RequestMapping(value = "/blog/home")
	public String loginHome(Model model) {
		if(this.request.getSession().getAttribute("userVo") == null){
			return "redirect:/blog";
		}
		return "/layout/bloghome";
	}

	@RequestMapping("/blog/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.logout();
			this.userService.logOut();
		} catch (Exception e) {

		}

		return "redirect:/blog";
	}

	/**
	* Title: UserController.java
	* Description: 去注册页面
	* @param model
	* @return
	* @author HuangJian
	* @date 2017年5月9日
	*/
	@RequestMapping("/problog/registerpage")
	public String userRegisterPage(Model model){
		
		return "/register/userRegister";
	}
	/**
	* Title: UserController.java
	* Description: 注册用户
	* @param model
	* @param user
	* @return
	* @author HuangJian
	* @date 2017年5月9日
	*/
	@RequestMapping("/problog/register")
	@ResponseBody
	public String userRegister(Model model,TAdmin user){
		user.setBackuserRoleId(ConstantVo.USER_DEFAULT_ROLE);
		user.setBackuserPwd(MD5Util.md5(user.getBackuserPwd()));
		int id = userService.saveUser(user);
		return new Gson().toJson(id);
	}
	
	/**
	* Title: UserController.java
	* Description: 查询用户名是否存在
	* @param userName
	* @return
	* @author HuangJian
	* @date 2017年5月9日
	*/
	@RequestMapping("/problog/isexistun")
	@ResponseBody
	public String isExistUserName(String userName){
		int count=0;
		List<TAdmin> users =  userService.getUserByUserName(userName);
		count = users.size();
		return new Gson().toJson(count);
	}
	
	/**
	* Title: UserController.java
	* Description: 查询手机号码是否存在
	* @param mobilePhone
	* @return
	* @author HuangJian
	* @date 2017年5月9日
	*/
	@RequestMapping("/problog/isexismp")
	@ResponseBody
	public String isExistMobilePhone(String mobilePhone){
		int count=0;
		count = userService.getIsExistMobilePhone(mobilePhone);
		return new Gson().toJson(count);
	}
	
	/**
	* Title: UserController.java
	* Description: 查询手机号码绑定的邮箱，发送验证码
	* @param mobilePhone
	* @return
	* @author HuangJian
	* @date 2017年5月10日
	*/
	@RequestMapping("/problog/sednemailcode")
	@ResponseBody
	public String sendEmailMessage(String mobilePhoneNum){
		//先清除session AUTH_COAD 的信息
		//this.request.getSession().removeAttribute(ConstantVo.AUTH_COAD);
		
		//Map<String, Object> userMap = new HashMap<>();
		Map<String, Object> param;//=new HashMap<>();
		//int random = (int)((Math.random()*9+1)*100000);
		TAdmin user = userService.selectUserByMobilePhone(mobilePhoneNum);
		if(user == null){
			param=new HashMap<>();
			param.put("result", "0");
			param.put("message", mobilePhoneNum+"没有注册");
		}else{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			System.out.println(sdf.format(c.getTime()));
			c.add(Calendar.MINUTE, 2);//HOUR_OF_DAY
			String data = sdf.format(c.getTime())+"&"+user.getBackuserId();
			//加密过的key
			String key = DES3Util.encryptCode(data);
			
			
			StringBuffer sb=new StringBuffer("");
			sb.append(this.selectValueByKey(ConstantVo.CONFIG_DOMAIN_PR)+"/problog/repassword");
			sb.append("?key=");
			sb.append(key);
			param = EmailUtil.userSendMessage(user.getUserEmail(), sb.toString());
			String retRes = String.valueOf(param.get("result"));
			if("1".equals(retRes)){
				param.put("message", "发送邮件成功");
				param.put("result", "1");
				
				String e=user.getUserEmail();
				String str1 = e.substring(0, 3);
				String str2=e.substring(e.indexOf("@"));
				String str3=str1+"***"+str2;
				
				param.put("email", str3);
				param.put("message", "系统已将密码重置的链接发送到了您的邮箱"+str3+",请在2个小时内完成密码重置操作.");
				//userMap.put("mobilePhoneNum", mobilePhone);
				//userMap.put("code", random);
				//this.request.getSession().setAttribute(ConstantVo.AUTH_COAD, userMap);
			}else{
				param.put("message", "发送邮件失败");
				param.put("result", "0");
			}
			
			
		}
		
		return new Gson().toJson(param);
	}
	/**
	* Title: UserController.java
	* Description: 验证发送的验证码与输入的验证码是否匹配
	* @param code
	* @param mobilePhoneNum
	* @return
	* @author HuangJian
	* @date 2017年5月10日
	*/
	@RequestMapping("/problog/authcode")
	@ResponseBody
	public String authCode(String mobilePhoneNum){
		Map<String, Object> param=new HashMap<>();
		String mess="";
		String result="0";
		TAdmin user = userService.selectUserByMobilePhone(mobilePhoneNum);
		if(null == user){
			mess="手机号码错误,并没有注册";
		}else{
			//如果输入的手机号和验证码 和 session的数据比较
			Map<String, Object> sessionData = (Map<String, Object>) this.request.getSession().getAttribute(ConstantVo.AUTH_COAD);
			if(sessionData == null){
				mess="没有发送验证码";
				
			}else{
				String tempCode = String.valueOf(sessionData.get("code"));
				String tempMp = String.valueOf(sessionData.get("mobilePhoneNum"));
				
				if(StringUtils.isBlank(tempMp)){
					mess="请填写手机号码";
				}else if(StringUtils.isBlank(tempCode)){
					mess="请填写验证码";
				}else{
					/*if(tempCode.equals(code) && tempMp.equals(mobilePhoneNum)){
						result="1";
						mess="验证成功";
					}else{
						result="0";
						mess="验证失败";
					}*/
					
					param.put("mid", user.getBackuserId());
				}
			}
		}
		
		
		param.put("result", result);
		param.put("message", mess);
		return new Gson().toJson(param);
	}
	/**
	* Title: UserController.java
	* Description: 去密码重置页面
	* @param model
	* @param mid
	* @return
	* @author HuangJian
	* @date 2017年5月16日
	*/
	@RequestMapping("/problog/repassword")
	public String toRePassword(Model model,String key){
		/**
		 * 加密一些数据  key = 用户id 当前日期   (当前日期+2小时作为过期日期)
		 */
		model.addAttribute("key", key);
		return "/register/rePassword";
	}
	/**
	* Title: UserController.java
	* Description: 重置密码
	* @param npwd
	* @param mid
	* @return
	* @author HuangJian
	* @date 2017年5月16日
	*/
	@RequestMapping("/problog/comrepassword")
	@ResponseBody
	public String rePassword(String npwd,String key){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/**
		 * 解密数据  key
		 */
		int res = 0;
		//解密
		String deEncryp = DES3Util.deEncryptCode(key);
		//结束修改日期+user id
		String [] userInfo = deEncryp.split("&");
		if(userInfo.length > 0){
			String now = sdf.format(new Date());
			//now 要小于结束日期才有效
			if(now.compareTo(userInfo[0]) == -1){
				TAdmin user = new TAdmin();
				user.setBackuserId(Integer.parseInt(userInfo[1]));
				user.setBackuserPwd(MD5Util.md5(npwd.trim()));
				res = userService.updateUser(user);
			}
			
		}
		
		
		return new Gson().toJson(res);
	}
}
