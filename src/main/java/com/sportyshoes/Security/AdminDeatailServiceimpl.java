package com.sportyshoes.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sportyshoes.entity.Admin;
import com.sportyshoes.repository.AdminRepository;

public class AdminDeatailServiceimpl implements UserDetailsService {

	@Autowired
	private AdminRepository adminrepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Admin admin = adminrepository.getAdminByEmail(email);
		if(admin == null)
		{
			throw new UsernameNotFoundException("User not found, Please Register");
		}
		return new MyAdminDetails(admin);
	}

}
