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
public class LoginLog extends BaseDomain{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int loginLogId;
	private String ip;
	private Date loginDate;
	private User user;
	
	
	
	
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
