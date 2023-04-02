package com.study.mystudy.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.mystudy.user.domain.User;

public interface JpaUserRepository extends JpaRepository<User, Long> , UserRepository{
	
//	Optional<User> findByName(String name,Long id);
	
}
