package cn.gavin.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.gavin.domain.User;

/**
 * 
 * @author Gavin
 * @2017年7月4日
 */

@Controller
public class ShiroController {
private static final Logger logger = LoggerFactory.getLogger(ShiroController.class);
    
    /**
     * 判断用户是否登录
     * @param currUser
     * @return
     */
    @RequestMapping(value = "/shiroLoginin",method=RequestMethod.POST)
    public String isLogin(User currUser){
    	logger.info("进入");
        Subject user = SecurityUtils.getSubject();
        
      //加密（md5+盐），返回一个32位的字符串小写  
//        String salt="("+request.getParameter("username")+")";    
//        String md5Pwd=new Md5Hash(request.getParameter("password"),salt).toString();
        
        
        //传递token给shiro的realm 
        UsernamePasswordToken token = new UsernamePasswordToken(currUser.getUserName(),currUser.getPassword());
        
//      但是，“已记住”和“已认证”是有区别的： 
//      已记住的用户仅仅是非匿名用户，你可以通过subject.getPrincipals()获取用户信息。但是它并非是完全认证通过的用户，当你访问需要认证用户的功能时，你仍然需要重新提交认证信息。 
//      这一区别可以参考亚马逊网站，网站会默认记住登录的用户，再次访问网站时，对于非敏感的页面功能，页面上会显示记住的用户信息，但是当你访问网站账户信息时仍然需要再次进行登录认证。 
        token.setRememberMe(true);
        System.out.println(currUser);
        try {
        	//这句是提交申请，验证能不能通过，也就是交给公安局同志了。这里会回调reaml里的一个方法
            // 回调doGetAuthenticationInfo，进行认证
            user.login(token);
            return "/success";
        }catch (AuthenticationException e) {
            logger.error("登录失败错误信息:"+e);
            token.clear();
            return "/failure";
        }
    }
}
