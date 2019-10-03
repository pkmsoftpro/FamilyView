package com.miraclesoft.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.miraclesoft.entity.User;
import com.miraclesoft.service.UseService;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	UseService useService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User userFromDB = useService.findByUsername(username);
		
		UserBuilder builder = null;
		if (userFromDB != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(new BCryptPasswordEncoder().encode(userFromDB.getPassword()));
			System.out.println("Roles are:"+userFromDB.getRole());							
			builder.roles(userFromDB.getRole());
		} else {
			throw new UsernameNotFoundException("User not found.");
		}

		return builder.build();
	}

}

