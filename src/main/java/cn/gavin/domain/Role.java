package cn.gavin.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Basic;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_role")
public class Role implements Serializable{

    private static final long serialVersionUID = 6177417450707400228L;
    
    
    private Long id;
    @Column(length=50)																												
    private String name;
    @Column(length=50)
    private String description;
    
    
    private Set<User> users;
    
    
    private Set<Permission> permissions;
    
    
    
    public Role(){
    	
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="roleId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	@OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", users=" + users
				+ ", permissions=" + permissions + "]";
	}
    
    
    
}