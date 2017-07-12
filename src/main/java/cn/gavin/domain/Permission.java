package cn.gavin.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_permission")
public class Permission implements Serializable{

    private static final long serialVersionUID = -8792590494605747957L;
    
    
    private Long permissionId;
    @Column(length=50)
    private String name;
    @Column(length=100)
    private String description;
    @Column(length=50)
    private String permission;
    private Set<Role> roles;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="permissionId")
	public Long getId() {
		return permissionId;
	}


	public void setId(Long permissionid) {
		this.permissionId = permissionid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPermission() {
		return permission;
	}


	public void setPermission(String permission) {
		this.permission = permission;
	}

	@OneToMany(mappedBy="permissions", cascade = CascadeType.ALL)
	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}




	@Override
	public String toString() {
		return "Permission [id=" + permissionId + ", name=" + name + ", description=" + description + ", permission=" + permission
				+ ", roles=" + roles + "]";
	}

    
    
}
