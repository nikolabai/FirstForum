package cn.gavin.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.gavin.domain.LoginLog;

/**
 * 
 * @author Gavin
 * @2017年6月9日
 */


@Repository
public class LoginLogDao extends BaseDao<LoginLog>{
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}
