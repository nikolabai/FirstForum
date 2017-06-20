package cn.gavin.dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gavin.domain.User;

public class GetTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		ud.load(1);
	}
	@Test
	public User load() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud=(UserDao) context.getBean("userDao");
		return ud.load(1);
	}
}
