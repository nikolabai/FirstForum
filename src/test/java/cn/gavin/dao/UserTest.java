package cn.gavin.dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.gavin.domain.User;
import cn.gavin.exception.UserExistsException;
import cn.gavin.service.UserService;

public class UserTest {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws UserExistsException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		User u =new User();
		u.setUserId(4);
		u.setUserName("nikola");
		u.setPassword("123");
		ud.save(u);
		
	}

}
