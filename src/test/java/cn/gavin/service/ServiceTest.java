package cn.gavin.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.gavin.domain.User;
import cn.gavin.exception.UserExistsException;
import cn.gavin.service.UserService;

public class ServiceTest {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testRegister() throws UserExistsException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserService us=(UserService) context.getBean("userService");
		User u =new User();
		u.setUserId(7);
		u.setUserName("selary");
		u.setPassword("1");
		us.register(u);
	}
	@Test
	public void testGetUserById(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserService us=(UserService) context.getBean("userService");
		System.out.println(us.getUserById(1));
	}

}
