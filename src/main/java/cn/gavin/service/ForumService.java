package cn.gavin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gavin.dao.BoardDao;
import cn.gavin.dao.PostDao;
import cn.gavin.dao.TopicDao;
import cn.gavin.dao.UserDao;
import cn.gavin.domain.Board;
import cn.gavin.domain.Post;
import cn.gavin.domain.Topic;
import cn.gavin.domain.User;

/**
 * 
 * @author Gavin
 * @2017年5月30日
 */
@Service
public class ForumService {
	@Autowired
	private TopicDao topicDao;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private PostDao postDao;
	@Autowired
	private UserDao userDao;
	
	
	//1.发表一个主题帖子，用户积分加10，论坛版块的主题帖数加1
	public void addTopic(Topic topic){
		Board board = boardDao.get(topic.getBoard().getBoardId());
		board.setTopicNum(board.getTopicNum()+1);
		
		topicDao.save(topic);
		//更新用户积分+10
		User user =topic.getUser();
		user.setCredit(user.getCredit()+10);
		userDao.update(user);
		
	}
	//2.删除一个主题帖子，用户积分减少50，论坛版块主题帖数减1
	//删除主题帖所有关联的帖子
	public void removeTopic(int topicId){
		Topic topic = topicDao.get(topicId);
		
		//将论坛版块的主题帖数减1
		Board board = boardDao.get(topic.getBoard().getBoardId());
		board.setTopicNum(board.getTopicNum()-1);
		//发表该主题帖用户扣除50积分
		User user=topic.getUser();
		user.setCredit(user.getCredit()-50);
		//删除主题帖及其相关的帖子
		topicDao.remove(topic);
		postDao.deleteTopicPosts(topicId);
		
	}
	//3.添加一个回复帖子，用户积分加5，主题帖子回复数加1，并更新最后回复时间
	public void addPost(Post post){
		postDao.save(post);
		User user = post.getUser();
		user.setCredit(user.getCredit()+5);
		userDao.update(user);
		//自己修改
		Topic topic=topicDao.get(post.getTopic().getTopicId());
		topic.setReplies(topic.getReplies()+1);
		topic.setLastPost(new Date());
		
		//topic处于hibernate受管状态，无需显示更新
		//topicDao.update(topic);
	}
	//4.删除一个回复的帖子，发表回复帖子的用户积分减20，主题帖的回复数-1
	public void removePost(int postId){
		Post post=postDao.get(postId);
		postDao.remove(post);
		
		//主题帖回复数-1
		Topic topic=topicDao.get(post.getTopic().getTopicId());
		topic.setReplies(topic.getReplies()-1);
		//
		User user = post.getUser();
		user.setCredit(user.getCredit()-20);
	}
	//5.创建一个新的论坛版块
	public void addBoard(Board board){
		boardDao.save(board);
	}
	
	//6.删除一个版块
	public void removeBoard(int boardId){
		Board board=boardDao.get(boardId);
		boardDao.remove(board);
	}
	//7.将帖子置为精华主题帖，digest精华级别可选只为1、2、3
	public void makeDigestTopic(int topicId){
		Topic topic = topicDao.get(topicId);
		topic.setDigest(1);
		//
		User user = topic.getUser();
		user.setCredit(user.getCredit()+100);
	}
	//8.获取论坛版块某一页主题，以最后回复时间降序排列
	public List getPagedTopic(int boardId,int pageNo,int pageSize){
		return topicDao.getPagedTopic(boardId, pageNo, pageSize);
	}
	//9.获取同主题每一页帖子，以最后回复时间降序排列
	public List<Post> getPagedPosts(int topicId,int pageNo,int pageSize){
		return postDao.getPagePosts(topicId,pageNo,pageSize);
	}
	//10.将用户设为论坛版块的管理员
//	public void addBoardManager(int boardId ,String userName){
//		User user = userDao.getUserByUserName(userName);
//		if(user==null){
//			throw new RuntimeException("用户名为"+userName+"用户不存在");
//		}else {
//			Board board =boardDao.get(boardId);
//			user.getManBoard().add(board);
//			userDao.update(user);
//		}
//	}

}
