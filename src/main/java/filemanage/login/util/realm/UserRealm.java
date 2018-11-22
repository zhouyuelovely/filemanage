package filemanage.login.util.realm;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import filemanage.login.pojo.User;
import filemanage.login.service.LogService;

/**
 * @author meng
 *
 */
public class UserRealm extends AuthorizingRealm {
	
	private Logger logger=org.apache.log4j.Logger.getLogger(UserRealm.class);
	
	@Autowired
	private LogService logService;


	// 支持什么类型的token
	/*	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}*/

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("登录验证");
		String username = (String) token.getPrincipal();
		logger.info("登录的用户名："+username+"service:"+logService);
		User user = logService.queryUserByUserName(username);
		logger.info("登录的用户:"+user);
		if (user == null) {
			throw new UnknownAccountException();// 没找到帐号
		}
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), // 用户名
				user.getUserPassword(), // 密码
				ByteSource.Util.bytes(user.getCredentialsSalt()),
				getName() // realm name
		);
		logger.info("验证成功");

		return authenticationInfo;
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
