package cn.gavin.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.gavin.domain.Board;
import cn.gavin.domain.Topic;


/**
 * 
 * @author Gavin
 * @2017年5月28日
 */

@Repository
public class TopicDao extends BaseDao<Topic>{
	@Autowired
	private SessionFactory sessionFactory;  
	public void setSessionFactory(SessionFactory sessionFactory) {   
		this.sessionFactory = sessionFactory;   
	}     
	public Session getSession() {    
		return sessionFactory.getCurrentSession();   
	}  
	
	
	private final String GET_BOARD_DIGEST_TOPICS="from Topic t where t.board=? and digest>0 order by t.lastPost desc,digest desc";
	private final String GET_PAGED_TOPICS="from Topic where board=? order by lastPost desc";
	private final String QUERY_TOPIC_BY_TITLE = "from Topic where topic Title like ? order by lastPost desc";
//	获取论坛版块某一页的精华主题帖，按最后回复时间以及精华级别降序排列
//	public List getBoardDigestTopics(int boardId,int pageNo,int pageSize){
//		return queryForPage(GET_BOARD_DIGEST_TOPICS,pageNo,pageSize);
//	}
	//获取论坛版块某一页的主题帖子
//	public List getPagedTopic(int boardId,int pageNo,int pageSize){
//		return queryForPage(GET_BOARD_DIGEST_TOPICS,pageNo,pageSize);
//	}
//	获取和主题帖标题模糊匹配的主题帖（某一页的数据）
//	public List queryTopicByTitle(String title,int pageNo,int pageSize){
//		return queryForPage(GET_BOARD_DIGEST_TOPICS,pageNo,pageSize);
//	}
	/**
	 * 获取论坛版块分页的主题帖子
	 * @param boardId 论坛版块ID
	 * @param pageNo 页号，从1开始。
	 * @param pageSize 每页的记录数
	 * @return 包含分页信息的Page对象
	 */
	public Page getPagedTopics(int pageNo,int pageSize,Board board) {
		return queryForPage(GET_PAGED_TOPICS,pageNo,pageSize,board);
	}
	
}
