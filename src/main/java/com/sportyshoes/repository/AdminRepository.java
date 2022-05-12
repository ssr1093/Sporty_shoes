package com.sportyshoes.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sportyshoes.entity.Admin;


public interface AdminRepository extends CrudRepository<Admin, Long> {
		
	@Query("SELECT u from Admin u where u.email = :email")
	public Admin getAdminByEmail(@Param("email") String email);
}
