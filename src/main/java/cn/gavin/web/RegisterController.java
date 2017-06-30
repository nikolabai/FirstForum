package cn.gavin.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import cn.gavin.dao.UserDao;
import cn.gavin.domain.User;
import cn.gavin.exception.UserExistsException;
import cn.gavin.service.UserService;
import net.sf.json.JSONObject;

/**
 * 
 * @author Gavin
 * @2017年5月31日
 */
@Controller
public class RegisterController extends BaseController{
	@Autowired
	private UserService userService;
	@Autowired
	private UserDao userDao;
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	//用户注册
	@RequestMapping(value="/register.do")
	public ModelAndView register(HttpServletRequest request, User user){
//	public ModelAndView register(@RequestParam("userName") String userName, @RequestParam("password") String password){
		logger.info("调用controller");
		System.out.println(user);
		ModelAndView view =new ModelAndView();
		view.setViewName("/success");
		try {
			userService.register(user);
		} catch (UserExistsException e) {
			e.printStackTrace();
			view.addObject("errorMsg","用户名已经存在，请选择其他的名字");
			view.setViewName("forward:/register.jsp");
		}
		setSessionUser(request, user);
		return view;
	}
	
	
	
	@RequestMapping(value="/index",method=RequestMethod.GET) 
	public String index(){ 
	return "register"; 
	}
	
	
	@RequestMapping(value="/checkUserName.do",method = RequestMethod.POST)  
    public String checkUserName(HttpServletRequest request, HttpServletResponse response) throws IOException{  
        String userName=(String)request.getParameter("userName");  
        System.out.println(userName);
        System.out.println(request.getParameter("userName"));
        //检验用户名是否存在  
        //用户名是否存在的标志  
        User uz = userDao.getUserByUserName(userName);
        System.out.println("zz");
        System.out.println(uz);//null
        boolean flag;
        if(uz!=null){
			 flag=true;
			System.out.println(flag);
		}else{
			flag=false;
			System.out.println(flag);
		}
        //将数据转换成json  
        Map<String,Object> map = new HashMap<String,Object>();    
        map.put("flag", flag);              
        String json = JSONObject.fromObject(map).toString();          
        //将数据返回  
        response.setCharacterEncoding("UTF-8");  
        response.flushBuffer();  
        response.getWriter().write(json);  
        response.getWriter().flush();    
        response.getWriter().close();  
        return null;  
    }  

}
