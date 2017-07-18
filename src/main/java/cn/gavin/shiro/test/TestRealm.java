package cn.gavin.shiro.test;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.gavin.shiro.realm.UserRealm;
/**
 * 1\静态资源测试realm授权验证
 * @author Gavin
 * @2017年7月13日
 */
public class TestRealm extends AuthorizingRealm{
private static final Logger logger =LoggerFactory.getLogger(UserRealm.class);
    
    /***
	 * 获取授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		logger.info("----------doGetAuthorizationInfo方法被调用----------");
        String username = (String) getAvailablePrincipal(pc);
        //通过用户名从数据库获取权限字符串
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //权限
        Set<String> s = new HashSet<String>();
        s.add("printer:print");
        s.add("printer:query");
        info.setStringPermissions(s);
        //角色
        Set<String> r = new HashSet<String>();
        r.add("role1");
        info.setRoles(r);

        return info;
	}
    
    /**
     *  登陆认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
    	logger.info("进入登陆TESTrealm");
    	//用户名
        String username = (String) authcToken.getPrincipal();
        logger.info("username:"+username);
        //密码
        String password = new String((char[])authcToken.getCredentials());
        logger.info("password:"+password);
        //从数据库获取用户名密码进行匹配，这里为了方面，省略数据库操作
        if(!"admin".equals(username)){
            throw new UnknownAccountException();
        }
        if(!"123".equals(password)){
            throw new IncorrectCredentialsException();
        }
        //身份验证通过,返回一个身份信息
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username,password,getName());

        return aInfo;
    }

}
