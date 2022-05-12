package com.sportyshoes.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sportyshoes.entity.Admin;
import com.sportyshoes.entity.Role;


public class MyAdminDetails implements UserDetails{
	private Admin admin;
	public MyAdminDetails(Admin admin) {
		this.admin=admin;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles =admin.getRoles();
	List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for(Role role:roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return admin.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return admin.isEnabled();
	}

}
