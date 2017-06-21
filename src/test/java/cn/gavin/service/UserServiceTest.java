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

public class UserServiceTest {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	//done
	@Test
	public void testRegister() throws UserExistsException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserService us=(UserService) context.getBean("userService");
		User u =new User();
		u.setUserId(10);
		u.setUserName("matin");
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
