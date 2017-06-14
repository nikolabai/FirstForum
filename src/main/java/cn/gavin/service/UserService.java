package cn.gavin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import cn.gavin.dao.LoginLogDao;
import cn.gavin.dao.UserDao;
import cn.gavin.domain.LoginLog;
import cn.gavin.domain.User;
import cn.gavin.exception.UserExistsException;

/**
 * 
 * @author Gavin
 * @2017年5月29日
 */
//用户管理服务器，负责查询用户、注册用户、锁定用户等操作
@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;
	
	//注册一个新用户，如果用户名已经存在则抛出UserExistException的异常
	@Transactional
	public void register(User user)throws UserExistsException{
		User u = this.getUserByUserName(user.getUserName());
		if(u!=null){
			throw new UserExistsException("用户名已经存在");
			
		}else{
			user.setCredit(100);
			user.setUserType(1);
			userDao.save(user);
		}
	}
	//根据用户名密码查询User对象
	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}
	//根据用户id加载User对象
	public User getUserById(int userId){
		return userDao.get(userId);
	}
	//将用户锁定，锁定的用户不能够登陆
	public void lockUser(String userName){
		User user = userDao.getUserByUserName(userName);
		user.setLocked(1);
	}
	//接触用户锁定
	public void unlockUser(String userName){
		User user = userDao.getUserByUserName(userName);
		user.setLocked(0);
	}
	//根据用户名为条件，执行模糊查询操作
	public List<User> queryUserByUserName(String userName){
		return userDao.queryUserByUserName(userName);
	}
	
	//登陆成功,用户积分加5，并记录日志
	public void loginSuccess(User user){
		user.setCredit(5+user.getCredit());
		LoginLog loginLog = new LoginLog();
		loginLog.setUser(user);
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(new Date());
		
	}
}
