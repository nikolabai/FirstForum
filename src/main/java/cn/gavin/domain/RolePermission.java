package cn.gavin.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 角色权限表
 * @author Gavin
 * @2017年7月11日
 */
@Entity
@Table(name="t_role_permission")
public class RolePermission {
	private int id;
	private Role role;
	private Permission permission;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="roleId", unique=true)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="permissionId", unique=true)
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
}
