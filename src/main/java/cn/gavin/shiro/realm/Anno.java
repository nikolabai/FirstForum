package cn.gavin.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;



@Service
public class Anno {
	 public void login(){
		 System.out.println("进入anno");

	        Subject currenUser = SecurityUtils.getSubject();
	        UsernamePasswordToken token = new UsernamePasswordToken("admin","123");
	        token.setRememberMe(true);
	        currenUser.login(token);
	    }
	    /**
	     * 有printer:print权限才能调用该方法
	     * 否则抛异常
	     */
	    @RequiresPermissions({"printer:print"})
	    public void testAnnotation(){
	        System.out.println("使用注解方式。。。");
	    }

}
