package cn.gavin.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用户角色表
 * @author Gavin
 * @2017年7月11日
 */
@Entity
@Table(name="t_user_role")
public class UserRole {
	private int id;
	private Set<User> users;
	private Set<Role> roles;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId", unique=true)
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="roleId", unique=true)
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	

}
