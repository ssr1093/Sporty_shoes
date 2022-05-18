package com.sportyshoes.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sportyshoes.dto.Registrationdto;
import com.sportyshoes.entity.Role;
import com.sportyshoes.entity.User;
import com.sportyshoes.repository.UserRepo;
import com.sportyshoes.service.Userservice;

@Service
public class Userserviceimpl implements Userservice {

	private UserRepo userrepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	 public Userserviceimpl(UserRepo userrepo) {
	        super();
	        this.userrepo = userrepo;
	    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userrepo.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found, try again");
					}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),mapRolesToAuthorities(user.getRoles())) ;
	}
	@Override
	public User save(Registrationdto registrationDto) {
		User user = new User(registrationDto.getFirstName(),
				registrationDto.getLastName(),registrationDto.getEmail()
				,passwordEncoder.encode(registrationDto.getPassword()),Arrays.asList(new Role("USER")));
		return userrepo.save(user);
	}
	

	private Collection <? extends GrantedAuthority > mapRolesToAuthorities(Collection <Role> roles) {

		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

	}

}
