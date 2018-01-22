package com.virinchi.virinchimanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virinchi.virinchimanagementsystem.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	 User findByEmail(String email);
	 User findByName(String name);
	 long count();
	
}
