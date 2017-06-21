package cn.gavin.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.gavin.domain.Post;
import cn.gavin.domain.User;
/**
 * 
 * @author Gavin
 * @2017年5月31日
 */
@Repository
public class PostDao extends BaseDao<Post>{
	@Autowired
	private SessionFactory sessionFactory;  
	public void setSessionFactory(SessionFactory sessionFactory) {   
		this.sessionFactory = sessionFactory;   
	}     
	public Session getSession() {    
		return sessionFactory.getCurrentSession();   
	}  

	public void deleteTopicPosts(int topicId) {
			String hql= "from t_post where topicId=:topicId";
			Query query= getSession().createQuery(hql);
			query.setParameter("topicId", topicId);
			List<Post> postlist =query.list();
			for (Post post : postlist) {
				remove(post);
			}
			
	}
	public List<Post> getPagePosts(int topicId, int pageNo, int pageSize) {
		String hql = "from t_post where topicId=:topicId";
		Query query = getSession().createQuery(hql);
		query.setParameter("topicId", topicId);
		List<Post> postlist =query.list();
		return postlist;
	}
}
