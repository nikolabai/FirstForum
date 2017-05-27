package cn.gavin.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;

import cn.gavin.domain.User;

public class BaseController {
	protected static final String ERROR_MSG_KEY="error_Msg";
//	User user =new User();
	
	//1.获取保存在Session中的用户对象
	protected User getSessionUser(HttpServletRequest request){
		return (User)request.getSession().getAttribute("user");
		
	}
	
	//2.将用户对象保存到Session中
	protected void setSessionUser(HttpServletRequest request,User user){
		request.getSession().setAttribute("user",user);
	}
	
	//获取基于应用程序的URL绝对路径
	public final String getAppbaseUrl(HttpServletRequest request,String url){
		Assert.hasLength(url,"url不能为空");
		Assert.isTrue(url.startsWith("/"),"必须以/打头");
		return request.getContextPath()+url;
	}
}
