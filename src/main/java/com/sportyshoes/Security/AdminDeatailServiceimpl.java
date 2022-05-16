package com.sportyshoes.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sportyshoes.entity.User;
import com.sportyshoes.repository.UserRepo;

public class AdminDeatailServiceimpl implements UserDetailsService {

	@Autowired
	private UserRepo userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userrepo.getUserByEmail(email);
		if(user == null)
		{
			throw new UsernameNotFoundException("User not found, Please Register");
		}
		return new MyAdminDetails(user);
	}

}
