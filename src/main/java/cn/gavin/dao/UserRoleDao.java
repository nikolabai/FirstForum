package cn.gavin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.gavin.domain.UserRole;

public class UserRoleDao extends BaseDao<UserRole>{
	@Autowired
	private SessionFactory sessionFactory;  
	public void setSessionFactory(SessionFactory sessionFactory) {   
		this.sessionFactory = sessionFactory;   
	}     
	public Session getSession() {    
		return sessionFactory.getCurrentSession();   
	}  
	

}
