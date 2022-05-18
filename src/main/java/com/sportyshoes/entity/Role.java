package com.sportyshoes.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")

public class Role {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long role_id;
	private String name;
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	
	
	public Role(String string) {
		
	}
	public Role(long role_id, String name, List<User> users) {
		super();
		this.role_id = role_id;
		this.name = name;
		this.users = users;
	}
	public long getRole_id() {
		return role_id;
	}
	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
