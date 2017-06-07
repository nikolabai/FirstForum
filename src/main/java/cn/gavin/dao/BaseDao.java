package cn.gavin.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;


/**
 * 
 * @author Gavin
 * @2017年3月22日
 */

//DAO基类，其他DAO可以直接继承这个DAO，不但可以复用共用的方法，还可以获得泛型的好处
public class BaseDao<T> {
	private Class<T> entityClass;
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//根据ID加载PO实例
	public T load(Serializable id ) {
		Session session = sessionFactory.openSession();
		T entity = session.load(entityClass, id);
		session.flush();
		session.close();
		return entity;
	}
	//根据ID获取PO实例
	public T get(Serializable id) {
		Session session = sessionFactory.openSession();
		T entity = session.get(entityClass, id);
		session.flush();
		session.close();
		return entity;
	}
	//获取po的所有对象
//	public T loadAll() {
//		Session session = sessionFactory.openSession();
//		T entity = session.loadAll(entityClass);
//		session.flush();
//		session.close();
//		return entity;
//	}
	//保存po
	public void save (T entity ) {
		Session session = sessionFactory.openSession();
		session.save(entity);
		session.flush();
		session.close();
		
	}
	/**
	 * 删除po
	 * @param entity
	 */
	public void remove (T entity) {
		Session session = sessionFactory.openSession();
		session.delete(entity);
		session.flush();
		session.close();
	}
	/**
	 * 更新po
	 * @param entity
	 */
	public void update (T entity) {
		Session session = sessionFactory.openSession();
		session.update(entity);
		session.flush();
		session.close();
	}
	/**
	 * 执行HQL查询
	 * @param hql
	 * @return
	 */
	public List find(String hql) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		List list = query.getResultList();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	/**
	 * 执行带参的HQL查询
	 * @param hql
	 * @param params
	 * @return
	 */
//	public List find(String hql,Object params) {
//		
//		return hibernateTemplate.find(hql,params);
//	}
	/**
	 * 对延迟加载的实体po执行初始化
	 * @param entity
	 */
//	public void initializae(Object entity ) {
//		Session session = sessionFactory.openSession();
//		session.
//		
//		hibernateTemplate.initialize(entity);
//	}
	
	/*********************************HQL*************************************/
	//分页查询
	public List<?> queryForPage(String hql,int pageNo,int pageSize) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
        List list = session.createQuery(hql)
                        .setFirstResult(pageNo)
                        .setMaxResults(pageSize)
                        .getResultList();                   
                return list;
	}
//    总记录条数
	public int getCount(String hql) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		int count = ((Long) query.iterate().next()).intValue();
		return count; 
	}
				 
		
	
}
