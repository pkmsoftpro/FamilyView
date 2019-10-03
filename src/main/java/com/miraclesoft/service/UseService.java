package com.miraclesoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraclesoft.entity.User;
import com.miraclesoft.repository.UseRepository;

@Service
@Transactional
public class UseService {

	@Autowired
	UseRepository useRepository;

	public User findByUsername(String username) {
		return this.useRepository.findByUsername(username);
	}
	
	public User save(User user) {
		return this.useRepository.save(user);
	}
}
