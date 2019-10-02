package com.miraclesoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraclesoft.entity.UserDetail;
import com.miraclesoft.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
    UserRepository userRepository;

    public List<UserDetail> getAllUsers() {
        return this.userRepository.findAll();
    }

    public UserDetail addUser(UserDetail user) {
        return this.userRepository.save(user);
    }
    
    public UserDetail getUserWithId(Integer id) {
    	return this.userRepository.getUserWithId(id);
    }
    
    public List<UserDetail> findAll() {
    	return this.userRepository.findAll();
    }
}
