package cn.gavin.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * 
 * @author Gavin
 * @2017年3月22日
 */

//DAO基类，其他DAO可以直接继承这个DAO，不但可以复用共用的方法，还可以获得泛型的好处
public interface BaseDao<T> {
	
	
	public Session getSession();
	
	/**
	 * 根据ID加载po实例
	 * @param id
	 * @return
	 */
	public T load(Serializable id );
	//根据ID获取PO实例
	public T get(Serializable id);
	//获取po的所有对象
	public T loadAll(Serializable id);
	//保存po
	public void save (T entity );
	/**
	 * 删除po
	 * @param entity
	 */
	public void remove (T entity);
	/**
	 * 更新po
	 * @param entity
	 */
	public void undate (T entity);
	/**
	 * 执行HQL查询
	 * @param hql
	 * @return
	 */
	public List find(String hql);
	/**
	 * 执行带参的HQL查询
	 * @param hql
	 * @param params
	 * @return
	 */
	public List find(String hql,Object params);
	/**
	 * 对延迟加载的实体po执行初始化
	 * @param entity
	 */
	public void initializae(Object entity );
	
	/*********************************HQL*************************************/
	
}
