package com.spe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spe.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	User findByEmail(String emailId);

	User findByUsername(String username);
	
	boolean existsByEmail(String emailId);
	
	User findById(long id);
}
