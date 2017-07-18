package cn.gavin.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * @author Gavin
 * @2017年3月27日
 */
@javax.persistence.Entity
@Cache(usage= CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_user")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String userName;
	private String password;
	private long userType;
	private long locked;
	private int credit;
	private Date lastVisit;
	private String lastIp;
	
	private Set<Role> roles ;
	
	
	
	public  User() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getUserType() {
		return userType;
	}
	public void setUserType(long userType) {
		this.userType = userType;
	}
	public long getLocked() {
		return locked;
	}
	public void setLocked(long locked) {
		this.locked = locked;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public Date getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [userid=" + userId + ", userName=" + userName + ", password=" + password + ", userType=" + userType
				+ ", locked=" + locked + ", credit=" + credit + ", lastVisit=" + lastVisit + ", lastIp=" + lastIp
				+ ", roles=" + roles + "]";
	}
	
	
	
	

}
