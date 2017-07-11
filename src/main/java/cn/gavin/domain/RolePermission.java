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
	private Set<Role> roles;
	private Set<Permission> permissions;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="roleId", unique=true)
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="permissionId", unique=true)
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
}
