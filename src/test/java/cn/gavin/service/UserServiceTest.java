package cn.gavin.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.gavin.dao.LoginLogDao;
import cn.gavin.dao.UserDao;
import cn.gavin.domain.LoginLog;
import cn.gavin.domain.User;
import cn.gavin.exception.UserExistsException;
import cn.gavin.service.UserService;


/**
 * 
 * @author Goodbai  2017.6.21
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath:spring.xml")  
@Transactional 
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("开始测试");
	}
	//done
	@Rollback(false) //这里设置为false，就让事务不回滚
	@Test
	public void testRegister() throws UserExistsException {
		User u =new User();
		u.setUserId(14);
		u.setUserName("mhe");
		u.setPassword("1");
		userService.register(u);
	}
	@Test
	public void testGetUserById(){
		System.out.println(userService.getUserById(1));
	}
	@Test
	public void testGetUserByUserName() {
		System.out.println(userService.getUserByUserName("tom"));
	}
	//将用户锁定，锁定的用户不能够登陆
	@Test
	public void testLockUser(){
		userService.lockUser("tom");
	}
	//接触用户锁定
	@Test
	public void testUnlockUser(){
		userService.unlockUser("tom");
	}
	//根据用户名为条件，执行模糊查询操作
	@Test
	public void testQueryUserByUserName(){
		
		System.out.println(userService.queryUserByUserName("tom"));
	}
	
	//登陆成功,用户积分加5，并记录日志
	@Test
	public void testLoginSuccess(){
		User u =userService.getUserById(1);
		userService.loginSuccess(u);
	}

}
