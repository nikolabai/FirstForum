package cn.gavin.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.gavin.domain.User;
import cn.gavin.exception.UserExistsException;
import cn.gavin.service.UserService;

/**
 * 
 * @author Gavin
 * @2017年5月31日
 */
@Controller
public class RegisterController extends BaseController{
	@Autowired
	private UserService userService;
	
	//用户登陆
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,User user){
		ModelAndView view =new ModelAndView();
		try {
			userService.register(user);
		} catch (UserExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			view.addObject("errorMsg","用户名已经岑在，请选择其他的名字。");
			view.setViewName("forward:/register.jsp");
		}
		setSessionUser(request, user);
		return view;
		
	}
	

}
