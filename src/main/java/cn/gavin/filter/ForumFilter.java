package cn.gavin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.jpamodelgen.util.StringUtil;
import org.hibernate.loader.custom.Return;
import org.springframework.http.HttpRequest;

import cn.gavin.commonConstants.Constants;
import cn.gavin.domain.User;

/**
 * 
 * @author Gavin
 * @2017年6月1日
 * 
 */

public class ForumFilter implements Filter{
	private static final String FILTERED_REQUEST="@@session_context_filtered_request";
	//不需要登陆即可访问的URI资源
	private static final String[] INHERENT_ESCAPE_URIS={"/index.jsp","/index.html","/login.jsp",
														"/login/doLogin.html","/register.jsp",
														"/register.html","/board/listBoardTopics-",
														"/board/listTopicPosts-"};

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	//执行过滤
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//保证该过滤器在一次请求中只被调用一次
		if (request!=null&&request.getAttribute(FILTERED_REQUEST)!=null) {
			chain.doFilter(request, response);
			
		}else {
			//设置过滤标识，防止一次请求多次过滤
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
			HttpServletRequest httpServletRequest=(HttpServletRequest) request;
			User userContext =getSessionUser(httpServletRequest);
			//用户未登陆，且当前URI资源需要登陆才能访问
			if (userContext==null&&!isURILogin(httpServletRequest.getRequestURI(),httpServletRequest)) {
				String toUrl=httpServletRequest.getRequestURL().toString();
				if (!StringUtils.isEmpty(httpServletRequest.getQueryString())) {
					toUrl+="?"+httpServletRequest.getQueryString();
				}
				//将用户的请求URL保存在session中，用于登陆成功之后，调到目标URL
				httpServletRequest.getSession().setAttribute(Constants.LOGIN_TO_URL, toUrl);
				//转发到登陆页面
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
			chain.doFilter(request, response);
		}
		
	}
	//更新后请删除
	private User getSessionUser(HttpServletRequest httpServletRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	private boolean isURILogin(String requestURI,HttpServletRequest request){
		if (request.getContextPath().equalsIgnoreCase(requestURI)||(request.getContextPath()+"/").equalsIgnoreCase(requestURI))
			return true;
		for (String uri:INHERENT_ESCAPE_URIS){
			if (requestURI!=null&&requestURI.indexOf(uri)>=0) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}
