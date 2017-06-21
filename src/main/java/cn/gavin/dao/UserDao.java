package cn.gavin.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.gavin.domain.User;
@Repository
public class UserDao extends BaseDao<User>{
	@Autowired
	private SessionFactory sessionFactory;  
	public void setSessionFactory(SessionFactory sessionFactory) {   
		this.sessionFactory = sessionFactory;   
	}     
	public Session getSession() {    
		return sessionFactory.getCurrentSession();   
	}  
	
	
	public User getUserByUserName(String userName) {
	   String hql="from User u where u.userName=:userName";
	   Query query=getSession().createQuery(hql);  
       query.setParameter("userName",userName);  
       List userList=query.list();  
       if(userList.size()<1){  
              return null;  
       }  
       User user=(User)userList.get(0);  
       return user;  
          
	}
	public List<User> queryUserByUserName(String userName) {
		String hql="from User u where u.userName=:userName";
		Query query=getSession().createQuery(hql);  
        query.setParameter("userName",userName);  
        List userList=query.list();  
        return userList;  
	}

}
