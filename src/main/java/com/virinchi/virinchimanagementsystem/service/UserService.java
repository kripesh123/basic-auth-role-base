package com.virinchi.virinchimanagementsystem.service;

import com.virinchi.virinchimanagementsystem.model.User;

public interface UserService {
	
	public User findUserByEmail(String email);
	public User findUserByName(String name);
	public void saveUser(User user);
	long count();

}
