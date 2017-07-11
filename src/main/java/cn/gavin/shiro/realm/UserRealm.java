package cn.gavin.shiro.realm;

import org.apache.shiro.realm.AuthorizingRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import cn.gavin.domain.Permission;
import cn.gavin.domain.Role;
import cn.gavin.domain.User;
import cn.gavin.service.UserService;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
/**
 * 
 * @author Gavin
 * @2017年7月4日
 */


public class UserRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;
    
//    protected AuthorizationInfo doGetAuthorizationInfo(
//            PrincipalCollection principals) {
//        
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        //获取当前登录的用户名
//        String account = (String) super.getAvailablePrincipal(principals);
//        
//        List<String> roles = new ArrayList<String>();  
//        List<String> permissions = new ArrayList<String>();
//        User user = userService.getByAccount(account);
//        if(user != null){
//            if (user.getRoles() != null && user.getRoles().size() > 0) {
//                for (Role role : user.getRoles()) {
//                    roles.add(role.getName());
//                    if (role.getPmss() != null && role.getPmss().size() > 0) {
//                        for (Permission pmss : role.getPmss()) {
//                            if(!StringUtils.isEmpty(pmss.getPermission())){
//                                permissions.add(pmss.getPermission());
//                            }
//                        }
//                    }
//                }
//            }
//        }else{
//            throw new AuthorizationException();
//        }
//        //给当前用户设置角色
//        info.addRoles(roles);
//        //给当前用户设置权限
//        info.addStringPermissions(permissions); 
//        return info;
//        
//    }
    
    /** 
     * 添加角色 
     * @param username 
     * @param info 
     */  
//    private void addRole(String username, SimpleAuthorizationInfo info) {  
//        List<Role> roles = roleDao.findByUser(username);  
//        if(roles!=null&&roles.size()>0){  
//            for (Role role : roles) {  
//                info.addRole(role.getRoleName());  
//            }  
//        }  
//    }  
  
    /** 
     * 添加权限 
     * @param username 
     * @param info 
     * @return 
     */  
//    private SimpleAuthorizationInfo addPermission(String username,SimpleAuthorizationInfo info) {  
//        List<Permission> permissions = permissionDao.findPermissionByName(username);  
//        for (Permission permission : permissions) {  
//            info.addStringPermission(permission.getUrl());//添加权限    
//        }  
//        return info;    
//    }    
    
      
    /** 
     * 获取授权信息 
     */  
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {    
//        //用户名    
//        String userName = (String) principals.fromRealm(getName()).iterator().next();   
//        //根据用户名来添加相应的权限和角色  
//        if(!StringUtils.isEmpty(userName)){  
//            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
//            addPermission(userName,info);  
//            addRole(userName, info);  
//            return info;  
//        }  
//        return null;    
//    }  
    /**
     *  登陆认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
    	//令牌——基于用户名和密码的令牌
    	UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = userService.getUserByUserName(token.getUsername());
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getUserName(), user
                    .getPassword(), user.getUserName());
        } else {
            return null;
        }
    }

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
}