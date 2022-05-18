package com.sportyshoes.entity;

import java.util.HashSet;
import java.util.List;
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
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {


	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long custid;
	private String first_name;
	private String last_name;
	@Column(unique = true)
	
	private String email;
	@Column(nullable = false)
	private String password;
	@ColumnDefault(value = "enabled") 
	private boolean enabled;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name ="customerroles", joinColumns = {@JoinColumn(name = "custid")},
			inverseJoinColumns = {@JoinColumn(name = "roleid")})
	private Set<Role> roles = new HashSet<>();

	
	
	public User(String string, String string2, String string3, String string4, List<Role> list) {
	}

	public User(long custid, String first_name, String last_name, String email, String password, boolean enabled,
			Set<Role> roles) {
		super();
		this.custid = custid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}

	public long getCustid() {
		return custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
