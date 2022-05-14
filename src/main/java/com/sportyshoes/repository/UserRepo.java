package com.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
		
	@Query("SELECT u from user u where u.email = :email")
	public User getUserByEmail(@Param("email") String email);
	
	
	public User findByUserId(int userId);	
}
