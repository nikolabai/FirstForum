package cn.gavin.shiro.realm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotation {
	 public static void main(String[] args) {

	        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	        Anno anno = (Anno)ctx.getBean("anno");

	        anno.login();
	        //有权限时，该方法才正常调用，否则抛异常
	        anno.testAnnotation();

	    }


}
