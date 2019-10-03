package com.miraclesoft.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	 public UserDetails loadUserByUsername(String userName) {
		 
		 return userServiceImpl.loadUserByUsername(userName);

	 }

}