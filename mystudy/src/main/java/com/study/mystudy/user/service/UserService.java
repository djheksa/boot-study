package com.study.mystudy.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.study.mystudy.user.domain.User;
import com.study.mystudy.user.repository.UserRepository;


@Transactional
public class UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Long join(User user) {
		userRepository.findByName(user.getName()).ifPresent(u -> {
			throw new IllegalStateException("이미 존재하는 이름");
		});
		
		userRepository.save(user);
		
		return user.getId();
	}
	
	public Optional<User> findByName(User user){
		return userRepository.findByName(user.getName());
	}
	
}
