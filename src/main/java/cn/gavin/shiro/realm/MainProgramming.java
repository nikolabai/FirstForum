package cn.gavin.shiro.realm;

import org.apache.shiro.SecurityUtils;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 测试shiro授权--变成方式
 * @author Gavin
 * @2017年7月13日
 */

public class MainProgramming {
	private static final Logger logger = LoggerFactory.getLogger(MainProgramming.class);
	public static void main(String[] args) {
		//获取SecurityManager的实例
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject currenUser = SecurityUtils.getSubject();

        //如果还未认证
        if(!currenUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken("admin","123");
            token.setRememberMe(true);
            try {
                currenUser.login(token);
            } catch (UnknownAccountException uae) {
                logger.info("没有该用户： " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                logger.info( token.getPrincipal() + " 的密码不正确!");
            } catch (LockedAccountException lae) {
                logger.info( token.getPrincipal() + " 被锁定 ，请联系管理员");
            }catch (AuthenticationException ae) {
                //其他未知的异常
            }
        }

        if(currenUser.isAuthenticated())
            logger.info("用户 "+currenUser.getPrincipal() +" 登录成功");
        //=====================使用编码方式进行权限和角色的验证==================
        //是否有role1这个角色
        if(currenUser.hasRole("role1")){
            logger.info("有角色role1");
        }else{
            logger.info("没有角色role1");
        }
        //是否有对打印机进行打印操作的权限
        if(currenUser.isPermitted("printer:print")){
            logger.info("可以对打印机进行打印操作");
        }else {
            logger.info("不可以对打印机进行打印操作");
        }
	}
}
