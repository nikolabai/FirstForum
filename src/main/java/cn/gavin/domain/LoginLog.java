package cn.gavin.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * @author Gavin   登陆日志
 * @2017年3月27日
 */
@javax.persistence.Entity
@Cache(usage= CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_login_log")
public class LoginLog implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int loginLogId;
	private String ip;
	private Date loginDate;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getLoginLogId() {
		return loginLogId;
	}
	public void setLoginLogId(int loginLogId) {
		this.loginLogId = loginLogId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date date) {
		this.loginDate = date;
	}
	@Override
	public String toString() {
		return "LoginLog [loginLogId=" + loginLogId + ", ip=" + ip + ", loginDate=" + loginDate + ", user=" + user
				+ "]";
	}
	

}
