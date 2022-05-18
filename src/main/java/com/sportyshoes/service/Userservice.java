package com.sportyshoes.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sportyshoes.dto.Registrationdto;
import com.sportyshoes.entity.User;

public interface Userservice extends UserDetailsService {

	 User save(Registrationdto registrationDto);

}
