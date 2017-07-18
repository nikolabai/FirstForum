package cn.gavin.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.gavin.domain.Role;
import cn.gavin.domain.User;
import cn.gavin.domain.UserRole;


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
	
	public Set<Role> queryRoleByUser(User user) {
		String hql="from UserRole ur where ur.user=:user";
		Query query=getSession().createQuery(hql);  
        query.setParameter("user",user);  
        @SuppressWarnings("unchecked")
		List<UserRole> list=  query.list(); 
        Set<Role> roles =new HashSet<>();
        for (UserRole userRole : list) {
			roles.add(userRole.getRole());
		}
        
        return roles;  
	}

}