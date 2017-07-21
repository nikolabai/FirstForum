package cn.gavin.domain;
import java.io.Serializable;
/**
 * 
 * @author Gavin
 * @2017年3月27日
 */
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * 主题帖子
 * @author Gavin
 * @2017年6月16日
 */
@javax.persistence.Entity
@Cache(usage= CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_topic")
public class Topic implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int topicId;
	@ManyToOne
	@JoinColumn(name="board_id")
	private Board board;
	private String topicTitle;
	private Date createTime;
	private Date lastPost;
	private int views;
	private int replies;
	private int digest;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	//addbygavin
	private String topicText;
	
	
	
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTopicTitle() {
		return topicTitle;
	}
	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date creatTime) {
		this.createTime = creatTime;
	}
	public Date getLastPost() {
		return lastPost;
	}
	public void setLastPost(Date lastPost) {
		this.lastPost = lastPost;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getReplies() {
		return replies;
	}
	public void setReplies(int replies) {
		this.replies = replies;
	}
	public int getDigest() {
		return digest;
	}
	public void setDigest(int digest) {
		this.digest = digest;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTopicText() {
		return topicText;
	}
	public void setTopicText(String topicText) {
		this.topicText = topicText;
	}
	
	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", board=" + board + ", toplicTitle=" + topicTitle + ", creatTime="
				+ createTime + ", lastPost=" + lastPost + ", views=" + views + ", replies=" + replies + ", digest="
				+ digest + ", user=" + user + ", topicText=" + topicText + "]";
	}
	
}
