package com.joe.myblog.oa.realm;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.joe.myblog.oa.po.TAdmin;
import com.joe.myblog.oa.service.UserService;
import com.joe.myblog.oa.vo.UserVo;

/**
* Title: UserRealm
* Description: 用户登录
* @author HuangJian
* @date 2017年4月8日
*
*/
public class UserRealm extends AuthorizingRealm{
	@Autowired
	private UserService userService;
	
	@Override
	public String getName() {
		
		return "userShiro";
	}
	//查询角色与权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		String userName = (String) principal.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo= new SimpleAuthorizationInfo();
		if(!StringUtils.isBlank(userName)){
			 
			authorizationInfo.setRoles(userService.findRolesByUserName(userName));
			authorizationInfo.setStringPermissions(userService.findPermissions(userName));
		}
		
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String userName = upToken.getUsername();
		String passWord= String.valueOf(upToken.getPassword());
		TAdmin user = new TAdmin();
		user.setBackuserMobliePhone(userName);
		user.setBackuserPwd(passWord);
		
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

		if ("ok".equals(errInfo)) {
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(userName,passWord,getName());
			return info;
		} else {
			throw new AuthenticationException(errInfo);
		}
		
	}

}
