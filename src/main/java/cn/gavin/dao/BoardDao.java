package cn.gavin.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cn.gavin.domain.Board;
import cn.gavin.domain.User;

/**
 * 
 * @author lenin
 * @2017年5月28日
 */
@Repository
public class BoardDao extends BaseDao<Board>{
	protected final String GET_BOARD_NUM="select count(f.boardld)from Board f";
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//	获取论坛版块数目的方法
	public long getBoardNum(){
		Session session = sessionFactory.openSession();
//		Iterator iterator =session.iterate(GET_BOARD_NUM );
		return ((Long)(session.createQuery(GET_BOARD_NUM).iterate().next())).intValue();
	}
//	
	public List<Board> loadAll() {
		String hql="from Board b order by b.boardName desc";
		Query query=getSession().createQuery(hql);  
        List<Board> boardList=query.list();  
        return boardList;  
	}
}
