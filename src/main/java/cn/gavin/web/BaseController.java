package cn.gavin.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;

import cn.gavin.domain.User;

public class BaseController {
	protected static final String ERROR_MSG_KEY="error_Msg";
	
	//1.获取保存在Session中的用户对象
	protected User getSessionUser(HttpServletRequest request){
		return (User)request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
		
	}
	
	//2.将用户对象保存到Session中
	protected void setSessionUser(HttpServletRequest request,User user){
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
	}
	
	//获取基于应用程序的URL绝对路径
	public final String getAppbaseUrl(HttpServletRequest request,String user){
		Assert.hasLength();
	}
}
