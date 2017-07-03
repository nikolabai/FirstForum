package cn.gavin.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.loader.custom.Return;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.gavin.cons.Constants;
import cn.gavin.domain.User;
import cn.gavin.service.UserService;

/**
 * 
 * @author Gavin
 * @2017年5月31日
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	@Autowired
	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	//用户登陆
	@RequestMapping("/doLogin")
	public ModelAndView login(HttpServletRequest request,User user){
		logger.info("调用controller");
		
		User dbUser =userService.getUserByUserName(user.getUserName());
		ModelAndView mav=new  ModelAndView();
		mav.setViewName("forward:login");
		
		if (dbUser==null) {
			mav.addObject("errorMsg","用户名不存在");
			
		} else if(!dbUser.getPassword().equals(user.getPassword())){
			mav.addObject("errorMsg","密码不正确");
		}else if(dbUser.getLocked()==1){
			mav.addObject("errorMsg","用户已锁定，不能登陆");
		}else{
			dbUser.setLastIp(request.getRemoteAddr());
			dbUser.setLastVisit(new Date());
			userService.loginSuccess(dbUser);
			setSessionUser(request, dbUser);
//			String toUrl = (String) request.getSession().getAttribute(Constants.LOGIN_TO_URL);
//			request.getSession().removeAttribute(Constants.LOGIN_TO_URL);
//			//如果当前会话中没有保存登陆之前的请求URL，则直接跳转的主页
//			if (StringUtils.isEmpty(toUrl)) {
//				toUrl="/index.html";
//			}
//			mav.setViewName("redirect:"+toUrl);
			mav.setViewName("/success");
			
		}
		return  mav;
	}
	//登陆注销
	@RequestMapping("/doLogout")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.USER_CONTEXT);
		return "forward:/index.jsp";
	}

}
