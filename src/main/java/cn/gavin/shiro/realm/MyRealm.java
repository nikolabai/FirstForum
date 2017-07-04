package cn.gavin.shiro.realm;

import org.apache.shiro.realm.AuthorizingRealm;
import org.springframework.beans.factory.annotation.Autowired;
import cn.gavin.domain.User;
import cn.gavin.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
/**
 * 
 * @author Gavin
 * @2017年7月4日
 */


public class MyRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        return null;
    }

    /**
     *  认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = userService.getUserByUserName(token.getUsername());
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getUserName(), user
                    .getPassword(), user.getUserName());
        } else {
            return null;
        }
    }
}