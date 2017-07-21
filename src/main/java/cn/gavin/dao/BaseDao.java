package cn.gavin.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.gavin.domain.Topic;



/**
 * 
 * @author Gavin
 * @2017年3月22日
 */

//DAO基类，其他DAO可以直接继承这个DAO，不但可以复用共用的方法，还可以获得泛型的好处
public class BaseDao<T> {
	private Class<T> entityClass;
	//反射
	@SuppressWarnings("unchecked")
	public BaseDao() {  
        Type type = getClass().getGenericSuperclass();  
        if (type instanceof ParameterizedType) {  
            this.entityClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];  
        } else {  
            this.entityClass = null;  
        }  
    }  
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	//根据ID加载PO实例
	public T load(Serializable id ) {
		Session session = sessionFactory.getCurrentSession();
		T entity = (T) session.load(entityClass, id);
//		session.flush();
//		session.close();
		return entity;
	}
	//根据ID获取PO实例
	@Transactional
	public T get(Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		T entity = (T) session.get(entityClass, id);
		return entity;
	}
	//保存po
	@Transactional
	public void save (T entity ) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
	}
	/**
	 * 删除po
	 * @param entity
	 */
	@Transactional
	public void remove (T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
	}
	/**
	 * 更新po
	 * @param entity
	 */
	@Transactional
	public void update (T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}
	/**
	 * 执行HQL查询
	 * @param hql
	 * @return
	 */
	@Transactional
	public List find(String hql) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List list = query.list();
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
	/**
	 * 分页查询函数，使用hql.
	 *
	 * @param pageNo 页号,从1开始.
	 */
	public Page queryForPage(String hql, int pageNo, int pageSize ,Object value) {
		Assert.hasText(hql);
		Assert.isTrue(pageNo >= 1, "pageNo should start from 1");
		// Count查询
		String countQueryString = " select count (*) " + removeSelect(removeOrders(hql));
		Query query2 = getSession().createQuery(countQueryString);
		List countlist = query2.setParameter(0, value).list();
		long totalCount = (Long) countlist.get(0);
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		
		
		Query query = getSession().createQuery(hql);
		List list = query.setFirstResult(startIndex)
						.setMaxResults(pageSize)
						.setParameter(0, value)
						.list();
		// Count查询
//		long totalCount =  ((Long)( query.setParameter(0, value).iterate().next())).intValue();
//
//		if (totalCount < 1){
//			return new Page();
//		}

		return new Page(startIndex, totalCount, pageSize, list);
	}

    //总记录条数
	@Transactional
	public int getCount(String hql) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		int count = ( (Long) query.iterate().next()).intValue();
		return count; 
	}
	/**
	 * 去除hql的select 子句，未考虑union的情况,用于pagedQuery.
	 *
	 * @see #pagedQuery(String,int,int,Object[])
	 */
	private static String removeSelect(String hql) {
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, " hql : " + hql + " must has a keyword 'from'");
		return hql.substring(beginPos);
	}
	/**
	 * 去除hql的orderby 子句，用于pagedQuery.
	 *
	 * @see #pagedQuery(String,int,int,Object[])
	 */
	private static String removeOrders(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
				
	
	
}
