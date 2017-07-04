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
public class UserController {
private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    /**
     * 判断用户是否登录
     * @param currUser
     * @return
     */
    @RequestMapping(value = "/shirologin",method=RequestMethod.POST)
    public String isLogin(User currUser){
    	logger.info("进入");
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(currUser.getUserName(),currUser.getPassword());
        token.setRememberMe(true);
        try {
            user.login(token);
            return "redirect:/success";
        }catch (AuthenticationException e) {
            logger.error("登录失败错误信息:"+e);
            token.clear();
            return "redirect:/shiro";
        }
    }
}
