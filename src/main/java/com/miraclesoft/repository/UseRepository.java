package com.miraclesoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.miraclesoft.entity.User;

@Transactional(readOnly = true)
public interface UseRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
}