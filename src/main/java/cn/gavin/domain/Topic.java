package cn.gavin.domain;
/**
 * 
 * @author Gavin
 * @2017年3月27日
 */
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@javax.persistence.Entity
@Cache(usage= CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_login_log")
public class Topic extends BaseDomain{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int topicId;
	private String toplicTitle;
	private Date creatTime;
	private Date lastPost;
	private int views;
	private int replies;
	private int digest;
	private User user;
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getToplicTitle() {
		return toplicTitle;
	}
	public void setToplicTitle(String toplicTitle) {
		this.toplicTitle = toplicTitle;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
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
	

}
