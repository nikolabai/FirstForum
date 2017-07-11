package cn.gavin.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import cn.gavin.domain.User;
import cn.gavin.exception.UserExistsException;
import junit.framework.TestCase;

public class UsrDaoTest extends TestCase{
	

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
		u.setUserid(9);
		u.setUserName("tom");
		u.setPassword("12345");
		ud.save(u);
	}
	@Test
	public void testLoad() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		System.out.println(ud.load(1)); 
	}
	@Test
	public void testGet() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		System.out.println(ud.load(1)); 
	}
	@Test
	public void testRemove() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		ud.remove(ud.load(10));
	}
	@Test
	public void testGetUserByUserName(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		System.out.println(ud.getUserByUserName("tom"));
	}
	@Test
	public void testQueryUserByUserName(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		System.out.println(ud.queryUserByUserName("tom"));
	}
	@Test
	public void testUpdate()  {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		User u =ud.get(1);
		u.setPassword("12");
		ud.update(u);
	}
	@Test
	public void testFind()  {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		String aString = "from User u where u.password=12345";
		System.out.println(ud.find(aString));
	}
	@Test
	public void testGetCount()  {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		String aString = "select count(*)  from User";
		System.out.println(ud.getCount(aString));
	}
	
}
