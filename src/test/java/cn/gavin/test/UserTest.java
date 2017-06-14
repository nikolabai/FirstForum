package cn.gavin.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.gavin.domain.User;
import cn.gavin.exception.UserExistsException;
import cn.gavin.service.UserService;
import cn.gavin.web.RegisterController;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath:spring.xml")  
@Transactional  
public class UserTest extends AbstractJUnit4SpringContextTests{
	@Resource
	private UserService userService;
//	@Autowired    
//	private ApplicationContext appplicationContext; //自动注入applicationContext，这样就可以使用appli*.getBean("beanName")    

	
	
	    
    @Transactional  //使用该注释会使用事务，而且在测试完成之后会回滚事务，也就是说在该方法中做出的一切操作都不会对数据库中的数据产生任何影响    
    @Rollback(false) //这里设置为false，就让事务不回滚
	@Test 
	public void saveUser() throws UserExistsException {
		
		User u =new User();
		u.setUserName("jack");
		u.setPassword("123");
		userService.register(u);
		
	}
	

}
