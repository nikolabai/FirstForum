package cn.gavin.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
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
	private HibernateTemplate ht;
	
	
//	public Session getSession();
	
	
	//根据ID加载PO实例
	public T load(Serializable id ) {
		return (T)ht.load(entityClass,id);
	}
	//根据ID获取PO实例
	public T get(Serializable id) {
		 return (T)ht.get(entityClass,id);
	}
	//获取po的所有对象
	public T loadAll() {
		return (T)ht.loadAll(entityClass);
	}
	//保存po
	public void save (T entity ) {
		ht.save(entity);
	}
	/**
	 * 删除po
	 * @param entity
	 */
	public void remove (T entity) {
		ht.delete(entity);
	}
	/**
	 * 更新po
	 * @param entity
	 */
	public void update (T entity) {
		ht.update(entity);
	}
	/**
	 * 执行HQL查询
	 * @param hql
	 * @return
	 */
	public List find(String hql) {
		return ht.find(hql);
	}
	/**
	 * 执行带参的HQL查询
	 * @param hql
	 * @param params
	 * @return
	 */
	public List find(String hql,Object params) {
		return ht.find(hql,params);
	}
	/**
	 * 对延迟加载的实体po执行初始化
	 * @param entity
	 */
	public void initializae(Object entity ) {
		ht.initialize(entity);
	}
	
	/*********************************HQL*************************************/
	//分页查询
	public List<?> queryForPage(String hql,int pageNo,int pageSize) {
		List list =(List) ht.execute(new HibernateCallback<Object>(){
            public Object doInHibernate(Session session){
            	List list2 = session.createQuery(hql)
                        .setFirstResult(pageNo)
                        .setMaxResults(pageSize)
                        .getResultList();                   
                return list2;
            }
		});
        return list;
	}
//    总记录条数
	public int getCount(String hql) {
//		List list =(List) ht.execute(new HibernateCallback(){
//            public Object doInHibernate(Session session){
//            	List list3 = session.createQuery(hql).getResultList();
//            	
//            }
//		});
//		return Integer.parseInt(list3.get(0).toString());;
		return ((Integer)ht.iterate(hql).next()).intValue(); 
	}
				 
		
	
}
