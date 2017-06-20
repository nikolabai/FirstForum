package cn.gavin.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gavin.domain.User;
import cn.gavin.exception.UserExistsException;
import junit.framework.TestCase;

public class DaoTest extends TestCase{
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("开始");
	}
	//Done
	@Test
	public void testSave() throws UserExistsException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		User u =new User();
		u.setUserId(9);
		u.setUserName("du");
		u.setPassword("12345");
		ud.save(u);
	}
	@Test
	public User testGetUserByUserName(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		return ud.getUserByUserName("tom");
	}
	@Test
	public void testUpdate()  {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		User u =ud.get(1);
		u.setPassword("1234567");
		ud.update(u);
	}
	@Test
	public void testRemove() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		User u =new User();
		u.setUserId(5);
		ud.remove(u);
	}
	@Test
	public User load() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		return ud.load(1);
	}
}
