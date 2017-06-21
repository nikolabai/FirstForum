package cn.gavin.dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

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
		u.setUserId(5);
		u.setUserName("ni");
		u.setPassword("123");
		ud.save(u);
		
	}
	@Test
	public void testGet() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		System.out.println(ud.get(1));
		
	}
	@Test
	@Transactional
	public void testLoad() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		System.out.println(ud.load(2));
		
	}
}
