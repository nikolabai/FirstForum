package cn.gavin.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.gavin.domain.User;
import cn.gavin.service.UserService;
import cn.gavin.shiro.test.Anno;

/**
 * 
 * @author Gavin
 * @2017年7月4日
 */

@Controller
public class ShiroController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(ShiroController.class);
	@Autowired
	private UserService userService;
    /**
     * shiro登陆  授权
     * @param currUser
     * @return
     */
    @RequestMapping(value = "/shirodoLogin",method=RequestMethod.POST)
    public String isLogin(HttpServletRequest request,User currUser){
    	logger.info("进入shirocontroller");
        Subject user = SecurityUtils.getSubject();
        
        //加密（md5+盐），返回一个32位的字符串小写  
        String salt="("+currUser.getUserName()+")";    
        String md5=new Md5Hash(currUser.getPassword(),salt).toString();
        currUser.setPassword(md5);
        
        //传递token给shiro的realm 
        UsernamePasswordToken token = new UsernamePasswordToken(currUser.getUserName(),currUser.getPassword());
        
        //“已记住”和“已认证”是有区别的： 
        //已记住的用户仅仅是非匿名用户，你可以通过subject.getPrincipals()获取用户信息。但是它并非是完全认证通过的用户，当你访问需要认证用户的功能时，你仍然需要重新提交认证信息。 
        //这一区别可以参考亚马逊网站，网站会默认记住登录的用户，再次访问网站时，对于非敏感的页面功能，页面上会显示记住的用户信息，但是当你访问网站账户信息时仍然需要再次进行登录认证。 
        token.setRememberMe(true);
        
        try {
        	//这句是提交申请，验证能不能通过。这里会回调realm里的一个方法doGetAuthenticationInfo
            user.login(token);
            setSessionUser(request, userService.getUserByUserName(currUser.getUserName()));
            return "redirect:/index";
        }catch (AuthenticationException e) {
            logger.error("登录失败错误信息:"+e);
            token.clear();
            return "/failure";
        }
    }
}
